package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/internal/HashedWeakRef.class */
public final class HashedWeakRef<T> extends WeakReference<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f43040a;

    public HashedWeakRef(T t, ReferenceQueue<T> referenceQueue) {
        super(t, referenceQueue);
        this.f43040a = t != null ? t.hashCode() : 0;
    }
}
