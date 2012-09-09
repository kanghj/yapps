package com.vouov.yapps.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;

/**
 * User: yuminglong
 * Date: 12-2-21
 * Time: 上午12:21
 */
public class AESUtils {
    /**
     * AES 加解密
     * @param mode
     * @param password
     * @param textBytes
     * @return
     * @throws Exception
     */
    public static byte[] aes(int mode, String password, byte[] textBytes) throws Exception{
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        //for windows and linux, the secure random need select a algorithm
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(password.getBytes("utf-8"));
        keyGenerator.init(128, secureRandom);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] encoded = secretKey.getEncoded();
        SecretKeySpec secretKeySpec = new SecretKeySpec(encoded, "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(mode, secretKeySpec);// 初始化
        return cipher.doFinal(textBytes);
    }

    /**
     * AES 加密
     * @param password
     * @param plainText
     * @return
     * @throws Exception
     */
    public static  String encrypt(String password, String plainText) throws Exception {
        byte[] bytes =  aes(Cipher.ENCRYPT_MODE, password, plainText.getBytes("utf-8"));
        return URLEncoder.encode(new String(Base64.encodeBase64(bytes), "utf-8"), "utf-8");
    }

    /**
     * AES 解密
     * @param password
     * @param cipherText
     * @return
     * @throws Exception
     */
    public static String decrypt(String password, String cipherText)throws Exception{
        byte[] cipherBytes = Base64.decodeBase64(URLDecoder.decode(cipherText,"utf-8").getBytes("utf-8"));
        byte[] bytes = aes(Cipher.DECRYPT_MODE, password, cipherBytes);
        return new String(bytes, "utf-8");
    }
}
