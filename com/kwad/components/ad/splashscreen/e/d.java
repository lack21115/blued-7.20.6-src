package com.kwad.components.ad.splashscreen.e;

import android.view.View;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/e/d.class */
public final class d extends com.kwad.components.core.widget.kwai.b {
    public d(View view, int i) {
        super(view, 70);
    }

    @Override // com.kwad.components.core.widget.kwai.b, com.kwad.components.core.widget.kwai.a
    public final boolean et() {
        com.kwad.sdk.core.b.b.vS();
        if (com.kwad.sdk.core.b.b.isEnable()) {
            com.kwad.sdk.core.b.b.vS();
            return com.kwad.sdk.core.b.b.isAppOnForeground() && super.et();
        }
        return super.et();
    }
}
