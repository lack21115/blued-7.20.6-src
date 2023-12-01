package io.grpc.util;

import com.google.common.base.MoreObjects;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import io.grpc.NameResolverRegistry;
import io.grpc.SynchronizationContext;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/util/ForwardingLoadBalancerHelper.class */
public abstract class ForwardingLoadBalancerHelper extends LoadBalancer.Helper {
    @Override // io.grpc.LoadBalancer.Helper
    public ManagedChannel createOobChannel(EquivalentAddressGroup equivalentAddressGroup, String str) {
        return delegate().createOobChannel(equivalentAddressGroup, str);
    }

    @Override // io.grpc.LoadBalancer.Helper
    public ManagedChannel createResolvingOobChannel(String str) {
        return delegate().createResolvingOobChannel(str);
    }

    @Override // io.grpc.LoadBalancer.Helper
    public ManagedChannelBuilder<?> createResolvingOobChannelBuilder(String str) {
        return delegate().createResolvingOobChannelBuilder(str);
    }

    @Override // io.grpc.LoadBalancer.Helper
    public LoadBalancer.Subchannel createSubchannel(LoadBalancer.CreateSubchannelArgs createSubchannelArgs) {
        return delegate().createSubchannel(createSubchannelArgs);
    }

    @Override // io.grpc.LoadBalancer.Helper
    @Deprecated
    public LoadBalancer.Subchannel createSubchannel(List<EquivalentAddressGroup> list, Attributes attributes) {
        return delegate().createSubchannel(list, attributes);
    }

    protected abstract LoadBalancer.Helper delegate();

    @Override // io.grpc.LoadBalancer.Helper
    public String getAuthority() {
        return delegate().getAuthority();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public ChannelLogger getChannelLogger() {
        return delegate().getChannelLogger();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public NameResolver.Args getNameResolverArgs() {
        return delegate().getNameResolverArgs();
    }

    @Override // io.grpc.LoadBalancer.Helper
    @Deprecated
    public NameResolver.Factory getNameResolverFactory() {
        return delegate().getNameResolverFactory();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public NameResolverRegistry getNameResolverRegistry() {
        return delegate().getNameResolverRegistry();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public ScheduledExecutorService getScheduledExecutorService() {
        return delegate().getScheduledExecutorService();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public SynchronizationContext getSynchronizationContext() {
        return delegate().getSynchronizationContext();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public void refreshNameResolution() {
        delegate().refreshNameResolution();
    }

    @Override // io.grpc.LoadBalancer.Helper
    @Deprecated
    public void runSerialized(Runnable runnable) {
        delegate().runSerialized(runnable);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public void updateBalancingState(ConnectivityState connectivityState, LoadBalancer.SubchannelPicker subchannelPicker) {
        delegate().updateBalancingState(connectivityState, subchannelPicker);
    }

    @Override // io.grpc.LoadBalancer.Helper
    public void updateOobChannelAddresses(ManagedChannel managedChannel, EquivalentAddressGroup equivalentAddressGroup) {
        delegate().updateOobChannelAddresses(managedChannel, equivalentAddressGroup);
    }

    @Override // io.grpc.LoadBalancer.Helper
    @Deprecated
    public void updateSubchannelAddresses(LoadBalancer.Subchannel subchannel, List<EquivalentAddressGroup> list) {
        delegate().updateSubchannelAddresses(subchannel, list);
    }
}
