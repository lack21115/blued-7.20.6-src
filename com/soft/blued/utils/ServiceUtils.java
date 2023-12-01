package com.soft.blued.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.blued.android.core.AppInfo;
import com.soft.blued.app.BluedApplicationLike;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/ServiceUtils.class */
public class ServiceUtils {
    public static boolean a() {
        if (AppInfo.c()) {
            return Build.VERSION.SDK_INT < 26 || BluedApplicationLike.isAppOnForeground();
        }
        return false;
    }

    public static void startService(Context context, Class<?> cls, Bundle bundle) {
        if (a()) {
            Intent intent = new Intent(context, cls);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            try {
                context.startService(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
