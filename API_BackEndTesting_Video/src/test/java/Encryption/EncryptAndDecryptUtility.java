package Encryption;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Private Key : Ac03tEam@j!tu_#1
 */

public class EncryptAndDecryptUtility {

	  public String encrypt(String input,String secretKey) throws Exception {
	        SecretKeySpec sks = new SecretKeySpec(secretKey.getBytes(), "AES");
	        IvParameterSpec ips = new IvParameterSpec("4234567890123456".getBytes());
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // ECB mode with padding
	        cipher.init(Cipher.ENCRYPT_MODE, sks,ips);
	        byte[] encrypted = cipher.doFinal(input.getBytes());
	        return Base64.getEncoder().encodeToString(encrypted);
	    }
	  
	  public String decrypt(String input,String secretKey) throws Exception {
	        SecretKeySpec sks = new SecretKeySpec(secretKey.getBytes(), "AES");
	        IvParameterSpec ips = new IvParameterSpec("4234567890123456".getBytes());
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // ECB mode with padding
	        cipher.init(Cipher.DECRYPT_MODE, sks,ips);
	        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(input));
	        return new String(decrypted);
	    }
}
