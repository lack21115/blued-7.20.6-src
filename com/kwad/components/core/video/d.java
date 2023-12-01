package com.kwad.components.core.video;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/d.class */
public final class d {
    private boolean Ro = false;
    private boolean Rp = false;
    private boolean Rq = false;
    private boolean Rr = false;
    private boolean Rs = false;
    private int Rt = -1;

    public final void aN(int i) {
        this.Rt = i;
    }

    public final void aN(boolean z) {
        this.Rq = z;
    }

    public final boolean qm() {
        return this.Rt > 0;
    }

    public final int qn() {
        return this.Rt;
    }

    public final boolean qo() {
        return this.Ro;
    }

    public final boolean qp() {
        return this.Rp;
    }

    public final boolean qq() {
        return this.Rq;
    }

    public final boolean qr() {
        return this.Rr;
    }

    public final boolean qs() {
        return this.Rs;
    }

    public final void setAd(boolean z) {
        this.Rp = z;
    }

    public final void setFillXY(boolean z) {
        this.Rs = z;
    }

    public final void setForce(boolean z) {
        this.Ro = z;
    }

    public final void setHorizontalVideo(boolean z) {
        this.Rr = z;
    }
}
