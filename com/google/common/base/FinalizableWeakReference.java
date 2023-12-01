package com.google.common.base;

import java.lang.ref.WeakReference;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/base/FinalizableWeakReference.class */
public abstract class FinalizableWeakReference<T> extends WeakReference<T> implements FinalizableReference {
    protected FinalizableWeakReference(T t, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}
