package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.process.UMProcessDBHelper;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.JSONArraySortUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/o.class */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static Context f27074a;
    private static final String l = "first_activate_time";
    private static final String m = "ana_is_f";
    private static final String n = "thtstart";
    private static final String o = "dstk_last_time";
    private static final String p = "dstk_cnt";
    private static final String q = "gkvc";
    private static final String r = "ekvc";
    private static final String t = "-1";
    private static final String x = "com.umeng.umcrash.UMCrashUtils";
    private static Class<?> y;
    private static Method z;
    private c b;

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f27075c;
    private String d;
    private String e;
    private int f;
    private JSONArray g;
    private final int h;
    private int i;
    private int j;
    private long k;
    private final long s;
    private boolean u;
    private boolean v;
    private Object w;

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/o$a.class */
    public static class a {
        public static final int A = 8210;
        public static final int B = 8211;
        public static final int C = 8212;
        public static final int D = 8213;
        public static final int E = 8214;
        public static final int F = 8215;

        /* renamed from: a  reason: collision with root package name */
        public static final int f27076a = 4097;
        public static final int b = 4098;

        /* renamed from: c  reason: collision with root package name */
        public static final int f27077c = 4099;
        public static final int d = 4100;
        public static final int e = 4101;
        public static final int f = 4102;
        public static final int g = 4103;
        public static final int h = 4104;
        public static final int i = 4105;
        public static final int j = 4106;
        public static final int k = 4352;
        public static final int l = 4353;
        public static final int m = 4354;
        public static final int n = 4355;
        public static final int o = 4356;
        public static final int p = 4357;
        public static final int q = 8193;
        public static final int r = 8194;
        public static final int s = 8195;
        public static final int t = 8196;
        public static final int u = 8197;
        public static final int v = 8199;
        public static final int w = 8200;
        public static final int x = 8201;
        public static final int y = 8208;
        public static final int z = 8209;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/o$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final o f27078a = new o();

        private b() {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/o$c.class */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private ReportPolicy.ReportStrategy f27079a = null;
        private int b = -1;

        /* renamed from: c  reason: collision with root package name */
        private int f27080c = -1;
        private int d = -1;
        private int e = -1;
        private ABTest f;

        public c() {
            this.f = null;
            this.f = ABTest.getService(o.f27074a);
        }

        private ReportPolicy.ReportStrategy b(int i, int i2) {
            if (i == 0) {
                ReportPolicy.ReportStrategy reportStrategy = this.f27079a;
                return reportStrategy instanceof ReportPolicy.ReportRealtime ? reportStrategy : new ReportPolicy.ReportRealtime();
            } else if (i == 1) {
                ReportPolicy.ReportStrategy reportStrategy2 = this.f27079a;
                return reportStrategy2 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy2 : new ReportPolicy.ReportAtLaunch();
            } else if (i == 4) {
                ReportPolicy.ReportStrategy reportStrategy3 = this.f27079a;
                return reportStrategy3 instanceof ReportPolicy.ReportDaily ? reportStrategy3 : new ReportPolicy.ReportDaily(StatTracer.getInstance(o.f27074a));
            } else if (i == 5) {
                ReportPolicy.ReportStrategy reportStrategy4 = this.f27079a;
                return reportStrategy4 instanceof ReportPolicy.ReportWifiOnly ? reportStrategy4 : new ReportPolicy.ReportWifiOnly(o.f27074a);
            } else if (i == 6) {
                ReportPolicy.ReportStrategy reportStrategy5 = this.f27079a;
                if (reportStrategy5 instanceof ReportPolicy.ReportByInterval) {
                    ((ReportPolicy.ReportByInterval) reportStrategy5).setReportInterval(i2);
                    return reportStrategy5;
                }
                return new ReportPolicy.ReportByInterval(StatTracer.getInstance(o.f27074a), i2);
            } else if (i == 8) {
                ReportPolicy.ReportStrategy reportStrategy6 = this.f27079a;
                return reportStrategy6 instanceof ReportPolicy.SmartPolicy ? reportStrategy6 : new ReportPolicy.SmartPolicy(StatTracer.getInstance(o.f27074a));
            } else if (i != 11) {
                ReportPolicy.ReportStrategy reportStrategy7 = this.f27079a;
                return reportStrategy7 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy7 : new ReportPolicy.ReportAtLaunch();
            } else {
                ReportPolicy.ReportStrategy reportStrategy8 = this.f27079a;
                if (reportStrategy8 instanceof ReportPolicy.ReportQuasiRealtime) {
                    ((ReportPolicy.ReportQuasiRealtime) reportStrategy8).setReportInterval(i2);
                    return reportStrategy8;
                }
                ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new ReportPolicy.ReportQuasiRealtime();
                reportQuasiRealtime.setReportInterval(i2);
                return reportQuasiRealtime;
            }
        }

        public int a(int i) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f27074a, "test_report_interval", "-1")).intValue();
            return (intValue == -1 || intValue < 90) ? i : intValue > 86400 ? i : intValue * 1000;
        }

        public void a() {
            try {
                int[] a2 = a(-1, -1);
                this.b = a2[0];
                this.f27080c = a2[1];
            } catch (Throwable th) {
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
            if (r0 > 86400) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
            if (r0 > 3600) goto L27;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int[] a(int r7, int r8) {
            /*
                Method dump skipped, instructions count: 169
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.o.c.a(int, int):int[]");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v94, types: [com.umeng.commonsdk.statistics.common.ReportPolicy$ReportStrategy] */
        protected void b() {
            int i;
            Defcon service = Defcon.getService(o.f27074a);
            if (service.isOpen()) {
                ReportPolicy.ReportStrategy reportStrategy = this.f27079a;
                this.f27079a = (reportStrategy instanceof ReportPolicy.DefconPolicy) && reportStrategy.isValid() ? this.f27079a : new ReportPolicy.DefconPolicy(StatTracer.getInstance(o.f27074a), service);
            } else {
                boolean z = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f27074a, "integrated_test", "-1")).intValue() == 1;
                if (UMConfigure.isDebugLog() && z && !MLog.DEBUG) {
                    UMLog.mutlInfo(j.K, 3, "\\|", null, null);
                }
                if (MLog.DEBUG && z) {
                    this.f27079a = new ReportPolicy.DebugPolicy(StatTracer.getInstance(o.f27074a));
                } else if (this.f.isInTest() && "RPT".equals(this.f.getTestName())) {
                    if (this.f.getTestPolicy() == 6) {
                        if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f27074a, "test_report_interval", "-1")).intValue() != -1) {
                            i = a(com.anythink.expressad.foundation.g.a.bM);
                        } else {
                            i = this.f27080c;
                            if (i <= 0) {
                                i = this.e;
                            }
                        }
                    } else {
                        i = 0;
                    }
                    this.f27079a = b(this.f.getTestPolicy(), i);
                } else {
                    int i2 = this.d;
                    int i3 = this.e;
                    int i4 = this.b;
                    if (i4 != -1) {
                        i3 = this.f27080c;
                        i2 = i4;
                    }
                    this.f27079a = b(i2, i3);
                }
            }
            if (UMConfigure.isDebugLog()) {
                try {
                    if (this.f27079a instanceof ReportPolicy.ReportAtLaunch) {
                        UMLog.mutlInfo(j.I, 3, "", null, null);
                    } else if (this.f27079a instanceof ReportPolicy.ReportByInterval) {
                        UMLog.mutlInfo(j.J, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportByInterval) this.f27079a).getReportInterval() / 1000)});
                    } else if (this.f27079a instanceof ReportPolicy.DebugPolicy) {
                        UMLog.mutlInfo(j.L, 3, "", null, null);
                    } else if (!(this.f27079a instanceof ReportPolicy.ReportQuasiRealtime)) {
                        boolean z2 = this.f27079a instanceof ReportPolicy.DefconPolicy;
                    } else {
                        long reportInterval = ((ReportPolicy.ReportQuasiRealtime) this.f27079a).getReportInterval() / 1000;
                        UMLog uMLog = UMConfigure.umDebugLog;
                        UMLog.mutlInfo(j.M, 3, "", new String[]{"@"}, new String[]{String.valueOf(reportInterval)});
                    }
                } catch (Throwable th) {
                }
            }
        }

        public ReportPolicy.ReportStrategy c() {
            b();
            return this.f27079a;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/o$d.class */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, Object> f27081a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f27082c;
        private long d;

        private d() {
            this.f27081a = null;
            this.b = null;
            this.f27082c = null;
            this.d = 0L;
        }

        public d(String str, Map<String, Object> map, String str2, long j) {
            this.f27081a = null;
            this.b = null;
            this.f27082c = null;
            this.d = 0L;
            this.f27081a = map;
            this.b = str;
            this.d = j;
            this.f27082c = str2;
        }

        public Map<String, Object> a() {
            return this.f27081a;
        }

        public String b() {
            return this.f27082c;
        }

        public String c() {
            return this.b;
        }

        public long d() {
            return this.d;
        }
    }

    static {
        h();
    }

    private o() {
        this.b = null;
        this.f27075c = null;
        this.d = null;
        this.e = null;
        this.f = 10;
        this.g = new JSONArray();
        this.h = 5000;
        this.i = 0;
        this.j = 0;
        this.k = 0L;
        this.s = 28800000L;
        this.u = false;
        this.v = false;
        this.w = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f27074a);
            this.k = sharedPreferences.getLong(n, 0L);
            this.i = sharedPreferences.getInt(q, 0);
            this.j = sharedPreferences.getInt(r, 0);
            this.b = new c();
        } catch (Throwable th) {
        }
    }

    public static o a(Context context) {
        if (f27074a == null && context != null) {
            f27074a = context.getApplicationContext();
        }
        return b.f27078a;
    }

    private JSONObject a(JSONObject jSONObject, long j) {
        JSONObject jSONObject2 = jSONObject;
        try {
            if (q.a(jSONObject) > j) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("header");
                jSONObject3.put(com.umeng.analytics.pro.d.aB, q.a(jSONObject));
                jSONObject.put("header", jSONObject3);
                jSONObject2 = q.a(f27074a, j, jSONObject);
            }
            return jSONObject2;
        } catch (Throwable th) {
            return jSONObject;
        }
    }

    private void a(String str, String str2) {
        Method method;
        Class<?> cls = y;
        if (cls == null || (method = z) == null) {
            return;
        }
        try {
            method.invoke(cls, str, str2);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> reflect call setPuidAndProvider method of crash lib failed.");
        }
    }

    private boolean a(long j, int i) {
        if (j != 0) {
            if (System.currentTimeMillis() - j <= 28800000) {
                return i < 5000;
            }
            o();
            return true;
        }
        return true;
    }

    private boolean a(JSONArray jSONArray) {
        int i;
        int i2;
        int length = jSONArray.length();
        List asList = Arrays.asList("$$_onUMengEnterForeground", "$$_onUMengEnterBackground", "$$_onUMengEnterForegroundInitError");
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = i4;
            if (i3 >= length) {
                break;
            }
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                i2 = i;
                if (optJSONObject != null) {
                    i2 = i;
                    if (asList.contains(optJSONObject.optString("id"))) {
                        i2 = i + 1;
                    }
                }
            } catch (Throwable th) {
                i2 = i;
            }
            i3++;
            i4 = i2;
        }
        return i >= length;
    }

    private boolean a(JSONObject jSONObject) {
        int i;
        int i2;
        JSONArray optJSONArray = jSONObject.optJSONArray("ekv");
        int length = optJSONArray.length();
        if (optJSONArray != null) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                i = i4;
                if (i3 >= length) {
                    break;
                }
                try {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    Iterator<String> keys = optJSONObject.keys();
                    while (true) {
                        i2 = i;
                        if (keys.hasNext()) {
                            int i5 = i;
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(keys.next());
                            if (optJSONArray2 != null && a(optJSONArray2)) {
                                i++;
                            }
                        }
                    }
                } catch (Throwable th) {
                    i2 = i;
                }
                i3++;
                i4 = i2;
            }
            return i >= length;
        }
        return false;
    }

    private JSONObject b(JSONObject jSONObject, long j) {
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = jSONObject;
        try {
            if (q.a(jSONObject) > j) {
                jSONObject2 = null;
                i.a(f27074a).a(true, false);
                i.a(f27074a).b();
                jSONObject3 = null;
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Instant session packet overload !!! ");
            }
            return jSONObject2;
        } catch (Throwable th) {
            return jSONObject3;
        }
    }

    private void b(JSONObject jSONObject) {
        JSONObject f;
        if (i.a(UMGlobalContext.getAppContext(f27074a)).c() || (f = i.a(UMGlobalContext.getAppContext(f27074a)).f()) == null) {
            return;
        }
        String optString = f.optString("__av");
        String optString2 = f.optString("__vc");
        try {
            if (TextUtils.isEmpty(optString)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f27074a));
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), optString);
            }
            if (TextUtils.isEmpty(optString2)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f27074a));
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), optString2);
            }
        } catch (Throwable th) {
        }
    }

    private void c(JSONObject jSONObject) {
        try {
            if (i.a(f27074a).e()) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f27074a));
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f27074a));
                return;
            }
            JSONObject g = i.a(f27074a).g();
            if (g != null) {
                String optString = g.optString("__av");
                String optString2 = g.optString("__vc");
                if (TextUtils.isEmpty(optString)) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f27074a));
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), optString);
                }
                if (TextUtils.isEmpty(optString2)) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f27074a));
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), optString2);
                }
            }
        } catch (Throwable th) {
        }
    }

    private boolean c(boolean z2) {
        if (s() || AnalyticsConfig.isRealTimeDebugMode()) {
            return true;
        }
        if (this.b == null) {
            this.b = new c();
        }
        this.b.a();
        ReportPolicy.ReportStrategy c2 = this.b.c();
        boolean shouldSendMessage = c2.shouldSendMessage(z2);
        if (shouldSendMessage) {
            if (((c2 instanceof ReportPolicy.ReportByInterval) || (c2 instanceof ReportPolicy.DebugPolicy) || (c2 instanceof ReportPolicy.ReportQuasiRealtime)) && p()) {
                d();
            }
            if ((c2 instanceof ReportPolicy.DefconPolicy) && p()) {
                d();
            }
            if (UMConfigure.isDebugLog()) {
                MLog.d("数据发送策略 : " + c2.getClass().getSimpleName());
            }
        }
        return shouldSendMessage;
    }

    private void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = jSONObject2;
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                JSONObject jSONObject5 = jSONObject2;
                if (jSONObject4.has("ekv")) {
                    jSONObject2.put("ekv", jSONObject4.getJSONArray("ekv"));
                    jSONObject5 = jSONObject2;
                    if (jSONObject2.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]事件:" + jSONObject2.toString());
                        } else {
                            MLog.d("事件:" + jSONObject2.toString());
                        }
                        jSONObject5 = new JSONObject();
                    }
                }
                JSONObject jSONObject6 = jSONObject5;
                if (jSONObject4.has(com.umeng.analytics.pro.d.T)) {
                    jSONObject5.put(com.umeng.analytics.pro.d.T, jSONObject4.getJSONArray(com.umeng.analytics.pro.d.T));
                    jSONObject6 = jSONObject5;
                    if (jSONObject5.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]游戏事件:" + jSONObject5.toString());
                        } else {
                            MLog.d("游戏事件:" + jSONObject5.toString());
                        }
                        jSONObject6 = new JSONObject();
                    }
                }
                JSONObject jSONObject7 = jSONObject6;
                if (jSONObject4.has("error")) {
                    jSONObject6.put("error", jSONObject4.getJSONArray("error"));
                    jSONObject7 = jSONObject6;
                    if (jSONObject6.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]错误:" + jSONObject6.toString());
                        } else {
                            MLog.d("错误:" + jSONObject6.toString());
                        }
                        jSONObject7 = new JSONObject();
                    }
                }
                JSONObject jSONObject8 = jSONObject7;
                if (jSONObject4.has(com.umeng.analytics.pro.d.n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(com.umeng.analytics.pro.d.n);
                    JSONArray jSONArray2 = new JSONArray();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= jSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject9 = jSONArray.getJSONObject(i2);
                        if (jSONObject9 != null && jSONObject9.length() > 0) {
                            if (jSONObject9.has(com.umeng.analytics.pro.d.u)) {
                                jSONObject9.remove(com.umeng.analytics.pro.d.u);
                            }
                            jSONArray2.put(jSONObject9);
                        }
                        i = i2 + 1;
                    }
                    jSONObject7.put(com.umeng.analytics.pro.d.n, jSONArray2);
                    jSONObject8 = jSONObject7;
                    if (jSONObject7.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]会话:" + jSONObject7.toString());
                        } else {
                            MLog.d("会话:" + jSONObject7.toString());
                        }
                        jSONObject8 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.I)) {
                    jSONObject8.put(com.umeng.analytics.pro.d.I, jSONObject4.getJSONObject(com.umeng.analytics.pro.d.I));
                }
                jSONObject3 = jSONObject8;
                if (jSONObject4.has(com.umeng.analytics.pro.d.L)) {
                    jSONObject8.put(com.umeng.analytics.pro.d.L, jSONObject4.getJSONObject(com.umeng.analytics.pro.d.L));
                    jSONObject3 = jSONObject8;
                    if (jSONObject8.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]账号:" + jSONObject8.toString());
                        } else {
                            MLog.d("账号:" + jSONObject8.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has("dplus")) {
                jSONObject3.put("dplus", jSONObject.getJSONObject("dplus"));
            }
            JSONObject jSONObject10 = jSONObject3;
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header"))) {
                JSONObject jSONObject11 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"));
                jSONObject10 = jSONObject3;
                if (jSONObject11 != null) {
                    jSONObject10 = jSONObject3;
                    if (jSONObject11.length() > 0) {
                        if (jSONObject11.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                            jSONObject3.put("sdk_version", jSONObject11.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                        }
                        if (jSONObject11.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                            jSONObject3.put("device_id", jSONObject11.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                        }
                        if (jSONObject11.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                            jSONObject3.put("device_model", jSONObject11.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                        }
                        if (jSONObject11.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                            jSONObject3.put("version", jSONObject11.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                        }
                        if (jSONObject11.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                            jSONObject3.put("appkey", jSONObject11.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                        }
                        if (jSONObject11.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                            jSONObject3.put("channel", jSONObject11.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                        }
                        jSONObject10 = jSONObject3;
                        if (jSONObject3.length() > 0) {
                            MLog.d("基础信息:" + jSONObject3.toString());
                            jSONObject10 = new JSONObject();
                        }
                    }
                }
            }
            jSONObject10.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private boolean d(boolean z2) {
        if (this.b == null) {
            this.b = new c();
        }
        ReportPolicy.ReportStrategy c2 = this.b.c();
        if (c2 instanceof ReportPolicy.DefconPolicy) {
            return z2 ? ((ReportPolicy.DefconPolicy) c2).shouldSendMessageByInstant() : c2.shouldSendMessage(false);
        }
        return true;
    }

    private void e(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (!a(this.k, this.i)) {
                    return;
                }
                this.i++;
            } else if (2049 == jSONObject.getInt("__t")) {
                if (!a(this.k, this.j)) {
                    return;
                }
                this.j++;
            }
            if (AnalyticsConfig.isRealTimeDebugMode()) {
                if (this.g == null) {
                    this.g = new JSONArray();
                }
                this.g.put(jSONObject);
                i.a(f27074a).a(this.g);
                this.g = new JSONArray();
                return;
            }
            if (this.g.length() >= this.f) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** 超过10个事件，事件落库。");
                i.a(f27074a).a(this.g);
                this.g = new JSONArray();
            }
            if (this.k == 0) {
                this.k = System.currentTimeMillis();
            }
            this.g.put(jSONObject);
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = jSONObject2;
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                JSONObject jSONObject5 = jSONObject2;
                if (jSONObject4.has(com.umeng.analytics.pro.d.n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(com.umeng.analytics.pro.d.n);
                    JSONArray jSONArray2 = new JSONArray();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= jSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject6 = jSONArray.getJSONObject(i2);
                        if (jSONObject6 != null && jSONObject6.length() > 0) {
                            jSONArray2.put(jSONObject6);
                        }
                        i = i2 + 1;
                    }
                    jSONObject2.put(com.umeng.analytics.pro.d.n, jSONArray2);
                    jSONObject5 = jSONObject2;
                    if (jSONObject2.length() > 0) {
                        MLog.d("本次启动会话:" + jSONObject2.toString());
                        jSONObject5 = new JSONObject();
                    }
                }
                jSONObject3 = jSONObject5;
                if (jSONObject4.has(com.umeng.analytics.pro.d.L)) {
                    jSONObject5.put(com.umeng.analytics.pro.d.L, jSONObject4.getJSONObject(com.umeng.analytics.pro.d.L));
                    jSONObject3 = jSONObject5;
                    if (jSONObject5.length() > 0) {
                        MLog.d("本次启动账号:" + jSONObject5.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            JSONObject jSONObject7 = jSONObject3;
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header"))) {
                jSONObject7 = jSONObject3;
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header"))) {
                    JSONObject jSONObject8 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"));
                    jSONObject7 = jSONObject3;
                    if (jSONObject8 != null) {
                        jSONObject7 = jSONObject3;
                        if (jSONObject8.length() > 0) {
                            if (jSONObject8.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                                jSONObject3.put("sdk_version", jSONObject8.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                            }
                            if (jSONObject8.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                                jSONObject3.put("device_id", jSONObject8.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                            }
                            if (jSONObject8.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                                jSONObject3.put("device_model", jSONObject8.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                            }
                            if (jSONObject8.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                                jSONObject3.put("version", jSONObject8.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                            }
                            if (jSONObject8.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                                jSONObject3.put("appkey", jSONObject8.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                            }
                            if (jSONObject8.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                                jSONObject3.put("channel", jSONObject8.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                            }
                            jSONObject7 = jSONObject3;
                            if (jSONObject3.length() > 0) {
                                MLog.d("本次启动基础信息:" + jSONObject3.toString());
                                jSONObject7 = new JSONObject();
                            }
                        }
                    }
                }
            }
            jSONObject7.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private void f(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null || jSONObject.length() <= 0) {
                return;
            }
            long j = jSONObject.getLong("ts");
            b(f27074a);
            d();
            String[] a2 = com.umeng.analytics.c.a(f27074a);
            if (a2 == null || TextUtils.isEmpty(a2[0]) || TextUtils.isEmpty(a2[1])) {
                return;
            }
            u.a().a(f27074a, j);
            String c2 = y.a().c(f27074a);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + c2);
            boolean b2 = u.a().b(f27074a, j, false);
            com.umeng.analytics.c.b(f27074a);
            u.a().a(f27074a, j, true);
            if (b2) {
                u.a().b(f27074a, j);
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    private void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        try {
            if (!jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(com.umeng.analytics.pro.d.aB)) {
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject.has("content")) {
                    jSONObject2 = jSONObject.getJSONObject("content");
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (optJSONObject = jSONObject2.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && optJSONObject.length() > 0 && optJSONObject.has(com.umeng.analytics.pro.d.n)) {
                    i.a(f27074a).a(true, false);
                }
                i.a(f27074a).b();
                return;
            }
            JSONObject jSONObject3 = jSONObject;
            if (jSONObject.has("content")) {
                jSONObject3 = jSONObject.getJSONObject("content");
            }
            if (jSONObject3.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject3.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has(com.umeng.analytics.pro.d.n) && (optJSONObject2 = jSONObject4.getJSONArray(com.umeng.analytics.pro.d.n).optJSONObject(0)) != null) {
                    String optString = optJSONObject2.optString("id");
                    if (!TextUtils.isEmpty(optString)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: really delete instant session data");
                        i.a(f27074a).b(optString);
                    }
                }
            }
            i.a(f27074a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
            UMWorkDispatch.sendEvent(f27074a, 4353, CoreProtocol.getInstance(f27074a), null);
        } catch (Exception e) {
        }
    }

    private void g(Object obj) {
        try {
            b(f27074a);
            d();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null || jSONObject.length() <= 0) {
                return;
            }
            String string = jSONObject.getString(com.umeng.analytics.pro.d.M);
            String string2 = jSONObject.getString("uid");
            long j = jSONObject.getLong("ts");
            String[] a2 = com.umeng.analytics.c.a(f27074a);
            if (a2 != null && string.equals(a2[0]) && string2.equals(a2[1])) {
                return;
            }
            u.a().a(f27074a, j);
            String c2 = y.a().c(f27074a);
            boolean b2 = u.a().b(f27074a, j, false);
            com.umeng.analytics.c.a(f27074a, string, string2);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + c2);
            u.a().a(f27074a, j, true);
            if (b2) {
                u.a().b(f27074a, j);
            }
        } catch (Throwable th) {
        }
    }

    private void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            if (jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(com.umeng.analytics.pro.d.aB)) {
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject.has("content")) {
                    jSONObject2 = jSONObject.getJSONObject("content");
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                    if (!jSONObject2.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics")).has(com.umeng.analytics.pro.d.n)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Error, Should not go to this branch.");
                        return;
                    }
                    i.a(f27074a).i();
                    i.a(f27074a).h();
                    i.a(f27074a).b(true, false);
                    i.a(f27074a).a();
                    return;
                }
                return;
            }
            JSONObject jSONObject3 = jSONObject;
            if (jSONObject.has("content")) {
                jSONObject3 = jSONObject.getJSONObject("content");
            }
            if (jSONObject3.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (optJSONObject = jSONObject3.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && optJSONObject.length() > 0) {
                if (optJSONObject.has(com.umeng.analytics.pro.d.n)) {
                    i.a(f27074a).b(true, false);
                }
                if (optJSONObject.has("ekv") || optJSONObject.has(com.umeng.analytics.pro.d.T)) {
                    i.a(f27074a).h();
                }
                if (optJSONObject.has("error")) {
                    i.a(f27074a).i();
                }
            }
            i.a(f27074a).a();
        } catch (Exception e) {
        }
    }

    private static void h() {
        try {
            Class<?> cls = Class.forName(x);
            if (cls != null) {
                y = cls;
                Method declaredMethod = cls.getDeclaredMethod("setPuidAndProvider", String.class, String.class);
                if (declaredMethod != null) {
                    z = declaredMethod;
                }
            }
        } catch (Throwable th) {
        }
    }

    private void h(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null || jSONObject.length() <= 0 || !jSONObject.has("__ii")) {
                return;
            }
            String optString = jSONObject.optString("__ii");
            jSONObject.remove("__ii");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            i.a(f27074a).a(optString, obj.toString(), 2);
        } catch (Throwable th) {
        }
    }

    private void i() {
        JSONObject b2 = b(UMEnvelopeBuild.maxDataSpace(f27074a));
        if (b2 == null || b2.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) b2.opt("header");
        JSONObject jSONObject2 = (JSONObject) b2.opt("content");
        if (f27074a == null || jSONObject == null || jSONObject2 == null) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructInstantMessage: request build envelope.");
        JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(f27074a, jSONObject, jSONObject2);
        if (buildEnvelopeWithExtHeader != null) {
            try {
                if (buildEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
                }
            } catch (Throwable th) {
            }
            if (UMConfigure.isDebugLog()) {
                e(buildEnvelopeWithExtHeader);
            }
            b((Object) buildEnvelopeWithExtHeader);
        }
    }

    private void j() {
        JSONObject buildEnvelopeWithExtHeader;
        JSONObject a2 = a(UMEnvelopeBuild.maxDataSpace(f27074a));
        if (a2 == null || a2.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) a2.opt("header");
        JSONObject jSONObject2 = (JSONObject) a2.opt("content");
        Context context = f27074a;
        if (context == null || jSONObject == null || jSONObject2 == null || (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2)) == null) {
            return;
        }
        try {
            if (buildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable th) {
        }
        if (UMConfigure.isDebugLog()) {
            d(buildEnvelopeWithExtHeader);
        }
        a((Object) buildEnvelopeWithExtHeader);
    }

    private JSONObject k() {
        JSONObject l2 = l();
        if (l2 != null) {
            try {
                l2.put("st", "1");
            } catch (Throwable th) {
                return l2;
            }
        }
        return l2;
    }

    private JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (AnalyticsConfig.mWrapperType != null && AnalyticsConfig.mWrapperVersion != null) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_version"), AnalyticsConfig.mWrapperVersion);
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_type"), AnalyticsConfig.mWrapperType);
            }
            int verticalType = AnalyticsConfig.getVerticalType(f27074a);
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.i), verticalType);
            String str = "9.6.3";
            if (verticalType == 1) {
                String gameSdkVersion = AnalyticsConfig.getGameSdkVersion(f27074a);
                if (!TextUtils.isEmpty(gameSdkVersion)) {
                    str = gameSdkVersion;
                }
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), str);
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), "9.6.3");
            }
            String MD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(f27074a));
            if (!TextUtils.isEmpty(MD5)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("secret"), MD5);
            }
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f27074a, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f27074a);
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(f27074a, com.umeng.analytics.pro.d.an, "");
            if (!TextUtils.isEmpty(imprintProperty2)) {
                if (AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.ap), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.ap), imprintProperty2);
                }
            }
            String imprintProperty3 = UMEnvelopeBuild.imprintProperty(f27074a, com.umeng.analytics.pro.d.ao, "");
            if (!TextUtils.isEmpty(imprintProperty3)) {
                if (AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.aq), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.aq), imprintProperty3);
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.ah), "1.0.0");
            if (s()) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.aj), "1");
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(m, 0L).commit();
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.l), m());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.m), n());
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(string)) {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(imprintProperty)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.l), sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.m), sharedPreferences.getString("vers_date", format));
                    }
                    sharedPreferences.edit().putString("pre_version", string).putString("cur_version", DeviceConfig.getAppVersionName(f27074a)).putString("pre_date", format).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                    return jSONObject;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private String m() {
        String str = null;
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f27074a, "pr_ve", null);
            str = imprintProperty;
            if (TextUtils.isEmpty(imprintProperty)) {
                if (!TextUtils.isEmpty(this.d)) {
                    return this.d;
                }
                if (this.f27075c == null) {
                    this.f27075c = PreferenceWrapper.getDefault(f27074a);
                }
                String string = this.f27075c.getString("pre_version", "");
                String appVersionName = DeviceConfig.getAppVersionName(f27074a);
                if (TextUtils.isEmpty(string)) {
                    this.f27075c.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
                    str = "0";
                } else {
                    String string2 = this.f27075c.getString("cur_version", "");
                    if (appVersionName.equals(string2)) {
                        str = string;
                    } else {
                        this.f27075c.edit().putString("pre_version", string2).putString("cur_version", appVersionName).commit();
                        str = string2;
                    }
                }
            }
        } catch (Throwable th) {
        }
        this.d = str;
        return str;
    }

    private String n() {
        String str;
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f27074a, "ud_da", null);
            str = imprintProperty;
            if (TextUtils.isEmpty(imprintProperty)) {
                if (!TextUtils.isEmpty(this.e)) {
                    return this.e;
                }
                if (this.f27075c == null) {
                    this.f27075c = PreferenceWrapper.getDefault(f27074a);
                }
                String string = this.f27075c.getString("pre_date", "");
                if (TextUtils.isEmpty(string)) {
                    str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    this.f27075c.edit().putString("pre_date", str).commit();
                } else {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    str = string;
                    if (!string.equals(format)) {
                        this.f27075c.edit().putString("pre_date", format).commit();
                        str = format;
                    }
                }
            }
        } catch (Throwable th) {
            str = null;
        }
        this.e = str;
        return str;
    }

    private void o() {
        try {
            this.i = 0;
            this.j = 0;
            this.k = System.currentTimeMillis();
            PreferenceWrapper.getDefault(f27074a).edit().putLong(o, System.currentTimeMillis()).putInt(p, 0).commit();
        } catch (Throwable th) {
        }
    }

    private boolean p() {
        try {
            if (!TextUtils.isEmpty(u.a().b())) {
                b(f27074a);
            }
            if (this.g.length() <= 0) {
                return false;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.g.length()) {
                    return true;
                }
                JSONObject optJSONObject = this.g.optJSONObject(i2);
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    String optString = optJSONObject.optString("__i");
                    if (TextUtils.isEmpty(optString) || "-1".equals(optString)) {
                        return false;
                    }
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            return true;
        }
    }

    private void q() {
        if (this.g.length() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.g.length()) {
                this.g = jSONArray;
                return;
            }
            try {
                JSONObject jSONObject = this.g.getJSONObject(i2);
                if (jSONObject == null || jSONObject.length() <= 0) {
                    jSONArray.put(jSONObject);
                } else {
                    String optString = jSONObject.optString("__i");
                    String str = "-1";
                    if (TextUtils.isEmpty(optString) || "-1".equals(optString)) {
                        String b2 = u.a().b();
                        if (!TextUtils.isEmpty(b2)) {
                            str = b2;
                        }
                        jSONObject.put("__i", str);
                    }
                    jSONArray.put(jSONObject);
                }
            } catch (Throwable th) {
            }
            i = i2 + 1;
        }
    }

    private void r() {
        SharedPreferences sharedPreferences;
        try {
            if (!s() || f27074a == null || (sharedPreferences = PreferenceWrapper.getDefault(f27074a)) == null || sharedPreferences.getLong(l, 0L) != 0) {
                return;
            }
            sharedPreferences.edit().putLong(l, System.currentTimeMillis()).commit();
        } catch (Throwable th) {
        }
    }

    private boolean s() {
        SharedPreferences sharedPreferences;
        try {
            if (f27074a == null || (sharedPreferences = PreferenceWrapper.getDefault(f27074a)) == null) {
                return false;
            }
            return sharedPreferences.getLong(m, -1L) != 0;
        } catch (Throwable th) {
            return false;
        }
    }

    public JSONObject a(long j) {
        if (TextUtils.isEmpty(y.a().d(f27074a))) {
            return null;
        }
        JSONObject b2 = b(false);
        int a2 = r.a().a(f27074a);
        if (b2.length() > 0) {
            if (b2.length() == 1) {
                if (b2.optJSONObject(com.umeng.analytics.pro.d.L) != null && a2 != 3) {
                    return null;
                }
                if (!TextUtils.isEmpty(b2.optString("userlevel")) && a2 != 3) {
                    return null;
                }
            } else if (b2.length() == 2 && b2.optJSONObject(com.umeng.analytics.pro.d.L) != null && !TextUtils.isEmpty(b2.optString("userlevel")) && a2 != 3) {
                return null;
            }
            String optString = b2.optString(com.umeng.analytics.pro.d.n);
            String optString2 = b2.optString(com.umeng.analytics.pro.d.T);
            String optString3 = b2.optString("ekv");
            if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && a(b2)) {
                return null;
            }
        } else if (a2 != 3) {
            return null;
        }
        JSONObject l2 = l();
        if (l2 != null) {
            c(l2);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (a2 == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (b2 != null && b2.length() > 0) {
                jSONObject2.put("analytics", b2);
            }
            if (l2 != null && l2.length() > 0) {
                jSONObject.put("header", l2);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            return a(jSONObject, j);
        } catch (Throwable th) {
            return jSONObject;
        }
    }

    public void a() {
        if (f27074a != null) {
            synchronized (this.w) {
                if (this.u) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network is now available, rebuild instant session data packet.");
                    UMWorkDispatch.sendEvent(f27074a, 4353, CoreProtocol.getInstance(f27074a), null);
                }
            }
            synchronized (this.w) {
                if (this.v) {
                    UMWorkDispatch.sendEvent(f27074a, 4354, CoreProtocol.getInstance(f27074a), null);
                }
            }
        }
    }

    public void a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (!jSONObject.has("exception")) {
                        g(jSONObject);
                    } else if (101 == jSONObject.getInt("exception")) {
                    } else {
                        g(jSONObject);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public void a(Object obj, int i) {
        if (com.umeng.commonsdk.utils.c.a()) {
            if (i != 4357) {
                return;
            }
            try {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> clean db in silent mode.");
                h.a(f27074a);
                com.umeng.commonsdk.utils.c.c(f27074a);
            } catch (Throwable th) {
            }
        }
        if (AnalyticsConfig.enable) {
            try {
                switch (i) {
                    case 4097:
                        if (!UMUtils.isMainProgress(f27074a)) {
                            UMProcessDBHelper.getInstance(f27074a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f27074a), new JSONArray().put(obj));
                            return;
                        }
                        if (obj != null) {
                            e(obj);
                        }
                        if ("-1".equals(((JSONObject) obj).optString("__i"))) {
                            return;
                        }
                        a(false);
                        return;
                    case 4098:
                        if (obj != null) {
                            e(obj);
                        }
                        if ("-1".equals(((JSONObject) obj).optString("__i"))) {
                            return;
                        }
                        a(false);
                        return;
                    case 4099:
                        v.a(f27074a);
                        return;
                    case 4100:
                        l.c(f27074a);
                        return;
                    case 4101:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNIN");
                        a((Object) null, true);
                        g(obj);
                        return;
                    case 4102:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNOFF");
                        a((Object) null, true);
                        f(obj);
                        return;
                    case 4103:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> START_SESSION");
                        u.a().a(f27074a, obj);
                        synchronized (this.w) {
                            this.v = true;
                        }
                        return;
                    case a.h /* 4104 */:
                        u.a().c(f27074a, obj);
                        return;
                    case 4105:
                        d();
                        return;
                    case 4106:
                        h(obj);
                        return;
                    default:
                        switch (i) {
                            case 4352:
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> INSTANT_SESSION_START");
                                u.a().b(f27074a, obj);
                                synchronized (this.w) {
                                    this.u = true;
                                }
                                return;
                            case 4353:
                                a(obj, true);
                                return;
                            case 4354:
                                c();
                                return;
                            case a.n /* 4355 */:
                                if (!UMUtils.isMainProgress(f27074a)) {
                                    UMProcessDBHelper.getInstance(f27074a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f27074a), new JSONArray().put(obj));
                                    return;
                                } else if (obj != null) {
                                    e(obj);
                                    d();
                                    return;
                                } else {
                                    return;
                                }
                            case a.o /* 4356 */:
                                if (obj == null || y == null || z == null) {
                                    return;
                                }
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_CHANGE_NOTIFY");
                                if (obj instanceof JSONObject) {
                                    JSONObject jSONObject = (JSONObject) obj;
                                    String str = "";
                                    String str2 = "";
                                    if (jSONObject.has("uid")) {
                                        str = "";
                                        str2 = "";
                                        if (jSONObject.has(com.umeng.analytics.pro.d.M)) {
                                            str2 = jSONObject.getString(com.umeng.analytics.pro.d.M);
                                            str = jSONObject.getString("uid");
                                        }
                                    }
                                    a(str, str2);
                                    return;
                                }
                                return;
                            default:
                                switch (i) {
                                    case 8195:
                                        com.umeng.analytics.b.a().a(obj);
                                        return;
                                    case 8196:
                                        com.umeng.analytics.b.a().m();
                                        return;
                                    case 8197:
                                        com.umeng.analytics.b.a().k();
                                        return;
                                    default:
                                        switch (i) {
                                            case 8199:
                                            case 8200:
                                                com.umeng.analytics.b.a().b(obj);
                                                return;
                                            case 8201:
                                                com.umeng.analytics.b.a().b((Object) null);
                                                return;
                                            default:
                                                switch (i) {
                                                    case 8208:
                                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> receive DELAY_BUILD_ENVELOPE event.");
                                                        Context context = f27074a;
                                                        UMWorkDispatch.sendEvent(context, 8209, CoreProtocol.getInstance(context), null);
                                                        Context context2 = f27074a;
                                                        UMWorkDispatch.sendEvent(context2, 4354, CoreProtocol.getInstance(context2), null);
                                                        return;
                                                    case 8209:
                                                        a(obj, false);
                                                        return;
                                                    case 8210:
                                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv BUILD_ENVELOPE_IMMEDIATELY.");
                                                        if (!UMUtils.isMainProgress(f27074a) || (this.b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                                                            return;
                                                        }
                                                        a(true);
                                                        return;
                                                    default:
                                                        switch (i) {
                                                            case 8213:
                                                                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                                                                    if (DeviceConfig.getGlobleActivity(f27074a) != null) {
                                                                        u.b(f27074a);
                                                                    }
                                                                    Context context3 = f27074a;
                                                                    UMWorkDispatch.sendEventEx(context3, 8213, CoreProtocol.getInstance(context3), null, 5000L);
                                                                    return;
                                                                }
                                                                return;
                                                            case 8214:
                                                                if (obj != null && (obj instanceof JSONObject)) {
                                                                    String optString = ((JSONObject) obj).optString("startTime");
                                                                    String optString2 = ((JSONObject) obj).optString("period");
                                                                    String optString3 = ((JSONObject) obj).optString("debugkey");
                                                                    if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                                                                        return;
                                                                    }
                                                                    com.umeng.common.b.a(f27074a, AnalyticsConfig.RTD_SP_FILE, "startTime", optString);
                                                                    com.umeng.common.b.a(f27074a, AnalyticsConfig.RTD_SP_FILE, "period", optString2);
                                                                    com.umeng.common.b.a(f27074a, AnalyticsConfig.RTD_SP_FILE, "debugkey", optString3);
                                                                    return;
                                                                }
                                                                return;
                                                            case 8215:
                                                                com.umeng.common.b.a(f27074a, AnalyticsConfig.RTD_SP_FILE);
                                                                return;
                                                            default:
                                                                return;
                                                        }
                                                }
                                        }
                                }
                        }
                }
            } catch (Throwable th2) {
            }
        }
    }

    public void a(Object obj, boolean z2) {
        if (z2) {
            if (d(true)) {
                i();
            }
        } else if (UMEnvelopeBuild.isOnline(f27074a) && d(true)) {
            i();
        }
    }

    public void a(boolean z2) {
        if (c(z2)) {
            if (!(this.b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                if (UMEnvelopeBuild.isReadyBuild(f27074a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructMessage()");
                    j();
                }
            } else if (z2) {
                if (UMEnvelopeBuild.isOnline(f27074a)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send session start in policy ReportQuasiRealtime.");
                    j();
                }
            } else if (UMEnvelopeBuild.isReadyBuild(f27074a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send normal data in policy ReportQuasiRealtime.");
                j();
            }
        }
    }

    public JSONObject b(long j) {
        if (TextUtils.isEmpty(y.a().d(UMGlobalContext.getAppContext(f27074a)))) {
            return null;
        }
        JSONObject b2 = i.a(UMGlobalContext.getAppContext(f27074a)).b(false);
        String[] a2 = com.umeng.analytics.c.a(f27074a);
        if (a2 != null && !TextUtils.isEmpty(a2[0]) && !TextUtils.isEmpty(a2[1])) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.umeng.analytics.pro.d.M, a2[0]);
                jSONObject.put(com.umeng.analytics.pro.d.N, a2[1]);
                if (jSONObject.length() > 0) {
                    b2.put(com.umeng.analytics.pro.d.L, jSONObject);
                }
            } catch (Throwable th) {
            }
        }
        int a3 = r.a().a(f27074a);
        if (b2.length() != 1 || b2.optJSONObject(com.umeng.analytics.pro.d.L) == null || a3 == 3) {
            r.a().b(b2, f27074a);
            if (b2.length() > 0 || a3 == 3) {
                JSONObject k = k();
                if (k != null) {
                    b(k);
                }
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    if (a3 == 3) {
                        jSONObject3.put("analytics", new JSONObject());
                    } else if (b2 != 0 && b2.length() > 0) {
                        jSONObject3.put("analytics", b2);
                    }
                    if (k != null && k.length() > 0) {
                        jSONObject2.put("header", k);
                    }
                    if (jSONObject3.length() > 0) {
                        jSONObject2.put("content", jSONObject3);
                    }
                    return b(jSONObject2, j);
                } catch (Throwable th2) {
                    return jSONObject2;
                }
            }
            return null;
        }
        return null;
    }

    public JSONObject b(boolean z2) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            JSONObject a2 = i.a(f27074a).a(z2);
            if (a2 == null) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = a2;
                jSONObject2 = a2;
                try {
                    if (a2.has(com.umeng.analytics.pro.d.n)) {
                        JSONArray jSONArray = a2.getJSONArray(com.umeng.analytics.pro.d.n);
                        JSONArray jSONArray2 = new JSONArray();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= jSONArray.length()) {
                                break;
                            }
                            JSONObject jSONObject3 = (JSONObject) jSONArray.get(i2);
                            JSONArray optJSONArray = jSONObject3.optJSONArray(com.umeng.analytics.pro.d.t);
                            JSONArray optJSONArray2 = jSONObject3.optJSONArray(com.umeng.analytics.pro.d.u);
                            if (optJSONArray == null && optJSONArray2 != null) {
                                jSONObject3.put(com.umeng.analytics.pro.d.t, optJSONArray2);
                                jSONObject3.remove(com.umeng.analytics.pro.d.u);
                            }
                            if (optJSONArray != null && optJSONArray2 != null) {
                                ArrayList<JSONObject> arrayList = new ArrayList();
                                int i3 = 0;
                                while (true) {
                                    int i4 = i3;
                                    if (i4 >= optJSONArray.length()) {
                                        break;
                                    }
                                    arrayList.add((JSONObject) optJSONArray.get(i4));
                                    i3 = i4 + 1;
                                }
                                int i5 = 0;
                                while (true) {
                                    int i6 = i5;
                                    if (i6 >= optJSONArray2.length()) {
                                        break;
                                    }
                                    arrayList.add((JSONObject) optJSONArray2.get(i6));
                                    i5 = i6 + 1;
                                }
                                JSONArraySortUtil jSONArraySortUtil = new JSONArraySortUtil();
                                jSONArraySortUtil.setCompareKey(com.umeng.analytics.pro.d.x);
                                Collections.sort(arrayList, jSONArraySortUtil);
                                JSONArray jSONArray3 = new JSONArray();
                                for (JSONObject jSONObject4 : arrayList) {
                                    jSONArray3.put(jSONObject4);
                                }
                                jSONObject3.put(com.umeng.analytics.pro.d.t, jSONArray3);
                                jSONObject3.remove(com.umeng.analytics.pro.d.u);
                            }
                            if (jSONObject3.has(com.umeng.analytics.pro.d.t)) {
                                JSONArray optJSONArray3 = jSONObject3.optJSONArray(com.umeng.analytics.pro.d.t);
                                int i7 = 0;
                                while (true) {
                                    int i8 = i7;
                                    if (i8 >= optJSONArray3.length()) {
                                        break;
                                    }
                                    JSONObject jSONObject5 = optJSONArray3.getJSONObject(i8);
                                    if (jSONObject5.has(com.umeng.analytics.pro.d.x)) {
                                        jSONObject5.put("ts", jSONObject5.getLong(com.umeng.analytics.pro.d.x));
                                        jSONObject5.remove(com.umeng.analytics.pro.d.x);
                                    }
                                    i7 = i8 + 1;
                                }
                                jSONObject3.put(com.umeng.analytics.pro.d.t, optJSONArray3);
                                jSONObject3.put(com.umeng.analytics.pro.d.z, optJSONArray3.length());
                            } else {
                                jSONObject3.put(com.umeng.analytics.pro.d.z, 0);
                            }
                            jSONArray2.put(jSONObject3);
                            i = i2 + 1;
                        }
                        jSONObject2 = a2;
                        a2.put(com.umeng.analytics.pro.d.n, jSONArray2);
                        jSONObject = a2;
                    }
                } catch (Exception e) {
                    MLog.e("merge pages error");
                    e.printStackTrace();
                    jSONObject = a2;
                }
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f27074a);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("userlevel", "");
                JSONObject jSONObject6 = jSONObject;
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject7 = jSONObject;
                    jSONObject.put("userlevel", string);
                }
            }
            JSONObject jSONObject8 = jSONObject;
            String[] a3 = com.umeng.analytics.c.a(f27074a);
            if (a3 != null && !TextUtils.isEmpty(a3[0])) {
                JSONObject jSONObject9 = jSONObject;
                if (!TextUtils.isEmpty(a3[1])) {
                    JSONObject jSONObject10 = jSONObject;
                    JSONObject jSONObject11 = new JSONObject();
                    JSONObject jSONObject12 = jSONObject;
                    jSONObject11.put(com.umeng.analytics.pro.d.M, a3[0]);
                    JSONObject jSONObject13 = jSONObject;
                    jSONObject11.put(com.umeng.analytics.pro.d.N, a3[1]);
                    JSONObject jSONObject14 = jSONObject;
                    if (jSONObject11.length() > 0) {
                        JSONObject jSONObject15 = jSONObject;
                        jSONObject.put(com.umeng.analytics.pro.d.L, jSONObject11);
                    }
                }
            }
            JSONObject jSONObject16 = jSONObject;
            if (ABTest.getService(f27074a).isInTest()) {
                JSONObject jSONObject17 = jSONObject;
                JSONObject jSONObject18 = new JSONObject();
                JSONObject jSONObject19 = jSONObject;
                jSONObject18.put(ABTest.getService(f27074a).getTestName(), ABTest.getService(f27074a).getGroupInfo());
                JSONObject jSONObject20 = jSONObject;
                jSONObject.put(com.umeng.analytics.pro.d.K, jSONObject18);
            }
            jSONObject2 = jSONObject;
            r.a().a(jSONObject, f27074a);
            return jSONObject;
        } catch (Throwable th) {
            return jSONObject2;
        }
    }

    public void b() {
    }

    public void b(Context context) {
        try {
            i.a(context).d();
            q();
        } catch (Throwable th) {
        }
    }

    public void b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (!jSONObject.has("exception")) {
                        f(jSONObject);
                    } else if (101 == jSONObject.getInt("exception")) {
                    } else {
                        f(jSONObject);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public void c() {
        b(f27074a);
        d();
        a(true);
    }

    public void c(Object obj) {
        b(f27074a);
        d();
        if (d(false)) {
            j();
        }
    }

    public void d() {
        try {
            if (this.g.length() > 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** flushMemoryData: 事件落库。");
                i.a(f27074a).a(this.g);
                this.g = new JSONArray();
            }
            PreferenceWrapper.getDefault(f27074a).edit().putLong(n, this.k).putInt(q, this.i).putInt(r, this.j).commit();
        } catch (Throwable th) {
        }
    }

    public void d(Object obj) {
        r();
        m();
        n();
        a(true);
    }

    public void e() {
        if (d(false)) {
            j();
        }
    }

    public long f() {
        long j = 0;
        long j2 = 0;
        try {
            if (f27074a != null) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f27074a);
                j = 0;
                if (sharedPreferences != null) {
                    j = sharedPreferences.getLong(l, 0L);
                    if (j == 0) {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            j2 = currentTimeMillis;
                            sharedPreferences.edit().putLong(l, currentTimeMillis).commit();
                            return currentTimeMillis;
                        } catch (Throwable th) {
                        }
                    }
                }
            }
            return j;
        } catch (Throwable th2) {
            return j2;
        }
    }
}
