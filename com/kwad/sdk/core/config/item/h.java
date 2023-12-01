package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/config/item/h.class */
public final class h extends b<a> {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/config/item/h$a.class */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String adV = "";
        public String adW = "";
    }

    public h() {
        super("idMapping", new a());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        a value = getValue();
        a aVar = value;
        if (value == null) {
            aVar = new a();
        }
        String string = sharedPreferences.getString(getKey(), "");
        if (!TextUtils.isEmpty(string)) {
            try {
                aVar.parseJson(new JSONObject(bC(string)));
            } catch (JSONException e) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            }
        }
        setValue(aVar);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        if (getValue() == null || getValue().toJson() == null) {
            editor.putString(getKey(), "");
            return;
        }
        editor.putString(getKey(), bB(getValue().toJson().toString()));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void g(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(getKey());
        if (optJSONObject == null) {
            return;
        }
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        setValue(aVar);
    }

    public final String getImei() {
        a value = getValue();
        return (value == null || TextUtils.isEmpty(value.adV)) ? "" : value.adV;
    }

    public final String getOaid() {
        a value = getValue();
        return (value == null || TextUtils.isEmpty(value.adW)) ? "" : value.adW;
    }
}
