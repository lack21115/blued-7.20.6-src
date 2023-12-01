package com.kwad.components.core.n.kwai;

import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.t;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/n/kwai/b.class */
public final class b implements com.kwad.sdk.core.b {
    public SceneImpl Ow;
    public long Ox = 0;
    public long Oy = 0;
    public String sdkExtraData;

    public b(SceneImpl sceneImpl) {
        this.Ow = sceneImpl;
        if (be.getPosId() != 0) {
            this.Ow.setPosId(be.getPosId());
        }
        if (be.EW() != 0) {
            this.Ow.setAdNum((int) be.EW());
        }
    }

    public final String az(String str) {
        Map<String, String> rewardCallbackExtraData;
        SceneImpl sceneImpl = this.Ow;
        if (sceneImpl == null || (rewardCallbackExtraData = sceneImpl.getRewardCallbackExtraData()) == null || !rewardCallbackExtraData.containsKey(str)) {
            return null;
        }
        return rewardCallbackExtraData.get(str);
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    public final com.kwad.sdk.internal.api.a pk() {
        SceneImpl sceneImpl = this.Ow;
        if (sceneImpl == null) {
            return null;
        }
        return sceneImpl.mKsAdLabel;
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject json = this.Ow.toJson();
        t.putValue(json, "pageScene", this.Ox);
        t.putValue(json, "subPageScene", this.Oy);
        t.putValue(json, "sdkExtraData", this.sdkExtraData);
        String az = az("extraData");
        if (az != null) {
            t.putValue(json, "extraData", az);
        }
        return json;
    }
}
