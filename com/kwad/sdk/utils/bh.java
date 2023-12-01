package com.kwad.sdk.utils;

import android.os.SystemClock;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/bh.class */
public final class bh {
    private long aBu;
    private long aBv;
    private boolean aBw;

    public bh() {
        reset();
    }

    private void reset() {
        this.aBu = 0L;
        this.aBv = -1L;
    }

    public final void EX() {
        if (this.aBw && this.aBv < 0) {
            this.aBv = SystemClock.elapsedRealtime();
        }
    }

    public final void EY() {
        if (this.aBw && this.aBv > 0) {
            this.aBu += SystemClock.elapsedRealtime() - this.aBv;
            this.aBv = -1L;
        }
    }

    public final long EZ() {
        if (this.aBw) {
            this.aBw = false;
            if (this.aBv > 0) {
                this.aBu += SystemClock.elapsedRealtime() - this.aBv;
                this.aBv = -1L;
            }
            return this.aBu;
        }
        return 0L;
    }

    public final long getTime() {
        long j = this.aBv;
        long j2 = this.aBu;
        long j3 = j2;
        if (j > 0) {
            j3 = (j2 + SystemClock.elapsedRealtime()) - this.aBv;
        }
        return j3;
    }

    public final void startTiming() {
        reset();
        this.aBw = true;
        this.aBv = SystemClock.elapsedRealtime();
    }
}
