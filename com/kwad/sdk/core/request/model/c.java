package com.kwad.sdk.core.request.model;

import android.location.Location;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/request/model/c.class */
public final class c implements com.kwad.sdk.core.b {
    private static c aly;
    private double alA;
    private double alz;

    public static c xr() {
        c cVar = aly;
        if (cVar != null) {
            return cVar;
        }
        Location bL = au.bL(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext());
        if (bL != null) {
            c cVar2 = new c();
            aly = cVar2;
            cVar2.alz = bL.getLatitude();
            aly.alA = bL.getLongitude();
        }
        return aly;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "latitude", this.alz);
        t.putValue(jSONObject, "longitude", this.alA);
        return jSONObject;
    }
}
