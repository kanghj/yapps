package com.vouov.yapps.util;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * User: yuminglong
 * Date: 12-2-14
 * Time: 下午2:31
 */
public class TextUtils {
    public final static String EMAIL_ADDRESS_PATTERN = "\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
    private final static int RANDOM_TEXT_DEFAULT_LEN = 10;

    /**
     * 验证邮箱是否有效
     * @param text
     * @return
     */
    public static boolean isEmail(String text) {
        Pattern pattern = Pattern.compile(EMAIL_ADDRESS_PATTERN);
        return pattern.matcher(text).matches();
    }

    /**
     * 16进制字符串转字节数组
     * @param hexString
     * @return
     */
    public static byte[] hex2byte(String hexString) {
        //长度除以2, 字符肯定为2的倍数，所以不用考虑精度问题
        int byteSize = hexString.length() >> 1;
        byte[] bytes = new byte[byteSize];
        for (int i = 0; i < byteSize; i++) {
            int index = i << 1;
            String digitChar = hexString.substring(index, index + 2);
            bytes[i] = (byte) Integer.parseInt(digitChar, 16);
        }
        return bytes;
    }

    /**
     * 转16进制字符串
     * @param bytes
     * @return
     */
    public static String byte2hex(byte[] bytes) {
        // 转成16进制字符串
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            //整数转成十六进制表示
            sb.append(Integer.toHexString(b & 0xFF | 0x100).substring(1));
        }
        return sb.toString().toLowerCase(); //转成小写
    }

    /**
     * 对文本摘要，先base64 再md5摘要 生成16位摘要字符串
     * @param text  明文
     * @param salt  干扰字符
     * @return
     * @throws java.io.UnsupportedEncodingException
     * @throws java.security.NoSuchAlgorithmException
     */
    public static String digestText(String text, String salt) throws UnsupportedEncodingException,
            NoSuchAlgorithmException {
        byte[] bytes = Base64.encodeBase64(text.getBytes("UTF-8"));
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        //加入干扰
        messageDigest.update(salt.getBytes("UTF-8"));
        messageDigest.update(bytes);
        return byte2hex(messageDigest.digest()).substring(8, 24);
    }

    /**
     * 对文本SHA1摘要，用base64转byte
     *
     * @param text
     * @return
     * @throws Exception
     */
    public static String sha1Text(String text) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(text.getBytes("UTF-8"));
        return new String(Base64.encodeBase64(messageDigest.digest()), "utf-8");
    }

    /**
     * 生成随机字符串
     * @param length   生成长度
     * @return
     */
    public static String generateRandomText(int length) {
        String tables = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_+-={}[]':,.;|\\\"";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int l = tables.length();
        for (int i = 0; i < length; i++) {
            sb.append(tables.charAt(random.nextInt(l)));
        }
        return sb.toString();
    }

    /**
     * 生成随机字符串
     * @return
     */
    public static String generateRandomText() {
        return generateRandomText(RANDOM_TEXT_DEFAULT_LEN);
    }

    /**
     * 
     * @Function: checkLength
     * @Description:
     *
     * @param nickname
     * @return
     * @throws java.io.UnsupportedEncodingException
     *
     * @version: v1.0.0
     * @author: think
     * @date: 2012-2-14 下午05:35:42
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2012-2-14     think           v1.0.0
     */
    public static boolean checkLength(String nickname, int dbLength) throws UnsupportedEncodingException {

        int count = nickname.getBytes("UTF-8").length;
        if (count > dbLength) {
            //System.out.println("昵称过长");
            return false;
        }
        else if (count == 0) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @Function: isSimplePassword
     * @Description: 简单密码校验
     * @param password
     * @return
     *
     * @version: v1.0.0
     * @author: ZSJ
     * @date: 2012-2-15 下午03:25:29
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2012-2-15     ZSJ           v1.0.0
     */
    public static boolean isSimplePassword(String password) {
        Pattern pattern1 = Pattern.compile("^\\S{6,20}$");//判断字符为6到20位的非空字符
        Pattern pattern2 = Pattern.compile("^\\d+$");//判断字符为数字
        Pattern pattern3 = Pattern.compile("^[a-zA-Z]+$");//判断字符是全字母
        if (!pattern1.matcher(password).matches()) {
            return false;
        }
        if (pattern2.matcher(password).matches()) {
            return false;
        }
        if (pattern3.matcher(password).matches()) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @Function: isPhoneNo
     * @Description: 手机号码校验
     *
     * @return
     *
     * @version: v1.0.0
     * @author: ZSJ
     * @date: 2012-2-20 上午09:13:37
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2012-2-20     ZSJ           v1.0.0
     */
    public static boolean isPhoneNo(String phoneNo) {
        Pattern pattern = Pattern.compile("^\\d+$");//判断字符为数字
        if (pattern.matcher(phoneNo).matches()) {
            return true;
        }
        return false;
    }

    /**
     * 
     * @Function: isServiceNo
     * @Description: 服务密码校验
     * @return
     *
     * @version: v1.0.0
     * @author: ZSJ
     * @date: 2012-2-20 上午09:13:58
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2012-2-20     ZSJ           v1.0.0
     */
    public static boolean isServiceNo(String serviceNo) {
        Pattern serviceNo1 = Pattern.compile("^\\d{6}$");//判断字符为六位的数字
        if (serviceNo1.matcher(serviceNo).matches()) {
            return true;
        }
        return false;
    }

    /**
     * @Function: map2json
     * @Description: map对象转化成jsonStr(加密)
     *
     * @param object
     * @return
     *
     * @version: v1.0.0
     * @author: yuandj
     * @date: 2012-4-10 上午11:01:42
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2012-4-10     yuandj           v1.0.0
     */
    public static String object2json(Object object) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return SecUtils.encryptText(objectMapper.writeValueAsString(object));
    }

    /**
     * @Function: json2map
     * @Description: jsonStr对象转化成Map(解密)
     *
     * @param json
     * @return
     *
     * @version: v1.0.0
     * @author: yuandj
     * @date: 2012-4-10 上午11:20:39
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2012-4-10     yuandj           v1.0.0
     */
    public static Map<String, String> json2map(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(SecUtils.decryptText(json), new TypeReference<Map<String, String>>() {
        });
    }

    /**
     * @Function: json2object
     * @Description: jsonStr对象转化成object(解密)
     *
     * @param json
     * @return
     *
     * @version: v1.0.0
     * @author: yuml
     * @date: 2012-4-24 上午11:20:39
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2012-4-24     yuml           v1.0.0
     */
    public static <T> T json2object(String json, Class<T> clazz) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(SecUtils.decryptText(json), clazz);
    }

    /**
     * 
    * @Function: checkDate
    * @Description: 传入日期格式校验
    *
    * @param date
    * @return
    *
    * @version: v1.0.0
    * @author: ZC
     * @throws java.text.ParseException
    * @date: 2012-5-14 下午05:41:58 
    *
    * Modification History:
    * Date         Author          Version            Description
    *---------------------------------------------------------*
    * 2012-5-14     ZC           v1.0.0
     */
    public static boolean checkDate(String date) {
        boolean ret = true;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            df.setLenient(false);
            ret = df.format(df.parse(date)).equals(date);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
