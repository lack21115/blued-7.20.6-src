package com.blued.android.core.image.apng.io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/io/ByteBufferWriter.class */
public class ByteBufferWriter implements Writer {

    /* renamed from: a  reason: collision with root package name */
    protected ByteBuffer f9550a;

    public ByteBufferWriter() {
        c(10240);
    }

    public int a() {
        return this.f9550a.position();
    }

    public void a(byte b) {
        this.f9550a.put(b);
    }

    public void a(byte[] bArr) {
        this.f9550a.put(bArr);
    }

    public byte[] b() {
        return this.f9550a.array();
    }

    @Override // com.blued.android.core.image.apng.io.Writer
    public void c() {
        this.f9550a.clear();
    }

    public void c(int i) {
        ByteBuffer byteBuffer = this.f9550a;
        if (byteBuffer == null || i > byteBuffer.capacity()) {
            ByteBuffer allocate = ByteBuffer.allocate(i);
            this.f9550a = allocate;
            allocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.f9550a.clear();
    }

    public void d(int i) {
        this.f9550a.position(i + a());
    }
}
