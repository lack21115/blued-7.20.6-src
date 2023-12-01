package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.internal.SerializingExecutor;
import io.grpc.okhttp.ExceptionHandlingFrameWriter;
import io.perfmark.Link;
import io.perfmark.PerfMark;
import java.io.IOException;
import java.net.Socket;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:io/grpc/okhttp/AsyncSink.class */
public final class AsyncSink implements Sink {
    private final SerializingExecutor serializingExecutor;
    @Nullable
    private Sink sink;
    @Nullable
    private Socket socket;
    private final ExceptionHandlingFrameWriter.TransportExceptionHandler transportExceptionHandler;
    private final Object lock = new Object();
    private final Buffer buffer = new Buffer();
    private boolean writeEnqueued = false;
    private boolean flushEnqueued = false;
    private boolean closed = false;

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/okhttp/AsyncSink$WriteRunnable.class */
    abstract class WriteRunnable implements Runnable {
        private WriteRunnable() {
        }

        public abstract void doRun() throws IOException;

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (AsyncSink.this.sink == null) {
                    throw new IOException("Unable to perform write due to unavailable sink.");
                }
                doRun();
            } catch (Exception e) {
                AsyncSink.this.transportExceptionHandler.onException(e);
            }
        }
    }

    private AsyncSink(SerializingExecutor serializingExecutor, ExceptionHandlingFrameWriter.TransportExceptionHandler transportExceptionHandler) {
        this.serializingExecutor = (SerializingExecutor) Preconditions.checkNotNull(serializingExecutor, "executor");
        this.transportExceptionHandler = (ExceptionHandlingFrameWriter.TransportExceptionHandler) Preconditions.checkNotNull(transportExceptionHandler, "exceptionHandler");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AsyncSink sink(SerializingExecutor serializingExecutor, ExceptionHandlingFrameWriter.TransportExceptionHandler transportExceptionHandler) {
        return new AsyncSink(serializingExecutor, transportExceptionHandler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void becomeConnected(Sink sink, Socket socket) {
        Preconditions.checkState(this.sink == null, "AsyncSink's becomeConnected should only be called once.");
        this.sink = (Sink) Preconditions.checkNotNull(sink, "sink");
        this.socket = (Socket) Preconditions.checkNotNull(socket, "socket");
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.okhttp.AsyncSink.3
            @Override // java.lang.Runnable
            public void run() {
                AsyncSink.this.buffer.close();
                try {
                    if (AsyncSink.this.sink != null) {
                        AsyncSink.this.sink.close();
                    }
                } catch (IOException e) {
                    AsyncSink.this.transportExceptionHandler.onException(e);
                }
                try {
                    if (AsyncSink.this.socket != null) {
                        AsyncSink.this.socket.close();
                    }
                } catch (IOException e2) {
                    AsyncSink.this.transportExceptionHandler.onException(e2);
                }
            }
        });
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        PerfMark.startTask("AsyncSink.flush");
        try {
            synchronized (this.lock) {
                if (this.flushEnqueued) {
                    PerfMark.stopTask("AsyncSink.flush");
                    return;
                }
                this.flushEnqueued = true;
                this.serializingExecutor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncSink.2
                    final Link link = PerfMark.linkOut();

                    @Override // io.grpc.okhttp.AsyncSink.WriteRunnable
                    public void doRun() throws IOException {
                        PerfMark.startTask("WriteRunnable.runFlush");
                        PerfMark.linkIn(this.link);
                        Buffer buffer = new Buffer();
                        try {
                            synchronized (AsyncSink.this.lock) {
                                buffer.write(AsyncSink.this.buffer, AsyncSink.this.buffer.size());
                                AsyncSink.this.flushEnqueued = false;
                            }
                            AsyncSink.this.sink.write(buffer, buffer.size());
                            AsyncSink.this.sink.flush();
                            PerfMark.stopTask("WriteRunnable.runFlush");
                        } catch (Throwable th) {
                            PerfMark.stopTask("WriteRunnable.runFlush");
                            throw th;
                        }
                    }
                });
                PerfMark.stopTask("AsyncSink.flush");
            }
        } catch (Throwable th) {
            PerfMark.stopTask("AsyncSink.flush");
            throw th;
        }
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        Preconditions.checkNotNull(buffer, "source");
        if (this.closed) {
            throw new IOException("closed");
        }
        PerfMark.startTask("AsyncSink.write");
        try {
            synchronized (this.lock) {
                this.buffer.write(buffer, j);
                if (!this.writeEnqueued && !this.flushEnqueued && this.buffer.completeSegmentByteCount() > 0) {
                    this.writeEnqueued = true;
                    this.serializingExecutor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncSink.1
                        final Link link = PerfMark.linkOut();

                        @Override // io.grpc.okhttp.AsyncSink.WriteRunnable
                        public void doRun() throws IOException {
                            PerfMark.startTask("WriteRunnable.runWrite");
                            PerfMark.linkIn(this.link);
                            Buffer buffer2 = new Buffer();
                            try {
                                synchronized (AsyncSink.this.lock) {
                                    buffer2.write(AsyncSink.this.buffer, AsyncSink.this.buffer.completeSegmentByteCount());
                                    AsyncSink.this.writeEnqueued = false;
                                }
                                AsyncSink.this.sink.write(buffer2, buffer2.size());
                                PerfMark.stopTask("WriteRunnable.runWrite");
                            } catch (Throwable th) {
                                PerfMark.stopTask("WriteRunnable.runWrite");
                                throw th;
                            }
                        }
                    });
                    PerfMark.stopTask("AsyncSink.write");
                    return;
                }
                PerfMark.stopTask("AsyncSink.write");
            }
        } catch (Throwable th) {
            PerfMark.stopTask("AsyncSink.write");
            throw th;
        }
    }
}
