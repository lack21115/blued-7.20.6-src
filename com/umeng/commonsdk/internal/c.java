package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bl;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.o;
import com.umeng.ccg.CcgAgent;
import com.umeng.ccg.ConfigListener;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.UMInnerManager;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.SelfChecker;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.h;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import com.umeng.commonsdk.vchannel.Sender;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/internal/c.class */
public class c implements UMLogDataProtocol {
    public static final String b = "preInitInvokedFlag";

    /* renamed from: c  reason: collision with root package name */
    public static final String f27172c = "policyGrantInvokedFlag";
    public static final String d = "policyGrantResult";
    private static int f = 1;
    private Context e;

    /* renamed from: a  reason: collision with root package name */
    public static final String f27171a = at.b().b(at.q);
    private static Class<?> g = null;
    private static Method h = null;
    private static Method i = null;
    private static Method j = null;
    private static volatile String k = "";
    private static volatile String l = "";
    private static boolean m = false;

    static {
        c();
    }

    public c(Context context) {
        if (context != null) {
            this.e = context.getApplicationContext();
        }
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(bh.x), "Android");
            JSONObject buildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.ZCFG_PATH);
            if (buildZeroEnvelopeWithExtHeader == null || !buildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文 成功!!!");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文失败.");
            }
        } catch (Throwable th) {
        }
    }

    private static void a(Context context, final OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.2
            @Override // java.lang.Runnable
            public void run() {
                String a2 = av.a(Context.this);
                OnGetOaidListener onGetOaidListener2 = onGetOaidListener;
                if (onGetOaidListener2 != null) {
                    onGetOaidListener2.onGetOaid(a2);
                }
            }
        }).start();
    }

    public static void a(final Context context, final boolean z) {
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = Context.this.getSharedPreferences(h.f27233a, 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    String a2 = av.a(Context.this);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(a2) && sharedPreferences != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(h.f27234c, (currentTimeMillis2 - currentTimeMillis) + "");
                        edit.commit();
                    }
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        edit2.putString(h.b, a2);
                        edit2.commit();
                    }
                    if (z) {
                        UMConfigureImpl.removeInterruptFlag();
                    }
                } catch (Throwable th) {
                }
            }
        }).start();
    }

    public static String b() {
        if (TextUtils.isEmpty(l)) {
            Class<?> cls = g;
            String str = "";
            if (cls != null) {
                Method method = h;
                str = "";
                if (method != null) {
                    str = "";
                    if (j != null) {
                        try {
                            Object invoke = method.invoke(cls, new Object[0]);
                            str = "";
                            if (invoke != null) {
                                str = (String) j.invoke(invoke, new Object[0]);
                                try {
                                    l = str;
                                } catch (Throwable th) {
                                }
                            }
                        } catch (Throwable th2) {
                            return "";
                        }
                    }
                }
            }
            return str;
        }
        return l;
    }

    private void b(Context context) {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(context, bh.g, "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(bh.g), imprintProperty);
            JSONObject buildSilentEnvelopeWithExtHeader = UMEnvelopeBuild.buildSilentEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.SILENT_HEART_BEAT);
            if (buildSilentEnvelopeWithExtHeader == null || !buildSilentEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文 成功!!!");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文失败.");
            }
        } catch (Throwable th) {
        }
    }

    private static void c() {
        try {
            Class<?> cls = Class.forName("com.umeng.umzid.ZIDManager");
            if (cls != null) {
                g = cls;
                Method declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0]);
                if (declaredMethod != null) {
                    h = declaredMethod;
                }
                Method declaredMethod2 = g.getDeclaredMethod("getZID", Context.class);
                if (declaredMethod2 != null) {
                    i = declaredMethod2;
                }
                Method declaredMethod3 = g.getDeclaredMethod("getSDKVersion", new Class[0]);
                if (declaredMethod3 != null) {
                    j = declaredMethod3;
                }
            }
        } catch (Throwable th) {
        }
    }

    private static void c(final Context context) {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            a(context, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.3
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = Context.this.getSharedPreferences(h.f27233a, 0);
                        if (sharedPreferences == null || sharedPreferences.getString(h.b, "").equalsIgnoreCase(str)) {
                            return;
                        }
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(h.b, str);
                        edit.commit();
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }

    private void d() {
        bj a2 = bj.a(this.e);
        bk a3 = a2.a(bl.f26975c);
        if (a3 != null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                String str = a3.f26972a;
                String str2 = a3.b;
                JSONObject a4 = new com.umeng.commonsdk.statistics.b().a(this.e.getApplicationContext(), new JSONObject(a3.f26973c), new JSONObject(a3.d), a3.e, str2, a3.f);
                if (a4 == null || !a4.has("exception")) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。");
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                }
                a2.a(bl.f26975c, str);
                a2.b();
            } catch (Throwable th) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(android.content.Context r8) {
        /*
            r7 = this;
            r0 = r8
            if (r0 != 0) goto L5
            return
        L5:
            r0 = r8
            java.lang.String r1 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            java.lang.String r2 = "debugkey"
            java.lang.String r0 = com.umeng.common.b.a(r0, r1, r2)
            r13 = r0
            r0 = r13
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Ld1
            r0 = r8
            java.lang.String r1 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            java.lang.String r2 = "startTime"
            java.lang.String r0 = com.umeng.common.b.a(r0, r1, r2)
            r15 = r0
            r0 = r8
            java.lang.String r1 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            java.lang.String r2 = "period"
            java.lang.String r0 = com.umeng.common.b.a(r0, r1, r2)
            r14 = r0
            r0 = r15
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L45
            r0 = r15
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> Ld2
            long r0 = r0.longValue()     // Catch: java.lang.Throwable -> Ld2
            r9 = r0
            goto L47
        L45:
            r0 = 0
            r9 = r0
        L47:
            r0 = r14
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L5c
            r0 = r14
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> Ld7
            long r0 = r0.longValue()     // Catch: java.lang.Throwable -> Ld7
            r11 = r0
            goto L5f
        L5c:
            r0 = 0
            r11 = r0
        L5f:
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto Lc2
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L6f
            goto Lc2
        L6f:
            long r0 = java.lang.System.currentTimeMillis()
            r1 = r9
            long r0 = r0 - r1
            r1 = r11
            r2 = 60
            long r1 = r1 * r2
            r2 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 * r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L9b
            java.lang.String r0 = "MobclickRT"
            java.lang.String r1 = "--->>> [RTD]本地缓存dk值已经超时，清除缓存数据。"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r1)
            r0 = r8
            java.lang.String r1 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.b.a(r0, r1)
            boolean r0 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r0 == 0) goto Ld1
            com.umeng.analytics.AnalyticsConfig.turnOffRealTimeDebug()
            return
        L9b:
            java.util.HashMap r0 = new java.util.HashMap
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            java.lang.String r1 = "debugkey"
            r2 = r13
            java.lang.Object r0 = r0.put(r1, r2)
            boolean r0 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r0 != 0) goto Ld1
            java.lang.String r0 = "MobclickRT"
            java.lang.String r1 = "--->>> [RTD]本地缓存dk值在有效期内，切换到埋点验证模式。"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r1)
            r0 = r8
            com.umeng.analytics.AnalyticsConfig.turnOnRealTimeDebug(r0)
            return
        Lc2:
            java.lang.String r0 = "MobclickRT"
            java.lang.String r1 = "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r1)
            r0 = r8
            java.lang.String r1 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.b.a(r0, r1)
        Ld1:
            return
        Ld2:
            r15 = move-exception
            goto L45
        Ld7:
            r14 = move-exception
            goto L5c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.d(android.content.Context):void");
    }

    private void e() {
        if (m) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                return;
            }
            m = false;
        } else if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            m = true;
            a(this.e, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.4
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
                    if (TextUtils.isEmpty(str)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = c.this.e.getSharedPreferences(h.f27233a, 0);
                        if (sharedPreferences != null) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString(h.b, str);
                            edit.commit();
                        }
                    } catch (Throwable th) {
                    }
                    UMWorkDispatch.sendEvent(c.this.e, a.w, b.a(c.this.e).a(), null);
                }
            });
        }
    }

    private void e(Context context) {
        Object invoke;
        Method declaredMethod;
        Context applicationContext = context.getApplicationContext();
        String appkey = UMUtils.getAppkey(context);
        try {
            Class<?> a2 = a("com.umeng.umzid.ZIDManager");
            Method declaredMethod2 = a2.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(a2, new Object[0])) == null || (declaredMethod = a2.getDeclaredMethod("init", Context.class, String.class, a("com.umeng.umzid.IZIDCompletionCallback"))) == null) {
                return;
            }
            declaredMethod.invoke(invoke, applicationContext, appkey, null);
        } catch (Throwable th) {
        }
    }

    private void f() {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            m = true;
            UMConfigureImpl.registerInterruptFlag();
            UMConfigureImpl.init(this.e);
            f++;
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 要读取 oaid，需等待读取结果.");
            UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.internal.c.5
                @Override // com.umeng.commonsdk.utils.onMessageSendListener
                public void onMessageSend() {
                    if (c.this.e != null) {
                        UMWorkDispatch.sendEvent(c.this.e, a.x, b.a(c.this.e).a(), null);
                    }
                    UMConfigureImpl.removeMessageSendListener(this);
                }
            });
            a(this.e, true);
        }
    }

    private static void f(Context context) {
        File filesDir = context.getFilesDir();
        File file = new File(filesDir.getAbsolutePath() + File.separator + bl.l);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Throwable th) {
        }
    }

    private void g() {
        if (f <= 0) {
            h();
            e(this.e);
        }
    }

    private void h() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 真实构建条件满足，开始构建业务信封。");
        if (UMUtils.isMainProgress(this.e)) {
            f(this.e);
            UMInnerManager.sendInnerPackage(this.e);
            if (!FieldManager.allow(com.umeng.commonsdk.utils.d.f27276ar) && SdkVersion.SDK_TYPE == 0 && UMUtils.isMainProgress(this.e)) {
                Context context = this.e;
                UMWorkDispatch.sendEvent(context, a.G, b.a(context).a(), null, 5000L);
            }
            Context context2 = this.e;
            UMWorkDispatch.sendEvent(context2, 8208, CoreProtocol.getInstance(context2), null);
            Context context3 = this.e;
            UMWorkDispatch.sendEvent(context3, a.t, b.a(context3).a(), null);
        }
    }

    public String a() {
        if (TextUtils.isEmpty(k)) {
            Class<?> cls = g;
            String str = "";
            if (cls != null) {
                Method method = h;
                str = "";
                if (method != null) {
                    str = "";
                    if (i != null) {
                        try {
                            Object invoke = method.invoke(cls, new Object[0]);
                            str = "";
                            if (invoke != null) {
                                str = (String) i.invoke(invoke, this.e);
                                try {
                                    k = str;
                                } catch (Throwable th) {
                                }
                            }
                        } catch (Throwable th2) {
                            return "";
                        }
                    }
                }
            }
            return str;
        }
        return k;
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j2) {
        return null;
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i2) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        ULog.i("walle", "[internal] workEvent");
        if (com.umeng.commonsdk.utils.c.a()) {
            if (32802 == i2) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 静默模式：进入心跳处理逻辑!");
                long currentTimeMillis = System.currentTimeMillis();
                long b2 = com.umeng.commonsdk.utils.c.b(this.e);
                boolean e = com.umeng.commonsdk.utils.c.e(this.e);
                if (com.umeng.commonsdk.utils.c.a(b2, currentTimeMillis, com.umeng.commonsdk.utils.c.a(this.e))) {
                    if (UMFrUtils.hasEnvelopeFile(this.e, UMLogDataProtocol.UMBusinessType.U_Silent)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 静默心跳信封文件已存在，尝试发送之!");
                    } else {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建静默心跳信封.");
                        b(this.e);
                    }
                    UMEnvelopeBuild.registerNetReceiver(this.e);
                }
                if (e) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send REBUILD_DB msg in silent mode.");
                Context context = this.e;
                UMWorkDispatch.sendEvent(context, o.a.p, CoreProtocol.getInstance(context), null, 2000L);
                return;
            }
            return;
        }
        try {
            switch (i2) {
                case 32769:
                    ULog.i("walle", "[internal] workEvent send envelope");
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        String a2 = av.a(this.e);
                        long currentTimeMillis3 = System.currentTimeMillis();
                        if (!TextUtils.isEmpty(a2) && (sharedPreferences = this.e.getSharedPreferences(h.f27233a, 0)) != null) {
                            SharedPreferences.Editor edit2 = sharedPreferences.edit();
                            edit2.putString(h.b, a2);
                            edit2.putString(h.f27234c, (currentTimeMillis3 - currentTimeMillis2) + "");
                            edit2.commit();
                        }
                    } catch (Throwable th) {
                    }
                    Class<?> cls = Class.forName("com.umeng.commonsdk.internal.UMInternalManagerAgent");
                    if (cls != null) {
                        cls.getMethod("sendInternalEnvelopeByStateful2", Context.class).invoke(cls, this.e);
                        return;
                    }
                    return;
                case 32770:
                case 32772:
                case 32773:
                case 32774:
                case 32776:
                case 32778:
                case 32780:
                case a.q /* 32782 */:
                case a.r /* 32783 */:
                case 32789:
                case 32794:
                case 32795:
                case 32796:
                case 32797:
                case 32798:
                case 32799:
                case a.D /* 32802 */:
                default:
                    return;
                case 32771:
                    if (obj == null || !(obj instanceof com.umeng.commonsdk.internal.utils.b)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    com.umeng.commonsdk.internal.utils.b bVar = (com.umeng.commonsdk.internal.utils.b) obj;
                    try {
                        jSONObject.put("le", bVar.f27180a);
                        jSONObject.put("vol", bVar.b);
                        jSONObject.put("temp", bVar.f27181c);
                        jSONObject.put("st", bVar.d);
                        jSONObject.put(com.anythink.expressad.d.a.b.dx, bVar.e);
                        jSONObject.put("ts", bVar.f);
                    } catch (Throwable th2) {
                    }
                    String jSONObject2 = jSONObject.toString();
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "battery info: " + jSONObject2);
                    Class<?> cls2 = Class.forName("com.umeng.commonsdk.internal.utils.UMInternalUtilsAgent");
                    if (cls2 != null) {
                        cls2.getMethod("saveBattery", Context.class, String.class).invoke(cls2, this.e, jSONObject2);
                        return;
                    }
                    return;
                case 32775:
                    Class<?> cls3 = Class.forName("com.umeng.commonsdk.internal.utils.InfoPreferenceAgent");
                    if (cls3 != null) {
                        cls3.getMethod("saveUA", Context.class, String.class).invoke(cls3, this.e, (String) obj);
                        return;
                    }
                    return;
                case 32777:
                    ULog.i("walle", "[internal] workEvent send envelope");
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(bh.aQ, a.e);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(bh.ax, new JSONObject());
                    JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(this.e, jSONObject3, jSONObject4);
                    if (buildEnvelopeWithExtHeader == null || buildEnvelopeWithExtHeader.has("exception")) {
                        return;
                    }
                    ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
                    return;
                case 32779:
                    Sender.handleEvent(this.e, (com.umeng.commonsdk.vchannel.b) obj);
                    return;
                case a.p /* 32781 */:
                    if (UMFrUtils.hasEnvelopeFile(this.e, UMLogDataProtocol.UMBusinessType.U_ZeroEnv)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文信封文件已存在，尝试发送之!");
                        return;
                    }
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文");
                    a(this.e);
                    return;
                case a.s /* 32784 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文流程，接收到云控配置加载成功通知(成功收到零号报文应答)。");
                    f();
                    f--;
                    g();
                    UMUtils.saveSDKComponent();
                    return;
                case a.t /* 32785 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]接收到消费二级缓存数据通知.");
                    if (bj.a(this.e).c()) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]已消费完毕,二级缓存数据库为空.");
                        return;
                    }
                    d();
                    if (UMWorkDispatch.eventHasExist(a.t)) {
                        return;
                    }
                    Context context2 = this.e;
                    UMWorkDispatch.sendEvent(context2, a.t, b.a(context2).a(), null);
                    return;
                case a.u /* 32786 */:
                    UMCrashManager.buildEnvelope(this.e, obj);
                    return;
                case a.v /* 32787 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查动作。");
                    String a3 = com.umeng.commonsdk.stateless.d.a(this.e, false);
                    String a4 = com.umeng.commonsdk.stateless.d.a(this.e, true);
                    boolean z = false;
                    if (!TextUtils.isEmpty(a3)) {
                        File file = new File(a3);
                        z = false;
                        if (file.exists()) {
                            z = false;
                            if (file.isDirectory()) {
                                z = true;
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(a4)) {
                        File file2 = new File(a4);
                        if (file2.exists() && file2.isDirectory()) {
                            z = true;
                        }
                    }
                    if (!z) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查，没有需要处理的目录，不需要处理。");
                        return;
                    } else if (com.umeng.commonsdk.stateless.b.a()) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查，Sender已创建，不需要处理。");
                        return;
                    } else {
                        new com.umeng.commonsdk.stateless.b(this.e);
                        com.umeng.commonsdk.stateless.b.b();
                        return;
                    }
                case a.w /* 32788 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新，触发 伪冷启动。");
                    com.umeng.commonsdk.statistics.b.a();
                    e();
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.E) && !UMWorkDispatch.eventHasExist()) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新 前台计数器功能 打开，触发 5秒周期检查机制");
                        Context context3 = this.e;
                        UMWorkDispatch.sendEventEx(context3, 8213, CoreProtocol.getInstance(context3), null, 5000L);
                    }
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新 FirstResume功能 打开，触发 trigger");
                        l.a(this.e).b(this.e);
                        return;
                    }
                    return;
                case a.x /* 32790 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 成功接收到(OAID)读取结束通知。");
                    f--;
                    g();
                    return;
                case a.y /* 32791 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 正常冷启动流程，接收到云控配置加载成功通知。");
                    c(this.e);
                    UMInnerManager.sendInnerPackage(this.e);
                    if (!FieldManager.allow(com.umeng.commonsdk.utils.d.f27276ar) && SdkVersion.SDK_TYPE == 0 && UMUtils.isMainProgress(this.e)) {
                        Context context4 = this.e;
                        UMWorkDispatch.sendEvent(context4, a.G, b.a(context4).a(), null, 5000L);
                    }
                    e(this.e);
                    UMUtils.saveSDKComponent();
                    return;
                case a.z /* 32792 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 保存隐私授权结果.");
                    if (obj instanceof Integer) {
                        int intValue = ((Integer) obj).intValue();
                        SharedPreferences sharedPreferences2 = this.e.getApplicationContext().getSharedPreferences(f27171a, 0);
                        if (sharedPreferences2 != null) {
                            sharedPreferences2.edit().putInt("policyGrantResult", intValue).commit();
                            return;
                        }
                        return;
                    }
                    return;
                case a.A /* 32793 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 保存preInit执行结果及授权API是否调用结果.");
                    if (obj instanceof JSONObject) {
                        JSONObject jSONObject5 = (JSONObject) obj;
                        if (jSONObject5.has(a.J)) {
                            int i3 = jSONObject5.getInt(a.J);
                            int i4 = jSONObject5.getInt(a.K);
                            int i5 = jSONObject5.getInt("policyGrantResult");
                            SharedPreferences sharedPreferences3 = this.e.getApplicationContext().getSharedPreferences(f27171a, 0);
                            if (sharedPreferences3 != null && (edit = sharedPreferences3.edit()) != null) {
                                edit.putInt(b, i3);
                                edit.putInt(f27172c, i4);
                                edit.putInt("policyGrantResult", i5);
                                edit.commit();
                            }
                            File filesDir = this.e.getFilesDir();
                            File file3 = new File(filesDir.getAbsolutePath() + File.separator + bl.m);
                            if (file3.exists()) {
                                return;
                            }
                            file3.createNewFile();
                            return;
                        }
                        return;
                    }
                    return;
                case a.B /* 32800 */:
                    File filesDir2 = this.e.getFilesDir();
                    File file4 = new File(filesDir2.getAbsolutePath() + File.separator + bl.m);
                    if (file4.exists()) {
                        file4.delete();
                        return;
                    }
                    return;
                case a.C /* 32801 */:
                    SelfChecker.doCheck(this.e);
                    return;
                case a.E /* 32803 */:
                    ConnectivityManager connectivityManager = (ConnectivityManager) this.e.getSystemService(Context.CONNECTIVITY_SERVICE);
                    if (connectivityManager == null) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> ConnectivityManager is null!");
                        com.umeng.commonsdk.framework.a.a(false);
                        com.umeng.commonsdk.stateless.b.a(false);
                        return;
                    }
                    try {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo == null) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> NetworkInfo is null!");
                            com.umeng.commonsdk.framework.a.a(false);
                            com.umeng.commonsdk.stateless.b.a(false);
                            return;
                        } else if (activeNetworkInfo.isAvailable()) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network state changed: Available");
                            com.umeng.commonsdk.framework.a.a(true);
                            com.umeng.commonsdk.stateless.b.a(true);
                            return;
                        } else {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network state changed: unAvailable");
                            com.umeng.commonsdk.framework.a.a(false);
                            com.umeng.commonsdk.stateless.b.a(false);
                            return;
                        }
                    } catch (Throwable th3) {
                        com.umeng.commonsdk.framework.a.a(false);
                        com.umeng.commonsdk.stateless.b.a(false);
                        return;
                    }
                case a.F /* 32804 */:
                    d(this.e);
                    return;
                case a.G /* 32805 */:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv CLOUD_CONFIG_TRIGGER msg.");
                    CcgAgent.registerConfigListener(new ConfigListener() { // from class: com.umeng.commonsdk.internal.c.6
                        @Override // com.umeng.ccg.ConfigListener
                        public void onConfigReady(JSONObject jSONObject6) {
                            if (jSONObject6 == null || !(jSONObject6 instanceof JSONObject)) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "onConfigReady: empty config!");
                                return;
                            }
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "onConfigReady:" + jSONObject6.toString());
                            com.umeng.ccg.c.a(c.this.e, 201, com.umeng.ccg.d.a(), jSONObject6);
                        }
                    });
                    SharedPreferences a5 = aq.a(this.e);
                    if (a5 != null) {
                        long j2 = a5.getLong(aq.f26937a, 0L);
                        long j3 = j2;
                        if (j2 < Long.MAX_VALUE) {
                            j3 = j2 + 1;
                        }
                        a5.edit().putLong(aq.f26937a, j3).commit();
                    }
                    CcgAgent.init(this.e);
                    return;
            }
        } catch (Throwable th4) {
        }
    }
}
