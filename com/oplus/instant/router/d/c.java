package com.oplus.instant.router.d;

import com.oplus.instant.router.Instant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/d/c.class */
public class c extends Instant.FromBuilder {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f24289a = new HashMap();

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public String build() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : this.f24289a.keySet()) {
                jSONObject.put(str, this.f24289a.get(str));
            }
        } catch (JSONException e) {
            com.oplus.instant.router.g.d.a("FromBuilderImpl", e);
        }
        return jSONObject.toString();
    }

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public Instant.FromBuilder set(String str, String str2) {
        this.f24289a.put(str, str2);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public Instant.FromBuilder setScene(String str) {
        this.f24289a.put("m", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public Instant.FromBuilder setTraceId(String str) {
        this.f24289a.put("t", str);
        return this;
    }
}
