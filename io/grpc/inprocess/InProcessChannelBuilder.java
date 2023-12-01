package io.grpc.inprocess;

import android.net.ProxyInfo;
import com.google.common.base.Preconditions;
import io.grpc.ChannelLogger;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.SharedResourceHolder;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/inprocess/InProcessChannelBuilder.class */
public final class InProcessChannelBuilder extends AbstractManagedChannelImplBuilder<InProcessChannelBuilder> {
    private int maxInboundMetadataSize;
    private final String name;
    private ScheduledExecutorService scheduledExecutorService;
    private boolean transportIncludeStatusCause;

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/inprocess/InProcessChannelBuilder$InProcessClientTransportFactory.class */
    static final class InProcessClientTransportFactory implements ClientTransportFactory {
        private boolean closed;
        private final boolean includeCauseWithStatus;
        private final int maxInboundMetadataSize;
        private final String name;
        private final ScheduledExecutorService timerService;
        private final boolean useSharedTimer;

        private InProcessClientTransportFactory(String str, @Nullable ScheduledExecutorService scheduledExecutorService, int i, boolean z) {
            this.name = str;
            boolean z2 = scheduledExecutorService == null;
            this.useSharedTimer = z2;
            this.timerService = z2 ? (ScheduledExecutorService) SharedResourceHolder.get(GrpcUtil.TIMER_SERVICE) : scheduledExecutorService;
            this.maxInboundMetadataSize = i;
            this.includeCauseWithStatus = z;
        }

        @Override // io.grpc.internal.ClientTransportFactory, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.useSharedTimer) {
                SharedResourceHolder.release(GrpcUtil.TIMER_SERVICE, this.timerService);
            }
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ScheduledExecutorService getScheduledExecutorService() {
            return this.timerService;
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ConnectionClientTransport newClientTransport(SocketAddress socketAddress, ClientTransportFactory.ClientTransportOptions clientTransportOptions, ChannelLogger channelLogger) {
            if (this.closed) {
                throw new IllegalStateException("The transport factory is closed.");
            }
            return new InProcessTransport(this.name, this.maxInboundMetadataSize, clientTransportOptions.getAuthority(), clientTransportOptions.getUserAgent(), clientTransportOptions.getEagAttributes(), this.includeCauseWithStatus);
        }
    }

    private InProcessChannelBuilder(String str) {
        super(new InProcessSocketAddress(str), ProxyInfo.LOCAL_HOST);
        this.maxInboundMetadataSize = Integer.MAX_VALUE;
        this.transportIncludeStatusCause = false;
        this.name = (String) Preconditions.checkNotNull(str, "name");
        setStatsRecordStartedRpcs(false);
        setStatsRecordFinishedRpcs(false);
    }

    public static InProcessChannelBuilder forAddress(String str, int i) {
        throw new UnsupportedOperationException("call forName() instead");
    }

    public static InProcessChannelBuilder forName(String str) {
        return new InProcessChannelBuilder(str);
    }

    public static InProcessChannelBuilder forTarget(String str) {
        throw new UnsupportedOperationException("call forName() instead");
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder
    public ClientTransportFactory buildTransportFactory() {
        return new InProcessClientTransportFactory(this.name, this.scheduledExecutorService, this.maxInboundMetadataSize, this.transportIncludeStatusCause);
    }

    @Override // io.grpc.ManagedChannelBuilder
    public InProcessChannelBuilder keepAliveTime(long j, TimeUnit timeUnit) {
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public InProcessChannelBuilder keepAliveTimeout(long j, TimeUnit timeUnit) {
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public InProcessChannelBuilder keepAliveWithoutCalls(boolean z) {
        return this;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder, io.grpc.ManagedChannelBuilder
    public final InProcessChannelBuilder maxInboundMessageSize(int i) {
        return (InProcessChannelBuilder) super.maxInboundMessageSize(i);
    }

    @Override // io.grpc.ManagedChannelBuilder
    public InProcessChannelBuilder maxInboundMetadataSize(int i) {
        Preconditions.checkArgument(i > 0, "maxInboundMetadataSize must be > 0");
        this.maxInboundMetadataSize = i;
        return this;
    }

    public InProcessChannelBuilder propagateCauseWithStatus(boolean z) {
        this.transportIncludeStatusCause = z;
        return this;
    }

    public InProcessChannelBuilder scheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService, "scheduledExecutorService");
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public InProcessChannelBuilder usePlaintext() {
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public InProcessChannelBuilder useTransportSecurity() {
        return this;
    }
}
