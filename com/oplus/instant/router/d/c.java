package com.oplus.instant.router.d;

import com.oplus.instant.router.Instant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/d/c.class */
public class c extends Instant.FromBuilder {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f10602a = new HashMap();

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public String build() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : this.f10602a.keySet()) {
                jSONObject.put(str, this.f10602a.get(str));
            }
        } catch (JSONException e) {
            com.oplus.instant.router.g.d.a("FromBuilderImpl", e);
        }
        return jSONObject.toString();
    }

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public Instant.FromBuilder set(String str, String str2) {
        this.f10602a.put(str, str2);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public Instant.FromBuilder setScene(String str) {
        this.f10602a.put("m", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public Instant.FromBuilder setTraceId(String str) {
        this.f10602a.put("t", str);
        return this;
    }
}
