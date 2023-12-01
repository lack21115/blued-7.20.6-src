package com.danlan.android.cognition.common;

import com.danlan.android.cognition.StringFog;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/common/HashUtil.class */
public class HashUtil {
    public static String md5(byte[] bArr) {
        MessageDigest messageDigest;
        int i;
        StringBuffer stringBuffer = new StringBuffer();
        MessageDigest messageDigest2 = null;
        try {
            MessageDigest messageDigest3 = MessageDigest.getInstance(StringFog.decrypt("bGcR"));
            messageDigest3.reset();
            messageDigest3.update(bArr);
            byte[] digest = messageDigest3.digest();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                messageDigest2 = messageDigest3;
                messageDigest = messageDigest3;
                if (i3 >= digest.length) {
                    break;
                }
                if (Integer.toHexString(digest[i3] & 255).length() == 1) {
                    stringBuffer.append(StringFog.decrypt("EQ=="));
                    i = digest[i3] & 255;
                } else {
                    i = digest[i3] & 255;
                }
                stringBuffer.append(Integer.toHexString(i));
                i2 = i3 + 1;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            messageDigest = messageDigest2;
        }
        return messageDigest != null ? stringBuffer.toString() : "";
    }
}
