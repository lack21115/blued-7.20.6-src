package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ew.class */
public final class ew implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdJSCornerModel.topLeft = jSONObject.optDouble("topLeft");
        kSAdJSCornerModel.topRight = jSONObject.optDouble("topRight");
        kSAdJSCornerModel.bottomRight = jSONObject.optDouble("bottomRight");
        kSAdJSCornerModel.bottomLeft = jSONObject.optDouble("bottomLeft");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (kSAdJSCornerModel.topLeft != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "topLeft", kSAdJSCornerModel.topLeft);
        }
        if (kSAdJSCornerModel.topRight != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "topRight", kSAdJSCornerModel.topRight);
        }
        if (kSAdJSCornerModel.bottomRight != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "bottomRight", kSAdJSCornerModel.bottomRight);
        }
        if (kSAdJSCornerModel.bottomLeft != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "bottomLeft", kSAdJSCornerModel.bottomLeft);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        a2(kSAdJSCornerModel, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        return b2(kSAdJSCornerModel, jSONObject);
    }
}
