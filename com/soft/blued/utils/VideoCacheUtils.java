package com.soft.blued.utils;

import android.text.TextUtils;
import com.blued.android.core.AppMethods;
import com.blued.android.core.utils.Md5;
import java.io.File;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/VideoCacheUtils.class */
public class VideoCacheUtils {
    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String b = AppMethods.b("video");
        String a2 = Md5.a(str.toLowerCase());
        return b + File.separator + a2;
    }

    public static String a(String str, String str2) {
        String a2 = a(str);
        if (!TextUtils.isEmpty(a2) && AppMethods.a(str2, a2, false)) {
            return a2;
        }
        return str2;
    }
}
