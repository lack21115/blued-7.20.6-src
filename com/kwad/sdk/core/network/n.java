package com.kwad.sdk.core.network;

import com.kwad.sdk.core.network.NormalResultData;
import com.kwad.sdk.core.network.o;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/n.class */
public abstract class n<R extends o, T extends NormalResultData> extends a<R> {
    private static final String TAG = "NormalNetworking";
    private h<R, T> mListener = null;

    private void onRequest(h<R, T> hVar) {
        this.mListener = hVar;
    }

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    protected abstract T createResponseData();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.network.a
    protected void fetchImpl() {
        c cVar;
        String str;
        o oVar = (o) createRequest();
        c cVar2 = null;
        try {
            String url = oVar.getUrl();
            cVar = oVar.getMethod().equals("POST") ? com.kwad.sdk.b.rZ().doPost(url, oVar.getHeader(), oVar.getBody()) : com.kwad.sdk.b.rZ().doGet(url, oVar.getHeader());
            if (cVar == null || cVar.code != 200) {
                str = "normal request failed";
            } else {
                c cVar3 = cVar;
                StringBuilder sb = new StringBuilder("normal request success:");
                c cVar4 = cVar;
                sb.append(cVar.code);
                c cVar5 = cVar;
                str = sb.toString();
            }
            cVar2 = cVar;
            com.kwad.sdk.core.d.b.d(TAG, str);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            cVar = cVar2;
            if (cVar2 == null) {
                cVar = new c();
            }
            cVar.code = -1;
            cVar.age = e;
        }
        onResponse((n<R, T>) oVar, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.network.a
    protected /* bridge */ /* synthetic */ void onResponse(g gVar, c cVar) {
        onResponse((n<R, T>) ((o) gVar), cVar);
    }

    protected void onResponse(R r, c cVar) {
        if (this.mListener == null) {
            return;
        }
        if (!cVar.wb()) {
            this.mListener.onError(r, cVar.code, cVar.age != null ? cVar.age.getMessage() : "");
            return;
        }
        T createResponseData = createResponseData();
        parseResponse(createResponseData, cVar);
        this.mListener.onSuccess(r, createResponseData);
    }

    protected void parseResponse(T t, c cVar) {
        t.parseResponse(cVar);
    }

    public void request(h<R, T> hVar) {
        onRequest(hVar);
        fetch();
    }
}
