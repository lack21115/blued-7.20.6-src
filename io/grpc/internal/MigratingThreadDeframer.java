package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Decompressor;
import io.grpc.internal.ApplicationThreadDeframerListener;
import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import io.perfmark.Link;
import io.perfmark.PerfMark;
import java.io.Closeable;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/MigratingThreadDeframer.class */
final class MigratingThreadDeframer implements ThreadOptimizedDeframer {
    private final ApplicationThreadDeframerListener appListener;
    private final MessageDeframer deframer;
    private boolean deframerOnTransportThread;
    private boolean messageProducerEnqueued;
    private final MigratingDeframerListener migratingListener;
    private final ApplicationThreadDeframerListener.TransportExecutor transportExecutor;
    private final MessageDeframer.Listener transportListener;
    private final DeframeMessageProducer messageProducer = new DeframeMessageProducer();
    private final Object lock = new Object();
    private final Queue<Op> opQueue = new ArrayDeque();

    /* renamed from: io.grpc.internal.MigratingThreadDeframer$1DeframeOp  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/MigratingThreadDeframer$1DeframeOp.class */
    class C1DeframeOp implements Op, Closeable {
        final /* synthetic */ ReadableBuffer val$data;

        C1DeframeOp(ReadableBuffer readableBuffer) {
            this.val$data = readableBuffer;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.val$data.close();
        }

