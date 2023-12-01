package com.blued.android.core.image.apng.decode;

import com.blued.android.core.image.apng.io.APNGReader;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/decode/ACTLChunk.class */
class ACTLChunk extends Chunk {

    /* renamed from: a  reason: collision with root package name */
    static final int f9518a = Chunk.a("acTL");
    int b;

    /* renamed from: c  reason: collision with root package name */
    int f9519c;

    @Override // com.blued.android.core.image.apng.decode.Chunk
    void a(APNGReader aPNGReader) throws IOException {
        this.b = aPNGReader.m_();
        this.f9519c = aPNGReader.m_();
    }
}
