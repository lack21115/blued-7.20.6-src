package com.kwai.adclient.kscommerciallogger.snapshot;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/adclient/kscommerciallogger/snapshot/b.class */
public final class b extends d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kwai.adclient.kscommerciallogger.snapshot.d
    public final JSONObject Gf() {
        JSONObject jSONObject;
        synchronized (this) {
            jSONObject = new JSONObject();
        }
        return jSONObject;
    }
}
