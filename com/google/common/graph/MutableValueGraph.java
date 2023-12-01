package com.google.common.graph;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/MutableValueGraph.class */
public interface MutableValueGraph<N, V> extends ValueGraph<N, V> {
    boolean addNode(N n);

    V putEdgeValue(EndpointPair<N> endpointPair, V v);

    V putEdgeValue(N n, N n2, V v);

    V removeEdge(EndpointPair<N> endpointPair);

    V removeEdge(N n, N n2);

    boolean removeNode(N n);
}
