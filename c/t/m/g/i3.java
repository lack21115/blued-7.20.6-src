package c.t.m.g;

import java.security.MessageDigest;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/i3.class */
public class i3 {
    public static String a(String str, String str2) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (Throwable th) {
            bArr = null;
        }
        return a(bArr, str2);
    }

    public static String a(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return o2.a(messageDigest.digest(), "");
        } catch (Throwable th) {
            g3.a();
            return "";
        }
    }
}
