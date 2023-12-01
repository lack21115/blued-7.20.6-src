package com.ishumei.l111l1111llIl;

import android.os.Build;
import android.util.Base64;
import java.io.IOException;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l1111llIl/l1111l111111Il.class */
public class l1111l111111Il {
    private static String l1111l111111Il(String str, byte[] bArr) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes()));
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(1, generateSecret);
            return Base64.encodeToString(cipher.doFinal(bArr), 0);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public static String l1111l111111Il(String str, byte[] bArr, int i) {
        try {
            return new String(l111l11111lIl(str, bArr, i), "utf-8");
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private static Key l1111l111111Il(String str) {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        SecureRandom secureRandom = Build.VERSION.SDK_INT >= 17 ? SecureRandom.getInstance("SHA1PRNG", "Crypto") : SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(str.getBytes("utf-8"));
        keyGenerator.init(64, secureRandom);
        return new SecretKeySpec(keyGenerator.generateKey().getEncoded(), "DES");
    }

    private static byte[] l111l11111I1l(String str, byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(2, new SecretKeySpec(str.getBytes("utf-8"), "DES"));
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private static String l111l11111lIl(String str, byte[] bArr) {
        try {
            return new String(l111l11111I1l(str, bArr), "utf-8");
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public static byte[] l111l11111lIl(String str, byte[] bArr, int i) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(2, new SecretKeySpec(str.getBytes("utf-8"), "DES"));
            byte[] doFinal = cipher.doFinal(bArr);
            byte[] bArr2 = new byte[i];
            System.arraycopy(doFinal, 0, bArr2, 0, i);
            return bArr2;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
