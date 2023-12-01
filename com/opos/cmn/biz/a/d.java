package com.opos.cmn.biz.a;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/a/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f10919a = "";

    public static String a(Context context) {
        String str;
        if (com.opos.cmn.an.c.a.a(f10919a)) {
            if (context != null) {
                f10919a = f.b(context);
            }
            if (com.opos.cmn.an.c.a.a(f10919a)) {
                f10919a = com.opos.cmn.an.b.d.c();
                com.opos.cmn.an.f.a.b("RegionTool", "get region by os:" + f10919a);
                if (com.opos.cmn.an.c.a.a(f10919a)) {
                    f10919a = "CN";
                    str = "set default region";
                }
            }
            return f10919a;
        }
        str = "get Region result =" + f10919a;
        com.opos.cmn.an.f.a.b("RegionTool", str);
        return f10919a;
    }

    public static void a(Context context, String str) {
        synchronized (d.class) {
            try {
                if (com.opos.cmn.an.c.a.a(str)) {
                    com.opos.cmn.an.f.a.b("RegionTool", "init, setRegion= null");
                } else {
                    try {
                        String upperCase = str.toUpperCase();
                        if (!com.opos.cmn.an.c.a.a(upperCase) && !upperCase.contentEquals(f10919a)) {
                            f10919a = upperCase;
                            if (context != null) {
                                final Context applicationContext = context.getApplicationContext();
                                new Thread(new Runnable() { // from class: com.opos.cmn.biz.a.d.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        f.b(Context.this, d.f10919a);
                                    }
                                }).start();
                            }
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("RegionTool", "setRegion", e);
                    }
                    com.opos.cmn.an.f.a.b("RegionTool", "init, setRegion=" + str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
