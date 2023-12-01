package com.kwad.components.ad.reward.b;

import com.kwad.sdk.utils.bi;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/b/f.class */
public final class f implements com.kwad.sdk.core.webview.b.a {
    private d ql;

    public f(d dVar) {
        this.ql = dVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "updateExtraReward";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        try {
            final b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.b.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (f.this.ql != null) {
                        f.this.ql.a(bVar);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.ql = null;
    }
}
