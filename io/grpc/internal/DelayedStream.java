package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/DelayedStream.class */
class DelayedStream implements ClientStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private DelayedStreamListener delayedListener;
    private Status error;
    private ClientStreamListener listener;
    private volatile boolean passThrough;
    private List<Runnable> pendingCalls = new ArrayList();
    private ClientStream realStream;
    private long startTimeNanos;
    private long streamSetTimeNanos;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/DelayedStream$DelayedStreamListener.class */
    public static class DelayedStreamListener implements ClientStreamListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile boolean passThrough;
        private List<Runnable> pendingCallbacks = new ArrayList();
        private final ClientStreamListener realListener;

        public DelayedStreamListener(ClientStreamListener clientStreamListener) {
            this.realListener = clientStreamListener;
        }

        private void delayOrExecute(Runnable runnable) {
            synchronized (this) {
                if (this.passThrough) {
                    runnable.run();
                } else {
                    this.pendingCallbacks.add(runnable);
                }
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(final Status status, final Metadata metadata) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.4
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStreamListener.this.realListener.closed(status, metadata);
                }
            });
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(final Status status, final ClientStreamListener.RpcProgress rpcProgress, final Metadata metadata) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.5
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStreamListener.this.realListener.closed(status, rpcProgress, metadata);
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void drainPendingCallbacks() {
            List<Runnable> list;
            List arrayList = new ArrayList();
            while (true) {
                List list2 = arrayList;
                synchronized (this) {
                    if (this.pendingCallbacks.isEmpty()) {
                        this.pendingCallbacks = null;
                        this.passThrough = true;
                        return;
                    }
                    list = this.pendingCallbacks;
                    this.pendingCallbacks = list2;
                }
                for (Runnable runnable : list) {
                    runnable.run();
                }
                list.clear();
                arrayList = list;
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void headersRead(final Metadata metadata) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.3
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStreamListener.this.realListener.headersRead(metadata);
                }
            });
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(final StreamListener.MessageProducer messageProducer) {
            if (this.passThrough) {
                this.realListener.messagesAvailable(messageProducer);
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedStreamListener.this.realListener.messagesAvailable(messageProducer);
                    }
                });
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            if (this.passThrough) {
                this.realListener.onReady();
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedStreamListener.this.realListener.onReady();
                    }
                });
            }
        }
    }

    private void delayOrExecute(Runnable runnable) {
        synchronized (this) {
            if (this.passThrough) {
                runnable.run();
            } else {
                this.pendingCalls.add(runnable);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
        r0 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (r0.hasNext() == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void drainPendingCalls() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            r4 = r0
        L8:
            r0 = r3
            monitor-enter(r0)
            r0 = r3
            java.util.List<java.lang.Runnable> r0 = r0.pendingCalls     // Catch: java.lang.Throwable -> L68
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L30
            r0 = r3
            r1 = 0
            r0.pendingCalls = r1     // Catch: java.lang.Throwable -> L68
            r0 = r3
            r1 = 1
            r0.passThrough = r1     // Catch: java.lang.Throwable -> L68
            r0 = r3
            io.grpc.internal.DelayedStream$DelayedStreamListener r0 = r0.delayedListener     // Catch: java.lang.Throwable -> L68
            r4 = r0
            r0 = r3
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L68
            r0 = r4
            if (r0 == 0) goto L2f
            r0 = r4
            r0.drainPendingCallbacks()
        L2f:
            return
        L30:
            r0 = r3
            java.util.List<java.lang.Runnable> r0 = r0.pendingCalls     // Catch: java.lang.Throwable -> L68
            r5 = r0
            r0 = r3
            r1 = r4
            r0.pendingCalls = r1     // Catch: java.lang.Throwable -> L68
            r0 = r3
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L68
            r0 = r5
            java.util.Iterator r0 = r0.iterator()
            r4 = r0
        L43:
            r0 = r4
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L5d
            r0 = r4
            java.lang.Object r0 = r0.next()
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r0.run()
            goto L43
        L5d:
            r0 = r5
            r0.clear()
            r0 = r5
            r4 = r0
            goto L8
        L68:
            r4 = move-exception
            r0 = r3
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L68
            r0 = r4
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.DelayedStream.drainPendingCalls():void");
    }

    private void setRealStream(ClientStream clientStream) {
        Preconditions.checkState(this.realStream == null, "realStream already set to %s", this.realStream);
        this.realStream = clientStream;
        this.streamSetTimeNanos = System.nanoTime();
    }

    @Override // io.grpc.internal.ClientStream
    public void appendTimeoutInsight(InsightBuilder insightBuilder) {
        synchronized (this) {
            if (this.listener == null) {
                return;
            }
            if (this.realStream != null) {
                insightBuilder.appendKeyValue("buffered_nanos", Long.valueOf(this.streamSetTimeNanos - this.startTimeNanos));
                this.realStream.appendTimeoutInsight(insightBuilder);
            } else {
                insightBuilder.appendKeyValue("buffered_nanos", Long.valueOf(System.nanoTime() - this.startTimeNanos));
                insightBuilder.append("waiting_for_connection");
            }
        }
    }

    @Override // io.grpc.internal.ClientStream
    public void cancel(final Status status) {
        boolean z;
        ClientStreamListener clientStreamListener;
        Preconditions.checkNotNull(status, "reason");
        synchronized (this) {
            if (this.realStream == null) {
                setRealStream(NoopClientStream.INSTANCE);
                z = false;
                clientStreamListener = this.listener;
                this.error = status;
            } else {
                z = true;
                clientStreamListener = null;
            }
        }
        if (z) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.8
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.cancel(status);
                }
            });
            return;
        }
        if (clientStreamListener != null) {
            clientStreamListener.closed(status, new Metadata());
        }
        drainPendingCalls();
    }

    @Override // io.grpc.internal.Stream
    public void flush() {
        if (this.passThrough) {
            this.realStream.flush();
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.7
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.flush();
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public Attributes getAttributes() {
        ClientStream clientStream;
        synchronized (this) {
            clientStream = this.realStream;
        }
        return clientStream != null ? clientStream.getAttributes() : Attributes.EMPTY;
    }

    ClientStream getRealStream() {
        return this.realStream;
    }

    @Override // io.grpc.internal.ClientStream
    public void halfClose() {
        delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.9
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.halfClose();
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public boolean isReady() {
        if (this.passThrough) {
            return this.realStream.isReady();
        }
        return false;
    }

    @Override // io.grpc.internal.Stream
    public void optimizeForDirectExecutor() {
        delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.11
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.optimizeForDirectExecutor();
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public void request(final int i) {
        if (this.passThrough) {
            this.realStream.request(i);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.10
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.request(i);
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public void setAuthority(final String str) {
        Preconditions.checkState(this.listener == null, "May only be called before start");
        Preconditions.checkNotNull(str, "authority");
        delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.4
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setAuthority(str);
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public void setCompressor(final Compressor compressor) {
        Preconditions.checkNotNull(compressor, "compressor");
        delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.12
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setCompressor(compressor);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void setDeadline(final Deadline deadline) {
        delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.3
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setDeadline(deadline);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void setDecompressorRegistry(final DecompressorRegistry decompressorRegistry) {
        Preconditions.checkNotNull(decompressorRegistry, "decompressorRegistry");
        delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.14
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setDecompressorRegistry(decompressorRegistry);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void setFullStreamDecompression(final boolean z) {
        delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.13
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setFullStreamDecompression(z);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxInboundMessageSize(final int i) {
        if (this.passThrough) {
            this.realStream.setMaxInboundMessageSize(i);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.1
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.setMaxInboundMessageSize(i);
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxOutboundMessageSize(final int i) {
        if (this.passThrough) {
            this.realStream.setMaxOutboundMessageSize(i);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.2
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.setMaxOutboundMessageSize(i);
                }
            });
        }
    }

    @Override // io.grpc.internal.Stream
    public void setMessageCompression(final boolean z) {
        if (this.passThrough) {
            this.realStream.setMessageCompression(z);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.15
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.setMessageCompression(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setStream(ClientStream clientStream) {
        synchronized (this) {
            if (this.realStream != null) {
                return;
            }
            setRealStream((ClientStream) Preconditions.checkNotNull(clientStream, "stream"));
            drainPendingCalls();
        }
    }

    @Override // io.grpc.internal.ClientStream
    public void start(ClientStreamListener clientStreamListener) {
        Status status;
        boolean z;
        DelayedStreamListener delayedStreamListener;
        Preconditions.checkState(this.listener == null, "already started");
        synchronized (this) {
            this.listener = (ClientStreamListener) Preconditions.checkNotNull(clientStreamListener, "listener");
            status = this.error;
            z = this.passThrough;
            delayedStreamListener = clientStreamListener;
            if (!z) {
                DelayedStreamListener delayedStreamListener2 = new DelayedStreamListener(clientStreamListener);
                this.delayedListener = delayedStreamListener2;
                delayedStreamListener = delayedStreamListener2;
            }
            this.startTimeNanos = System.nanoTime();
        }
        if (status != null) {
            delayedStreamListener.closed(status, new Metadata());
        } else if (z) {
            this.realStream.start(delayedStreamListener);
        } else {
            final ClientStreamListener clientStreamListener2 = delayedStreamListener;
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.5
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.start(clientStreamListener2);
                }
            });
        }
    }

    @Override // io.grpc.internal.Stream
    public void writeMessage(final InputStream inputStream) {
        Preconditions.checkNotNull(inputStream, "message");
        if (this.passThrough) {
            this.realStream.writeMessage(inputStream);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.6
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.writeMessage(inputStream);
                }
            });
        }
    }
}
