package com.bytedance.bdtracker;

import android.accounts.Account;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.IActiveCustomParamsCallback;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.applog.IDataObserver;
import com.bytedance.applog.IEventObserver;
import com.bytedance.applog.IExtraParams;
import com.bytedance.applog.IHeaderCustomTimelyCallback;
import com.bytedance.applog.IOaidObserver;
import com.bytedance.applog.ISessionObserver;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.Level;
import com.bytedance.applog.R;
import com.bytedance.applog.UriConfig;
import com.bytedance.applog.alink.IALinkListener;
import com.bytedance.applog.event.IEventHandler;
import com.bytedance.applog.network.INetworkClient;
import com.bytedance.applog.profile.UserProfileCallback;
import com.bytedance.applog.scheme.BuildConfig;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.thumbplayer.tplayer.plugins.report.TPReportParams;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/c.class */
public final class c implements IAppLogInstance {
    public static final List<c> D = new LinkedList();
    public static final AtomicInteger E = new AtomicInteger(0);
    public final r1 i;
    public final q1 j;
    public volatile m0 n;
    public volatile n0 o;
    public volatile v p;
    public volatile o q;
    public volatile INetworkClient r;
    public volatile IHeaderCustomTimelyCallback t;
    public volatile a0 u;
    public d0 w;
    public IALinkListener x;
    public IActiveCustomParamsCallback y;
    public IEventHandler z;

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, JSONObject> f21200a = new ConcurrentHashMap<>();
    public final f0 b = new f0();

    /* renamed from: c  reason: collision with root package name */
    public final e0 f21201c = new e0();
    public final p0 d = new p0();
    public final h0 e = new h0();
    public final Set<Integer> f = new HashSet();
    public final Set<String> g = new HashSet();
    public final Set<Class<?>> h = new HashSet();
    public int k = 0;
    public String l = "";
    public volatile Application m = null;
    public volatile boolean s = false;
    public volatile boolean v = false;
    public volatile boolean A = true;
    public long B = 0;
    public long C = 10000;

    public c() {
        E.incrementAndGet();
        this.i = new r1(this);
        this.j = new q1(this);
        D.add(this);
    }

    public p0 a() {
        return this.d;
    }

