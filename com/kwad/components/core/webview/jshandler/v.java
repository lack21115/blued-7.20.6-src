package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/v.class */
public final class v implements com.kwad.sdk.core.webview.b.a {
    private final boolean SG = false;
    private com.kwad.sdk.core.network.m<com.kwad.components.core.n.a, AdResultData> ir;
    private final com.kwad.sdk.core.webview.b mBridgeContext;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/v$a.class */
    public static final class a implements com.kwad.sdk.core.b {
        private List<AdTemplate> SJ;

        public a(List<AdTemplate> list) {
            this.SJ = list;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (AdTemplate adTemplate : this.SJ) {
                if (!TextUtils.isEmpty(adTemplate.mOriginJString)) {
                    try {
                        jSONArray.put(new JSONObject(adTemplate.mOriginJString));
                    } catch (JSONException e) {
                        com.kwad.sdk.core.d.b.printStackTrace(e);
                    }
                }
                jSONArray.put(adTemplate.toJson());
            }
            com.kwad.sdk.utils.t.putValue(jSONObject, "impAdInfo", jSONArray);
            return jSONObject;
        }
    }

    public v(com.kwad.sdk.core.webview.b bVar) {
        this.mBridgeContext = bVar;
    }

    private void a(final com.kwad.components.core.n.kwai.b bVar, final com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.sdk.core.network.m<com.kwad.components.core.n.a, AdResultData> mVar = this.ir;
        if (mVar != null) {
            mVar.cancel();
        }
        com.kwad.sdk.core.network.m<com.kwad.components.core.n.a, AdResultData> mVar2 = new com.kwad.sdk.core.network.m<com.kwad.components.core.n.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.v.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.m
            /* renamed from: aj */
            public AdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(bVar.Ow);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: mc */
            public com.kwad.components.core.n.a createRequest() {
                return new com.kwad.components.core.n.a(bVar);
            }
        };
        this.ir = mVar2;
        mVar2.request(new com.kwad.sdk.core.network.p<com.kwad.components.core.n.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.v.2
            private void b(final AdResultData adResultData) {
                if (!adResultData.isAdResultDataEmpty()) {
                    bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.v.2.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            cVar.a(new a(adResultData.getAdTemplateList()));
                        }
                    });
                    return;
                }
                StringBuilder sb = new StringBuilder("onError:");
                sb.append(String.format("code:%s__msg:%s", Integer.valueOf(com.kwad.sdk.core.network.f.agn.errorCode), TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg : adResultData.testErrorMsg));
                com.kwad.sdk.core.d.b.d("WebCardGetKsAdDataHandler", sb.toString());
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.v.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        cVar.a(new a(new ArrayList()));
                    }
                });
            }

            private void e(int i, String str) {
                com.kwad.sdk.core.d.b.d("WebCardGetKsAdDataHandler", "requestAggregateAd onError code:" + i + " msg: " + str);
                v.this.a(cVar);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(com.kwad.sdk.core.network.g gVar, int i, String str) {
                e(i, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.g gVar, BaseResultData baseResultData) {
                b((AdResultData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.core.webview.b.c cVar) {
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.v.3
            @Override // java.lang.Runnable
            public final void run() {
                cVar.a(new a(new ArrayList()));
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "getKsAdData";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        if (!this.SG) {
            if (this.mBridgeContext.yU()) {
                cVar.onError(-1, "native adTemplate is null");
                return;
            } else {
                cVar.a(new a(this.mBridgeContext.yT()));
                return;
            }
        }
        AdTemplate adTemplate = this.mBridgeContext.getAdTemplate();
        com.kwad.components.core.n.kwai.b bVar = new com.kwad.components.core.n.kwai.b(adTemplate.mAdScene);
        if (adTemplate.mAdScene != null) {
            bVar.Ox = adTemplate.mAdScene.getPageScene();
        }
        bVar.Oy = 106L;
        bVar.Ow.setAdNum(12);
        bVar.sdkExtraData = com.kwad.sdk.core.response.a.d.ck(adTemplate);
        a(bVar, cVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        com.kwad.sdk.core.network.m<com.kwad.components.core.n.a, AdResultData> mVar = this.ir;
        if (mVar != null) {
            mVar.cancel();
        }
    }
}
