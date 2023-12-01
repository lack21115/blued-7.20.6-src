package com.alipay.security.mobile.module.a.a;

import com.tencent.cos.xml.crypto.JceEncryptionConstants;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/a/a/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f4703a = "idnjfhncnsfuobcnt847y929o449u474w7j3h22aoddc98euk#%&&)*&^%#";

    public static String a() {
        String str = new String();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= f4703a.length() - 1) {
                return str;
            }
            str = str + f4703a.charAt(i2);
            i = i2 + 4;
        }
    }

    public static String a(String str, String str2) {
        try {
            PBEKeySpec a2 = a(str);
            byte[] bytes = str2.getBytes();
            byte[] b = b();
            SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(a2).getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            cipher.init(1, secretKeySpec, new IvParameterSpec(b));
            byte[] salt = a2.getSalt();
            ByteBuffer allocate = ByteBuffer.allocate(salt.length + cipher.getOutputSize(bytes.length));
            allocate.put(salt);
            cipher.doFinal(ByteBuffer.wrap(bytes), allocate);
            return a(allocate.array());
        } catch (Exception e) {
            return null;
        }
    }

    private static String a(byte[] bArr) {
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
            byte b = bArr[i2];
            stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(b & 15));
            i = i2 + 1;
        }
    }

    private static PBEKeySpec a(String str) {
        Class<?> cls = Class.forName(new String(a.a("amF2YS5zZWN1cml0eS5TZWN1cmVSYW5kb20=")));
        Object newInstance = cls.newInstance();
        byte[] bArr = new byte[16];
        Method method = cls.getMethod("nextBytes", bArr.getClass());
        method.setAccessible(true);
        method.invoke(newInstance, bArr);
        return new PBEKeySpec(str.toCharArray(), bArr, 10, 128);
    }

    public static String b(String str, String str2) {
        byte[] doFinal;
        try {
            PBEKeySpec a2 = a(str);
            int length = str2.length() / 2;
            byte[] bArr = new byte[length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                int i3 = i2 * 2;
                bArr[i2] = Integer.valueOf(str2.substring(i3, i3 + 2), 16).byteValue();
                i = i2 + 1;
            }
            byte[] b = b();
            if (length <= 16) {
                doFinal = null;
            } else {
                SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(a2.getPassword(), Arrays.copyOf(bArr, 16), 10, 128)).getEncoded(), "AES");
                Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
                cipher.init(2, secretKeySpec, new IvParameterSpec(b));
                doFinal = cipher.doFinal(bArr, 16, length - 16);
            }
            if (doFinal != null) {
                String str3 = new String(doFinal);
                if (com.alipay.security.mobile.module.a.a.c(str3)) {
                    return str3;
                }
                return null;
            }
            throw new Exception();
        } catch (Exception e) {
            return null;
        }
    }

    private static byte[] b() {
        try {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 48) {
                    return a.a(sb.toString());
                }
                sb.append("AsAgAtA5A6AdAgABABACADAfAsAdAfAsAgAaAgA3A5A6=8=0".charAt(i2));
                i = i2 + 2;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
