package com.oplus.log.d;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/d/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f10668a = {null, null, null, null, null, null, null, null, null, null, "9.0", "9.5", "10.0", "10.5", null};

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/log/d/d$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f10669a = d.b("ro.rom.version");
    }

    public static int a() {
        int i;
        Log.v("BrandPBuild", " getOSVERSION " + a.f10669a);
        int length = f10668a.length;
        int i2 = 2;
        while (true) {
            i = length - i2;
            if (i < 0) {
                return 0;
            }
            Log.v("BrandPBuild", " VERSIONS[ " + i + "]" + f10668a[i]);
            if (!TextUtils.isEmpty(a.f10669a) && !TextUtils.isEmpty(f10668a[i])) {
                if (!a.f10669a.startsWith(f10668a[i])) {
                    String str = a.f10669a;
                    if (str.startsWith(g.o + f10668a[i])) {
                        break;
                    }
                    String str2 = a.f10669a;
                    if (str2.startsWith(g.p + f10668a[i])) {
                        break;
                    }
                } else {
                    break;
                }
            }
            length = i;
            i2 = 1;
        }
        return i + 1;
    }

    public static String b() {
        return b("ro.rom.version");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e) {
            if (com.oplus.log.b.a()) {
                e.printStackTrace();
                return "unknown";
            }
            return "unknown";
        }
    }
}
