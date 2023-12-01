package com.ta.utdid2.a.a;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-8457232-dex2jar.jar:com/ta/utdid2/a/a/h.class */
public class h {
    public static String get(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            return str2;
        }
    }
}
