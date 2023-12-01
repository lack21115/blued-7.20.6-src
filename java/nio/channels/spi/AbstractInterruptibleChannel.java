package java.nio.channels.spi;

import java.io.IOException;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.Channel;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.InterruptibleChannel;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/spi/AbstractInterruptibleChannel.class */
public abstract class AbstractInterruptibleChannel implements Channel, InterruptibleChannel {
    private volatile boolean closed = false;
    volatile boolean interrupted = false;
    private final Runnable interruptAndCloseRunnable = new Runnable() { // from class: java.nio.channels.spi.AbstractInterruptibleChannel.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                AbstractInterruptibleChannel.this.interrupted = true;
                AbstractInterruptibleChannel.this.close();
            } catch (IOException e) {
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public final void begin() {
        Thread.currentThread().pushInterruptAction$(this.interruptAndCloseRunnable);
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.closed) {
            return;
        }
        synchronized (this) {
            if (!this.closed) {
                this.closed = true;
                implCloseChannel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void end(boolean z) throws AsynchronousCloseException {
        Thread.currentThread().popInterruptAction$(this.interruptAndCloseRunnable);
        if (this.interrupted) {
            this.interrupted = false;
            throw new ClosedByInterruptException();
        } else if (!z && this.closed) {
            throw new AsynchronousCloseException();
        }
    }

    protected abstract void implCloseChannel() throws IOException;

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        boolean z;
        synchronized (this) {
            z = !this.closed;
        }
        return z;
    }
}
