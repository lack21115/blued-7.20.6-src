package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/s.class */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static final String f27087a = "fs_lc_tl_uapp";
    private static final String f = "-1";
    private static Context g;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f27088c;
    private final int d;
    private final int e;
    private JSONObject h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/s$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final s f27089a = new s();

        private a() {
        }
    }

    private s() {
        this.b = 128;
        this.f27088c = 256;
        this.d = 1024;
        this.e = 10;
        this.h = null;
        if (0 == 0) {
            try {
                b(g);
            } catch (Throwable th) {
            }
        }
    }

    public static s a(Context context) {
        if (g == null && context != null) {
            g = context.getApplicationContext();
        }
        return a.f27089a;
    }

    private JSONObject a(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    String key = entry.getKey();
                    if (key != null) {
                        String subStr = HelperUtils.subStr(key, 128);
                        Object value = entry.getValue();
                        if (value != null) {
                            if (value.getClass().isArray()) {
                                if (value instanceof int[]) {
                                    int[] iArr = (int[]) value;
                                    JSONArray jSONArray = new JSONArray();
                                    for (int i : iArr) {
                                        jSONArray.put(i);
                                    }
                                    jSONObject.put(subStr, jSONArray);
                                } else if (value instanceof double[]) {
                                    double[] dArr = (double[]) value;
                                    JSONArray jSONArray2 = new JSONArray();
                                    int i2 = 0;
                                    while (true) {
                                        int i3 = i2;
                                        if (i3 >= dArr.length) {
                                            break;
                                        }
                                        jSONArray2.put(dArr[i3]);
                                        i2 = i3 + 1;
                                    }
                                    jSONObject.put(subStr, jSONArray2);
                                } else if (value instanceof long[]) {
                                    long[] jArr = (long[]) value;
                                    JSONArray jSONArray3 = new JSONArray();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= jArr.length) {
                                            break;
                                        }
                                        jSONArray3.put(jArr[i5]);
                                        i4 = i5 + 1;
                                    }
                                    jSONObject.put(subStr, jSONArray3);
                                } else if (value instanceof float[]) {
                                    float[] fArr = (float[]) value;
                                    JSONArray jSONArray4 = new JSONArray();
                                    int i6 = 0;
                                    while (true) {
                                        int i7 = i6;
                                        if (i7 >= fArr.length) {
                                            break;
                                        }
                                        jSONArray4.put(fArr[i7]);
                                        i6 = i7 + 1;
                                    }
                                    jSONObject.put(subStr, jSONArray4);
                                } else if (value instanceof short[]) {
                                    short[] sArr = (short[]) value;
                                    JSONArray jSONArray5 = new JSONArray();
                                    int i8 = 0;
                                    while (true) {
                                        int i9 = i8;
                                        if (i9 >= sArr.length) {
                                            break;
                                        }
                                        jSONArray5.put((int) sArr[i9]);
                                        i8 = i9 + 1;
                                    }
                                    jSONObject.put(subStr, jSONArray5);
                                }
                            } else if (value instanceof List) {
                                List list = (List) value;
                                JSONArray jSONArray6 = new JSONArray();
                                int i10 = 0;
                                while (true) {
                                    int i11 = i10;
                                    if (i11 >= list.size()) {
                                        break;
                                    }
                                    Object obj = list.get(i11);
                                    if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                                        jSONArray6.put(list.get(i11));
                                    }
                                    i10 = i11 + 1;
                                }
                                if (jSONArray6.length() > 0) {
                                    jSONObject.put(subStr, jSONArray6);
                                }
                            } else if (value instanceof String) {
                                jSONObject.put(subStr, HelperUtils.subStr(value.toString(), 256));
                            } else {
                                if (!(value instanceof Long) && !(value instanceof Integer) && !(value instanceof Float) && !(value instanceof Double) && !(value instanceof Short)) {
                                    MLog.e("The param has not support type. please check !");
                                }
                                jSONObject.put(subStr, value);
                            }
                        }
                    }
                } catch (Exception e) {
                    MLog.e(e);
                }
            }
            return jSONObject;
        } catch (Exception e2) {
            return jSONObject;
        }
    }

    private void a() {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(g, "track_list", "");
            if (TextUtils.isEmpty(imprintProperty)) {
                return;
            }
            String[] split = imprintProperty.split("!");
            JSONObject jSONObject = new JSONObject();
            if (this.h != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= split.length) {
                        break;
                    }
                    String subStr = HelperUtils.subStr(split[i2], 128);
                    if (this.h.has(subStr)) {
                        jSONObject.put(subStr, this.h.get(subStr));
                    }
                    i = i2 + 1;
                }
            }
            this.h = new JSONObject();
            if (split.length >= 10) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= 10) {
                        break;
                    }
                    a(split[i4], jSONObject);
                    i3 = i4 + 1;
                }
            } else {
                for (String str : split) {
                    a(str, jSONObject);
                }
            }
            c(g);
        } catch (Exception e) {
        }
    }

    private void a(String str, JSONObject jSONObject) throws JSONException {
        String subStr = HelperUtils.subStr(str, 128);
        if (jSONObject.has(subStr)) {
            a(subStr, ((Boolean) jSONObject.get(subStr)).booleanValue());
        } else {
            a(subStr, false);
        }
    }

    private void a(String str, boolean z) {
        try {
            if (d.Y.equals(str) || d.W.equals(str) || "id".equals(str) || "ts".equals(str) || this.h.has(str)) {
                return;
            }
            this.h.put(str, z);
        } catch (Exception e) {
        }
    }

    private boolean a(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length <= 128) {
                    return true;
                }
            } catch (Exception e) {
            }
        }
        MLog.e("key is " + str + ", please check key, illegal");
        return false;
    }

    private void b(Context context) {
        try {
            String string = PreferenceWrapper.getDefault(context).getString(f27087a, null);
            if (!TextUtils.isEmpty(string)) {
                this.h = new JSONObject(string);
            }
            a();
        } catch (Exception e) {
        }
    }

    private boolean b(String str) {
        if (str == null) {
            return true;
        }
        try {
            if (str.trim().getBytes().length <= 256) {
                return true;
            }
        } catch (Exception e) {
        }
        MLog.e("value is " + str + ", please check value, illegal");
        return false;
    }

    private boolean b(Map<String, Object> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        if (!a(entry.getKey())) {
                            UMLog.aq(j.h, 0, "\\|");
                            return false;
                        } else if (entry.getValue() == null) {
                            UMLog.aq(j.i, 0, "\\|");
                            return false;
                        } else if (entry.getValue() instanceof String) {
                            if (d.aE.equals(entry.getKey())) {
                                if (!c(entry.getValue().toString())) {
                                    UMLog.aq(j.P, 0, "\\|");
                                    return false;
                                }
                            } else if ("_$!url".equals(entry.getKey())) {
                                if (!c(entry.getValue().toString())) {
                                    UMLog.aq("url参数长度超过限制。|参数url长度不能超过1024字符。", 0, "\\|");
                                    return false;
                                }
                            } else if (!b(entry.getValue().toString())) {
                                UMLog.aq(j.j, 0, "\\|");
                                return false;
                            }
                        }
                    }
                    return true;
                }
            } catch (Exception e) {
                return true;
            }
        }
        UMLog.aq(j.g, 0, "\\|");
        return false;
    }

    private void c(Context context) {
        try {
            if (this.h != null) {
                PreferenceWrapper.getDefault(g).edit().putString(f27087a, this.h.toString()).commit();
            }
        } catch (Throwable th) {
        }
    }

    private boolean c(String str) {
        if (str == null) {
            return true;
        }
        try {
            return str.trim().getBytes().length <= 1024;
        } catch (Exception e) {
            return false;
        }
    }

    public void a(String str, String str2, long j, int i, String str3) {
        try {
            if (a(str) && b(str2)) {
                if (Arrays.asList(d.aG).contains(str)) {
                    MLog.e("key is " + str + ", please check key, illegal");
                    UMLog.aq(j.m, 0, "\\|");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", currentTimeMillis);
                if (j > 0) {
                    jSONObject.put(d.W, j);
                }
                jSONObject.put("__t", 2049);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(str, str2);
                }
                String d = UMUtils.isMainProgress(g) ? y.a().d(UMGlobalContext.getAppContext(g)) : y.a().a(UMGlobalContext.getAppContext(g), currentTimeMillis);
                String str4 = d;
                if (TextUtils.isEmpty(d)) {
                    str4 = "-1";
                }
                jSONObject.put("__i", str4);
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(d.au, jSONObject2);
                        }
                    } catch (JSONException e) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(g).getProcessName(g));
                a();
                if (this.h != null && this.h.has(str) && !((Boolean) this.h.get(str)).booleanValue()) {
                    jSONObject.put(d.Y, 1);
                    this.h.put(str, true);
                    c(g);
                }
                UMWorkDispatch.sendEvent(g, 4097, CoreProtocol.getInstance(g), jSONObject);
                return;
            }
            UMLog.aq(j.l, 0, "\\|");
        } catch (Throwable th) {
        }
    }

    public void a(String str, Map<String, Object> map, long j, String str2, boolean z) {
        try {
            if (!a(str)) {
                UMLog.aq(j.f, 0, "\\|");
            } else if (b(map)) {
                if (map.size() > 100) {
                    MLog.e("map size is " + map.size() + ", please check");
                } else if (Arrays.asList(d.aG).contains(str)) {
                    MLog.e("key is " + str + ", please check key, illegal");
                    UMLog.aq(j.b, 0, "\\|");
                } else {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", str);
                    jSONObject.put("ts", System.currentTimeMillis());
                    if (j > 0) {
                        jSONObject.put(d.W, j);
                    }
                    jSONObject.put("__t", 2049);
                    ULog.i("befort ekv map, event is " + jSONObject.toString());
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        if (Arrays.asList(d.aG).contains(entry.getKey())) {
                            UMLog.aq(j.e, 0, "\\|");
                            return;
                        }
                        Object value = entry.getValue();
                        if (!(value instanceof String) && !(value instanceof Integer) && !(value instanceof Long) && !(value instanceof Short) && !(value instanceof Float) && !(value instanceof Double)) {
                            if (!value.getClass().isArray()) {
                                MLog.e("please check key or value, illegal type!");
                                return;
                            } else if (value instanceof int[]) {
                                int[] iArr = (int[]) value;
                                if (iArr.length > 10) {
                                    MLog.e("please check key or value, size overlength!");
                                    return;
                                }
                                JSONArray jSONArray = new JSONArray();
                                int i = 0;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= iArr.length) {
                                        break;
                                    }
                                    jSONArray.put(iArr[i2]);
                                    i = i2 + 1;
                                }
                                jSONObject.put(entry.getKey(), jSONArray);
                            } else if (value instanceof double[]) {
                                double[] dArr = (double[]) value;
                                if (dArr.length > 10) {
                                    MLog.e("please check key or value, size overlength!");
                                    return;
                                }
                                JSONArray jSONArray2 = new JSONArray();
                                int i3 = 0;
                                while (true) {
                                    int i4 = i3;
                                    if (i4 >= dArr.length) {
                                        break;
                                    }
                                    jSONArray2.put(dArr[i4]);
                                    i3 = i4 + 1;
                                }
                                jSONObject.put(entry.getKey(), jSONArray2);
                            } else if (value instanceof long[]) {
                                long[] jArr = (long[]) value;
                                if (jArr.length > 10) {
                                    MLog.e("please check key or value, size overlength!");
                                    return;
                                }
                                JSONArray jSONArray3 = new JSONArray();
                                int i5 = 0;
                                while (true) {
                                    int i6 = i5;
                                    if (i6 >= jArr.length) {
                                        break;
                                    }
                                    jSONArray3.put(jArr[i6]);
                                    i5 = i6 + 1;
                                }
                                jSONObject.put(entry.getKey(), jSONArray3);
                            } else if (value instanceof float[]) {
                                float[] fArr = (float[]) value;
                                if (fArr.length > 10) {
                                    MLog.e("please check key or value, size overlength!");
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
                                jSONObject.put(entry.getKey(), jSONArray4);
                            } else if (value instanceof short[]) {
                                short[] sArr = (short[]) value;
                                if (sArr.length > 10) {
                                    MLog.e("please check key or value, size overlength!");
                                    return;
                                }
                                JSONArray jSONArray5 = new JSONArray();
                                int i9 = 0;
                                while (true) {
                                    int i10 = i9;
                                    if (i10 >= sArr.length) {
                                        break;
                                    }
                                    jSONArray5.put((int) sArr[i10]);
                                    i9 = i10 + 1;
                                }
                                jSONObject.put(entry.getKey(), jSONArray5);
                            } else if (!(value instanceof String[])) {
                                MLog.e("please check key or value, illegal type!");
                                return;
                            } else {
                                String[] strArr = (String[]) value;
                                if (strArr.length > 10) {
                                    MLog.e("please check key or value, size overlength!");
                                    return;
                                }
                                JSONArray jSONArray6 = new JSONArray();
                                int i11 = 0;
                                while (true) {
                                    int i12 = i11;
                                    if (i12 >= strArr.length) {
                                        jSONObject.put(entry.getKey(), jSONArray6);
                                        break;
                                    } else if (strArr[i12] == null) {
                                        MLog.e("please check array, null item!");
                                        return;
                                    } else if (!b(strArr[i12])) {
                                        return;
                                    } else {
                                        jSONArray6.put(strArr[i12]);
                                        i11 = i12 + 1;
                                    }
                                }
                            }
                        }
                        jSONObject.put(entry.getKey(), value);
                    }
                    String d = UMUtils.isMainProgress(g) ? y.a().d(UMGlobalContext.getAppContext(g)) : y.a().a(UMGlobalContext.getAppContext(g), jSONObject.getLong("ts"));
                    String str3 = d;
                    if (TextUtils.isEmpty(d)) {
                        str3 = "-1";
                    }
                    jSONObject.put("__i", str3);
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(str2);
                            if (jSONObject2.length() > 0) {
                                jSONObject.put(d.au, jSONObject2);
                            }
                        } catch (JSONException e) {
                        }
                    }
                    jSONObject.put("ds", 0);
                    jSONObject.put("pn", UMGlobalContext.getInstance(g).getProcessName(g));
                    a();
                    if (this.h != null && this.h.has(str) && !((Boolean) this.h.get(str)).booleanValue()) {
                        jSONObject.put(d.Y, 1);
                        this.h.put(str, true);
                        c(g);
                    }
                    ULog.i("----->>>>>ekv event json is " + jSONObject.toString());
                    if (z) {
                        UMWorkDispatch.sendEvent(g, o.a.n, CoreProtocol.getInstance(g), jSONObject);
                    } else {
                        UMWorkDispatch.sendEvent(g, 4097, CoreProtocol.getInstance(g), jSONObject);
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    public void a(String str, Map<String, Object> map, String str2) {
        try {
            if (a(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put(d.W, 0);
                jSONObject.put("__t", i.b);
                ULog.i("befort gkv map, event is " + jSONObject.toString());
                Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 10 || !it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, Object> next = it.next();
                    if (!d.Y.equals(next.getKey()) && !d.W.equals(next.getKey()) && !"id".equals(next.getKey()) && !"ts".equals(next.getKey())) {
                        Object value = next.getValue();
                        if ((value instanceof String) || (value instanceof Integer) || (value instanceof Long)) {
                            jSONObject.put(next.getKey(), value);
                        }
                    }
                    i = i2 + 1;
                }
                String d = y.a().d(UMGlobalContext.getAppContext(g));
                String str3 = d;
                if (TextUtils.isEmpty(d)) {
                    str3 = "-1";
                }
                jSONObject.put("__i", str3);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(d.au, jSONObject2);
                        }
                    } catch (JSONException e) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(g).getProcessName(g));
                ULog.i("----->>>>>gkv event json is " + jSONObject.toString());
                UMWorkDispatch.sendEvent(g, 4098, CoreProtocol.getInstance(g), jSONObject);
            }
        } catch (Throwable th) {
        }
    }

    public void a(List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    a();
                    if (this.h == null) {
                        this.h = new JSONObject();
                        int size = list.size();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= size) {
                                break;
                            }
                            if (this.h != null) {
                                if (this.h.length() >= 5) {
                                    break;
                                }
                            } else {
                                this.h = new JSONObject();
                            }
                            String str = list.get(i2);
                            if (!TextUtils.isEmpty(str)) {
                                a(HelperUtils.subStr(str, 128), false);
                            }
                            i = i2 + 1;
                        }
                        c(g);
                        return;
                    } else if (this.h.length() >= 5) {
                        MLog.d("already setFistLaunchEvent, igone.");
                        return;
                    } else {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                c(g);
                                return;
                            } else if (this.h.length() >= 5) {
                                MLog.d(" add setFistLaunchEvent over.");
                                return;
                            } else {
                                a(HelperUtils.subStr(list.get(i4), 128), false);
                                i3 = i4 + 1;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                return;
            }
        }
        UMLog.aq(j.ak, 0, "\\|");
    }
}
