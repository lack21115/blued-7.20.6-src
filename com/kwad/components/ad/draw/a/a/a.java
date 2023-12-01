package com.kwad.components.ad.draw.a.a;

import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/a/a/a.class */
public final class a {
    private InterfaceC0466a cM;
    private b cN;
    private boolean cO = false;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.draw.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/a/a/a$a.class */
    public interface InterfaceC0466a {
        void ay();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/a/a/a$b.class */
    public interface b {
        boolean az();
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void a(InterfaceC0466a interfaceC0466a) {
        this.cM = interfaceC0466a;
    }

    public final void a(b bVar) {
        this.cN = bVar;
    }

    public final void ax() {
        InterfaceC0466a interfaceC0466a;
        if (this.cO) {
            return;
        }
        this.cO = true;
        if (d.cb(this.mAdTemplate).status == 1 || d.cb(this.mAdTemplate).status == 2 || d.cb(this.mAdTemplate).status == 3) {
            return;
        }
        b bVar = this.cN;
        if ((bVar == null || !bVar.az()) && (interfaceC0466a = this.cM) != null) {
            interfaceC0466a.ay();
        }
    }
}
