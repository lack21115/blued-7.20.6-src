package com.google.common.graph;

import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Implement with a lambda, or use GraphBuilder to build a Graph with the desired edges")
/* loaded from: source-8110460-dex2jar.jar:com/google/common/graph/PredecessorsFunction.class */
public interface PredecessorsFunction<N> {
    Iterable<? extends N> predecessors(N n);
}
