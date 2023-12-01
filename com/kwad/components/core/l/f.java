package com.kwad.components.core.l;

import com.kwad.sdk.api.core.fragment.KsFragment;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/l/f.class */
public class f extends KsFragment implements com.kwad.sdk.i.kwai.b {
    private final com.kwad.sdk.i.kwai.a mBackPressDelete = new com.kwad.sdk.i.kwai.a();
    private boolean enableDestroyer = true;

    @Override // com.kwad.sdk.i.kwai.b
    public boolean bX() {
        return this.mBackPressDelete.bX();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        if (!this.enableDestroyer || getHost() == null) {
            return;
        }
        com.kwad.components.core.r.f.destroyFragment(getContext(), getView());
    }
}
