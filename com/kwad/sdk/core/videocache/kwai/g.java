package com.kwad.sdk.core.videocache.kwai;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/kwai/g.class */
public final class g extends e {
    private final long maxSize;

    public g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.maxSize = j;
    }

    @Override // com.kwad.sdk.core.videocache.kwai.e
    protected final boolean W(long j) {
        return j <= this.maxSize;
    }
}
