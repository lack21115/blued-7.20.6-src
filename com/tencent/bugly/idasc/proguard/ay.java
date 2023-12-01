package com.tencent.bugly.idasc.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.FileObserver;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.idasc.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.idasc.crashreport.crash.jni.NativeCrashHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ay.class */
public final class ay {
    public static ay f;
    public final ActivityManager b;

    /* renamed from: c  reason: collision with root package name */
    final aa f35278c;
    final ak d;
    String e;
    private final Context g;
    private final ac h;
    private final as i;
    private FileObserver k;
    private bg m;
    private int n;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f35277a = new AtomicBoolean(false);
    private final Object j = new Object();
    private boolean l = true;
    private long o = 0;

    public ay(Context context, ac acVar, aa aaVar, ak akVar, as asVar) {
        Context a2 = ap.a(context);
        this.g = a2;
        this.b = (ActivityManager) a2.getSystemService("activity");
        this.e = ap.b(NativeCrashHandler.getDumpFilePath()) ? context.getDir("bugly", 0).getAbsolutePath() : NativeCrashHandler.getDumpFilePath();
        this.f35278c = aaVar;
        this.d = akVar;
        this.h = acVar;
        this.i = asVar;
    }

    private CrashDetailBean a(ax axVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.F = this.f35278c.k();
            crashDetailBean.G = this.f35278c.j();
            crashDetailBean.H = this.f35278c.l();
            crashDetailBean.I = ab.b(this.g);
            crashDetailBean.J = ab.g();
            crashDetailBean.K = ab.h();
            crashDetailBean.b = 3;
            crashDetailBean.e = this.f35278c.g();
            crashDetailBean.f = this.f35278c.o;
            crashDetailBean.g = this.f35278c.q();
            crashDetailBean.m = this.f35278c.f();
            crashDetailBean.n = "ANR_EXCEPTION";
            crashDetailBean.o = axVar.f;
            crashDetailBean.q = axVar.g;
            crashDetailBean.T = new HashMap();
            crashDetailBean.T.put("BUGLY_CR_01", axVar.e);
            int i = -1;
            if (crashDetailBean.q != null) {
                i = crashDetailBean.q.indexOf("\n");
            }
            crashDetailBean.p = i > 0 ? crashDetailBean.q.substring(0, i) : "GET_FAIL";
            crashDetailBean.r = axVar.f35276c;
            if (crashDetailBean.q != null) {
                crashDetailBean.u = ap.c(crashDetailBean.q.getBytes());
            }
            crashDetailBean.z = axVar.b;
            crashDetailBean.A = axVar.f35275a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.L = this.f35278c.s();
            crashDetailBean.h = this.f35278c.p();
            crashDetailBean.i = this.f35278c.A();
            crashDetailBean.v = axVar.d;
            crashDetailBean.P = this.f35278c.u;
            crashDetailBean.Q = this.f35278c.f35211a;
            crashDetailBean.R = this.f35278c.a();
            crashDetailBean.U = this.f35278c.z();
            crashDetailBean.V = this.f35278c.x;
            crashDetailBean.W = this.f35278c.t();
            crashDetailBean.X = this.f35278c.y();
            crashDetailBean.y = ao.a();
            return crashDetailBean;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return crashDetailBean;
        }
    }

    public static ay a() {
        ay ayVar;
        synchronized (ay.class) {
            try {
                ayVar = f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ayVar;
    }

    private static String a(List<ba> list, long j) {
        if (list == null || list.isEmpty()) {
            return "main thread stack not enable";
        }
        StringBuilder sb = new StringBuilder(4096);
        sb.append("\n>>>>> 以下为anr过程中主线程堆栈记录，可根据堆栈出现次数推测在该堆栈阻塞的时间，出现次数越多对anr贡献越大，越可能是造成anr的原因 >>>>>\n");
        sb.append("\n>>>>> Thread Stack Traces Records Start >>>>>\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            ba baVar = list.get(i2);
            sb.append("Thread name:");
            sb.append(baVar.f35284a);
            sb.append("\n");
            long j2 = baVar.b - j;
            String str = j2 <= 0 ? "before " : "after ";
            sb.append("Got ");
            sb.append(str);
            sb.append("anr:");
            sb.append(Math.abs(j2));
            sb.append("ms\n");
            sb.append(baVar.f35285c);
            sb.append("\n");
            if (sb.length() * 2 >= 101376) {
                break;
            }
            i = i2 + 1;
        }
        sb.append("\n<<<<< Thread Stack Traces Records End <<<<<\n");
        return sb.toString();
    }

    static /* synthetic */ void a(ay ayVar) {
        long currentTimeMillis = (at.j + System.currentTimeMillis()) - ap.b();
        am.a(ayVar.e, "bugly_trace_", ".txt", currentTimeMillis);
        am.a(ayVar.e, "manual_bugly_trace_", ".txt", currentTimeMillis);
        am.a(ayVar.e, "main_stack_record_", ".txt", currentTimeMillis);
        am.a(ayVar.e, "main_stack_record_", ".txt.merged", currentTimeMillis);
    }

    private static boolean a(String str, String str2, String str3) {
        TraceFileHelper.a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo == null || readTargetDumpInfo.d == null || readTargetDumpInfo.d.isEmpty()) {
            al.e("not found trace dump for %s", str3);
            return false;
        }
        StringBuilder sb = new StringBuilder(1024);
        String[] strArr = readTargetDumpInfo.d.get("main");
        if (strArr != null && strArr.length >= 3) {
            sb.append("\"main\" tid=");
            sb.append(strArr[2]);
            sb.append(" :\n");
            sb.append(strArr[0]);
            sb.append("\n");
            sb.append(strArr[1]);
            sb.append("\n\n");
        }
        for (Map.Entry<String, String[]> entry : readTargetDumpInfo.d.entrySet()) {
            if (!entry.getKey().equals("main") && entry.getValue() != null && entry.getValue().length >= 3) {
                sb.append("\"");
                sb.append(entry.getKey());
                sb.append("\" tid=");
                sb.append(entry.getValue()[2]);
                sb.append(" :\n");
                sb.append(entry.getValue()[0]);
                sb.append("\n");
                sb.append(entry.getValue()[1]);
                sb.append("\n\n");
            }
        }
        return am.a(str2, sb.toString(), sb.length() * 2);
    }

    private void c() {
        synchronized (this) {
            if (e()) {
                al.d("start when started!", new Object[0]);
                return;
            }
            FileObserver fileObserver = new FileObserver("/data/anr/") { // from class: com.tencent.bugly.idasc.proguard.ay.1
                @Override // android.os.FileObserver
                public final void onEvent(int i, String str) {
                    if (str == null) {
                        return;
                    }
                    final String concat = "/data/anr/".concat(String.valueOf(str));
                    al.d("watching file %s", concat);
                    if (concat.contains("trace")) {
                        ay.this.d.a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.ay.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                ay ayVar = ay.this;
                                String str2 = concat;
                                if (ayVar.a(true)) {
                                    try {
                                        al.c("read trace first dump for create time!", new Object[0]);
                                        TraceFileHelper.a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str2, false);
                                        long j = readFirstDumpInfo != null ? readFirstDumpInfo.f35204c : -1L;
                                        long j2 = j;
                                        if (j == -1) {
                                            al.d("trace dump fail could not get time!", new Object[0]);
                                            j2 = System.currentTimeMillis();
                                        }
                                        if (ayVar.a(j2)) {
                                            return;
                                        }
                                        ayVar.a(j2, str2);
                                    } catch (Throwable th) {
                                        if (!al.a(th)) {
                                            th.printStackTrace();
                                        }
                                        al.e("handle anr error %s", th.getClass().toString());
                                    }
                                }
                            }
                        });
                    } else {
                        al.d("not anr file %s", concat);
                    }
                }
            };
            this.k = fileObserver;
            fileObserver.startWatching();
            al.a("start anr monitor!", new Object[0]);
            this.d.a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.ay.2
                @Override // java.lang.Runnable
                public final void run() {
                    ay.a(ay.this);
                }
            });
        }
    }

    private void c(boolean z) {
        synchronized (this) {
            if (Build.VERSION.SDK_INT <= 19) {
                if (z) {
                    c();
                } else {
                    d();
                }
            } else if (z) {
                g();
            } else {
                h();
            }
        }
    }

    private void d() {
        synchronized (this) {
            if (!e()) {
                al.d("close when closed!", new Object[0]);
                return;
            }
            this.k.stopWatching();
            this.k = null;
            al.d("close anr monitor!", new Object[0]);
        }
    }

    private void d(boolean z) {
        synchronized (this) {
            if (this.l != z) {
                al.a("user change anr %b", Boolean.valueOf(z));
                this.l = z;
            }
        }
    }

    private boolean e() {
        boolean z;
        synchronized (this) {
            z = this.k != null;
        }
        return z;
    }

    private boolean f() {
        boolean z;
        synchronized (this) {
            z = this.l;
        }
        return z;
    }

    private void g() {
        synchronized (this) {
            if (e()) {
                al.d("start when started!", new Object[0]);
            } else if (TextUtils.isEmpty(this.e)) {
            } else {
                synchronized (this.j) {
                    if (this.m == null || !this.m.isAlive()) {
                        bg bgVar = new bg();
                        this.m = bgVar;
                        boolean z = this.f35278c.S;
                        bgVar.b = z;
                        al.c("set record stack trace enable:".concat(String.valueOf(z)), new Object[0]);
                        bg bgVar2 = this.m;
                        StringBuilder sb = new StringBuilder("Bugly-ThreadMonitor");
                        int i = this.n;
                        this.n = i + 1;
                        sb.append(i);
                        bgVar2.setName(sb.toString());
                        this.m.b();
                    }
                }
                FileObserver fileObserver = new FileObserver(this.e) { // from class: com.tencent.bugly.idasc.proguard.ay.3
                    @Override // android.os.FileObserver
                    public final void onEvent(int i2, String str) {
                        if (str == null) {
                            return;
                        }
                        boolean z2 = true;
                        al.d("observe file, dir:%s fileName:%s", ay.this.e, str);
                        if (!str.startsWith("manual_bugly_trace_") || !str.endsWith(".txt")) {
                            z2 = false;
                        }
                        if (!z2) {
                            al.c("not manual trace file, ignore.", new Object[0]);
                        } else if (!ay.this.f35277a.get()) {
                            al.c("proc is not in anr, just ignore", new Object[0]);
                        } else if (ay.this.f35278c.a()) {
                            al.c("Found foreground anr, resend sigquit immediately.", new Object[0]);
                            NativeCrashHandler.getInstance().resendSigquit();
                            long a2 = am.a(str, "manual_bugly_trace_", ".txt");
                            ay.this.a(a2, ay.this.e + BridgeUtil.SPLIT_MARK + str);
                            al.c("Finish handling one anr.", new Object[0]);
                        } else {
                            al.c("Found background anr, resend sigquit later.", new Object[0]);
                            long a3 = am.a(str, "manual_bugly_trace_", ".txt");
                            ay.this.a(a3, ay.this.e + BridgeUtil.SPLIT_MARK + str);
                            al.c("Finish handling one anr, now resend sigquit.", new Object[0]);
                            NativeCrashHandler.getInstance().resendSigquit();
                        }
                    }
                };
                this.k = fileObserver;
                fileObserver.startWatching();
                al.a("startWatchingPrivateAnrDir! dumFilePath is %s", this.e);
                this.d.a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.ay.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        ay.a(ay.this);
                    }
                });
            }
        }
    }

    private void h() {
        synchronized (this) {
            if (!e()) {
                al.d("close when closed!", new Object[0]);
                return;
            }
            synchronized (this.j) {
                if (this.m != null) {
                    this.m.a();
                    this.m = null;
                }
            }
            al.a("stopWatchingPrivateAnrDir", new Object[0]);
            this.k.stopWatching();
            this.k = null;
            al.d("close anr monitor!", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:126:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0085 A[Catch: all -> 0x036c, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x036c, blocks: (B:2:0x0000, B:3:0x001a, B:10:0x0037, B:11:0x003a, B:13:0x005b, B:15:0x0061, B:18:0x006a, B:21:0x0085, B:25:0x00a3, B:28:0x00b5, B:30:0x00c9, B:33:0x00dd, B:35:0x00e7, B:36:0x00f1, B:38:0x00fd, B:39:0x0107, B:41:0x0127, B:43:0x0131, B:49:0x0176, B:51:0x01ca, B:54:0x01db, B:56:0x0222, B:60:0x0264, B:61:0x026c, B:70:0x0286, B:72:0x02a4, B:81:0x02c1, B:83:0x02d7, B:86:0x02f3, B:90:0x031a, B:92:0x0325, B:94:0x032f, B:95:0x033c, B:84:0x02e5, B:57:0x0244, B:79:0x02b8, B:47:0x0167, B:31:0x00d3, B:22:0x0094, B:5:0x001c, B:7:0x0022, B:9:0x0036, B:97:0x033e, B:99:0x0344, B:101:0x0357, B:63:0x026e, B:65:0x0274, B:67:0x0281), top: B:129:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a3 A[Catch: all -> 0x036c, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x036c, blocks: (B:2:0x0000, B:3:0x001a, B:10:0x0037, B:11:0x003a, B:13:0x005b, B:15:0x0061, B:18:0x006a, B:21:0x0085, B:25:0x00a3, B:28:0x00b5, B:30:0x00c9, B:33:0x00dd, B:35:0x00e7, B:36:0x00f1, B:38:0x00fd, B:39:0x0107, B:41:0x0127, B:43:0x0131, B:49:0x0176, B:51:0x01ca, B:54:0x01db, B:56:0x0222, B:60:0x0264, B:61:0x026c, B:70:0x0286, B:72:0x02a4, B:81:0x02c1, B:83:0x02d7, B:86:0x02f3, B:90:0x031a, B:92:0x0325, B:94:0x032f, B:95:0x033c, B:84:0x02e5, B:57:0x0244, B:79:0x02b8, B:47:0x0167, B:31:0x00d3, B:22:0x0094, B:5:0x001c, B:7:0x0022, B:9:0x0036, B:97:0x033e, B:99:0x0344, B:101:0x0357, B:63:0x026e, B:65:0x0274, B:67:0x0281), top: B:129:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b5 A[Catch: all -> 0x036c, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x036c, blocks: (B:2:0x0000, B:3:0x001a, B:10:0x0037, B:11:0x003a, B:13:0x005b, B:15:0x0061, B:18:0x006a, B:21:0x0085, B:25:0x00a3, B:28:0x00b5, B:30:0x00c9, B:33:0x00dd, B:35:0x00e7, B:36:0x00f1, B:38:0x00fd, B:39:0x0107, B:41:0x0127, B:43:0x0131, B:49:0x0176, B:51:0x01ca, B:54:0x01db, B:56:0x0222, B:60:0x0264, B:61:0x026c, B:70:0x0286, B:72:0x02a4, B:81:0x02c1, B:83:0x02d7, B:86:0x02f3, B:90:0x031a, B:92:0x0325, B:94:0x032f, B:95:0x033c, B:84:0x02e5, B:57:0x0244, B:79:0x02b8, B:47:0x0167, B:31:0x00d3, B:22:0x0094, B:5:0x001c, B:7:0x0022, B:9:0x0036, B:97:0x033e, B:99:0x0344, B:101:0x0357, B:63:0x026e, B:65:0x0274, B:67:0x0281), top: B:129:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02d7 A[Catch: all -> 0x036c, TRY_LEAVE, TryCatch #3 {all -> 0x036c, blocks: (B:2:0x0000, B:3:0x001a, B:10:0x0037, B:11:0x003a, B:13:0x005b, B:15:0x0061, B:18:0x006a, B:21:0x0085, B:25:0x00a3, B:28:0x00b5, B:30:0x00c9, B:33:0x00dd, B:35:0x00e7, B:36:0x00f1, B:38:0x00fd, B:39:0x0107, B:41:0x0127, B:43:0x0131, B:49:0x0176, B:51:0x01ca, B:54:0x01db, B:56:0x0222, B:60:0x0264, B:61:0x026c, B:70:0x0286, B:72:0x02a4, B:81:0x02c1, B:83:0x02d7, B:86:0x02f3, B:90:0x031a, B:92:0x0325, B:94:0x032f, B:95:0x033c, B:84:0x02e5, B:57:0x0244, B:79:0x02b8, B:47:0x0167, B:31:0x00d3, B:22:0x0094, B:5:0x001c, B:7:0x0022, B:9:0x0036, B:97:0x033e, B:99:0x0344, B:101:0x0357, B:63:0x026e, B:65:0x0274, B:67:0x0281), top: B:129:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02e5 A[Catch: all -> 0x036c, TRY_ENTER, TryCatch #3 {all -> 0x036c, blocks: (B:2:0x0000, B:3:0x001a, B:10:0x0037, B:11:0x003a, B:13:0x005b, B:15:0x0061, B:18:0x006a, B:21:0x0085, B:25:0x00a3, B:28:0x00b5, B:30:0x00c9, B:33:0x00dd, B:35:0x00e7, B:36:0x00f1, B:38:0x00fd, B:39:0x0107, B:41:0x0127, B:43:0x0131, B:49:0x0176, B:51:0x01ca, B:54:0x01db, B:56:0x0222, B:60:0x0264, B:61:0x026c, B:70:0x0286, B:72:0x02a4, B:81:0x02c1, B:83:0x02d7, B:86:0x02f3, B:90:0x031a, B:92:0x0325, B:94:0x032f, B:95:0x033c, B:84:0x02e5, B:57:0x0244, B:79:0x02b8, B:47:0x0167, B:31:0x00d3, B:22:0x0094, B:5:0x001c, B:7:0x0022, B:9:0x0036, B:97:0x033e, B:99:0x0344, B:101:0x0357, B:63:0x026e, B:65:0x0274, B:67:0x0281), top: B:129:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0325 A[Catch: all -> 0x036c, TryCatch #3 {all -> 0x036c, blocks: (B:2:0x0000, B:3:0x001a, B:10:0x0037, B:11:0x003a, B:13:0x005b, B:15:0x0061, B:18:0x006a, B:21:0x0085, B:25:0x00a3, B:28:0x00b5, B:30:0x00c9, B:33:0x00dd, B:35:0x00e7, B:36:0x00f1, B:38:0x00fd, B:39:0x0107, B:41:0x0127, B:43:0x0131, B:49:0x0176, B:51:0x01ca, B:54:0x01db, B:56:0x0222, B:60:0x0264, B:61:0x026c, B:70:0x0286, B:72:0x02a4, B:81:0x02c1, B:83:0x02d7, B:86:0x02f3, B:90:0x031a, B:92:0x0325, B:94:0x032f, B:95:0x033c, B:84:0x02e5, B:57:0x0244, B:79:0x02b8, B:47:0x0167, B:31:0x00d3, B:22:0x0094, B:5:0x001c, B:7:0x0022, B:9:0x0036, B:97:0x033e, B:99:0x0344, B:101:0x0357, B:63:0x026e, B:65:0x0274, B:67:0x0281), top: B:129:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x033d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(long r9, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 932
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.ay.a(long, java.lang.String):void");
    }

    public final boolean a(long j) {
        if (Math.abs(j - this.o) < 10000) {
            al.d("should not process ANR too Fre in %dms", 10000);
            return true;
        }
        this.o = j;
        return false;
    }

    public final boolean a(boolean z) {
        boolean compareAndSet = this.f35277a.compareAndSet(!z, z);
        al.c("tryChangeAnrState to %s, success:%s", Boolean.valueOf(z), Boolean.valueOf(compareAndSet));
        return compareAndSet;
    }

    public final void b() {
        synchronized (this) {
            al.d("customer decides whether to open or close.", new Object[0]);
        }
    }

    public final void b(boolean z) {
        d(z);
        boolean f2 = f();
        ac a2 = ac.a();
        boolean z2 = f2;
        if (a2 != null) {
            z2 = f2 && a2.c().f;
        }
        if (z2 != e()) {
            al.a("anr changed to %b", Boolean.valueOf(z2));
            c(z2);
        }
    }
}
