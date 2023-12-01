package com.kwad.sdk.core.network;

import android.provider.Downloads;
import android.text.TextUtils;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/BaseResultData.class */
public abstract class BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final int CODE_RESULT_OK = 1;
    private static final long serialVersionUID = -8657363515914699792L;
    public String cookie;
    public String errorMsg;
    public String extra;
    public boolean hasAd;
    public long llsid;
    public int result;
    public String testErrorMsg;

    public JSONObject baseToJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "llsid", this.llsid);
        t.putValue(jSONObject, "extra", this.extra);
        t.putValue(jSONObject, "result", this.result);
        t.putValue(jSONObject, "hasAd", this.hasAd);
        t.putValue(jSONObject, Downloads.Impl.COLUMN_ERROR_MSG, this.errorMsg);
        t.putValue(jSONObject, "testErrorMsg", this.testErrorMsg);
        t.putValue(jSONObject, "cookie", this.cookie);
        return jSONObject;
    }

    public boolean hasData() {
        return this.hasAd;
    }

    public boolean isDataEmpty() {
        return false;
    }

    public boolean isResultOk() {
        return this.result == 1;
    }

    public boolean notifyFailOnResultError() {
        return true;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.llsid = jSONObject.optLong("llsid");
        this.result = jSONObject.optInt("result");
        this.hasAd = jSONObject.optBoolean("hasAd");
        this.errorMsg = jSONObject.optString(Downloads.Impl.COLUMN_ERROR_MSG);
        this.testErrorMsg = jSONObject.optString("testErrorMsg");
        String optString = jSONObject.optString("extra");
        if (!bb.isNullString(optString)) {
            this.extra = com.kwad.sdk.core.kwai.d.getResponseData(optString);
        }
        com.kwad.sdk.components.f fVar = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.f(com.kwad.sdk.components.f.class);
        if (fVar != null) {
            fVar.at(jSONObject.optString("egid"));
            fVar.r(jSONObject.optLong("gidExpireTimeMs"));
        }
        String optString2 = jSONObject.optString("cookie");
        this.cookie = optString2;
        if (TextUtils.isEmpty(optString2)) {
            return;
        }
        e.wc().cc(this.cookie);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        return baseToJson();
    }
}
