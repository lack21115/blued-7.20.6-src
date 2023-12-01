package com.kwad.sdk.core.request.model;

import android.provider.SearchIndexablesContract;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/request/model/g.class */
public final class g implements com.kwad.sdk.core.b {
    public int aaM;
    public int aaN;
    public String aaO;
    private String alL;
    private String alM;

    public static g xv() {
        return new g();
    }

    public final void cH(String str) {
        this.alM = str;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, SearchIndexablesContract.RawData.COLUMN_USER_ID, this.alL);
        t.putValue(jSONObject, "thirdUserId", this.alM);
        int i = this.aaM;
        if (i != 0) {
            t.putValue(jSONObject, "thirdAge", i);
        }
        int i2 = this.aaN;
        if (i2 != 0) {
            t.putValue(jSONObject, "thirdGender", i2);
        }
        t.putValue(jSONObject, "thirdInterest", this.aaO);
        return jSONObject;
    }
}
