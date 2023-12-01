package com.tencent.liteav.txcvodplayer.hlsencoder;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.liteav.base.util.LiteavLog;
import java.nio.charset.Charset;
import java.util.Random;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/hlsencoder/TXCHLSEncoder.class */
public class TXCHLSEncoder {

    /* renamed from: a  reason: collision with root package name */
    private static final String f36551a = TXCHLSEncoder.class.getName();
    private static final Charset b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f36552c = "0123456789ABCDEF".toCharArray();

    public static String a() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 32) {
                return sb.toString();
            }
            sb.append(f36552c[new Random().nextInt(f36552c.length)]);
            i = i2 + 1;
        }
    }

    public static String a(int i, String str, String str2, int i2) {
        String str3 = str;
        if (TextUtils.isEmpty(str)) {
            str3 = "default";
        }
        if (TextUtils.isEmpty(str2)) {
            LiteavLog.w(f36551a, "genSecretKey input exception!");
            return null;
        }
        return md5(i, str3, str2, i2);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            LiteavLog.w(f36551a, "encryptKey input exception!");
            return null;
        }
        return rsaEncrypt(str);
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            LiteavLog.w(f36551a, "encryptWithSecretKey input exception!");
            return null;
        }
        return Base64.encodeToString(aesEncrypt(str, str2.getBytes(b)), 2);
    }

    private static native byte[] aesDecrypt(String str, byte[] bArr);

    private static native byte[] aesEncrypt(String str, byte[] bArr);

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            LiteavLog.w(f36551a, "decryptWithSecretKey input exception!");
            return null;
        }
        return new String(aesDecrypt(str, Base64.decode(str2, 2)), b);
    }

    private static native String md5(int i, String str, String str2, int i2);

    private static native String rsaEncrypt(String str);
}
