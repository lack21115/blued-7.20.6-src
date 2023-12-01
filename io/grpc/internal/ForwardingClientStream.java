package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.Attributes;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Status;
import java.io.InputStream;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ForwardingClientStream.class */
abstract class ForwardingClientStream implements ClientStream {
    @Override // io.grpc.internal.ClientStream
    public void appendTimeoutInsight(InsightBuilder insightBuilder) {
        delegate().appendTimeoutInsight(insightBuilder);
    }

    @Override // io.grpc.internal.ClientStream
    public void cancel(Status status) {
        delegate().cancel(status);
    }

    protected abstract ClientStream delegate();

    @Override // io.grpc.internal.Stream
    public void flush() {
        delegate().flush();
    }

    @Override // io.grpc.internal.ClientStream
    public Attributes getAttributes() {
        return delegate().getAttributes();
    }

    @Override // io.grpc.internal.ClientStream
    public void halfClose() {
        delegate().halfClose();
    }

    @Override // io.grpc.internal.Stream
    public boolean isReady() {
        return delegate().isReady();
    }

    @Override // io.grpc.internal.Stream
    public void optimizeForDirectExecutor() {
        delegate().optimizeForDirectExecutor();
    }

    @Override // io.grpc.internal.Stream
    public void request(int i) {
        delegate().request(i);
    }

    @Override // io.grpc.internal.ClientStream
    public void setAuthority(String str) {
        delegate().setAuthority(str);
    }

    @Override // io.grpc.internal.Stream
    public void setCompressor(Compressor compressor) {
        delegate().setCompressor(compressor);
    }

    @Override // io.grpc.internal.ClientStream
    public void setDeadline(Deadline deadline) {
        delegate().setDeadline(deadline);
    }

    @Override // io.grpc.internal.ClientStream
    public void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
        delegate().setDecompressorRegistry(decompressorRegistry);
    }

    @Override // io.grpc.internal.ClientStream
    public void setFullStreamDecompression(boolean z) {
        delegate().setFullStreamDecompression(z);
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxInboundMessageSize(int i) {
        delegate().setMaxInboundMessageSize(i);
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxOutboundMessageSize(int i) {
        delegate().setMaxOutboundMessageSize(i);
    }

    @Override // io.grpc.internal.Stream
    public void setMessageCompression(boolean z) {
        delegate().setMessageCompression(z);
    }

    @Override // io.grpc.internal.ClientStream
    public void start(ClientStreamListener clientStreamListener) {
        delegate().start(clientStreamListener);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }

    @Override // io.grpc.internal.Stream
    public void writeMessage(InputStream inputStream) {
        delegate().writeMessage(inputStream);
    }
}
