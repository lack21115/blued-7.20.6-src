package io.grpc.internal;

import android.provider.Downloads;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.InternalConfigSelector;
import io.grpc.InternalDecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;
import io.perfmark.Link;
import io.perfmark.PerfMark;
import io.perfmark.Tag;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ClientCallImpl.class */
public final class ClientCallImpl<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    private final Executor callExecutor;
    private final boolean callExecutorIsDirect;
    private final CallOptions callOptions;
    private boolean cancelCalled;
    private volatile boolean cancelListenersShouldBeRemoved;
    private ClientCallImpl<ReqT, RespT>.ContextCancellationListener cancellationListener;
    private final CallTracer channelCallsTracer;
    private final ClientStreamProvider clientStreamProvider;
    private final Context context;
    private final ScheduledExecutorService deadlineCancellationExecutor;
    private volatile ScheduledFuture<?> deadlineCancellationNotifyApplicationFuture;
    private volatile ScheduledFuture<?> deadlineCancellationSendToServerFuture;
    private boolean fullStreamDecompression;
    private boolean halfCloseCalled;
    private final MethodDescriptor<ReqT, RespT> method;
    private ClientStream stream;
    private final Tag tag;
    private final boolean unaryRequest;
    private static final Logger log = Logger.getLogger(ClientCallImpl.class.getName());
    private static final byte[] FULL_STREAM_DECOMPRESSION_ENCODINGS = "gzip".getBytes(Charset.forName("US-ASCII"));
    static final long DEADLINE_EXPIRATION_CANCEL_DELAY_NANOS = TimeUnit.SECONDS.toNanos(1);
    private DecompressorRegistry decompressorRegistry = DecompressorRegistry.getDefaultInstance();
    private CompressorRegistry compressorRegistry = CompressorRegistry.getDefaultInstance();
    private boolean observerClosed = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ClientCallImpl$ClientStreamListenerImpl.class */
    public class ClientStreamListenerImpl implements ClientStreamListener {
        private Status exceptionStatus;
        private final ClientCall.Listener<RespT> observer;

        public ClientStreamListenerImpl(ClientCall.Listener<RespT> listener) {
            this.observer = (ClientCall.Listener) Preconditions.checkNotNull(listener, "observer");
        }

        private void closedInternal(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata metadata) {
            Deadline effectiveDeadline = ClientCallImpl.this.effectiveDeadline();
            Status status2 = status;
            Metadata metadata2 = metadata;
            if (status.getCode() == Status.Code.CANCELLED) {
                status2 = status;
                metadata2 = metadata;
                if (effectiveDeadline != null) {
                    status2 = status;
                    metadata2 = metadata;
                    if (effectiveDeadline.isExpired()) {
                        InsightBuilder insightBuilder = new InsightBuilder();
                        ClientCallImpl.this.stream.appendTimeoutInsight(insightBuilder);
                        Status status3 = Status.DEADLINE_EXCEEDED;
                        status2 = status3.augmentDescription("ClientCall was cancelled at or after deadline. " + insightBuilder);
                        metadata2 = new Metadata();
                    }
                }
            }
            final Link linkOut = PerfMark.linkOut();
            final Status status4 = status2;
            final Metadata metadata3 = metadata2;
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.ClientStreamListenerImpl.1StreamClosed
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(ClientCallImpl.this.context);
                }

                private void runInternal() {
                    Status status5 = status4;
                    Metadata metadata4 = metadata3;
                    if (ClientStreamListenerImpl.this.exceptionStatus != null) {
                        status5 = ClientStreamListenerImpl.this.exceptionStatus;
                        metadata4 = new Metadata();
                    }
                    ClientCallImpl.this.cancelListenersShouldBeRemoved = true;
                    try {
                        ClientCallImpl.this.closeObserver(ClientStreamListenerImpl.this.observer, status5, metadata4);
                    } finally {
                        ClientCallImpl.this.removeContextListenerAndCancelDeadlineFuture();
                        ClientCallImpl.this.channelCallsTracer.reportCallEnded(status5.isOk());
                    }
                }

                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    PerfMark.startTask("ClientCall$Listener.onClose", ClientCallImpl.this.tag);
                    PerfMark.linkIn(linkOut);
                    try {
                        runInternal();
                        PerfMark.stopTask("ClientCall$Listener.onClose", ClientCallImpl.this.tag);
                    } catch (Throwable th) {
                        PerfMark.stopTask("ClientCall$Listener.onClose", ClientCallImpl.this.tag);
                        throw th;
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void exceptionThrown(Status status) {
            this.exceptionStatus = status;
            ClientCallImpl.this.stream.cancel(status);
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(Status status, Metadata metadata) {
            closed(status, ClientStreamListener.RpcProgress.PROCESSED, metadata);
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata metadata) {
            PerfMark.startTask("ClientStreamListener.closed", ClientCallImpl.this.tag);
            try {
                closedInternal(status, rpcProgress, metadata);
                PerfMark.stopTask("ClientStreamListener.closed", ClientCallImpl.this.tag);
            } catch (Throwable th) {
                PerfMark.stopTask("ClientStreamListener.closed", ClientCallImpl.this.tag);
                throw th;
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void headersRead(final Metadata metadata) {
            PerfMark.startTask("ClientStreamListener.headersRead", ClientCallImpl.this.tag);
            final Link linkOut = PerfMark.linkOut();
            try {
                ClientCallImpl.this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.ClientStreamListenerImpl.1HeadersRead
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(ClientCallImpl.this.context);
                    }

                    private void runInternal() {
                        if (ClientStreamListenerImpl.this.exceptionStatus != null) {
                            return;
                        }
                        try {
                            ClientStreamListenerImpl.this.observer.onHeaders(metadata);
                        } catch (Throwable th) {
                            ClientStreamListenerImpl.this.exceptionThrown(Status.CANCELLED.withCause(th).withDescription("Failed to read headers"));
                        }
                    }

                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        PerfMark.startTask("ClientCall$Listener.headersRead", ClientCallImpl.this.tag);
                        PerfMark.linkIn(linkOut);
                        try {
                            runInternal();
                            PerfMark.stopTask("ClientCall$Listener.headersRead", ClientCallImpl.this.tag);
                        } catch (Throwable th) {
                            PerfMark.stopTask("ClientCall$Listener.headersRead", ClientCallImpl.this.tag);
                            throw th;
                        }
                    }
                });
                PerfMark.stopTask("ClientStreamListener.headersRead", ClientCallImpl.this.tag);
            } catch (Throwable th) {
                PerfMark.stopTask("ClientStreamListener.headersRead", ClientCallImpl.this.tag);
                throw th;
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(final StreamListener.MessageProducer messageProducer) {
            PerfMark.startTask("ClientStreamListener.messagesAvailable", ClientCallImpl.this.tag);
            final Link linkOut = PerfMark.linkOut();
            try {
                ClientCallImpl.this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.ClientStreamListenerImpl.1MessagesAvailable
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(ClientCallImpl.this.context);
                    }

                    private void runInternal() {
                        if (ClientStreamListenerImpl.this.exceptionStatus != null) {
                            GrpcUtil.closeQuietly(messageProducer);
                            return;
                        }
                        while (true) {
                            try {
                                InputStream next = messageProducer.next();
                                if (next == null) {
                                    return;
                                }
                                ClientStreamListenerImpl.this.observer.onMessage(ClientCallImpl.this.method.parseResponse(next));
                                next.close();
                            } catch (Throwable th) {
                                GrpcUtil.closeQuietly(messageProducer);
                                ClientStreamListenerImpl.this.exceptionThrown(Status.CANCELLED.withCause(th).withDescription("Failed to read message."));
                                return;
                            }
                        }
                    }

                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        PerfMark.startTask("ClientCall$Listener.messagesAvailable", ClientCallImpl.this.tag);
                        PerfMark.linkIn(linkOut);
                        try {
                            runInternal();
                            PerfMark.stopTask("ClientCall$Listener.messagesAvailable", ClientCallImpl.this.tag);
                        } catch (Throwable th) {
                            PerfMark.stopTask("ClientCall$Listener.messagesAvailable", ClientCallImpl.this.tag);
                            throw th;
                        }
                    }
                });
                PerfMark.stopTask("ClientStreamListener.messagesAvailable", ClientCallImpl.this.tag);
            } catch (Throwable th) {
                PerfMark.stopTask("ClientStreamListener.messagesAvailable", ClientCallImpl.this.tag);
                throw th;
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            if (ClientCallImpl.this.method.getType().clientSendsOneMessage()) {
                return;
            }
            PerfMark.startTask("ClientStreamListener.onReady", ClientCallImpl.this.tag);
            final Link linkOut = PerfMark.linkOut();
            try {
                ClientCallImpl.this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.ClientStreamListenerImpl.1StreamOnReady
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(ClientCallImpl.this.context);
                    }

                    private void runInternal() {
                        if (ClientStreamListenerImpl.this.exceptionStatus != null) {
                            return;
                        }
                        try {
                            ClientStreamListenerImpl.this.observer.onReady();
                        } catch (Throwable th) {
                            ClientStreamListenerImpl.this.exceptionThrown(Status.CANCELLED.withCause(th).withDescription("Failed to call onReady."));
                        }
                    }

                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        PerfMark.startTask("ClientCall$Listener.onReady", ClientCallImpl.this.tag);
                        PerfMark.linkIn(linkOut);
                        try {
                            runInternal();
                            PerfMark.stopTask("ClientCall$Listener.onReady", ClientCallImpl.this.tag);
                        } catch (Throwable th) {
                            PerfMark.stopTask("ClientCall$Listener.onReady", ClientCallImpl.this.tag);
                            throw th;
                        }
                    }
                });
                PerfMark.stopTask("ClientStreamListener.onReady", ClientCallImpl.this.tag);
            } catch (Throwable th) {
                PerfMark.stopTask("ClientStreamListener.onReady", ClientCallImpl.this.tag);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ClientCallImpl$ClientStreamProvider.class */
    public interface ClientStreamProvider {
        ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, CallOptions callOptions, Metadata metadata, Context context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ClientCallImpl$ContextCancellationListener.class */
    public final class ContextCancellationListener implements Context.CancellationListener {
        private ClientCall.Listener<RespT> observer;

        private ContextCancellationListener(ClientCall.Listener<RespT> listener) {
            this.observer = listener;
        }

        @Override // io.grpc.Context.CancellationListener
        public void cancelled(Context context) {
            if (context.getDeadline() == null || !context.getDeadline().isExpired()) {
                ClientCallImpl.this.stream.cancel(Contexts.statusFromCancelled(context));
                return;
            }
            ClientCallImpl.this.delayedCancelOnDeadlineExceeded(Contexts.statusFromCancelled(context), this.observer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientCallImpl(MethodDescriptor<ReqT, RespT> methodDescriptor, Executor executor, CallOptions callOptions, ClientStreamProvider clientStreamProvider, ScheduledExecutorService scheduledExecutorService, CallTracer callTracer, InternalConfigSelector internalConfigSelector) {
        boolean z = false;
        this.method = methodDescriptor;
        this.tag = PerfMark.createTag(methodDescriptor.getFullMethodName(), System.identityHashCode(this));
        if (executor == MoreExecutors.directExecutor()) {
            this.callExecutor = new SerializeReentrantCallsDirectExecutor();
            this.callExecutorIsDirect = true;
        } else {
            this.callExecutor = new SerializingExecutor(executor);
            this.callExecutorIsDirect = false;
        }
        this.channelCallsTracer = callTracer;
        this.context = Context.current();
        this.unaryRequest = (methodDescriptor.getType() == MethodDescriptor.MethodType.UNARY || methodDescriptor.getType() == MethodDescriptor.MethodType.SERVER_STREAMING) ? true : z;
        this.callOptions = callOptions;
        this.clientStreamProvider = clientStreamProvider;
        this.deadlineCancellationExecutor = scheduledExecutorService;
        PerfMark.event("ClientCall.<init>", this.tag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Status buildDeadlineExceededStatusWithRemainingNanos(long j) {
        InsightBuilder insightBuilder = new InsightBuilder();
        this.stream.appendTimeoutInsight(insightBuilder);
        long abs = Math.abs(j) / TimeUnit.SECONDS.toNanos(1L);
        long abs2 = Math.abs(j);
        long nanos = TimeUnit.SECONDS.toNanos(1L);
        StringBuilder sb = new StringBuilder();
        sb.append("deadline exceeded after ");
        if (j < 0) {
            sb.append('-');
        }
        sb.append(abs);
        sb.append(String.format(".%09d", Long.valueOf(abs2 % nanos)));
        sb.append("s. ");
        sb.append(insightBuilder);
        return Status.DEADLINE_EXCEEDED.augmentDescription(sb.toString());
    }

    private void cancelInternal(@Nullable String str, @Nullable Throwable th) {
        CancellationException cancellationException = th;
        if (str == null) {
            cancellationException = th;
            if (th == null) {
                cancellationException = new CancellationException("Cancelled without a message or cause");
                log.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", (Throwable) cancellationException);
            }
        }
        if (this.cancelCalled) {
            return;
        }
        this.cancelCalled = true;
        try {
            if (this.stream != null) {
                Status status = Status.CANCELLED;
                Status withDescription = str != null ? status.withDescription(str) : status.withDescription("Call cancelled without message");
                Status status2 = withDescription;
                if (cancellationException != null) {
                    status2 = withDescription.withCause(cancellationException);
                }
                this.stream.cancel(status2);
            }
        } finally {
            removeContextListenerAndCancelDeadlineFuture();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeObserver(ClientCall.Listener<RespT> listener, Status status, Metadata metadata) {
        if (this.observerClosed) {
            return;
        }
        this.observerClosed = true;
        listener.onClose(status, metadata);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delayedCancelOnDeadlineExceeded(final Status status, ClientCall.Listener<RespT> listener) {
        if (this.deadlineCancellationSendToServerFuture != null) {
            return;
        }
        this.deadlineCancellationSendToServerFuture = this.deadlineCancellationExecutor.schedule(new LogExceptionRunnable(new Runnable() { // from class: io.grpc.internal.ClientCallImpl.1DeadlineExceededSendCancelToServerTimer
            @Override // java.lang.Runnable
            public void run() {
                ClientCallImpl.this.stream.cancel(status);
            }
        }), DEADLINE_EXPIRATION_CANCEL_DELAY_NANOS, TimeUnit.NANOSECONDS);
        executeCloseObserverInContext(listener, status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Deadline effectiveDeadline() {
        return min(this.callOptions.getDeadline(), this.context.getDeadline());
    }

    private void executeCloseObserverInContext(final ClientCall.Listener<RespT> listener, final Status status) {
        this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.1CloseInContext
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ClientCallImpl.this.context);
            }

            @Override // io.grpc.internal.ContextRunnable
            public void runInContext() {
                ClientCallImpl.this.closeObserver(listener, status, new Metadata());
            }
        });
    }

    private void halfCloseInternal() {
        Preconditions.checkState(this.stream != null, "Not started");
        Preconditions.checkState(!this.cancelCalled, "call was cancelled");
        Preconditions.checkState(!this.halfCloseCalled, "call already half-closed");
        this.halfCloseCalled = true;
        this.stream.halfClose();
    }

    private static void logIfContextNarrowedTimeout(Deadline deadline, @Nullable Deadline deadline2, @Nullable Deadline deadline3) {
        if (log.isLoggable(Level.FINE) && deadline != null && deadline.equals(deadline2)) {
            StringBuilder sb = new StringBuilder(String.format("Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(Math.max(0L, deadline.timeRemaining(TimeUnit.NANOSECONDS)))));
            if (deadline3 == null) {
                sb.append(" Explicit call timeout was not set.");
            } else {
                sb.append(String.format(" Explicit call timeout was '%d' ns.", Long.valueOf(deadline3.timeRemaining(TimeUnit.NANOSECONDS))));
            }
            log.fine(sb.toString());
        }
    }

    @Nullable
    private static Deadline min(@Nullable Deadline deadline, @Nullable Deadline deadline2) {
        return deadline == null ? deadline2 : deadline2 == null ? deadline : deadline.minimum(deadline2);
    }

    static void prepareHeaders(Metadata metadata, DecompressorRegistry decompressorRegistry, Compressor compressor, boolean z) {
        metadata.discardAll(GrpcUtil.MESSAGE_ENCODING_KEY);
        if (compressor != Codec.Identity.NONE) {
            metadata.put(GrpcUtil.MESSAGE_ENCODING_KEY, compressor.getMessageEncoding());
        }
        metadata.discardAll(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
        byte[] rawAdvertisedMessageEncodings = InternalDecompressorRegistry.getRawAdvertisedMessageEncodings(decompressorRegistry);
        if (rawAdvertisedMessageEncodings.length != 0) {
            metadata.put(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY, rawAdvertisedMessageEncodings);
        }
        metadata.discardAll(GrpcUtil.CONTENT_ENCODING_KEY);
        metadata.discardAll(GrpcUtil.CONTENT_ACCEPT_ENCODING_KEY);
        if (z) {
            metadata.put(GrpcUtil.CONTENT_ACCEPT_ENCODING_KEY, FULL_STREAM_DECOMPRESSION_ENCODINGS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeContextListenerAndCancelDeadlineFuture() {
        this.context.removeListener(this.cancellationListener);
        ScheduledFuture<?> scheduledFuture = this.deadlineCancellationSendToServerFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        ScheduledFuture<?> scheduledFuture2 = this.deadlineCancellationNotifyApplicationFuture;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(false);
        }
    }

    private void sendMessageInternal(ReqT reqt) {
        Preconditions.checkState(this.stream != null, "Not started");
        Preconditions.checkState(!this.cancelCalled, "call was cancelled");
        Preconditions.checkState(!this.halfCloseCalled, "call was half-closed");
        try {
            if (this.stream instanceof RetriableStream) {
                ((RetriableStream) this.stream).sendMessage(reqt);
            } else {
                this.stream.writeMessage(this.method.streamRequest(reqt));
            }
            if (this.unaryRequest) {
                return;
            }
            this.stream.flush();
        } catch (Error e) {
            this.stream.cancel(Status.CANCELLED.withDescription("Client sendMessage() failed with Error"));
            throw e;
        } catch (RuntimeException e2) {
            this.stream.cancel(Status.CANCELLED.withCause(e2).withDescription("Failed to stream message"));
        }
    }

    private ScheduledFuture<?> startDeadlineNotifyApplicationTimer(Deadline deadline, final ClientCall.Listener<RespT> listener) {
        final long timeRemaining = deadline.timeRemaining(TimeUnit.NANOSECONDS);
        return this.deadlineCancellationExecutor.schedule(new LogExceptionRunnable(new Runnable() { // from class: io.grpc.internal.ClientCallImpl.1DeadlineExceededNotifyApplicationTimer
            @Override // java.lang.Runnable
            public void run() {
                ClientCallImpl.this.delayedCancelOnDeadlineExceeded(ClientCallImpl.this.buildDeadlineExceededStatusWithRemainingNanos(timeRemaining), listener);
            }
        }), timeRemaining, TimeUnit.NANOSECONDS);
    }

    private void startInternal(ClientCall.Listener<RespT> listener, Metadata metadata) {
        Codec codec;
        Preconditions.checkState(this.stream == null, "Already started");
        Preconditions.checkState(!this.cancelCalled, "call was cancelled");
        Preconditions.checkNotNull(listener, "observer");
        Preconditions.checkNotNull(metadata, Downloads.Impl.RequestHeaders.URI_SEGMENT);
        if (this.context.isCancelled()) {
            this.stream = NoopClientStream.INSTANCE;
            executeCloseObserverInContext(listener, Contexts.statusFromCancelled(this.context));
            return;
        }
        String compressor = this.callOptions.getCompressor();
        if (compressor != null) {
            Compressor lookupCompressor = this.compressorRegistry.lookupCompressor(compressor);
            codec = lookupCompressor;
            if (lookupCompressor == 0) {
                this.stream = NoopClientStream.INSTANCE;
                executeCloseObserverInContext(listener, Status.INTERNAL.withDescription(String.format("Unable to find compressor by name %s", compressor)));
                return;
            }
        } else {
            codec = Codec.Identity.NONE;
        }
        prepareHeaders(metadata, this.decompressorRegistry, codec, this.fullStreamDecompression);
        Deadline effectiveDeadline = effectiveDeadline();
        boolean z = false;
        if (effectiveDeadline != null) {
            z = false;
            if (effectiveDeadline.isExpired()) {
                z = true;
            }
        }
        if (z) {
            this.stream = new FailingClientStream(Status.DEADLINE_EXCEEDED.withDescription("ClientCall started after deadline exceeded: " + effectiveDeadline));
        } else {
            logIfContextNarrowedTimeout(effectiveDeadline, this.context.getDeadline(), this.callOptions.getDeadline());
            this.stream = this.clientStreamProvider.newStream(this.method, this.callOptions, metadata, this.context);
        }
        if (this.callExecutorIsDirect) {
            this.stream.optimizeForDirectExecutor();
        }
        if (this.callOptions.getAuthority() != null) {
            this.stream.setAuthority(this.callOptions.getAuthority());
        }
        if (this.callOptions.getMaxInboundMessageSize() != null) {
            this.stream.setMaxInboundMessageSize(this.callOptions.getMaxInboundMessageSize().intValue());
        }
        if (this.callOptions.getMaxOutboundMessageSize() != null) {
            this.stream.setMaxOutboundMessageSize(this.callOptions.getMaxOutboundMessageSize().intValue());
        }
        if (effectiveDeadline != null) {
            this.stream.setDeadline(effectiveDeadline);
        }
        this.stream.setCompressor(codec);
        boolean z2 = this.fullStreamDecompression;
        if (z2) {
            this.stream.setFullStreamDecompression(z2);
        }
        this.stream.setDecompressorRegistry(this.decompressorRegistry);
        this.channelCallsTracer.reportCallStarted();
        this.cancellationListener = new ContextCancellationListener(listener);
        this.stream.start(new ClientStreamListenerImpl(listener));
        this.context.addListener(this.cancellationListener, MoreExecutors.directExecutor());
        if (effectiveDeadline != null && !effectiveDeadline.equals(this.context.getDeadline()) && this.deadlineCancellationExecutor != null && !(this.stream instanceof FailingClientStream)) {
            this.deadlineCancellationNotifyApplicationFuture = startDeadlineNotifyApplicationTimer(effectiveDeadline, listener);
        }
        if (this.cancelListenersShouldBeRemoved) {
            removeContextListenerAndCancelDeadlineFuture();
        }
    }

    @Override // io.grpc.ClientCall
    public void cancel(@Nullable String str, @Nullable Throwable th) {
        PerfMark.startTask("ClientCall.cancel", this.tag);
        try {
            cancelInternal(str, th);
            PerfMark.stopTask("ClientCall.cancel", this.tag);
        } catch (Throwable th2) {
            PerfMark.stopTask("ClientCall.cancel", this.tag);
            throw th2;
        }
    }

    @Override // io.grpc.ClientCall
    public Attributes getAttributes() {
        ClientStream clientStream = this.stream;
        return clientStream != null ? clientStream.getAttributes() : Attributes.EMPTY;
    }

    @Override // io.grpc.ClientCall
    public void halfClose() {
        PerfMark.startTask("ClientCall.halfClose", this.tag);
        try {
            halfCloseInternal();
            PerfMark.stopTask("ClientCall.halfClose", this.tag);
        } catch (Throwable th) {
            PerfMark.stopTask("ClientCall.halfClose", this.tag);
            throw th;
        }
    }

    @Override // io.grpc.ClientCall
    public boolean isReady() {
        return this.stream.isReady();
    }

    @Override // io.grpc.ClientCall
    public void request(int i) {
        PerfMark.startTask("ClientCall.request", this.tag);
        try {
            Preconditions.checkState(this.stream != null, "Not started");
            Preconditions.checkArgument(i >= 0, "Number requested must be non-negative");
            this.stream.request(i);
            PerfMark.stopTask("ClientCall.request", this.tag);
        } catch (Throwable th) {
            PerfMark.stopTask("ClientCall.request", this.tag);
            throw th;
        }
    }

    @Override // io.grpc.ClientCall
    public void sendMessage(ReqT reqt) {
        PerfMark.startTask("ClientCall.sendMessage", this.tag);
        try {
            sendMessageInternal(reqt);
            PerfMark.stopTask("ClientCall.sendMessage", this.tag);
        } catch (Throwable th) {
            PerfMark.stopTask("ClientCall.sendMessage", this.tag);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientCallImpl<ReqT, RespT> setCompressorRegistry(CompressorRegistry compressorRegistry) {
        this.compressorRegistry = compressorRegistry;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientCallImpl<ReqT, RespT> setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
        this.decompressorRegistry = decompressorRegistry;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientCallImpl<ReqT, RespT> setFullStreamDecompression(boolean z) {
        this.fullStreamDecompression = z;
        return this;
    }

    @Override // io.grpc.ClientCall
    public void setMessageCompression(boolean z) {
        Preconditions.checkState(this.stream != null, "Not started");
        this.stream.setMessageCompression(z);
    }

    @Override // io.grpc.ClientCall
    public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
        PerfMark.startTask("ClientCall.start", this.tag);
        try {
            startInternal(listener, metadata);
            PerfMark.stopTask("ClientCall.start", this.tag);
        } catch (Throwable th) {
            PerfMark.stopTask("ClientCall.start", this.tag);
            throw th;
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("method", this.method).toString();
    }
}
