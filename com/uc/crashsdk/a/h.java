package com.uc.crashsdk.a;

import android.os.Build;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import com.cdo.oaps.ad.OapsKey;
import com.google.android.material.timepicker.TimeModel;
import com.uc.crashsdk.JNIBridge;
import com.umeng.analytics.pro.bh;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/a/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f26879a = !h.class.desiredAssertionStatus();
    private static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, String> f26880c = new HashMap();
    private static int d = 0;
    private static final Map<String, a> e = new HashMap();
    private static final Object f = new Object();
    private static final Object g = new Object();
    private static final SparseArray<String> h = new SparseArray<>();
    private static boolean i = false;
    private static boolean j = false;
    private static final Object k = new Object();
    private static String l = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/a/h$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        long f26881a = 0;
        int b = 0;

        /* renamed from: c  reason: collision with root package name */
        Map<String, String> f26882c = new HashMap();
        private String d;
        private boolean e;
        private boolean f;

        a(String str, boolean z, boolean z2) {
            this.e = false;
            this.f = false;
            this.d = str;
            this.e = z;
            this.f = z2;
        }

        private long d(String str) {
            return g.c(a(str));
        }

        final String a(String str) {
            return this.f26882c.get(str);
        }

        final String a(boolean z, boolean z2, boolean z3) {
            if (this.d == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (z) {
                h.b(sb, "lt", "uc");
                h.b(sb, "pre", com.uc.crashsdk.g.e());
                h.b(sb, "pkg", com.uc.crashsdk.a.f26866a);
                h.b(sb, "rom", Build.VERSION.RELEASE);
                h.b(sb, "brd", Build.BRAND);
                h.b(sb, "model", Build.MODEL);
                h.a(sb, "sdk", Build.VERSION.SDK_INT);
                h.b(sb, "cpu", com.uc.crashsdk.e.e());
                h.b(sb, "hdw", com.uc.crashsdk.e.f());
                long l = h.l();
                h.a(sb, "ram", l);
                h.b(sb, "aram", h.a(l));
                h.b(sb, "cver", "3.3.2.2");
                h.b(sb, "cseq", "211215141717");
                h.b(sb, "ctag", "release");
                h.b(sb, "aver", com.uc.crashsdk.a.a());
                h.b(sb, "ver", com.uc.crashsdk.g.T());
                h.b(sb, "sver", com.uc.crashsdk.g.U());
                h.b(sb, "seq", com.uc.crashsdk.g.V());
                h.b(sb, "grd", com.uc.crashsdk.b.A() ? "fg" : OapsKey.KEY_BG);
                h.b(sb, bh.x, "android");
                h.b(sb, "dn", com.uc.crashsdk.e.q());
                String ab = com.uc.crashsdk.g.ab();
                String str = ab;
                if (TextUtils.isEmpty(ab)) {
                    str = com.uc.crashsdk.e.q();
                }
                h.b(sb, "k_uid", str);
                String ac = com.uc.crashsdk.g.ac();
                if (!TextUtils.isEmpty(ac)) {
                    h.b(sb, "k_channel", ac);
                }
                sb.append("\n");
            }
            h.b(sb, "lt", this.d);
            h.a(sb, this.f26882c);
            if (this.e && !z2) {
                long j = this.f26881a;
                if (j != 0) {
                    h.b(sb, "up", String.valueOf(j));
                }
                if (z3) {
                    h.b(sb, "pid", String.format(Locale.US, TimeModel.NUMBER_FORMAT, Integer.valueOf(Process.myPid())));
                } else if (this.b != 0) {
                    h.b(sb, "pid", String.format(Locale.US, TimeModel.NUMBER_FORMAT, Integer.valueOf(this.b)));
                }
            }
            sb.append("\n");
            return sb.toString();
        }

        final void a(String str, long j) {
            long d = d(str) + j;
            if (d <= 100) {
                j = d < 0 ? 0L : d;
            }
            a(str, String.valueOf(j));
        }

        final void a(String str, String str2) {
            this.f26882c.put(str, str2);
        }

        final boolean a(a aVar) {
            if (!this.f) {
                com.uc.crashsdk.a.a.a("crashsdk", String.format(Locale.US, "WaItem '%s' is not mergable!", this.d), null);
                return false;
            }
            for (String str : aVar.f26882c.keySet()) {
                if (str.startsWith("c_")) {
                    a(str, aVar.a(str));
                } else {
                    long d = aVar.d(str);
                    if (d == 0) {
                        a(str, aVar.a(str));
                    } else if (d < 100) {
                        a(str, d);
                    }
                }
            }
            return true;
        }

        final String b(String str) {
            String a2 = a(str);
            String str2 = a2;
            if (a2 == null) {
                str2 = "";
            }
            return str2;
        }

        final boolean c(String str) {
            if (g.a(str)) {
                return false;
            }
            long j = 0;
            HashMap hashMap = new HashMap();
            Map c2 = h.c(str);
            int i = 0;
            String str2 = null;
            for (String str3 : c2.keySet()) {
                String str4 = (String) c2.get(str3);
                if (str3.equals("lt")) {
                    str2 = str4;
                } else if (this.e && str3.equals("up")) {
                    j = g.c(str4);
                } else if (this.e && str3.equals("pid")) {
                    i = (int) g.c(str4);
                } else {
                    hashMap.put(str3, str4);
                }
            }
            String str5 = this.d;
            if (str5 == null || str5.equals(str2)) {
                this.f26881a = j;
                this.b = i;
                this.d = str2;
                this.f26882c = hashMap;
                return true;
            }
            return false;
        }
    }

    static /* synthetic */ String a(long j2) {
        return j2 < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED ? "512M" : String.format(Locale.US, "%dG", Long.valueOf(((j2 / 1024) + 512) / 1024));
    }

    private static StringBuilder a(Iterable<a> iterable, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        for (a aVar : iterable) {
            if (z3) {
                sb.append(aVar.a(z, z, z2));
                z3 = false;
            } else {
                sb.append(aVar.a(false, z, z2));
            }
        }
        return sb;
    }

    private static ArrayList<a> a(File file, String str, int i2) {
        ArrayList<String> a2 = g.a(file, i2);
        ArrayList<a> arrayList = new ArrayList<>();
        Iterator<String> it = a2.iterator();
        while (it.hasNext()) {
            String next = it.next();
            a aVar = new a(str, false, false);
            if (aVar.c(next)) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public static void a() {
        a(0, com.uc.crashsdk.b.H() ? 700000L : 70000L);
    }

    private static void a(int i2, long j2) {
        if (com.uc.crashsdk.b.F()) {
            f.a(0, new e(302, new Object[]{Integer.valueOf(i2)}), j2);
        }
    }

    private static void a(int i2, String str) {
        h.put(i2, str);
    }

    private static void a(int i2, boolean z) {
        if (a(z, "crash rate")) {
            return;
        }
        String str = com.uc.crashsdk.g.W() + "cr.wa";
        com.uc.crashsdk.b.a(b, str, new e(351, new Object[]{str, Integer.valueOf(i2)}));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0174, code lost:
        if ((r0.b == android.os.Process.myPid()) == false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0112 A[Catch: all -> 0x0140, TRY_ENTER, TryCatch #0 {, blocks: (B:18:0x0045, B:20:0x0053, B:22:0x0059, B:61:0x013e, B:23:0x005d, B:23:0x005d, B:24:0x0060, B:26:0x0068, B:28:0x0070, B:28:0x0070, B:29:0x0073, B:31:0x0096, B:34:0x00a1, B:40:0x00b5, B:42:0x00c0, B:47:0x00dd, B:50:0x00ed, B:57:0x0112, B:59:0x0130, B:54:0x00ff, B:45:0x00cf), top: B:86:0x0045 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(int r6, java.lang.Object[] r7) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.h.a(int, java.lang.Object[]):void");
    }

    private static void a(a aVar) {
        synchronized (f26880c) {
            for (String str : f26880c.keySet()) {
                aVar.a(str, f26880c.get(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str) {
        synchronized (b) {
            File file = new File(m());
            a aVar = new a("pv", true, true);
            String c2 = g.c(file);
            if (!g.a(c2)) {
                aVar.c(c2);
            }
            aVar.a(str, 1L);
            aVar.a("aujv", 1L);
            g.a(file, aVar.a(false, false, false));
        }
    }

    public static void a(String str, int i2, int i3) {
        if (com.uc.crashsdk.g.Q()) {
            synchronized (f) {
                a aVar = e.get(str);
                a aVar2 = aVar;
                if (aVar == null) {
                    aVar2 = new a("cst", false, true);
                    e.put(str, aVar2);
                    a(aVar2);
                }
                synchronized (h) {
                    if (h.size() == 0) {
                        a(100, "pv");
                        a(102, "hpv");
                        a(1, "all");
                        a(2, "afg");
                        a(101, "abg");
                        a(3, "jfg");
                        a(4, "jbg");
                        a(7, "nfg");
                        a(8, "nbg");
                        a(27, "nafg");
                        a(28, "nabg");
                        a(9, "nho");
                        a(10, "uar");
                        a(29, "ulm");
                        a(30, "ukt");
                        a(31, "uet");
                        a(32, "urs");
                        a(11, "ufg");
                        a(12, "ubg");
                        a(40, "anf");
                        a(41, "anb");
                        a(42, "ancf");
                        a(43, "ancb");
                        a(13, "lup");
                        a(14, "luf");
                        a(15, "lef");
                        a(200, "ltf");
                        a(16, "laf");
                        a(22, "lac");
                        a(23, "lau");
                        a(17, "llf");
                        a(18, "lul");
                        a(19, "lub");
                        a(20, "luc");
                        a(21, "luu");
                        a(24, "lzc");
                        a(201, "lec");
                        a(25, "lrc");
                        a(26, "lss");
                    }
                }
                String str2 = h.get(i2);
                if (str2 == null) {
                    com.uc.crashsdk.a.a.a("crashsdk", "map key is not set with: " + i2, null);
                }
                aVar2.a("prc", str);
                if (str2 != null) {
                    aVar2.a(str2, String.valueOf(i3));
                }
            }
        }
    }

    static /* synthetic */ void a(StringBuilder sb, String str, long j2) {
        b(sb, str, String.valueOf(j2));
    }

    static /* synthetic */ void a(StringBuilder sb, Map map) {
        for (String str : map.keySet()) {
            b(sb, str, (String) map.get(str));
        }
    }

    public static void a(boolean z) {
        a(1, z);
    }

    public static boolean a(String str, String str2) {
        try {
            String str3 = "c_" + str.replaceAll("[^0-9a-zA-Z-_]", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            String replaceAll = g.a(str2) ? "" : str2.replaceAll("[`=]", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            synchronized (f26880c) {
                if (f26880c.get(str3) == null) {
                    if (d >= 20) {
                        return false;
                    }
                    d++;
                }
                f26880c.put(str3, replaceAll);
                return true;
            }
        } catch (Throwable th) {
            g.a(th);
            return false;
        }
    }

    public static boolean a(String str, String str2, boolean z, boolean z2) {
        if (com.uc.crashsdk.g.Q()) {
            return com.uc.crashsdk.b.a(g, n(), new e(353, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}));
        }
        return false;
    }

    public static boolean a(boolean z, String str) {
        if (com.uc.crashsdk.b.d && !z && JNIBridge.nativeIsCrashing()) {
            com.uc.crashsdk.a.a.b("crashsdk", "Native is crashing, skip stat for " + str);
            return true;
        }
        return false;
    }

    public static void b() {
        a(2, 0L);
    }

    private static void b(int i2, long j2) {
        if (com.uc.crashsdk.g.Q()) {
            f.a(1, new e(301, new Object[]{Integer.valueOf(i2)}), j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str) {
        synchronized (k) {
            l = str;
            String k2 = com.uc.crashsdk.b.k();
            b.a(k2, str + "\n");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append("`");
    }

    public static void b(boolean z) {
        if (a(z, "crash detail upload")) {
            return;
        }
        String str = com.uc.crashsdk.g.W() + "dt.wa";
        com.uc.crashsdk.b.a(f, str, new e(352, new Object[]{str}));
        String n = n();
        com.uc.crashsdk.b.a(g, n, new e(354, new Object[]{n}));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(int i2, Object[] objArr) {
        switch (i2) {
            case 351:
                if (f26879a || objArr != null) {
                    String str = (String) objArr[0];
                    int intValue = ((Integer) objArr[1]).intValue();
                    if (intValue == 1) {
                        if (j) {
                            return false;
                        }
                        j = true;
                    }
                    if (com.uc.crashsdk.g.Z()) {
                        File file = new File(str);
                        ArrayList<a> a2 = a(file, "crp", 100);
                        if (intValue != 4) {
                            a aVar = new a("crp", false, false);
                            if (intValue == 1) {
                                aVar.a("et", String.valueOf(com.uc.crashsdk.b.I()));
                                aVar.a("ete", String.valueOf(com.uc.crashsdk.b.J()));
                            } else if (intValue == 3) {
                                aVar.a("et", "1");
                                aVar.a("ete", "1");
                            } else if (intValue == 2) {
                                aVar.a("hpv", "1");
                            }
                            aVar.a("prc", com.uc.crashsdk.e.h());
                            aVar.a("imp", com.uc.crashsdk.b.F() ? "1" : "0");
                            a(aVar);
                            a2.add(0, aVar);
                        }
                        if (a2.isEmpty()) {
                            return true;
                        }
                        boolean c2 = c(com.uc.crashsdk.e.q(), a((Iterable<a>) a2, true, false).toString());
                        g.b(file);
                        if (c2) {
                            return true;
                        }
                        g.a(file, a((Iterable<a>) a2, false, true).toString());
                        return true;
                    }
                    return false;
                }
                throw new AssertionError();
            case 352:
                if (f26879a || objArr != null) {
                    return d((String) objArr[0]);
                }
                throw new AssertionError();
            case 353:
                if (f26879a || objArr != null) {
                    return b((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
                }
                throw new AssertionError();
            case 354:
                if (f26879a || objArr != null) {
                    File file2 = new File((String) objArr[0]);
                    boolean c3 = c(com.uc.crashsdk.e.q(), a((Iterable<a>) a(file2, "cst", 30), true, false).toString());
                    if (c3) {
                        g.b(file2);
                    }
                    return c3;
                }
                throw new AssertionError();
            default:
                return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean b(java.lang.String r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.h.b(java.lang.String, java.lang.String):boolean");
    }

    private static boolean b(String str, String str2, boolean z, boolean z2) {
        a aVar;
        File file = new File(n());
        ArrayList<a> a2 = a(file, "cst", 30);
        String str3 = str + str2;
        Iterator<a> it = a2.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = it.next();
            if (str3.equals(aVar.b("prc") + aVar.b("typ"))) {
                break;
            }
        }
        a aVar2 = aVar;
        if (aVar == null) {
            aVar2 = new a("cst", false, true);
            aVar2.a("prc", str);
            aVar2.a("typ", str2);
            a(aVar2);
            a2.add(aVar2);
        }
        aVar2.a("cnt", 1L);
        if (z) {
            aVar2.a("lim", 1L);
        }
        if (z2) {
            aVar2.a("syu", 1L);
        }
        return g.a(file, a((Iterable<a>) a2, false, false).toString());
    }

    static /* synthetic */ Map c(String str) {
        HashMap hashMap = new HashMap();
        String[] split = str.split("`");
        int length = split.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return hashMap;
            }
            String str2 = split[i3];
            if (str2.length() > 1) {
                String[] split2 = str2.split("=", 3);
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
            i2 = i3 + 1;
        }
    }

    public static void c() {
        a(3, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean c(java.lang.String r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.h.c(java.lang.String, java.lang.String):boolean");
    }

    public static void d() {
        b(2, 2000L);
        a(1, 70000L);
    }

    private static boolean d(String str) {
        File file = new File(str);
        Iterator<a> it = a(file, "cst", 30).iterator();
        while (it.hasNext()) {
            a next = it.next();
            String a2 = next.a("prc");
            if (!g.a(a2)) {
                a aVar = e.get(a2);
                if (aVar != null) {
                    aVar.a(next);
                } else {
                    e.put(a2, next);
                }
            }
        }
        StringBuilder a3 = a((Iterable<a>) e.values(), true, false);
        boolean b2 = com.uc.crashsdk.g.aa() ? b(com.uc.crashsdk.e.q(), a3.toString()) : c(com.uc.crashsdk.e.q(), a3.toString());
        g.b(file);
        if (b2 || g.a(file, a((Iterable<a>) e.values(), false, true).toString())) {
            e.clear();
            return true;
        }
        return true;
    }

    public static boolean e() {
        return j;
    }

    public static void f() {
        b(1, 2000L);
    }

    public static void g() {
        b(3, 0L);
    }

    public static void h() {
        b(4, 0L);
    }

    public static void i() {
        if (com.uc.crashsdk.g.Q()) {
            f.a(1, new e(303));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] j() {
        return new byte[]{Byte.MAX_VALUE, 100, 110, 31};
    }

    public static void k() {
        synchronized (k) {
            l = null;
        }
    }

    static /* synthetic */ long l() {
        return o();
    }

    private static String m() {
        return com.uc.crashsdk.g.W() + "pv.wa";
    }

    private static String n() {
        return com.uc.crashsdk.g.W() + "cdt.wa";
    }

    private static long o() {
        Iterator<String> it = g.a(new File("/proc/meminfo"), 2).iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("MemTotal:")) {
                try {
                    return Long.parseLong(next.replaceAll("\\D+", ""));
                } catch (NumberFormatException e2) {
                    g.a(e2);
                    return 0L;
                }
            }
        }
        return 0L;
    }
}
