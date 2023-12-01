package com.oplus.instant.router.d;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/d/d.class */
public class d extends a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        super(bVar);
    }

    private Map<String, Object> a() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.f)) {
            hashMap.putAll(com.oplus.instant.router.a.a.a(this.f));
        }
        Map<String, String> map = this.f24286c;
        if (map != null && map.size() > 0 && this.f24285a.containsKey("f")) {
            try {
                JSONObject jSONObject = new JSONObject(this.f24285a.get("f"));
                for (String str : this.f24286c.keySet()) {
                    jSONObject.put(str, this.f24286c.get(str));
                }
                this.f24285a.put("f", jSONObject.toString());
            } catch (Exception e) {
            }
        }
        hashMap.putAll(this.f24285a);
        if (!hashMap.containsKey("scheme")) {
            hashMap.put("scheme", "oaps");
        }
        if (!hashMap.containsKey("host")) {
            hashMap.put("host", "instant");
        }
        return hashMap;
    }

    @Override // com.oplus.instant.router.Instant.Req
    public void preload(Context context) {
        com.oplus.instant.router.g.e.b(context.getApplicationContext(), com.oplus.instant.router.a.a.a(a()), this.f24285a, this.b, this.f24286c, this.d, this.e);
    }

    @Override // com.oplus.instant.router.Instant.Req
    public void request(Context context) {
        com.oplus.instant.router.g.e.a(context, com.oplus.instant.router.a.a.a(a()), this.f24285a, this.b, this.f24286c, this.d, this.e);
    }
}
