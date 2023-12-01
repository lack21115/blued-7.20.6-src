package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/config/item/e.class */
public final class e extends b<JSONObject> {
    public e() {
        super(uZ(), new JSONObject());
    }

    private static String uZ() {
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        return (eVar == null || !eVar.getIsExternal()) ? "commercialReportConf" : "commercialExternalReportConf";
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        JSONObject jSONObject;
        JSONObject value = getValue();
        JSONObject jSONObject2 = value;
        if (value == null) {
            jSONObject2 = new JSONObject();
        }
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(getKey(), ""));
        } catch (Throwable th) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            jSONObject2 = jSONObject;
        }
        setValue(jSONObject2);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        String key;
        String str;
        if (getValue() != null) {
            key = getKey();
            str = getValue().toString();
        } else {
            key = getKey();
            str = "";
        }
        editor.putString(key, str);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(getKey())) == null) {
            setValue(uX());
        } else {
            setValue(optJSONObject);
        }
    }
}
