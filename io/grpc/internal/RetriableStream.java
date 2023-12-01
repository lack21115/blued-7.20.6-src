package io.grpc.internal;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ClientStreamTracer;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.HedgingPolicy;
import io.grpc.internal.RetryPolicy;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/RetriableStream.class */
public abstract class RetriableStream<ReqT> implements ClientStream {
    private final Executor callExecutor;
    private final long channelBufferLimit;
    private final ChannelBufferMeter channelBufferUsed;
    private final Metadata headers;
    private HedgingPolicy hedgingPolicy;
    private final HedgingPolicy.Provider hedgingPolicyProvider;
    private boolean isHedging;
    private ClientStreamListener masterListener;
    private final MethodDescriptor<ReqT, ?> method;
    private long nextBackoffIntervalNanos;
    private final long perRpcBufferLimit;
    private long perRpcBufferUsed;
    private RetryPolicy retryPolicy;
    private final RetryPolicy.Provider retryPolicyProvider;
    private final ScheduledExecutorService scheduledExecutorService;
    private FutureCanceller scheduledHedging;
    private FutureCanceller scheduledRetry;
    @Nullable
    private final Throttle throttle;
    static final Metadata.Key<String> GRPC_PREVIOUS_RPC_ATTEMPTS = Metadata.Key.of("grpc-previous-rpc-attempts", Metadata.ASCII_STRING_MARSHALLER);
    static final Metadata.Key<String> GRPC_RETRY_PUSHBACK_MS = Metadata.Key.of("grpc-retry-pushback-ms", Metadata.ASCII_STRING_MARSHALLER);
    private static final Status CANCELLED_BECAUSE_COMMITTED = Status.CANCELLED.withDescription("Stream thrown away because RetriableStream committed");
    private static Random random = new Random();
    private final Object lock = new Object();
    private final InsightBuilder closedSubstreamsInsight = new InsightBuilder();
    private volatile State state = new State(new ArrayList(8), Collections.emptyList(), null, null, false, false, false, 0);
    private final AtomicBoolean noMoreTransparentRetry = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/RetriableStream$BufferEntry.class */
    public interface BufferEntry {
        void runWith(Substream substream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/RetriableStream$BufferSizeTracer.class */
    public class BufferSizeTracer extends ClientStreamTracer {
        long bufferNeeded;
        private final Substream substream;

        BufferSizeTracer(Substream substream) {
            this.substream = substream;
        }

        @Override // io.grpc.StreamTracer
        public void outboundWireSize(long j) {
            if (RetriableStream.this.state.winningSubstream != null) {
                return;
            }
            Runnable runnable = null;
            synchronized (RetriableStream.this.lock) {
                if (RetriableStream.this.state.winningSubstream == null && !this.substream.closed) {
                    long j2 = this.bufferNeeded + j;
                    this.bufferNeeded = j2;
                    if (j2 <= RetriableStream.this.perRpcBufferUsed) {
                        return;
                    }
                    if (this.bufferNeeded > RetriableStream.this.perRpcBufferLimit) {
                        this.substream.bufferLimitExceeded = true;
                    } else {
                        long addAndGet = RetriableStream.this.channelBufferUsed.addAndGet(this.bufferNeeded - RetriableStream.this.perRpcBufferUsed);
                        RetriableStream.this.perRpcBufferUsed = this.bufferNeeded;
                        if (addAndGet > RetriableStream.this.channelBufferLimit) {
                            this.substream.bufferLimitExceeded = true;
                        }
                    }
                    if (this.substream.bufferLimitExceeded) {
                        runnable = RetriableStream.this.commit(this.substream);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/RetriableStream$ChannelBufferMeter.class */
    public static final class ChannelBufferMeter {
        private final AtomicLong bufferUsed = new AtomicLong();

        long addAndGet(long j) {
            return this.bufferUsed.addAndGet(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/RetriableStream$FutureCanceller.class */
    public static final class FutureCanceller {
        boolean cancelled;
        Future<?> future;
        final Object lock;

        FutureCanceller(Object obj) {
            this.lock = obj;
        }

        boolean isCancelled() {
            return this.cancelled;
        }

        @CheckForNull
        Future<?> markCancelled() {
            this.cancelled = true;
            return this.future;
        }

        void setFuture(Future<?> future) {
            synchronized (this.lock) {
                if (!this.cancelled) {
                    this.future = future;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/RetriableStream$HedgingPlan.class */
    public static final class HedgingPlan {
        @Nullable
        final Integer hedgingPushbackMillis;
        final boolean isHedgeable;

        public HedgingPlan(boolean z, @Nullable Integer num) {
            this.isHedgeable = z;
            this.hedgingPushbackMillis = num;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/RetriableStream$HedgingRunnable.class */
    public final class HedgingRunnable implements Runnable {
        final FutureCanceller scheduledHedgingRef;

        HedgingRunnable(FutureCanceller futureCanceller) {
            this.scheduledHedgingRef = futureCanceller;
        }

        @Override // java.lang.Runnable
        public void run() {
            RetriableStream.this.callExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.HedgingRunnable.1
                @Override // java.lang.Runnable
                public void run() {
                    FutureCanceller futureCanceller;
                    boolean z;
                    Substream createSubstream = RetriableStream.this.createSubstream(RetriableStream.this.state.hedgingAttemptCount);
                    synchronized (RetriableStream.this.lock) {
                        futureCanceller = null;
                        z = false;
                        if (HedgingRunnable.this.scheduledHedgingRef.isCancelled()) {
                            z = true;
                        } else {
                            RetriableStream.this.state = RetriableStream.this.state.addActiveHedge(createSubstream);
                            if (RetriableStream.this.hasPotentialHedging(RetriableStream.this.state) && (RetriableStream.this.throttle == null || RetriableStream.this.throttle.isAboveThreshold())) {
                                RetriableStream retriableStream = RetriableStream.this;
                                futureCanceller = new FutureCanceller(RetriableStream.this.lock);
                                retriableStream.scheduledHedging = futureCanceller;
                            } else {
                                RetriableStream.this.state = RetriableStream.this.state.freezeHedging();
                                RetriableStream.this.scheduledHedging = null;
                            }
                        }
                    }
                    if (z) {
                        createSubstream.stream.cancel(Status.CANCELLED.withDescription("Unneeded hedging"));
                        return;
                    }
                    if (futureCanceller != null) {
                        futureCanceller.setFuture(RetriableStream.this.scheduledExecutorService.schedule(new HedgingRunnable(futureCanceller), RetriableStream.this.hedgingPolicy.hedgingDelayNanos, TimeUnit.NANOSECONDS));
                    }
                    RetriableStream.this.drain(createSubstream);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/RetriableStream$RetryPlan.class */
    public static final class RetryPlan {
        final long backoffNanos;
        final boolean shouldRetry;

        RetryPlan(boolean z, long j) {
            this.shouldRetry = z;
            this.backoffNanos = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/RetriableStream$State.class */
    public static final class State {
        final Collection<Substream> activeHedges;
        @Nullable
        final List<BufferEntry> buffer;
        final boolean cancelled;
        final Collection<Substream> drainedSubstreams;
        final int hedgingAttemptCount;
        final boolean hedgingFrozen;
        final boolean passThrough;
        @Nullable
        final Substream winningSubstream;

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00be, code lost:
            if (r8 != null) goto L29;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        State(@javax.annotation.Nullable java.util.List<io.grpc.internal.RetriableStream.BufferEntry> r5, java.util.Collection<io.grpc.internal.RetriableStream.Substream> r6, java.util.Collection<io.grpc.internal.RetriableStream.Substream> r7, @javax.annotation.Nullable io.grpc.internal.RetriableStream.Substream r8, boolean r9, boolean r10, boolean r11, int r12) {
            /*
                r4 = this;
                r0 = r4
                r0.<init>()
                r0 = r4
                r1 = r5
                r0.buffer = r1
                r0 = r4
                r1 = r6
                java.lang.String r2 = "drainedSubstreams"
                java.lang.Object r1 = com.google.common.base.Preconditions.checkNotNull(r1, r2)
                java.util.Collection r1 = (java.util.Collection) r1
                r0.drainedSubstreams = r1
                r0 = r4
                r1 = r8
                r0.winningSubstream = r1
                r0 = r4
                r1 = r7
                r0.activeHedges = r1
                r0 = r4
                r1 = r9
                r0.cancelled = r1
                r0 = r4
                r1 = r10
                r0.passThrough = r1
                r0 = r4
                r1 = r11
                r0.hedgingFrozen = r1
                r0 = r4
                r1 = r12
                r0.hedgingAttemptCount = r1
                r0 = 0
                r13 = r0
                r0 = r10
                if (r0 == 0) goto L4e
                r0 = r5
                if (r0 != 0) goto L48
                goto L4e
            L48:
                r0 = 0
                r11 = r0
                goto L51
            L4e:
                r0 = 1
                r11 = r0
            L51:
                r0 = r11
                java.lang.String r1 = "passThrough should imply buffer is null"
                com.google.common.base.Preconditions.checkState(r0, r1)
                r0 = r10
                if (r0 == 0) goto L6b
                r0 = r8
                if (r0 == 0) goto L65
                goto L6b
            L65:
                r0 = 0
                r11 = r0
                goto L6e
            L6b:
                r0 = 1
                r11 = r0
            L6e:
                r0 = r11
                java.lang.String r1 = "passThrough should imply winningSubstream != null"
                com.google.common.base.Preconditions.checkState(r0, r1)
                r0 = r10
                if (r0 == 0) goto La9
                r0 = r6
                int r0 = r0.size()
                r1 = 1
                if (r0 != r1) goto L8f
                r0 = r6
                r1 = r8
                boolean r0 = r0.contains(r1)
                if (r0 != 0) goto La9
            L8f:
                r0 = r6
                int r0 = r0.size()
                if (r0 != 0) goto La3
                r0 = r8
                boolean r0 = r0.closed
                if (r0 == 0) goto La3
                goto La9
            La3:
                r0 = 0
                r10 = r0
                goto Lac
            La9:
                r0 = 1
                r10 = r0
            Lac:
                r0 = r10
                java.lang.String r1 = "passThrough should imply winningSubstream is drained"
                com.google.common.base.Preconditions.checkState(r0, r1)
                r0 = r9
                if (r0 == 0) goto Lc1
                r0 = r13
                r9 = r0
                r0 = r8
                if (r0 == 0) goto Lc4
            Lc1:
                r0 = 1
                r9 = r0
            Lc4:
                r0 = r9
                java.lang.String r1 = "cancelled should imply committed"
                com.google.common.base.Preconditions.checkState(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.RetriableStream.State.<init>(java.util.List, java.util.Collection, java.util.Collection, io.grpc.internal.RetriableStream$Substream, boolean, boolean, boolean, int):void");
        }

        @CheckReturnValue
        State addActiveHedge(Substream substream) {
            Set unmodifiableCollection;
            Preconditions.checkState(!this.hedgingFrozen, "hedging frozen");
            Preconditions.checkState(this.winningSubstream == null, "already committed");
            if (this.activeHedges == null) {
                unmodifiableCollection = Collections.singleton(substream);
            } else {
                ArrayList arrayList = new ArrayList(this.activeHedges);
                arrayList.add(substream);
                unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            return new State(this.buffer, this.drainedSubstreams, unmodifiableCollection, this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount + 1);
        }

        @CheckReturnValue
        State cancelled() {
            return new State(this.buffer, this.drainedSubstreams, this.activeHedges, this.winningSubstream, true, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        @CheckReturnValue
        State committed(Substream substream) {
            Collection emptyList;
            boolean z;
            List<BufferEntry> list;
            Preconditions.checkState(this.winningSubstream == null, "Already committed");
            List<BufferEntry> list2 = this.buffer;
            if (this.drainedSubstreams.contains(substream)) {
                list = null;
                z = true;
                emptyList = Collections.singleton(substream);
            } else {
                emptyList = Collections.emptyList();
                z = false;
                list = list2;
            }
            return new State(list, emptyList, this.activeHedges, substream, this.cancelled, z, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        @CheckReturnValue
        State freezeHedging() {
            return this.hedgingFrozen ? this : new State(this.buffer, this.drainedSubstreams, this.activeHedges, this.winningSubstream, this.cancelled, this.passThrough, true, this.hedgingAttemptCount);
        }

        @CheckReturnValue
        State removeActiveHedge(Substream substream) {
            ArrayList arrayList = new ArrayList(this.activeHedges);
            arrayList.remove(substream);
            return new State(this.buffer, this.drainedSubstreams, Collections.unmodifiableCollection(arrayList), this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        @CheckReturnValue
        State replaceActiveHedge(Substream substream, Substream substream2) {
            ArrayList arrayList = new ArrayList(this.activeHedges);
            arrayList.remove(substream);
            arrayList.add(substream2);
            return new State(this.buffer, this.drainedSubstreams, Collections.unmodifiableCollection(arrayList), this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        @CheckReturnValue
        State substreamClosed(Substream substream) {
            substream.closed = true;
            if (this.drainedSubstreams.contains(substream)) {
                ArrayList arrayList = new ArrayList(this.drainedSubstreams);
                arrayList.remove(substream);
                return new State(this.buffer, Collections.unmodifiableCollection(arrayList), this.activeHedges, this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
            }
            return this;
        }

        @CheckReturnValue
        State substreamDrained(Substream substream) {
            Collection<Substream> unmodifiableCollection;
            List<BufferEntry> list;
            boolean z = true;
            Preconditions.checkState(!this.passThrough, "Already passThrough");
            if (substream.closed) {
                unmodifiableCollection = this.drainedSubstreams;
            } else if (this.drainedSubstreams.isEmpty()) {
                unmodifiableCollection = Collections.singletonList(substream);
            } else {
                ArrayList arrayList = new ArrayList(this.drainedSubstreams);
                arrayList.add(substream);
                unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            boolean z2 = this.winningSubstream != null;
            List<BufferEntry> list2 = this.buffer;
            if (z2) {
                if (this.winningSubstream != substream) {
                    z = false;
                }
                Preconditions.checkState(z, "Another RPC attempt has already committed");
                list = null;
            } else {
                list = list2;
            }
            return new State(list, unmodifiableCollection, this.activeHedges, this.winningSubstream, this.cancelled, z2, this.hedgingFrozen, this.hedgingAttemptCount);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/RetriableStream$Sublistener.class */
    final class Sublistener implements ClientStreamListener {
        final Substream substream;

        Sublistener(Substream substream) {
            this.substream = substream;
        }

        @Nullable
        private Integer getPushbackMills(Metadata metadata) {
            String str = (String) metadata.get(RetriableStream.GRPC_RETRY_PUSHBACK_MS);
            if (str != null) {
                try {
                    return Integer.valueOf(str);
                } catch (NumberFormatException e) {
                    return -1;
                }
            }
            return null;
        }

        private HedgingPlan makeHedgingDecision(Status status, Metadata metadata) {
            Integer pushbackMills = getPushbackMills(metadata);
            boolean z = true;
            boolean z2 = !RetriableStream.this.hedgingPolicy.nonFatalStatusCodes.contains(status.getCode());
            boolean z3 = (RetriableStream.this.throttle == null || (z2 && (pushbackMills == null || pushbackMills.intValue() >= 0))) ? false : !RetriableStream.this.throttle.onQualifiedFailureThenCheckIsAboveThreshold();
            if (z2 || z3) {
                z = false;
            }
            return new HedgingPlan(z, pushbackMills);
        }

        private RetryPlan makeRetryDecision(Status status, Metadata metadata) {
            long j;
            RetriableStream retriableStream;
            boolean contains = RetriableStream.this.retryPolicy.retryableStatusCodes.contains(status.getCode());
            Integer pushbackMills = getPushbackMills(metadata);
            boolean z = false;
            boolean z2 = (RetriableStream.this.throttle == null || (!contains && (pushbackMills == null || pushbackMills.intValue() >= 0))) ? false : !RetriableStream.this.throttle.onQualifiedFailureThenCheckIsAboveThreshold();
            if (RetriableStream.this.retryPolicy.maxAttempts > this.substream.previousAttemptCount + 1 && !z2) {
                if (pushbackMills == null) {
                    if (contains) {
                        j = (long) (RetriableStream.this.nextBackoffIntervalNanos * RetriableStream.random.nextDouble());
                        RetriableStream.this.nextBackoffIntervalNanos = Math.min((long) (retriableStream.nextBackoffIntervalNanos * RetriableStream.this.retryPolicy.backoffMultiplier), RetriableStream.this.retryPolicy.maxBackoffNanos);
                        z = true;
                    }
                } else if (pushbackMills.intValue() >= 0) {
                    j = TimeUnit.MILLISECONDS.toNanos(pushbackMills.intValue());
                    RetriableStream retriableStream2 = RetriableStream.this;
                    retriableStream2.nextBackoffIntervalNanos = retriableStream2.retryPolicy.initialBackoffNanos;
                    z = true;
                }
                return new RetryPlan(z, j);
            }
            j = 0;
            return new RetryPlan(z, j);
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(Status status, Metadata metadata) {
            closed(status, ClientStreamListener.RpcProgress.PROCESSED, metadata);
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata metadata) {
            FutureCanceller futureCanceller;
            synchronized (RetriableStream.this.lock) {
                RetriableStream.this.state = RetriableStream.this.state.substreamClosed(this.substream);
                RetriableStream.this.closedSubstreamsInsight.append(status.getCode());
            }
            if (this.substream.bufferLimitExceeded) {
                RetriableStream.this.commitAndRun(this.substream);
                if (RetriableStream.this.state.winningSubstream == this.substream) {
                    RetriableStream.this.masterListener.closed(status, metadata);
                    return;
                }
                return;
            }
            if (RetriableStream.this.state.winningSubstream == null) {
                boolean z = true;
                if (rpcProgress == ClientStreamListener.RpcProgress.REFUSED && RetriableStream.this.noMoreTransparentRetry.compareAndSet(false, true)) {
                    final Substream createSubstream = RetriableStream.this.createSubstream(this.substream.previousAttemptCount);
                    if (RetriableStream.this.isHedging) {
                        synchronized (RetriableStream.this.lock) {
                            RetriableStream.this.state = RetriableStream.this.state.replaceActiveHedge(this.substream, createSubstream);
                            if (RetriableStream.this.hasPotentialHedging(RetriableStream.this.state) || RetriableStream.this.state.activeHedges.size() != 1) {
                                z = false;
                            }
                        }
                        if (z) {
                            RetriableStream.this.commitAndRun(createSubstream);
                        }
                    } else {
                        if (RetriableStream.this.retryPolicy == null) {
                            RetriableStream retriableStream = RetriableStream.this;
                            retriableStream.retryPolicy = retriableStream.retryPolicyProvider.get();
                        }
                        if (RetriableStream.this.retryPolicy.maxAttempts == 1) {
                            RetriableStream.this.commitAndRun(createSubstream);
                        }
                    }
                    RetriableStream.this.callExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RetriableStream.this.drain(createSubstream);
                        }
                    });
                    return;
                } else if (rpcProgress != ClientStreamListener.RpcProgress.DROPPED) {
                    RetriableStream.this.noMoreTransparentRetry.set(true);
                    if (RetriableStream.this.retryPolicy == null) {
                        RetriableStream retriableStream2 = RetriableStream.this;
                        retriableStream2.retryPolicy = retriableStream2.retryPolicyProvider.get();
                        RetriableStream retriableStream3 = RetriableStream.this;
                        retriableStream3.nextBackoffIntervalNanos = retriableStream3.retryPolicy.initialBackoffNanos;
                    }
                    if (RetriableStream.this.isHedging) {
                        HedgingPlan makeHedgingDecision = makeHedgingDecision(status, metadata);
                        if (makeHedgingDecision.isHedgeable) {
                            RetriableStream.this.pushbackHedging(makeHedgingDecision.hedgingPushbackMillis);
                        }
                        synchronized (RetriableStream.this.lock) {
                            RetriableStream.this.state = RetriableStream.this.state.removeActiveHedge(this.substream);
                            if (makeHedgingDecision.isHedgeable && (RetriableStream.this.hasPotentialHedging(RetriableStream.this.state) || !RetriableStream.this.state.activeHedges.isEmpty())) {
                                return;
                            }
                        }
                    } else {
                        RetryPlan makeRetryDecision = makeRetryDecision(status, metadata);
                        if (makeRetryDecision.shouldRetry) {
                            synchronized (RetriableStream.this.lock) {
                                RetriableStream retriableStream4 = RetriableStream.this;
                                futureCanceller = new FutureCanceller(RetriableStream.this.lock);
                                retriableStream4.scheduledRetry = futureCanceller;
                            }
                            futureCanceller.setFuture(RetriableStream.this.scheduledExecutorService.schedule(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    RetriableStream.this.callExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.2.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            RetriableStream.this.drain(RetriableStream.this.createSubstream(Sublistener.this.substream.previousAttemptCount + 1));
                                        }
                                    });
                                }
                            }, makeRetryDecision.backoffNanos, TimeUnit.NANOSECONDS));
                            return;
                        }
                    }
                } else if (RetriableStream.this.isHedging) {
                    RetriableStream.this.freezeHedging();
                }
            }
            RetriableStream.this.commitAndRun(this.substream);
            if (RetriableStream.this.state.winningSubstream == this.substream) {
                RetriableStream.this.masterListener.closed(status, metadata);
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void headersRead(Metadata metadata) {
            RetriableStream.this.commitAndRun(this.substream);
            if (RetriableStream.this.state.winningSubstream == this.substream) {
                RetriableStream.this.masterListener.headersRead(metadata);
                if (RetriableStream.this.throttle != null) {
                    RetriableStream.this.throttle.onSuccess();
                }
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
            State state = RetriableStream.this.state;
            Preconditions.checkState(state.winningSubstream != null, "Headers should be received prior to messages.");
            if (state.winningSubstream != this.substream) {
                return;
            }
            RetriableStream.this.masterListener.messagesAvailable(messageProducer);
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            RetriableStream.this.masterListener.onReady();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/RetriableStream$Substream.class */
    public static final class Substream {
        boolean bufferLimitExceeded;
        boolean closed;
        final int previousAttemptCount;
        ClientStream stream;

        Substream(int i) {
            this.previousAttemptCount = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/RetriableStream$Throttle.class */
    public static final class Throttle {
        private static final int THREE_DECIMAL_PLACES_SCALE_UP = 1000;
        final int maxTokens;
        final int threshold;
        final AtomicInteger tokenCount;
        final int tokenRatio;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Throttle(float f, float f2) {
            AtomicInteger atomicInteger = new AtomicInteger();
            this.tokenCount = atomicInteger;
            this.tokenRatio = (int) (f2 * 1000.0f);
            int i = (int) (f * 1000.0f);
            this.maxTokens = i;
            this.threshold = i / 2;
            atomicInteger.set(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Throttle) {
                Throttle throttle = (Throttle) obj;
                return this.maxTokens == throttle.maxTokens && this.tokenRatio == throttle.tokenRatio;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(Integer.valueOf(this.maxTokens), Integer.valueOf(this.tokenRatio));
        }

        boolean isAboveThreshold() {
            return this.tokenCount.get() > this.threshold;
        }

        boolean onQualifiedFailureThenCheckIsAboveThreshold() {
            int i;
            boolean z;
            int i2;
            do {
                i = this.tokenCount.get();
                z = false;
                if (i == 0) {
                    return false;
                }
                i2 = i - 1000;
            } while (!this.tokenCount.compareAndSet(i, Math.max(i2, 0)));
            if (i2 > this.threshold) {
                z = true;
            }
            return z;
        }

        void onSuccess() {
            int i;
            int i2;
            do {
                i = this.tokenCount.get();
                i2 = this.maxTokens;
                if (i == i2) {
                    return;
                }
            } while (!this.tokenCount.compareAndSet(i, Math.min(this.tokenRatio + i, i2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RetriableStream(MethodDescriptor<ReqT, ?> methodDescriptor, Metadata metadata, ChannelBufferMeter channelBufferMeter, long j, long j2, Executor executor, ScheduledExecutorService scheduledExecutorService, RetryPolicy.Provider provider, HedgingPolicy.Provider provider2, @Nullable Throttle throttle) {
        this.method = methodDescriptor;
        this.channelBufferUsed = channelBufferMeter;
        this.perRpcBufferLimit = j;
        this.channelBufferLimit = j2;
        this.callExecutor = executor;
        this.scheduledExecutorService = scheduledExecutorService;
        this.headers = metadata;
        this.retryPolicyProvider = (RetryPolicy.Provider) Preconditions.checkNotNull(provider, "retryPolicyProvider");
        this.hedgingPolicyProvider = (HedgingPolicy.Provider) Preconditions.checkNotNull(provider2, "hedgingPolicyProvider");
        this.throttle = throttle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckReturnValue
    @Nullable
    public Runnable commit(final Substream substream) {
        Future<?> future;
        Future<?> future2;
        synchronized (this.lock) {
            if (this.state.winningSubstream != null) {
                return null;
            }
            final Collection<Substream> collection = this.state.drainedSubstreams;
            this.state = this.state.committed(substream);
            this.channelBufferUsed.addAndGet(-this.perRpcBufferUsed);
            if (this.scheduledRetry != null) {
                future = this.scheduledRetry.markCancelled();
                this.scheduledRetry = null;
            } else {
                future = null;
            }
            if (this.scheduledHedging != null) {
                future2 = this.scheduledHedging.markCancelled();
                this.scheduledHedging = null;
            } else {
                future2 = null;
            }
            final Future<?> future3 = future;
            final Future<?> future4 = future2;
            return new Runnable() { // from class: io.grpc.internal.RetriableStream.1CommitTask
                @Override // java.lang.Runnable
                public void run() {
                    for (Substream substream2 : collection) {
                        if (substream2 != substream) {
                            substream2.stream.cancel(RetriableStream.CANCELLED_BECAUSE_COMMITTED);
                        }
                    }
                    Future future5 = future3;
                    if (future5 != null) {
                        future5.cancel(false);
                    }
                    Future future6 = future4;
                    if (future6 != null) {
                        future6.cancel(false);
                    }
                    RetriableStream.this.postCommit();
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void commitAndRun(Substream substream) {
        Runnable commit = commit(substream);
        if (commit != null) {
            commit.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Substream createSubstream(int i) {
        Substream substream = new Substream(i);
        final BufferSizeTracer bufferSizeTracer = new BufferSizeTracer(substream);
        substream.stream = newSubstream(new ClientStreamTracer.Factory() { // from class: io.grpc.internal.RetriableStream.1
            @Override // io.grpc.ClientStreamTracer.Factory
            public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo streamInfo, Metadata metadata) {
                return bufferSizeTracer;
            }
        }, updateHeaders(this.headers, i));
        return substream;
    }

    private void delayOrExecute(BufferEntry bufferEntry) {
        Collection<Substream> collection;
        synchronized (this.lock) {
            if (!this.state.passThrough) {
                this.state.buffer.add(bufferEntry);
            }
            collection = this.state.drainedSubstreams;
        }
        for (Substream substream : collection) {
            bufferEntry.runWith(substream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drain(Substream substream) {
        ArrayList<BufferEntry> arrayList = null;
        int i = 0;
        while (true) {
            int i2 = i;
            synchronized (this.lock) {
                State state = this.state;
                if (state.winningSubstream != null && state.winningSubstream != substream) {
                    substream.stream.cancel(CANCELLED_BECAUSE_COMMITTED);
                    return;
                } else if (i2 == state.buffer.size()) {
                    this.state = state.substreamDrained(substream);
                    return;
                } else if (substream.closed) {
                    return;
                } else {
                    int min = Math.min(i2 + 128, state.buffer.size());
                    if (arrayList == null) {
                        arrayList = new ArrayList(state.buffer.subList(i2, min));
                    } else {
                        arrayList.clear();
                        arrayList.addAll(state.buffer.subList(i2, min));
                    }
                    for (BufferEntry bufferEntry : arrayList) {
                        State state2 = this.state;
                        if (state2.winningSubstream == null || state2.winningSubstream == substream) {
                            if (state2.cancelled) {
                                Preconditions.checkState(state2.winningSubstream == substream, "substream should be CANCELLED_BECAUSE_COMMITTED already");
                                return;
                            }
                            bufferEntry.runWith(substream);
                        }
                    }
                    i = min;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void freezeHedging() {
        Future<?> future;
        synchronized (this.lock) {
            future = null;
            if (this.scheduledHedging != null) {
                future = this.scheduledHedging.markCancelled();
                this.scheduledHedging = null;
            }
            this.state = this.state.freezeHedging();
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasPotentialHedging(State state) {
        return state.winningSubstream == null && state.hedgingAttemptCount < this.hedgingPolicy.maxAttempts && !state.hedgingFrozen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushbackHedging(@Nullable Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            freezeHedging();
            return;
        }
        synchronized (this.lock) {
            if (this.scheduledHedging == null) {
                return;
            }
            Future<?> markCancelled = this.scheduledHedging.markCancelled();
            FutureCanceller futureCanceller = new FutureCanceller(this.lock);
            this.scheduledHedging = futureCanceller;
            if (markCancelled != null) {
                markCancelled.cancel(false);
            }
            futureCanceller.setFuture(this.scheduledExecutorService.schedule(new HedgingRunnable(futureCanceller), num.intValue(), TimeUnit.MILLISECONDS));
        }
    }

    static void setRandom(Random random2) {
        random = random2;
    }

    @Override // io.grpc.internal.ClientStream
    public void appendTimeoutInsight(InsightBuilder insightBuilder) {
        State state;
        synchronized (this.lock) {
            insightBuilder.appendKeyValue("closed", this.closedSubstreamsInsight);
            state = this.state;
        }
        if (state.winningSubstream != null) {
            InsightBuilder insightBuilder2 = new InsightBuilder();
            state.winningSubstream.stream.appendTimeoutInsight(insightBuilder2);
            insightBuilder.appendKeyValue("committed", insightBuilder2);
            return;
        }
        InsightBuilder insightBuilder3 = new InsightBuilder();
        for (Substream substream : state.drainedSubstreams) {
            InsightBuilder insightBuilder4 = new InsightBuilder();
            substream.stream.appendTimeoutInsight(insightBuilder4);
            insightBuilder3.append(insightBuilder4);
        }
        insightBuilder.appendKeyValue("open", insightBuilder3);
    }

    @Override // io.grpc.internal.ClientStream
    public final void cancel(Status status) {
        Substream substream = new Substream(0);
        substream.stream = new NoopClientStream();
        Runnable commit = commit(substream);
        if (commit != null) {
            this.masterListener.closed(status, new Metadata());
            commit.run();
            return;
        }
        this.state.winningSubstream.stream.cancel(status);
        synchronized (this.lock) {
            this.state = this.state.cancelled();
        }
    }

    @Override // io.grpc.internal.Stream
    public final void flush() {
        State state = this.state;
        if (state.passThrough) {
            state.winningSubstream.stream.flush();
        } else {
            delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1FlushEntry
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.stream.flush();
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public final Attributes getAttributes() {
        return this.state.winningSubstream != null ? this.state.winningSubstream.stream.getAttributes() : Attributes.EMPTY;
    }

    @Override // io.grpc.internal.ClientStream
    public final void halfClose() {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1HalfCloseEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.halfClose();
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public final boolean isReady() {
        for (Substream substream : this.state.drainedSubstreams) {
            if (substream.stream.isReady()) {
                return true;
            }
        }
        return false;
    }

    abstract ClientStream newSubstream(ClientStreamTracer.Factory factory, Metadata metadata);

    @Override // io.grpc.internal.Stream
    public void optimizeForDirectExecutor() {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1OptimizeDirectEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.optimizeForDirectExecutor();
            }
        });
    }

    abstract void postCommit();

    @CheckReturnValue
    @Nullable
    abstract Status prestart();

    @Override // io.grpc.internal.Stream
    public final void request(final int i) {
        State state = this.state;
        if (state.passThrough) {
            state.winningSubstream.stream.request(i);
        } else {
            delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1RequestEntry
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.stream.request(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void sendMessage(final ReqT reqt) {
        State state = this.state;
        if (state.passThrough) {
            state.winningSubstream.stream.writeMessage(this.method.streamRequest(reqt));
        } else {
            delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1SendMessageEntry
                /* JADX WARN: Multi-variable type inference failed */
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.stream.writeMessage(RetriableStream.this.method.streamRequest(reqt));
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public final void setAuthority(final String str) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1AuthorityEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setAuthority(str);
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public final void setCompressor(final Compressor compressor) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1CompressorEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setCompressor(compressor);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setDeadline(final Deadline deadline) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1DeadlineEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setDeadline(deadline);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setDecompressorRegistry(final DecompressorRegistry decompressorRegistry) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1DecompressorRegistryEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setDecompressorRegistry(decompressorRegistry);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setFullStreamDecompression(final boolean z) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1FullStreamDecompressionEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setFullStreamDecompression(z);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setMaxInboundMessageSize(final int i) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1MaxInboundMessageSizeEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setMaxInboundMessageSize(i);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setMaxOutboundMessageSize(final int i) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1MaxOutboundMessageSizeEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setMaxOutboundMessageSize(i);
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public final void setMessageCompression(final boolean z) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1MessageCompressionEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setMessageCompression(z);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a6, code lost:
        if (r7.throttle.isAboveThreshold() != false) goto L30;
     */
    @Override // io.grpc.internal.ClientStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void start(io.grpc.internal.ClientStreamListener r8) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.RetriableStream.start(io.grpc.internal.ClientStreamListener):void");
    }

    final Metadata updateHeaders(Metadata metadata, int i) {
        Metadata metadata2 = new Metadata();
        metadata2.merge(metadata);
        if (i > 0) {
            metadata2.put(GRPC_PREVIOUS_RPC_ATTEMPTS, String.valueOf(i));
        }
        return metadata2;
    }

    @Override // io.grpc.internal.Stream
    public final void writeMessage(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }
}
