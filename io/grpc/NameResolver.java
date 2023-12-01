package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.igexin.push.core.b;
import io.grpc.Attributes;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/NameResolver.class */
public abstract class NameResolver {

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/NameResolver$Args.class */
    public static final class Args {
        @Nullable
        private final ChannelLogger channelLogger;
        private final int defaultPort;
        @Nullable
        private final Executor executor;
        private final ProxyDetector proxyDetector;
        @Nullable
        private final ScheduledExecutorService scheduledExecutorService;
        private final ServiceConfigParser serviceConfigParser;
        private final SynchronizationContext syncContext;

        /* loaded from: source-8829756-dex2jar.jar:io/grpc/NameResolver$Args$Builder.class */
        public static final class Builder {
            private ChannelLogger channelLogger;
            private Integer defaultPort;
            private Executor executor;
            private ProxyDetector proxyDetector;
            private ScheduledExecutorService scheduledExecutorService;
            private ServiceConfigParser serviceConfigParser;
            private SynchronizationContext syncContext;

            Builder() {
            }

            public Args build() {
                return new Args(this.defaultPort, this.proxyDetector, this.syncContext, this.serviceConfigParser, this.scheduledExecutorService, this.channelLogger, this.executor);
            }

            public Builder setChannelLogger(ChannelLogger channelLogger) {
                this.channelLogger = (ChannelLogger) Preconditions.checkNotNull(channelLogger);
                return this;
            }

            public Builder setDefaultPort(int i) {
                this.defaultPort = Integer.valueOf(i);
                return this;
            }

            public Builder setOffloadExecutor(Executor executor) {
                this.executor = executor;
                return this;
            }

            public Builder setProxyDetector(ProxyDetector proxyDetector) {
                this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(proxyDetector);
                return this;
            }

            public Builder setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
                this.scheduledExecutorService = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
                return this;
            }

            public Builder setServiceConfigParser(ServiceConfigParser serviceConfigParser) {
                this.serviceConfigParser = (ServiceConfigParser) Preconditions.checkNotNull(serviceConfigParser);
                return this;
            }

            public Builder setSynchronizationContext(SynchronizationContext synchronizationContext) {
                this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(synchronizationContext);
                return this;
            }
        }

        private Args(Integer num, ProxyDetector proxyDetector, SynchronizationContext synchronizationContext, ServiceConfigParser serviceConfigParser, @Nullable ScheduledExecutorService scheduledExecutorService, @Nullable ChannelLogger channelLogger, @Nullable Executor executor) {
            this.defaultPort = ((Integer) Preconditions.checkNotNull(num, "defaultPort not set")).intValue();
            this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(proxyDetector, "proxyDetector not set");
            this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(synchronizationContext, "syncContext not set");
            this.serviceConfigParser = (ServiceConfigParser) Preconditions.checkNotNull(serviceConfigParser, "serviceConfigParser not set");
            this.scheduledExecutorService = scheduledExecutorService;
            this.channelLogger = channelLogger;
            this.executor = executor;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public ChannelLogger getChannelLogger() {
            ChannelLogger channelLogger = this.channelLogger;
            if (channelLogger != null) {
                return channelLogger;
            }
            throw new IllegalStateException("ChannelLogger is not set in Builder");
        }

        public int getDefaultPort() {
            return this.defaultPort;
        }

        @Nullable
        public Executor getOffloadExecutor() {
            return this.executor;
        }

        public ProxyDetector getProxyDetector() {
            return this.proxyDetector;
        }

        public ScheduledExecutorService getScheduledExecutorService() {
            ScheduledExecutorService scheduledExecutorService = this.scheduledExecutorService;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService;
            }
            throw new IllegalStateException("ScheduledExecutorService not set in Builder");
        }

        public ServiceConfigParser getServiceConfigParser() {
            return this.serviceConfigParser;
        }

        public SynchronizationContext getSynchronizationContext() {
            return this.syncContext;
        }

