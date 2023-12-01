package com.kwai.filedownloader;

import android.os.SystemClock;
import com.kwai.filedownloader.s;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/b.class */
public final class b implements s.a, s.b {
    private long aEP;
    private long aEQ;
    private long aER;
    private int aES;
    private int aET = 1000;
    private long mStartTime;

    @Override // com.kwai.filedownloader.s.b
    public final void aj(long j) {
        if (this.aET <= 0) {
            return;
        }
        boolean z = true;
        if (this.aEP != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.aEP;
            if (uptimeMillis >= this.aET || (this.aES == 0 && uptimeMillis > 0)) {
                int i = (int) ((j - this.aEQ) / uptimeMillis);
                this.aES = i;
                this.aES = Math.max(0, i);
            } else {
                z = false;
            }
        }
        if (z) {
            this.aEQ = j;
            this.aEP = SystemClock.uptimeMillis();
        }
    }

    @Override // com.kwai.filedownloader.s.b
    public final void end(long j) {
        if (this.mStartTime <= 0) {
            return;
        }
        long j2 = j - this.aER;
        this.aEP = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.mStartTime;
        if (uptimeMillis > 0) {
            j2 /= uptimeMillis;
        }
        this.aES = (int) j2;
    }

    @Override // com.kwai.filedownloader.s.a
    public final int getSpeed() {
        return this.aES;
    }

    @Override // com.kwai.filedownloader.s.b
    public final void reset() {
        this.aES = 0;
        this.aEP = 0L;
    }

    @Override // com.kwai.filedownloader.s.b
    public final void start(long j) {
        this.mStartTime = SystemClock.uptimeMillis();
        this.aER = j;
    }
}
