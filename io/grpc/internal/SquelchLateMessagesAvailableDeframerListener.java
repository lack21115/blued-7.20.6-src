package io.grpc.internal;

import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import java.io.Closeable;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/SquelchLateMessagesAvailableDeframerListener.class */
final class SquelchLateMessagesAvailableDeframerListener extends ForwardingDeframerListener {
    private boolean closed;
    private final MessageDeframer.Listener delegate;

    public SquelchLateMessagesAvailableDeframerListener(MessageDeframer.Listener listener) {
        this.delegate = listener;
    }

    @Override // io.grpc.internal.ForwardingDeframerListener, io.grpc.internal.MessageDeframer.Listener
    public void deframeFailed(Throwable th) {
        this.closed = true;
        super.deframeFailed(th);
    }

    @Override // io.grpc.internal.ForwardingDeframerListener, io.grpc.internal.MessageDeframer.Listener
    public void deframerClosed(boolean z) {
        this.closed = true;
        super.deframerClosed(z);
    }

    @Override // io.grpc.internal.ForwardingDeframerListener
    protected MessageDeframer.Listener delegate() {
        return this.delegate;
    }

    @Override // io.grpc.internal.ForwardingDeframerListener, io.grpc.internal.MessageDeframer.Listener
    public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
        if (!this.closed) {
            super.messagesAvailable(messageProducer);
        } else if (messageProducer instanceof Closeable) {
            GrpcUtil.closeQuietly((Closeable) messageProducer);
        }
    }
}
