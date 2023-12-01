package com.igexin.push.core.a.b;

import com.igexin.push.c.c.n;
import com.igexin.sdk.main.FeedbackImpl;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/b/d.class */
public final class d extends com.igexin.push.core.a.a {
    private static final String b = "FormatMsgAction";

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, a> f23402c;

    public d() {
        HashMap hashMap = new HashMap();
        f23402c = hashMap;
        hashMap.put(com.igexin.push.core.b.C, new h());
        f23402c.put("response_deviceid", new i());
        f23402c.put(com.igexin.push.core.b.A, new e());
        f23402c.put(com.igexin.push.core.b.B, new g());
        f23402c.put("sendmessage_feedback", new j());
        f23402c.put("block_client", new c());
        f23402c.put("settag_result", new k());
        f23402c.put("query_tag_result", new f());
        f23402c.put("response_bind", new b());
        f23402c.put("response_unbind", new l());
    }

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (!nVar.d() || nVar.f == null) {
                return false;
            }
            try {
                final JSONObject jSONObject = new JSONObject((String) nVar.f);
                if (jSONObject.has("action") && !jSONObject.getString("action").equals(com.igexin.push.core.b.B) && !jSONObject.getString("action").equals(com.igexin.push.core.b.C) && jSONObject.has("id")) {
                    FeedbackImpl.getInstance().asyncFeedback(new Runnable() { // from class: com.igexin.push.core.a.b.d.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            String optString = jSONObject.optString("id");
                            com.igexin.push.core.a.b.d();
                            com.igexin.push.core.a.b.a(optString);
                        }
                    });
                }
                if (jSONObject.has("action")) {
                    a aVar = f23402c.get(jSONObject.getString("action"));
                    if (aVar != null) {
                        return aVar.a(obj, jSONObject);
                    }
                    return false;
                }
                return false;
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
                return false;
            }
        }
        return false;
    }

    @Override // com.igexin.push.core.a.a
    public final void b() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean c() {
        return false;
    }
}
