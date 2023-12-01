package com.kwad.sdk.pngencrypt.chunk;

import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/chunk/f.class */
public final class f extends e {
    private final List<PngChunk> awO;

    @Override // com.kwad.sdk.pngencrypt.chunk.e
    public final String toString() {
        return "ChunkList: written: " + BX().size() + " queue: " + this.awO.size();
    }
}
