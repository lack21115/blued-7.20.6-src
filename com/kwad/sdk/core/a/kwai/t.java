package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/t.class */
public final class t implements com.kwad.sdk.core.d<AdMatrixInfo.AdInteractionInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.AdInteractionInfo adInteractionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInteractionInfo.interactiveStyle = jSONObject.optInt("interactiveStyle");
        adInteractionInfo.interactivityDefaultStyle = jSONObject.optInt("interactivityDefaultStyle", new Integer("4").intValue());
        adInteractionInfo.isMediaDisable = jSONObject.optBoolean("isMediaDisable");
        adInteractionInfo.switchDefaultTime = jSONObject.optLong("switchDefaultTime", new Long("1500").longValue());
        adInteractionInfo.shakeInfo = new AdMatrixInfo.ShakeInfo();
        adInteractionInfo.shakeInfo.parseJson(jSONObject.optJSONObject("shakeInfo"));
        adInteractionInfo.rotateInfo = new AdMatrixInfo.RotateInfo();
        adInteractionInfo.rotateInfo.parseJson(jSONObject.optJSONObject("rotateInfo"));
        adInteractionInfo.slideInfo = new AdMatrixInfo.SplashSlideInfo();
        adInteractionInfo.slideInfo.parseJson(jSONObject.optJSONObject("slideInfo"));
        adInteractionInfo.splashActionBarInfo = new AdMatrixInfo.SplashActionBarInfo();
        adInteractionInfo.splashActionBarInfo.parseJson(jSONObject.optJSONObject("actionBarInfo"));
        adInteractionInfo.tkDefaultTimeout = jSONObject.optLong("tkDefaultTimeout", new Long("1500").longValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.AdInteractionInfo adInteractionInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (adInteractionInfo.interactiveStyle != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "interactiveStyle", adInteractionInfo.interactiveStyle);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "interactivityDefaultStyle", adInteractionInfo.interactivityDefaultStyle);
        if (adInteractionInfo.isMediaDisable) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "isMediaDisable", adInteractionInfo.isMediaDisable);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "switchDefaultTime", adInteractionInfo.switchDefaultTime);
        com.kwad.sdk.utils.t.a(jSONObject2, "shakeInfo", adInteractionInfo.shakeInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "rotateInfo", adInteractionInfo.rotateInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "slideInfo", adInteractionInfo.slideInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "actionBarInfo", adInteractionInfo.splashActionBarInfo);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "tkDefaultTimeout", adInteractionInfo.tkDefaultTimeout);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.AdInteractionInfo adInteractionInfo, JSONObject jSONObject) {
        a2(adInteractionInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.AdInteractionInfo adInteractionInfo, JSONObject jSONObject) {
        return b2(adInteractionInfo, jSONObject);
    }
}
