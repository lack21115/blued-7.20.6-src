package com.umeng.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.d;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.j;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.m;
import com.umeng.analytics.pro.n;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.p;
import com.umeng.analytics.pro.s;
import com.umeng.analytics.pro.t;
import com.umeng.analytics.pro.u;
import com.umeng.analytics.pro.v;
import com.umeng.analytics.pro.y;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/b.class */
public class b implements n, t {
    private static final String A = "umsp_2";
    private static final String B = "umsp_3";
    private static final String C = "umsp_4";
    private static final String D = "umsp_5";

    /* renamed from: a  reason: collision with root package name */
    private static Context f26910a;
    private static final String h = "sp_uapp";
    private static final String i = "prepp_uapp";
    private static final int o = 128;
    private static final int p = 256;
    private static String q = "";
    private static String r = "";
    private static final String t = "ekv_bl_ver";
    private static final String w = "ekv_wl_ver";
    private static final String z = "umsp_1";
    private ISysListener b;

    /* renamed from: c  reason: collision with root package name */
    private p f26911c;
    private v d;
    private k e;
    private u f;
    private l g;
    private boolean j;
    private volatile JSONObject k;
    private volatile JSONObject l;
    private volatile JSONObject m;
    private boolean n;
    private com.umeng.analytics.filter.a u;
    private com.umeng.analytics.filter.b x;
    private m y;
    private static final String s = d.al;
    private static final String v = d.am;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/b$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f26912a = new b();

