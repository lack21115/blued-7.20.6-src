package com.kwad.components.ad.interstitial.c;

import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/b.class */
public class b extends Presenter {
    public c jt;

    @Override // com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        this.jt = (c) Bh();
    }

    public void cT() {
        List<Presenter> Bg = Bg();
        if (Bg == null) {
            return;
        }
        for (Presenter presenter : Bg) {
            if (presenter instanceof b) {
                ((b) presenter).cT();
            }
        }
    }

    public void cU() {
        List<Presenter> Bg = Bg();
        if (Bg == null) {
            return;
        }
        for (Presenter presenter : Bg) {
            if (presenter instanceof b) {
                ((b) presenter).cU();
            }
        }
    }
}
