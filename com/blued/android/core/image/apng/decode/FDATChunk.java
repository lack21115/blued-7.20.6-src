package com.blued.android.core.image.apng.decode;

import com.blued.android.core.image.apng.io.APNGReader;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/decode/FDATChunk.class */
class FDATChunk extends Chunk {

    /* renamed from: a  reason: collision with root package name */
    static final int f9526a = Chunk.a("fdAT");
    int b;

    @Override // com.blued.android.core.image.apng.decode.Chunk
    void a(APNGReader aPNGReader) throws IOException {
        this.b = aPNGReader.m_();
    }
}
