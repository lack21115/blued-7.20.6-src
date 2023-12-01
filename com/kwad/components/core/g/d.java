package com.kwad.components.core.g;

import com.kwad.sdk.api.KsInnerAd;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/g/d.class */
public final class d {
    private Object JF;

    public d(Object obj) {
        this.JF = obj;
    }

    public final void c(c cVar) {
        if (this.JF == null || cVar == null || cVar.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.JF).onAdClicked((KsInnerAd) cVar.getHost());
        } catch (Exception e) {
        }
    }

    public final void d(c cVar) {
        if (this.JF == null || cVar == null || cVar.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.JF).onAdShow((KsInnerAd) cVar.getHost());
        } catch (Exception e) {
        }
    }

    public final void destroy() {
        this.JF = null;
    }
}
