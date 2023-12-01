package com.opos.cmn.g.a;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/g/a/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11273a = h.class.getSimpleName();
    private static final byte[] b = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f11274c = new byte[0];
    private static volatile long d = 0;
    private static volatile String e = "";
    private static volatile String f = "";
    private static volatile String g = "";
    private static volatile boolean h = false;
    private static volatile boolean i = false;

    public static void a(Context context) {
        synchronized (h.class) {
            if (context != null) {
                try {
                    final Context applicationContext = context.getApplicationContext();
                    i = true;
                    new Thread(new Runnable() { // from class: com.opos.cmn.g.a.h.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                synchronized (h.b) {
                                    com.opos.cmn.an.f.a.b(h.f11273a, "updateOpenId begin!");
                                    String b2 = g.b(Context.this);
                                    String c2 = g.c(Context.this);
                                    String a2 = g.a(Context.this);
                                    if (!TextUtils.isEmpty(b2)) {
                                        String unused = h.e = b2;
                                        i.a(Context.this, h.e);
                                    }
                                    if (!TextUtils.isEmpty(c2)) {
                                        String unused2 = h.f = c2;
                                        i.b(Context.this, h.f);
                                    }
                                    if (!TextUtils.isEmpty(a2)) {
                                        String unused3 = h.g = a2;
                                        i.c(Context.this, h.g);
                                    }
                                    com.opos.cmn.an.f.a.b(h.f11273a, "updateOpenId end!");
                                }
                            } catch (Exception e2) {
                                com.opos.cmn.an.f.a.c(h.f11273a, "", e2);
                            }
                        }
                    }).start();
                } finally {
                }
            }
        }
    }

    public static void b(Context context) {
        if (context != null) {
            final Context applicationContext = context.getApplicationContext();
            if (System.currentTimeMillis() >= d + 5000) {
                new Thread(new Runnable() { // from class: com.opos.cmn.g.a.h.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            synchronized (h.f11274c) {
                                com.opos.cmn.an.f.a.b(h.f11273a, "updateOUIDStatus begin!");
                                boolean unused = h.h = g.e(Context.this);
                                i.a(Context.this, h.h);
                                long unused2 = h.d = System.currentTimeMillis();
                                String str = h.f11273a;
                                com.opos.cmn.an.f.a.b(str, "updateOUIDStatus end! OUIDStatus=" + h.h + " sLastUpdateOUIDStatusTime=" + h.d);
                            }
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.c(h.f11273a, "", e2);
                        }
                    }
                }).start();
            }
        }
    }

    public static String c(Context context) {
        if (context != null && TextUtils.isEmpty(e)) {
            e = i.a(context);
        }
        String str = f11273a;
        com.opos.cmn.an.f.a.b(str, "getOUID " + e);
        if (!i) {
            a(context);
        }
        return e;
    }

    public static String d(Context context) {
        if (context != null && TextUtils.isEmpty(f)) {
            f = i.b(context);
        }
        String str = f11273a;
        com.opos.cmn.an.f.a.b(str, "getDUID " + f);
        if (!i) {
            a(context);
        }
        return f;
    }

    public static String e(Context context) {
        if (context != null && TextUtils.isEmpty(g)) {
            g = i.c(context);
        }
        String str = f11273a;
        com.opos.cmn.an.f.a.b(str, "getGUID " + g);
        if (!i) {
            a(context);
        }
        return g;
    }

    public static boolean f(Context context) {
        if (context != null) {
            h = i.e(context);
        }
        String str = f11273a;
        com.opos.cmn.an.f.a.b(str, "getOUIDStatus " + h);
        return h;
    }
}
