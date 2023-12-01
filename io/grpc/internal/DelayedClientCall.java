package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ClientCall;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.Metadata;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/DelayedClientCall.class */
class DelayedClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Executor callExecutor;
    private final Context context;
    private DelayedListener<RespT> delayedListener;
    private Status error;
    @Nullable
    private final ScheduledFuture<?> initialDeadlineMonitor;
    private ClientCall.Listener<RespT> listener;
    private volatile boolean passThrough;
    private List<Runnable> pendingRunnables = new ArrayList();
    private ClientCall<ReqT, RespT> realCall;
    private static final Logger logger = Logger.getLogger(DelayedClientCall.class.getName());
    private static final ClientCall<Object, Object> NOOP_CALL = new ClientCall<Object, Object>() { // from class: io.grpc.internal.DelayedClientCall.7
        @Override // io.grpc.ClientCall
        public void cancel(String str, Throwable th) {
        }

        @Override // io.grpc.ClientCall
        public void halfClose() {
        }

        @Override // io.grpc.ClientCall
        public boolean isReady() {
            return false;
        }

        @Override // io.grpc.ClientCall
        public void request(int i) {
        }

        @Override // io.grpc.ClientCall
        public void sendMessage(Object obj) {
        }

        @Override // io.grpc.ClientCall
        public void start(ClientCall.Listener<Object> listener, Metadata metadata) {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/DelayedClientCall$CloseListenerRunnable.class */
    public final class CloseListenerRunnable extends ContextRunnable {
        final ClientCall.Listener<RespT> listener;
        final Status status;

        CloseListenerRunnable(ClientCall.Listener<RespT> listener, Status status) {
            super(DelayedClientCall.this.context);
            this.listener = listener;
            this.status = status;
        }

        @Override // io.grpc.internal.ContextRunnable
        public void runInContext() {
            this.listener.onClose(this.status, new Metadata());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/DelayedClientCall$DelayedListener.class */
    public static final class DelayedListener<RespT> extends ClientCall.Listener<RespT> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile boolean passThrough;
        private List<Runnable> pendingCallbacks = new ArrayList();
        private final ClientCall.Listener<RespT> realListener;

        public DelayedListener(ClientCall.Listener<RespT> listener) {
            this.realListener = listener;
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

        /* JADX WARN: Multi-variable type inference failed */
        void drainPendingCallbacks() {
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

        @Override // io.grpc.ClientCall.Listener
        public void onClose(final Status status, final Metadata metadata) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.DelayedListener.3
                @Override // java.lang.Runnable
                public void run() {
                    DelayedListener.this.realListener.onClose(status, metadata);
                }
            });
        }

        @Override // io.grpc.ClientCall.Listener
        public void onHeaders(final Metadata metadata) {
            if (this.passThrough) {
                this.realListener.onHeaders(metadata);
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.DelayedListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedListener.this.realListener.onHeaders(metadata);
                    }
                });
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onMessage(final RespT respt) {
            if (this.passThrough) {
                this.realListener.onMessage(respt);
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.DelayedListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedListener.this.realListener.onMessage(respt);
                    }
                });
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onReady() {
            if (this.passThrough) {
                this.realListener.onReady();
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.DelayedListener.4
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedListener.this.realListener.onReady();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelayedClientCall(Executor executor, ScheduledExecutorService scheduledExecutorService, @Nullable Deadline deadline) {
        this.callExecutor = (Executor) Preconditions.checkNotNull(executor, "callExecutor");
        Preconditions.checkNotNull(scheduledExecutorService, "scheduler");
        this.context = Context.current();
        this.initialDeadlineMonitor = scheduleDeadlineIfNeeded(scheduledExecutorService, deadline);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void cancel(final Status status, boolean z) {
        boolean z2;
        ClientCall.Listener<RespT> listener;
        synchronized (this) {
            if (this.realCall == null) {
                setRealCall(NOOP_CALL);
                z2 = false;
                listener = this.listener;
                this.error = status;
            } else if (z) {
                return;
            } else {
                z2 = true;
                listener = null;
            }
            if (z2) {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedClientCall.this.realCall.cancel(status.getDescription(), status.getCause());
                    }
                });
            } else {
                if (listener != null) {
                    this.callExecutor.execute(new CloseListenerRunnable(listener, status));
                }
                drainPendingCalls();
            }
            callCancelled();
        }
    }

    private void delayOrExecute(Runnable runnable) {
        synchronized (this) {
            if (this.passThrough) {
                runnable.run();
            } else {
                this.pendingRunnables.add(runnable);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
        r0 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
        if (r0.hasNext() == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
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
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            r7 = r0
        L8:
            r0 = r6
            monitor-enter(r0)
            r0 = r6
            java.util.List<java.lang.Runnable> r0 = r0.pendingRunnables     // Catch: java.lang.Throwable -> L76
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L76
            if (r0 == 0) goto L3e
            r0 = r6
            r1 = 0
            r0.pendingRunnables = r1     // Catch: java.lang.Throwable -> L76
            r0 = r6
            r1 = 1
            r0.passThrough = r1     // Catch: java.lang.Throwable -> L76
            r0 = r6
            io.grpc.internal.DelayedClientCall$DelayedListener<RespT> r0 = r0.delayedListener     // Catch: java.lang.Throwable -> L76
            r7 = r0
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L76
            r0 = r7
            if (r0 == 0) goto L3d
            r0 = r6
            java.util.concurrent.Executor r0 = r0.callExecutor
            io.grpc.internal.DelayedClientCall$1DrainListenerRunnable r1 = new io.grpc.internal.DelayedClientCall$1DrainListenerRunnable
            r2 = r1
            r3 = r6
            r4 = r7
            r2.<init>()
            r0.execute(r1)
        L3d:
            return
        L3e:
            r0 = r6
            java.util.List<java.lang.Runnable> r0 = r0.pendingRunnables     // Catch: java.lang.Throwable -> L76
            r8 = r0
            r0 = r6
            r1 = r7
            r0.pendingRunnables = r1     // Catch: java.lang.Throwable -> L76
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L76
            r0 = r8
            java.util.Iterator r0 = r0.iterator()
            r7 = r0
        L51:
            r0 = r7
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L6b
            r0 = r7
            java.lang.Object r0 = r0.next()
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r0.run()
            goto L51
        L6b:
            r0 = r8
            r0.clear()
            r0 = r8
            r7 = r0
            goto L8
        L76:
            r7 = move-exception
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L76
            r0 = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.DelayedClientCall.drainPendingCalls():void");
    }

    @Nullable
    private ScheduledFuture<?> scheduleDeadlineIfNeeded(ScheduledExecutorService scheduledExecutorService, @Nullable Deadline deadline) {
        Deadline deadline2 = this.context.getDeadline();
        if (deadline == null && deadline2 == null) {
            return null;
        }
        long j = Long.MAX_VALUE;
        if (deadline != null) {
            j = Math.min(Long.MAX_VALUE, deadline.timeRemaining(TimeUnit.NANOSECONDS));
        }
        long j2 = j;
        if (deadline2 != null) {
            j2 = j;
            if (deadline2.timeRemaining(TimeUnit.NANOSECONDS) < j) {
                long timeRemaining = deadline2.timeRemaining(TimeUnit.NANOSECONDS);
                j2 = timeRemaining;
                if (logger.isLoggable(Level.FINE)) {
                    StringBuilder sb = new StringBuilder(String.format("Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(timeRemaining)));
                    if (deadline == null) {
                        sb.append(" Explicit call timeout was not set.");
                    } else {
                        sb.append(String.format(" Explicit call timeout was '%d' ns.", Long.valueOf(deadline.timeRemaining(TimeUnit.NANOSECONDS))));
                    }
                    logger.fine(sb.toString());
                    j2 = timeRemaining;
                }
            }
        }
        long abs = Math.abs(j2) / TimeUnit.SECONDS.toNanos(1L);
        long abs2 = Math.abs(j2);
        long nanos = TimeUnit.SECONDS.toNanos(1L);
        final StringBuilder sb2 = new StringBuilder();
        if (j2 < 0) {
            sb2.append("ClientCall started after deadline exceeded. Deadline exceeded after -");
        } else {
            sb2.append("Deadline exceeded after ");
        }
        sb2.append(abs);
        sb2.append(String.format(".%09d", Long.valueOf(abs2 % nanos)));
        sb2.append("s. ");
        return scheduledExecutorService.schedule(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.1DeadlineExceededRunnable
            @Override // java.lang.Runnable
            public void run() {
                DelayedClientCall.this.cancel(Status.DEADLINE_EXCEEDED.withDescription(sb2.toString()), true);
            }
        }, j2, TimeUnit.NANOSECONDS);
    }

    private void setRealCall(ClientCall<ReqT, RespT> clientCall) {
        Preconditions.checkState(this.realCall == null, "realCall already set to %s", this.realCall);
        ScheduledFuture<?> scheduledFuture = this.initialDeadlineMonitor;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.realCall = clientCall;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void callCancelled() {
    }

    @Override // io.grpc.ClientCall
    public final void cancel(@Nullable String str, @Nullable Throwable th) {
        Status status = Status.CANCELLED;
        Status withDescription = str != null ? status.withDescription(str) : status.withDescription("Call cancelled without message");
        Status status2 = withDescription;
        if (th != null) {
            status2 = withDescription.withCause(th);
        }
        cancel(status2, false);
    }

    @Override // io.grpc.ClientCall
    public final Attributes getAttributes() {
        ClientCall<ReqT, RespT> clientCall;
        synchronized (this) {
            clientCall = this.realCall;
        }
        return clientCall != null ? clientCall.getAttributes() : Attributes.EMPTY;
    }

    final ClientCall<ReqT, RespT> getRealCall() {
        return this.realCall;
    }

    @Override // io.grpc.ClientCall
    public final void halfClose() {
        delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.6
            @Override // java.lang.Runnable
            public void run() {
                DelayedClientCall.this.realCall.halfClose();
            }
        });
    }

    @Override // io.grpc.ClientCall
    public final boolean isReady() {
        if (this.passThrough) {
            return this.realCall.isReady();
        }
        return false;
    }

    @Override // io.grpc.ClientCall
    public final void request(final int i) {
        if (this.passThrough) {
            this.realCall.request(i);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.5
                @Override // java.lang.Runnable
                public void run() {
                    DelayedClientCall.this.realCall.request(i);
                }
            });
        }
    }

    @Override // io.grpc.ClientCall
    public final void sendMessage(final ReqT reqt) {
        if (this.passThrough) {
            this.realCall.sendMessage(reqt);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    DelayedClientCall.this.realCall.sendMessage(reqt);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setCall(ClientCall<ReqT, RespT> clientCall) {
        synchronized (this) {
            if (this.realCall != null) {
                return;
            }
            setRealCall((ClientCall) Preconditions.checkNotNull(clientCall, "call"));
            drainPendingCalls();
        }
    }

    @Override // io.grpc.ClientCall
    public final void setMessageCompression(final boolean z) {
        if (this.passThrough) {
            this.realCall.setMessageCompression(z);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.4
                @Override // java.lang.Runnable
                public void run() {
                    DelayedClientCall.this.realCall.setMessageCompression(z);
                }
            });
        }
    }

    @Override // io.grpc.ClientCall
    public final void start(ClientCall.Listener<RespT> listener, final Metadata metadata) {
        Status status;
        boolean z;
        DelayedListener<RespT> delayedListener;
        Preconditions.checkState(this.listener == null, "already started");
        synchronized (this) {
            this.listener = (ClientCall.Listener) Preconditions.checkNotNull(listener, "listener");
            status = this.error;
            z = this.passThrough;
            delayedListener = (DelayedListener<RespT>) listener;
            if (!z) {
                delayedListener = new DelayedListener<>(listener);
                this.delayedListener = delayedListener;
            }
        }
        if (status != null) {
            this.callExecutor.execute(new CloseListenerRunnable(delayedListener, status));
        } else if (z) {
            this.realCall.start(delayedListener, metadata);
        } else {
            final DelayedListener<RespT> delayedListener2 = delayedListener;
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.1
                @Override // java.lang.Runnable
                public void run() {
                    DelayedClientCall.this.realCall.start(delayedListener2, metadata);
                }
            });
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("realCall", this.realCall).toString();
    }
}
