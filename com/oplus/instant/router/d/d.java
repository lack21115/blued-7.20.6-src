package com.oplus.instant.router.d;

import android.app.backup.FullBackup;
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
        Map<String, String> map = this.f10599c;
        if (map != null && map.size() > 0 && this.f10598a.containsKey(FullBackup.DATA_TREE_TOKEN)) {
            try {
                JSONObject jSONObject = new JSONObject(this.f10598a.get(FullBackup.DATA_TREE_TOKEN));
                for (String str : this.f10599c.keySet()) {
                    jSONObject.put(str, this.f10599c.get(str));
                }
                this.f10598a.put(FullBackup.DATA_TREE_TOKEN, jSONObject.toString());
            } catch (Exception e) {
            }
        }
        hashMap.putAll(this.f10598a);
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
        com.oplus.instant.router.g.e.b(context.getApplicationContext(), com.oplus.instant.router.a.a.a(a()), this.f10598a, this.b, this.f10599c, this.d, this.e);
    }

    @Override // com.oplus.instant.router.Instant.Req
    public void request(Context context) {
        com.oplus.instant.router.g.e.a(context, com.oplus.instant.router.a.a.a(a()), this.f10598a, this.b, this.f10599c, this.d, this.e);
    }
}
