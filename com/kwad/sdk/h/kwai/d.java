package com.kwad.sdk.h.kwai;

import android.content.Context;
import android.provider.Settings;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/h/kwai/d.class */
public final class d extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int axB = 0;
    public int axC = 0;
    public int axD = 0;
    public int axE = 0;
    public int axF = 0;
    public int axG = 0;
    public int axH = 0;

    public d(Context context) {
        boolean z = false;
        if (context != null) {
            bs(Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0 ? true : z);
        }
    }

    private void a(d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.axB = jSONObject.optInt("isRoot");
        dVar.axC = jSONObject.optInt("isXPosed");
        dVar.axD = jSONObject.optInt("isFrameworkHooked");
        dVar.axE = jSONObject.optInt("isVirtual");
        dVar.axF = jSONObject.optInt("isAdbEnabled");
        dVar.axG = jSONObject.optInt("isEmulator");
        dVar.axH = jSONObject.optInt("isGroupControl");
        super.afterParseJson(jSONObject);
    }

    private static JSONObject b(d dVar, JSONObject jSONObject) {
        t.putValue(jSONObject, "isRoot", dVar.axB);
        t.putValue(jSONObject, "isXPosed", dVar.axC);
        t.putValue(jSONObject, "isFrameworkHooked", dVar.axD);
        t.putValue(jSONObject, "isVirtual", dVar.axE);
        t.putValue(jSONObject, "isAdbEnabled", dVar.axF);
        t.putValue(jSONObject, "isEmulator", dVar.axG);
        t.putValue(jSONObject, "isGroupControl", dVar.axH);
        return jSONObject;
    }

    private void bs(boolean z) {
        this.axF = bv(z);
    }

    private static int bv(boolean z) {
        return z ? 1 : 2;
    }

    public final void bp(boolean z) {
        this.axB = bv(z);
    }

    public final void bq(boolean z) {
        this.axC = bv(z);
    }

    public final void br(boolean z) {
        this.axD = bv(z);
    }

    public final void bt(boolean z) {
        this.axG = bv(z);
    }

    public final void bu(boolean z) {
        this.axH = bv(z);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject b = b(this, new JSONObject());
        afterToJson(b);
        return b;
    }
}
