package io.grpc.util;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import javax.annotation.Nonnull;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/util/RoundRobinLoadBalancer.class */
final class RoundRobinLoadBalancer extends LoadBalancer {
    private ConnectivityState currentState;
    private final LoadBalancer.Helper helper;
    static final Attributes.Key<Ref<ConnectivityStateInfo>> STATE_INFO = Attributes.Key.create("state-info");
    private static final Status EMPTY_OK = Status.OK.withDescription("no subchannels ready");
    private final Map<EquivalentAddressGroup, LoadBalancer.Subchannel> subchannels = new HashMap();
    private RoundRobinPicker currentPicker = new EmptyPicker(EMPTY_OK);
    private final Random random = new Random();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/util/RoundRobinLoadBalancer$EmptyPicker.class */
    public static final class EmptyPicker extends RoundRobinPicker {
        private final Status status;

        EmptyPicker(@Nonnull Status status) {
            super();
            this.status = (Status) Preconditions.checkNotNull(status, "status");
        }

        @Override // io.grpc.util.RoundRobinLoadBalancer.RoundRobinPicker
        boolean isEquivalentTo(RoundRobinPicker roundRobinPicker) {
            if (roundRobinPicker instanceof EmptyPicker) {
                EmptyPicker emptyPicker = (EmptyPicker) roundRobinPicker;
                if (Objects.equal(this.status, emptyPicker.status)) {
                    return true;
                }
                return this.status.isOk() && emptyPicker.status.isOk();
            }
            return false;
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return this.status.isOk() ? LoadBalancer.PickResult.withNoResult() : LoadBalancer.PickResult.withError(this.status);
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) EmptyPicker.class).add("status", this.status).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/util/RoundRobinLoadBalancer$ReadyPicker.class */
    public static final class ReadyPicker extends RoundRobinPicker {
        private static final AtomicIntegerFieldUpdater<ReadyPicker> indexUpdater = AtomicIntegerFieldUpdater.newUpdater(ReadyPicker.class, "index");
        private volatile int index;
        private final List<LoadBalancer.Subchannel> list;

        ReadyPicker(List<LoadBalancer.Subchannel> list, int i) {
            super();
            Preconditions.checkArgument(!list.isEmpty(), "empty list");
            this.list = list;
            this.index = i - 1;
        }

        private LoadBalancer.Subchannel nextSubchannel() {
            int size = this.list.size();
            int incrementAndGet = indexUpdater.incrementAndGet(this);
            int i = incrementAndGet;
            if (incrementAndGet >= size) {
                i = incrementAndGet % size;
                indexUpdater.compareAndSet(this, incrementAndGet, i);
            }
            return this.list.get(i);
        }

