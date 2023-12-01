package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Status;
import java.io.InputStream;
import javax.annotation.Nonnull;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/NoopClientStream.class */
public class NoopClientStream implements ClientStream {
    public static final NoopClientStream INSTANCE = new NoopClientStream();

    @Override // io.grpc.internal.ClientStream
    public void appendTimeoutInsight(InsightBuilder insightBuilder) {
        insightBuilder.append("noop");
    }

    @Override // io.grpc.internal.ClientStream
    public void cancel(Status status) {
    }

    @Override // io.grpc.internal.Stream
    public void flush() {
    }

    @Override // io.grpc.internal.ClientStream
    public Attributes getAttributes() {
        return Attributes.EMPTY;
    }

    @Override // io.grpc.internal.ClientStream
    public void halfClose() {
    }

    @Override // io.grpc.internal.Stream
    public boolean isReady() {
        return false;
    }

    @Override // io.grpc.internal.Stream
    public void optimizeForDirectExecutor() {
    }

    @Override // io.grpc.internal.Stream
    public void request(int i) {
    }

    @Override // io.grpc.internal.ClientStream
    public void setAuthority(String str) {
    }

    @Override // io.grpc.internal.Stream
    public void setCompressor(Compressor compressor) {
    }

    @Override // io.grpc.internal.ClientStream
    public void setDeadline(@Nonnull Deadline deadline) {
    }

    @Override // io.grpc.internal.ClientStream
    public void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
    }

    @Override // io.grpc.internal.ClientStream
    public void setFullStreamDecompression(boolean z) {
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxInboundMessageSize(int i) {
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxOutboundMessageSize(int i) {
    }

    @Override // io.grpc.internal.Stream
    public void setMessageCompression(boolean z) {
    }

    @Override // io.grpc.internal.ClientStream
    public void start(ClientStreamListener clientStreamListener) {
    }

    @Override // io.grpc.internal.Stream
    public void writeMessage(InputStream inputStream) {
    }
}
