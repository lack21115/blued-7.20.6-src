package com.getui.gtc.base.http;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/BufferedSink.class */
final class BufferedSink {
    public final OutputStream sink;
    private long size;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BufferedSink(OutputStream outputStream) {
        if (outputStream == null) {
            throw new NullPointerException("sink == null");
        }
        this.sink = outputStream;
        this.size = 0L;
    }

    public final void close() throws IOException {
        this.sink.close();
    }

    public final long size() {
        return this.size;
    }

    public final BufferedSink write(String str) throws IOException {
        byte[] bytes;
        this.sink.write(str.getBytes());
        this.size += bytes.length;
        return this;
    }

    public final BufferedSink write(ByteBuffer byteBuffer) throws IOException {
        byte[] array;
        this.sink.write(byteBuffer.array());
        this.size += array.length;
        return this;
    }

    public final BufferedSink write(byte[] bArr) throws IOException {
        this.sink.write(bArr);
        this.size += bArr.length;
        return this;
    }

    public final BufferedSink writeLong(long j) throws IOException {
        byte[] bytes;
        this.sink.write(String.valueOf(j).getBytes());
        this.size += bytes.length;
        return this;
    }

    public final BufferedSink writeUtf8(String str) throws IOException {
        byte[] bytes;
        this.sink.write(str.getBytes());
        this.size += bytes.length;
        return this;
    }
}
