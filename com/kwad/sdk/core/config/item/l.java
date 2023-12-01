package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/config/item/l.class */
public final class l extends b<String> {
    private boolean adZ;

    public l(String str, String str2) {
        super(str, str2);
        this.adZ = false;
    }

    public l(String str, String str2, boolean z) {
        this(str, str2);
        this.adZ = false;
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        if (this.adZ) {
            setValue(sharedPreferences.getString(getKey(), uX()));
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        if (this.adZ) {
            editor.putString(getKey(), getValue());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        setValue((jSONObject == null || (optJSONObject = jSONObject.optJSONObject(getKey())) == null) ? uX() : optJSONObject.toString());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final String getValue() {
        return (String) super.getValue();
    }
}
