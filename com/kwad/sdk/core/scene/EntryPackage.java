package com.kwad.sdk.core.scene;

import com.kwad.sdk.utils.t;
import com.tencent.smtt.sdk.stat.MttLoader;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/scene/EntryPackage.class */
public class EntryPackage extends URLPackage {
    private static final long serialVersionUID = 8251709184937662571L;
    public String entryId;
    public String entryPageSource;

    public EntryPackage() {
        this.entryPageSource = "unknown";
    }

    public EntryPackage(String str, int i) {
        super(str, i);
        this.entryPageSource = "unknown";
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.entryPageSource = jSONObject.optString("entryPageSource");
        this.entryId = jSONObject.optString(MttLoader.ENTRY_ID);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.putValue(json, "entryPageSource", this.entryPageSource);
        t.putValue(json, MttLoader.ENTRY_ID, this.entryId);
        return json;
    }
}
