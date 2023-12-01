package com.opos.cmn.i;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/i/l.class */
public class l {
    public static final String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("", "", e);
            return null;
        }
    }
}
