package com.kwad.components.offline.api.core.adlive.model;

import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/adlive/model/KSAdLiveEndResultData.class */
public class KSAdLiveEndResultData extends CommonOfflineCompoResultData implements Serializable {
    private static final long serialVersionUID = -6047167317852134995L;
    public KSAdLivePushEndInfo mQLivePushEndInfo = new KSAdLivePushEndInfo();

    public void parseJson(KSAdLiveEndResultData kSAdLiveEndResultData, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdLiveEndResultData.mQLivePushEndInfo.parseJson(jSONObject);
    }

    @Override // com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        parseJson(this, jSONObject);
    }

    @Override // com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        toJson(this, json);
        return json;
    }

    public JSONObject toJson(KSAdLiveEndResultData kSAdLiveEndResultData, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        kSAdLiveEndResultData.mQLivePushEndInfo.toJson(jSONObject2);
        return jSONObject2;
    }
}
