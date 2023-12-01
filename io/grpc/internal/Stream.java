package io.grpc.internal;

import io.grpc.Compressor;
import java.io.InputStream;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/Stream.class */
public interface Stream {
    void flush();

    boolean isReady();

    void optimizeForDirectExecutor();

    void request(int i);

    void setCompressor(Compressor compressor);

    void setMessageCompression(boolean z);

    void writeMessage(InputStream inputStream);
}
