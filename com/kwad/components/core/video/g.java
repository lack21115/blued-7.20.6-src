package com.kwad.components.core.video;

import android.os.SystemClock;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/g.class */
public final class g {
    private volatile boolean RD;
    private long RE;
    private a RF = new a();

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/g$a.class */
    public static final class a {
        private long RG = 0;
        private int RH = 0;

        public final void accumulate(long j) {
            this.RG += j;
            this.RH++;
        }

        public final int qH() {
            return this.RH;
        }

        public final long qI() {
            return this.RG;
        }
    }

    public final void qC() {
        if (this.RD) {
            return;
        }
        this.RD = true;
        this.RE = SystemClock.elapsedRealtime();
        com.kwad.sdk.core.video.kwai.kwai.a.cN("videoStartBlock");
    }

    public final void qD() {
        if (this.RD) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.RE;
            this.RF.accumulate(elapsedRealtime);
            this.RD = false;
            com.kwad.sdk.core.video.kwai.kwai.a.cN("videoEndBlock");
            com.kwad.sdk.core.video.kwai.kwai.a.cN("videoBlockTime_" + elapsedRealtime);
        }
    }

    public final boolean qE() {
        return this.RD;
    }

    public final a qF() {
        if (this.RD) {
            this.RF.accumulate(SystemClock.elapsedRealtime() - this.RE);
            this.RD = false;
        }
        return this.RF;
    }

    public final long qG() {
        return this.RE;
    }
}
