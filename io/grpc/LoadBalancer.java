package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ClientStreamTracer;
import io.grpc.NameResolver;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/LoadBalancer.class */
public abstract class LoadBalancer {
    private int recursionCount;
    @Deprecated
    public static final Attributes.Key<Map<String, ?>> ATTR_LOAD_BALANCING_CONFIG = Attributes.Key.create("io.grpc.LoadBalancer.loadBalancingConfig");
    public static final Attributes.Key<Map<String, ?>> ATTR_HEALTH_CHECKING_CONFIG = Attributes.Key.create("health-checking-config");

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/LoadBalancer$CreateSubchannelArgs.class */
    public static final class CreateSubchannelArgs {
        private final List<EquivalentAddressGroup> addrs;
        private final Attributes attrs;
        private final Object[][] customOptions;

        /* loaded from: source-8829756-dex2jar.jar:io/grpc/LoadBalancer$CreateSubchannelArgs$Builder.class */
        public static final class Builder {
            private List<EquivalentAddressGroup> addrs;
            private Attributes attrs = Attributes.EMPTY;
            private Object[][] customOptions = (Object[][]) Array.newInstance(Object.class, 0, 2);

            Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public <T> Builder copyCustomOptions(Object[][] objArr) {
                Object[][] objArr2 = (Object[][]) Array.newInstance(Object.class, objArr.length, 2);
                this.customOptions = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                return this;
            }

            public <T> Builder addOption(Key<T> key, T t) {
                int i;
                Preconditions.checkNotNull(key, "key");
                Preconditions.checkNotNull(t, "value");
                int i2 = 0;
                while (true) {
                    i = i2;
                    Object[][] objArr = this.customOptions;
                    if (i >= objArr.length) {
                        i = -1;
                        break;
                    } else if (key.equals(objArr[i][0])) {
                        break;
                    } else {
                        i2 = i + 1;
                    }
                }
                int i3 = i;
                if (i == -1) {
                    Object[][] objArr2 = (Object[][]) Array.newInstance(Object.class, this.customOptions.length + 1, 2);
                    Object[][] objArr3 = this.customOptions;
                    System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
                    this.customOptions = objArr2;
                    i3 = objArr2.length - 1;
                }
                Object[] objArr4 = new Object[2];
                objArr4[0] = key;
                objArr4[1] = t;
                this.customOptions[i3] = objArr4;
                return this;
            }

            public CreateSubchannelArgs build() {
                return new CreateSubchannelArgs(this.addrs, this.attrs, this.customOptions);
            }

            public Builder setAddresses(EquivalentAddressGroup equivalentAddressGroup) {
                this.addrs = Collections.singletonList(equivalentAddressGroup);
                return this;
            }

            public Builder setAddresses(List<EquivalentAddressGroup> list) {
                Preconditions.checkArgument(!list.isEmpty(), "addrs is empty");
                this.addrs = Collections.unmodifiableList(new ArrayList(list));
                return this;
            }

            public Builder setAttributes(Attributes attributes) {
                this.attrs = (Attributes) Preconditions.checkNotNull(attributes, "attrs");
                return this;
            }
        }

        /* loaded from: source-8829756-dex2jar.jar:io/grpc/LoadBalancer$CreateSubchannelArgs$Key.class */
        public static final class Key<T> {
            private final String debugString;
            private final T defaultValue;

            private Key(String str, T t) {
                this.debugString = str;
                this.defaultValue = t;
            }

            public static <T> Key<T> create(String str) {
                Preconditions.checkNotNull(str, "debugString");
                return new Key<>(str, null);
            }

            public static <T> Key<T> createWithDefault(String str, T t) {
                Preconditions.checkNotNull(str, "debugString");
                return new Key<>(str, t);
            }

            public T getDefault() {
                return this.defaultValue;
            }

            public String toString() {
                return this.debugString;
            }
        }

