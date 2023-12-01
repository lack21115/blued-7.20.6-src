package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.ElementOrder;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/DirectedGraphConnections.class */
public final class DirectedGraphConnections<N, V> implements GraphConnections<N, V> {
    private static final Object PRED = new Object();
    private final Map<N, Object> adjacentNodeValues;
    @NullableDecl
    private final List<NodeConnection<N>> orderedNodeConnections;
    private int predecessorCount;
    private int successorCount;

    /* renamed from: com.google.common.graph.DirectedGraphConnections$8  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/DirectedGraphConnections$8.class */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$graph$ElementOrder$Type;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[ElementOrder.Type.values().length];
            $SwitchMap$com$google$common$graph$ElementOrder$Type = iArr;
            try {
                iArr[ElementOrder.Type.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$common$graph$ElementOrder$Type[ElementOrder.Type.STABLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/DirectedGraphConnections$NodeConnection.class */
    public static abstract class NodeConnection<N> {
        final N node;

        /* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/DirectedGraphConnections$NodeConnection$Pred.class */
        static final class Pred<N> extends NodeConnection<N> {
            Pred(N n) {
                super(n);
            }

            public boolean equals(Object obj) {
                if (obj instanceof Pred) {
                    return this.node.equals(((Pred) obj).node);
                }
                return false;
            }

            public int hashCode() {
                return Pred.class.hashCode() + this.node.hashCode();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/DirectedGraphConnections$NodeConnection$Succ.class */
        public static final class Succ<N> extends NodeConnection<N> {
            Succ(N n) {
                super(n);
            }

            public boolean equals(Object obj) {
                if (obj instanceof Succ) {
                    return this.node.equals(((Succ) obj).node);
                }
                return false;
            }

            public int hashCode() {
                return Succ.class.hashCode() + this.node.hashCode();
            }
        }

        NodeConnection(N n) {
            this.node = (N) Preconditions.checkNotNull(n);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/DirectedGraphConnections$PredAndSucc.class */
    public static final class PredAndSucc {
        private final Object successorValue;

        PredAndSucc(Object obj) {
            this.successorValue = obj;
        }
    }

    private DirectedGraphConnections(Map<N, Object> map, @NullableDecl List<NodeConnection<N>> list, int i, int i2) {
        this.adjacentNodeValues = (Map) Preconditions.checkNotNull(map);
        this.orderedNodeConnections = list;
        this.predecessorCount = Graphs.checkNonNegative(i);
        this.successorCount = Graphs.checkNonNegative(i2);
        Preconditions.checkState(i <= map.size() && i2 <= map.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isPredecessor(@NullableDecl Object obj) {
        return obj == PRED || (obj instanceof PredAndSucc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSuccessor(@NullableDecl Object obj) {
        return (obj == PRED || obj == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <N, V> DirectedGraphConnections<N, V> of(ElementOrder<N> elementOrder) {
        ArrayList arrayList;
        int i = AnonymousClass8.$SwitchMap$com$google$common$graph$ElementOrder$Type[elementOrder.type().ordinal()];
        if (i == 1) {
            arrayList = null;
        } else if (i != 2) {
            throw new AssertionError(elementOrder.type());
        } else {
            arrayList = new ArrayList();
        }
        return new DirectedGraphConnections<>(new HashMap(4, 1.0f), arrayList, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <N, V> DirectedGraphConnections<N, V> ofImmutable(N n, Iterable<EndpointPair<N>> iterable, Function<N, V> function) {
        Preconditions.checkNotNull(n);
        Preconditions.checkNotNull(function);
        HashMap hashMap = new HashMap();
        ImmutableList.Builder builder = ImmutableList.builder();
        int i = 0;
        int i2 = 0;
        for (EndpointPair<N> endpointPair : iterable) {
            if (endpointPair.nodeU().equals(n) && endpointPair.nodeV().equals(n)) {
                hashMap.put(n, new PredAndSucc(function.apply(n)));
                builder.add((ImmutableList.Builder) new NodeConnection.Pred(n));
                builder.add((ImmutableList.Builder) new NodeConnection.Succ(n));
                i++;
            } else if (endpointPair.nodeV().equals(n)) {
                N nodeU = endpointPair.nodeU();
                Object put = hashMap.put(nodeU, PRED);
                if (put != null) {
                    hashMap.put(nodeU, new PredAndSucc(put));
                }
                builder.add((ImmutableList.Builder) new NodeConnection.Pred(nodeU));
                i++;
            } else {
                Preconditions.checkArgument(endpointPair.nodeU().equals(n));
                N nodeV = endpointPair.nodeV();
                V apply = function.apply(nodeV);
                Object put2 = hashMap.put(nodeV, apply);
                if (put2 != null) {
                    Preconditions.checkArgument(put2 == PRED);
                    hashMap.put(nodeV, new PredAndSucc(apply));
                }
                builder.add((ImmutableList.Builder) new NodeConnection.Succ(nodeV));
            }
            i2++;
        }
        return new DirectedGraphConnections<>(hashMap, builder.build(), i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // com.google.common.graph.GraphConnections
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addPredecessor(N r7, V r8) {
        /*
            r6 = this;
            r0 = r6
            java.util.Map<N, java.lang.Object> r0 = r0.adjacentNodeValues
            r1 = r7
            java.lang.Object r2 = com.google.common.graph.DirectedGraphConnections.PRED
            java.lang.Object r0 = r0.put(r1, r2)
            r8 = r0
            r0 = 0
            r9 = r0
            r0 = r8
            if (r0 != 0) goto L19
        L14:
            r0 = 1
            r9 = r0
            goto L4c
        L19:
            r0 = r8
            boolean r0 = r0 instanceof com.google.common.graph.DirectedGraphConnections.PredAndSucc
            if (r0 == 0) goto L2f
            r0 = r6
            java.util.Map<N, java.lang.Object> r0 = r0.adjacentNodeValues
            r1 = r7
            r2 = r8
            java.lang.Object r0 = r0.put(r1, r2)
            goto L4c
        L2f:
            r0 = r8
            java.lang.Object r1 = com.google.common.graph.DirectedGraphConnections.PRED
            if (r0 == r1) goto L4c
            r0 = r6
            java.util.Map<N, java.lang.Object> r0 = r0.adjacentNodeValues
            r1 = r7
            com.google.common.graph.DirectedGraphConnections$PredAndSucc r2 = new com.google.common.graph.DirectedGraphConnections$PredAndSucc
            r3 = r2
            r4 = r8
            r3.<init>(r4)
            java.lang.Object r0 = r0.put(r1, r2)
            goto L14
        L4c:
            r0 = r9
            if (r0 == 0) goto L79
            r0 = r6
            int r0 = r0.predecessorCount
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            r0 = r6
            r1 = r9
            r0.predecessorCount = r1
            r0 = r9
            int r0 = com.google.common.graph.Graphs.checkPositive(r0)
            r0 = r6
            java.util.List<com.google.common.graph.DirectedGraphConnections$NodeConnection<N>> r0 = r0.orderedNodeConnections
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L79
            r0 = r8
            com.google.common.graph.DirectedGraphConnections$NodeConnection$Pred r1 = new com.google.common.graph.DirectedGraphConnections$NodeConnection$Pred
            r2 = r1
            r3 = r7
            r2.<init>(r3)
            boolean r0 = r0.add(r1)
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.DirectedGraphConnections.addPredecessor(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    @Override // com.google.common.graph.GraphConnections
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V addSuccessor(N r7, V r8) {
        /*
            r6 = this;
            r0 = r6
            java.util.Map<N, java.lang.Object> r0 = r0.adjacentNodeValues
            r1 = r7
            r2 = r8
            java.lang.Object r0 = r0.put(r1, r2)
            r11 = r0
            r0 = r11
            if (r0 != 0) goto L18
        L12:
            r0 = 0
            r10 = r0
            goto L62
        L18:
            r0 = r11
            boolean r0 = r0 instanceof com.google.common.graph.DirectedGraphConnections.PredAndSucc
            if (r0 == 0) goto L40
            r0 = r6
            java.util.Map<N, java.lang.Object> r0 = r0.adjacentNodeValues
            r1 = r7
            com.google.common.graph.DirectedGraphConnections$PredAndSucc r2 = new com.google.common.graph.DirectedGraphConnections$PredAndSucc
            r3 = r2
            r4 = r8
            r3.<init>(r4)
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r11
            com.google.common.graph.DirectedGraphConnections$PredAndSucc r0 = (com.google.common.graph.DirectedGraphConnections.PredAndSucc) r0
            java.lang.Object r0 = com.google.common.graph.DirectedGraphConnections.PredAndSucc.access$600(r0)
            r10 = r0
            goto L62
        L40:
            r0 = r11
            r10 = r0
            r0 = r11
            java.lang.Object r1 = com.google.common.graph.DirectedGraphConnections.PRED
            if (r0 != r1) goto L62
            r0 = r6
            java.util.Map<N, java.lang.Object> r0 = r0.adjacentNodeValues
            r1 = r7
            com.google.common.graph.DirectedGraphConnections$PredAndSucc r2 = new com.google.common.graph.DirectedGraphConnections$PredAndSucc
            r3 = r2
            r4 = r8
            r3.<init>(r4)
            java.lang.Object r0 = r0.put(r1, r2)
            goto L12
        L62:
            r0 = r10
            if (r0 != 0) goto L90
            r0 = r6
            int r0 = r0.successorCount
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            r0 = r6
            r1 = r9
            r0.successorCount = r1
            r0 = r9
            int r0 = com.google.common.graph.Graphs.checkPositive(r0)
            r0 = r6
            java.util.List<com.google.common.graph.DirectedGraphConnections$NodeConnection<N>> r0 = r0.orderedNodeConnections
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L90
            r0 = r8
            com.google.common.graph.DirectedGraphConnections$NodeConnection$Succ r1 = new com.google.common.graph.DirectedGraphConnections$NodeConnection$Succ
            r2 = r1
            r3 = r7
            r2.<init>(r3)
            boolean r0 = r0.add(r1)
        L90:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.DirectedGraphConnections.addSuccessor(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> adjacentNodes() {
        return this.orderedNodeConnections == null ? Collections.unmodifiableSet(this.adjacentNodeValues.keySet()) : new AbstractSet<N>() { // from class: com.google.common.graph.DirectedGraphConnections.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                return DirectedGraphConnections.this.adjacentNodeValues.containsKey(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<N> iterator() {
                final Iterator it = DirectedGraphConnections.this.orderedNodeConnections.iterator();
                final HashSet hashSet = new HashSet();
                return new AbstractIterator<N>() { // from class: com.google.common.graph.DirectedGraphConnections.1.1
                    @Override // com.google.common.collect.AbstractIterator
                    public N computeNext() {
                        while (it.hasNext()) {
                            NodeConnection nodeConnection = (NodeConnection) it.next();
                            if (hashSet.add(nodeConnection.node)) {
                                return nodeConnection.node;
                            }
                        }
                        return endOfData();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return DirectedGraphConnections.this.adjacentNodeValues.size();
            }
        };
    }

    @Override // com.google.common.graph.GraphConnections
    public Iterator<EndpointPair<N>> incidentEdgeIterator(final N n) {
        Preconditions.checkNotNull(n);
        List<NodeConnection<N>> list = this.orderedNodeConnections;
        final Iterator concat = list == null ? Iterators.concat(Iterators.transform(predecessors().iterator(), new Function<N, EndpointPair<N>>() { // from class: com.google.common.graph.DirectedGraphConnections.4
            @Override // com.google.common.base.Function
            public EndpointPair<N> apply(N n2) {
                return EndpointPair.ordered(n2, n);
            }

            @Override // com.google.common.base.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((AnonymousClass4) obj);
            }
        }), Iterators.transform(successors().iterator(), new Function<N, EndpointPair<N>>() { // from class: com.google.common.graph.DirectedGraphConnections.5
            @Override // com.google.common.base.Function
            public EndpointPair<N> apply(N n2) {
                return EndpointPair.ordered(n, n2);
            }

            @Override // com.google.common.base.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((AnonymousClass5) obj);
            }
        })) : Iterators.transform(list.iterator(), new Function<NodeConnection<N>, EndpointPair<N>>() { // from class: com.google.common.graph.DirectedGraphConnections.6
            public EndpointPair<N> apply(NodeConnection<N> nodeConnection) {
                return nodeConnection instanceof NodeConnection.Succ ? EndpointPair.ordered(n, nodeConnection.node) : EndpointPair.ordered(nodeConnection.node, n);
            }

            @Override // com.google.common.base.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((NodeConnection) ((NodeConnection) obj));
            }
        });
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        return new AbstractIterator<EndpointPair<N>>() { // from class: com.google.common.graph.DirectedGraphConnections.7
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Removed duplicated region for block: B:4:0x000c  */
            @Override // com.google.common.collect.AbstractIterator
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.google.common.graph.EndpointPair<N> computeNext() {
                /*
                    r3 = this;
                L0:
                    r0 = r3
                    java.util.Iterator r0 = r5
                    boolean r0 = r0.hasNext()
                    if (r0 == 0) goto L34
                    r0 = r3
                    java.util.Iterator r0 = r5
                    java.lang.Object r0 = r0.next()
                    com.google.common.graph.EndpointPair r0 = (com.google.common.graph.EndpointPair) r0
                    r4 = r0
                    r0 = r4
                    java.lang.Object r0 = r0.nodeU()
                    r1 = r4
                    java.lang.Object r1 = r1.nodeV()
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L32
                    r0 = r3
                    java.util.concurrent.atomic.AtomicBoolean r0 = r6
                    r1 = 1
                    boolean r0 = r0.getAndSet(r1)
                    if (r0 != 0) goto L0
                L32:
                    r0 = r4
                    return r0
                L34:
                    r0 = r3
                    java.lang.Object r0 = r0.endOfData()
                    com.google.common.graph.EndpointPair r0 = (com.google.common.graph.EndpointPair) r0
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.DirectedGraphConnections.AnonymousClass7.computeNext():com.google.common.graph.EndpointPair");
            }
        };
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> predecessors() {
        return new AbstractSet<N>() { // from class: com.google.common.graph.DirectedGraphConnections.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                return DirectedGraphConnections.isPredecessor(DirectedGraphConnections.this.adjacentNodeValues.get(obj));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<N> iterator() {
                if (DirectedGraphConnections.this.orderedNodeConnections == null) {
                    final Iterator it = DirectedGraphConnections.this.adjacentNodeValues.entrySet().iterator();
                    return new AbstractIterator<N>() { // from class: com.google.common.graph.DirectedGraphConnections.2.1
                        @Override // com.google.common.collect.AbstractIterator
                        public N computeNext() {
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                if (DirectedGraphConnections.isPredecessor(entry.getValue())) {
                                    return (N) entry.getKey();
                                }
                            }
                            return endOfData();
                        }
                    };
                }
                final Iterator it2 = DirectedGraphConnections.this.orderedNodeConnections.iterator();
                return new AbstractIterator<N>() { // from class: com.google.common.graph.DirectedGraphConnections.2.2
                    @Override // com.google.common.collect.AbstractIterator
                    public N computeNext() {
                        while (it2.hasNext()) {
                            NodeConnection nodeConnection = (NodeConnection) it2.next();
                            if (nodeConnection instanceof NodeConnection.Pred) {
                                return nodeConnection.node;
                            }
                        }
                        return endOfData();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return DirectedGraphConnections.this.predecessorCount;
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // com.google.common.graph.GraphConnections
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void removePredecessor(N r6) {
        /*
            r5 = this;
            r0 = r6
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
            r0 = r5
            java.util.Map<N, java.lang.Object> r0 = r0.adjacentNodeValues
            r1 = r6
            java.lang.Object r0 = r0.get(r1)
            r8 = r0
            r0 = r8
            java.lang.Object r1 = com.google.common.graph.DirectedGraphConnections.PRED
            if (r0 != r1) goto L27
            r0 = r5
            java.util.Map<N, java.lang.Object> r0 = r0.adjacentNodeValues
            r1 = r6
            java.lang.Object r0 = r0.remove(r1)
        L22:
            r0 = 1
            r7 = r0
            goto L45
        L27:
            r0 = r8
            boolean r0 = r0 instanceof com.google.common.graph.DirectedGraphConnections.PredAndSucc
            if (r0 == 0) goto L43
            r0 = r5
            java.util.Map<N, java.lang.Object> r0 = r0.adjacentNodeValues
            r1 = r6
            r2 = r8
            com.google.common.graph.DirectedGraphConnections$PredAndSucc r2 = (com.google.common.graph.DirectedGraphConnections.PredAndSucc) r2
            java.lang.Object r2 = com.google.common.graph.DirectedGraphConnections.PredAndSucc.access$600(r2)
            java.lang.Object r0 = r0.put(r1, r2)
            goto L22
        L43:
            r0 = 0
            r7 = r0
        L45:
            r0 = r7
            if (r0 == 0) goto L72
            r0 = r5
            int r0 = r0.predecessorCount
            r1 = 1
            int r0 = r0 - r1
            r7 = r0
            r0 = r5
            r1 = r7
            r0.predecessorCount = r1
            r0 = r7
            int r0 = com.google.common.graph.Graphs.checkNonNegative(r0)
            r0 = r5
            java.util.List<com.google.common.graph.DirectedGraphConnections$NodeConnection<N>> r0 = r0.orderedNodeConnections
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L72
            r0 = r8
            com.google.common.graph.DirectedGraphConnections$NodeConnection$Pred r1 = new com.google.common.graph.DirectedGraphConnections$NodeConnection$Pred
            r2 = r1
            r3 = r6
            r2.<init>(r3)
            boolean r0 = r0.remove(r1)
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.DirectedGraphConnections.removePredecessor(java.lang.Object):void");
    }

    @Override // com.google.common.graph.GraphConnections
    public V removeSuccessor(Object obj) {
        Object obj2;
        Preconditions.checkNotNull(obj);
        V v = this.adjacentNodeValues.get(obj);
        if (v == null || v == (obj2 = PRED)) {
            v = null;
        } else if (v instanceof PredAndSucc) {
            this.adjacentNodeValues.put(obj, obj2);
            v = ((PredAndSucc) v).successorValue;
        } else {
            this.adjacentNodeValues.remove(obj);
        }
        if (v != null) {
            int i = this.successorCount - 1;
            this.successorCount = i;
            Graphs.checkNonNegative(i);
            List<NodeConnection<N>> list = this.orderedNodeConnections;
            if (list != null) {
                list.remove(new NodeConnection.Succ(obj));
            }
        }
        return v;
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> successors() {
        return new AbstractSet<N>() { // from class: com.google.common.graph.DirectedGraphConnections.3
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                return DirectedGraphConnections.isSuccessor(DirectedGraphConnections.this.adjacentNodeValues.get(obj));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<N> iterator() {
                if (DirectedGraphConnections.this.orderedNodeConnections == null) {
                    final Iterator it = DirectedGraphConnections.this.adjacentNodeValues.entrySet().iterator();
                    return new AbstractIterator<N>() { // from class: com.google.common.graph.DirectedGraphConnections.3.1
                        @Override // com.google.common.collect.AbstractIterator
                        public N computeNext() {
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                if (DirectedGraphConnections.isSuccessor(entry.getValue())) {
                                    return (N) entry.getKey();
                                }
                            }
                            return endOfData();
                        }
                    };
                }
                final Iterator it2 = DirectedGraphConnections.this.orderedNodeConnections.iterator();
                return new AbstractIterator<N>() { // from class: com.google.common.graph.DirectedGraphConnections.3.2
                    @Override // com.google.common.collect.AbstractIterator
                    public N computeNext() {
                        while (it2.hasNext()) {
                            NodeConnection nodeConnection = (NodeConnection) it2.next();
                            if (nodeConnection instanceof NodeConnection.Succ) {
                                return nodeConnection.node;
                            }
                        }
                        return endOfData();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return DirectedGraphConnections.this.successorCount;
            }
        };
    }

    @Override // com.google.common.graph.GraphConnections
    public V value(N n) {
        Preconditions.checkNotNull(n);
        Object obj = this.adjacentNodeValues.get(n);
        if (obj == PRED) {
            return null;
        }
        Object obj2 = obj;
        if (obj instanceof PredAndSucc) {
            obj2 = ((PredAndSucc) obj).successorValue;
        }
        return (V) obj2;
    }
}
