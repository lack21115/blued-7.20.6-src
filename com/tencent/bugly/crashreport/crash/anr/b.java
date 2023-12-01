package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.anythink.expressad.video.module.a.a.m;
import com.sobot.chat.camera.StCameraView;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/crash/anr/b.class */
public final class b implements ac {
    private static b m;

    /* renamed from: c  reason: collision with root package name */
    private final Context f21462c;
    private final com.tencent.bugly.crashreport.common.info.a d;
    private final w e;
    private String f;
    private final com.tencent.bugly.crashreport.crash.b g;
    private FileObserver h;
    private ab j;
    private int k;

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f21461a = new AtomicInteger(0);
    private long b = -1;
    private boolean i = true;
    private ActivityManager.ProcessErrorStateInfo l = new ActivityManager.ProcessErrorStateInfo();

    private b(Context context, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2, w wVar, com.tencent.bugly.crashreport.crash.b bVar) {
        this.f21462c = z.a(context);
        this.f = context.getDir("bugly", 0).getAbsolutePath();
        this.d = aVar2;
        this.e = wVar;
        this.g = bVar;
    }

    private ActivityManager.ProcessErrorStateInfo a(Context context, long j) {
        try {
            x.c("to find!", new Object[0]);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int i = 0;
            while (true) {
                int i2 = i;
                x.c("waiting!", new Object[0]);
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2) {
                            x.c("found!", new Object[0]);
                            return processErrorStateInfo;
                        }
                    }
                }
                z.b(500L);
                if (i2 >= 20) {
                    x.c("end!", new Object[0]);
                    return null;
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            x.b(e);
            return null;
        } catch (OutOfMemoryError e2) {
            this.l.pid = Process.myPid();
            ActivityManager.ProcessErrorStateInfo processErrorStateInfo2 = this.l;
            processErrorStateInfo2.shortMsg = "bugly sdk waitForAnrProcessStateChanged encount error:" + e2.getMessage();
            return this.l;
        }
    }

    private CrashDetailBean a(a aVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.i();
            crashDetailBean.F = this.d.k();
            crashDetailBean.G = this.d.j();
            crashDetailBean.H = this.d.l();
            if (!com.tencent.bugly.crashreport.common.info.b.m()) {
                crashDetailBean.w = z.a(this.f21462c, c.e, (String) null);
            }
            crashDetailBean.b = 3;
            crashDetailBean.e = this.d.h();
            crashDetailBean.f = this.d.k;
            crashDetailBean.g = this.d.q();
            crashDetailBean.m = this.d.g();
            crashDetailBean.n = "ANR_EXCEPTION";
            crashDetailBean.o = aVar.f;
            crashDetailBean.q = aVar.g;
            crashDetailBean.P = new HashMap();
            crashDetailBean.P.put("BUGLY_CR_01", aVar.e);
            int i = -1;
            if (crashDetailBean.q != null) {
                i = crashDetailBean.q.indexOf("\n");
            }
            crashDetailBean.p = i > 0 ? crashDetailBean.q.substring(0, i) : "GET_FAIL";
            crashDetailBean.r = aVar.f21460c;
            if (crashDetailBean.q != null) {
                crashDetailBean.u = z.a(crashDetailBean.q.getBytes());
            }
            crashDetailBean.z = aVar.b;
            crashDetailBean.A = aVar.f21459a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.I = this.d.s();
            crashDetailBean.h = this.d.p();
            crashDetailBean.i = this.d.B();
            crashDetailBean.v = aVar.d;
            crashDetailBean.L = this.d.o;
            crashDetailBean.M = this.d.f21438a;
            crashDetailBean.N = this.d.a();
            if (!com.tencent.bugly.crashreport.common.info.b.m()) {
                this.g.d(crashDetailBean);
            }
            crashDetailBean.Q = this.d.z();
            crashDetailBean.R = this.d.A();
            crashDetailBean.S = this.d.t();
            crashDetailBean.T = this.d.y();
            crashDetailBean.y = y.a();
            return crashDetailBean;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return crashDetailBean;
        }
    }

    public static b a(Context context, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2, w wVar, p pVar, com.tencent.bugly.crashreport.crash.b bVar, BuglyStrategy.a aVar3) {
        if (m == null) {
            m = new b(context, aVar, aVar2, wVar, bVar);
        }
        return m;
    }

    private boolean a(Context context, String str, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j, Map<String, String> map) {
        a aVar = new a();
        aVar.f21460c = j;
        aVar.f21459a = processErrorStateInfo != null ? processErrorStateInfo.processName : AppInfo.a(Process.myPid());
        aVar.f = processErrorStateInfo != null ? processErrorStateInfo.shortMsg : "";
        aVar.e = processErrorStateInfo != null ? processErrorStateInfo.longMsg : "";
        aVar.b = map;
        Thread thread = Looper.getMainLooper().getThread();
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (next.startsWith(thread.getName())) {
                    aVar.g = map.get(next);
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(aVar.g)) {
            aVar.g = "main stack is null , some error may be encountered.";
        }
        x.c("anr tm:%d\ntr:%s\nproc:%s\nmain stack:%s\nsMsg:%s\n lMsg:%s\n threads:%d", Long.valueOf(aVar.f21460c), aVar.d, aVar.f21459a, aVar.g, aVar.f, aVar.e, Integer.valueOf(aVar.b == null ? 0 : aVar.b.size()));
        x.a("found visiable anr , start to upload!", new Object[0]);
        CrashDetailBean a2 = a(aVar);
        if (a2 == null) {
            x.e("pack anr fail!", new Object[0]);
            return false;
        }
        c.a().a(a2);
        if (a2.f21450a >= 0) {
            x.a("backup anr record success!", new Object[0]);
        } else {
            x.d("backup anr record fail!", new Object[0]);
        }
        if (str == null || !new File(str).exists()) {
            File h = h();
            x.a("traceFile is %s", h);
            if (h != null) {
                a2.v = h.getAbsolutePath();
            }
        } else {
            String str2 = this.f;
            aVar.d = new File(str2, "bugly_trace_" + j + ".txt").getAbsolutePath();
            this.f21461a.set(3);
            if (a(str, aVar.d, aVar.f21459a)) {
                x.a("backup trace success", new Object[0]);
            }
        }
        com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), aVar.f21459a, "main", aVar.g, a2);
        if (!this.g.a(a2)) {
            this.g.a(a2, m.ag, true);
        }
        this.g.c(a2);
        return true;
    }

    private static boolean a(String str, String str2, String str3) {
        BufferedWriter bufferedWriter;
        IOException e;
        Throwable th;
        TraceFileHelper.a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo == null || readTargetDumpInfo.d == null || readTargetDumpInfo.d.size() <= 0) {
            x.e("not found trace dump for %s", str3);
            return false;
        }
        File file = new File(str2);
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            if (!file.exists() || !file.canWrite()) {
                x.e("backup file create fail %s", str2);
                return false;
            }
            try {
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                    try {
                        String[] strArr = readTargetDumpInfo.d.get("main");
                        if (strArr != null && strArr.length >= 3) {
                            String str4 = strArr[0];
                            String str5 = strArr[1];
                            bufferedWriter.write("\"main\" tid=" + strArr[2] + " :\n" + str4 + "\n" + str5 + "\n\n");
                            bufferedWriter.flush();
                        }
                        for (Map.Entry<String, String[]> entry : readTargetDumpInfo.d.entrySet()) {
                            if (!entry.getKey().equals("main")) {
                                if (entry.getValue() != null && entry.getValue().length >= 3) {
                                    String str6 = entry.getValue()[0];
                                    String str7 = entry.getValue()[1];
                                    bufferedWriter.write("\"" + entry.getKey() + "\" tid=" + entry.getValue()[2] + " :\n" + str6 + "\n" + str7 + "\n\n");
                                    bufferedWriter.flush();
                                }
                            }
                        }
                        try {
                            bufferedWriter.close();
                            return true;
                        } catch (IOException e2) {
                            if (x.a(e2)) {
                                return true;
                            }
                            e2.printStackTrace();
                            return true;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        if (!x.a(e)) {
                            BufferedWriter bufferedWriter2 = bufferedWriter;
                            e.printStackTrace();
                        }
                        BufferedWriter bufferedWriter3 = bufferedWriter;
                        StringBuilder sb = new StringBuilder();
                        BufferedWriter bufferedWriter4 = bufferedWriter;
                        sb.append(e.getClass().getName());
                        BufferedWriter bufferedWriter5 = bufferedWriter;
                        sb.append(":");
                        BufferedWriter bufferedWriter6 = bufferedWriter;
                        sb.append(e.getMessage());
                        BufferedWriter bufferedWriter7 = bufferedWriter;
                        x.e("dump trace fail %s", sb.toString());
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                                return false;
                            } catch (IOException e4) {
                                if (x.a(e4)) {
                                    return false;
                                }
                                e4.printStackTrace();
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e5) {
                                if (!x.a(e5)) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    bufferedWriter = null;
                    e = e6;
                }
            } catch (Throwable th3) {
                bufferedWriter = null;
                th = th3;
            }
        } catch (Exception e7) {
            if (!x.a(e7)) {
                e7.printStackTrace();
            }
            x.e("backup file create error! %s  %s", e7.getClass().getName() + ":" + e7.getMessage(), str2);
            return false;
        }
    }

    private void b(boolean z) {
        synchronized (this) {
            if (Build.VERSION.SDK_INT <= 19) {
                if (z) {
                    d();
                } else {
                    e();
                }
            } else if (z) {
                i();
            } else {
                j();
            }
        }
    }

    private void c(boolean z) {
        synchronized (this) {
            if (this.i != z) {
                x.a("user change anr %b", Boolean.valueOf(z));
                this.i = z;
            }
        }
    }

    private void d() {
        synchronized (this) {
            if (f()) {
                x.d("start when started!", new Object[0]);
                return;
            }
            FileObserver fileObserver = new FileObserver("/data/anr/", 8) { // from class: com.tencent.bugly.crashreport.crash.anr.b.1
                @Override // android.os.FileObserver
                public final void onEvent(int i, String str) {
                    if (str == null) {
                        return;
                    }
                    String str2 = "/data/anr/" + str;
                    x.d("watching file %s", str2);
                    if (str2.contains("trace")) {
                        b.this.a(str2);
                    } else {
                        x.d("not anr file %s", str2);
                    }
                }
            };
            this.h = fileObserver;
            fileObserver.startWatching();
            x.a("start anr monitor!", new Object[0]);
            this.e.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.b();
                }
            });
        }
    }

    private void e() {
        synchronized (this) {
            if (!f()) {
                x.d("close when closed!", new Object[0]);
                return;
            }
            this.h.stopWatching();
            this.h = null;
            x.d("close anr monitor!", new Object[0]);
        }
    }

    private boolean f() {
        boolean z;
        synchronized (this) {
            z = this.h != null;
        }
        return z;
    }

    private boolean g() {
        boolean z;
        synchronized (this) {
            z = this.i;
        }
        return z;
    }

    private File h() {
        int indexOf;
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(this.f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int length = listFiles.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            return null;
                        }
                        File file2 = listFiles[i2];
                        String name = file2.getName();
                        if (name.startsWith("bugly_trace_") && (indexOf = name.indexOf(".txt")) > 0) {
                            long parseLong = Long.parseLong(name.substring(12, indexOf));
                            long j = (currentTimeMillis - parseLong) / 1000;
                            x.c("current time %d trace time is %d s", Long.valueOf(currentTimeMillis), Long.valueOf(parseLong));
                            x.c("current time minus trace time is %d s", Long.valueOf(j));
                            if (j < 30) {
                                return file2;
                            }
                        }
                        i = i2 + 1;
                    }
                }
                return null;
            } catch (Throwable th) {
                x.a(th);
                return null;
            }
        }
        return null;
    }

    private void i() {
        synchronized (this) {
            if (f()) {
                x.d("start when started!", new Object[0]);
            } else if (TextUtils.isEmpty(this.f)) {
            } else {
                if (this.j == null || !this.j.isAlive()) {
                    ab abVar = new ab();
                    this.j = abVar;
                    StringBuilder sb = new StringBuilder("Bugly-ThreadMonitor");
                    int i = this.k;
                    this.k = i + 1;
                    sb.append(i);
                    abVar.setName(sb.toString());
                    this.j.a();
                    this.j.a(this);
                    this.j.d();
                    if (this.e != null) {
                        this.e.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.3
                            @Override // java.lang.Runnable
                            public final void run() {
                                b.this.b();
                            }
                        });
                    }
                }
                FileObserver fileObserver = new FileObserver(this.f, 256) { // from class: com.tencent.bugly.crashreport.crash.anr.b.4
                    @Override // android.os.FileObserver
                    public final void onEvent(int i2, String str) {
                        if (str == null) {
                            return;
                        }
                        x.d("startWatchingPrivateAnrDir %s", str);
                        String str2 = "/data/anr/" + str;
                        if (!str2.contains("trace")) {
                            x.d("not anr file %s", str2);
                        } else if (b.this.j != null) {
                            b.this.j.a(true);
                        }
                    }
                };
                this.h = fileObserver;
                fileObserver.startWatching();
                x.a("startWatchingPrivateAnrDir! dumFilePath is %s", this.f);
                this.e.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.b();
                    }
                });
            }
        }
    }

    private void j() {
        synchronized (this) {
            if (!f()) {
                x.d("close when closed!", new Object[0]);
                return;
            }
            if (this.j != null) {
                this.j.c();
                this.j.b();
                this.j.b(this);
                this.j = null;
            }
            x.a("stopWatchingPrivateAnrDir", new Object[0]);
            this.h.stopWatching();
            this.h = null;
            x.d("close anr monitor!", new Object[0]);
        }
    }

    public final void a(String str) {
        synchronized (this) {
            if (this.f21461a.get() != 0) {
                x.c("trace started return ", new Object[0]);
                return;
            }
            this.f21461a.set(1);
            try {
                x.c("read trace first dump for create time!", new Object[0]);
                TraceFileHelper.a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                long j = readFirstDumpInfo != null ? readFirstDumpInfo.f21458c : -1L;
                long j2 = j;
                if (j == -1) {
                    x.d("trace dump fail could not get time!", new Object[0]);
                    j2 = System.currentTimeMillis();
                }
                if (Math.abs(j2 - this.b) < 10000) {
                    x.d("should not process ANR too Fre in %d", 10000);
                } else {
                    this.b = j2;
                    this.f21461a.set(1);
                    Map<String, String> a2 = z.a(c.f, false);
                    if (a2 != null && a2.size() > 0) {
                        ActivityManager.ProcessErrorStateInfo a3 = a(this.f21462c, 10000L);
                        this.l = a3;
                        if (a3 == null) {
                            x.c("proc state is unvisiable!", new Object[0]);
                        } else if (a3.pid != Process.myPid()) {
                            x.c("not mind proc!", this.l.processName);
                        } else {
                            x.a("found visiable anr , start to process!", new Object[0]);
                            a(this.f21462c, str, this.l, j2, a2);
                        }
                    }
                    x.d("can't get all thread skip this anr", new Object[0]);
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public final void a(boolean z) {
        c(z);
        boolean g = g();
        com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
        boolean z2 = g;
        if (a2 != null) {
            z2 = g && a2.c().e;
        }
        if (z2 != f()) {
            x.a("anr changed to %b", Boolean.valueOf(z2));
            b(z2);
        }
    }

    public final boolean a() {
        return this.f21461a.get() != 0;
    }

    @Override // com.tencent.bugly.proguard.ac
    public final boolean a(aa aaVar) {
        HashMap hashMap;
        HashMap hashMap2 = new HashMap();
        if (!aaVar.e().equals(Looper.getMainLooper())) {
            x.c("anr handler onThreadBlock only care main thread ,current thread is: %s", aaVar.d());
            return true;
        }
        try {
            hashMap = z.a((int) StCameraView.MEDIA_QUALITY_DESPAIR, false);
        } catch (Throwable th) {
            x.b(th);
            hashMap2.put("main", th.getMessage());
            hashMap = hashMap2;
        }
        x.c("onThreadBlock found visiable anr , start to process!", new Object[0]);
        a(this.f21462c, "", null, System.currentTimeMillis(), hashMap);
        return true;
    }

    protected final void b() {
        long b = z.b();
        long j = c.g;
        File file = new File(this.f);
        if (!file.exists() || !file.isDirectory()) {
            return;
        }
        try {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return;
            }
            int length = listFiles.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i >= length) {
                    x.c("Number of overdue trace files that has deleted: " + i3, new Object[0]);
                    return;
                }
                File file2 = listFiles[i];
                String name = file2.getName();
                x.c("Number Trace file : " + name, new Object[0]);
                int i4 = i3;
                if (name.startsWith("bugly_trace_")) {
                    int indexOf = name.indexOf(".txt");
                    if (indexOf <= 0 || Long.parseLong(name.substring(12, indexOf)) < b - j) {
                        i4 = i3;
                        if (file2.delete()) {
                            i4 = i3 + 1;
                        }
                    } else {
                        i4 = i3;
                    }
                }
                i++;
                i2 = i4;
            }
        } catch (Throwable th) {
            x.a(th);
        }
    }

    public final void c() {
        synchronized (this) {
            x.d("customer decides whether to open or close.", new Object[0]);
        }
    }
}
