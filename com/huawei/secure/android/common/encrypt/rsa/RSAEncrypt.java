package com.huawei.secure.android.common.encrypt.rsa;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/encrypt/rsa/RSAEncrypt.class */
public abstract class RSAEncrypt {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23081a = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    private static final String b = "RSAEncrypt";

    /* renamed from: c  reason: collision with root package name */
    private static final String f23082c = "UTF-8";
    private static final String d = "";
    private static final int e = 2048;
    private static final String f = "RSA";

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(b, "content or private key is null");
            return "";
        }
        return decrypt(str, EncryptUtil.getPrivateKey(str2));
    }

    public static String decrypt(String str, PrivateKey privateKey) {
        if (TextUtils.isEmpty(str) || privateKey == null || !isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            b.b(b, "content or privateKey is null , or length is too short");
            return "";
        }
        try {
            return new String(decrypt(Base64.decode(str, 0), privateKey), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            b.b(b, "RSA decrypt exception : " + e2.getMessage());
            return "";
        } catch (Exception e3) {
            b.b(b, "exception : " + e3.getMessage());
            return "";
        }
    }

    public static byte[] decrypt(byte[] bArr, PrivateKey privateKey) {
        byte[] bArr2 = new byte[0];
        if (bArr == null || privateKey == null || !isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            b.b(b, "content or privateKey is null , or length is too short");
            return bArr2;
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(2, privateKey);
            return cipher.doFinal(bArr);
        } catch (GeneralSecurityException e2) {
            b.b(b, "RSA decrypt exception : " + e2.getMessage());
            return bArr2;
        }
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(b, "content or public key is null");
            return "";
        }
        return encrypt(str, EncryptUtil.getPublicKey(str2));
    }

    public static String encrypt(String str, PublicKey publicKey) {
        if (TextUtils.isEmpty(str) || publicKey == null || !isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            b.b(b, "content or PublicKey is null , or length is too short");
            return "";
        }
        try {
            return Base64.encodeToString(encrypt(str.getBytes("UTF-8"), publicKey), 0);
        } catch (UnsupportedEncodingException e2) {
            b.b(b, "encrypt: UnsupportedEncodingException");
            return "";
        } catch (Exception e3) {
            b.b(b, "exception : " + e3.getMessage());
            return "";
        }
    }

    public static byte[] encrypt(byte[] bArr, PublicKey publicKey) {
        byte[] bArr2 = new byte[0];
        if (bArr == null || publicKey == null || !isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            b.b(b, "content or PublicKey is null , or length is too short");
            return bArr2;
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (GeneralSecurityException e2) {
            b.b(b, "RSA encrypt exception : " + e2.getMessage());
            return bArr2;
        }
    }

    public static Map<String, Key> generateRSAKeyPair(int i) throws NoSuchAlgorithmException {
        HashMap hashMap = new HashMap(2);
        if (i < 2048) {
            b.b(b, "generateRSAKeyPair: key length is too short");
            return hashMap;
        }
        SecureRandom genSecureRandom = EncryptUtil.genSecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(f);
        keyPairGenerator.initialize(i, genSecureRandom);
        KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = generateKeyPair.getPublic();
        PrivateKey privateKey = generateKeyPair.getPrivate();
        hashMap.put("publicKey", publicKey);
        hashMap.put("privateKey", privateKey);
        return hashMap;
    }

    public static boolean isPrivateKeyLengthRight(RSAPrivateKey rSAPrivateKey) {
        boolean z = false;
        if (rSAPrivateKey == null) {
            return false;
        }
        if (rSAPrivateKey.getModulus().bitLength() >= 2048) {
            z = true;
        }
        return z;
    }

    public static boolean isPublicKeyLengthRight(RSAPublicKey rSAPublicKey) {
        boolean z = false;
        if (rSAPublicKey == null) {
            return false;
        }
        if (rSAPublicKey.getModulus().bitLength() >= 2048) {
            z = true;
        }
        return z;
    }
}
