package com.sobot.chat.utils;

import java.security.MessageDigest;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/MD5Util.class */
public class MD5Util {
    public static String encode(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            int length = digest.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String hexString = Integer.toHexString(digest[i2] & 255);
                if (hexString.length() < 2) {
                    sb.append("0");
                }
                sb.append(hexString);
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
