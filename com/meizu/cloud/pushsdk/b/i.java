package com.meizu.cloud.pushsdk.b;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/i.class */
public class i {
    public static String a(String str) {
        com.meizu.cloud.pushsdk.b.b.d a2 = com.meizu.cloud.pushsdk.b.b.a.a("android.os.SystemProperties").a(MonitorConstants.CONNECT_TYPE_GET, String.class).a(str);
        if (a2.f23973a) {
            return (String) a2.b;
        }
        return null;
    }
}
