package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/jg.class */
public final class jg implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoPosition.leftMarginRation = jSONObject.optDouble("leftMarginRation");
        videoPosition.topMarginRation = jSONObject.optDouble("topMarginRation");
        videoPosition.widthRation = jSONObject.optDouble("widthRation");
        videoPosition.heightWidthRation = jSONObject.optDouble("heightWidthRation");
        videoPosition.leftMargin = jSONObject.optInt("leftMargin");
        videoPosition.topMargin = jSONObject.optInt("topMargin");
        videoPosition.width = jSONObject.optInt("width");
        videoPosition.height = jSONObject.optInt("height");
        videoPosition.borderRadius = jSONObject.optInt("borderRadius");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (videoPosition.leftMarginRation != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "leftMarginRation", videoPosition.leftMarginRation);
        }
        if (videoPosition.topMarginRation != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "topMarginRation", videoPosition.topMarginRation);
        }
        if (videoPosition.widthRation != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "widthRation", videoPosition.widthRation);
        }
        if (videoPosition.heightWidthRation != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "heightWidthRation", videoPosition.heightWidthRation);
        }
        if (videoPosition.leftMargin != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "leftMargin", videoPosition.leftMargin);
        }
        if (videoPosition.topMargin != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "topMargin", videoPosition.topMargin);
        }
        if (videoPosition.width != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "width", videoPosition.width);
        }
        if (videoPosition.height != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "height", videoPosition.height);
        }
        if (videoPosition.borderRadius != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "borderRadius", videoPosition.borderRadius);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        a2(videoPosition, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        return b2(videoPosition, jSONObject);
    }
}
