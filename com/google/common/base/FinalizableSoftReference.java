package com.google.common.base;

import java.lang.ref.SoftReference;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/base/FinalizableSoftReference.class */
public abstract class FinalizableSoftReference<T> extends SoftReference<T> implements FinalizableReference {
    protected FinalizableSoftReference(T t, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}
