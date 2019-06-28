package koboldblogweb.koboldblogweb.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserUtils {
	@Autowired
	private HttpServletRequest httpServletRequest;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public String getUserId() {
		final String requestTokenHeader = httpServletRequest.getHeader("Authorization");

		String jwtToken = "";
		if (!StringUtils.isEmpty(requestTokenHeader) && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			return jwtTokenUtil.getUserIdFromToken(jwtToken);
		}
		return "";
	}
}
