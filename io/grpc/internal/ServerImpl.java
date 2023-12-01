package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.BinaryLog;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Deadline;
import io.grpc.Decompressor;
import io.grpc.DecompressorRegistry;
import io.grpc.HandlerRegistry;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.InternalLogId;
import io.grpc.InternalServerInterceptors;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServerTransportFilter;
import io.grpc.Status;
import io.grpc.internal.StreamListener;
import io.perfmark.Link;
import io.perfmark.PerfMark;
import io.perfmark.Tag;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ServerImpl.class */
public final class ServerImpl extends Server implements InternalInstrumented<InternalChannelz.ServerStats> {
    private int activeTransportServers;
    private final BinaryLog binlog;
    private final InternalChannelz channelz;
    private final CompressorRegistry compressorRegistry;
    private final DecompressorRegistry decompressorRegistry;
    private Executor executor;
    private final ObjectPool<? extends Executor> executorPool;
    private final HandlerRegistry fallbackRegistry;
    private final long handshakeTimeoutMillis;
    private final ServerInterceptor[] interceptors;
    private final InternalLogId logId;
    private final HandlerRegistry registry;
    private final Context rootContext;
    private final CallTracer serverCallTracer;
    private boolean serverShutdownCallbackInvoked;
    private boolean shutdown;
    private Status shutdownNowStatus;
    private boolean started;
    private boolean terminated;
    private final Deadline.Ticker ticker;
    private final List<ServerTransportFilter> transportFilters;
    private final List<? extends InternalServer> transportServers;
    private boolean transportServersTerminated;
    private static final Logger log = Logger.getLogger(ServerImpl.class.getName());
    private static final ServerStreamListener NOOP_LISTENER = new NoopListener();
    private final Object lock = new Object();
    private final Set<ServerTransport> transports = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ServerImpl$ContextCloser.class */
    public static final class ContextCloser implements Runnable {
        private final Throwable cause;
        private final Context.CancellableContext context;

