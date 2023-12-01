package com.kwad.components.ad.interstitial.d;

import android.view.View;
import com.kwad.sdk.utils.bl;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/d/b.class */
public final class b extends com.kwad.components.core.widget.kwai.a {
    private View mRootView;

    public b(View view, int i) {
        super(view, 100);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.kwai.a
    public final boolean et() {
        return bl.o(this.mRootView, 100);
    }
}
