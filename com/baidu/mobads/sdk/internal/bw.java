package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.FileInputStream;
import java.lang.Thread;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarFile;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bw.class */
public class bw {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6522a = "ApkLoader";
    protected static Thread.UncaughtExceptionHandler b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f6523c = "__badApkVersion__9.26";
    public static final String d = "previousProxyVersion";
    protected static final String e = "__xadsdk__remote__final__";
    protected static final String f = "bdxadsdk.jar";
    protected static final String g = "__xadsdk__remote__final__builtin__.jar";
    protected static final String h = "__xadsdk__remote__final__builtinversion__.jar";
    protected static final String i = "__xadsdk__remote__final__downloaded__.jar";
    protected static final String j = "__xadsdk__remote__final__running__.jar";
    public static final String k = "OK";
    public static final String l = "ERROR";
    public static final String m = "APK_INFO";
    public static final String n = "CODE";
    public static final String o = "success";
    protected static volatile bl p;
    protected static volatile bl q;
    protected static volatile Class r;
    protected static String s;
    protected static final Handler t = new bx(Looper.getMainLooper());
    private static final String x = "baidu_sdk_remote";
    private boolean A;
    private CopyOnWriteArrayList<c> B;
    private c C;
    protected Handler u;
    protected final Handler v;
    private bu w;
    private final Context y;
    private bq z;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bw$a.class */
    public static final class a extends Exception {

        /* renamed from: a  reason: collision with root package name */
        private static final long f6524a = 2978543166232984104L;