        @Override // io.grpc.internal.MigratingThreadDeframer.Op
        public void run(boolean z) {
            PerfMark.startTask("MigratingThreadDeframer.deframe");
            try {
                if (z) {
                    MigratingThreadDeframer.this.deframer.deframe(this.val$data);
                    PerfMark.stopTask("MigratingThreadDeframer.deframe");
                    return;
                }
                MigratingThreadDeframer.this.deframer.deframe(this.val$data);
                PerfMark.stopTask("MigratingThreadDeframer.deframe");
            } catch (Throwable th) {
                PerfMark.stopTask("MigratingThreadDeframer.deframe");
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/MigratingThreadDeframer$DeframeMessageProducer.class */
    public class DeframeMessageProducer implements StreamListener.MessageProducer, Closeable {
        DeframeMessageProducer() {
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Op op;
            while (true) {
                synchronized (MigratingThreadDeframer.this.lock) {
                    do {
                        op = (Op) MigratingThreadDeframer.this.opQueue.poll();
                        if (op == null) {
                            break;
                        }
                    } while (!(op instanceof Closeable));
                    if (op == null) {
                        MigratingThreadDeframer.this.messageProducerEnqueued = false;
                        return;
                    }
                }
                GrpcUtil.closeQuietly((Closeable) op);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
            if (r3.this$0.deframer.hasPendingDeliveries() == false) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
            io.perfmark.PerfMark.event("MigratingThreadDeframer.deframerOnTransportThread");
            r3.this$0.migratingListener.setDelegate(r3.this$0.transportListener);
            r3.this$0.deframerOnTransportThread = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x005c, code lost:
            r3.this$0.messageProducerEnqueued = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
            return null;
         */
        @Override // io.grpc.internal.StreamListener.MessageProducer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.io.InputStream next() {
            /*
                r3 = this;
            L0:
                r0 = r3
                io.grpc.internal.MigratingThreadDeframer r0 = io.grpc.internal.MigratingThreadDeframer.this
                io.grpc.internal.ApplicationThreadDeframerListener r0 = io.grpc.internal.MigratingThreadDeframer.access$500(r0)
                java.io.InputStream r0 = r0.messageReadQueuePoll()
                r4 = r0
                r0 = r4
                if (r0 == 0) goto L11
                r0 = r4
                return r0
            L11:
                r0 = r3
                io.grpc.internal.MigratingThreadDeframer r0 = io.grpc.internal.MigratingThreadDeframer.this
                java.lang.Object r0 = io.grpc.internal.MigratingThreadDeframer.access$600(r0)
                r4 = r0
                r0 = r4
                monitor-enter(r0)
                r0 = r3
                io.grpc.internal.MigratingThreadDeframer r0 = io.grpc.internal.MigratingThreadDeframer.this     // Catch: java.lang.Throwable -> L74
                java.util.Queue r0 = io.grpc.internal.MigratingThreadDeframer.access$900(r0)     // Catch: java.lang.Throwable -> L74
                java.lang.Object r0 = r0.poll()     // Catch: java.lang.Throwable -> L74
                io.grpc.internal.MigratingThreadDeframer$Op r0 = (io.grpc.internal.MigratingThreadDeframer.Op) r0     // Catch: java.lang.Throwable -> L74
                r5 = r0
                r0 = r5
                if (r0 != 0) goto L68
                r0 = r3
                io.grpc.internal.MigratingThreadDeframer r0 = io.grpc.internal.MigratingThreadDeframer.this     // Catch: java.lang.Throwable -> L74
                io.grpc.internal.MessageDeframer r0 = io.grpc.internal.MigratingThreadDeframer.access$400(r0)     // Catch: java.lang.Throwable -> L74
                boolean r0 = r0.hasPendingDeliveries()     // Catch: java.lang.Throwable -> L74
                if (r0 == 0) goto L5b
                java.lang.String r0 = "MigratingThreadDeframer.deframerOnTransportThread"
                io.perfmark.PerfMark.event(r0)     // Catch: java.lang.Throwable -> L74
                r0 = r3
                io.grpc.internal.MigratingThreadDeframer r0 = io.grpc.internal.MigratingThreadDeframer.this     // Catch: java.lang.Throwable -> L74
                io.grpc.internal.MigratingThreadDeframer$MigratingDeframerListener r0 = io.grpc.internal.MigratingThreadDeframer.access$700(r0)     // Catch: java.lang.Throwable -> L74
                r1 = r3
                io.grpc.internal.MigratingThreadDeframer r1 = io.grpc.internal.MigratingThreadDeframer.this     // Catch: java.lang.Throwable -> L74
                io.grpc.internal.MessageDeframer$Listener r1 = io.grpc.internal.MigratingThreadDeframer.access$100(r1)     // Catch: java.lang.Throwable -> L74
                r0.setDelegate(r1)     // Catch: java.lang.Throwable -> L74
                r0 = r3
                io.grpc.internal.MigratingThreadDeframer r0 = io.grpc.internal.MigratingThreadDeframer.this     // Catch: java.lang.Throwable -> L74
                r1 = 1
                boolean r0 = io.grpc.internal.MigratingThreadDeframer.access$802(r0, r1)     // Catch: java.lang.Throwable -> L74
            L5b:
                r0 = r3
                io.grpc.internal.MigratingThreadDeframer r0 = io.grpc.internal.MigratingThreadDeframer.this     // Catch: java.lang.Throwable -> L74
                r1 = 0
                boolean r0 = io.grpc.internal.MigratingThreadDeframer.access$1002(r0, r1)     // Catch: java.lang.Throwable -> L74
                r0 = r4
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L74
                r0 = 0
                return r0
            L68:
                r0 = r4
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L74
                r0 = r5
                r1 = 0
                r0.run(r1)
                goto L0
            L74:
                r5 = move-exception
                r0 = r4
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L74
                r0 = r5
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.MigratingThreadDeframer.DeframeMessageProducer.next():java.io.InputStream");
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/MigratingThreadDeframer$MigratingDeframerListener.class */
    static class MigratingDeframerListener extends ForwardingDeframerListener {
        private MessageDeframer.Listener delegate;

        public MigratingDeframerListener(MessageDeframer.Listener listener) {
            setDelegate(listener);
        }

        @Override // io.grpc.internal.ForwardingDeframerListener
        protected MessageDeframer.Listener delegate() {
            return this.delegate;
        }

        public void setDelegate(MessageDeframer.Listener listener) {
            this.delegate = (MessageDeframer.Listener) Preconditions.checkNotNull(listener, "delegate");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/MigratingThreadDeframer$Op.class */
    public interface Op {
        void run(boolean z);
    }

    public MigratingThreadDeframer(MessageDeframer.Listener listener, ApplicationThreadDeframerListener.TransportExecutor transportExecutor, MessageDeframer messageDeframer) {
        this.transportListener = new SquelchLateMessagesAvailableDeframerListener((MessageDeframer.Listener) Preconditions.checkNotNull(listener, "listener"));
        this.transportExecutor = (ApplicationThreadDeframerListener.TransportExecutor) Preconditions.checkNotNull(transportExecutor, "transportExecutor");
        ApplicationThreadDeframerListener applicationThreadDeframerListener = new ApplicationThreadDeframerListener(this.transportListener, transportExecutor);
        this.appListener = applicationThreadDeframerListener;
        MigratingDeframerListener migratingDeframerListener = new MigratingDeframerListener(applicationThreadDeframerListener);
        this.migratingListener = migratingDeframerListener;
        messageDeframer.setListener(migratingDeframerListener);
        this.deframer = messageDeframer;
    }

    static /* synthetic */ ApplicationThreadDeframerListener access$500(MigratingThreadDeframer migratingThreadDeframer) {
        return migratingThreadDeframer.appListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestFromTransportThread(final int i) {
        runWhereAppropriate(new Op() { // from class: io.grpc.internal.MigratingThreadDeframer.1RequestAgainOp
            @Override // io.grpc.internal.MigratingThreadDeframer.Op
            public void run(boolean z) {
                if (!z) {
                    MigratingThreadDeframer.this.request(i);
                    return;
                }
                try {
                    MigratingThreadDeframer.this.deframer.request(i);
                } catch (Throwable th) {
                    MigratingThreadDeframer.this.appListener.deframeFailed(th);
                    MigratingThreadDeframer.this.deframer.close();
                }
                if (MigratingThreadDeframer.this.deframer.hasPendingDeliveries()) {
                    return;
                }
                synchronized (MigratingThreadDeframer.this.lock) {
                    PerfMark.event("MigratingThreadDeframer.deframerOnApplicationThread");
                    MigratingThreadDeframer.this.migratingListener.setDelegate(MigratingThreadDeframer.this.appListener);
                    MigratingThreadDeframer.this.deframerOnTransportThread = false;
                }
            }
        });
    }

    private boolean runWhereAppropriate(Op op) {
        return runWhereAppropriate(op, true);
    }

    private boolean runWhereAppropriate(Op op, boolean z) {
        boolean z2;
        boolean z3;
        synchronized (this.lock) {
            z2 = this.deframerOnTransportThread;
            z3 = this.messageProducerEnqueued;
            if (!z2) {
                this.opQueue.offer(op);
                this.messageProducerEnqueued = true;
            }
        }
        if (z2) {
            op.run(true);
            return true;
        } else if (z3) {
            return false;
        } else {
            if (!z) {
                final Link linkOut = PerfMark.linkOut();
                this.transportExecutor.runOnTransportThread(new Runnable() { // from class: io.grpc.internal.MigratingThreadDeframer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PerfMark.startTask("MigratingThreadDeframer.messageAvailable");
                        PerfMark.linkIn(linkOut);
                        try {
                            MigratingThreadDeframer.this.transportListener.messagesAvailable(MigratingThreadDeframer.this.messageProducer);
                            PerfMark.stopTask("MigratingThreadDeframer.messageAvailable");
                        } catch (Throwable th) {
                            PerfMark.stopTask("MigratingThreadDeframer.messageAvailable");
                            throw th;
                        }
                    }
                });
                return false;
            }
            PerfMark.startTask("MigratingThreadDeframer.messageAvailable");
            try {
                this.transportListener.messagesAvailable(this.messageProducer);
                PerfMark.stopTask("MigratingThreadDeframer.messageAvailable");
                return false;
            } catch (Throwable th) {
                PerfMark.stopTask("MigratingThreadDeframer.messageAvailable");
                throw th;
            }
        }
    }

    @Override // io.grpc.internal.Deframer
    public void close() {
        if (runWhereAppropriate(new Op() { // from class: io.grpc.internal.MigratingThreadDeframer.1CloseOp
            @Override // io.grpc.internal.MigratingThreadDeframer.Op
            public void run(boolean z) {
                MigratingThreadDeframer.this.deframer.close();
            }
        })) {
            return;
        }
        this.deframer.stopDelivery();
    }

    @Override // io.grpc.internal.Deframer
    public void closeWhenComplete() {
        runWhereAppropriate(new Op() { // from class: io.grpc.internal.MigratingThreadDeframer.1CloseWhenCompleteOp
            @Override // io.grpc.internal.MigratingThreadDeframer.Op
            public void run(boolean z) {
                MigratingThreadDeframer.this.deframer.closeWhenComplete();
            }
        });
    }

    @Override // io.grpc.internal.Deframer
    public void deframe(ReadableBuffer readableBuffer) {
        runWhereAppropriate(new C1DeframeOp(readableBuffer));
    }

    @Override // io.grpc.internal.ThreadOptimizedDeframer, io.grpc.internal.Deframer
    public void request(final int i) {
        runWhereAppropriate(new Op() { // from class: io.grpc.internal.MigratingThreadDeframer.1RequestOp
            @Override // io.grpc.internal.MigratingThreadDeframer.Op
            public void run(boolean z) {
                if (z) {
                    final Link linkOut = PerfMark.linkOut();
                    MigratingThreadDeframer.this.transportExecutor.runOnTransportThread(new Runnable() { // from class: io.grpc.internal.MigratingThreadDeframer.1RequestOp.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PerfMark.startTask("MigratingThreadDeframer.request");
                            PerfMark.linkIn(linkOut);
                            try {
                                MigratingThreadDeframer.this.requestFromTransportThread(i);
                                PerfMark.stopTask("MigratingThreadDeframer.request");
                            } catch (Throwable th) {
                                PerfMark.stopTask("MigratingThreadDeframer.request");
                                throw th;
                            }
                        }
                    });
                    return;
                }
                PerfMark.startTask("MigratingThreadDeframer.request");
                try {
                    MigratingThreadDeframer.this.deframer.request(i);
                } finally {
                    try {
                        PerfMark.stopTask("MigratingThreadDeframer.request");
                    } catch (Throwable th) {
                    }
                }
                PerfMark.stopTask("MigratingThreadDeframer.request");
            }
        }, false);
    }

    @Override // io.grpc.internal.Deframer
    public void setDecompressor(Decompressor decompressor) {
        this.deframer.setDecompressor(decompressor);
    }

    @Override // io.grpc.internal.Deframer
    public void setFullStreamDecompressor(GzipInflatingBuffer gzipInflatingBuffer) {
        this.deframer.setFullStreamDecompressor(gzipInflatingBuffer);
    }

    @Override // io.grpc.internal.Deframer
    public void setMaxInboundMessageSize(int i) {
        this.deframer.setMaxInboundMessageSize(i);
    }
}
