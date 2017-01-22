package com.dassmeta.passport.security.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AESUtils {
	private static final Logger logger = LoggerFactory.getLogger(AESUtils.class);
	// private static final String AES = "AES";
	private static SecretKey KEY = null;

	static {
		try {
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			SecureRandom sr = new SecureRandom();
			keygen.init(sr);
			KEY = keygen.generateKey();
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public static String encrypt(String content) {
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(1, KEY);
			byte[] data = content.getBytes();

			byte[] encryptedData = cipher.doFinal(data);
			char[] chars = Hex.encodeHex(encryptedData);
			return new String(chars);
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
		} catch (NoSuchPaddingException e) {
			logger.error(e.getMessage(), e);
		} catch (InvalidKeyException e) {
			logger.error(e.getMessage(), e);
		} catch (IllegalBlockSizeException e) {
			logger.error(e.getMessage(), e);
		} catch (BadPaddingException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public static String decrypt(String content) {
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(2, KEY);
			byte[] data = Hex.decodeHex(content.toCharArray());

			byte[] decryptedData = cipher.doFinal(data);
			return new String(decryptedData);
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
		} catch (NoSuchPaddingException e) {
			logger.error(e.getMessage(), e);
		} catch (InvalidKeyException e) {
			logger.error(e.getMessage(), e);
		} catch (IllegalBlockSizeException e) {
			logger.error(e.getMessage(), e);
		} catch (BadPaddingException e) {
			logger.error(e.getMessage(), e);
		} catch (DecoderException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
}
