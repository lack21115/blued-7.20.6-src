package com.xiaomi.push;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/q.class */
public class q {
    public static String a(String str, String str2) {
        try {
            return (String) r.a(null, "android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("SystemProperties.get: ".concat(String.valueOf(e)));
            return str2;
        }
    }
}
