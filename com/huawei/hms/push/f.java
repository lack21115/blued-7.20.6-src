package com.huawei.hms.push;

import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/f.class */
public class f {
    private static int a(Context context) {
        int i = context.getApplicationInfo().icon;
        int i2 = i;
        if (i == 0) {
            int identifier = context.getResources().getIdentifier("btn_star_big_on", com.anythink.expressad.foundation.h.i.f5112c, "android");
            HMSLog.d("PushSelfShowLog", "icon is btn_star_big_on ");
            i2 = identifier;
            if (identifier == 0) {
                i2 = 17301651;
                HMSLog.d("PushSelfShowLog", "icon is sym_def_app_icon ");
            }
        }
        return i2;
    }

    public static Bitmap a(Context context, m mVar) {
        if (context == null || mVar == null) {
            return null;
        }
        try {
            if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11) {
                HMSLog.i("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");
                return null;
            } else if ("com.huawei.android.pushagent".equals(mVar.k())) {
                return null;
            } else {
                HMSLog.i("PushSelfShowLog", "get left bitmap from " + mVar.k());
                return ((BitmapDrawable) context.getPackageManager().getApplicationIcon(mVar.k())).getBitmap();
            }
        } catch (PackageManager.NameNotFoundException e) {
            HMSLog.e("PushSelfShowLog", "build left icon occur NameNotFoundException.");
            return null;
        } catch (Exception e2) {
            HMSLog.e("PushSelfShowLog", "build left icon occur Exception.");
            return null;
        }
    }

    public static void a(Context context, Notification.Builder builder, m mVar) {
        if (context == null || builder == null || mVar == null) {
            HMSLog.e("PushSelfShowLog", "msg is null");
        } else {
            builder.setSmallIcon(b(context, mVar));
        }
    }

    private static int b(Context context, m mVar) {
        if (context == null || mVar == null) {
            HMSLog.i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
            return 0;
        }
        int i = 0;
        if (!TextUtils.isEmpty(mVar.m())) {
            String[] split = mVar.m().split("/");
            i = 0;
            if (split.length == 3) {
                i = q.a(context, split[1], split[2]);
            }
        }
        int i2 = i;
        if (i == 0) {
            i2 = q.a(context, "com.huawei.messaging.default_notification_icon");
        }
        return i2 != 0 ? i2 : a(context);
    }
}
