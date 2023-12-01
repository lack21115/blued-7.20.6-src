package com.kwad.components.core.webview.a.kwai;

import com.kwad.sdk.utils.bi;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/v.class */
public abstract class v implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c UO;
    private CopyOnWriteArrayList<com.kwad.sdk.core.b> UP = new CopyOnWriteArrayList<>();

    public final void b(final com.kwad.sdk.core.b bVar) {
        if (this.UO != null) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.kwai.v.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (v.this.UO != null) {
                        v.this.UO.a(bVar);
                    }
                }
            });
        } else {
            this.UP.add(bVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        this.UO = cVar;
        if (this.UP.size() > 0) {
            Iterator<com.kwad.sdk.core.b> it = this.UP.iterator();
            while (it.hasNext()) {
                com.kwad.sdk.core.b next = it.next();
                b(next);
                this.UP.remove(next);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
        this.UO = null;
    }
}
