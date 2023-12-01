package com.tencent.cloud.huiyansdkface.normal.tools.secure;

import java.security.SecureRandom;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/normal/tools/secure/SecureRandomStringUtils.class */
public class SecureRandomStringUtils {
    public static String randomAlphabetic(int i) {
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            StringBuffer stringBuffer = new StringBuffer();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return stringBuffer.toString();
                }
                int abs = Math.abs(secureRandom.nextInt() % 52);
                if (abs > 26) {
                    stringBuffer.append((char) ((abs - 26) + 97));
                } else {
                    stringBuffer.append((char) (abs + 65));
                }
                i2 = i3 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int randomNum(int i) {
        try {
            return SecureRandom.getInstance("SHA1PRNG").nextInt(i);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String randomNumeric(int i) {
        String str;
        String str2 = "";
        String str3 = str2;
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                str = str2;
                if (i3 >= i) {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                String str4 = str2;
                sb.append(str2);
                String str5 = str2;
                sb.append(new Integer(secureRandom.nextInt(i)).toString());
                String str6 = str2;
                str2 = sb.toString();
                if (str2.length() >= i) {
                    str = str2;
                    break;
                }
                i2 = i3 + 1;
            }
            str3 = str;
            return str.substring(0, i);
        } catch (Exception e) {
            e.printStackTrace();
            return str3;
        }
    }
}
