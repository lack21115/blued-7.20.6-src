package com.igexin.assist.control.meizu;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/control/meizu/i.class */
public class i {
    public static String a(String str) {
        d aa = A.a("android.os.SystemProperties").a(MonitorConstants.CONNECT_TYPE_GET, String.class).aa(str, new Object[0]);
        if (aa.f9579a) {
            return (String) aa.b;
        }
        return null;
    }
}
