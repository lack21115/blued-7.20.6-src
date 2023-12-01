package com.google.common.util.concurrent;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/ExecutionError.class */
public class ExecutionError extends Error {
    private static final long serialVersionUID = 0;

    protected ExecutionError() {
    }

    public ExecutionError(@NullableDecl Error error) {
        super(error);
    }

    protected ExecutionError(@NullableDecl String str) {
        super(str);
    }

    public ExecutionError(@NullableDecl String str, @NullableDecl Error error) {
        super(str, error);
    }
}
