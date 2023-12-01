package com.getui.gtc.a.a;

import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/a/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f8263a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.getui.gtc.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/a/a/a$a.class */
    public static final class C0168a extends Provider {
        public C0168a() {
            super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", ExifInterface.TAG_SOFTWARE);
        }
    }

    public static String a() {
        try {
            byte[] bArr = new byte[20];
            SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr);
            return b(bArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            return b(b(bArr, bArr2, bArr3));
        } catch (Exception e) {
            return null;
        }
    }

    private static void a(StringBuffer stringBuffer, byte b) {
        stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b & 15));
    }

    public static byte[] a(byte[] bArr) {
        SecureRandom secureRandom;
        byte[] encoded;
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            if (Build.VERSION.SDK_INT < 28) {
                if (Build.VERSION.SDK_INT >= 24) {
                    secureRandom = SecureRandom.getInstance("SHA1PRNG", new C0168a());
                } else if (Build.VERSION.SDK_INT >= 17) {
                    secureRandom = SecureRandom.getInstance("SHA1PRNG", "Crypto");
                }
                secureRandom.setSeed(bArr);
                keyGenerator.init(128, secureRandom);
                encoded = keyGenerator.generateKey().getEncoded();
                if (Build.VERSION.SDK_INT >= 28 && f8263a == null) {
                    f8263a = encoded;
                }
                return encoded;
            } else if (f8263a != null) {
                return f8263a;
            }
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(bArr);
            keyGenerator.init(128, secureRandom);
            encoded = keyGenerator.generateKey().getEncoded();
            if (Build.VERSION.SDK_INT >= 28) {
                f8263a = encoded;
            }
            return encoded;
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
            return null;
        }
    }

    private static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return stringBuffer.toString();
            }
            a(stringBuffer, bArr[i2]);
            i = i2 + 1;
        }
    }

    private static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(a(bArr), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
            Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr2);
        } catch (Throwable th) {
            return null;
        }
    }
}
