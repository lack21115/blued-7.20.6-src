package com.blued.android.framework.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/AesCrypto.class */
public class AesCrypto {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10063a = "df0b".toLowerCase();
    public static final byte[] b = Base64.decode("VlEc5qsEDXWChrWJ0AzMXQ==", 2);

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f10064c = Base64.decode("MC8Lpxk9zqyuRPXMdO8rJQ==", 2);
    public static final byte[] d = a();

    public static String a(String str) throws Exception {
        byte[] a2 = a();
        String a3 = a(str, a2);
        String a4 = a(a2);
        int parseInt = Integer.parseInt(f10063a.substring(0, 1), 16);
        return f10063a + a3.substring(0, parseInt) + a4 + a3.substring(parseInt);
    }

    private static String a(String str, String str2, byte[] bArr) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] decode = Base64.decode(str, 2);
        String lowerCase = ByteTransformUtils.a(decode, 0, decode.length).toLowerCase();
        String str3 = lowerCase;
        if (lowerCase.startsWith(str2)) {
            str3 = lowerCase.substring(str2.length());
        }
        int parseInt = Integer.parseInt(str2.substring(0, 1), 16);
        int i = parseInt + 32;
        String substring = str3.substring(parseInt, i);
        return new String(b(b(bArr), f(str3.substring(0, parseInt) + str3.substring(i)), ByteTransformUtils.a(substring)));
    }

    public static String a(String str, byte[] bArr) throws Exception {
        return a(a(b(b), str.getBytes(), bArr));
    }

    public static String a(byte[] bArr) {
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

    private static void a(StringBuffer stringBuffer, byte b2) {
        stringBuffer.append("0123456789ABCDEF".charAt((b2 >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b2 & 15));
    }

    private static byte[] a() {
        Random random = new Random();
        byte[] bArr = new byte[16];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 16) {
                return bArr;
            }
            bArr[i2] = (byte) (random.nextInt(256) - 128);
            i = i2 + 1;
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
        return cipher.doFinal(bArr2);
    }

    public static String b(String str) throws Exception {
        return b(str, f10063a, b);
    }

    private static String b(String str, String str2, byte[] bArr) throws Exception {
        byte[] a2 = a();
        String a3 = a(a(b(bArr), str.getBytes(), a2));
        String a4 = a(a2);
        int parseInt = Integer.parseInt(str2.substring(0, 1), 16);
        return Base64.encodeToString(ByteTransformUtils.a(str2 + a3.substring(0, parseInt) + a4 + a3.substring(parseInt)), 2);
    }

    private static byte[] b(byte[] bArr) throws Exception {
        return bArr;
    }

    private static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
        return cipher.doFinal(bArr2);
    }

    public static String c(String str) throws Exception {
        return a(str, f10063a, b);
    }

    public static String d(String str) throws Exception {
        return b(str, "4545", f10064c);
    }

    public static String e(String str) throws Exception {
        return a(str, "4545", f10064c);
    }

    public static byte[] f(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            int i3 = i2 * 2;
            bArr[i2] = Integer.valueOf(str.substring(i3, i3 + 2), 16).byteValue();
            i = i2 + 1;
        }
    }
}
