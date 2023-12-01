package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.e;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.y;
import com.umeng.analytics.process.UMProcessDBDatasSender;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/u.class */
public class u implements y.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f27090a = "session_start_time";
    public static final String b = "session_end_time";

    /* renamed from: c  reason: collision with root package name */
    public static final String f27091c = "session_id";
    public static final String d = "pre_session_id";
    public static final String e = "a_start_time";
    public static final String f = "a_end_time";
    public static final String g = "fg_count";
    private static String h;
    private static Context i;
    private static boolean j = false;
    private static long k = 0;
    private static boolean l = true;
    private static long m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/u$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final u f27092a = new u();

        private a() {
        }
    }

    private u() {
        y.a().a(this);
    }

    public static long a(Context context) {
        try {
            return PreferenceWrapper.getDefault(context).getLong(g, 0L);
        } catch (Throwable th) {
            return 0L;
        }
    }

    public static u a() {
        return a.f27092a;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00da -> B:34:0x0092). Please submit an issue!!! */
    private void a(Context context, String str, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(h)) {
            h = y.a().a(i);
        }
        if (TextUtils.isEmpty(str) || str.equals(h)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(e.d.a.g, j3);
            jSONObject.put(e.d.a.h, j4);
            JSONObject b2 = com.umeng.analytics.b.a().b();
            if (b2 != null && b2.length() > 0) {
                jSONObject.put("__sp", b2);
            }
            JSONObject c2 = com.umeng.analytics.b.a().c();
            if (c2 != null && c2.length() > 0) {
                jSONObject.put("__pp", c2);
            }
            i.a(context).a(h, jSONObject, i.a.END);
        } catch (Exception e2) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__e", j2);
            i.a(context).a(str, jSONObject2, i.a.BEGIN);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                m = j4;
                d(context);
                UMWorkDispatch.sendEventEx(i, 8213, CoreProtocol.getInstance(i), null, 0L);
            }
        } catch (Exception e3) {
        }
        h = str;
    }

    private void a(String str, long j2) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(i);
        if (sharedPreferences == null) {
            return;
        }
        long j3 = sharedPreferences.getLong(b, 0L);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", str);
            jSONObject.put("__e", j2);
            jSONObject.put(e.d.a.g, j3);
            double[] location = AnalyticsConfig.getLocation();
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("lat", location[0]);
                jSONObject2.put("lng", location[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put(e.d.a.e, jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Method method = cls.getMethod("getUidRxBytes", Integer.TYPE);
            Method method2 = cls.getMethod("getUidTxBytes", Integer.TYPE);
            int i2 = i.getApplicationInfo().uid;
            if (i2 == -1) {
                return;
            }
            long longValue = ((Long) method.invoke(null, Integer.valueOf(i2))).longValue();
            long longValue2 = ((Long) method2.invoke(null, Integer.valueOf(i2))).longValue();
            if (longValue > 0 && longValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(d.H, longValue);
                jSONObject3.put(d.G, longValue2);
                jSONObject.put(e.d.a.d, jSONObject3);
            }
            i.a(i).a(str, jSONObject, i.a.NEWSESSION);
            v.a(i);
            l.c(i);
        } catch (Throwable th) {
        }
    }

    public static void b(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(i);
        if (sharedPreferences != null) {
            long j2 = sharedPreferences.getLong(g, 0L);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.putLong(g, j2 + 1);
                edit.commit();
            }
        }
    }

    private void d(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putLong(g, 0L);
            edit.commit();
        } catch (Throwable th) {
        }
    }

    private String e(Context context) {
        if (i == null && context != null) {
            i = context.getApplicationContext();
        }
        String d2 = y.a().d(i);
        try {
            f(context);
            o.a(i).d((Object) null);
            return d2;
        } catch (Throwable th) {
            return d2;
        }
    }

    private void f(Context context) {
        o.a(context).b(context);
        o.a(context).d();
    }

    public String a(Context context, long j2, boolean z) {
        String b2 = y.a().b(context);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onInstantSessionInternal: current session id = " + b2);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", j2);
            JSONObject b3 = com.umeng.analytics.b.a().b();
            if (b3 != null && b3.length() > 0) {
                jSONObject.put("__sp", b3);
            }
            JSONObject c2 = com.umeng.analytics.b.a().c();
            if (c2 != null && c2.length() > 0) {
                jSONObject.put("__pp", c2);
            }
            i.a(context).a(b2, jSONObject, i.a.INSTANTSESSIONBEGIN);
            o.a(context).a(jSONObject, z);
            return b2;
        } catch (Throwable th) {
            return b2;
        }
    }

    public void a(Context context, long j2) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(i);
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putLong(f27090a, j2);
        edit.commit();
    }

    public void a(Context context, Object obj) {
        SharedPreferences.Editor edit;
        try {
            if (i == null && context != null) {
                i = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(i);
            if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
                return;
            }
            String string = sharedPreferences.getString(d.az, "");
            String appVersionName = UMUtils.getAppVersionName(i);
            if (TextUtils.isEmpty(string)) {
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(d.az, appVersionName);
                edit.commit();
            } else if (!string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onStartSessionInternal: upgrade version: " + string + "-> " + appVersionName);
                int i2 = sharedPreferences.getInt("versioncode", 0);
                String string2 = sharedPreferences.getString("pre_date", "");
                String string3 = sharedPreferences.getString("pre_version", "");
                String string4 = sharedPreferences.getString(d.az, "");
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(d.az, appVersionName);
                edit.putString("vers_date", string2);
                edit.putString("vers_pre_version", string3);
                edit.putString("cur_version", string4);
                edit.putInt("vers_code", i2);
                edit.putString("vers_name", string);
                edit.commit();
                if (l) {
                    l = false;
                }
                if (j) {
                    j = false;
                    b(i, longValue, true);
                    b(i, longValue);
                    return;
                }
                return;
            }
            if (j) {
                j = false;
                if (l) {
                    l = false;
                }
                h = e(context);
                MLog.d("创建新会话: " + h);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "mSessionChanged flag has been set, Start new session: " + h);
                return;
            }
            h = sharedPreferences.getString("session_id", null);
            edit.putLong(e, longValue);
            edit.putLong(f, 0L);
            edit.commit();
            MLog.d("延续上一个会话: " + h);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "Extend current session: " + h);
            if (l) {
                l = false;
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    UMWorkDispatch.sendEventEx(i, 8213, CoreProtocol.getInstance(i), null, 0L);
                }
            }
            f(context);
            o.a(i).a(false);
        } catch (Throwable th) {
        }
    }

    @Override // com.umeng.analytics.pro.y.a
    public void a(String str, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, j2);
    }

    @Override // com.umeng.analytics.pro.y.a
    public void a(String str, String str2, long j2, long j3, long j4) {
        a(i, str2, j2, j3, j4);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "saveSessionToDB: complete");
        if (AnalyticsConstants.SUB_PROCESS_EVENT) {
            Context context = i;
            UMWorkDispatch.sendEvent(context, 36945, UMProcessDBDatasSender.getInstance(context), Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Deprecated
    public String b() {
        return h;
    }

    public void b(Context context, long j2) {
        if (PreferenceWrapper.getDefault(context) == null) {
            return;
        }
        try {
            o.a(i).c((Object) null);
        } catch (Throwable th) {
        }
    }

    public void b(Context context, Object obj) {
        try {
            if (i == null) {
                i = UMGlobalContext.getAppContext(context);
            }
            long currentTimeMillis = obj == null ? System.currentTimeMillis() : ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(i);
            if (sharedPreferences == null) {
                return;
            }
            k = sharedPreferences.getLong(f, 0L);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime: " + k);
            String string = sharedPreferences.getString(d.az, "");
            String appVersionName = UMUtils.getAppVersionName(i);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null) {
                return;
            }
            if (TextUtils.isEmpty(string) || string.equals(appVersionName)) {
                if (!y.a().e(i)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> less then 30 sec from last session, do nothing.");
                    j = false;
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> More then 30 sec from last session.");
                j = true;
                edit.putLong(f27090a, currentTimeMillis);
                edit.commit();
                a(i, currentTimeMillis, false);
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> requestNewInstantSessionIf: version upgrade");
            edit.putLong(f27090a, currentTimeMillis);
            edit.commit();
            o.a(i).a((Object) null, true);
            String c2 = y.a().c(i);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> force generate new session: session id = " + c2);
            j = true;
            a(i, currentTimeMillis, true);
        } catch (Throwable th) {
        }
    }

    public boolean b(Context context, long j2, boolean z) {
        String a2;
        long j3;
        boolean z2 = false;
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null || (a2 = y.a().a(i)) == null) {
                return false;
            }
            long j4 = sharedPreferences.getLong(e, 0L);
            long j5 = sharedPreferences.getLong(f, 0L);
            boolean z3 = false;
            if (j4 > 0) {
                z3 = false;
                if (j5 == 0) {
                    if (z) {
                        if (k == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("------>>> lastActivityEndTime = 0, In-app upgrade, use currentTime: = ");
                            sb.append(j2);
                            UMRTLog.i(UMRTLog.RTLOG_TAG, sb.toString());
                            j3 = j2;
                        } else {
                            j3 = k;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("------>>> lastActivityEndTime != 0, app upgrade, use lastActivityEndTime: = ");
                            sb2.append(k);
                            UMRTLog.i(UMRTLog.RTLOG_TAG, sb2.toString());
                        }
                        c(i, Long.valueOf(j3));
                    } else {
                        c(i, Long.valueOf(j2));
                        j3 = j2;
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (z) {
                        jSONObject.put(e.d.a.g, j3);
                    } else {
                        jSONObject.put(e.d.a.g, j2);
                    }
                    JSONObject b2 = com.umeng.analytics.b.a().b();
                    if (b2 != null && b2.length() > 0) {
                        jSONObject.put("__sp", b2);
                    }
                    JSONObject c2 = com.umeng.analytics.b.a().c();
                    if (c2 != null && c2.length() > 0) {
                        jSONObject.put("__pp", c2);
                    }
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("--->>>*** foregroundCount = ");
                        sb3.append(m);
                        UMRTLog.e(UMRTLog.RTLOG_TAG, sb3.toString());
                        jSONObject.put(e.d.a.h, m);
                        m = 0L;
                    } else {
                        jSONObject.put(e.d.a.h, 0L);
                    }
                    i.a(context).a(a2, jSONObject, i.a.END);
                    z2 = true;
                    o.a(i).e();
                    z3 = true;
                }
            }
            return z3;
        } catch (Throwable th) {
            return z2;
        }
    }

    @Deprecated
    public String c() {
        return c(i);
    }

    @Deprecated
    public String c(Context context) {
        try {
            if (h == null) {
                return PreferenceWrapper.getDefault(context).getString("session_id", null);
            }
        } catch (Throwable th) {
        }
        return h;
    }

    public void c(Context context, Object obj) {
        try {
            if (i == null && context != null) {
                i = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return;
            }
            if (sharedPreferences.getLong(e, 0L) == 0) {
                MLog.e("onPause called before onResume");
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onEndSessionInternal: write activity end time = " + longValue);
            edit.putLong(f, longValue);
            edit.putLong(b, longValue);
            edit.commit();
        } catch (Throwable th) {
        }
    }
}
