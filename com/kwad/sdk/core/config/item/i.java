package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/config/item/i.class */
public final class i extends b<com.kwad.sdk.core.network.idc.kwai.a> {
    public i() {
        super("idc", new com.kwad.sdk.core.network.idc.kwai.a());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(getKey())) == null) {
            setValue(uX());
            return;
        }
        com.kwad.sdk.core.network.idc.kwai.a aVar = new com.kwad.sdk.core.network.idc.kwai.a();
        aVar.parseJson(optJSONObject);
        setValue(aVar);
    }
}
