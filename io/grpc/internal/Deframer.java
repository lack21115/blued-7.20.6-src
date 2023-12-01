package io.grpc.internal;

import io.grpc.Decompressor;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/Deframer.class */
public interface Deframer {
    void close();

    void closeWhenComplete();

    void deframe(ReadableBuffer readableBuffer);

    void request(int i);

    void setDecompressor(Decompressor decompressor);

    void setFullStreamDecompressor(GzipInflatingBuffer gzipInflatingBuffer);

    void setMaxInboundMessageSize(int i);
}
