package com.tencent.tmsqmsp.sdk.a;

import com.tencent.mapsdk.internal.oj;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/a/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static String f39675a = "Qp.RPT";

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/a/f$a.class */
    public static final class a implements Runnable {
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f39676c;

        public a(int i, JSONObject jSONObject) {
            this.b = i;
            this.f39676c = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.b(this.b, this.f39676c);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/a/f$b.class */
    public static final class b implements com.tencent.tmsqmsp.sdk.b.e {
        @Override // com.tencent.tmsqmsp.sdk.b.e
        public void a(int i, JSONObject jSONObject) {
            if (i == 161) {
                com.tencent.tmsqmsp.sdk.f.g.a(f.f39675a, 1, String.format("ret: %d", 161));
            }
        }
    }

    public static void a(String str, int i) {
        if (str != null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject a2 = d.a(3);
            if (a(a2)) {
                try {
                    jSONObject2.put(e.a(15), a2);
                    jSONObject2.put(e.a(16), new JSONObject().put("log", str));
                    jSONArray.put(jSONObject2);
                    jSONObject.put("arr", jSONArray);
                    com.tencent.tmsqmsp.sdk.f.g.a(f39675a, 1, jSONObject2.toString());
                    com.tencent.tmsqmsp.sdk.app.b.e().a(new a(i, jSONObject));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean a(JSONObject jSONObject) {
        try {
            jSONObject.put(e.a(12), c.b());
            jSONObject.put(e.a(13), c.f());
            jSONObject.put(e.a(14), c.a());
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i, JSONObject jSONObject) {
        String appID;
        if (jSONObject == null) {
            return;
        }
        String str = f39675a;
        com.tencent.tmsqmsp.sdk.f.g.a(str, 0, "Rpt: " + jSONObject);
        com.tencent.tmsqmsp.sdk.b.g b2 = com.tencent.tmsqmsp.sdk.b.g.b();
        appID = oj.getAppID();
        b2.a(3, appID, i, jSONObject, new b());
    }
}
