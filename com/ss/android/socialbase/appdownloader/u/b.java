package com.ss.android.socialbase.appdownloader.u;

import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/u/b.class */
public class b {
    public static String mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new String(Base64.decode(DownloadUtils.hexToString(str), 0));
    }

    public static String mb(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        byte[] decode = Base64.decode(DownloadUtils.hexToString(str), 0);
        int length = str2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (byte b : decode) {
            int i2 = i;
            if (i >= length) {
                i2 = i % length;
            }
            sb.append((char) (b ^ str2.charAt(i2)));
            i = i2 + 1;
        }
        return sb.toString();
    }
}
