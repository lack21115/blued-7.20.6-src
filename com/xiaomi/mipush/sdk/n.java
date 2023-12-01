package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.xiaomi.push.bi;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/n.class */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static int f41231a = -1;

    public static ag a(Context context) {
        return m11491a(context) ? ag.HUAWEI : c(context) ? ag.OPPO : d(context) ? ag.VIVO : ag.OTHER;
    }

    private static boolean a() {
        try {
            String str = (String) bi.a("android.os.SystemProperties", MonitorConstants.CONNECT_TYPE_GET, "ro.build.hw_emui_api_level", "");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return Integer.parseInt(str) >= 9;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m11491a(Context context) {
        try {
            if (context.getPackageManager().getServiceInfo(new ComponentName("com.huawei.hwid", "com.huawei.hms.core.service.HMSCoreService"), 128) != null) {
                return a();
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean b(Context context) {
        Object a2 = bi.a(bi.a("com.google.android.gms.common.GoogleApiAvailability", "getInstance", new Object[0]), "isGooglePlayServicesAvailable", context);
        Object a3 = bi.a("com.google.android.gms.common.ConnectionResult", com.alipay.security.mobile.module.http.model.c.g);
        if (a3 == null || !(a3 instanceof Integer)) {
            com.xiaomi.channel.commonutils.logger.b.c("google service is not avaliable");
            f41231a = 0;
            return false;
        }
        int intValue = ((Integer) Integer.class.cast(a3)).intValue();
        if (a2 != null) {
            if (a2 instanceof Integer) {
                f41231a = ((Integer) Integer.class.cast(a2)).intValue() == intValue ? 1 : 0;
            } else {
                f41231a = 0;
                com.xiaomi.channel.commonutils.logger.b.c("google service is not avaliable");
            }
        }
        StringBuilder sb = new StringBuilder("is google service can be used");
        sb.append(f41231a > 0);
        com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
        return f41231a > 0;
    }

    public static boolean c(Context context) {
        Object a2 = bi.a("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", context);
        boolean z = false;
        if (a2 != null) {
            z = false;
            if (a2 instanceof Boolean) {
                z = ((Boolean) Boolean.class.cast(a2)).booleanValue();
            }
        }
        com.xiaomi.channel.commonutils.logger.b.c("color os push  is avaliable ? :".concat(String.valueOf(z)));
        return z;
    }

    public static boolean d(Context context) {
        Object a2 = bi.a("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", context);
        boolean z = false;
        if (a2 != null) {
            z = false;
            if (a2 instanceof Boolean) {
                z = ((Boolean) Boolean.class.cast(a2)).booleanValue();
            }
        }
        com.xiaomi.channel.commonutils.logger.b.c("fun touch os push  is avaliable ? :".concat(String.valueOf(z)));
        return z;
    }
}
