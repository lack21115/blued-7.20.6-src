package com.anythink.china.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.p;
import java.util.regex.Pattern;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/b/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f6268a = "";
    private static String b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f6269c = "";
    private static String d = "";
    private static String e = "";
    private static String f = "";
    private static String g = "";
    private static String h = "";
    private static String i = "";
    private static boolean j = false;

    public static String a() {
        return n.a().c("mac") ? "" : f6268a;
    }

    public static void a(final Context context) {
        String b2 = p.b(context, g.o, "oaid", "");
        f6269c = b2;
        if (TextUtils.isEmpty(b2) && !n.a().c("oaid") && TextUtils.isEmpty(f6269c)) {
            com.anythink.china.a.b.a(context, new com.anythink.china.a.a() { // from class: com.anythink.china.b.a.1
                @Override // com.anythink.china.a.a
                public final void a() {
                }

                @Override // com.anythink.china.a.a
                public final void a(String str, boolean z) {
                    if (a.a(str)) {
                        return;
                    }
                    String unused = a.f6269c = str;
                    p.a(Context.this, g.o, "oaid", str);
                }
            });
        }
        f6268a = n.a().c("mac") ? "" : Build.VERSION.SDK_INT < 23 ? d.a(context) : d.a();
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
        return n.a().c("oaid") ? "" : f6269c;
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
        return n.a().c("wifi_name") ? "" : b.b(n.a().g());
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0079 -> B:25:0x0069). Please submit an issue!!! */
    public static String c(final Context context) {
        if (n.a().c("oaid")) {
            return "";
        }
        if (TextUtils.isEmpty(f6269c)) {
            String b2 = p.b(context, g.o, "oaid", "");
            f6269c = b2;
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
                            String unused = a.f6269c = str;
                            p.a(Context.this, g.o, "oaid", str);
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
                            obj.wait(com.igexin.push.config.c.j);
                        }
                    } catch (Exception e2) {
                    }
                }
                String str = f6269c;
                return str != null ? str : "";
            }
            return f6269c;
        }
        return f6269c;
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
                if (n.a().c("imei")) {
                    return "";
                }
                if (!j && TextUtils.isEmpty(b) && com.anythink.china.common.d.a(context, "android.permission.READ_PHONE_STATE")) {
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
