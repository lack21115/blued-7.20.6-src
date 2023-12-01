package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.c;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/dp.class */
public final class dp implements com.kwad.sdk.core.d<c.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.showLiveStatus = jSONObject.optInt("showLiveStatus");
        aVar.showLiveStyle = jSONObject.optInt("showLiveStyle");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(c.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.showLiveStatus != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "showLiveStatus", aVar.showLiveStatus);
        }
        if (aVar.showLiveStyle != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "showLiveStyle", aVar.showLiveStyle);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(c.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(c.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
