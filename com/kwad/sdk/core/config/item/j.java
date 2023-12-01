package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/config/item/j.class */
public final class j extends b<a> {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/config/item/j$a.class */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int adX = 180000;
        public int adY = com.anythink.expressad.foundation.g.a.bM;
    }

    public j(String str) {
        super(str, new a());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        JSONObject jSONObject;
        a value = getValue();
        a aVar = value;
        if (value == null) {
            aVar = new a();
        }
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(getKey(), ""));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            jSONObject = null;
        }
        if (jSONObject != null) {
            aVar.parseJson(jSONObject);
        }
        setValue(aVar);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        String key;
        String str;
        if (getValue() == null || getValue().toJson() == null) {
            key = getKey();
            str = "";
        } else {
            key = getKey();
            str = getValue().toJson().toString();
        }
        editor.putString(key, str);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(getKey())) == null) {
            setValue(uX());
            return;
        }
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        setValue(aVar);
    }
}
