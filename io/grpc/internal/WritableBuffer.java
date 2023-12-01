package io.grpc.internal;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/WritableBuffer.class */
public interface WritableBuffer {
    int readableBytes();

    void release();

    int writableBytes();

    void write(byte b);

    void write(byte[] bArr, int i, int i2);
}
