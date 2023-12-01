package com.blued.android.framework.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.danlan.android.security.AesCryptor;
import java.util.Random;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/AesCrypto2.class */
public class AesCrypto2 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10065a = "df0b".toLowerCase();
    public static final byte[] b = a();

    public static String a(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] decode = Base64.decode(str, 2);
        String lowerCase = ByteTransformUtils.a(decode, 0, decode.length).toLowerCase();
        String str2 = lowerCase;
        if (lowerCase.startsWith(f10065a)) {
            str2 = lowerCase.substring(f10065a.length());
        }
        int parseInt = Integer.parseInt(f10065a.substring(0, 1), 16);
        int i = parseInt + 32;
        String substring = str2.substring(parseInt, i);
        return new String(AesCryptor.aesDecryptByteArry(c(str2.substring(0, parseInt) + str2.substring(i)), AesCryptor.b, ByteTransformUtils.a(substring)));
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

    public static String b(String str) throws Exception {
        byte[] a2 = a();
        String a3 = a(AesCryptor.aesEncryptByteArry(str.getBytes("utf-8"), AesCryptor.f21715a, a2));
        String a4 = a(a2);
        int parseInt = Integer.parseInt(f10065a.substring(0, 1), 16);
        return Base64.encodeToString(ByteTransformUtils.a(f10065a + a3.substring(0, parseInt) + a4 + a3.substring(parseInt)), 2);
    }

    public static byte[] c(String str) {
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
