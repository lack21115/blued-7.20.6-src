package com.google.common.graph;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/MutableNetwork.class */
public interface MutableNetwork<N, E> extends Network<N, E> {
    boolean addEdge(EndpointPair<N> endpointPair, E e);

    boolean addEdge(N n, N n2, E e);

    boolean addNode(N n);

    boolean removeEdge(E e);

    boolean removeNode(N n);
}
