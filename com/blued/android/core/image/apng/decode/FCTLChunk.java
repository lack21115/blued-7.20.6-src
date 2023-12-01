package com.blued.android.core.image.apng.decode;

import com.blued.android.core.image.apng.io.APNGReader;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/decode/FCTLChunk.class */
class FCTLChunk extends Chunk {
    static final int a = Chunk.a("fcTL");
    int b;
    int c;
    int h;
    int i;
    int j;
    short k;
    short l;
    byte m;
    byte n;

    @Override // com.blued.android.core.image.apng.decode.Chunk
    void a(APNGReader aPNGReader) throws IOException {
        this.b = aPNGReader.m_();
        this.c = aPNGReader.m_();
        this.h = aPNGReader.m_();
        this.i = aPNGReader.m_();
        this.j = aPNGReader.m_();
        this.k = aPNGReader.c();
        this.l = aPNGReader.c();
        this.m = aPNGReader.n_();
        this.n = aPNGReader.n_();
    }
}
