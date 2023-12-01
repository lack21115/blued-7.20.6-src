package com.qiniu.android.utils;

import android.util.Base64;
import java.io.UnsupportedEncodingException;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/UrlSafeBase64.class */
public final class UrlSafeBase64 {
    public static byte[] decode(String str) {
        return Base64.decode(str, 10);
    }

    public static String encodeToString(String str) {
        try {
            return encodeToString(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encodeToString(byte[] bArr) {
        return Base64.encodeToString(bArr, 10);
    }
}
