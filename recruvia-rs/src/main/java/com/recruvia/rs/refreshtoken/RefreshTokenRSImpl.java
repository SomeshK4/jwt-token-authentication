package com.recruvia.rs.refreshtoken;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.recruvia.model.user.User;
import com.recruvia.security.configuration.SecurityConfiguration;
import com.recruvia.security.exceptions.InvalidJwtToken;
import com.recruvia.security.jwt.JwtSettings;
import com.recruvia.security.jwt.JwtTokenFactory;
import com.recruvia.security.jwt.RawAccessJwtToken;
import com.recruvia.security.jwt.TokenExtractor;
import com.recruvia.security.jwt.TokenVerifier;
import com.recruvia.security.model.Authority;
import com.recruvia.security.model.JwtToken;
import com.recruvia.security.model.RefreshToken;
import com.recruvia.security.model.UserContext;
import com.recruvia.service.user.UserService;

/**
 * 
 * @author someshkumar
 *
 */
@Component
public class RefreshTokenRSImpl implements RefreshTokenRS{
	@Autowired
	private JwtTokenFactory tokenFactory;
	@Autowired
	private JwtSettings jwtSettings;
	@Autowired
	private UserService userService;
	@Autowired
	private TokenVerifier tokenVerifier;
	@Autowired
	@Qualifier("jwtHeaderTokenExtractor")
	private TokenExtractor tokenExtractor;

	
	public JwtToken refreshToken(@Context HttpServletRequest request)
			throws IOException, ServletException {
		String tokenPayload = tokenExtractor.extract(request.getHeader(SecurityConfiguration.AUTHENTICATION_HEADER_NAME));

		RawAccessJwtToken rawToken = new RawAccessJwtToken(tokenPayload);
		RefreshToken refreshToken = RefreshToken.create(rawToken, jwtSettings.getTokenSigningKey())
				.orElseThrow(() -> new InvalidJwtToken("Invalid Jwt token"));

		String jti = refreshToken.getJti();
		if (!tokenVerifier.verify(jti)) {
			throw new InvalidJwtToken("Invalid Jwt token");
		}

		String subject = refreshToken.getSubject();
		User user = userService.getUserByEmail(subject)
				.orElseThrow(() -> new UsernameNotFoundException("User not found: " + subject));

		List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(Authority.ADMIN.toString()));

		UserContext userContext = UserContext.create(user.getEmail(), authorities);

		return tokenFactory.createAccessJwtToken(userContext);
	}
}
