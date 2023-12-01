package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.ABParams;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/a.class */
public final class a implements com.kwad.sdk.core.d<ABParams> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(ABParams aBParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aBParams.videoBlackAreaClick = jSONObject.optInt("videoBlackAreaClick");
        aBParams.videoBlackAreaNewStyle = jSONObject.optInt("videoBlackAreaNewStyle");
        aBParams.drawActionBarTimes = jSONObject.optString("drawActionBarTimes");
        if (aBParams.drawActionBarTimes == JSONObject.NULL) {
            aBParams.drawActionBarTimes = "";
        }
        aBParams.showVideoAtH5 = jSONObject.optInt("showVideoAtH5");
        aBParams.playableStyle = jSONObject.optInt("playableStyle");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(ABParams aBParams, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aBParams.videoBlackAreaClick != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "videoBlackAreaClick", aBParams.videoBlackAreaClick);
        }
        if (aBParams.videoBlackAreaNewStyle != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "videoBlackAreaNewStyle", aBParams.videoBlackAreaNewStyle);
        }
        if (aBParams.drawActionBarTimes != null && !aBParams.drawActionBarTimes.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "drawActionBarTimes", aBParams.drawActionBarTimes);
        }
        if (aBParams.showVideoAtH5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "showVideoAtH5", aBParams.showVideoAtH5);
        }
        if (aBParams.playableStyle != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "playableStyle", aBParams.playableStyle);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ABParams aBParams, JSONObject jSONObject) {
        a2(aBParams, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ABParams aBParams, JSONObject jSONObject) {
        return b2(aBParams, jSONObject);
    }
}
