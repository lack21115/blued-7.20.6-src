package com.kwad.components.offline.tk.kwai;

import android.view.View;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaView;
import com.kwad.sdk.components.j;
import com.kwad.sdk.components.k;
import com.kwad.sdk.components.l;
import com.kwad.sdk.utils.ao;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/tk/kwai/g.class */
public final class g implements l {
    private final IOfflineCompoTachikomaView XQ;

    public g(IOfflineCompoTachikomaView iOfflineCompoTachikomaView) {
        ao.checkNotNull(iOfflineCompoTachikomaView);
        this.XQ = iOfflineCompoTachikomaView;
    }

    @Override // com.kwad.sdk.components.l
    public final void a(j jVar) {
        if (jVar != null) {
            this.XQ.registerHostActionHandler(new c(jVar));
        }
    }

    @Override // com.kwad.sdk.components.l
    public final void a(com.kwad.sdk.core.webview.b.g gVar) {
        if (gVar == null) {
            return;
        }
        this.XQ.registerTKBridge(new d(gVar));
    }

    @Override // com.kwad.sdk.components.l
    public final void a(String str, String str2, k kVar) {
        this.XQ.execute(str, str2, new f(kVar));
    }

    @Override // com.kwad.sdk.components.l
    public final void c(com.kwad.sdk.core.webview.b.a aVar) {
        if (aVar == null) {
            return;
        }
        this.XQ.registerJsBridge(new b(aVar));
    }

    @Override // com.kwad.sdk.components.l
    public final Object execute(String str) {
        return this.XQ.execute(str);
    }

    @Override // com.kwad.sdk.components.l
    public final int getUniqId() {
        return this.XQ.getUniqId();
    }

    @Override // com.kwad.sdk.components.l
    public final View getView() {
        return this.XQ.getView();
    }

    @Override // com.kwad.sdk.components.l
    public final void onDestroy() {
        this.XQ.onDestroy();
    }

    @Override // com.kwad.sdk.components.l
    public final void setCustomEnv(Map<String, Object> map) {
        this.XQ.setCustomEnv(map);
    }

    @Override // com.kwad.sdk.components.l
    public final void unregisterJsBridge() {
        this.XQ.unregisterJsBridge();
    }
}
