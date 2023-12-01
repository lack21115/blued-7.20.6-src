package com.kwad.sdk.core.a.kwai;

import android.speech.tts.TextToSpeech;
import com.kwad.components.core.n.kwai.c;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/at.class */
public final class at implements com.kwad.sdk.core.d<c.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.streamType = jSONObject.optInt(TextToSpeech.Engine.KEY_PARAM_STREAM);
        aVar.OX = jSONObject.optInt("maxVolume");
        aVar.OY = jSONObject.optInt("minVolume");
        aVar.OZ = jSONObject.optInt("currentVolume");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(c.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.streamType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, TextToSpeech.Engine.KEY_PARAM_STREAM, aVar.streamType);
        }
        if (aVar.OX != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "maxVolume", aVar.OX);
        }
        if (aVar.OY != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "minVolume", aVar.OY);
        }
        if (aVar.OZ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "currentVolume", aVar.OZ);
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
