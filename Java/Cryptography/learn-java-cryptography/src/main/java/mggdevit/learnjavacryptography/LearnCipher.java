package mggdevit.learnjavacryptography;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

//import mggdevit.learnjavacollection.LearnJavaCollection;

public class LearnCipher {

	public LearnCipher() {

	}

	public static void learn() {
		System.out.println("");
		System.out.println("Learning Cipher");
		System.out.println("");
		String s0 = "Java Cryptography";
		System.out.println(s0);
		// SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
		String s = encrypt(s0);
		if (s != null) {
			System.out.println(s);
			String s2 = decrypt(s);
			if (s2 != null) {
				System.out.println(s2);
			}
		}
	}

	private static String encrypt(String sContent) {
		byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		IvParameterSpec ivspec = new IvParameterSpec(iv);
		String sKey = "aesEncryptionKey";
		try {
			SecretKeySpec skeySpec = new SecretKeySpec(sKey.getBytes("UTF-8"), "AES");
//			SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivspec);
//			byte[] iv = cipher.sgetIV();
			return (Base64.getEncoder().encodeToString(cipher.doFinal(sContent.getBytes("UTF-8"))));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
		return (null);
	}

	private static String decrypt(String sContent) {
		byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		IvParameterSpec ivspec = new IvParameterSpec(iv);
		byte[] b = Base64.getDecoder().decode(sContent);
		String sKey = "aesEncryptionKey";
		try {
			SecretKeySpec skeySpec = new SecretKeySpec(sKey.getBytes("UTF-8"), "AES");
//			SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivspec);
//			byte[] iv = cipher.getIV();
			return (new String(cipher.doFinal(b), "UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
		return (null);
	}

}
