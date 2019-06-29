package koboldblogweb.koboldblogweb.utils;

import dto.dtos.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
@Component
public class JwtTokenUtil implements Serializable {
	public static final long JWT_TOKEN_VALIDITY=5*60*60;

	private SecretKey key =getKey();// Keys.secretKeyFor(SignatureAlgorithm.HS512);

	private SecretKey getKey(){
		byte[] bytes="koboldwebblogkeykoboldwebblogkeykoboldwebblogkey".getBytes();
		SecretKey key=Keys.hmacShaKeyFor(bytes);
		return key;
	}

	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token,Claims::getSubject);
	}

	//retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public String getUserIdFromToken(String token){
		return getClaimFromToken(token,Claims::getId);
	}
	//check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	//generate token for user
	public String generateToken(UserDto userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername(),userDetails.getId());
	}


	private String doGenerateToken(Map<String, Object> claims, String subject,String id) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setId(id).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(key).compact();
	}

	//validate token
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
	}

}
