package com.google.common.base;

import java.lang.ref.PhantomReference;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/base/FinalizablePhantomReference.class */
public abstract class FinalizablePhantomReference<T> extends PhantomReference<T> implements FinalizableReference {
    protected FinalizablePhantomReference(T t, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}
