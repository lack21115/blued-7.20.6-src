package io.grpc.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ReadableBuffer.class */
public interface ReadableBuffer extends Closeable {
    byte[] array();

    int arrayOffset();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    boolean hasArray();

    ReadableBuffer readBytes(int i);

    void readBytes(OutputStream outputStream, int i) throws IOException;

    void readBytes(ByteBuffer byteBuffer);

    void readBytes(byte[] bArr, int i, int i2);

    int readInt();

    int readUnsignedByte();

    int readableBytes();

    void skipBytes(int i);
}
