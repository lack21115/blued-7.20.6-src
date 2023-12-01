package com.zx.a.I8b7;

import android.text.TextUtils;
import android.util.Base64;
import com.zx.module.annotation.Java2C;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/k.class */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static final SecureRandom f28450a = new SecureRandom();

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return a(a(str2, str.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            z1.a(e);
            return "";
        }
    }

    @Java2C.Method2C
    public static native String a(String str, boolean z) throws NoSuchAlgorithmException;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            byte b = bArr[i2];
            byte b2 = b;
            if (b < 0) {
                b2 = b + 256;
            }
            if (b2 < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(b2));
            i = i2 + 1;
        }
    }

    public static String a(byte[] bArr, SecretKey secretKey, String str) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, secretKey, new GCMParameterSpec(128, bArr, 0, 12));
        cipher.updateAAD(str.getBytes(StandardCharsets.UTF_8));
        return new String(cipher.doFinal(bArr, 12, bArr.length - 12), StandardCharsets.UTF_8);
    }

    public static SecretKey a(byte[] bArr, String str) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(str.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] doFinal = mac.doFinal(bArr);
            byte[] bArr2 = new byte[16];
            System.arraycopy(doFinal, 0, bArr2, 0, 16);
            return new SecretKeySpec(bArr2, "AES");
        } catch (Exception e) {
            z1.a(e);
            return null;
        }
    }

    public static byte[] a(String str, SecretKey secretKey, String str2) throws Exception {
        byte[] bArr = new byte[12];
        f28450a.nextBytes(bArr);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, secretKey, new GCMParameterSpec(128, bArr));
        cipher.updateAAD(str2.getBytes(StandardCharsets.UTF_8));
        byte[] doFinal = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
        ByteBuffer allocate = ByteBuffer.allocate(doFinal.length + 12);
        allocate.put(bArr);
        allocate.put(doFinal);
        return allocate.array();
    }

    public static byte[] a(String str, SecretKey secretKey, IvParameterSpec ivParameterSpec, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(str);
        cipher.init(2, secretKey, ivParameterSpec);
        return cipher.doFinal(bArr);
    }

    public static byte[] a(String str, byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    public static PublicKey b(String str, String str2) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 0)));
    }

    public static SecretKey b(byte[] bArr, String str) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(str.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            return new SecretKeySpec(mac.doFinal(bArr), "AES");
        } catch (Exception e) {
            z1.a(e);
            return null;
        }
    }

    public static byte[] b(String str, SecretKey secretKey, IvParameterSpec ivParameterSpec, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(str);
        cipher.init(1, secretKey, ivParameterSpec);
        return cipher.doFinal(bArr);
    }
}
