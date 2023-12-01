package com.kwad.components.ad.reward.k;

import android.view.ViewGroup;
import android.view.ViewStub;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/w.class */
public abstract class w extends d {
    protected ViewGroup sn;

    public final void a(ViewGroup viewGroup, int i, int i2) {
        if (this.sn != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(i);
        this.sn = (ViewGroup) (viewStub != null ? viewStub.inflate() : viewGroup.findViewById(i2));
    }

    @Override // com.kwad.components.ad.reward.k.d
    public ViewGroup gK() {
        return this.sn;
    }
}
