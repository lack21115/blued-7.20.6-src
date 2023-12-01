package com.kwad.sdk.core.g;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/g/b.class */
public abstract class b implements c {
    private boolean apo = false;
    private boolean JJ = false;
    private boolean JK = false;

    protected abstract void ap();

    protected abstract void aq();

    @Override // com.kwad.sdk.core.g.c
    public void onPageInvisible() {
        if (this.apo && !this.JJ) {
            aq();
            this.JJ = true;
        }
    }

    @Override // com.kwad.sdk.core.g.c
    public void onPageVisible() {
        this.apo = true;
        if (this.JK) {
            return;
        }
        ap();
        this.JK = true;
    }
}
