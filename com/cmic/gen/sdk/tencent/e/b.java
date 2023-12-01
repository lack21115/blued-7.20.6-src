package com.cmic.gen.sdk.tencent.e;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Calendar;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.security.auth.x500.X500Principal;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/e/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f21658a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context, String str) {
        a();
        byte[] b = b(context);
        if (b != null) {
            return a.a(b, str, f21658a);
        }
        a();
        return null;
    }

    public static void a() {
        k.a("AES_KEY");
    }

    private static boolean a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                keyGenerator.init(new KeyGenParameterSpec.Builder("CMCC_SDK_V1", 3).setDigests("SHA-256", "SHA-512").setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setRandomizedEncryptionRequired(false).setKeySize(256).build());
                Thread.sleep(1000L);
                keyGenerator.generateKey();
                return true;
            }
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 30);
            if (Build.VERSION.SDK_INT >= 18) {
                KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context).setAlias("CMCC_SDK_V1").setSubject(new X500Principal("CN=CMCC_SDK_V1")).setSerialNumber(BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                keyPairGenerator.initialize(build);
                Thread.sleep(1000L);
                keyPairGenerator.generateKeyPair();
                return true;
            }
            return false;
        } catch (Exception e) {
            c.a("KeystoreUtil", e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, boolean z) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (keyStore.getKey("CMCC_SDK_V1", null) != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (z) {
            return a(context);
        }
        return false;
    }

    private static String b() {
        return k.b("AES_KEY", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] b = b(context);
        if (b != null) {
            return a.b(b, str, f21658a);
        }
        a();
        return null;
    }

    private static byte[] b(Context context) {
        Cipher cipher;
        String str;
        byte[] doFinal;
        Cipher cipher2;
        synchronized (b.class) {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                keyStore.load(null);
                boolean z = false;
                if (a(context, false)) {
                    String b = b();
                    if (TextUtils.isEmpty(b)) {
                        byte[] a2 = q.a();
                        f21658a = q.a();
                        Key key = keyStore.getKey("CMCC_SDK_V1", null);
                        if (key instanceof SecretKey) {
                            c.b("KeystoreUtil", "随机生成aes秘钥");
                            cipher2 = Cipher.getInstance("AES/CBC/PKCS7Padding");
                            cipher2.init(1, key, new IvParameterSpec(f21658a));
                        } else if (!(key instanceof PrivateKey)) {
                            return null;
                        } else {
                            PublicKey publicKey = keyStore.getCertificate("CMCC_SDK_V1").getPublicKey();
                            cipher2 = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
                            c.b("KeystoreUtil", "生成rsa密");
                            cipher2.init(1, publicKey);
                        }
                        String encodeToString = Base64.encodeToString(cipher2.doFinal(a2), 0);
                        String encodeToString2 = Base64.encodeToString(f21658a, 0);
                        HashMap hashMap = new HashMap();
                        hashMap.put("AES_IV", encodeToString2);
                        hashMap.put("AES_KEY", encodeToString);
                        k.a(hashMap);
                        doFinal = a2;
                    } else {
                        f21658a = Base64.decode(c(), 0);
                        byte[] decode = Base64.decode(b, 0);
                        Key key2 = keyStore.getKey("CMCC_SDK_V1", null);
                        if (key2 == null) {
                            return null;
                        }
                        if (key2 instanceof SecretKey) {
                            cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                            cipher.init(2, key2, new IvParameterSpec(f21658a));
                            str = "使用aes";
                        } else if (!(key2 instanceof PrivateKey)) {
                            return null;
                        } else {
                            cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
                            cipher.init(2, key2);
                            str = "使用rsa";
                        }
                        c.b("KeystoreUtil", str);
                        doFinal = cipher.doFinal(decode);
                        StringBuilder sb = new StringBuilder();
                        sb.append("是否解密出秘钥：");
                        if (!TextUtils.isEmpty(Base64.encodeToString(doFinal, 0))) {
                            z = true;
                        }
                        sb.append(z);
                        c.b("KeystoreUtil", sb.toString());
                    }
                    return doFinal;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
            }
        }
    }

    private static String c() {
        return k.b("AES_IV", "");
    }
}
