package com.opos.cmn.biz.a;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/a/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f24606a = "";

    public static String a(Context context) {
        String str;
        if (com.opos.cmn.an.c.a.a(f24606a)) {
            if (context != null) {
                f24606a = f.b(context);
            }
            if (com.opos.cmn.an.c.a.a(f24606a)) {
                f24606a = com.opos.cmn.an.b.d.c();
                com.opos.cmn.an.f.a.b("RegionTool", "get region by os:" + f24606a);
                if (com.opos.cmn.an.c.a.a(f24606a)) {
                    f24606a = "CN";
                    str = "set default region";
                }
            }
            return f24606a;
        }
        str = "get Region result =" + f24606a;
        com.opos.cmn.an.f.a.b("RegionTool", str);
        return f24606a;
    }

    public static void a(Context context, String str) {
        synchronized (d.class) {
            try {
                if (com.opos.cmn.an.c.a.a(str)) {
                    com.opos.cmn.an.f.a.b("RegionTool", "init, setRegion= null");
                } else {
                    try {
                        String upperCase = str.toUpperCase();
                        if (!com.opos.cmn.an.c.a.a(upperCase) && !upperCase.contentEquals(f24606a)) {
                            f24606a = upperCase;
                            if (context != null) {
                                final Context applicationContext = context.getApplicationContext();
                                new Thread(new Runnable() { // from class: com.opos.cmn.biz.a.d.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        f.b(Context.this, d.f24606a);
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
