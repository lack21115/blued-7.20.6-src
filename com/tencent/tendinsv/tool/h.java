package com.tencent.tendinsv.tool;

import android.content.Context;
import android.content.pm.Signature;
import java.security.MessageDigest;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/tool/h.class */
public class h {
    public static String a(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 64).packageName;
            } catch (Exception e) {
                return "-1";
            }
        }
        return "-1";
    }

    private static String a(byte[] bArr) {
        String hexString;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            int length = digest.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                int i3 = digest[i2] & 255;
                if (Integer.toHexString(i3).length() == 1) {
                    stringBuffer.append("0");
                    hexString = Integer.toHexString(i3);
                } else {
                    hexString = Integer.toHexString(i3);
                }
                stringBuffer.append(hexString);
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public static String b(Context context) {
        if (context != null) {
            try {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
                return (signatureArr == null || signatureArr.length <= 0) ? "-1" : a(signatureArr[0].toByteArray()).toUpperCase();
            } catch (Exception e) {
                return "-1";
            }
        }
        return "-1";
    }
}
