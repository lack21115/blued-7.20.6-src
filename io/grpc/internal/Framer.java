package io.grpc.internal;

import io.grpc.Compressor;
import java.io.InputStream;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/Framer.class */
public interface Framer {
    void close();

    void dispose();

    void flush();

    boolean isClosed();

    Framer setCompressor(Compressor compressor);

    void setMaxOutboundMessageSize(int i);

    Framer setMessageCompression(boolean z);

    void writePayload(InputStream inputStream);
}
