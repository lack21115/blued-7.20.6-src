package com.google.common.collect;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Deprecated
/* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/ComputationException.class */
public class ComputationException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public ComputationException(@NullableDecl Throwable th) {
        super(th);
    }
}