        private CreateSubchannelArgs(List<EquivalentAddressGroup> list, Attributes attributes, Object[][] objArr) {
            this.addrs = (List) Preconditions.checkNotNull(list, "addresses are not set");
            this.attrs = (Attributes) Preconditions.checkNotNull(attributes, "attrs");
            this.customOptions = (Object[][]) Preconditions.checkNotNull(objArr, "customOptions");
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public List<EquivalentAddressGroup> getAddresses() {
            return this.addrs;
        }

        public Attributes getAttributes() {
            return this.attrs;
        }

        public <T> T getOption(Key<T> key) {
            Preconditions.checkNotNull(key, "key");
            int i = 0;
            while (true) {
                int i2 = i;
                Object[][] objArr = this.customOptions;
                if (i2 >= objArr.length) {
                    return (T) ((Key) key).defaultValue;
                }
                if (key.equals(objArr[i2][0])) {
                    return (T) this.customOptions[i2][1];
                }
                i = i2 + 1;
            }
        }

        public Builder toBuilder() {
            return newBuilder().setAddresses(this.addrs).setAttributes(this.attrs).copyCustomOptions(this.customOptions);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("addrs", this.addrs).add("attrs", this.attrs).add("customOptions", Arrays.deepToString(this.customOptions)).toString();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/LoadBalancer$Factory.class */
    public static abstract class Factory {
        public abstract LoadBalancer newLoadBalancer(Helper helper);
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/LoadBalancer$Helper.class */
    public static abstract class Helper {
        public abstract ManagedChannel createOobChannel(EquivalentAddressGroup equivalentAddressGroup, String str);

        public ManagedChannel createResolvingOobChannel(String str) {
            return createResolvingOobChannelBuilder(str).build();
        }

        public ManagedChannelBuilder<?> createResolvingOobChannelBuilder(String str) {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Deprecated
        public final Subchannel createSubchannel(EquivalentAddressGroup equivalentAddressGroup, Attributes attributes) {
            Preconditions.checkNotNull(equivalentAddressGroup, "addrs");
            return createSubchannel(Collections.singletonList(equivalentAddressGroup), attributes);
        }

        public Subchannel createSubchannel(CreateSubchannelArgs createSubchannelArgs) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public Subchannel createSubchannel(List<EquivalentAddressGroup> list, Attributes attributes) {
            throw new UnsupportedOperationException();
        }

        public abstract String getAuthority();

        public ChannelLogger getChannelLogger() {
            throw new UnsupportedOperationException();
        }

        public NameResolver.Args getNameResolverArgs() {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public abstract NameResolver.Factory getNameResolverFactory();

        public NameResolverRegistry getNameResolverRegistry() {
            throw new UnsupportedOperationException();
        }

        public ScheduledExecutorService getScheduledExecutorService() {
            throw new UnsupportedOperationException();
        }

        public SynchronizationContext getSynchronizationContext() {
            throw new UnsupportedOperationException();
        }

        public void refreshNameResolution() {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public void runSerialized(Runnable runnable) {
            getSynchronizationContext().execute(runnable);
        }

        public abstract void updateBalancingState(@Nonnull ConnectivityState connectivityState, @Nonnull SubchannelPicker subchannelPicker);

        public void updateOobChannelAddresses(ManagedChannel managedChannel, EquivalentAddressGroup equivalentAddressGroup) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public final void updateSubchannelAddresses(Subchannel subchannel, EquivalentAddressGroup equivalentAddressGroup) {
            Preconditions.checkNotNull(equivalentAddressGroup, "addrs");
            updateSubchannelAddresses(subchannel, Collections.singletonList(equivalentAddressGroup));
        }

        @Deprecated
        public void updateSubchannelAddresses(Subchannel subchannel, List<EquivalentAddressGroup> list) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/LoadBalancer$PickResult.class */
    public static final class PickResult {
        private static final PickResult NO_RESULT = new PickResult(null, null, Status.OK, false);
        private final boolean drop;
        private final Status status;
        @Nullable
        private final ClientStreamTracer.Factory streamTracerFactory;
        @Nullable
        private final Subchannel subchannel;

        private PickResult(@Nullable Subchannel subchannel, @Nullable ClientStreamTracer.Factory factory, Status status, boolean z) {
            this.subchannel = subchannel;
            this.streamTracerFactory = factory;
            this.status = (Status) Preconditions.checkNotNull(status, "status");
            this.drop = z;
        }

        public static PickResult withDrop(Status status) {
            Preconditions.checkArgument(!status.isOk(), "drop status shouldn't be OK");
            return new PickResult(null, null, status, true);
        }

        public static PickResult withError(Status status) {
            Preconditions.checkArgument(!status.isOk(), "error status shouldn't be OK");
            return new PickResult(null, null, status, false);
        }

        public static PickResult withNoResult() {
            return NO_RESULT;
        }

        public static PickResult withSubchannel(Subchannel subchannel) {
            return withSubchannel(subchannel, null);
        }

        public static PickResult withSubchannel(Subchannel subchannel, @Nullable ClientStreamTracer.Factory factory) {
            return new PickResult((Subchannel) Preconditions.checkNotNull(subchannel, "subchannel"), factory, Status.OK, false);
        }

        public boolean equals(Object obj) {
            if (obj instanceof PickResult) {
                PickResult pickResult = (PickResult) obj;
                boolean z = false;
                if (Objects.equal(this.subchannel, pickResult.subchannel)) {
                    z = false;
                    if (Objects.equal(this.status, pickResult.status)) {
                        z = false;
                        if (Objects.equal(this.streamTracerFactory, pickResult.streamTracerFactory)) {
                            z = false;
                            if (this.drop == pickResult.drop) {
                                z = true;
                            }
                        }
                    }
                }
                return z;
            }
            return false;
        }

        public Status getStatus() {
            return this.status;
        }

        @Nullable
        public ClientStreamTracer.Factory getStreamTracerFactory() {
            return this.streamTracerFactory;
        }

        @Nullable
        public Subchannel getSubchannel() {
            return this.subchannel;
        }

        public int hashCode() {
            return Objects.hashCode(this.subchannel, this.status, this.streamTracerFactory, Boolean.valueOf(this.drop));
        }

        public boolean isDrop() {
            return this.drop;
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("subchannel", this.subchannel).add("streamTracerFactory", this.streamTracerFactory).add("status", this.status).add("drop", this.drop).toString();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/LoadBalancer$PickSubchannelArgs.class */
    public static abstract class PickSubchannelArgs {
        public abstract CallOptions getCallOptions();

        public abstract Metadata getHeaders();

        public abstract MethodDescriptor<?, ?> getMethodDescriptor();
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/LoadBalancer$ResolvedAddresses.class */
    public static final class ResolvedAddresses {
        private final List<EquivalentAddressGroup> addresses;
        private final Attributes attributes;
        @Nullable
        private final Object loadBalancingPolicyConfig;

        /* loaded from: source-8829756-dex2jar.jar:io/grpc/LoadBalancer$ResolvedAddresses$Builder.class */
        public static final class Builder {
            private List<EquivalentAddressGroup> addresses;
            private Attributes attributes = Attributes.EMPTY;
            @Nullable
            private Object loadBalancingPolicyConfig;

            Builder() {
            }

            public ResolvedAddresses build() {
                return new ResolvedAddresses(this.addresses, this.attributes, this.loadBalancingPolicyConfig);
            }

            public Builder setAddresses(List<EquivalentAddressGroup> list) {
                this.addresses = list;
                return this;
            }

            public Builder setAttributes(Attributes attributes) {
                this.attributes = attributes;
                return this;
            }

            public Builder setLoadBalancingPolicyConfig(@Nullable Object obj) {
                this.loadBalancingPolicyConfig = obj;
                return this;
            }
        }

        private ResolvedAddresses(List<EquivalentAddressGroup> list, Attributes attributes, Object obj) {
            this.addresses = Collections.unmodifiableList(new ArrayList((Collection) Preconditions.checkNotNull(list, "addresses")));
            this.attributes = (Attributes) Preconditions.checkNotNull(attributes, "attributes");
            this.loadBalancingPolicyConfig = obj;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (obj instanceof ResolvedAddresses) {
                ResolvedAddresses resolvedAddresses = (ResolvedAddresses) obj;
                boolean z = false;
                if (Objects.equal(this.addresses, resolvedAddresses.addresses)) {
                    z = false;
                    if (Objects.equal(this.attributes, resolvedAddresses.attributes)) {
                        z = false;
                        if (Objects.equal(this.loadBalancingPolicyConfig, resolvedAddresses.loadBalancingPolicyConfig)) {
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
        public Object getLoadBalancingPolicyConfig() {
            return this.loadBalancingPolicyConfig;
        }

        public int hashCode() {
            return Objects.hashCode(this.addresses, this.attributes, this.loadBalancingPolicyConfig);
        }

        public Builder toBuilder() {
            return newBuilder().setAddresses(this.addresses).setAttributes(this.attributes).setLoadBalancingPolicyConfig(this.loadBalancingPolicyConfig);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("addresses", this.addresses).add("attributes", this.attributes).add("loadBalancingPolicyConfig", this.loadBalancingPolicyConfig).toString();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/LoadBalancer$Subchannel.class */
    public static abstract class Subchannel {
        public Channel asChannel() {
            throw new UnsupportedOperationException();
        }

        public final EquivalentAddressGroup getAddresses() {
            List<EquivalentAddressGroup> allAddresses = getAllAddresses();
            boolean z = true;
            if (allAddresses.size() != 1) {
                z = false;
            }
            Preconditions.checkState(z, "%s does not have exactly one group", allAddresses);
            return allAddresses.get(0);
        }

        public List<EquivalentAddressGroup> getAllAddresses() {
            throw new UnsupportedOperationException();
        }

        public abstract Attributes getAttributes();

        public ChannelLogger getChannelLogger() {
            throw new UnsupportedOperationException();
        }

        public Object getInternalSubchannel() {
            throw new UnsupportedOperationException();
        }

        public abstract void requestConnection();

        public abstract void shutdown();

        public void start(SubchannelStateListener subchannelStateListener) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public void updateAddresses(List<EquivalentAddressGroup> list) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/LoadBalancer$SubchannelPicker.class */
    public static abstract class SubchannelPicker {
        public abstract PickResult pickSubchannel(PickSubchannelArgs pickSubchannelArgs);

        @Deprecated
        public void requestConnection() {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/LoadBalancer$SubchannelStateListener.class */
    public interface SubchannelStateListener {
        void onSubchannelState(ConnectivityStateInfo connectivityStateInfo);
    }

    public boolean canHandleEmptyAddressListFromNameResolution() {
        return false;
    }

    public abstract void handleNameResolutionError(Status status);

    @Deprecated
    public void handleResolvedAddressGroups(List<EquivalentAddressGroup> list, Attributes attributes) {
        int i = this.recursionCount;
        this.recursionCount = i + 1;
        if (i == 0) {
            handleResolvedAddresses(ResolvedAddresses.newBuilder().setAddresses(list).setAttributes(attributes).build());
        }
        this.recursionCount = 0;
    }

    public void handleResolvedAddresses(ResolvedAddresses resolvedAddresses) {
        int i = this.recursionCount;
        this.recursionCount = i + 1;
        if (i == 0) {
            handleResolvedAddressGroups(resolvedAddresses.getAddresses(), resolvedAddresses.getAttributes());
        }
        this.recursionCount = 0;
    }

    @Deprecated
    public void handleSubchannelState(Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo) {
    }

    public void requestConnection() {
    }

    public abstract void shutdown();
}
