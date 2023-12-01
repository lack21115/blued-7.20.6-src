package com.google.common.graph;

import com.google.common.base.Optional;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/AbstractGraphBuilder.class */
abstract class AbstractGraphBuilder<N> {
    final boolean directed;
    boolean allowsSelfLoops = false;
    ElementOrder<N> nodeOrder = ElementOrder.insertion();
    ElementOrder<N> incidentEdgeOrder = ElementOrder.unordered();
    Optional<Integer> expectedNodeCount = Optional.absent();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractGraphBuilder(boolean z) {
        this.directed = z;
    }
}