        private a() {
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f26910a = appContext.getApplicationContext();
        }
    }

    private b() {
        this.f26911c = new p();
        this.d = new v();
        this.e = new k();
        this.f = u.a();
        this.g = null;
        this.j = false;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.u = null;
        this.x = null;
        this.y = null;
        this.f26911c.a(this);
    }

    public static b a() {
        return a.f26912a;
    }

    private void a(Context context, String str, Map<String, Object> map, long j, boolean z2) {
        try {
            if (context == null) {
                MLog.e("context is null in onEventNoCheck, please check!");
                return;
            }
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            if (!this.j || !this.n) {
                a(f26910a);
            }
            if (c(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str2 = "";
            if (this.k == null) {
                this.k = new JSONObject();
            } else {
                str2 = this.k.toString();
            }
            s.a(f26910a).a(str, map, j, str2, z2);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    private void a(String str, Object obj) {
        try {
            if (this.k == null) {
                this.k = new JSONObject();
            }
            if (obj.getClass().isArray()) {
                if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    if (strArr.length > 10) {
                        return;
                    }
                    JSONArray jSONArray = new JSONArray();
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        if (strArr[i2] != null && !HelperUtils.checkStrLen(strArr[i2], 256)) {
                            jSONArray.put(strArr[i2]);
                        }
                    }
                    this.k.put(str, jSONArray);
                } else if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    JSONArray jSONArray2 = new JSONArray();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= jArr.length) {
                            this.k.put(str, jSONArray2);
                            return;
                        } else {
                            jSONArray2.put(jArr[i4]);
                            i3 = i4 + 1;
                        }
                    }
                } else if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    JSONArray jSONArray3 = new JSONArray();
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= iArr.length) {
                            this.k.put(str, jSONArray3);
                            return;
                        } else {
                            jSONArray3.put(iArr[i6]);
                            i5 = i6 + 1;
                        }
                    }
                } else if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    JSONArray jSONArray4 = new JSONArray();
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        if (i8 >= fArr.length) {
                            this.k.put(str, jSONArray4);
                            return;
                        } else {
                            jSONArray4.put(fArr[i8]);
                            i7 = i8 + 1;
                        }
                    }
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    JSONArray jSONArray5 = new JSONArray();
                    int i9 = 0;
                    while (true) {
                        int i10 = i9;
                        if (i10 >= dArr.length) {
                            this.k.put(str, jSONArray5);
                            return;
                        } else {
                            jSONArray5.put(dArr[i10]);
                            i9 = i10 + 1;
                        }
                    }
                } else if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    JSONArray jSONArray6 = new JSONArray();
                    int i11 = 0;
                    while (true) {
                        int i12 = i11;
                        if (i12 >= sArr.length) {
                            this.k.put(str, jSONArray6);
                            return;
                        } else {
                            jSONArray6.put((int) sArr[i12]);
                            i11 = i12 + 1;
                        }
                    }
                }
            } else if (!(obj instanceof List)) {
                if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                    this.k.put(str, obj);
                }
            } else {
                List list = (List) obj;
                JSONArray jSONArray7 = new JSONArray();
                int i13 = 0;
                while (true) {
                    int i14 = i13;
                    if (i14 >= list.size()) {
                        this.k.put(str, jSONArray7);
                        return;
                    }
                    Object obj2 = list.get(i14);
                    if ((obj2 instanceof String) || (obj2 instanceof Long) || (obj2 instanceof Integer) || (obj2 instanceof Float) || (obj2 instanceof Double) || (obj2 instanceof Short)) {
                        jSONArray7.put(list.get(i14));
                    }
                    i13 = i14 + 1;
                }
            }
        } catch (Throwable th) {
        }
    }

    private boolean b(String str, Object obj) {
        int i2;
        try {
            if (TextUtils.isEmpty(str)) {
                MLog.e("key is " + str + ", please check key, illegal");
                return false;
            }
            try {
                i2 = str.getBytes("UTF-8").length;
            } catch (UnsupportedEncodingException e) {
                i2 = 0;
            }
            if (i2 > 128) {
                MLog.e("key length is " + i2 + ", please check key, illegal");
                return false;
            } else if (obj instanceof String) {
                if (((String) obj).getBytes("UTF-8").length > 256) {
                    MLog.e("value length is " + ((String) obj).getBytes("UTF-8").length + ", please check value, illegal");
                    return false;
                }
                return true;
            } else if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof Float)) {
                return true;
            } else {
                MLog.e("value is " + obj + ", please check value, type illegal");
                return false;
            }
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean c(String str) {
        if (this.u.enabled() && this.u.matchHit(str)) {
            return true;
        }
        if (this.x.enabled()) {
            if (this.x.matchHit(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> white list match! id = " + str);
                return false;
            }
            return true;
        }
        return false;
    }

    private void i(Context context) {
        try {
            if (context == null) {
                MLog.e("unexpected null context in getNativeSuperProperties");
                return;
            }
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (this.k == null) {
                this.k = new JSONObject();
            }
            if (this.l == null) {
                this.l = new JSONObject();
            }
            String string = sharedPreferences.getString(i, null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.m = new JSONObject(string);
                } catch (JSONException e) {
                }
            }
            if (this.m == null) {
                this.m = new JSONObject();
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(double d, double d2) {
        Context context = f26910a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setLocation can not be called in child process");
            return;
        }
        if (AnalyticsConfig.f26900a == null) {
            AnalyticsConfig.f26900a = new double[2];
        }
        AnalyticsConfig.f26900a[0] = d;
        AnalyticsConfig.f26900a[1] = d2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        Context context = f26910a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setSessionContinueMillis can not be called in child process");
            return;
        }
        AnalyticsConfig.kContinueSessionMillis = j;
        y.a().a(AnalyticsConfig.kContinueSessionMillis);
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            if (this.u == null) {
                com.umeng.analytics.filter.a aVar = new com.umeng.analytics.filter.a(s, "ekv_bl_ver");
                this.u = aVar;
                aVar.register(f26910a);
            }
            if (this.x == null) {
                com.umeng.analytics.filter.b bVar = new com.umeng.analytics.filter.b(v, "ekv_wl_ver");
                this.x = bVar;
                bVar.register(f26910a);
            }
            if (UMUtils.isMainProgress(f26910a)) {
                if (!this.j) {
                    this.j = true;
                    i(f26910a);
                }
                if (Build.VERSION.SDK_INT > 13) {
                    synchronized (this) {
                        if (!this.n) {
                            l a2 = l.a(context);
                            this.g = a2;
                            if (a2.a()) {
                                this.n = true;
                            }
                            this.y = m.a();
                            try {
                                m.a(context);
                                this.y.a(this);
                            } catch (Throwable th) {
                            }
                        }
                    }
                } else {
                    this.n = true;
                }
                if (UMConfigure.isDebugLog()) {
                    UMLog.mutlInfo(j.B, 3, "", null, null);
                }
                UMWorkDispatch.registerConnStateObserver(CoreProtocol.getInstance(f26910a));
            }
        } catch (Throwable th2) {
        }
    }

    public void a(Context context, int i2) {
        if (context == null) {
            MLog.e("unexpected null context in setVerticalType");
            return;
        }
        if (f26910a == null) {
            f26910a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f26910a)) {
            MLog.e("setVerticalType can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(f26910a);
        }
        AnalyticsConfig.a(f26910a, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, MobclickAgent.EScenarioType eScenarioType) {
        if (context == null) {
            MLog.e("unexpected null context in setScenarioType");
            return;
        }
        if (f26910a == null) {
            f26910a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f26910a)) {
            MLog.e("setScenarioType can not be called in child process");
            return;
        }
        if (eScenarioType != null) {
            a(f26910a, eScenarioType.toValue());
        }
        if (this.j && this.n) {
            return;
        }
        a(f26910a);
    }

    void a(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.w, 0, "\\|");
            return;
        }
        if (f26910a == null) {
            f26910a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f26910a)) {
            MLog.e("reportError can not be called in child process");
        } else if (TextUtils.isEmpty(str)) {
            if (UMConfigure.isDebugLog()) {
                UMLog.aq(j.x, 0, "\\|");
            }
        } else {
            try {
                if (!this.j || !this.n) {
                    a(f26910a);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put(d.Q, 2);
                jSONObject.put("context", str);
                jSONObject.put("__ii", this.f.c());
                UMWorkDispatch.sendEvent(f26910a, 4106, CoreProtocol.getInstance(f26910a), jSONObject);
            } catch (Throwable th) {
                if (MLog.DEBUG) {
                    MLog.e(th);
                }
            }
        }
    }

    public void a(Context context, String str, Object obj) {
        synchronized (this) {
            if (context == null) {
                UMLog.aq(j.af, 0, "\\|");
                return;
            }
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("registerSuperProperty can not be called in child process");
                return;
            }
            if (!this.j || !this.n) {
                a(f26910a);
            }
            if (TextUtils.isEmpty(str) || obj == null) {
                UMLog.aq(j.ag, 0, "\\|");
            } else if (!str.equals(z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
                MLog.e("property name is " + str + ", please check key, must be correct!");
            } else if ((obj instanceof String) && !HelperUtils.checkStrLen(obj.toString(), 256)) {
                MLog.e("property value is " + obj + ", please check value, lawless!");
            } else {
                try {
                    if (this.k == null) {
                        this.k = new JSONObject();
                    }
                    if (!obj.getClass().isArray()) {
                        if (!(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Short)) {
                            MLog.e("please check value, illegal type!");
                            return;
                        }
                        this.k.put(str, obj);
                    } else if (obj instanceof String[]) {
                        String[] strArr = (String[]) obj;
                        if (strArr.length > 10) {
                            MLog.e("please check value, size is " + strArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray = new JSONArray();
                        for (int i2 = 0; i2 < strArr.length; i2++) {
                            if (strArr[i2] != null && HelperUtils.checkStrLen(strArr[i2], 256)) {
                                jSONArray.put(strArr[i2]);
                            }
                            MLog.e("please check value, length is " + strArr[i2].length() + ", overlength 256!");
                            return;
                        }
                        this.k.put(str, jSONArray);
                    } else if (obj instanceof long[]) {
                        long[] jArr = (long[]) obj;
                        if (jArr.length > 10) {
                            MLog.e("please check value, size is " + jArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray2 = new JSONArray();
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= jArr.length) {
                                break;
                            }
                            jSONArray2.put(jArr[i4]);
                            i3 = i4 + 1;
                        }
                        this.k.put(str, jSONArray2);
                    } else if (obj instanceof int[]) {
                        int[] iArr = (int[]) obj;
                        if (iArr.length > 10) {
                            MLog.e("please check value, size is " + iArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray3 = new JSONArray();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= iArr.length) {
                                break;
                            }
                            jSONArray3.put(iArr[i6]);
                            i5 = i6 + 1;
                        }
                        this.k.put(str, jSONArray3);
                    } else if (obj instanceof float[]) {
                        float[] fArr = (float[]) obj;
                        if (fArr.length > 10) {
                            MLog.e("please check value, size is " + fArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray4 = new JSONArray();
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            if (i8 >= fArr.length) {
                                break;
                            }
                            jSONArray4.put(fArr[i8]);
                            i7 = i8 + 1;
                        }
                        this.k.put(str, jSONArray4);
                    } else if (obj instanceof double[]) {
                        double[] dArr = (double[]) obj;
                        if (dArr.length > 10) {
                            MLog.e("please check value, size is " + dArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray5 = new JSONArray();
                        int i9 = 0;
                        while (true) {
                            int i10 = i9;
                            if (i10 >= dArr.length) {
                                break;
                            }
                            jSONArray5.put(dArr[i10]);
                            i9 = i10 + 1;
                        }
                        this.k.put(str, jSONArray5);
                    } else if (!(obj instanceof short[])) {
                        MLog.e("please check value, illegal type!");
                        return;
                    } else {
                        short[] sArr = (short[]) obj;
                        if (sArr.length > 10) {
                            MLog.e("please check value, size is " + sArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray6 = new JSONArray();
                        int i11 = 0;
                        while (true) {
                            int i12 = i11;
                            if (i12 >= sArr.length) {
                                break;
                            }
                            jSONArray6.put((int) sArr[i12]);
                            i11 = i12 + 1;
                        }
                        this.k.put(str, jSONArray6);
                    }
                } catch (Throwable th) {
                }
                UMWorkDispatch.sendEvent(f26910a, 8195, CoreProtocol.getInstance(f26910a), this.k.toString());
            }
        }
    }

    public void a(Context context, String str, String str2, long j, int i2) {
        if (context == null) {
            return;
        }
        try {
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            if (!this.j || !this.n) {
                a(f26910a);
            }
            if (c(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str3 = "";
            if (this.k == null) {
                this.k = new JSONObject();
            } else {
                str3 = this.k.toString();
            }
            s.a(f26910a).a(str, str2, j, i2, str3);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public void a(Context context, String str, HashMap<String, Object> hashMap) {
        if (context == null) {
            return;
        }
        try {
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("onGKVEvent can not be called in child process");
                return;
            }
            if (!this.j || !this.n) {
                a(f26910a);
            }
            String str2 = "";
            if (this.k == null) {
                this.k = new JSONObject();
            } else {
                str2 = this.k.toString();
            }
            s.a(f26910a).a(str, hashMap, str2);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public void a(Context context, String str, Map<String, Object> map) {
        a(context, str, map, -1L, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, String str, Map<String, Object> map, long j) {
        try {
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.f27066c, 0, "\\|");
        } else if (Arrays.asList(d.aF).contains(str)) {
            UMLog.aq(j.b, 0, "\\|");
        } else if (map.isEmpty()) {
            UMLog.aq(j.d, 0, "\\|");
        } else {
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            do {
                if (!it.hasNext()) {
                    a(context, str, map, j, false);
                    return;
                }
            } while (!Arrays.asList(d.aF).contains(it.next().getKey()));
            UMLog.aq(j.e, 0, "\\|");
        }
    }

    void a(Context context, Throwable th) {
        if (context == null || th == null) {
            UMLog.aq(j.y, 0, "\\|");
            return;
        }
        if (f26910a == null) {
            f26910a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f26910a)) {
            MLog.e("reportError can not be called in child process");
            return;
        }
        try {
            if (!this.j || !this.n) {
                a(f26910a);
            }
            a(f26910a, DataHelper.convertExceptionToString(th));
        } catch (Exception e) {
            if (MLog.DEBUG) {
                MLog.e(e);
            }
        }
    }

    public void a(Context context, List<String> list) {
        synchronized (this) {
            try {
            } catch (Throwable th) {
                MLog.e(th);
            }
            if (context == null) {
                UMLog.aq(j.aj, 0, "\\|");
                return;
            }
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("setFirstLaunchEvent can not be called in child process");
                return;
            }
            if (!this.j || !this.n) {
                a(f26910a);
            }
            s.a(f26910a).a(list);
        }
    }

    public void a(Context context, JSONObject jSONObject) {
        String obj;
        Object obj2;
        synchronized (this) {
            if (context == null) {
                UMLog.aq(j.al, 0, "\\|");
                return;
            }
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("registerPreProperties can not be called in child process");
                return;
            }
            if (!this.j || !this.n) {
                a(f26910a);
            }
            if (this.m == null) {
                this.m = new JSONObject();
            }
            if (jSONObject == null || jSONObject.length() <= 0) {
                UMLog.aq(j.am, 0, "\\|");
                return;
            }
            JSONObject jSONObject2 = null;
            try {
                jSONObject2 = new JSONObject(this.m.toString());
            } catch (Exception e) {
            }
            JSONObject jSONObject3 = jSONObject2;
            if (jSONObject2 == null) {
                jSONObject3 = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    try {
                        obj = keys.next().toString();
                        obj2 = jSONObject.get(obj);
                    } catch (Exception e2) {
                    }
                    if (b(obj, obj2)) {
                        jSONObject3.put(obj, obj2);
                        if (jSONObject3.length() > 10) {
                            MLog.e("please check propertics, size overlength!");
                            return;
                        }
                        continue;
                    } else {
                        return;
                    }
                }
            }
            this.m = jSONObject3;
            if (this.m.length() > 0) {
                UMWorkDispatch.sendEvent(f26910a, 8199, CoreProtocol.getInstance(f26910a), this.m.toString());
            }
        }
    }

    public void a(ISysListener iSysListener) {
        if (UMUtils.isMainProgress(f26910a)) {
            this.b = iSysListener;
        } else {
            MLog.e("setSysListener can not be called in child process");
        }
    }

    public void a(Object obj) {
        synchronized (this) {
            if (f26910a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("registerSuperPropertyByCoreProtocol can not be called in child process");
                return;
            }
            if (obj != null) {
                String str = (String) obj;
                SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f26910a).edit();
                if (edit != null && !TextUtils.isEmpty(str)) {
                    edit.putString(h, this.k.toString()).commit();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        if (!UMUtils.isMainProgress(f26910a)) {
            MLog.e("onPageStart can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.d.a(str);
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        try {
            if (f26910a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("onProfileSignIn can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(d.M, str);
            jSONObject.put("uid", str2);
            jSONObject.put("ts", currentTimeMillis);
            UMWorkDispatch.sendEvent(f26910a, 4101, CoreProtocol.getInstance(f26910a), jSONObject);
            UMWorkDispatch.sendEvent(f26910a, o.a.o, CoreProtocol.getInstance(f26910a), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignIn", th);
            }
        }
    }

    @Override // com.umeng.analytics.pro.t
    public void a(Throwable th) {
        try {
            if (f26910a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("onAppCrash can not be called in child process");
            } else if (AnalyticsConfig.enable) {
                if (this.d != null) {
                    this.d.b();
                }
                l.a(f26910a, "onAppCrash");
                if (this.e != null) {
                    this.e.b();
                }
                if (this.g != null) {
                    this.g.c();
                }
                if (this.f != null) {
                    this.f.c(f26910a, Long.valueOf(System.currentTimeMillis()));
                }
                if (th != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put(d.Q, 1);
                    jSONObject.put("context", DataHelper.convertExceptionToString(th));
                    i.a(f26910a).a(this.f.c(), jSONObject.toString(), 1);
                }
                o.a(f26910a).d();
                v.a(f26910a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    l.c(f26910a);
                }
                PreferenceWrapper.getDefault(f26910a).edit().commit();
            }
        } catch (Exception e) {
            if (MLog.DEBUG) {
                MLog.e("Exception in onAppCrash", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(GL10 gl10) {
        String[] gpu = UMUtils.getGPU(gl10);
        if (gpu.length == 2) {
            AnalyticsConfig.GPU_VENDER = gpu[0];
            AnalyticsConfig.GPU_RENDERER = gpu[1];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z2) {
        Context context = f26910a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setCatchUncaughtExceptions can not be called in child process");
        } else if (AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW) {
        } else {
            AnalyticsConfig.CATCH_EXCEPTION = z2;
        }
    }

    public JSONObject b() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Context context) {
        if (context == null) {
            MLog.e("unexpected null context in onResume");
        } else if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
        } else {
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("onResume can not be called in child process");
                return;
            }
            if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
                UMLog.aq(j.o, 2, "\\|");
            }
            try {
                if (!this.j || !this.n) {
                    a(context);
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                    this.e.a(context.getClass().getName());
                }
                h();
                if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
                    q = context.getClass().getName();
                }
            } catch (Throwable th) {
                MLog.e("Exception occurred in Mobclick.onResume(). ", th);
            }
        }
    }

    public void b(Context context, String str) {
        try {
            if (context == null) {
                UMLog.aq(j.N, 0, "\\|");
                return;
            }
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("onDeepLinkReceived can not be called in child process");
                return;
            }
            if (!this.j || !this.n) {
                a(f26910a);
            }
            if (TextUtils.isEmpty(str)) {
                UMLog.aq(j.O, 0, "\\|");
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(d.aE, str);
            a(f26910a, d.aD, (Map<String, Object>) hashMap, -1L, false);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public void b(Object obj) {
        synchronized (this) {
            if (f26910a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("updateNativePrePropertiesByCoreProtocol can not be called in child process");
                return;
            }
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f26910a).edit();
            if (obj != null) {
                String str = (String) obj;
                if (edit != null && !TextUtils.isEmpty(str)) {
                    edit.putString(i, str).commit();
                }
            } else if (edit != null) {
                edit.remove(i).commit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        if (!UMUtils.isMainProgress(f26910a)) {
            MLog.e("onPageEnd can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.d.b(str);
            }
        } catch (Throwable th) {
        }
    }

    public JSONObject c() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Context context) {
        if (context == null) {
            UMLog.aq(j.p, 0, "\\|");
        } else if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
        } else {
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("onPause can not be called in child process");
                return;
            }
            if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
                UMLog.aq(j.q, 2, "\\|");
            }
            try {
                if (!this.j || !this.n) {
                    a(context);
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                    this.e.b(context.getClass().getName());
                }
                i();
            } catch (Throwable th) {
                if (MLog.DEBUG) {
                    MLog.e("Exception occurred in Mobclick.onRause(). ", th);
                }
            }
            if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
                r = context.getClass().getName();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.z, 0, "\\|");
            return;
        }
        if (f26910a == null) {
            f26910a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f26910a)) {
            MLog.e("setSecret can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(f26910a);
        }
        AnalyticsConfig.a(f26910a, str);
    }

    public JSONObject d() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("onKillProcess can not be called in child process");
                return;
            }
            if (this.g != null) {
                this.g.c();
            }
            l.a(context, "onKillProcess");
            if (this.e != null) {
                this.e.b();
            }
            if (this.d != null) {
                this.d.b();
            }
            if (f26910a != null) {
                if (this.f != null) {
                    this.f.c(f26910a, Long.valueOf(System.currentTimeMillis()));
                }
                o.a(f26910a).d();
                v.a(f26910a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    l.c(f26910a);
                }
                PreferenceWrapper.getDefault(f26910a).edit().commit();
            }
        } catch (Throwable th) {
        }
    }

    public void d(Context context, String str) {
        synchronized (this) {
            try {
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (context == null) {
                UMLog.aq(j.ah, 0, "\\|");
                return;
            }
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("unregisterSuperProperty can not be called in child process");
                return;
            }
            if (!this.j || !this.n) {
                a(f26910a);
            }
            if (TextUtils.isEmpty(str)) {
                UMLog.aq(j.ag, 0, "\\|");
            } else if (!str.equals(z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
                MLog.e("please check key or value, must be correct!");
            } else {
                if (this.k == null) {
                    this.k = new JSONObject();
                }
                if (this.k.has(str)) {
                    this.k.remove(str);
                    UMWorkDispatch.sendEvent(f26910a, 8197, CoreProtocol.getInstance(f26910a), str);
                }
            }
        }
    }

    public Object e(Context context, String str) {
        synchronized (this) {
            if (context == null) {
                UMLog.aq(j.ai, 0, "\\|");
                return null;
            }
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("getSuperProperty can not be called in child process");
                return null;
            } else if (TextUtils.isEmpty(str)) {
                UMLog.aq(j.ag, 0, "\\|");
                return null;
            } else if (!str.equals(z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
                MLog.e("please check key or value, must be correct!");
                return null;
            } else {
                if (this.k == null) {
                    this.k = new JSONObject();
                } else if (this.k.has(str)) {
                    return this.k.opt(str);
                }
                return null;
            }
        }
    }

    public String e(Context context) {
        synchronized (this) {
            if (context == null) {
                UMLog.aq(j.ai, 0, "\\|");
                return null;
            }
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("getSuperProperties can not be called in child process");
                return null;
            } else if (this.k != null) {
                return this.k.toString();
            } else {
                this.k = new JSONObject();
                return null;
            }
        }
    }

    public void e() {
        this.l = null;
    }

    public String f() {
        if (UMUtils.isMainProgress(f26910a)) {
            return q;
        }
        MLog.e("getOnResumedActivityName can not be called in child process");
        return null;
    }

    public void f(Context context) {
        synchronized (this) {
            if (context == null) {
                UMLog.aq(j.ah, 0, "\\|");
                return;
            }
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("clearSuperProperties can not be called in child process");
                return;
            }
            if (!this.j || !this.n) {
                a(f26910a);
            }
            this.k = new JSONObject();
            UMWorkDispatch.sendEvent(f26910a, 8196, CoreProtocol.getInstance(f26910a), null);
        }
    }

    public void f(Context context, String str) {
        synchronized (this) {
            if (context == null) {
                UMLog.aq(j.an, 0, "\\|");
                return;
            }
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("unregisterPreProperty can not be called in child process");
                return;
            }
            if (!this.j || !this.n) {
                a(f26910a);
            }
            if (this.m == null) {
                this.m = new JSONObject();
            }
            if (str != null && str.length() > 0) {
                if (this.m.has(str)) {
                    this.m.remove(str);
                    UMWorkDispatch.sendEvent(f26910a, 8200, CoreProtocol.getInstance(f26910a), this.m.toString());
                } else if (UMConfigure.isDebugLog()) {
                    UMLog.aq(j.ao, 0, "\\|");
                }
                return;
            }
            MLog.e("please check propertics, property is null!");
        }
    }

    public String g() {
        if (UMUtils.isMainProgress(f26910a)) {
            return r;
        }
        MLog.e("getOnPausedActivityName can not be called in child process");
        return null;
    }

    public void g(Context context) {
        synchronized (this) {
            if (context == null) {
                UMLog.aq(j.ap, 0, "\\|");
                return;
            }
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("clearPreProperties can not be called in child process");
                return;
            }
            if (!this.j || !this.n) {
                a(f26910a);
            }
            if (this.m.length() > 0) {
                UMWorkDispatch.sendEvent(f26910a, 8201, CoreProtocol.getInstance(f26910a), null);
            }
            this.m = new JSONObject();
        }
    }

    public JSONObject h(Context context) {
        synchronized (this) {
            if (context == null) {
                UMLog.aq(j.aq, 0, "\\|");
                return null;
            }
            if (f26910a == null) {
                f26910a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("getPreProperties can not be called in child process");
                return null;
            }
            if (!this.j || !this.n) {
                a(f26910a);
            }
            if (this.m == null) {
                this.m = new JSONObject();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = jSONObject;
            if (this.m.length() > 0) {
                try {
                    jSONObject2 = new JSONObject(this.m.toString());
                } catch (JSONException e) {
                    jSONObject2 = jSONObject;
                }
            }
            return jSONObject2;
        }
    }

    public void h() {
        try {
            if (f26910a != null) {
                if (!UMUtils.isMainProgress(f26910a)) {
                    MLog.e("onStartSessionInternal can not be called in child process");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                UMWorkDispatch.sendEvent(f26910a, 4352, CoreProtocol.getInstance(f26910a), Long.valueOf(currentTimeMillis));
                UMWorkDispatch.sendEvent(f26910a, 4103, CoreProtocol.getInstance(f26910a), Long.valueOf(currentTimeMillis));
            }
            if (this.b != null) {
                this.b.onAppResume();
            }
        } catch (Throwable th) {
        }
    }

    public void i() {
        try {
            if (f26910a != null) {
                if (!UMUtils.isMainProgress(f26910a)) {
                    MLog.e("onEndSessionInternal can not be called in child process");
                    return;
                }
                UMWorkDispatch.sendEvent(f26910a, o.a.h, CoreProtocol.getInstance(f26910a), Long.valueOf(System.currentTimeMillis()));
                UMWorkDispatch.sendEvent(f26910a, 4100, CoreProtocol.getInstance(f26910a), null);
                UMWorkDispatch.sendEvent(f26910a, 4099, CoreProtocol.getInstance(f26910a), null);
                UMWorkDispatch.sendEvent(f26910a, 4105, CoreProtocol.getInstance(f26910a), null);
            }
        } catch (Throwable th) {
        }
        ISysListener iSysListener = this.b;
        if (iSysListener != null) {
            iSysListener.onAppPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        try {
            if (f26910a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("onProfileSignOff can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", currentTimeMillis);
            UMWorkDispatch.sendEvent(f26910a, 4102, CoreProtocol.getInstance(f26910a), jSONObject);
            UMWorkDispatch.sendEvent(f26910a, o.a.o, CoreProtocol.getInstance(f26910a), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    public void k() {
        synchronized (this) {
            if (f26910a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("unregisterSuperPropertyByCoreProtocol can not be called in child process");
                return;
            }
            if (this.k != null) {
                SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f26910a).edit();
                edit.putString(h, this.k.toString());
                edit.commit();
            } else {
                this.k = new JSONObject();
            }
        }
    }

    public JSONObject l() {
        synchronized (this) {
            if (f26910a == null) {
                return null;
            }
            if (!UMUtils.isMainProgress(f26910a)) {
                MLog.e("getSuperPropertiesJSONObject can not be called in child process");
                return null;
            }
            if (this.k == null) {
                this.k = new JSONObject();
            }
            return this.k;
        }
    }

    public void m() {
        synchronized (this) {
            try {
                if (f26910a != null) {
                    if (!UMUtils.isMainProgress(f26910a)) {
                        MLog.e("clearSuperPropertiesByCoreProtocol can not be called in child process");
                        return;
                    }
                    SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f26910a).edit();
                    edit.remove(h);
                    edit.commit();
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.umeng.analytics.pro.n
    public void n() {
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onIntoBackground triggered.");
        if (AnalyticsConfig.enable && FieldManager.b()) {
            if (!FieldManager.allow(com.umeng.commonsdk.utils.d.D)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出发送策略: 云控控制字关闭。功能不生效");
            } else if (UMWorkDispatch.eventHasExist(8210)) {
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出时发送策略 被触发！");
                Context context = f26910a;
                UMWorkDispatch.sendEvent(context, 8210, CoreProtocol.getInstance(context), null);
            }
        }
    }
}
