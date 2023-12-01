package com.blued.android.core.image.apng.io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/io/ByteBufferWriter.class */
public class ByteBufferWriter implements Writer {
    protected ByteBuffer a;

    public ByteBufferWriter() {
        c(GL10.GL_TEXTURE_MAG_FILTER);
    }

    public int a() {
        return this.a.position();
    }

    public void a(byte b) {
        this.a.put(b);
    }

    public void a(byte[] bArr) {
        this.a.put(bArr);
    }

    public byte[] b() {
        return this.a.array();
    }

    @Override // com.blued.android.core.image.apng.io.Writer
    public void c() {
        this.a.clear();
    }

    public void c(int i) {
        ByteBuffer byteBuffer = this.a;
        if (byteBuffer == null || i > byteBuffer.capacity()) {
            ByteBuffer allocate = ByteBuffer.allocate(i);
            this.a = allocate;
            allocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.a.clear();
    }

    public void d(int i) {
        this.a.position(i + a());
    }
}
