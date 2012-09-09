package com.vouov.yapps.util;

/**
 * User: yuminglong
 * Date: 12-2-21
 * Time: 上午10:38
 */
public class SecUtils {
    /**
     * AES+base64加密文本 + URL encode
     * 支持Cookie V1.0中=等特殊字符问题
     *
     * @param plainText
     * @return
     * @throws Exception
     */
    public static String encryptText(String plainText) throws Exception {
        String aesKey = ConfigUtils.getValue("security.key").trim();
        return AESUtils.encrypt(aesKey, plainText);
    }

    /**
     * AES+base64解密文本
     *
     * @param cipherText
     * @return
     * @throws Exception
     */
    public static String decryptText(String cipherText) throws Exception {
        String aesKey = ConfigUtils.getValue("security.key").trim();
        return AESUtils.decrypt(aesKey, cipherText);
    }
}
