package com.umeng.commonsdk.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.umeng.analytics.pro.bh;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.a;
import com.umeng.commonsdk.internal.utils.d;
import com.umeng.commonsdk.internal.utils.j;
import com.umeng.commonsdk.internal.utils.k;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/internal/d.class */
public class d {
    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a_pr", Build.PRODUCT);
            jSONObject.put("a_bl", Build.BOOTLOADER);
            if (Build.VERSION.SDK_INT >= 14) {
                jSONObject.put("a_rv", Build.getRadioVersion());
            }
            jSONObject.put("a_fp", Build.FINGERPRINT);
            jSONObject.put("a_hw", Build.HARDWARE);
            jSONObject.put("a_host", Build.HOST);
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray = new JSONArray();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= Build.SUPPORTED_32_BIT_ABIS.length) {
                        break;
                    }
                    jSONArray.put(Build.SUPPORTED_32_BIT_ABIS[i2]);
                    i = i2 + 1;
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("a_s32", jSONArray);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray2 = new JSONArray();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Build.SUPPORTED_64_BIT_ABIS.length) {
                        break;
                    }
                    jSONArray2.put(Build.SUPPORTED_64_BIT_ABIS[i4]);
                    i3 = i4 + 1;
                }
                if (jSONArray2.length() > 0) {
                    jSONObject.put("a_s64", jSONArray2);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray3 = new JSONArray();
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= Build.SUPPORTED_ABIS.length) {
                        break;
                    }
                    jSONArray3.put(Build.SUPPORTED_ABIS[i6]);
                    i5 = i6 + 1;
                }
                if (jSONArray3.length() > 0) {
                    jSONObject.put("a_sa", jSONArray3);
                }
            }
            jSONObject.put("a_ta", Build.TAGS);
            jSONObject.put("a_uk", "unknown");
            jSONObject.put("a_user", Build.USER);
            jSONObject.put("a_cpu1", Build.CPU_ABI);
            jSONObject.put("a_cpu2", Build.CPU_ABI2);
            jSONObject.put("a_ra", Build.RADIO);
            if (Build.VERSION.SDK_INT >= 23) {
                jSONObject.put("a_bos", Build.VERSION.BASE_OS);
                jSONObject.put("a_pre", Build.VERSION.PREVIEW_SDK_INT);
                jSONObject.put("a_sp", Build.VERSION.SECURITY_PATCH);
            }
            jSONObject.put("a_cn", Build.VERSION.CODENAME);
            jSONObject.put("a_intl", Build.VERSION.INCREMENTAL);
            return jSONObject;
        } catch (Exception e) {
            return jSONObject;
        }
    }

    public static void a(Context context) {
        try {
            ULog.i("walle", "[internal] workEvent send envelope");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(bh.aQ, a.e);
            JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, d(context), UMServerURL.PATH_ANALYTICS, "i", a.e);
            if (buildEnvelopeWithExtHeader == null || buildEnvelopeWithExtHeader.has("exception")) {
                return;
            }
            ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getApplicationContext().getPackageManager()) == null) {
            return;
        }
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        a(jSONObject2, "gp", packageManager.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS));
        a(jSONObject2, "to", packageManager.hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN));
        a(jSONObject2, "mo", packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY));
        a(jSONObject2, com.igexin.push.core.b.Y, packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA));
        a(jSONObject2, "fl", packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH));
    }

    private static void a(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (z) {
                jSONObject.put(str, 1);
            } else {
                jSONObject.put(str, 0);
            }
        } catch (Exception e) {
        }
    }

    private static JSONObject b() {
        JSONObject jSONObject = null;
        try {
            d.a a2 = com.umeng.commonsdk.internal.utils.d.a();
            if (a2 != null) {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("pro", a2.f40877a);
                    jSONObject.put("pla", a2.b);
                    jSONObject.put("cpus", a2.f40878c);
                    jSONObject.put("fea", a2.d);
                    jSONObject.put("imp", a2.e);
                    jSONObject.put("arc", a2.f);
                    jSONObject.put("var", a2.g);
                    jSONObject.put("par", a2.h);
                    jSONObject.put("rev", a2.i);
                    jSONObject.put("har", a2.j);
                    jSONObject.put("rev", a2.k);
                    jSONObject.put("ser", a2.l);
                    jSONObject.put("cur_cpu", com.umeng.commonsdk.internal.utils.d.d());
                    jSONObject.put("max_cpu", com.umeng.commonsdk.internal.utils.d.b());
                    jSONObject.put("min_cpu", com.umeng.commonsdk.internal.utils.d.c());
                    jSONObject.put("ts", System.currentTimeMillis());
                } catch (Exception e) {
                }
            }
            return jSONObject;
        } catch (Exception e2) {
            return null;
        }
    }

    public static void b(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context != null) {
            j(context);
        }
    }

    private static void b(Context context, JSONObject jSONObject) {
        if (context != null) {
            String a2 = k.a(context);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(a2);
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject == null) {
                    jSONObject3 = new JSONObject();
                }
                if (jSONObject2.has(k.d)) {
                    jSONObject3.put(k.d, jSONObject2.opt(k.d));
                }
                if (jSONObject2.has(k.f40885c)) {
                    jSONObject3.put(k.f40885c, jSONObject2.opt(k.f40885c));
                }
                if (jSONObject2.has(k.b)) {
                    jSONObject3.put(k.b, jSONObject2.opt(k.b));
                }
            } catch (Exception e) {
            }
        }
    }

    public static void c(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context == null || !UMEnvelopeBuild.getTransmissionSendFlag()) {
            return;
        }
        j(context);
    }

    public static JSONObject d(Context context) {
        JSONObject b;
        JSONArray h;
        JSONObject a2;
        JSONArray l;
        JSONArray k;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.J) && (k = k(applicationContext)) != null && k.length() > 0) {
                    jSONObject2.put("rs", k);
                }
            } catch (Exception e) {
                UMCrashManager.reportCrash(applicationContext, e);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.ao) && (l = l(applicationContext)) != null && l.length() > 0) {
                    jSONObject2.put("by", l);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(applicationContext, e2);
            }
            try {
                a(applicationContext, jSONObject2);
            } catch (Exception e3) {
                UMCrashManager.reportCrash(applicationContext, e3);
            }
            try {
                b(applicationContext, jSONObject2);
            } catch (Exception e4) {
                UMCrashManager.reportCrash(applicationContext, e4);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.ap) && (a2 = a()) != null && a2.length() > 0) {
                    jSONObject2.put("build", a2);
                }
            } catch (Exception e5) {
                UMCrashManager.reportCrash(applicationContext, e5);
            }
            try {
                JSONObject e6 = e(applicationContext);
                if (e6 != null && e6.length() > 0) {
                    jSONObject2.put("scr", e6);
                }
            } catch (Exception e7) {
                UMCrashManager.reportCrash(applicationContext, e7);
            }
            try {
                JSONObject f = f(applicationContext);
                if (f != null && f.length() > 0) {
                    jSONObject2.put("sinfo", f);
                }
            } catch (Exception e8) {
                UMCrashManager.reportCrash(applicationContext, e8);
            }
            try {
                JSONArray g = g(applicationContext);
                if (g != null && g.length() > 0) {
                    jSONObject2.put("input", g);
                }
            } catch (Exception e9) {
                UMCrashManager.reportCrash(applicationContext, e9);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.ag) && (h = h(applicationContext)) != null && h.length() > 0) {
                    jSONObject2.put("appls", h);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(applicationContext, e10);
            }
            try {
                JSONObject i = i(applicationContext);
                if (i != null && i.length() > 0) {
                    jSONObject2.put("mem", i);
                }
            } catch (Exception e11) {
                UMCrashManager.reportCrash(applicationContext, e11);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.aq) && (b = b()) != null && b.length() > 0) {
                    jSONObject2.put("cpu", b);
                }
            } catch (Exception e12) {
            }
            try {
                jSONObject.put(bh.ax, jSONObject2);
                return jSONObject;
            } catch (JSONException e13) {
                UMCrashManager.reportCrash(applicationContext, e13);
            }
        }
        return jSONObject;
    }

    public static JSONObject e(Context context) {
        DisplayMetrics displayMetrics;
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            try {
                jSONObject.put("a_st_h", com.umeng.commonsdk.internal.utils.a.c(context));
                jSONObject.put("a_nav_h", com.umeng.commonsdk.internal.utils.a.d(context));
                if (context.getResources() != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
                    jSONObject.put("a_den", displayMetrics.density);
                    jSONObject.put("a_dpi", displayMetrics.densityDpi);
                    return jSONObject;
                }
            } catch (Exception e) {
                UMCrashManager.reportCrash(context, e);
            }
        }
        return jSONObject;
    }

    public static JSONObject f(Context context) {
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            String packageName = applicationContext.getPackageName();
            try {
                jSONObject.put("a_fit", com.umeng.commonsdk.internal.utils.a.a(applicationContext, packageName));
                jSONObject.put("a_alut", com.umeng.commonsdk.internal.utils.a.b(applicationContext, packageName));
                jSONObject.put("a_c", com.umeng.commonsdk.internal.utils.a.c(applicationContext, packageName));
                jSONObject.put("a_uid", com.umeng.commonsdk.internal.utils.a.d(applicationContext, packageName));
                if (com.umeng.commonsdk.internal.utils.a.a()) {
                    jSONObject.put("a_root", 1);
                } else {
                    jSONObject.put("a_root", 0);
                }
                jSONObject.put("tf", com.umeng.commonsdk.internal.utils.a.b());
                jSONObject.put("s_fs", com.umeng.commonsdk.internal.utils.a.a(applicationContext));
                jSONObject.put("a_meid", DeviceConfig.getMeid(applicationContext));
                jSONObject.put("a_imsi", DeviceConfig.getImsi(applicationContext));
                jSONObject.put("st", com.umeng.commonsdk.internal.utils.a.c());
                String simICCID = DeviceConfig.getSimICCID(applicationContext);
                if (!TextUtils.isEmpty(simICCID)) {
                    try {
                        jSONObject.put("a_iccid", simICCID);
                    } catch (Exception e) {
                    }
                }
                String secondSimIMEi = DeviceConfig.getSecondSimIMEi(applicationContext);
                if (!TextUtils.isEmpty(secondSimIMEi)) {
                    try {
                        jSONObject.put("a_simei", secondSimIMEi);
                    } catch (Exception e2) {
                    }
                }
                jSONObject.put(AdvanceSetting.HEAD_UP_NOTIFICATION, com.umeng.commonsdk.internal.utils.a.d());
                jSONObject.put("ts", System.currentTimeMillis());
                return jSONObject;
            } catch (Exception e3) {
                UMCrashManager.reportCrash(applicationContext, e3);
            }
        }
        return jSONObject;
    }

    public static JSONArray g(Context context) {
        Context applicationContext;
        List<InputMethodInfo> f;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (f = com.umeng.commonsdk.internal.utils.a.f((applicationContext = context.getApplicationContext()))) != null) {
            for (InputMethodInfo inputMethodInfo : f) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("a_id", inputMethodInfo.getId());
                    jSONObject.put("a_pn", inputMethodInfo.getPackageName());
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONArray.put(jSONObject);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(applicationContext, th);
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray h(Context context) {
        Context applicationContext;
        List<a.C1082a> g;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (g = com.umeng.commonsdk.internal.utils.a.g((applicationContext = context.getApplicationContext()))) != null && !g.isEmpty()) {
            for (a.C1082a c1082a : g) {
                if (c1082a != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("a_pn", c1082a.f40870a);
                        jSONObject.put("a_la", c1082a.b);
                        jSONObject.put("ts", System.currentTimeMillis());
                        jSONArray.put(jSONObject);
                    } catch (Exception e) {
                        UMCrashManager.reportCrash(applicationContext, e);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject i(Context context) {
        Context applicationContext;
        ActivityManager.MemoryInfo h;
        JSONObject jSONObject = new JSONObject();
        if (context != null && (h = com.umeng.commonsdk.internal.utils.a.h((applicationContext = context.getApplicationContext()))) != null) {
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    jSONObject.put("t", h.totalMem);
                }
                jSONObject.put("f", h.availMem);
                jSONObject.put("ts", System.currentTimeMillis());
                return jSONObject;
            } catch (Exception e) {
                UMCrashManager.reportCrash(applicationContext, e);
            }
        }
        return jSONObject;
    }

    private static void j(Context context) {
        try {
            if (UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                UMWorkDispatch.sendEvent(context, 32769, b.a(context).a(), null, 5000L);
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 冷启动：5秒后触发2号数据仓遗留信封检查动作。");
            UMWorkDispatch.sendEvent(context, a.v, b.a(context).a(), null, 5000L);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    private static JSONArray k(Context context) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        JSONArray jSONArray3 = null;
        if (context != null) {
            JSONArray jSONArray4 = null;
            try {
                ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
                jSONArray3 = null;
                if (activityManager != null) {
                    List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
                    jSONArray3 = null;
                    if (runningServices != null) {
                        jSONArray3 = null;
                        if (!runningServices.isEmpty()) {
                            int i = 0;
                            while (i < runningServices.size()) {
                                JSONArray jSONArray5 = jSONArray2;
                                if (runningServices.get(i) != null) {
                                    jSONArray5 = jSONArray2;
                                    if (runningServices.get(i).service != null) {
                                        jSONArray5 = jSONArray2;
                                        if (runningServices.get(i).service.getClassName() != null) {
                                            JSONArray jSONArray6 = jSONArray2;
                                            jSONArray5 = jSONArray2;
                                            if (runningServices.get(i).service.getPackageName() != null) {
                                                JSONArray jSONArray7 = jSONArray2;
                                                try {
                                                    JSONObject jSONObject = new JSONObject();
                                                    JSONArray jSONArray8 = jSONArray2;
                                                    jSONObject.put("sn", runningServices.get(i).service.getClassName().toString());
                                                    JSONArray jSONArray9 = jSONArray2;
                                                    jSONObject.put("pn", runningServices.get(i).service.getPackageName().toString());
                                                    jSONArray5 = jSONArray2;
                                                    if (jSONArray2 == null) {
                                                        jSONArray5 = new JSONArray();
                                                    }
                                                    JSONArray jSONArray10 = jSONArray5;
                                                    jSONArray5.put(jSONObject);
                                                } catch (JSONException e) {
                                                    jSONArray5 = jSONArray7;
                                                }
                                            }
                                        }
                                    }
                                }
                                i++;
                                jSONArray2 = jSONArray5;
                            }
                            jSONArray3 = jSONArray2;
                            if (jSONArray2 != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                JSONArray jSONArray11 = jSONArray2;
                                try {
                                    jSONObject2.put("ts", System.currentTimeMillis());
                                    JSONArray jSONArray12 = jSONArray2;
                                    jSONObject2.put("ls", jSONArray2);
                                } catch (JSONException e2) {
                                }
                                JSONArray jSONArray13 = jSONArray2;
                                JSONObject jSONObject3 = new JSONObject();
                                JSONArray jSONArray14 = jSONArray2;
                                try {
                                    jSONObject3.put("sers", jSONObject2);
                                } catch (JSONException e3) {
                                }
                                jSONArray4 = jSONArray2;
                                jSONArray = new JSONArray();
                                try {
                                    jSONArray.put(jSONObject3);
                                    return jSONArray;
                                } catch (Throwable th) {
                                    th = th;
                                    UMCrashManager.reportCrash(context, th);
                                    jSONArray3 = jSONArray;
                                    return jSONArray3;
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                jSONArray = jSONArray4;
            }
        }
        return jSONArray3;
    }

    private static JSONArray l(Context context) {
        JSONArray jSONArray = new JSONArray();
        String a2 = j.a(context);
        if (!TextUtils.isEmpty(a2)) {
            try {
                jSONArray.put(new JSONObject(a2));
            } catch (Exception e) {
                return jSONArray;
            }
        }
        return jSONArray;
    }
}
