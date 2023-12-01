package com.anythink.expressad.foundation.h;

import android.text.TextUtils;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5104a = "ebmclXzZOhtU2sRlZxGL8A";
    private static byte[] b = new byte[32];

    /* renamed from: c  reason: collision with root package name */
    private static byte[] f5105c = new byte[16];

    /* renamed from: com.anythink.expressad.foundation.h.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/a$a.class */
    public static final class C0077a extends Provider {
        public C0077a() {
            super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", ExifInterface.TAG_SOFTWARE);
        }
    }

    static {
        if (TextUtils.isEmpty(f5104a)) {
            return;
        }
        try {
            byte[] digest = MessageDigest.getInstance("sha-384").digest(f5104a.getBytes());
            System.arraycopy(digest, 0, b, 0, 32);
            System.arraycopy(digest, 32, f5105c, 0, 16);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String a(String str) {
        return a(str, b, f5105c);
    }

    private static String a(String str, byte[] bArr, byte[] bArr2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Security.addProvider(new C0077a());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return new String(Base64.encode(cipher.doFinal(str.getBytes()), 0));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(byte[] bArr) {
        String str;
        String str2 = "";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return str2;
            }
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() == 1) {
                str = str2 + "0" + hexString;
            } else {
                str = str2 + hexString;
            }
            str2 = str;
            i = i2 + 1;
        }
    }

    private static String b(String str, byte[] bArr, byte[] bArr2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(Base64.decode(str, 0)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            byte[] digest = MessageDigest.getInstance("sha-384").digest(str.getBytes());
            System.arraycopy(digest, 0, b, 0, 32);
            System.arraycopy(digest, 32, f5105c, 0, 16);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String c(String str) {
        return b(str, b, f5105c);
    }

    private static byte[] d(String str) {
        String upperCase = str.trim().replace(" ", "").toUpperCase(Locale.US);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            int i3 = i2 * 2;
            int i4 = i3 + 1;
            bArr[i2] = (byte) (Integer.decode("0x" + upperCase.substring(i3, i4) + upperCase.substring(i4, i4 + 1)).intValue() & 255);
            i = i2 + 1;
        }
    }
}
