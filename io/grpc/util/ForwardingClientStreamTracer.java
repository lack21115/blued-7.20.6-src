package io.grpc.util;

import com.google.common.base.MoreObjects;
import io.grpc.ClientStreamTracer;
import io.grpc.Metadata;
import io.grpc.Status;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/util/ForwardingClientStreamTracer.class */
public abstract class ForwardingClientStreamTracer extends ClientStreamTracer {
    protected abstract ClientStreamTracer delegate();

    public void inboundHeaders() {
        delegate().inboundHeaders();
    }

    public void inboundMessage(int i) {
        delegate().inboundMessage(i);
    }

    public void inboundMessageRead(int i, long j, long j2) {
        delegate().inboundMessageRead(i, j, j2);
    }

    public void inboundTrailers(Metadata metadata) {
        delegate().inboundTrailers(metadata);
    }

    public void inboundUncompressedSize(long j) {
        delegate().inboundUncompressedSize(j);
    }

    public void inboundWireSize(long j) {
        delegate().inboundWireSize(j);
    }

    public void outboundHeaders() {
        delegate().outboundHeaders();
    }

    public void outboundMessage(int i) {
        delegate().outboundMessage(i);
    }

    public void outboundMessageSent(int i, long j, long j2) {
        delegate().outboundMessageSent(i, j, j2);
    }

    public void outboundUncompressedSize(long j) {
        delegate().outboundUncompressedSize(j);
    }

    public void outboundWireSize(long j) {
        delegate().outboundWireSize(j);
    }

    public void streamClosed(Status status) {
        delegate().streamClosed(status);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}
