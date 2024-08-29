package com.BrightChamps.Utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtils {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    // Generate a secret key
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128); // AES-128
        return keyGen.generateKey();
    }

    // Encrypt data
    public static String encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Decrypt data
    public static String decrypt(String encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    // Generate a key from a byte array (use the same key for encryption and decryption)
    public static SecretKey getKeyFromBytes(byte[] encryptedPassword) {
        if (encryptedPassword.length != 16) { // Ensure key length is correct
            throw new IllegalArgumentException("Invalid key length: " + encryptedPassword.length);
        }
        return new SecretKeySpec(encryptedPassword, ALGORITHM);
    }
    public static SecretKey getKeyFromEnv() {
        String keyString = System.getenv("ENCRYPTION_KEY");
        if (keyString == null || keyString.length() != 16) { // Ensure key length is correct
            throw new IllegalStateException("Encryption key not set or incorrect length");
        }
        return getKeyFromBytes(keyString.getBytes());
    }
