package com.kwad.components.core.webview.a.kwai;

import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/w.class */
public final class w implements com.kwad.sdk.core.webview.b.a {
    private a US;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/w$a.class */
    public interface a {
        void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo);
    }

    public w(a aVar) {
        this.US = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "updateLiveCurrentShopInfo";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        try {
            com.kwad.sdk.core.d.b.d("UpdateLiveCurrentShopInfoHandler", "handleJsCall: " + str);
            final TKAdLiveShopItemInfo tKAdLiveShopItemInfo = new TKAdLiveShopItemInfo();
            tKAdLiveShopItemInfo.parseJson(new JSONObject(str));
            bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.kwai.w.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (w.this.US != null) {
                        w.this.US.a(tKAdLiveShopItemInfo);
                    }
                }
            });
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
