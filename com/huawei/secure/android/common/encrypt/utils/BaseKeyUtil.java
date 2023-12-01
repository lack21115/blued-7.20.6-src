package com.huawei.secure.android.common.encrypt.utils;

import com.huawei.secure.android.common.encrypt.hash.PBKDF2;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/encrypt/utils/BaseKeyUtil.class */
public class BaseKeyUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9477a = "BaseKeyUtil";
    private static final int b = 16;

    /* renamed from: c  reason: collision with root package name */
    private static final int f9478c = 16;
    private static final int d = 10000;
    private static final int e = 32;
    private static final int f = 1;

    private static int a(int i, int i2, int i3) {
        int i4 = i;
        if (i2 < i) {
            i4 = i2;
        }
        return i3 < i4 ? i3 : i4;
    }

    private static boolean a(int i) {
        return i >= 16;
    }

    private static boolean a(int i, byte[] bArr) {
        return a(i) & a(bArr);
    }

    private static boolean a(byte[] bArr) {
        return bArr.length >= 16;
    }

    public static String exportHexRootKey(String str, String str2, String str3, byte[] bArr, int i, boolean z) {
        return HexUtil.byteArray2HexStr(exportRootKey(str, str2, str3, bArr, i, z));
    }

    public static byte[] exportRootKey(String str, String str2, String str3, String str4, int i, boolean z) {
        return exportRootKey(str, str2, str3, HexUtil.hexStr2ByteArray(str4), i, z);
    }

    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, int i, int i2, boolean z) {
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray3 = HexUtil.hexStr2ByteArray(str3);
        int a2 = a(hexStr2ByteArray.length, hexStr2ByteArray2.length, hexStr2ByteArray3.length);
        if (a(a2, bArr)) {
            char[] cArr = new char[a2];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= a2) {
                    break;
                }
                cArr[i4] = (char) ((hexStr2ByteArray[i4] ^ hexStr2ByteArray2[i4]) ^ hexStr2ByteArray3[i4]);
                i3 = i4 + 1;
            }
            if (z) {
                b.c(f9477a, "exportRootKey: sha256");
                return PBKDF2.pbkdf2SHA256(cArr, bArr, i, i2 * 8);
            }
            b.c(f9477a, "exportRootKey: sha1");
            return PBKDF2.pbkdf2(cArr, bArr, i, i2 * 8);
        }
        throw new IllegalArgumentException("key length must be more than 128bit.");
    }

    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, int i, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 10000, i, z);
    }

    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 16, z);
    }

    public static byte[] exportRootKey32(String str, String str2, String str3, byte[] bArr, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 32, z);
    }

    public static byte[] exportRootKey32Iteration1(String str, String str2, String str3, byte[] bArr, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 1, 32, z);
    }

    public static byte[] exportRootKeyIteration1(String str, String str2, String str3, byte[] bArr, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 1, 16, z);
    }
}
