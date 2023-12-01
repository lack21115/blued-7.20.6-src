package com.anythink.china.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.china.api.ChinaDeviceDataInfo;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.p;
import java.util.regex.Pattern;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/b/a.class */
public final class a {
    private static String a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static String f = "";
    private static String g = "";
    private static String h = "";
    private static String i = "";
    private static boolean j = false;

    public static String a() {
        return n.a().c(ChinaDeviceDataInfo.MAC) ? "" : a;
    }

    public static void a(final Context context) {
        String b2 = p.b(context, g.o, ChinaDeviceDataInfo.OAID, "");
        c = b2;
        if (TextUtils.isEmpty(b2) && !n.a().c(ChinaDeviceDataInfo.OAID) && TextUtils.isEmpty(c)) {
            com.anythink.china.a.b.a(context, new com.anythink.china.a.a() { // from class: com.anythink.china.b.a.1
                @Override // com.anythink.china.a.a
                public final void a() {
                }

                @Override // com.anythink.china.a.a
                public final void a(String str, boolean z) {
                    if (a.a(str)) {
                        return;
                    }
                    String unused = a.c = str;
                    p.a(context, g.o, ChinaDeviceDataInfo.OAID, str);
                }
            });
        }
        a = n.a().c(ChinaDeviceDataInfo.MAC) ? "" : Build.VERSION.SDK_INT < 23 ? d.a(context) : d.a();
        b = d(context);
        d = b.a();
        String[] c2 = b.c(context);
        if (c2 != null && c2.length == 2) {
            e = c2[0];
            f = c2[1];
        }
        g = b.b();
        h = b.c();
        i = b.d();
    }

    static /* synthetic */ boolean a(String str) {
        return Pattern.matches("^[0-]+$", str);
    }

    public static String b() {
        return n.a().c(ChinaDeviceDataInfo.OAID) ? "" : c;
    }

    public static String b(Context context) {
        d(context);
        if (TextUtils.isEmpty(b)) {
            String c2 = c(context);
            return !TextUtils.isEmpty(c2) ? c2 : "";
        }
        return b;
    }

    public static String c() {
        return n.a().c(ChinaDeviceDataInfo.SSID) ? "" : b.b(n.a().g());
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0079 -> B:25:0x0069). Please submit an issue!!! */
    public static String c(final Context context) {
        if (n.a().c(ChinaDeviceDataInfo.OAID)) {
            return "";
        }
        if (TextUtils.isEmpty(c)) {
            String b2 = p.b(context, g.o, ChinaDeviceDataInfo.OAID, "");
            c = b2;
            if (TextUtils.isEmpty(b2)) {
                final Object obj = new Object();
                final boolean[] zArr = {false};
                com.anythink.china.a.b.a(context, new com.anythink.china.a.a() { // from class: com.anythink.china.b.a.2
                    @Override // com.anythink.china.a.a
                    public final void a() {
                        zArr[0] = true;
                        try {
                            synchronized (obj) {
                                obj.notifyAll();
                            }
                        } catch (Throwable th) {
                        }
                    }

                    @Override // com.anythink.china.a.a
                    public final void a(String str, boolean z) {
                        if (!a.a(str)) {
                            String unused = a.c = str;
                            p.a(context, g.o, ChinaDeviceDataInfo.OAID, str);
                        }
                        try {
                            synchronized (obj) {
                                obj.notifyAll();
                            }
                        } catch (Throwable th) {
                        }
                        zArr[0] = true;
                    }
                });
                if (!zArr[0]) {
                    try {
                        synchronized (obj) {
                            obj.wait(1500L);
                        }
                    } catch (Exception e2) {
                    }
                }
                String str = c;
                return str != null ? str : "";
            }
            return c;
        }
        return c;
    }

    private static boolean c(String str) {
        return Pattern.matches("^[0-]+$", str);
    }

    public static String d() {
        return d;
    }

    public static String d(Context context) {
        synchronized (a.class) {
            try {
                if (n.a().c(ChinaDeviceDataInfo.IMEI)) {
                    return "";
                }
                if (!j && TextUtils.isEmpty(b) && com.anythink.china.common.d.a(context, com.anythink.china.common.d.a)) {
                    b = c.a(context);
                    j = true;
                }
                return b;
            } finally {
            }
        }
    }

    public static String e() {
        return b.a(n.a().g());
    }

    public static String f() {
        return e;
    }

    public static String g() {
        return f;
    }

    public static String h() {
        return g;
    }

    public static String i() {
        return h;
    }

    public static String j() {
        return i;
    }
}
