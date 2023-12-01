package com.google.common.base;

import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Use an instance of one of the Finalizable*Reference classes")
/* loaded from: source-8110460-dex2jar.jar:com/google/common/base/FinalizableReference.class */
public interface FinalizableReference {
    void finalizeReferent();
}
