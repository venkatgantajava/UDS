package com.ecrops.controller;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class EncryptionController {

	private static final String SECRET_KEY = "1234567890123456"; // 16-byte key for AES

	public String decryptData(String encryptedData) throws Exception {
		System.out.println("Encrypted data: " + encryptedData);
		String decryptedData = decrypt(encryptedData);
		System.out.println("Decrypted data: " + decryptedData);
		return decryptedData;
	}

	private static String decrypt(String encryptedData) throws Exception {
		System.out.println("Decrypting...");
		SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); // Use ECB mode

		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec); System.out.println("cipher---Data");
		byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
		System.out.println("decryptedBytes====>>"+decryptedBytes);
		return new String(decryptedBytes, StandardCharsets.UTF_8);
	}

	
	 public static String encodeToBase64(String input) {
	        byte[] encodedBytes = Base64.getEncoder().encode(input.getBytes());
	        return new String(encodedBytes);
	    }
}