        public Builder toBuilder() {
            Builder builder = new Builder();
            builder.setDefaultPort(this.defaultPort);
            builder.setProxyDetector(this.proxyDetector);
            builder.setSynchronizationContext(this.syncContext);
            builder.setServiceConfigParser(this.serviceConfigParser);
            builder.setScheduledExecutorService(this.scheduledExecutorService);
            builder.setChannelLogger(this.channelLogger);
            builder.setOffloadExecutor(this.executor);
            return builder;
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("defaultPort", this.defaultPort).add("proxyDetector", this.proxyDetector).add("syncContext", this.syncContext).add("serviceConfigParser", this.serviceConfigParser).add("scheduledExecutorService", this.scheduledExecutorService).add("channelLogger", this.channelLogger).add("executor", this.executor).toString();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/NameResolver$ConfigOrError.class */
    public static final class ConfigOrError {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Object config;
        private final Status status;

        private ConfigOrError(Status status) {
            this.config = null;
            this.status = (Status) Preconditions.checkNotNull(status, "status");
            Preconditions.checkArgument(!status.isOk(), "cannot use OK status: %s", status);
        }

        private ConfigOrError(Object obj) {
            this.config = Preconditions.checkNotNull(obj, b.U);
            this.status = null;
        }

        public static ConfigOrError fromConfig(Object obj) {
            return new ConfigOrError(obj);
        }

        public static ConfigOrError fromError(Status status) {
            return new ConfigOrError(status);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ConfigOrError configOrError = (ConfigOrError) obj;
            return Objects.equal(this.status, configOrError.status) && Objects.equal(this.config, configOrError.config);
        }

        @Nullable
        public Object getConfig() {
            return this.config;
        }

        @Nullable
        public Status getError() {
            return this.status;
        }

        public int hashCode() {
            return Objects.hashCode(this.status, this.config);
        }

        public String toString() {
            return this.config != null ? MoreObjects.toStringHelper(this).add(b.U, this.config).toString() : MoreObjects.toStringHelper(this).add("error", this.status).toString();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/NameResolver$Factory.class */
    public static abstract class Factory {
        @Deprecated
        public static final Attributes.Key<Integer> PARAMS_DEFAULT_PORT = Attributes.Key.create("params-default-port");
        @Deprecated
        public static final Attributes.Key<ProxyDetector> PARAMS_PROXY_DETECTOR = Attributes.Key.create("params-proxy-detector");
        @Deprecated
        private static final Attributes.Key<SynchronizationContext> PARAMS_SYNC_CONTEXT = Attributes.Key.create("params-sync-context");
        @Deprecated
        private static final Attributes.Key<ServiceConfigParser> PARAMS_PARSER = Attributes.Key.create("params-parser");

        public abstract String getDefaultScheme();

        @Nullable
        @Deprecated
        public NameResolver newNameResolver(URI uri, Attributes attributes) {
            return newNameResolver(uri, Args.newBuilder().setDefaultPort(((Integer) attributes.get(PARAMS_DEFAULT_PORT)).intValue()).setProxyDetector((ProxyDetector) attributes.get(PARAMS_PROXY_DETECTOR)).setSynchronizationContext((SynchronizationContext) attributes.get(PARAMS_SYNC_CONTEXT)).setServiceConfigParser((ServiceConfigParser) attributes.get(PARAMS_PARSER)).build());
        }

        public NameResolver newNameResolver(URI uri, final Args args) {
            return newNameResolver(uri, new Helper() { // from class: io.grpc.NameResolver.Factory.2
                @Override // io.grpc.NameResolver.Helper
                public int getDefaultPort() {
                    return args.getDefaultPort();
                }

                @Override // io.grpc.NameResolver.Helper
                public ProxyDetector getProxyDetector() {
                    return args.getProxyDetector();
                }

                @Override // io.grpc.NameResolver.Helper
                public SynchronizationContext getSynchronizationContext() {
                    return args.getSynchronizationContext();
                }

                @Override // io.grpc.NameResolver.Helper
                public ConfigOrError parseServiceConfig(Map<String, ?> map) {
                    return args.getServiceConfigParser().parseServiceConfig(map);
                }
            });
        }

        @Nullable
        @Deprecated
        public NameResolver newNameResolver(URI uri, final Helper helper) {
            return newNameResolver(uri, Attributes.newBuilder().set(PARAMS_DEFAULT_PORT, Integer.valueOf(helper.getDefaultPort())).set(PARAMS_PROXY_DETECTOR, helper.getProxyDetector()).set(PARAMS_SYNC_CONTEXT, helper.getSynchronizationContext()).set(PARAMS_PARSER, new ServiceConfigParser() { // from class: io.grpc.NameResolver.Factory.1
                @Override // io.grpc.NameResolver.ServiceConfigParser
                public ConfigOrError parseServiceConfig(Map<String, ?> map) {
                    return helper.parseServiceConfig(map);
                }
            }).build());
        }
    }

    @Deprecated
    /* loaded from: source-8829756-dex2jar.jar:io/grpc/NameResolver$Helper.class */
    public static abstract class Helper {
        public abstract int getDefaultPort();

        public abstract ProxyDetector getProxyDetector();

        public SynchronizationContext getSynchronizationContext() {
            throw new UnsupportedOperationException("Not implemented");
        }

        public ConfigOrError parseServiceConfig(Map<String, ?> map) {
            throw new UnsupportedOperationException("should have been implemented");
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/NameResolver$Listener.class */
    public interface Listener {
        void onAddresses(List<EquivalentAddressGroup> list, Attributes attributes);

        void onError(Status status);
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/NameResolver$Listener2.class */
    public static abstract class Listener2 implements Listener {
        @Override // io.grpc.NameResolver.Listener
        @Deprecated
        public final void onAddresses(List<EquivalentAddressGroup> list, Attributes attributes) {
            onResult(ResolutionResult.newBuilder().setAddresses(list).setAttributes(attributes).build());
        }

        @Override // io.grpc.NameResolver.Listener
        public abstract void onError(Status status);

        public abstract void onResult(ResolutionResult resolutionResult);
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/NameResolver$ResolutionResult.class */
    public static final class ResolutionResult {
        private final List<EquivalentAddressGroup> addresses;
        private final Attributes attributes;
        @Nullable
        private final ConfigOrError serviceConfig;

        /* loaded from: source-8829756-dex2jar.jar:io/grpc/NameResolver$ResolutionResult$Builder.class */
        public static final class Builder {
            private List<EquivalentAddressGroup> addresses = Collections.emptyList();
            private Attributes attributes = Attributes.EMPTY;
            @Nullable
            private ConfigOrError serviceConfig;

            Builder() {
            }

            public ResolutionResult build() {
                return new ResolutionResult(this.addresses, this.attributes, this.serviceConfig);
            }

            public Builder setAddresses(List<EquivalentAddressGroup> list) {
                this.addresses = list;
                return this;
            }

            public Builder setAttributes(Attributes attributes) {
                this.attributes = attributes;
                return this;
            }

            public Builder setServiceConfig(@Nullable ConfigOrError configOrError) {
                this.serviceConfig = configOrError;
                return this;
            }
        }

        ResolutionResult(List<EquivalentAddressGroup> list, Attributes attributes, ConfigOrError configOrError) {
            this.addresses = Collections.unmodifiableList(new ArrayList(list));
            this.attributes = (Attributes) Preconditions.checkNotNull(attributes, "attributes");
            this.serviceConfig = configOrError;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (obj instanceof ResolutionResult) {
                ResolutionResult resolutionResult = (ResolutionResult) obj;
                boolean z = false;
                if (Objects.equal(this.addresses, resolutionResult.addresses)) {
                    z = false;
                    if (Objects.equal(this.attributes, resolutionResult.attributes)) {
                        z = false;
                        if (Objects.equal(this.serviceConfig, resolutionResult.serviceConfig)) {
                            z = true;
                        }
                    }
                }
                return z;
            }
            return false;
        }

        public List<EquivalentAddressGroup> getAddresses() {
            return this.addresses;
        }

        public Attributes getAttributes() {
            return this.attributes;
        }

        @Nullable
        public ConfigOrError getServiceConfig() {
            return this.serviceConfig;
        }

        public int hashCode() {
            return Objects.hashCode(this.addresses, this.attributes, this.serviceConfig);
        }

        public Builder toBuilder() {
            return newBuilder().setAddresses(this.addresses).setAttributes(this.attributes).setServiceConfig(this.serviceConfig);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("addresses", this.addresses).add("attributes", this.attributes).add("serviceConfig", this.serviceConfig).toString();
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8829756-dex2jar.jar:io/grpc/NameResolver$ResolutionResultAttr.class */
    public @interface ResolutionResultAttr {
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/NameResolver$ServiceConfigParser.class */
    public static abstract class ServiceConfigParser {
        public abstract ConfigOrError parseServiceConfig(Map<String, ?> map);
    }

    public abstract String getServiceAuthority();

    public void refresh() {
    }

    public abstract void shutdown();

    public void start(Listener2 listener2) {
        start((Listener) listener2);
    }

    public void start(final Listener listener) {
        if (listener instanceof Listener2) {
            start((Listener2) listener);
        } else {
            start(new Listener2() { // from class: io.grpc.NameResolver.1
                @Override // io.grpc.NameResolver.Listener2, io.grpc.NameResolver.Listener
                public void onError(Status status) {
                    listener.onError(status);
                }

                @Override // io.grpc.NameResolver.Listener2
                public void onResult(ResolutionResult resolutionResult) {
                    listener.onAddresses(resolutionResult.getAddresses(), resolutionResult.getAttributes());
                }
            });
        }
    }
}
