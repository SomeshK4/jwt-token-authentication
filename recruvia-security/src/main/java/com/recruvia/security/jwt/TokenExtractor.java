package com.recruvia.security.jwt;


/**
 * 
 * @author someshkumar
 *
 */
public interface TokenExtractor {
    public String extract(String payload);
}
