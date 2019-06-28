package koboldblogweb.koboldblogweb.filters;

import io.jsonwebtoken.ExpiredJwtException;
import koboldblogweb.koboldblogweb.service.JwtUserDetailsService;
import koboldblogweb.koboldblogweb.utils.AuthManager;
import koboldblogweb.koboldblogweb.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	private final String STRING_EMPTY = "";

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private AuthManager authManager;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		//从请求头获取token
		final String requestTokenHeader = request.getHeader("Authorization");

		String jwtToken = STRING_EMPTY;
		String username = STRING_EMPTY;
		if (!StringUtils.isEmpty(requestTokenHeader) && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		} else {
			logger.warn("JWT Token does not begin with Bearer String");
		}

		if(!StringUtils.isEmpty(username)&& SecurityContextHolder.getContext().getAuthentication()==null){
			UserDetails userDetails=this.jwtUserDetailsService.loadUserByUsername(username);

			if(jwtTokenUtil.validateToken(jwtToken,userDetails)){
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
			checkAuth(request,userDetails);

		}
		filterChain.doFilter(request,response);
	}

	private void checkAuth(HttpServletRequest request, UserDetails userDetails) {
		String controllerName=request.getServletPath();
//		if(controllerName.contains("/api/")){
//			controllerName=controllerName.replace("/api/","");
//		}
		System.out.println(authManager.getAuthCode(controllerName)+userDetails);
	}
}
