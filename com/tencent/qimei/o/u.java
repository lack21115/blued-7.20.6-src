package com.tencent.qimei.o;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qimei.beaconid.U;
import com.tencent.qimei.log.IObservableLog;
import com.tencent.qimei.o.d;
import com.tencent.qimei.o.m;
import com.tencent.qimei.o.r;
import com.tencent.qimei.r.b;
import com.tencent.qimei.sdk.IAsyncQimeiListener;
import com.tencent.qimei.sdk.IQimeiSDK;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.qimei.sdk.QimeiSDK;
import com.tencent.qimei.sdk.debug.IDebugger;
import com.tencent.qimei.strategy.terminal.ITerminalStrategy;
import com.tencent.qimei.upload.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/u.class */
public class u implements com.tencent.qimei.g.c, d.a, r.b, IQimeiSDK, com.tencent.qimei.u.b, com.tencent.qimei.u.c {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, u> f24706a = new ConcurrentHashMap();
    public static final String b = QimeiSDK.class.getCanonicalName();
    public final IDebugger e;
    public final String g;
    public long l;

    /* renamed from: c  reason: collision with root package name */
    public final List<IAsyncQimeiListener> f24707c = Collections.synchronizedList(new ArrayList(8));
    public final ConcurrentHashMap<String, String> d = new ConcurrentHashMap<>();
    public final com.tencent.qimei.x.b f = new com.tencent.qimei.x.b();
    public Context h = null;
    public boolean i = false;
    public String j = "";
    public String k = "";

    public u(String str) {
        this.g = str;
        this.e = new com.tencent.qimei.p.a(str);
    }

