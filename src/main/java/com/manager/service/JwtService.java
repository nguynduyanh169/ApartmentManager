package com.manager.service;

import java.util.Date;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

@Service
@ComponentScan(basePackages = "com.manager.security")
public class JwtService {

	public static final String EMAIL = "email";
	public static final String SECRET_KEY = "11111111111111111111111111111111";
	public static final int EXPIRE_TIME = 86400000;

	public String generateTokenLogin(String email) {
		String token = null;
		try {
			// Create HMAC signer
			JWSSigner signer = new MACSigner(generateShareSecret());
			JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
			builder.claim(EMAIL, email);
			builder.expirationTime(generateExpirationDate());
			JWTClaimsSet claimsSet = builder.build();
			SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
			// Apply the HMAC protection
			signedJWT.sign(signer);
			// Serialize to compact form, produces something like
			// eyJhbGciOiJIUzI1NiJ9.SGVsbG8sIHdvcmxkIQ.onO9Ihudz3WkiauDO2Uhyuz0Y18UASXlSc1eS0NkWyA
			token = signedJWT.serialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return token;
	}

	private JWTClaimsSet getClaimsFromToken(String token) {
		JWTClaimsSet claims = null;
		try {
			SignedJWT signedJWT = SignedJWT.parse(token);
			JWSVerifier verifier = new MACVerifier(generateShareSecret());
			if (signedJWT.verify(verifier)) {
				claims = signedJWT.getJWTClaimsSet();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return claims;
	}

	private Date generateExpirationDate() {
		return new Date(System.currentTimeMillis() + EXPIRE_TIME);
	}

	private Date getExpirationDateFromToken(String token) {
		Date expiration = null;
		JWTClaimsSet claims = getClaimsFromToken(token);
		expiration = claims.getExpirationTime();
		return expiration;
	}

	public String getEmailFromToken(String token) {
		String email = null;
		try {
			JWTClaimsSet claims = getClaimsFromToken(token);
			email = claims.getStringClaim(EMAIL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return email;
	}

	private byte[] generateShareSecret() {
		// Generate 256-bit (32-byte) shared secret
		byte[] sharedSecret = new byte[32];
		sharedSecret = SECRET_KEY.getBytes();
		return sharedSecret;
	}

	private Boolean isTokenExpired(String token) {
		Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	public Boolean validateTokenLogin(String token) {
		if (token == null || token.trim().length() == 0) {
			return false;
		}
		String email = getEmailFromToken(token);
		if (email == null || email.isEmpty()) {
			return false;
		}
		if (isTokenExpired(token)) {
			return false;
		}
		return true;
	}

}
