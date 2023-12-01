package com.google.common.util.concurrent.internal;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/internal/InternalFutures.class */
public final class InternalFutures {
    private InternalFutures() {
    }

    public static Throwable tryInternalFastPathGetFailure(InternalFutureFailureAccess internalFutureFailureAccess) {
        return internalFutureFailureAccess.tryInternalFastPathGetFailure();
    }
}
