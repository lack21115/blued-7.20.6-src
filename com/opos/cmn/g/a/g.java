package com.opos.cmn.g.a;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/g/a/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f11272a = false;
    private static volatile com.opos.cmn.g.a.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/g/a/g$a.class */
    public static class a extends com.opos.cmn.g.a.a {
        private a() {
        }

        @Override // com.opos.cmn.g.a.a
        public String a(Context context) {
            return com.oplus.stdid.sdk.a.c(context);
        }

        @Override // com.opos.cmn.g.a.a
        public boolean a() {
            return com.oplus.stdid.sdk.a.a();
        }

        @Override // com.opos.cmn.g.a.a
        public String b(Context context) {
            return com.oplus.stdid.sdk.a.e(context);
        }

        @Override // com.opos.cmn.g.a.a
        public String c(Context context) {
            return com.oplus.stdid.sdk.a.f(context);
        }

        @Override // com.opos.cmn.g.a.a
        public boolean d(Context context) {
            return com.oplus.stdid.sdk.a.d(context);
        }

        @Override // com.opos.cmn.g.a.a
        public void e(Context context) {
            com.oplus.stdid.sdk.a.b(context);
        }
    }

    private static com.opos.cmn.g.a.a a() {
        com.opos.cmn.g.a.a aVar;
        synchronized (g.class) {
            try {
                if (b == null) {
                    b = new a();
                }
                aVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public static String a(Context context) {
        String str;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            f(context);
            str = a().a() ? a().a(context) : "";
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                com.opos.cmn.an.f.a.b("IdentifierManager", "getGUID costTime=" + (currentTimeMillis2 - currentTimeMillis) + " result=" + str);
                return str;
            } catch (Exception e) {
                e = e;
                com.opos.cmn.an.f.a.c("IdentifierManager", "", e);
                return str;
            }
        } catch (Exception e2) {
            e = e2;
            str = "";
        }
    }

    public static String b(Context context) {
        String str;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            f(context);
            str = a().a() ? a().b(context) : "";
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                com.opos.cmn.an.f.a.b("IdentifierManager", "getOUID costTime=" + (currentTimeMillis2 - currentTimeMillis) + " result=" + str);
                return str;
            } catch (Exception e) {
                e = e;
                com.opos.cmn.an.f.a.c("IdentifierManager", "", e);
                return str;
            }
        } catch (Exception e2) {
            e = e2;
            str = "";
        }
    }

    public static String c(Context context) {
        String str;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            f(context);
            str = a().a() ? a().c(context) : "";
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                com.opos.cmn.an.f.a.b("IdentifierManager", "getDUID costTime=" + (currentTimeMillis2 - currentTimeMillis) + " result=" + str);
                return str;
            } catch (Exception e) {
                e = e;
                com.opos.cmn.an.f.a.c("IdentifierManager", "", e);
                return str;
            }
        } catch (Exception e2) {
            e = e2;
            str = "";
        }
    }

    public static boolean d(Context context) {
        boolean z;
        try {
            f(context);
            z = a().a();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("IdentifierManager", "", e);
            z = false;
        }
        com.opos.cmn.an.f.a.b("IdentifierManager", "isSupportedOpenId " + z);
        return z;
    }

    public static boolean e(Context context) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f(context);
            z = a().d(context);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("IdentifierManager", "", e);
            z = false;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        com.opos.cmn.an.f.a.b("IdentifierManager", "getOUIDStatus costTime=" + (currentTimeMillis2 - currentTimeMillis) + " result=" + z);
        return z;
    }

    private static void f(Context context) {
        if (f11272a) {
            return;
        }
        a().e(context);
        f11272a = true;
    }
}
