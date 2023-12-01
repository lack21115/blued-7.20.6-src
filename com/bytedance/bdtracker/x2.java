package com.bytedance.bdtracker;

import android.os.SystemProperties;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/x2.class */
public class x2 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile Object f21336a;

    public final Object a() {
        if (f21336a == null) {
            synchronized (x2.class) {
                try {
                    if (f21336a == null) {
                        f21336a = Class.forName("android.os.SystemProperties").newInstance();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21336a;
    }

    public String a(String str) {
        try {
            return SystemProperties.get(str);
        } catch (Throwable th) {
            z2.a(th);
            try {
                Object a2 = a();
                return (String) a2.getClass().getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(a2, str);
            } catch (Throwable th2) {
                z2.a(th2);
                return "";
            }
        }
    }
}
