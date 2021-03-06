package cn.wenjig.crm.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * 将信息摘要,或加密
 */
public class MD5Util {

    /**
     * @Description: 32位MD5 (会将一串额外的字符加入,一定程度上防解密???)
     * @param inStr
     * @Return java.lang.String
     */
    public static String md5Encode(String inStr) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        byte[] byteArray = (inStr + "Long May The SunShine").getBytes(StandardCharsets.UTF_8);
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuilder hexValue = new StringBuilder();
        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

}
