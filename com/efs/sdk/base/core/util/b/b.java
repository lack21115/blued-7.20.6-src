package com.efs.sdk.base.core.util.b;

import android.util.Base64;
import com.efs.sdk.base.core.util.Log;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/util/b/b.class */
public final class b {
    public static String a(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        try {
            return String.format(Locale.CHINA, "%032x", new BigInteger(1, MessageDigest.getInstance("MD5").digest(str.getBytes())));
        } catch (NoSuchAlgorithmException e) {
            Log.e("efs.base", "md5 error", e);
            return "";
        }
    }

    public static String a(byte[] bArr) {
        return new String(Base64.encode(bArr, 11));
    }

    public static String b(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e("efs.base", "urlEncode error", e);
            return "";
        }
    }

    public static String b(byte[] bArr) {
        try {
            return new String(Base64.decode(bArr, 11));
        } catch (Throwable th) {
            Log.e("efs.base", "decode error", th);
            return "";
        }
    }
}
