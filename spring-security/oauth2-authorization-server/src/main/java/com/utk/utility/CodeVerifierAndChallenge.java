package com.utk.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class CodeVerifierAndChallenge {

	public static void main(String[] args) {
		SecureRandom secureRandom = new SecureRandom();
		byte[] code = new byte[32];
		secureRandom.nextBytes(code);
		String codeVerifier = Base64.getUrlEncoder().withoutPadding().encodeToString(code);

		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] digested = messageDigest.digest(codeVerifier.getBytes());
		String codeChallenge = Base64.getUrlEncoder().withoutPadding().encodeToString(digested);

		System.out.println("Code verifier: " + codeVerifier + " Challenge : " + codeChallenge);
	}

}
