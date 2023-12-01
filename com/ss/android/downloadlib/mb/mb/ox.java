package com.ss.android.downloadlib.mb.mb;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.x;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/mb/mb/ox.class */
public class ox {
    public static String mb() {
        return ox(x.getContext());
    }

    public static String mb(Context context) {
        try {
            return mb(b.mb(mb(), "MD5"));
        } catch (Exception e) {
            return null;
        }
    }

    public static String mb(byte[] bArr) {
        return mb.mb(bArr);
    }

    public static String ox(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "normal";
        }
        return str2;
    }
}
