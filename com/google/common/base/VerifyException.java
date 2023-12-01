package com.google.common.base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/base/VerifyException.class */
public class VerifyException extends RuntimeException {
    public VerifyException() {
    }

    public VerifyException(@NullableDecl String str) {
        super(str);
    }

    public VerifyException(@NullableDecl String str, @NullableDecl Throwable th) {
        super(str, th);
    }

    public VerifyException(@NullableDecl Throwable th) {
        super(th);
    }
}
