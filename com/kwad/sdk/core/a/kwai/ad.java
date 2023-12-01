package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ad.class */
public final class ad implements com.kwad.sdk.core.d<AdInfo.AdShowVideoH5Info> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdShowVideoH5Info adShowVideoH5Info, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adShowVideoH5Info.showPageType = jSONObject.optInt("showPageType");
        adShowVideoH5Info.videoAutoLoopAtH5 = jSONObject.optBoolean("videoAutoLoopAtH5");
        adShowVideoH5Info.videoMutedAtH5 = jSONObject.optBoolean("videoMutedAtH5");
        adShowVideoH5Info.videoClickAtH5 = jSONObject.optBoolean("videoClickAtH5");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdShowVideoH5Info adShowVideoH5Info, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (adShowVideoH5Info.showPageType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "showPageType", adShowVideoH5Info.showPageType);
        }
        if (adShowVideoH5Info.videoAutoLoopAtH5) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "videoAutoLoopAtH5", adShowVideoH5Info.videoAutoLoopAtH5);
        }
        if (adShowVideoH5Info.videoMutedAtH5) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "videoMutedAtH5", adShowVideoH5Info.videoMutedAtH5);
        }
        if (adShowVideoH5Info.videoClickAtH5) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "videoClickAtH5", adShowVideoH5Info.videoClickAtH5);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdShowVideoH5Info adShowVideoH5Info, JSONObject jSONObject) {
        a2(adShowVideoH5Info, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdShowVideoH5Info adShowVideoH5Info, JSONObject jSONObject) {
        return b2(adShowVideoH5Info, jSONObject);
    }
}
