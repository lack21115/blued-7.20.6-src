package com.blued.android.framework.web;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.blued.android.core.AppInfo;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/CommonUrlHandler.class */
public class CommonUrlHandler {
    public static boolean a(Context context, String str) {
        if (str.startsWith("tel:")) {
            b(context, str);
            return true;
        } else if (str.startsWith("wtai://wp/mc")) {
            c(context, str);
            return true;
        } else if (str.startsWith("sms:")) {
            d(context, str);
            return true;
        } else if (str.startsWith("mailto:")) {
            e(context, str);
            return true;
        } else {
            return false;
        }
    }

    public static boolean a(Intent intent) {
        List<ResolveInfo> queryIntentActivities = AppInfo.d().getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    private static void b(Context context, String str) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(str));
        if (a(intent)) {
            context.startActivity(intent);
            return;
        }
        Log.e("CommonUrlHandler", "不支持该url处理, url:" + str);
    }

    private static void c(Context context, String str) {
        String[] split = str.split(";");
        if (split.length == 2) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel://" + split[1]));
            if (a(intent)) {
                context.startActivity(intent);
                return;
            }
            Log.e("CommonUrlHandler", "不支持该url处理, url:" + str);
        }
    }

    private static void d(Context context, String str) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + str.substring(4, str.length())));
        intent.putExtra("sms_body", "");
        if (a(intent)) {
            context.startActivity(intent);
            return;
        }
        Log.e("CommonUrlHandler", "不支持该url处理, url:" + str);
    }

    private static void e(Context context, String str) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(str));
        if (a(intent)) {
            context.startActivity(intent);
            return;
        }
        Log.e("CommonUrlHandler", "不支持该url处理, url:" + str);
    }
}
