package com.kwai.adclient.kscommerciallogger.snapshot;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/adclient/kscommerciallogger/snapshot/a.class */
public final class a extends c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str) {
        super(str, 0);
    }

    @Override // com.kwai.adclient.kscommerciallogger.snapshot.c
    public final d fh(String str) {
        b bVar;
        synchronized (this) {
            bVar = new b("empty");
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kwai.adclient.kscommerciallogger.snapshot.c
    public final JSONObject fi(String str) {
        return new JSONObject();
    }
}
