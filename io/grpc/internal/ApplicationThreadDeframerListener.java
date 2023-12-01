package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ApplicationThreadDeframerListener.class */
public final class ApplicationThreadDeframerListener implements MessageDeframer.Listener {
    private final Queue<InputStream> messageReadQueue = new ArrayDeque();
    private final MessageDeframer.Listener storedListener;
    private final TransportExecutor transportExecutor;

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ApplicationThreadDeframerListener$TransportExecutor.class */
    public interface TransportExecutor {
        void runOnTransportThread(Runnable runnable);
    }

    public ApplicationThreadDeframerListener(MessageDeframer.Listener listener, TransportExecutor transportExecutor) {
        this.storedListener = (MessageDeframer.Listener) Preconditions.checkNotNull(listener, "listener");
        this.transportExecutor = (TransportExecutor) Preconditions.checkNotNull(transportExecutor, "transportExecutor");
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void bytesRead(final int i) {
        this.transportExecutor.runOnTransportThread(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframerListener.1
            @Override // java.lang.Runnable
            public void run() {
                ApplicationThreadDeframerListener.this.storedListener.bytesRead(i);
            }
        });
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void deframeFailed(final Throwable th) {
        this.transportExecutor.runOnTransportThread(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframerListener.3
            @Override // java.lang.Runnable
            public void run() {
                ApplicationThreadDeframerListener.this.storedListener.deframeFailed(th);
            }
        });
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void deframerClosed(final boolean z) {
        this.transportExecutor.runOnTransportThread(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframerListener.2
            @Override // java.lang.Runnable
            public void run() {
                ApplicationThreadDeframerListener.this.storedListener.deframerClosed(z);
            }
        });
    }

    public InputStream messageReadQueuePoll() {
        return this.messageReadQueue.poll();
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
        while (true) {
            InputStream next = messageProducer.next();
            if (next == null) {
                return;
            }
            this.messageReadQueue.add(next);
        }
    }
}
