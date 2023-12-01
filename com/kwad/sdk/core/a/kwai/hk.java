package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/hk.class */
public final class hk implements com.kwad.sdk.core.d<SceneImpl> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(SceneImpl sceneImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sceneImpl.urlPackage = new URLPackage();
        sceneImpl.urlPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        sceneImpl.posId = jSONObject.optLong("posId");
        sceneImpl.entryScene = jSONObject.optLong("entryScene");
        sceneImpl.adNum = jSONObject.optInt("adNum");
        sceneImpl.action = jSONObject.optInt("action");
        sceneImpl.width = jSONObject.optInt("width");
        sceneImpl.height = jSONObject.optInt("height");
        sceneImpl.adStyle = jSONObject.optInt("adStyle");
        sceneImpl.screenOrientation = jSONObject.optInt("screenOrientation");
        sceneImpl.nativeAdExtraData = new NativeAdExtraDataImpl();
        sceneImpl.nativeAdExtraData.parseJson(jSONObject.optJSONObject("nativeAdExtraData"));
        sceneImpl.backUrl = jSONObject.optString("backUrl");
        if (sceneImpl.backUrl == JSONObject.NULL) {
            sceneImpl.backUrl = "";
        }
        sceneImpl.bidResponse = jSONObject.optString("bidResponse");
        if (sceneImpl.bidResponse == JSONObject.NULL) {
            sceneImpl.bidResponse = "";
        }
        sceneImpl.bidResponseV2 = jSONObject.optString("bidResponseV2");
        if (sceneImpl.bidResponseV2 == JSONObject.NULL) {
            sceneImpl.bidResponseV2 = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(SceneImpl sceneImpl, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "urlPackage", sceneImpl.urlPackage);
        if (sceneImpl.posId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "posId", sceneImpl.posId);
        }
        if (sceneImpl.entryScene != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "entryScene", sceneImpl.entryScene);
        }
        if (sceneImpl.adNum != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adNum", sceneImpl.adNum);
        }
        if (sceneImpl.action != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "action", sceneImpl.action);
        }
        if (sceneImpl.width != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "width", sceneImpl.width);
        }
        if (sceneImpl.height != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "height", sceneImpl.height);
        }
        if (sceneImpl.adStyle != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adStyle", sceneImpl.adStyle);
        }
        if (sceneImpl.screenOrientation != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "screenOrientation", sceneImpl.screenOrientation);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "nativeAdExtraData", sceneImpl.nativeAdExtraData);
        if (sceneImpl.backUrl != null && !sceneImpl.backUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "backUrl", sceneImpl.backUrl);
        }
        if (sceneImpl.bidResponse != null && !sceneImpl.bidResponse.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "bidResponse", sceneImpl.bidResponse);
        }
        if (sceneImpl.bidResponseV2 != null && !sceneImpl.bidResponseV2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "bidResponseV2", sceneImpl.bidResponseV2);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SceneImpl sceneImpl, JSONObject jSONObject) {
        a2(sceneImpl, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SceneImpl sceneImpl, JSONObject jSONObject) {
        return b2(sceneImpl, jSONObject);
    }
}
