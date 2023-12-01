package com.igexin.push.f;

import android.text.TextUtils;
import android.util.Base64;
import java.io.RandomAccessFile;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10034a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCzbMQ22qV6umuPXYWXEOGdlpJR\nBWMP68/ArS7XG8+7GmRbWMW1HOMLOOdwuIfPFp9QiwOshG0mYXlm1ecQ/fCXhRMW\nfh+OMCoBdl7vnCpoDYPmjYQBkm9fRW6oej33UhZtlnTZjECAsyC2Eybha7jg3Lft\ngYVnwaPShTmv5+Z9SQIDAQAB";
    private static final String b = "LOG-CryptoTool";

    private static byte a(char c2) {
        return (byte) "0123456789ABCDEF".indexOf(c2);
    }

    private static String a() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return a(keyGenerator.generateKey().getEncoded());
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
            i = i2 + 1;
        }
    }

    private static void a(RandomAccessFile randomAccessFile) throws Exception {
        long length = (int) (randomAccessFile.length() % 16);
        if (length >= 16 || length <= 0) {
            return;
        }
        randomAccessFile.setLength(randomAccessFile.length() - length);
    }

    private static byte[] a(String str) throws Exception {
        RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(f10034a, 0)));
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
        cipher.init(1, rSAPublicKey);
        byte[] doFinal = cipher.doFinal(str.getBytes("UTF-8"));
        a(doFinal);
        return doFinal;
    }

    private static RSAPublicKey b(String str) throws Exception {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
    }

    private static void b() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        com.igexin.push.core.e.aB = keyGenerator.generateKey().getEncoded();
        o.a(com.igexin.push.core.e.l, o.g, a(g.a(com.igexin.push.core.e.aB)));
        o.b(com.igexin.push.core.e.l, o.g, "");
    }

    private static byte[] c() {
        if (com.igexin.push.core.e.aB == null) {
            String str = (String) o.b(com.igexin.push.core.e.l, o.g, "");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] bArr = null;
            if (str != null) {
                if (!str.equals("")) {
                    String upperCase = str.toUpperCase();
                    int length = upperCase.length() / 2;
                    char[] charArray = upperCase.toCharArray();
                    byte[] bArr2 = new byte[length];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        bArr = bArr2;
                        if (i2 >= length) {
                            break;
                        }
                        int i3 = i2 * 2;
                        bArr2[i2] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i3 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i3])) << 4));
                        i = i2 + 1;
                    }
                } else {
                    bArr = null;
                }
            }
            com.igexin.push.core.e.aB = com.igexin.c.a.a.a.a(bArr, com.igexin.push.core.e.M);
        }
        return com.igexin.push.core.e.aB;
    }

    private static byte[] c(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            int i3 = i2 * 2;
            bArr[i2] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i3 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i3])) << 4));
            i = i2 + 1;
        }
    }
}