        ContextCloser(Context.CancellableContext cancellableContext, Throwable th) {
            this.context = cancellableContext;
            this.cause = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.context.cancel(this.cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ServerImpl$JumpToApplicationThreadServerStreamListener.class */
    public static final class JumpToApplicationThreadServerStreamListener implements ServerStreamListener {
        private final Executor callExecutor;
        private final Executor cancelExecutor;
        private final Context.CancellableContext context;
        private ServerStreamListener listener;
        private final ServerStream stream;
        private final Tag tag;

        public JumpToApplicationThreadServerStreamListener(Executor executor, Executor executor2, ServerStream serverStream, Context.CancellableContext cancellableContext, Tag tag) {
            this.callExecutor = executor;
            this.cancelExecutor = executor2;
            this.stream = serverStream;
            this.context = cancellableContext;
            this.tag = tag;
        }

        private void closedInternal(final Status status) {
            if (!status.isOk()) {
                this.cancelExecutor.execute(new ContextCloser(this.context, status.getCause()));
            }
            final Link linkOut = PerfMark.linkOut();
            this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.1Closed
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(JumpToApplicationThreadServerStreamListener.this.context);
                }

                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    PerfMark.startTask("ServerCallListener(app).closed", JumpToApplicationThreadServerStreamListener.this.tag);
                    PerfMark.linkIn(linkOut);
                    try {
                        JumpToApplicationThreadServerStreamListener.this.getListener().closed(status);
                        PerfMark.stopTask("ServerCallListener(app).closed", JumpToApplicationThreadServerStreamListener.this.tag);
                    } catch (Throwable th) {
                        PerfMark.stopTask("ServerCallListener(app).closed", JumpToApplicationThreadServerStreamListener.this.tag);
                        throw th;
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ServerStreamListener getListener() {
            ServerStreamListener serverStreamListener = this.listener;
            if (serverStreamListener != null) {
                return serverStreamListener;
            }
            throw new IllegalStateException("listener unset");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void internalClose(Throwable th) {
            this.stream.close(Status.UNKNOWN.withCause(th), new Metadata());
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void closed(Status status) {
            PerfMark.startTask("ServerStreamListener.closed", this.tag);
            try {
                closedInternal(status);
                PerfMark.stopTask("ServerStreamListener.closed", this.tag);
            } catch (Throwable th) {
                PerfMark.stopTask("ServerStreamListener.closed", this.tag);
                throw th;
            }
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void halfClosed() {
            PerfMark.startTask("ServerStreamListener.halfClosed", this.tag);
            final Link linkOut = PerfMark.linkOut();
            try {
                this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.1HalfClosed
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(JumpToApplicationThreadServerStreamListener.this.context);
                    }

                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        PerfMark.startTask("ServerCallListener(app).halfClosed", JumpToApplicationThreadServerStreamListener.this.tag);
                        PerfMark.linkIn(linkOut);
                        try {
                            JumpToApplicationThreadServerStreamListener.this.getListener().halfClosed();
                            PerfMark.stopTask("ServerCallListener(app).halfClosed", JumpToApplicationThreadServerStreamListener.this.tag);
                        } finally {
                        }
                    }
                });
                PerfMark.stopTask("ServerStreamListener.halfClosed", this.tag);
            } catch (Throwable th) {
                PerfMark.stopTask("ServerStreamListener.halfClosed", this.tag);
                throw th;
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(final StreamListener.MessageProducer messageProducer) {
            PerfMark.startTask("ServerStreamListener.messagesAvailable", this.tag);
            final Link linkOut = PerfMark.linkOut();
            try {
                this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.1MessagesAvailable
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(JumpToApplicationThreadServerStreamListener.this.context);
                    }

                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        PerfMark.startTask("ServerCallListener(app).messagesAvailable", JumpToApplicationThreadServerStreamListener.this.tag);
                        PerfMark.linkIn(linkOut);
                        try {
                            JumpToApplicationThreadServerStreamListener.this.getListener().messagesAvailable(messageProducer);
                            PerfMark.stopTask("ServerCallListener(app).messagesAvailable", JumpToApplicationThreadServerStreamListener.this.tag);
                        } finally {
                        }
                    }
                });
                PerfMark.stopTask("ServerStreamListener.messagesAvailable", this.tag);
            } catch (Throwable th) {
                PerfMark.stopTask("ServerStreamListener.messagesAvailable", this.tag);
                throw th;
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            PerfMark.startTask("ServerStreamListener.onReady", this.tag);
            final Link linkOut = PerfMark.linkOut();
            try {
                this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.1OnReady
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(JumpToApplicationThreadServerStreamListener.this.context);
                    }

                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        PerfMark.startTask("ServerCallListener(app).onReady", JumpToApplicationThreadServerStreamListener.this.tag);
                        PerfMark.linkIn(linkOut);
                        try {
                            JumpToApplicationThreadServerStreamListener.this.getListener().onReady();
                            PerfMark.stopTask("ServerCallListener(app).onReady", JumpToApplicationThreadServerStreamListener.this.tag);
                        } finally {
                        }
                    }
                });
                PerfMark.stopTask("ServerStreamListener.onReady", this.tag);
            } catch (Throwable th) {
                PerfMark.stopTask("ServerStreamListener.onReady", this.tag);
                throw th;
            }
        }

        void setListener(ServerStreamListener serverStreamListener) {
            Preconditions.checkNotNull(serverStreamListener, "listener must not be null");
            Preconditions.checkState(this.listener == null, "Listener already set");
            this.listener = serverStreamListener;
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ServerImpl$NoopListener.class */
    static final class NoopListener implements ServerStreamListener {
        private NoopListener() {
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void closed(Status status) {
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void halfClosed() {
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
            while (true) {
                InputStream next = messageProducer.next();
                if (next == null) {
                    return;
                }
                try {
                    next.close();
                } catch (IOException e) {
                    while (true) {
                        InputStream next2 = messageProducer.next();
                        if (next2 == null) {
                            break;
                        }
                        try {
                            next2.close();
                        } catch (IOException e2) {
                            ServerImpl.log.log(Level.WARNING, "Exception closing stream", (Throwable) e2);
                        }
                    }
                    throw new RuntimeException(e);
                }
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ServerImpl$ServerListenerImpl.class */
    public final class ServerListenerImpl implements ServerListener {
        private ServerListenerImpl() {
        }

        @Override // io.grpc.internal.ServerListener
        public void serverShutdown() {
            synchronized (ServerImpl.this.lock) {
                ServerImpl.access$410(ServerImpl.this);
                if (ServerImpl.this.activeTransportServers != 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList(ServerImpl.this.transports);
                Status status = ServerImpl.this.shutdownNowStatus;
                ServerImpl.this.serverShutdownCallbackInvoked = true;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ServerTransport serverTransport = (ServerTransport) it.next();
                    if (status == null) {
                        serverTransport.shutdown();
                    } else {
                        serverTransport.shutdownNow(status);
                    }
                }
                synchronized (ServerImpl.this.lock) {
                    ServerImpl.this.transportServersTerminated = true;
                    ServerImpl.this.checkForTermination();
                }
            }
        }

        @Override // io.grpc.internal.ServerListener
        public ServerTransportListener transportCreated(ServerTransport serverTransport) {
            synchronized (ServerImpl.this.lock) {
                ServerImpl.this.transports.add(serverTransport);
            }
            ServerTransportListenerImpl serverTransportListenerImpl = new ServerTransportListenerImpl(serverTransport);
            serverTransportListenerImpl.init();
            return serverTransportListenerImpl;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ServerImpl$ServerTransportListenerImpl.class */
    public final class ServerTransportListenerImpl implements ServerTransportListener {
        private Attributes attributes;
        private Future<?> handshakeTimeoutFuture;
        private final ServerTransport transport;

        ServerTransportListenerImpl(ServerTransport serverTransport) {
            this.transport = serverTransport;
        }

        private Context.CancellableContext createContext(Metadata metadata, StatsTraceContext statsTraceContext) {
            Long l = (Long) metadata.get(GrpcUtil.TIMEOUT_KEY);
            Context withValue = statsTraceContext.serverFilterContext(ServerImpl.this.rootContext).withValue(io.grpc.InternalServer.SERVER_CONTEXT_KEY, ServerImpl.this);
            return l == null ? withValue.withCancellation() : withValue.withDeadline(Deadline.after(l.longValue(), TimeUnit.NANOSECONDS, ServerImpl.this.ticker), this.transport.getScheduledExecutorService());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <ReqT, RespT> ServerStreamListener startCall(ServerStream serverStream, String str, ServerMethodDefinition<ReqT, RespT> serverMethodDefinition, Metadata metadata, Context.CancellableContext cancellableContext, StatsTraceContext statsTraceContext, Tag tag) {
            statsTraceContext.serverCallStarted(new ServerCallInfoImpl(serverMethodDefinition.getMethodDescriptor(), serverStream.getAttributes(), serverStream.getAuthority()));
            ServerCallHandler serverCallHandler = serverMethodDefinition.getServerCallHandler();
            ServerInterceptor[] serverInterceptorArr = ServerImpl.this.interceptors;
            int length = serverInterceptorArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                serverCallHandler = InternalServerInterceptors.interceptCallHandler(serverInterceptorArr[i2], serverCallHandler);
                i = i2 + 1;
            }
            ServerMethodDefinition withServerCallHandler = serverMethodDefinition.withServerCallHandler(serverCallHandler);
            if (ServerImpl.this.binlog != null) {
                withServerCallHandler = ServerImpl.this.binlog.wrapMethodDefinition(withServerCallHandler);
            }
            return startWrappedCall(str, withServerCallHandler, serverStream, metadata, cancellableContext, tag);
        }

        private <WReqT, WRespT> ServerStreamListener startWrappedCall(String str, ServerMethodDefinition<WReqT, WRespT> serverMethodDefinition, ServerStream serverStream, Metadata metadata, Context.CancellableContext cancellableContext, Tag tag) {
            ServerCallImpl serverCallImpl = new ServerCallImpl(serverStream, serverMethodDefinition.getMethodDescriptor(), metadata, cancellableContext, ServerImpl.this.decompressorRegistry, ServerImpl.this.compressorRegistry, ServerImpl.this.serverCallTracer, tag);
            ServerCall.Listener startCall = serverMethodDefinition.getServerCallHandler().startCall(serverCallImpl, metadata);
            if (startCall != null) {
                return serverCallImpl.newServerStreamListener(startCall);
            }
            throw new NullPointerException("startCall() returned a null listener for method " + str);
        }

        private void streamCreatedInternal(ServerStream serverStream, String str, Metadata metadata, Tag tag) {
            Executor serializingExecutor;
            if (ServerImpl.this.executor == MoreExecutors.directExecutor()) {
                serializingExecutor = new SerializeReentrantCallsDirectExecutor();
                serverStream.optimizeForDirectExecutor();
            } else {
                serializingExecutor = new SerializingExecutor(ServerImpl.this.executor);
            }
            if (metadata.containsKey(GrpcUtil.MESSAGE_ENCODING_KEY)) {
                String str2 = (String) metadata.get(GrpcUtil.MESSAGE_ENCODING_KEY);
                Decompressor lookupDecompressor = ServerImpl.this.decompressorRegistry.lookupDecompressor(str2);
                if (lookupDecompressor == null) {
                    serverStream.setListener(ServerImpl.NOOP_LISTENER);
                    serverStream.close(Status.UNIMPLEMENTED.withDescription(String.format("Can't find decompressor for %s", str2)), new Metadata());
                    return;
                }
                serverStream.setDecompressor(lookupDecompressor);
            }
            StatsTraceContext statsTraceContext = (StatsTraceContext) Preconditions.checkNotNull(serverStream.statsTraceContext(), "statsTraceCtx not present from stream");
            Context.CancellableContext createContext = createContext(metadata, statsTraceContext);
            Link linkOut = PerfMark.linkOut();
            JumpToApplicationThreadServerStreamListener jumpToApplicationThreadServerStreamListener = new JumpToApplicationThreadServerStreamListener(serializingExecutor, ServerImpl.this.executor, serverStream, createContext, tag);
            serverStream.setListener(jumpToApplicationThreadServerStreamListener);
            serializingExecutor.execute(new ContextRunnable(createContext, tag, linkOut, str, serverStream, metadata, statsTraceContext, jumpToApplicationThreadServerStreamListener) { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.1StreamCreated
                final /* synthetic */ Context.CancellableContext val$context;
                final /* synthetic */ Metadata val$headers;
                final /* synthetic */ JumpToApplicationThreadServerStreamListener val$jumpListener;
                final /* synthetic */ Link val$link;
                final /* synthetic */ String val$methodName;
                final /* synthetic */ StatsTraceContext val$statsTraceCtx;
                final /* synthetic */ ServerStream val$stream;
                final /* synthetic */ Tag val$tag;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(createContext);
                    this.val$context = createContext;
                    this.val$tag = tag;
                    this.val$link = linkOut;
                    this.val$methodName = str;
                    this.val$stream = serverStream;
                    this.val$headers = metadata;
                    this.val$statsTraceCtx = statsTraceContext;
                    this.val$jumpListener = jumpToApplicationThreadServerStreamListener;
                }

                private void runInternal() {
                    ServerStreamListener serverStreamListener = ServerImpl.NOOP_LISTENER;
                    try {
                        ServerMethodDefinition lookupMethod = ServerImpl.this.registry.lookupMethod(this.val$methodName);
                        ServerMethodDefinition serverMethodDefinition = lookupMethod;
                        if (lookupMethod == null) {
                            serverMethodDefinition = ServerImpl.this.fallbackRegistry.lookupMethod(this.val$methodName, this.val$stream.getAuthority());
                        }
                        if (serverMethodDefinition != null) {
                            this.val$jumpListener.setListener(ServerTransportListenerImpl.this.startCall(this.val$stream, this.val$methodName, serverMethodDefinition, this.val$headers, this.val$context, this.val$statsTraceCtx, this.val$tag));
                            this.val$context.addListener(new Context.CancellationListener() { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.1StreamCreated.1ServerStreamCancellationListener
                                public void cancelled(Context context) {
                                    Status statusFromCancelled = Contexts.statusFromCancelled(context);
                                    if (Status.DEADLINE_EXCEEDED.getCode().equals(statusFromCancelled.getCode())) {
                                        C1StreamCreated.this.val$stream.cancel(statusFromCancelled);
                                    }
                                }
                            }, MoreExecutors.directExecutor());
                            return;
                        }
                        Status status = Status.UNIMPLEMENTED;
                        this.val$stream.close(status.withDescription("Method not found: " + this.val$methodName), new Metadata());
                        this.val$context.cancel((Throwable) null);
                    } catch (Throwable th) {
                        try {
                            this.val$stream.close(Status.fromThrowable(th), new Metadata());
                            this.val$context.cancel((Throwable) null);
                            throw th;
                        } finally {
                            this.val$jumpListener.setListener(serverStreamListener);
                        }
                    }
                }

                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    PerfMark.startTask("ServerTransportListener$StreamCreated.startCall", this.val$tag);
                    PerfMark.linkIn(this.val$link);
                    try {
                        runInternal();
                        PerfMark.stopTask("ServerTransportListener$StreamCreated.startCall", this.val$tag);
                    } catch (Throwable th) {
                        PerfMark.stopTask("ServerTransportListener$StreamCreated.startCall", this.val$tag);
                        throw th;
                    }
                }
            });
        }

        public void init() {
            if (ServerImpl.this.handshakeTimeoutMillis != Long.MAX_VALUE) {
                this.handshakeTimeoutFuture = this.transport.getScheduledExecutorService().schedule(new Runnable() { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.1TransportShutdownNow
                    @Override // java.lang.Runnable
                    public void run() {
                        ServerTransportListenerImpl.this.transport.shutdownNow(Status.CANCELLED.withDescription("Handshake timeout exceeded"));
                    }
                }, ServerImpl.this.handshakeTimeoutMillis, TimeUnit.MILLISECONDS);
            } else {
                this.handshakeTimeoutFuture = new FutureTask(new Runnable() { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                }, null);
            }
            ServerImpl.this.channelz.addServerSocket(ServerImpl.this, this.transport);
        }

        @Override // io.grpc.internal.ServerTransportListener
        public void streamCreated(ServerStream serverStream, String str, Metadata metadata) {
            Tag createTag = PerfMark.createTag(str, serverStream.streamId());
            PerfMark.startTask("ServerTransportListener.streamCreated", createTag);
            try {
                streamCreatedInternal(serverStream, str, metadata, createTag);
                PerfMark.stopTask("ServerTransportListener.streamCreated", createTag);
            } catch (Throwable th) {
                PerfMark.stopTask("ServerTransportListener.streamCreated", createTag);
                throw th;
            }
        }

        @Override // io.grpc.internal.ServerTransportListener
        public Attributes transportReady(Attributes attributes) {
            this.handshakeTimeoutFuture.cancel(false);
            this.handshakeTimeoutFuture = null;
            for (ServerTransportFilter serverTransportFilter : ServerImpl.this.transportFilters) {
                attributes = (Attributes) Preconditions.checkNotNull(serverTransportFilter.transportReady(attributes), "Filter %s returned null", serverTransportFilter);
            }
            this.attributes = attributes;
            return attributes;
        }

        @Override // io.grpc.internal.ServerTransportListener
        public void transportTerminated() {
            Future<?> future = this.handshakeTimeoutFuture;
            if (future != null) {
                future.cancel(false);
                this.handshakeTimeoutFuture = null;
            }
            for (ServerTransportFilter serverTransportFilter : ServerImpl.this.transportFilters) {
                serverTransportFilter.transportTerminated(this.attributes);
            }
            ServerImpl.this.transportClosed(this.transport);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServerImpl(AbstractServerImplBuilder<?> abstractServerImplBuilder, List<? extends InternalServer> list, Context context) {
        this.executorPool = (ObjectPool) Preconditions.checkNotNull(abstractServerImplBuilder.executorPool, "executorPool");
        this.registry = (HandlerRegistry) Preconditions.checkNotNull(abstractServerImplBuilder.registryBuilder.build(), "registryBuilder");
        this.fallbackRegistry = (HandlerRegistry) Preconditions.checkNotNull(abstractServerImplBuilder.fallbackRegistry, "fallbackRegistry");
        Preconditions.checkNotNull(list, "transportServers");
        Preconditions.checkArgument(!list.isEmpty(), "no servers provided");
        this.transportServers = new ArrayList(list);
        this.logId = InternalLogId.allocate("Server", String.valueOf(getListenSocketsIgnoringLifecycle()));
        this.rootContext = ((Context) Preconditions.checkNotNull(context, "rootContext")).fork();
        this.decompressorRegistry = abstractServerImplBuilder.decompressorRegistry;
        this.compressorRegistry = abstractServerImplBuilder.compressorRegistry;
        this.transportFilters = Collections.unmodifiableList(new ArrayList(abstractServerImplBuilder.transportFilters));
        this.interceptors = (ServerInterceptor[]) abstractServerImplBuilder.interceptors.toArray(new ServerInterceptor[abstractServerImplBuilder.interceptors.size()]);
        this.handshakeTimeoutMillis = abstractServerImplBuilder.handshakeTimeoutMillis;
        this.binlog = abstractServerImplBuilder.binlog;
        this.channelz = abstractServerImplBuilder.channelz;
        this.serverCallTracer = abstractServerImplBuilder.callTracerFactory.create();
        this.ticker = (Deadline.Ticker) Preconditions.checkNotNull(abstractServerImplBuilder.ticker, "ticker");
        this.channelz.addServer(this);
    }

    static /* synthetic */ int access$410(ServerImpl serverImpl) {
        int i = serverImpl.activeTransportServers;
        serverImpl.activeTransportServers = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkForTermination() {
        synchronized (this.lock) {
            if (this.shutdown && this.transports.isEmpty() && this.transportServersTerminated) {
                if (this.terminated) {
                    throw new AssertionError("Server already terminated");
                }
                this.terminated = true;
                this.channelz.removeServer(this);
                if (this.executor != null) {
                    this.executor = this.executorPool.returnObject(this.executor);
                }
                this.lock.notifyAll();
            }
        }
    }

    private List<SocketAddress> getListenSocketsIgnoringLifecycle() {
        List<SocketAddress> unmodifiableList;
        synchronized (this.lock) {
            ArrayList arrayList = new ArrayList(this.transportServers.size());
            for (InternalServer internalServer : this.transportServers) {
                arrayList.add(internalServer.getListenSocketAddress());
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transportClosed(ServerTransport serverTransport) {
        synchronized (this.lock) {
            if (!this.transports.remove(serverTransport)) {
                throw new AssertionError("Transport already removed");
            }
            this.channelz.removeServerSocket(this, serverTransport);
            checkForTermination();
        }
    }

    public void awaitTermination() throws InterruptedException {
        synchronized (this.lock) {
            while (!this.terminated) {
                this.lock.wait();
            }
        }
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        boolean z;
        synchronized (this.lock) {
            long nanos = timeUnit.toNanos(j);
            long nanoTime = System.nanoTime();
            while (!this.terminated) {
                long nanoTime2 = (nanoTime + nanos) - System.nanoTime();
                if (nanoTime2 <= 0) {
                    break;
                }
                TimeUnit.NANOSECONDS.timedWait(this.lock, nanoTime2);
            }
            z = this.terminated;
        }
        return z;
    }

    public List<ServerServiceDefinition> getImmutableServices() {
        return this.registry.getServices();
    }

    public List<SocketAddress> getListenSockets() {
        List<SocketAddress> listenSocketsIgnoringLifecycle;
        synchronized (this.lock) {
            Preconditions.checkState(this.started, "Not started");
            Preconditions.checkState(!this.terminated, "Already terminated");
            listenSocketsIgnoringLifecycle = getListenSocketsIgnoringLifecycle();
        }
        return listenSocketsIgnoringLifecycle;
    }

    public InternalLogId getLogId() {
        return this.logId;
    }

    public List<ServerServiceDefinition> getMutableServices() {
        return Collections.unmodifiableList(this.fallbackRegistry.getServices());
    }

    public int getPort() {
        SocketAddress listenSocketAddress;
        synchronized (this.lock) {
            Preconditions.checkState(this.started, "Not started");
            Preconditions.checkState(!this.terminated, "Already terminated");
            Iterator<? extends InternalServer> it = this.transportServers.iterator();
            do {
                if (!it.hasNext()) {
                    return -1;
                }
                listenSocketAddress = it.next().getListenSocketAddress();
            } while (!(listenSocketAddress instanceof InetSocketAddress));
            return ((InetSocketAddress) listenSocketAddress).getPort();
        }
    }

    public List<ServerServiceDefinition> getServices() {
        List services = this.fallbackRegistry.getServices();
        if (services.isEmpty()) {
            return this.registry.getServices();
        }
        List services2 = this.registry.getServices();
        ArrayList arrayList = new ArrayList(services2.size() + services.size());
        arrayList.addAll(services2);
        arrayList.addAll(services);
        return Collections.unmodifiableList(arrayList);
    }

    public ListenableFuture<InternalChannelz.ServerStats> getStats() {
        InternalChannelz.ServerStats.Builder builder = new InternalChannelz.ServerStats.Builder();
        for (InternalServer internalServer : this.transportServers) {
            InternalInstrumented<InternalChannelz.SocketStats> listenSocketStats = internalServer.getListenSocketStats();
            if (listenSocketStats != null) {
                builder.addListenSockets(Collections.singletonList(listenSocketStats));
            }
        }
        this.serverCallTracer.updateBuilder(builder);
        SettableFuture create = SettableFuture.create();
        create.set(builder.build());
        return create;
    }

    public boolean isShutdown() {
        boolean z;
        synchronized (this.lock) {
            z = this.shutdown;
        }
        return z;
    }

    public boolean isTerminated() {
        boolean z;
        synchronized (this.lock) {
            z = this.terminated;
        }
        return z;
    }

    public ServerImpl shutdown() {
        synchronized (this.lock) {
            if (this.shutdown) {
                return this;
            }
            this.shutdown = true;
            boolean z = this.started;
            if (!z) {
                this.transportServersTerminated = true;
                checkForTermination();
            }
            if (z) {
                for (InternalServer internalServer : this.transportServers) {
                    internalServer.shutdown();
                }
            }
            return this;
        }
    }

    public ServerImpl shutdownNow() {
        shutdown();
        Status withDescription = Status.UNAVAILABLE.withDescription("Server shutdownNow invoked");
        synchronized (this.lock) {
            if (this.shutdownNowStatus != null) {
                return this;
            }
            this.shutdownNowStatus = withDescription;
            ArrayList<ServerTransport> arrayList = new ArrayList(this.transports);
            boolean z = this.serverShutdownCallbackInvoked;
            if (z) {
                for (ServerTransport serverTransport : arrayList) {
                    serverTransport.shutdownNow(withDescription);
                }
            }
            return this;
        }
    }

    public ServerImpl start() throws IOException {
        synchronized (this.lock) {
            Preconditions.checkState(!this.started, "Already started");
            Preconditions.checkState(this.shutdown ? false : true, "Shutting down");
            ServerListenerImpl serverListenerImpl = new ServerListenerImpl();
            for (InternalServer internalServer : this.transportServers) {
                internalServer.start(serverListenerImpl);
                this.activeTransportServers++;
            }
            this.executor = (Executor) Preconditions.checkNotNull(this.executorPool.getObject(), "executor");
            this.started = true;
        }
        return this;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.logId.getId()).add("transportServers", this.transportServers).toString();
    }
}
