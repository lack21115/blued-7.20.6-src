package com.opos.cmn.g.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.g.a.f;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/g/a/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f24954a = new byte[0];
    private static volatile boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static volatile f.a f24955c;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0034 -> B:14:0x0037). Please submit an issue!!! */
    public static String a(Context context) {
        String str;
        try {
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("GAIDUtils", "", e);
        }
        if (f24955c == null || TextUtils.isEmpty(f24955c.a())) {
            if (context != null) {
                str = i.d(context);
            }
            str = "";
        } else {
            str = f24955c.a();
        }
        com.opos.cmn.an.f.a.b("GAIDUtils", "getGAID " + str);
        if (!b) {
            b(context);
        }
        return str != null ? str : "";
    }

    public static void b(Context context) {
        synchronized (e.class) {
            try {
                if (context != null) {
                    try {
                        final Context applicationContext = context.getApplicationContext();
                        b = true;
                        new Thread(new Runnable() { // from class: com.opos.cmn.g.a.e.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    synchronized (e.f24954a) {
                                        com.opos.cmn.an.f.a.b("GAIDUtils", "updateGAID begin!");
                                        f.a a2 = f.a(Context.this);
                                        if (a2 != null) {
                                            f.a unused = e.f24955c = a2;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("updateGAID gaid:");
                                            sb.append(e.f24955c.a());
                                            sb.append(" gaidStatus:");
                                            sb.append(!e.f24955c.b());
                                            com.opos.cmn.an.f.a.b("GAIDUtils", sb.toString());
                                        }
                                        if (e.f24955c != null) {
                                            if (!TextUtils.isEmpty(e.f24955c.a())) {
                                                i.d(Context.this, e.f24955c.a());
                                            }
                                            i.b(Context.this, !a2.b());
                                        }
                                        com.opos.cmn.an.f.a.b("GAIDUtils", "updateGAID end!");
                                    }
                                } catch (Exception e) {
                                    com.opos.cmn.an.f.a.c("GAIDUtils", "", e);
                                }
                            }
                        }).start();
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.c("GAIDUtils", "", e);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
