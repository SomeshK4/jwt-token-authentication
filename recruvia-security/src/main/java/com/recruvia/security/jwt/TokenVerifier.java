package com.recruvia.security.jwt;

/**
 * 
 * @author someshkumar
 *
 */
public interface TokenVerifier {
	public boolean verify(String jti);
}
