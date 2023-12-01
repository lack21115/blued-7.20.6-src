package com.tencent.qmsp.sdk.a;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/a/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static String f24825a = "Qp.RPT";

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/a/f$a.class */
    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f24826a;
        final /* synthetic */ JSONObject b;

        a(int i, JSONObject jSONObject) {
            this.f24826a = i;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.b(this.f24826a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/a/f$b.class */
    public static final class b implements com.tencent.qmsp.sdk.b.e {
        b() {
        }

        @Override // com.tencent.qmsp.sdk.b.e
        public void a(int i, JSONObject jSONObject) {
            if (i == 161) {
                com.tencent.qmsp.sdk.f.g.a(f.f24825a, 1, String.format("ret: %d", 161));
            }
        }
    }

    public static void a(String str, int i) {
        if (str == null || !(str instanceof String)) {
            return;
        }
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
                com.tencent.qmsp.sdk.f.g.a(f24825a, 1, jSONObject2.toString());
                com.tencent.qmsp.sdk.app.b.e().a(new a(i, jSONObject));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    protected static boolean a(JSONObject jSONObject) {
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
        String str = f24825a;
        com.tencent.qmsp.sdk.f.g.a(str, 0, "Rpt: " + jSONObject);
        com.tencent.qmsp.sdk.b.g b2 = com.tencent.qmsp.sdk.b.g.b();
        appID = com.tencent.qmsp.sdk.app.a.getAppID();
        b2.a(3, appID, i, jSONObject, new b());
    }
}
