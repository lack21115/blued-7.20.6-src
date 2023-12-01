package com.blued.android.core.image.apng.io;

import java.nio.ByteOrder;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/io/APNGWriter.class */
public class APNGWriter extends ByteBufferWriter {
    public void a(int i) {
        a((byte) (i & 255));
        a((byte) ((i >> 8) & 255));
        a((byte) ((i >> 16) & 255));
        a((byte) ((i >> 24) & 255));
    }

    public void b(int i) {
        a((byte) ((i >> 24) & 255));
        a((byte) ((i >> 16) & 255));
        a((byte) ((i >> 8) & 255));
        a((byte) (i & 255));
    }

    @Override // com.blued.android.core.image.apng.io.ByteBufferWriter
    public void c(int i) {
        super.c(i);
        this.f9550a.order(ByteOrder.BIG_ENDIAN);
    }
}
