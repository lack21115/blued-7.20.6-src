package com.tencent.qimei.c;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import com.heytap.baselib.utils.OptvDevUtil;
import com.tencent.qimei.beaconid.U;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/c/c.class */
public class c {

    /* renamed from: a */
    public static final c f38318a = new c();

    /* renamed from: c */
    public long f38319c;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public long d = 0;
    public Enumeration<NetworkInterface> o = null;
    public final Context b = com.tencent.qimei.u.d.b().J();

    public c() {
        v();
    }

    public static /* synthetic */ long a(c cVar) {
        return cVar.f38319c;
    }

    public static /* synthetic */ String a(c cVar, String str) {
        cVar.h = str;
        return str;
    }

    public static c j() {
        c cVar;
        synchronized (c.class) {
            try {
                cVar = f38318a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a() {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.c.c.a():boolean");
    }

    public String b() {
        synchronized (this) {
            String str = this.e;
            if (str != null) {
                return str;
            }
            String str2 = "";
            Context context = this.b;
            if (context == null) {
                return "";
            }
            try {
                str2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Exception e) {
                com.tencent.qimei.k.a.a(e);
            }
            String lowerCase = str2 != null ? str2.toLowerCase() : "";
            this.e = lowerCase;
            return lowerCase;
        }
    }

    public String c() {
        String str;
        synchronized (this) {
            if (this.j == null) {
                this.j = com.tencent.qimei.a.a.a(Build.VERSION.SDK_INT);
            }
            str = this.j;
        }
        return str;
    }

    public String d() {
        synchronized (this) {
            String str = this.k;
            if (str != null) {
                return str;
            }
            String str2 = Build.MODEL;
            this.k = str2;
            return str2;
        }
    }

    public String e() {
        synchronized (this) {
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String f() {
        /*
            Method dump skipped, instructions count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.c.c.f():java.lang.String");
    }

    public String g() {
        boolean z;
        try {
            UiModeManager uiModeManager = (UiModeManager) this.b.getSystemService(Context.UI_MODE_SERVICE);
            if (uiModeManager == null && a()) {
                return OptvDevUtil.TYPE_TV;
            }
            int currentModeType = uiModeManager.getCurrentModeType();
            if (((UiModeManager) this.b.getSystemService(Context.UI_MODE_SERVICE)).getCurrentModeType() == 4) {
                z = true;
            } else {
                if (Build.VERSION.SDK_INT >= 21) {
                    z = true;
                    if (!this.b.getPackageManager().hasSystemFeature(PackageManager.FEATURE_TELEVISION)) {
                        if (this.b.getPackageManager().hasSystemFeature(PackageManager.FEATURE_LEANBACK)) {
                            z = true;
                        }
                    }
                }
                z = false;
            }
            return z ? OptvDevUtil.TYPE_TV : currentModeType == 6 ? "WATCH" : currentModeType == 3 ? "CAR" : (this.b.getResources().getConfiguration().screenLayout & 15) >= 3 ? "Pad" : "Phone";
        } catch (Throwable th) {
            if (a()) {
                return OptvDevUtil.TYPE_TV;
            }
            com.tencent.qimei.k.a.a(th);
            return "Phone";
        }
    }

    public String h() {
        return "";
    }

    public String i() {
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x000f, code lost:
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x001b, code lost:
        if (r0.hasMoreElements() == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x001e, code lost:
        r0 = r0.nextElement().getInetAddresses();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0031, code lost:
        if (r0.hasMoreElements() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0034, code lost:
        r0 = r0.nextElement();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0042, code lost:
        if (r0.isLoopbackAddress() != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0049, code lost:
        if ((r0 instanceof java.net.Inet4Address) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x004c, code lost:
        r4 = r0.getHostAddress();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0054, code lost:
        r3.i = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0067, code lost:
        r4 = "0.0.0.0";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String k() {
        /*
            r3 = this;
            r0 = r3
            monitor-enter(r0)
            r0 = r3
            java.lang.String r0 = r0.i     // Catch: java.lang.Throwable -> L62
            if (r0 != 0) goto L59
            r0 = r3
            java.util.Enumeration r0 = r0.n()     // Catch: java.lang.Throwable -> L62
            r4 = r0
            r0 = r4
            if (r0 != 0) goto L15
            goto L67
        L15:
            r0 = r4
            boolean r0 = r0.hasMoreElements()     // Catch: java.lang.Throwable -> L62
            if (r0 == 0) goto L67
            r0 = r4
            java.lang.Object r0 = r0.nextElement()     // Catch: java.lang.Throwable -> L62
            java.net.NetworkInterface r0 = (java.net.NetworkInterface) r0     // Catch: java.lang.Throwable -> L62
            java.util.Enumeration r0 = r0.getInetAddresses()     // Catch: java.lang.Throwable -> L62
            r5 = r0
        L2b:
            r0 = r5
            boolean r0 = r0.hasMoreElements()     // Catch: java.lang.Throwable -> L62
            if (r0 == 0) goto L15
            r0 = r5
            java.lang.Object r0 = r0.nextElement()     // Catch: java.lang.Throwable -> L62
            java.net.InetAddress r0 = (java.net.InetAddress) r0     // Catch: java.lang.Throwable -> L62
            r6 = r0
            r0 = r6
            boolean r0 = r0.isLoopbackAddress()     // Catch: java.lang.Throwable -> L62
            if (r0 != 0) goto L2b
            r0 = r6
            boolean r0 = r0 instanceof java.net.Inet4Address     // Catch: java.lang.Throwable -> L62
            if (r0 == 0) goto L2b
            r0 = r6
            java.lang.String r0 = r0.getHostAddress()     // Catch: java.lang.Throwable -> L62
            r4 = r0
            goto L54
        L54:
            r0 = r3
            r1 = r4
            r0.i = r1     // Catch: java.lang.Throwable -> L62
        L59:
            r0 = r3
            java.lang.String r0 = r0.i     // Catch: java.lang.Throwable -> L62
            r4 = r0
            r0 = r3
            monitor-exit(r0)
            r0 = r4
            return r0
        L62:
            r4 = move-exception
            r0 = r3
            monitor-exit(r0)
            r0 = r4
            throw r0
        L67:
            java.lang.String r0 = "0.0.0.0"
            r4 = r0
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.c.c.k():java.lang.String");
    }

    public String l() {
        synchronized (this) {
        }
        return "";
    }

    public String m() {
        String str = this.g;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public final Enumeration<NetworkInterface> n() {
        Enumeration<NetworkInterface> enumeration;
        synchronized (this) {
            if (this.o == null) {
                try {
                    this.o = NetworkInterface.getNetworkInterfaces();
                } catch (SocketException e) {
                    com.tencent.qimei.k.a.a(e);
                }
            }
            enumeration = this.o;
        }
        return enumeration;
    }

    public String o() {
        String str;
        String o;
        synchronized (this) {
            if (this.m == null) {
                if (U.f38315a) {
                    try {
                        o = U.o();
                    } catch (UnsatisfiedLinkError e) {
                        e.printStackTrace();
                    }
                    this.m = o;
                }
                o = "";
                this.m = o;
            }
            str = this.m;
        }
        return str;
    }

    public String p() {
        synchronized (this) {
            String str = this.f;
            if (str != null) {
                return str;
            }
            String str2 = "Android " + Build.VERSION.RELEASE + ",level " + Build.VERSION.SDK;
            this.f = str2;
            return str2;
        }
    }

    public String q() {
        String str;
        String z;
        synchronized (this) {
            if (this.l == null) {
                Context context = this.b;
                if (U.f38315a) {
                    try {
                        z = U.z(context);
                    } catch (UnsatisfiedLinkError e) {
                        e.printStackTrace();
                    }
                    this.l = z;
                }
                z = "";
                this.l = z;
            }
            str = this.l;
        }
        return str;
    }

    public byte r() {
        return (byte) 1;
    }

    public String s() {
        if (U.f38315a) {
            try {
                return U.s();
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public String t() {
        String str;
        String u;
        synchronized (this) {
            if (this.n == null) {
                if (U.f38315a) {
                    try {
                        u = U.u();
                    } catch (UnsatisfiedLinkError e) {
                        e.printStackTrace();
                    }
                    this.n = u;
                }
                u = "";
                this.n = u;
            }
            str = this.n;
        }
        return str;
    }

    public boolean u() {
        String str = (String) com.tencent.qimei.a.a.a("com.huawei.system.BuildEx", "getOsBrand", new Class[0], new Object[0]);
        if (str == null) {
            return false;
        }
        return "harmony".equalsIgnoreCase(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x00a4, code lost:
        if (r0.getType() == 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x00a7, code lost:
        r6 = "mobile";
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x007a, code lost:
        if (r6.hasTransport(0) != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void v() {
        /*
            Method dump skipped, instructions count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.c.c.v():void");
    }
}
