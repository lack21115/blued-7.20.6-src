package com.kwad.components.offline.api.core.network.model;

import com.kwad.sdk.core.kwai.d;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.EmptyResultData;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/network/model/CommonOfflineCompoResultData.class */
public abstract class CommonOfflineCompoResultData extends BaseOfflineCompoResultData {
    private static final int CODE_RESULT_OK = 1;
    private static final long serialVersionUID = 7464537023322307192L;
    public String cookie;
    public String errorMsg;
    public String extra;
    public boolean hasAd;
    public long llsid;
    private boolean mKeepOriginResponse;
    public JSONObject originResponseData;
    public int result;
    private boolean mNotifyFailOnResultError = true;
    private BaseResultData mBaseResultData = new EmptyResultData();

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
        return this.mNotifyFailOnResultError;
    }

    public void parseJson(JSONObject jSONObject) {
        String str;
        if (jSONObject == null) {
            return;
        }
        if (this.mBaseResultData == null) {
            this.mBaseResultData = new EmptyResultData();
        }
        this.mBaseResultData.parseJson(jSONObject);
        this.llsid = this.mBaseResultData.llsid;
        this.result = this.mBaseResultData.result;
        this.hasAd = this.mBaseResultData.hasAd;
        this.errorMsg = this.mBaseResultData.errorMsg;
        this.extra = this.mBaseResultData.extra;
        this.cookie = this.mBaseResultData.cookie;
        if (this.mKeepOriginResponse) {
            this.originResponseData = new JSONObject();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    str = jSONObject.get(next);
                } catch (JSONException e) {
                    str = null;
                }
                Object obj = null;
                if (str instanceof String) {
                    String responseData = d.getResponseData(str);
                    obj = null;
                    if (responseData != null) {
                        try {
                            obj = new JSONTokener(responseData).nextValue();
                        } catch (JSONException e2) {
                            obj = null;
                        }
                    }
                }
                if (obj != null) {
                    try {
                        this.originResponseData.put(next, obj);
                    } catch (JSONException e3) {
                    }
                } else {
                    this.originResponseData.put(next, str);
                }
            }
        }
    }

    public void setKeepOriginResponse(boolean z) {
        this.mKeepOriginResponse = z;
    }

    public void setNotifyFailOnResultError(boolean z) {
        this.mNotifyFailOnResultError = z;
    }

    public JSONObject toJson() {
        BaseResultData baseResultData = this.mBaseResultData;
        return baseResultData == null ? new JSONObject() : baseResultData.toJson();
    }
}
