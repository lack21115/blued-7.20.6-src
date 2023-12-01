package com.blued.android.core.image.apng.decode;

import com.blued.android.core.image.apng.io.APNGReader;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/decode/IHDRChunk.class */
class IHDRChunk extends Chunk {
    static final int a = Chunk.a("IHDR");
    int b;
    int c;
    byte[] h = new byte[5];

    @Override // com.blued.android.core.image.apng.decode.Chunk
    void a(APNGReader aPNGReader) throws IOException {
        this.b = aPNGReader.m_();
        this.c = aPNGReader.m_();
        byte[] bArr = this.h;
        aPNGReader.read(bArr, 0, bArr.length);
    }
}