    public static IQimeiSDK a(String str) {
        u uVar;
        synchronized (u.class) {
            try {
                u uVar2 = f24706a.get(str);
                uVar = uVar2;
                if (uVar2 == null) {
                    uVar = new u(str);
                    f24706a.put(str, uVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return uVar;
    }

    @Override // com.tencent.qimei.u.b
    public String H() {
        Qimei qimei = getQimei();
        return qimei == null ? "" : qimei.getQimei36();
    }

    @Override // com.tencent.qimei.u.b
    public String I() {
        return this.j;
    }

    @Override // com.tencent.qimei.u.c
    public Context J() {
        if (this.h == null) {
            com.tencent.qimei.k.a.b("SDK_INIT", "Context has been destroyed!!", new Object[0]);
        }
        return this.h;
    }

    @Override // com.tencent.qimei.u.b
    public String K() {
        return new JSONObject(this.d).toString();
    }

    @Override // com.tencent.qimei.u.b
    public String L() {
        return this.k;
    }

    @Override // com.tencent.qimei.u.b
    public void M() {
        synchronized (this.f24707c) {
            Qimei qimei = getQimei();
            if (qimei != null && !qimei.isEmpty()) {
                for (IAsyncQimeiListener iAsyncQimeiListener : this.f24707c) {
                    iAsyncQimeiListener.onQimeiDispatch(qimei);
                }
                this.f24707c.clear();
            }
        }
    }

    @Override // com.tencent.qimei.u.b
    public String N() {
        Qimei qimei = getQimei();
        return qimei == null ? "" : qimei.getQimei16();
    }

    @Override // com.tencent.qimei.u.c
    public String O() {
        return com.tencent.qimei.m.b.a().b();
    }

    @Override // com.tencent.qimei.g.c
    public void a() {
        e();
    }

    public final void a(IAsyncQimeiListener iAsyncQimeiListener) {
        synchronized (this.f24707c) {
            if (!this.f24707c.contains(iAsyncQimeiListener)) {
                this.f24707c.add(iAsyncQimeiListener);
            }
        }
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public IQimeiSDK addUserId(String str, String str2) {
        this.d.put(str, str2);
        return this;
    }

    @Override // com.tencent.qimei.g.c
    public void b() {
    }

    public final boolean c() {
        boolean z;
        synchronized (this) {
            if (TextUtils.isEmpty(this.g)) {
                throw new AssertionError("Assertion failed: AppKey Forgot Set!");
            }
            z = this.h != null;
        }
        return z;
    }

    public final boolean d() {
        boolean z;
        synchronized (this) {
            z = c() && this.i;
            if (!z) {
                com.tencent.qimei.k.a.a("SDK_INIT", "appkey:%s 未初始化", this.g);
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x021e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e() {
        /*
            Method dump skipped, instructions count: 625
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.o.u.e():void");
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public String getBeaconTicket() {
        if (d()) {
            String str = this.g;
            if (com.tencent.qimei.a.a.g(str)) {
                return null;
            }
            l a2 = l.a(str);
            if (a2.e == 0) {
                a2.e = System.currentTimeMillis();
            }
            if (!TextUtils.isEmpty(a2.d)) {
                return a2.d + a2.e;
            }
            a2.d = com.tencent.qimei.i.f.a(a2.b).c("tt");
            if (!TextUtils.isEmpty(a2.d)) {
                return a2.d + a2.e;
            } else if (com.tencent.qimei.c.a.j()) {
                return "";
            } else {
                a2.d = a2.b();
                return a2.d + a2.e;
            }
        }
        return "";
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public IDebugger getDebugger() {
        return this.e;
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public Qimei getQimei() {
        if (d()) {
            return com.tencent.qimei.a.a.d(this.g);
        }
        return null;
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public void getQimei(IAsyncQimeiListener iAsyncQimeiListener) {
        synchronized (this) {
            if (d()) {
                com.tencent.qimei.b.a.a().a(new s(this, iAsyncQimeiListener));
            } else {
                a(iAsyncQimeiListener);
            }
        }
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK, com.tencent.qimei.u.c
    public String getSdkVersion() {
        return BuildConfig.SDK_VERSION;
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public ITerminalStrategy getStrategy() {
        return this.f.f24750a;
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public String getToken() {
        String str = "";
        if (d()) {
            w a2 = w.a(this.g);
            String b2 = a2.b();
            if (b2.isEmpty()) {
                return a2.a();
            }
            long b3 = com.tencent.qimei.i.f.a(a2.b).b("t_s_t");
            if (!(0 != b3 && com.tencent.qimei.c.a.c() > b3)) {
                String str2 = b2;
                if (com.tencent.qimei.a.a.a(com.tencent.qimei.i.f.a(a2.b).b("t_s_t"))) {
                    str2 = a2.a();
                }
                return str2;
            }
            try {
                JSONObject jSONObject = new JSONObject(b2);
                String optString = jSONObject.optString(m.a.KEY_ENCRYPT_KEY.W);
                String optString2 = jSONObject.optString(m.a.KEY_PARAMS.W);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(m.a.KEY_PARAMS_APP_KEY.W, a2.b);
                jSONObject2.put(m.a.KEY_ENCRYPT_KEY.W, optString);
                jSONObject2.put(m.a.KEY_PARAMS.W, optString2);
                str = jSONObject2.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String a3 = m.f24691a.a(com.tencent.qimei.j.a.a(), a2.b, com.tencent.qimei.a.a.i(a2.b), str);
            a2.c(a3);
            return a3;
        }
        return "";
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public boolean init(Context context) {
        boolean z;
        boolean z2;
        synchronized (this) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (this.i) {
                return true;
            }
            com.tencent.qimei.k.a.b("SDK_INIT", "\n\n\n\n_____________________________________\n< Welcome to QmSDK! Your AppKey is: %s SDK_VERSION is: %s>\n -------------------------------------\n        \\   ^__^\n         \\  (oo)\\_______\n            (__)\\       )\\/\\\n                ||----w |\n                ||     || \n\n\n\n", this.g, BuildConfig.SDK_VERSION);
            this.h = context;
            if (!c()) {
                com.tencent.qimei.k.a.a("SDK_INIT", "appkey:%s 参数异常", this.g);
                return false;
            }
            com.tencent.qimei.t.b.a().a("SdkInfo", this);
            String str = this.g;
            com.tencent.qimei.t.b.a().a("BizInfo" + str, this);
            com.tencent.qimei.n.i.a().a(this.h);
            com.tencent.qimei.r.b bVar = b.a.f24715a;
            Context context2 = this.h;
            String str2 = b;
            if (bVar.f24714a) {
                z = true;
            } else if (context2 == null) {
                z = false;
            } else {
                File filesDir = context2.getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdir();
                }
                String absolutePath = new File(filesDir, str2).getAbsolutePath();
                if (U.f24624a) {
                    try {
                        U.n(context2, absolutePath);
                        z2 = true;
                    } catch (UnsatisfiedLinkError e) {
                        e.printStackTrace();
                    }
                    bVar.f24714a = z2;
                    com.tencent.qimei.k.a.b("SDK_INIT ｜ 本地加密", " 初始化完成（%b）,文件名:%s ", Boolean.valueOf(bVar.f24714a), str2);
                    z = bVar.f24714a;
                }
                z2 = false;
                bVar.f24714a = z2;
                com.tencent.qimei.k.a.b("SDK_INIT ｜ 本地加密", " 初始化完成（%b）,文件名:%s ", Boolean.valueOf(bVar.f24714a), str2);
                z = bVar.f24714a;
            }
            if (!z) {
                String str3 = this.g;
                com.tencent.qimei.n.c a2 = com.tencent.qimei.n.i.a().a(com.tencent.qimei.n.e.REPORT_QM_ERROR_CODE.K, "1005");
                String str4 = com.tencent.qimei.n.e.REPORT_QM_ERROR_DESC.K;
                com.tencent.qimei.l.d a3 = com.tencent.qimei.l.d.a(str3);
                HashMap hashMap = new HashMap();
                hashMap.put("a1", com.tencent.qimei.c.a.g());
                hashMap.put("a2", com.tencent.qimei.c.a.f());
                hashMap.put("a3", Build.CPU_ABI);
                hashMap.put("a4", Build.CPU_ABI2);
                hashMap.put("a5", a3.e());
                hashMap.put("a6", Build.BRAND);
                hashMap.put("a7", Build.VERSION.SDK);
                com.tencent.qimei.n.c a4 = a2.a(str4, new JSONObject(hashMap).toString());
                a4.f24665a = str3;
                a4.f24666c = "/report";
                a4.a(com.huawei.hms.ads.dynamicloader.b.g);
            }
            com.tencent.qimei.i.f a5 = com.tencent.qimei.i.f.a(this.g);
            Context context3 = this.h;
            String str5 = b;
            a5.d = context3;
            if (a5.d != null) {
                String str6 = str5;
                if (TextUtils.isEmpty(str5)) {
                    str6 = "";
                }
                a5.b = a5.d.getSharedPreferences("QV1" + str6 + com.tencent.qimei.c.a.b().replace(context3.getPackageName(), "") + com.tencent.qimei.j.a.a(a5.f24648c), 0);
            }
            d dVar = new d(this.g, this.h, this, this.f, this);
            com.tencent.qimei.b.a.a().a(dVar.k);
            com.tencent.qimei.b.a.a().a(dVar.l);
            com.tencent.qimei.k.a.b("SDK_INIT", "\n\n\n\n\t\t\t\t ----- 初始化结束! From appkey:%s ----- \n\n\n\n\t\t\t\t", this.g);
            this.i = true;
            this.l = SystemClock.uptimeMillis() - uptimeMillis;
            return true;
        }
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public boolean isQimeiValid(String str, String str2) {
        return true;
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public IQimeiSDK setAppVersion(String str) {
        com.tencent.qimei.c.a.a(str);
        return this;
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public IQimeiSDK setChannelID(String str) {
        this.j = str;
        return this;
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public IQimeiSDK setLogAble(boolean z) {
        synchronized (this) {
            com.tencent.qimei.k.a.a(z);
            com.tencent.qimei.k.a.b(z);
        }
        return this;
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public IQimeiSDK setLogObserver(IObservableLog iObservableLog) {
        synchronized (this) {
            com.tencent.qimei.k.a.f24656c = iObservableLog;
        }
        return this;
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public IQimeiSDK setSdkName(String str) {
        if (!this.i) {
            this.k = str;
        }
        return this;
    }
}
