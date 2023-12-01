package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ForwardingClientStreamListener.class */
abstract class ForwardingClientStreamListener implements ClientStreamListener {
    @Override // io.grpc.internal.ClientStreamListener
    public void closed(Status status, Metadata metadata) {
        delegate().closed(status, metadata);
    }

    @Override // io.grpc.internal.ClientStreamListener
    public void closed(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata metadata) {
        delegate().closed(status, rpcProgress, metadata);
    }

    protected abstract ClientStreamListener delegate();

    @Override // io.grpc.internal.ClientStreamListener
    public void headersRead(Metadata metadata) {
        delegate().headersRead(metadata);
    }

    @Override // io.grpc.internal.StreamListener
    public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
        delegate().messagesAvailable(messageProducer);
    }

    @Override // io.grpc.internal.StreamListener
    public void onReady() {
        delegate().onReady();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}
