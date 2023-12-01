package io.grpc.util;

import com.google.common.base.MoreObjects;
import io.grpc.Attributes;
import io.grpc.Channel;
import io.grpc.ChannelLogger;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import java.util.List;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/util/ForwardingSubchannel.class */
public abstract class ForwardingSubchannel extends LoadBalancer.Subchannel {
    public Channel asChannel() {
        return delegate().asChannel();
    }

    protected abstract LoadBalancer.Subchannel delegate();

    public List<EquivalentAddressGroup> getAllAddresses() {
        return delegate().getAllAddresses();
    }

    public Attributes getAttributes() {
        return delegate().getAttributes();
    }

    public ChannelLogger getChannelLogger() {
        return delegate().getChannelLogger();
    }

    public Object getInternalSubchannel() {
        return delegate().getInternalSubchannel();
    }

    public void requestConnection() {
        delegate().requestConnection();
    }

    public void shutdown() {
        delegate().shutdown();
    }

    public void start(LoadBalancer.SubchannelStateListener subchannelStateListener) {
        delegate().start(subchannelStateListener);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }

    public void updateAddresses(List<EquivalentAddressGroup> list) {
        delegate().updateAddresses(list);
    }
}
