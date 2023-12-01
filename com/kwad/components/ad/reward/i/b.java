package com.kwad.components.ad.reward.i;

import com.kwad.sdk.utils.t;
import java.util.Observable;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/i/b.class */
public abstract class b extends Observable implements c, com.kwad.sdk.core.b {
    private boolean xn = false;
    protected String xo;
    protected String xp;

    private boolean jq() {
        return this.xn;
    }

    private void jr() {
        setChanged();
        notifyObservers(Boolean.valueOf(this.xn));
    }

    public boolean isCompleted() {
        return jq();
    }

    public final void jm() {
        if (this.xn) {
            return;
        }
        this.xn = true;
        jr();
    }

    public final void jn() {
        if (this.xn) {
            this.xn = false;
            jr();
        }
    }

    @Override // com.kwad.components.ad.reward.i.c
    public final String jo() {
        return this.xo;
    }

    @Override // com.kwad.components.ad.reward.i.c
    public final String jp() {
        return this.xp;
    }

    public void parseJson(JSONObject jSONObject) {
        try {
            this.xn = jSONObject.optBoolean("selfCompleted");
        } catch (Throwable th) {
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "selfCompleted", this.xn);
        return jSONObject;
    }
}
