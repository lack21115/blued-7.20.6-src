package com.kwad.components.ad.splashscreen.b.kwai;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/kwai/f.class */
public final class f extends com.kwad.components.ad.splashscreen.b.e {
    com.kwad.components.ad.splashscreen.f DV = new com.kwad.components.ad.splashscreen.f() { // from class: com.kwad.components.ad.splashscreen.b.kwai.f.1
        @Override // com.kwad.components.ad.splashscreen.f
        public final void ks() {
            com.kwad.components.ad.splashscreen.local.b.b(f.this.getContext(), com.kwad.sdk.core.response.a.d.bU(f.this.Cg.mAdTemplate));
            f.this.a(new e(), true);
            f.this.a(new g(), true);
        }
    };

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.Cg.a(this.DV);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Cg.b(this.DV);
    }
}
