package com.kwad.components.core.n.kwai;

import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/n/kwai/d.class */
public final class d implements com.kwad.sdk.core.b {
    public long Pa;
    public long photoId;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "photoId", this.photoId);
        t.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, this.Pa);
        return jSONObject;
    }
}
