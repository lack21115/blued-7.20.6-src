package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/chunk/e.class */
public class e {
    final com.kwad.sdk.pngencrypt.k auQ;
    List<PngChunk> awK = new ArrayList();
    boolean awL = false;

    public e(com.kwad.sdk.pngencrypt.k kVar) {
        this.auQ = kVar;
    }

    private static List<PngChunk> a(List<PngChunk> list, final String str, final String str2) {
        return str2 == null ? b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                return pngChunk.awG.equals(str);
            }
        }) : b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                if (pngChunk.awG.equals(str)) {
                    if (!(pngChunk instanceof t) || ((t) pngChunk).getKey().equals(str2)) {
                        return !(pngChunk instanceof n) || ((n) pngChunk).Cg().equals(str2);
                    }
                    return false;
                }
                return false;
            }
        });
    }

    public final List<PngChunk> BX() {
        return this.awK;
    }

    public final List<? extends PngChunk> W(String str, String str2) {
        return a(this.awK, str, str2);
    }

    public final void a(PngChunk pngChunk, int i) {
        pngChunk.bU(i);
        this.awK.add(pngChunk);
        if (pngChunk.awG.equals("PLTE")) {
            this.awL = true;
        }
    }

    public String toString() {
        return "ChunkList: read: " + this.awK.size();
    }
}
