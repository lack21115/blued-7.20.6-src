package com.huawei.secure.android.common.util;

import android.util.Base64;
import android.util.Log;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/util/SafeBase64.class */
public class SafeBase64 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9539a = "SafeBase64";

    private SafeBase64() {
    }

    public static byte[] decode(String str, int i) {
        try {
            return Base64.decode(str, i);
        } catch (Exception e) {
            String str2 = f9539a;
            Log.e(str2, e.getClass().getSimpleName() + " , message2 : " + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decode(byte[] bArr, int i) {
        try {
            return Base64.decode(bArr, i);
        } catch (Exception e) {
            String str = f9539a;
            Log.e(str, e.getClass().getSimpleName() + " , message0 : " + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        try {
            return Base64.decode(bArr, i, i2, i3);
        } catch (Exception e) {
            String str = f9539a;
            Log.e(str, e.getClass().getSimpleName() + " , message1 : " + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i) {
        try {
            return Base64.encode(bArr, i);
        } catch (Exception e) {
            String str = f9539a;
            Log.e(str, e.getClass().getSimpleName() + " , message3 : " + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        try {
            return Base64.encode(bArr, i, i2, i3);
        } catch (Exception e) {
            String str = f9539a;
            Log.e(str, e.getClass().getSimpleName() + " , message4 : " + e.getMessage());
            return new byte[0];
        }
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return Base64.encodeToString(bArr, i);
        } catch (Exception e) {
            String str = f9539a;
            Log.e(str, e.getClass().getSimpleName() + " , message5 : " + e.getMessage());
            return "";
        }
    }

    public static String encodeToString(byte[] bArr, int i, int i2, int i3) {
        try {
            return Base64.encodeToString(bArr, i, i2, i3);
        } catch (Exception e) {
            String str = f9539a;
            Log.e(str, e.getClass().getSimpleName() + " , message6 : " + e.getMessage());
            return "";
        }
    }
}
