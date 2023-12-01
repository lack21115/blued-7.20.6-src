package com.blued.android.framework.urlroute;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.net.URLEncoder;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/urlroute/BluedURIProcesser.class */
public class BluedURIProcesser {
    public static boolean navigation(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String str4 = "http://maps.google.com/maps?daddr=" + str2 + "," + str;
        String str5 = str4;
        if (!TextUtils.isEmpty(str3)) {
            str5 = str4 + "(" + URLEncoder.encode(str3) + ")";
        }
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str5)));
        return true;
    }
}
