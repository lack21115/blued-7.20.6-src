package com.huawei.openalliance.ad.media;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/media/e.class */
public enum e {
    END(-2),
    ERROR(-1),
    IDLE(0),
    INITIALIZED(1),
    PREPARING(2),
    PREPARED(3),
    PLAYING(4),
    PAUSED(5),
    PLAYBACK_COMPLETED(6);
    
    int L;

    e(int i) {
        this.L = i;
    }

    public int Code() {
        return this.L;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + "(" + this.L + ")";
    }
}
