package com.kwad.components.offline.tk.kwai;

import com.kwad.components.offline.api.tk.IOfflineTKRenderListener;
import com.kwad.sdk.components.k;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/tk/kwai/f.class */
public final class f implements IOfflineTKRenderListener {
    private final k XP;

    public f(k kVar) {
        this.XP = kVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onFailed(Throwable th) {
        k kVar = this.XP;
        if (kVar != null) {
            kVar.onFailed(th);
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onSuccess() {
        k kVar = this.XP;
        if (kVar != null) {
            kVar.onSuccess();
        }
    }
}
