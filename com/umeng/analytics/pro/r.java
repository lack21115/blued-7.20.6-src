package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/r.class */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private static final int f40775a = 0;
    private static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f40776c = 2;
    private static final int d = 3;
    private final long e;

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/r$a.class */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final r f40777a = new r();

        private a() {
        }
    }

    private r() {
        this.e = 60000L;
    }

    public static r a() {
        return a.f40777a;
    }

    private void a(JSONObject jSONObject, boolean z) {
        if (!z && jSONObject.has(d.n)) {
            jSONObject.remove(d.n);
        }
        if (jSONObject.has(d.L)) {
            jSONObject.remove(d.L);
        }
        if (jSONObject.has("error")) {
            jSONObject.remove("error");
        }
        if (jSONObject.has("ekv")) {
            jSONObject.remove("ekv");
        }
        if (jSONObject.has(d.T)) {
            jSONObject.remove(d.T);
        }
        if (jSONObject.has(d.L)) {
            jSONObject.remove(d.L);
        }
        if (jSONObject.has("userlevel")) {
            jSONObject.remove("userlevel");
        }
    }

    private JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", y.a().a(UMGlobalContext.getAppContext(null)));
            jSONObject.put("start_time", currentTimeMillis);
            jSONObject.put("end_time", currentTimeMillis + 60000);
            jSONObject.put("duration", 60000L);
            jSONArray.put(jSONObject);
            return jSONArray;
        } catch (JSONException e) {
            return jSONArray;
        }
    }

    private JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", y.a().d(UMGlobalContext.getAppContext(null)));
            jSONObject.put("start_time", currentTimeMillis);
            jSONArray.put(jSONObject);
            return jSONArray;
        } catch (JSONException e) {
            return jSONArray;
        }
    }

    public int a(Context context) {
        return Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "defcon", String.valueOf(0))).intValue();
    }

    public void a(JSONObject jSONObject, Context context) {
        int a2 = a(context);
        if (a2 == 1) {
            a(jSONObject, true);
            i.a(context).b(false, true);
        } else if (a2 == 2) {
            jSONObject.remove(d.n);
            try {
                jSONObject.put(d.n, b());
            } catch (Exception e) {
            }
            a(jSONObject, true);
            i.a(context).b(false, true);
        } else if (a2 == 3) {
            a(jSONObject, false);
            i.a(context).b(false, true);
        }
    }

    public void b(JSONObject jSONObject, Context context) {
        int a2 = a(context);
        if (a2 != 1) {
            if (a2 == 2) {
                if (jSONObject.has(d.L)) {
                    jSONObject.remove(d.L);
                }
                if (jSONObject.has(d.n)) {
                    jSONObject.remove(d.n);
                }
                try {
                    jSONObject.put(d.n, c());
                } catch (Exception e) {
                }
                i.a(context).a(false, true);
                return;
            } else if (a2 == 3) {
                if (jSONObject.has(d.L)) {
                    jSONObject.remove(d.L);
                }
                jSONObject.remove(d.n);
                i.a(context).a(false, true);
                return;
            } else {
                return;
            }
        }
        if (jSONObject.has(d.L)) {
            jSONObject.remove(d.L);
        }
        if (jSONObject.has(d.n)) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(d.n);
                int length = jSONArray.length();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (jSONObject2.has(d.au)) {
                        jSONObject2.remove(d.au);
                    }
                    if (jSONObject2.has(d.av)) {
                        jSONObject2.remove(d.av);
                    }
                    i = i2 + 1;
                }
            } catch (JSONException e2) {
            }
        }
        i.a(context).a(false, true);
    }
}
