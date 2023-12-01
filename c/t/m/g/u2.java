package c.t.m.g;

import com.tencent.cos.xml.crypto.JceEncryptionConstants;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/u2.class */
public class u2 {
    public static String a(String str) {
        try {
            return new String(a(l2.a(str)), "UTF-8");
        } catch (Throwable th) {
            return "";
        }
    }

    public static Cipher a(byte[] bArr, byte[] bArr2, int i) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
        cipher.init(i, secretKeySpec, new IvParameterSpec(bArr2));
        return cipher;
    }

    public static byte[] a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        return a(bArr, i + 16, i2 - 16, bArr2, bArr2, 2);
    }

    public static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, byte[] bArr3) {
        return a(bArr, i, i2, bArr2, bArr3, 1);
    }

    public static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, byte[] bArr3, int i3) {
        if (i3 == 1 || i3 == 2) {
            if (bArr == null || bArr.length == 0 || i < 0 || i2 <= 0) {
                return k2.f3812a;
            }
            try {
                Cipher a2 = a(bArr2, bArr3, i3);
                return a2 == null ? k2.f3812a : a2.doFinal(bArr, i, i2);
            } catch (Throwable th) {
                return k2.f3812a;
            }
        }
        throw new IllegalArgumentException("wrong mode.");
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(bArr, 0, bArr.length, bArr2, bArr3);
    }

    public static String b(String str) {
        try {
            return l2.a(b(str.getBytes("UTF-8")));
        } catch (Throwable th) {
            return "";
        }
    }

    public static byte[] b(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public static byte[] b(byte[] bArr, int i, int i2) {
        try {
            byte[] a2 = x2.a(16);
            byte[] a3 = a(bArr, i, i2, a2, a2, 1);
            if (m3.a(a3)) {
                return a3;
            }
            byte[] bArr2 = new byte[a2.length + a3.length];
            System.arraycopy(a2, 0, bArr2, 0, a2.length);
            System.arraycopy(a3, 0, bArr2, a2.length, a3.length);
            return bArr2;
        } catch (Throwable th) {
            return k2.f3812a;
        }
    }
}