    public final void a(Object obj, JSONObject jSONObject) {
        if (this.q == null || obj == null) {
            return;
        }
        c2 c2Var = new c2();
        c2Var.r = obj.getClass().getName();
        if (t2.d(obj)) {
            Activity activity = null;
            try {
                activity = (Activity) obj.getClass().getMethod("getActivity", new Class[0]).invoke(obj, new Object[0]);
            } catch (Throwable th) {
            }
            if (activity != null) {
                c2Var.r = activity.getClass().getName() + ":" + c2Var.r;
            }
        }
        c2Var.p = 0L;
        c2Var.s = t2.b(obj);
        c2Var.u = t2.a(obj);
        if (jSONObject != null) {
            c2Var.m = jSONObject;
        }
        receive(c2Var);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void activateALink(Uri uri) {
        JSONObject jSONObject;
        if (this.p != null) {
            f fVar = this.p.A;
            fVar.a();
            if (uri != null) {
                fVar.h = uri.toString();
            }
            Handler handler = fVar.b;
            if (handler != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject = jSONObject2;
                    if (uri != null) {
                        String scheme = uri.getScheme();
                        if (Intrinsics.a((Object) scheme, (Object) "http") || Intrinsics.a((Object) scheme, (Object) "https")) {
                            jSONObject2.put("tr_token", uri.getLastPathSegment());
                        }
                        Iterator<String> it = uri.getQueryParameterNames().iterator();
                        while (true) {
                            jSONObject = jSONObject2;
                            if (!it.hasNext()) {
                                break;
                            }
                            String next = it.next();
                            jSONObject2.put(next, uri.getQueryParameter(next));
                        }
                    }
                } catch (Throwable th) {
                    jSONObject = null;
                }
                h hVar = (h) l.f21245a.a(jSONObject, h.class);
                String str = null;
                if (hVar != null) {
                    str = hVar.d();
                }
                if (str == null || str.length() == 0) {
                    return;
                }
                handler.sendMessage(handler.obtainMessage(1, hVar));
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void addDataObserver(IDataObserver iDataObserver) {
        synchronized (this) {
            if (this.w == null) {
                this.w = new d0();
            }
            this.w.a(iDataObserver);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void addEventObserver(IEventObserver iEventObserver) {
        this.f21201c.a(iEventObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String addNetCommonParams(Context context, String str, boolean z, Level level) {
        return this.i.a(this.o != null ? this.o.d() : null, str, z, level);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void addSessionHook(ISessionObserver iSessionObserver) {
        this.b.a(iSessionObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void flush() {
        if (this.p != null) {
            this.p.a(null, true);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public IALinkListener getALinkListener() {
        return this.x;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public <T> T getAbConfig(String str, T t) {
        if (this.o != null) {
            n0 n0Var = this.o;
            JSONObject optJSONObject = n0Var.f21265c.a().optJSONObject(str);
            T t2 = t;
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(OapsKey.KEY_VERID);
                Object opt = optJSONObject.opt(TPReportParams.JSON_KEY_VAL);
                n0Var.a(optString);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ab_sdk_version", optString);
                    n0Var.h.onEventV3("abtest_exposure", jSONObject, 0);
                } catch (JSONException e) {
                    z2.a(e);
                }
                t2 = null;
                if (opt != null) {
                    t2 = opt;
                }
                if (t2 == null) {
                    return t;
                }
            }
            return t2;
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getAbSdkVersion() {
        if (this.o != null) {
            n0 n0Var = this.o;
            if (n0Var.f21264a) {
                return n0Var.d.optString("ab_sdk_version", "");
            }
            m0 m0Var = n0Var.f21265c;
            return m0Var != null ? m0Var.b() : "";
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public IActiveCustomParamsCallback getActiveCustomParams() {
        return this.y;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public String getAid() {
        return this.l;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public JSONObject getAllAbTestConfigs() {
        return this.p == null ? new JSONObject() : this.p.d.a();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public d getAppContext() {
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getAppId() {
        return this.l;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getClientUdid() {
        return this.o != null ? this.o.d.optString("clientudid", "") : "";
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public Context getContext() {
        return this.m;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getDeepLinkUrl() {
        if (this.p != null) {
            return this.p.A.h;
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getDid() {
        return this.o != null ? this.o.d.optString("bd_did", "") : "";
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean getEncryptAndCompress() {
        return this.A;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public a0 getEventFilterByClient() {
        return this.u;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public IEventHandler getEventHandler() {
        return this.z;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public JSONObject getHeader() {
        if (this.o == null) {
            return null;
        }
        return this.o.d();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public IHeaderCustomTimelyCallback getHeaderCustomCallback() {
        return this.t;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public <T> T getHeaderValue(String str, T t, Class<T> cls) {
        if (this.o != null) {
            return (T) this.o.a(str, (String) t, (Class<String>) cls);
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getIid() {
        return this.o != null ? this.o.e() : "";
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public InitConfig getInitConfig() {
        if (this.n != null) {
            return this.n.b;
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public int getLaunchFrom() {
        return this.k;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public INetworkClient getNetClient() {
        if (this.r != null) {
            return this.r;
        }
        if (getInitConfig() == null || getInitConfig().getNetworkClient() == null) {
            synchronized (this) {
                if (this.r == null) {
                    this.r = new c1(this.j);
                }
            }
            return this.r;
        }
        return getInitConfig().getNetworkClient();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getOpenUdid() {
        return this.o != null ? this.o.g() : "";
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public Map<String, String> getRequestHeader() {
        if (this.n == null) {
            return Collections.emptyMap();
        }
        String string = this.n.e.getString(RemoteMessageConst.DEVICE_TOKEN, "");
        HashMap hashMap = new HashMap();
        hashMap.put("x-tt-dt", string != null ? string : "");
        return hashMap;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getSessionId() {
        z zVar = this.p.m;
        if (zVar != null) {
            return zVar.a();
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getSsid() {
        return this.o != null ? this.o.i() : "";
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void getSsidGroup(Map<String, String> map) {
        String did = getDid();
        if (!TextUtils.isEmpty(did)) {
            map.put("device_id", did);
        }
        String iid = getIid();
        if (!TextUtils.isEmpty(iid)) {
            map.put("install_id", iid);
        }
        String openUdid = getOpenUdid();
        if (!TextUtils.isEmpty(openUdid)) {
            map.put("openudid", openUdid);
        }
        String clientUdid = getClientUdid();
        if (TextUtils.isEmpty(clientUdid)) {
            return;
        }
        map.put("clientudid", clientUdid);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getUdid() {
        return this.o != null ? this.o.j() : "";
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getUserID() {
        if (this.p != null) {
            return String.valueOf(this.p.m.f21339a);
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getUserUniqueID() {
        return this.o != null ? this.o.k() : "";
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public JSONObject getViewProperties(View view) {
        if (view != null) {
            return this.f21200a.get(j1.a(view));
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean hasStarted() {
        return this.s;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void ignoreAutoTrackClick(View view) {
        if (view == null) {
            return;
        }
        this.g.add(j1.a(view));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void ignoreAutoTrackClickByViewType(Class<?>... clsArr) {
        if (clsArr == null) {
            return;
        }
        this.h.addAll(Arrays.asList(clsArr));
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
        r6 = true;
     */
    @Override // com.bytedance.applog.IAppLogInstance
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void ignoreAutoTrackPage(java.lang.Class<?>... r4) {
        /*
            r3 = this;
            r0 = r4
            if (r0 != 0) goto L5
            return
        L5:
            r0 = r4
            int r0 = r0.length
            r7 = r0
            r0 = 0
            r5 = r0
        Lb:
            r0 = r5
            r1 = r7
            if (r0 >= r1) goto Ld2
            r0 = r4
            r1 = r5
            r0 = r0[r1]
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L1e
            goto Lcb
        L1e:
            java.util.List<java.lang.Class<?>> r0 = com.bytedance.bdtracker.t2.f21311c
            java.util.Iterator r0 = r0.iterator()
            r9 = r0
        L28:
            r0 = r9
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L47
            r0 = r8
            r1 = r9
            java.lang.Object r1 = r1.next()
            java.lang.Class r1 = (java.lang.Class) r1
            boolean r0 = r0.isAssignableFrom(r1)
            if (r0 == 0) goto L28
            goto L6d
        L47:
            java.util.List<java.lang.Class<?>> r0 = com.bytedance.bdtracker.t2.d
            java.util.Iterator r0 = r0.iterator()
            r9 = r0
        L51:
            r0 = r9
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L72
            r0 = r8
            r1 = r9
            java.lang.Object r1 = r1.next()
            java.lang.Class r1 = (java.lang.Class) r1
            boolean r0 = r0.isAssignableFrom(r1)
            if (r0 == 0) goto L51
        L6d:
            r0 = 1
            r6 = r0
            goto L74
        L72:
            r0 = 0
            r6 = r0
        L74:
            r0 = r6
            if (r0 != 0) goto La1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = r9
            r1 = r8
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            java.lang.String r1 = " is not a page class."
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            java.lang.String r0 = r0.toString()
            r1 = 0
            com.bytedance.bdtracker.z2.b(r0, r1)
            goto Lcb
        La1:
            r0 = r8
            java.lang.String r0 = r0.getCanonicalName()
            r8 = r0
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto Lb3
            goto Lcb
        Lb3:
            r0 = r3
            java.util.Set<java.lang.Integer> r0 = r0.f
            r1 = r8
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            int r1 = r1.hashCode()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            boolean r0 = r0.add(r1)
        Lcb:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto Lb
        Ld2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.c.ignoreAutoTrackPage(java.lang.Class[]):void");
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void init(Context context, InitConfig initConfig) {
        synchronized (c.class) {
            try {
                if (j1.a(TextUtils.isEmpty(initConfig.getAid()), "App id must not be empty!")) {
                    return;
                }
                boolean c2 = b.c(initConfig.getAid());
                if (j1.a(c2, "The app id:" + initConfig.getAid() + " has an instance already.")) {
                    return;
                }
                if (AppLog.getInstance() == this) {
                    z2.a(context, initConfig.getLogger(), initConfig.isLogEnable());
                } else if (initConfig.getLogger() != null) {
                    z2.b("Only static AppLog can set logger.", (Throwable) null);
                }
                z2.b("AppLog init begin...");
                this.l = initConfig.getAid();
                this.m = (Application) context.getApplicationContext();
                if (TextUtils.isEmpty(initConfig.getSpName())) {
                    initConfig.setSpName(b.a(this, "applog_stats"));
                }
                this.n = new m0(this, this.m, initConfig);
                this.o = new n0(this, this.m, this.n);
                this.p = new v(this, this.n, this.o, this.e);
                this.q = o.a(this.m);
                Class<?> b = j1.b("com.bytedance.applog.metasec.AppLogSecHelper");
                if (b == null) {
                    z2.a("No AppLogSecHelper class, and will not init.");
                } else {
                    Method declaredMethod = b.getDeclaredMethod("init", IAppLogInstance.class, Context.class);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(null, this, context);
                }
                this.k = 1;
                this.s = initConfig.autoStart();
                z2.b("AppLog init end.");
            } finally {
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void init(Context context, InitConfig initConfig, Activity activity) {
        init(context, initConfig);
        if (this.q == null || activity == null) {
            return;
        }
        this.q.onActivityCreated(activity, null);
        this.q.onActivityResumed(activity);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void initMetaSec(Context context) {
        Class<?> b = j1.b("com.bytedance.applog.metasec.AppLogSecHelper");
        if (b == null) {
            z2.a("No AppLogSecHelper class, and will not init.");
            return;
        }
        try {
            Method declaredMethod = b.getDeclaredMethod("init", IAppLogInstance.class, Context.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, this, context);
        } catch (Throwable th) {
            z2.a("Initialize AppLogSecHelper failed.", th);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isAutoTrackClickIgnored(View view) {
        if (view == null) {
            return false;
        }
        if (this.g.contains(j1.a(view))) {
            return true;
        }
        for (Class<?> cls : this.h) {
            if (cls.isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isAutoTrackPageIgnored(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        String canonicalName = cls.getCanonicalName();
        if (TextUtils.isEmpty(canonicalName)) {
            return false;
        }
        return this.f.contains(Integer.valueOf(((String) Objects.requireNonNull(canonicalName)).hashCode()));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isBavEnabled() {
        return this.p != null && this.p.d();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isH5BridgeEnable() {
        return getInitConfig() != null && getInitConfig().isH5BridgeEnable();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isH5CollectEnable() {
        return getInitConfig() != null && getInitConfig().isH5CollectEnable();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isNewUser() {
        if (this.o != null) {
            return this.o.j;
        }
        return false;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isPrivacyMode() {
        return this.v;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean manualActivate() {
        if (this.p != null) {
            return this.p.a(false);
        }
        return false;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onActivityPause() {
        if (this.q != null) {
            this.q.onActivityPaused(null);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onActivityResumed(Activity activity, int i) {
        if (this.q != null) {
            this.q.a(activity, i);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public void onEvent(String str) {
        onEvent(str, null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public void onEvent(String str, String str2) {
        onEvent("event_v1", str, str2, 0L, 0L, null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public void onEvent(String str, String str2, String str3, long j, long j2) {
        onEvent(str, str2, str3, j, j2, null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public void onEvent(String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        String str4 = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            z2.b("Category or tag is empty", (Throwable) null);
            return;
        }
        String str5 = this.l;
        if (jSONObject != null) {
            str4 = jSONObject.toString();
        }
        receive(new x1(str5, str, str2, str3, j, j2, str4));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3(String str) {
        onEventV3(str, (JSONObject) null, 0);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3(String str, Bundle bundle) {
        onEventV3(str, bundle, 0);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3(String str, Bundle bundle, int i) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            jSONObject = null;
            try {
                if (!bundle.isEmpty()) {
                    jSONObject = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject.put(str2, bundle.get(str2));
                        }
                    } catch (Throwable th) {
                        th = th;
                        z2.c("U SHALL NOT PASS!", th);
                        onEventV3(str, jSONObject, i);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                jSONObject = null;
            }
        }
        onEventV3(str, jSONObject, i);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3(String str, JSONObject jSONObject) {
        onEventV3(str, jSONObject, 0);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3(String str, JSONObject jSONObject, int i) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            z2.a("event name is empty", (Throwable) null);
            return;
        }
        String str3 = this.l;
        if (jSONObject != null) {
            str2 = jSONObject.toString();
        }
        receive(new z1(str3, str, false, str2, i));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public void onInternalEventV3(String str, Bundle bundle, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            z2.b("both second appid and second app name is empty, return", (Throwable) null);
            return;
        }
        String str5 = "second_app_" + str;
        JSONObject jSONObject = null;
        if (bundle != null) {
            jSONObject = null;
            try {
                if (!bundle.isEmpty()) {
                    jSONObject = new JSONObject();
                    try {
                        for (String str6 : bundle.keySet()) {
                            jSONObject.put(str6, bundle.get(str6));
                        }
                        jSONObject.put("params_for_special", "second_app");
                        jSONObject.put("second_appid", str2);
                        jSONObject.put("second_appname", str3);
                        jSONObject.put("product_type", str4);
                    } catch (Throwable th) {
                        th = th;
                        z2.c("U SHALL NOT PASS!", th);
                        onEventV3(str5, jSONObject, 0);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                jSONObject = null;
            }
        }
        onEventV3(str5, jSONObject, 0);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public void onInternalEventV3(String str, JSONObject jSONObject, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            z2.b("both second appid and second app name is empty, return", (Throwable) null);
            return;
        }
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        String str5 = "second_app_" + str;
        try {
            jSONObject2.put("params_for_special", "second_app");
            jSONObject2.put("second_appid", str2);
            jSONObject2.put("second_appname", str3);
            jSONObject2.put("product_type", str4);
        } catch (Throwable th) {
            z2.c("U SHALL NOT PASS!", th);
        }
        onEventV3(str5, jSONObject2, 0);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onMiscEvent(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
            z2.b("call onEventData with invalid params, return", (Throwable) null);
            return;
        }
        try {
            receive(new y1(this.l, str, jSONObject));
        } catch (Exception e) {
            z2.a("call onEventData get exception: ", e);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onPause(Context context) {
        if (context instanceof Activity) {
            onActivityPause();
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onResume(Context context) {
        if (context instanceof Activity) {
            onActivityResumed((Activity) context, context.hashCode());
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void profileAppend(JSONObject jSONObject) {
        if (this.p == null || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            if (!j1.a(jSONObject, new Class[]{String.class, Integer.class}, new Class[]{String.class})) {
                z2.a("only support String、Int、String Array！", new Exception());
                return;
            }
        } catch (JSONException e) {
            z2.a(e);
        }
        this.p.a(jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void profileIncrement(JSONObject jSONObject) {
        if (this.p == null || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            if (!j1.a(jSONObject, new Class[]{Integer.class}, (Class<?>[]) null)) {
                z2.a("only support Int", new Exception());
                return;
            }
        } catch (JSONException e) {
            z2.a(e);
        }
        this.p.b(jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void profileSet(JSONObject jSONObject) {
        if (this.p == null || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.p.c(jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void profileSetOnce(JSONObject jSONObject) {
        if (this.p == null || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.p.d(jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void profileUnset(String str) {
        if (this.p == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, "");
        } catch (JSONException e) {
            z2.a(e);
        }
        this.p.e(jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void pullAbTestConfigs() {
        if (this.p != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.B) > this.C) {
                this.B = currentTimeMillis;
                v vVar = this.p;
                vVar.a(vVar.l);
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void putCommonParams(Context context, Map<String, String> map, boolean z, Level level) {
        this.i.a(this.o != null ? this.o.d() : null, z, map, level);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void receive(t1 t1Var) {
        if (t1Var == null) {
            return;
        }
        t1Var.k = this.l;
        if (this.p == null) {
            this.e.a(t1Var);
        } else {
            this.p.a(t1Var);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void receive(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            sb.append(strArr[i2]);
            sb.append(",");
            i = i2 + 1;
        }
        if (this.p == null) {
            this.e.a(strArr);
            return;
        }
        v vVar = this.p;
        vVar.o.removeMessages(4);
        vVar.o.obtainMessage(4, strArr).sendToTarget();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback) {
        this.t = iHeaderCustomTimelyCallback;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeAllDataObserver() {
        d0 d0Var = this.w;
        if (d0Var != null) {
            d0Var.f21206a.clear();
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeDataObserver(IDataObserver iDataObserver) {
        d0 d0Var = this.w;
        if (d0Var != null) {
            d0Var.b(iDataObserver);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeEventObserver(IEventObserver iEventObserver) {
        this.f21201c.b(iEventObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeHeaderInfo(String str) {
        if (this.o == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.o.d(str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeOaidObserver(IOaidObserver iOaidObserver) {
        k3.b(iOaidObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeSessionHook(ISessionObserver iSessionObserver) {
        this.b.b(iSessionObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean reportPhoneDetailInfo() {
        return this.o != null && this.o.p();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setALinkListener(IALinkListener iALinkListener) {
        this.x = iALinkListener;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setAccount(Account account) {
        if (this.o != null) {
            p0 a2 = this.o.h.a();
            if (!(a2.f21283a instanceof n2)) {
                a2.b = account;
                return;
            }
            s1 s1Var = ((n2) a2.f21283a).f21271c;
            if (s1Var != null) {
                s1Var.a(account);
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setActiveCustomParams(IActiveCustomParamsCallback iActiveCustomParamsCallback) {
        this.y = iActiveCustomParamsCallback;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setAppContext(d dVar) {
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setAppLanguageAndRegion(String str, String str2) {
        boolean z;
        if (this.p != null) {
            v vVar = this.p;
            n0 n0Var = vVar.h;
            boolean z2 = true;
            if (n0Var.a("app_language", (Object) str)) {
                a.a(n0Var.f21265c.e, "app_language", str);
                z = true;
            } else {
                z = false;
            }
            n0 n0Var2 = vVar.h;
            if (n0Var2.a("app_region", (Object) str2)) {
                a.a(n0Var2.f21265c.e, "app_region", str2);
            } else {
                z2 = false;
            }
            if (z || z2) {
                vVar.a(vVar.j);
                vVar.a(vVar.e);
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setAppTrack(JSONObject jSONObject) {
        if (jSONObject == null || this.o == null) {
            return;
        }
        n0 n0Var = this.o;
        if (n0Var.a("app_track", jSONObject)) {
            m0 m0Var = n0Var.f21265c;
            a.a(m0Var.f21257c, "app_track", jSONObject.toString());
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setClipboardEnabled(boolean z) {
        this.p.A.f21214a = z;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEncryptAndCompress(boolean z) {
        this.A = z;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEventFilterByClient(List<String> list, boolean z) {
        a0 a0Var = null;
        if (list != null) {
            a0Var = null;
            if (!list.isEmpty()) {
                HashSet hashSet = new HashSet();
                for (String str : list) {
                    if (!TextUtils.isEmpty(str)) {
                        hashSet.add(str);
                    }
                }
                a0Var = null;
                if (!hashSet.isEmpty()) {
                    a0Var = z ? new c0(hashSet, null) : new b0(hashSet, null);
                }
            }
        }
        this.u = a0Var;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEventHandler(IEventHandler iEventHandler) {
        this.z = iEventHandler;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setExternalAbVersion(String str) {
        if (this.o != null) {
            this.o.f(str);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setExtraParams(IExtraParams iExtraParams) {
        this.i.f21295a = iExtraParams;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setForbidReportPhoneDetailInfo(boolean z) {
        if (j1.a(this.o == null, "请先完成初始化")) {
            return;
        }
        n0 n0Var = this.o;
        n0Var.k = z;
        if (n0Var.p()) {
            return;
        }
        n0Var.a("sim_serial_number", (Object) null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setGoogleAid(String str) {
        if (this.o != null) {
            n0 n0Var = this.o;
            if (n0Var.a("google_aid", (Object) str)) {
                a.a(n0Var.f21265c.e, "google_aid", str);
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setHeaderInfo(String str, Object obj) {
        if (this.o == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(str, obj);
        this.o.a(hashMap);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setHeaderInfo(HashMap<String, Object> hashMap) {
        if (this.o != null) {
            this.o.a(hashMap);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setLaunchFrom(int i) {
        this.k = i;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setOaidObserver(IOaidObserver iOaidObserver) {
        k3.a(iOaidObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setPrivacyMode(boolean z) {
        this.v = z;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setPullAbTestConfigsThrottleMills(Long l) {
        long j = 0;
        if (l != null) {
            j = 0;
            if (l.longValue() > 0) {
                j = l.longValue();
            }
        }
        this.C = j;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setRangersEventVerifyEnable(boolean z, String str) {
        if (this.p != null) {
            v vVar = this.p;
            vVar.i.removeMessages(15);
            vVar.i.obtainMessage(15, new Object[]{Boolean.valueOf(z), str}).sendToTarget();
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setTouchPoint(String str) {
        setHeaderInfo("touch_point", str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setTracerData(JSONObject jSONObject) {
        if (this.o != null) {
            this.o.a("tracer_data", jSONObject);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setUriRuntime(UriConfig uriConfig) {
        if (this.p != null) {
            v vVar = this.p;
            vVar.n = uriConfig;
            vVar.a(vVar.j);
            if (vVar.d.b.isAutoActive()) {
                vVar.a(true);
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setUserAgent(String str) {
        if (this.o != null) {
            n0 n0Var = this.o;
            if (n0Var.a(com.alipay.sdk.cons.b.b, (Object) str)) {
                a.a(n0Var.f21265c.e, com.alipay.sdk.cons.b.b, str);
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setUserID(long j) {
        this.p.m.f21339a = j;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setUserUniqueID(String str) {
        if (this.p != null) {
            this.p.a(str);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setViewId(Dialog dialog, String str) {
        if (dialog == null || dialog.getWindow() == null) {
            return;
        }
        dialog.getWindow().getDecorView().setTag(R.id.applog_tag_view_id, str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setViewId(View view, String str) {
        if (view == null) {
            return;
        }
        view.setTag(R.id.applog_tag_view_id, str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setViewId(Object obj, String str) {
        String str2;
        if (obj == null) {
            return;
        }
        if (!j1.a(obj, "androidx.appcompat.app.AlertDialog", "androidx.appcompat.app.AlertDialog")) {
            z2.b("Only support AlertDialog view.");
            return;
        }
        try {
            Window window = (Window) obj.getClass().getMethod("getWindow", new Class[0]).invoke(obj, new Object[0]);
            if (window != null) {
                window.getDecorView().setTag(R.id.applog_tag_view_id, str);
            }
        } catch (NoSuchMethodException e) {
            e = e;
            str2 = "Not found getWindow method in alertDialog.";
            z2.a(str2, e);
        } catch (Exception e2) {
            e = e2;
            str2 = "Cannot set viewId for alertDialog.";
            z2.a(str2, e);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setViewProperties(View view, JSONObject jSONObject) {
        if (view == null || jSONObject == null) {
            return;
        }
        this.f21200a.put(j1.a(view), jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void start() {
        if (this.s) {
            return;
        }
        this.s = true;
        v vVar = this.p;
        if (vVar.q) {
            return;
        }
        vVar.q = true;
        vVar.o.sendEmptyMessage(1);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void startSimulator(String str) {
        if (this.p != null) {
            v vVar = this.p;
            t tVar = vVar.r;
            if (tVar != null) {
                tVar.setStop(true);
            }
            Class<?> b = j1.b("com.bytedance.applog.picker.DomSender");
            if (b != null) {
                try {
                    Constructor<?> constructor = b.getConstructor(v.class, String.class);
                    new HandlerThread("bd_tracker_d_" + vVar.f21325c.l).start();
                    vVar.r = (t) constructor.newInstance(vVar, str);
                    vVar.i.sendMessage(vVar.i.obtainMessage(9, vVar.r));
                } catch (Exception e) {
                    z2.c("U SHALL NOT PASS!", e);
                }
            }
        }
    }

    public String toString() {
        StringBuilder a2 = a.a("AppLogInstance{id:");
        a2.append(E.get());
        a2.append(";appId:");
        a2.append(this.l);
        a2.append("}@");
        a2.append(hashCode());
        return a2.toString();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void trackClick(View view) {
        trackClick(view, null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void trackClick(View view, JSONObject jSONObject) {
        v1 a2 = b3.a(view, false);
        if (a2 != null && jSONObject != null) {
            a2.m = jSONObject;
        }
        receive(a2);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void trackPage(Activity activity) {
        trackPage(activity, (JSONObject) null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void trackPage(Activity activity, JSONObject jSONObject) {
        a(activity, jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void trackPage(Object obj) {
        trackPage(obj, (JSONObject) null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void trackPage(Object obj, JSONObject jSONObject) {
        a(obj, jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void userProfileSetOnce(JSONObject jSONObject, UserProfileCallback userProfileCallback) {
        if (this.p != null) {
            v vVar = this.p;
            if (vVar.i != null) {
                o1.a(vVar, 0, jSONObject, userProfileCallback, vVar.i, false);
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void userProfileSync(JSONObject jSONObject, UserProfileCallback userProfileCallback) {
        if (this.p != null) {
            v vVar = this.p;
            if (vVar.i != null) {
                o1.a(vVar, 1, jSONObject, userProfileCallback, vVar.i, false);
            }
        }
    }
}