        public a(String str) {
            bq.a().c(str);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bw$b.class */
    public static final class b extends Exception {

        /* renamed from: a  reason: collision with root package name */
        private static final long f6525a = -7838296421993681751L;

        public b(String str) {
            bq.a().c(str);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bw$c.class */
    public interface c {
        void a(boolean z);
    }

    public bw(Activity activity) {
        this(activity.getApplicationContext());
    }

    public bw(Context context) {
        this.z = bq.a();
        this.A = false;
        this.u = t;
        this.B = new CopyOnWriteArrayList<>();
        this.v = new by(this, Looper.getMainLooper());
        this.y = context;
        c(context);
        if (b == null) {
            b = ck.a(context);
            ck.a(context).a(new bz(this));
        }
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof ck) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(b);
    }

    private IXAdContainerFactory a(bl blVar) {
        IXAdContainerFactory iXAdContainerFactory = null;
        if (blVar != null) {
            try {
                iXAdContainerFactory = blVar.a();
            } catch (Exception e2) {
                return null;
            }
        }
        return iXAdContainerFactory;
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(s)) {
            File dir = context.getDir(x, 0);
            s = dir.getAbsolutePath() + "/";
        }
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        return s + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bp bpVar) {
        Class<?> b2 = bpVar.b();
        synchronized (this) {
            q = new bl(b2, this.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bu buVar) {
        if (buVar.a().booleanValue()) {
            bs a2 = bs.a(this.y, buVar, s, this.v);
            if (a2.isAlive()) {
                this.z.a(f6522a, "XApkDownloadThread already started");
                a2.a(buVar.c());
                return;
            }
            this.z.a(f6522a, "XApkDownloadThread starting ...");
            a2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Message obtainMessage = this.u.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putBoolean(o, z);
        obtainMessage.setData(bundle);
        obtainMessage.what = 0;
        this.u.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str) {
        synchronized (this) {
            try {
                ck.a(this.y).c();
                if (this.B != null && this.B.size() > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= this.B.size()) {
                            break;
                        }
                        c cVar = this.B.get(i3);
                        if (cVar != null) {
                            cVar.a(z);
                        }
                        i2 = i3 + 1;
                    }
                }
                if (this.B != null) {
                    this.B.clear();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static double b(Context context) {
        try {
            c(context);
            double b2 = b(f());
            String d2 = d();
            if (Double.valueOf("9.26").doubleValue() > b(d2)) {
                bp bpVar = new bp(d2, context);
                if (bpVar.exists()) {
                    bpVar.delete();
                }
                bo.a(context, f, d2);
            }
            return Math.max(b2, b(d()));
        } catch (Exception e2) {
            return 0.0d;
        }
    }

    public static double b(String str) {
        JarFile jarFile;
        JarFile jarFile2 = null;
        try {
            try {
                if (cj.d.booleanValue()) {
                    File file = new File(str);
                    jarFile = null;
                    if (bo.a(file)) {
                        jarFile = new JarFile(file);
                        try {
                            double parseDouble = Double.parseDouble(jarFile.getManifest().getMainAttributes().getValue("Implementation-Version"));
                            if (parseDouble > 0.0d) {
                                try {
                                    jarFile.close();
                                    return parseDouble;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return parseDouble;
                                }
                            }
                        } catch (Exception e3) {
                            if (jarFile != null) {
                                jarFile.close();
                                return 0.0d;
                            }
                            return 0.0d;
                        } catch (Throwable th) {
                            jarFile2 = jarFile;
                            th = th;
                            if (jarFile2 != null) {
                                try {
                                    jarFile2.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    if (jarFile != null) {
                        jarFile.close();
                        return 0.0d;
                    }
                    return 0.0d;
                }
                return Double.valueOf("9.26").doubleValue();
            } catch (Exception e5) {
                jarFile = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0.0d;
        }
    }

    private void b(bp bpVar) {
        bq bqVar = this.z;
        bqVar.a(f6522a, "len=" + bpVar.length() + ", path=" + bpVar.getAbsolutePath());
        if (p != null) {
            bq bqVar2 = this.z;
            bqVar2.a(f6522a, "mApkBuilder already initialized, version: " + p.b);
            return;
        }
        String a2 = a(this.y);
        bp bpVar2 = new bp(a2, this.y);
        if (bpVar2.exists()) {
            bpVar2.delete();
        }
        try {
            bo.a(new FileInputStream(bpVar), a2);
        } catch (Exception e2) {
            this.z.c(e2);
        }
        p = new bl(bpVar2.b(), this.y);
        try {
            IXAdContainerFactory a3 = p.a();
            bq bqVar3 = this.z;
            bqVar3.a(f6522a, "preloaded apk.version=" + a3.getRemoteVersion());
        } catch (a e3) {
            bq bqVar4 = this.z;
            bqVar4.a(f6522a, "preload local apk " + bpVar.getAbsolutePath() + " failed, msg:" + e3.getMessage() + ", v=" + p.b);
            a(e3.getMessage());
            throw e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar, Handler handler) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(cVar)) {
            this.B.add(cVar);
        }
        this.u = handler;
        if (p == null) {
            g();
        } else {
            b(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z || o()) {
            a(z, z ? "apk Successfully Loaded" : "apk Load Failed");
        } else {
            this.A = true;
        }
        if (this.A) {
            ba.a().a((h) new ca(this, z));
        } else {
            ba.a().a(new cb(this, z), 5L, TimeUnit.SECONDS);
        }
    }

    protected static String c() {
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        return s + g;
    }

    private static void c(Context context) {
        if (TextUtils.isEmpty(s)) {
            File dir = context.getDir(x, 0);
            s = dir.getAbsolutePath() + "/";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        double d2;
        if (z) {
            try {
                d2 = p.b;
            } catch (Exception e2) {
                return;
            }
        } else {
            d2 = 0.0d;
        }
        an.a(d2, new cc(this, d2), new cd(this));
    }

    private boolean c(bp bpVar) {
        synchronized (this) {
            b(bpVar);
            bq bqVar = this.z;
            bqVar.a(f6522a, "loaded: " + bpVar.getPath());
        }
        return true;
    }

    protected static String d() {
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        return s + h;
    }

    private static void d(Context context) {
        synchronized (bw.class) {
            try {
                try {
                    String c2 = c();
                    double b2 = b(c2);
                    bq a2 = bq.a();
                    a2.a(f6522a, "copy assets,compare version=" + Double.valueOf("9.26") + "remote=" + b2);
                    if (Double.valueOf("9.26").doubleValue() != b2) {
                        bp bpVar = new bp(c2, context);
                        if (bpVar.exists()) {
                            bpVar.delete();
                        }
                        bo.a(context, f, c2);
                    }
                } catch (Exception e2) {
                    throw new b("loadBuiltInApk failed: " + e2.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String f() {
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        return s + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            File[] listFiles = this.y.getFilesDir().listFiles();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (listFiles == null) {
                    return;
                }
                if (i3 >= listFiles.length) {
                    return;
                }
                if (listFiles[i3].getAbsolutePath().contains(e) && listFiles[i3].getAbsolutePath().endsWith(ShareConstants.DEX_PATH)) {
                    listFiles[i3].delete();
                }
                i2 = i3 + 1;
            }
        } catch (Exception e2) {
            bq.a().c(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences m() {
        return this.y.getSharedPreferences(w.az, 0);
    }

    private boolean n() {
        String string = m().getString(d, null);
        return string == null || !string.equals(a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (com.baidu.mobads.sdk.internal.bo.a(f()) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean o() {
        /*
            r3 = this;
            r0 = 0
            r4 = r0
            java.lang.String r0 = c()     // Catch: java.lang.Exception -> L1a
            boolean r0 = com.baidu.mobads.sdk.internal.bo.a(r0)     // Catch: java.lang.Exception -> L1a
            if (r0 != 0) goto L16
            java.lang.String r0 = f()     // Catch: java.lang.Exception -> L1a
            boolean r0 = com.baidu.mobads.sdk.internal.bo.a(r0)     // Catch: java.lang.Exception -> L1a
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L18
        L16:
            r0 = 1
            r4 = r0
        L18:
            r0 = r4
            return r0
        L1a:
            r6 = move-exception
            r0 = r3
            com.baidu.mobads.sdk.internal.bq r0 = r0.z
            r1 = r6
            r0.a(r1)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.bw.o():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        bp bpVar = new bp(f(), this.y);
        if (bo.a(bpVar)) {
            try {
                if (n()) {
                    throw new a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
                }
                synchronized (this) {
                    bq bqVar = this.z;
                    bqVar.a(f6522a, "loadDownloadedOrBuiltInApk len=" + bpVar.length() + ", path=" + bpVar.getAbsolutePath());
                    b(bpVar);
                    double d2 = (double) m().getFloat(f6523c, -1.0f);
                    bq bqVar2 = this.z;
                    bqVar2.a(f6522a, "downloadedApkFile.getApkVersion(): " + bpVar.c() + ", badApkVersion: " + d2);
                    if (bpVar.c() == d2) {
                        throw new a("downloaded file marked bad, drop it and use built-in");
                    }
                    bq bqVar3 = this.z;
                    bqVar3.a(f6522a, "loaded: " + bpVar.getPath());
                }
                return true;
            } catch (a e2) {
                bq bqVar4 = this.z;
                bqVar4.a(f6522a, "load downloaded apk failed: " + e2.toString() + ", fallback to built-in");
                if (bpVar.exists()) {
                    bpVar.delete();
                }
                k();
                return false;
            }
        }
        return false;
    }

    public final String a() {
        return "9.26";
    }

    public void a(c cVar) {
        a(cVar, t);
    }

    public void a(c cVar, Handler handler) {
        ba.a().a((h) new ce(this, cVar, handler));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        if (p != null) {
            SharedPreferences.Editor edit = m().edit();
            edit.putFloat(f6523c, (float) p.b);
            edit.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        new File(f()).delete();
    }

    protected void e() {
        this.z.a(f6522a, "start load assets file");
        d(this.y);
        String c2 = c();
        bp bpVar = new bp(c2, this.y);
        if (!bo.a(bpVar)) {
            throw new b("loadBuiltInApk failed: " + c2);
        }
        this.z.a(f6522a, "assets file can read ,will use it ");
        if (c(bpVar)) {
            b(true);
        }
    }

    protected void g() {
        if (h() != 2 ? p() : false) {
            this.z.a(f6522a, "load downloaded file success,use it");
            b(true);
            return;
        }
        this.z.a(f6522a, "no downloaded file yet, use built-in apk file");
        try {
            e();
        } catch (b e2) {
            bq bqVar = this.z;
            bqVar.a(f6522a, "loadBuiltInApk failed: " + e2.toString());
            throw new a("load built-in apk failed" + e2.toString());
        }
    }

    public int h() {
        return this.y.getApplicationContext().getSharedPreferences("baidu_cloudControlConfig", 0).getInt("baidu_cloudConfig_pktype", 1);
    }

    public IXAdContainerFactory i() {
        return a(p);
    }

    public IXAdContainerFactory j() {
        return a(q);
    }

    protected void k() {
        if (p != null) {
            p.b();
            p = null;
        }
    }
}