        List<LoadBalancer.Subchannel> getList() {
            return this.list;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0042, code lost:
            if (new java.util.HashSet(r4.list).containsAll(r0.list) != false) goto L13;
         */
        @Override // io.grpc.util.RoundRobinLoadBalancer.RoundRobinPicker
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean isEquivalentTo(io.grpc.util.RoundRobinLoadBalancer.RoundRobinPicker r5) {
            /*
                r4 = this;
                r0 = r5
                boolean r0 = r0 instanceof io.grpc.util.RoundRobinLoadBalancer.ReadyPicker
                r6 = r0
                r0 = 0
                r7 = r0
                r0 = r6
                if (r0 != 0) goto Ld
                r0 = 0
                return r0
            Ld:
                r0 = r5
                io.grpc.util.RoundRobinLoadBalancer$ReadyPicker r0 = (io.grpc.util.RoundRobinLoadBalancer.ReadyPicker) r0
                r5 = r0
                r0 = r5
                r1 = r4
                if (r0 == r1) goto L45
                r0 = r7
                r6 = r0
                r0 = r4
                java.util.List<io.grpc.LoadBalancer$Subchannel> r0 = r0.list
                int r0 = r0.size()
                r1 = r5
                java.util.List<io.grpc.LoadBalancer$Subchannel> r1 = r1.list
                int r1 = r1.size()
                if (r0 != r1) goto L47
                r0 = r7
                r6 = r0
                java.util.HashSet r0 = new java.util.HashSet
                r1 = r0
                r2 = r4
                java.util.List<io.grpc.LoadBalancer$Subchannel> r2 = r2.list
                r1.<init>(r2)
                r1 = r5
                java.util.List<io.grpc.LoadBalancer$Subchannel> r1 = r1.list
                boolean r0 = r0.containsAll(r1)
                if (r0 == 0) goto L47
            L45:
                r0 = 1
                r6 = r0
            L47:
                r0 = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.util.RoundRobinLoadBalancer.ReadyPicker.isEquivalentTo(io.grpc.util.RoundRobinLoadBalancer$RoundRobinPicker):boolean");
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return LoadBalancer.PickResult.withSubchannel(nextSubchannel());
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) ReadyPicker.class).add("list", this.list).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/util/RoundRobinLoadBalancer$Ref.class */
    public static final class Ref<T> {
        T value;

        Ref(T t) {
            this.value = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/util/RoundRobinLoadBalancer$RoundRobinPicker.class */
    public static abstract class RoundRobinPicker extends LoadBalancer.SubchannelPicker {
        private RoundRobinPicker() {
        }

        abstract boolean isEquivalentTo(RoundRobinPicker roundRobinPicker);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoundRobinLoadBalancer(LoadBalancer.Helper helper) {
        this.helper = (LoadBalancer.Helper) Preconditions.checkNotNull(helper, "helper");
    }

    private static List<LoadBalancer.Subchannel> filterNonFailingSubchannels(Collection<LoadBalancer.Subchannel> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (LoadBalancer.Subchannel subchannel : collection) {
            if (isReady(subchannel)) {
                arrayList.add(subchannel);
            }
        }
        return arrayList;
    }

    private static Ref<ConnectivityStateInfo> getSubchannelStateInfoRef(LoadBalancer.Subchannel subchannel) {
        return (Ref) Preconditions.checkNotNull(subchannel.getAttributes().get(STATE_INFO), "STATE_INFO");
    }

    static boolean isReady(LoadBalancer.Subchannel subchannel) {
        return getSubchannelStateInfoRef(subchannel).value.getState() == ConnectivityState.READY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void processSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo) {
        if (this.subchannels.get(stripAttrs(subchannel.getAddresses())) != subchannel) {
            return;
        }
        if (connectivityStateInfo.getState() == ConnectivityState.IDLE) {
            subchannel.requestConnection();
        }
        Ref<ConnectivityStateInfo> subchannelStateInfoRef = getSubchannelStateInfoRef(subchannel);
        if (subchannelStateInfoRef.value.getState().equals(ConnectivityState.TRANSIENT_FAILURE) && (connectivityStateInfo.getState().equals(ConnectivityState.CONNECTING) || connectivityStateInfo.getState().equals(ConnectivityState.IDLE))) {
            return;
        }
        subchannelStateInfoRef.value = connectivityStateInfo;
        updateBalancingState();
    }

    private static <T> Set<T> setsDifference(Set<T> set, Set<T> set2) {
        HashSet hashSet = new HashSet(set);
        hashSet.removeAll(set2);
        return hashSet;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, io.grpc.ConnectivityStateInfo] */
    private void shutdownSubchannel(LoadBalancer.Subchannel subchannel) {
        subchannel.shutdown();
        getSubchannelStateInfoRef(subchannel).value = ConnectivityStateInfo.forNonError(ConnectivityState.SHUTDOWN);
    }

    private static EquivalentAddressGroup stripAttrs(EquivalentAddressGroup equivalentAddressGroup) {
        return new EquivalentAddressGroup(equivalentAddressGroup.getAddresses());
    }

    private static Map<EquivalentAddressGroup, EquivalentAddressGroup> stripAttrs(List<EquivalentAddressGroup> list) {
        HashMap hashMap = new HashMap(list.size() * 2);
        for (EquivalentAddressGroup equivalentAddressGroup : list) {
            hashMap.put(stripAttrs(equivalentAddressGroup), equivalentAddressGroup);
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0056, code lost:
        if (r0.getState() == io.grpc.ConnectivityState.IDLE) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void updateBalancingState() {
        /*
            r7 = this;
            r0 = r7
            java.util.Collection r0 = r0.getSubchannels()
            java.util.List r0 = filterNonFailingSubchannels(r0)
            r10 = r0
            r0 = r10
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L96
            r0 = 0
            r8 = r0
            io.grpc.Status r0 = io.grpc.util.RoundRobinLoadBalancer.EMPTY_OK
            r10 = r0
            r0 = r7
            java.util.Collection r0 = r0.getSubchannels()
            java.util.Iterator r0 = r0.iterator()
            r11 = r0
        L22:
            r0 = r11
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L76
            r0 = r11
            java.lang.Object r0 = r0.next()
            io.grpc.LoadBalancer$Subchannel r0 = (io.grpc.LoadBalancer.Subchannel) r0
            io.grpc.util.RoundRobinLoadBalancer$Ref r0 = getSubchannelStateInfoRef(r0)
            T r0 = r0.value
            io.grpc.ConnectivityStateInfo r0 = (io.grpc.ConnectivityStateInfo) r0
            r12 = r0
            r0 = r12
            io.grpc.ConnectivityState r0 = r0.getState()
            io.grpc.ConnectivityState r1 = io.grpc.ConnectivityState.CONNECTING
            if (r0 == r1) goto L59
            r0 = r8
            r9 = r0
            r0 = r12
            io.grpc.ConnectivityState r0 = r0.getState()
            io.grpc.ConnectivityState r1 = io.grpc.ConnectivityState.IDLE
            if (r0 != r1) goto L5b
        L59:
            r0 = 1
            r9 = r0
        L5b:
            r0 = r10
            io.grpc.Status r1 = io.grpc.util.RoundRobinLoadBalancer.EMPTY_OK
            if (r0 == r1) goto L6b
            r0 = r9
            r8 = r0
            r0 = r10
            boolean r0 = r0.isOk()
            if (r0 != 0) goto L22
        L6b:
            r0 = r12
            io.grpc.Status r0 = r0.getStatus()
            r10 = r0
            r0 = r9
            r8 = r0
            goto L22
        L76:
            r0 = r8
            if (r0 == 0) goto L82
            io.grpc.ConnectivityState r0 = io.grpc.ConnectivityState.CONNECTING
            r11 = r0
            goto L87
        L82:
            io.grpc.ConnectivityState r0 = io.grpc.ConnectivityState.TRANSIENT_FAILURE
            r11 = r0
        L87:
            r0 = r7
            r1 = r11
            io.grpc.util.RoundRobinLoadBalancer$EmptyPicker r2 = new io.grpc.util.RoundRobinLoadBalancer$EmptyPicker
            r3 = r2
            r4 = r10
            r3.<init>(r4)
            r0.updateBalancingState(r1, r2)
            return
        L96:
            r0 = r7
            java.util.Random r0 = r0.random
            r1 = r10
            int r1 = r1.size()
            int r0 = r0.nextInt(r1)
            r8 = r0
            r0 = r7
            io.grpc.ConnectivityState r1 = io.grpc.ConnectivityState.READY
            io.grpc.util.RoundRobinLoadBalancer$ReadyPicker r2 = new io.grpc.util.RoundRobinLoadBalancer$ReadyPicker
            r3 = r2
            r4 = r10
            r5 = r8
            r3.<init>(r4, r5)
            r0.updateBalancingState(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.util.RoundRobinLoadBalancer.updateBalancingState():void");
    }

    private void updateBalancingState(ConnectivityState connectivityState, RoundRobinPicker roundRobinPicker) {
        if (connectivityState == this.currentState && roundRobinPicker.isEquivalentTo(this.currentPicker)) {
            return;
        }
        this.helper.updateBalancingState(connectivityState, roundRobinPicker);
        this.currentState = connectivityState;
        this.currentPicker = roundRobinPicker;
    }

    Collection<LoadBalancer.Subchannel> getSubchannels() {
        return this.subchannels.values();
    }

    @Override // io.grpc.LoadBalancer
    public void handleNameResolutionError(Status status) {
        ConnectivityState connectivityState = ConnectivityState.TRANSIENT_FAILURE;
        RoundRobinPicker roundRobinPicker = this.currentPicker;
        updateBalancingState(connectivityState, roundRobinPicker instanceof ReadyPicker ? roundRobinPicker : new EmptyPicker(status));
    }

    @Override // io.grpc.LoadBalancer
    public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        List<EquivalentAddressGroup> addresses = resolvedAddresses.getAddresses();
        Set<EquivalentAddressGroup> keySet = this.subchannels.keySet();
        Map<EquivalentAddressGroup, EquivalentAddressGroup> stripAttrs = stripAttrs(addresses);
        Set<EquivalentAddressGroup> set = setsDifference(keySet, stripAttrs.keySet());
        for (Map.Entry<EquivalentAddressGroup, EquivalentAddressGroup> entry : stripAttrs.entrySet()) {
            EquivalentAddressGroup key = entry.getKey();
            EquivalentAddressGroup value = entry.getValue();
            LoadBalancer.Subchannel subchannel = this.subchannels.get(key);
            if (subchannel != null) {
                subchannel.updateAddresses(Collections.singletonList(value));
            } else {
                final LoadBalancer.Subchannel subchannel2 = (LoadBalancer.Subchannel) Preconditions.checkNotNull(this.helper.createSubchannel(LoadBalancer.CreateSubchannelArgs.newBuilder().setAddresses(value).setAttributes(Attributes.newBuilder().set(STATE_INFO, new Ref(ConnectivityStateInfo.forNonError(ConnectivityState.IDLE))).build()).build()), "subchannel");
                subchannel2.start(new LoadBalancer.SubchannelStateListener() { // from class: io.grpc.util.RoundRobinLoadBalancer.1
                    @Override // io.grpc.LoadBalancer.SubchannelStateListener
                    public void onSubchannelState(ConnectivityStateInfo connectivityStateInfo) {
                        RoundRobinLoadBalancer.this.processSubchannelState(subchannel2, connectivityStateInfo);
                    }
                });
                this.subchannels.put(key, subchannel2);
                subchannel2.requestConnection();
            }
        }
        ArrayList arrayList = new ArrayList();
        for (EquivalentAddressGroup equivalentAddressGroup : set) {
            arrayList.add(this.subchannels.remove(equivalentAddressGroup));
        }
        updateBalancingState();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            shutdownSubchannel((LoadBalancer.Subchannel) it.next());
        }
    }

    @Override // io.grpc.LoadBalancer
    public void shutdown() {
        for (LoadBalancer.Subchannel subchannel : getSubchannels()) {
            shutdownSubchannel(subchannel);
        }
    }
}
