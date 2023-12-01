package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/chunk/q.class */
public final class q extends t {
    public q(com.kwad.sdk.pngencrypt.k kVar) {
        super("tEXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int i;
        String str;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= dVar.data.length || dVar.data[i] == 0) {
                break;
            }
            i2 = i + 1;
        }
        this.key = b.d(dVar.data, 0, i);
        int i3 = i + 1;
        if (i3 < dVar.data.length) {
            byte[] bArr = dVar.data;
            str = b.d(bArr, i3, bArr.length - i3);
        } else {
            str = "";
        }
        this.axu = str;
    }
}
