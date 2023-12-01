package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/chunk/v.class */
public final class v extends t {
    public v(com.kwad.sdk.pngencrypt.k kVar) {
        super("zTXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= dVar.data.length) {
                i = -1;
                break;
            } else if (dVar.data[i] == 0) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i < 0 || i > dVar.data.length - 2) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("bad zTXt chunk: no separator found"));
        }
        this.key = b.d(dVar.data, 0, i);
        if (dVar.data[i + 1] != 0) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("bad zTXt chunk: unknown compression method"));
        }
        this.axu = b.i(b.b(dVar.data, i + 2, (dVar.data.length - i) - 2, false));
    }
}
