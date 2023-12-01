package com.oplus.quickgame.sdk.engine.c;

import com.oplus.quickgame.sdk.QuickGame;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/c/c.class */
public class c extends QuickGame.FromBuilder {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f24398a = new HashMap();

    @Override // com.oplus.quickgame.sdk.QuickGame.FromBuilder
    public String build() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : this.f24398a.keySet()) {
                jSONObject.put(str, this.f24398a.get(str));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.FromBuilder
    public QuickGame.FromBuilder set(String str, String str2) {
        this.f24398a.put(str, str2);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.FromBuilder
    public QuickGame.FromBuilder setScene(String str) {
        this.f24398a.put("m", str);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.FromBuilder
    public QuickGame.FromBuilder setTraceId(String str) {
        this.f24398a.put("t", str);
        return this;
    }
}
