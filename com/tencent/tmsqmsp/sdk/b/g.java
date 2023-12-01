package com.tencent.tmsqmsp.sdk.b;

import android.text.TextUtils;
import com.tencent.tmsqmsp.sdk.b.a;
import com.tencent.tmsqmsp.sdk.f.h;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/b/g.class */
public class g {

    /* renamed from: c  reason: collision with root package name */
    private static g f26000c;

    /* renamed from: a  reason: collision with root package name */
    private String f26001a = "Qp.netImp";
    private f b = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/b/g$a.class */
    public class a implements f {
        public a() {
        }

        @Override // com.tencent.tmsqmsp.sdk.b.f
        public void a(int i, String str, int i2, JSONObject jSONObject, e eVar) {
            try {
                JSONObject b = g.this.b(8, jSONObject);
                if (b == null) {
                    eVar.a(163, null);
                    return;
                }
                a.d a2 = com.tencent.tmsqmsp.sdk.b.a.a(i, str, i2, b);
                if (a2.b != 0) {
                    eVar.a(162, a2.f25995a);
                    return;
                }
                JSONObject jSONObject2 = a2.f25995a;
                eVar.a(161, (jSONObject2 == null || !(jSONObject2 instanceof JSONObject)) ? null : g.this.b(9, jSONObject2));
            } catch (Exception e) {
                com.tencent.tmsqmsp.sdk.f.g.b(g.this.f26001a, 0, "send fail！");
                eVar.a(162, null);
                e.printStackTrace();
            }
        }
    }

    private g() {
    }

    private JSONObject a(int i, JSONObject jSONObject) {
        String a2;
        if (!(jSONObject instanceof JSONObject) || jSONObject == null) {
            return null;
        }
        try {
            if (i != 8) {
                if (i != 9 || (a2 = com.tencent.tmsqmsp.sdk.c.f.a(i, 0, 0, 0, a(jSONObject), "")) == null || TextUtils.isEmpty(a2)) {
                    return null;
                }
                return new JSONObject(a2);
            }
            String a3 = com.tencent.tmsqmsp.sdk.c.f.a(i, 0, 0, 0, jSONObject.toString(), "");
            if (a3 == null || TextUtils.isEmpty(a3)) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.tencent.tmsqmsp.sdk.a.e.a(17), a3);
            return jSONObject2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static g b() {
        if (f26000c == null) {
            synchronized (g.class) {
                try {
                    if (f26000c == null) {
                        f26000c = new g();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f26000c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject b(int i, JSONObject jSONObject) {
        if (!(jSONObject instanceof JSONObject) || jSONObject == null) {
            return null;
        }
        return a(i, jSONObject);
    }

    public String a(JSONObject jSONObject) {
        try {
            return jSONObject.optString(com.tencent.tmsqmsp.sdk.a.e.a(17));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a() {
        this.b = new a();
    }

    public void a(int i, String str, int i2, JSONObject jSONObject, e eVar) {
        f fVar;
        if (!(jSONObject instanceof JSONObject) || jSONObject == null || eVar == null || (fVar = this.b) == null) {
            com.tencent.tmsqmsp.sdk.f.g.d(this.f26001a, 0, h.a(h.f26067a));
        } else {
            fVar.a(i, str, i2, jSONObject, eVar);
        }
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.b = fVar;
        } else {
            com.tencent.tmsqmsp.sdk.f.g.d(this.f26001a, 0, h.a(h.f26067a));
        }
    }
}
