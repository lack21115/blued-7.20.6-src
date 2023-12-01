package com.kwad.sdk.h.kwai;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/h/kwai/b.class */
public final class b extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int axA;
    public int axy;
    public int axz;

    public b(int i, int i2, int i3) {
        this.axy = i;
        this.axz = i2;
        this.axA = i3;
    }

    public static b Ci() {
        synchronized (b.class) {
            try {
                if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sz()) {
                    return ax.Ci();
                }
                return null;
            } finally {
            }
        }
    }

    private static void a(b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.axy = jSONObject.optInt("cellId", -1);
        bVar.axz = jSONObject.optInt("lac", -1);
        bVar.axA = jSONObject.optInt("bsss", -1);
    }

    private static JSONObject b(b bVar, JSONObject jSONObject) {
        t.putValue(jSONObject, "cellId", bVar.axy);
        t.putValue(jSONObject, "lac", bVar.axz);
        t.putValue(jSONObject, "bsss", bVar.axA);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        a(this, jSONObject);
        super.afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        return b(this, new JSONObject());
    }
}
