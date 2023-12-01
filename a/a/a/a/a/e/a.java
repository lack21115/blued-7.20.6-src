package a.a.a.a.a.e;

import java.security.GeneralSecurityException;
import java.security.SignatureException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/e/a.class */
public class a {
    public static Mac a(SecretKeySpec secretKeySpec) throws GeneralSecurityException {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(secretKeySpec);
        return mac;
    }

    public static byte[] a(String str, String str2) throws SignatureException {
        try {
            Mac a2 = a(new SecretKeySpec(str.getBytes("UTF-8"), "HmacSHA1"));
            a2.update(str2.getBytes("UTF-8"));
            return a2.doFinal();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SignatureException("Failed to digest: " + e.getMessage());
        }
    }

    public static String b(String str, String str2) throws SignatureException {
        return g.a(a(str, str2));
    }
}
