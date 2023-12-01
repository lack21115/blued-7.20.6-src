package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.g.b;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/hi.class */
public final class hi implements com.kwad.sdk.core.d<b.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.auj = jSONObject.optInt("ds");
        aVar.sdkVersion = jSONObject.optString("sv");
        if (aVar.sdkVersion == JSONObject.NULL) {
            aVar.sdkVersion = "";
        }
        aVar.auk = jSONObject.optString("spv");
        if (aVar.auk == JSONObject.NULL) {
            aVar.auk = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.auj != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "ds", aVar.auj);
        }
        if (aVar.sdkVersion != null && !aVar.sdkVersion.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sv", aVar.sdkVersion);
        }
        if (aVar.auk != null && !aVar.auk.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "spv", aVar.auk);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
