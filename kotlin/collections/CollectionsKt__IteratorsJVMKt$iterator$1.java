package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/CollectionsKt__IteratorsJVMKt$iterator$1.class */
public final class CollectionsKt__IteratorsJVMKt$iterator$1<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Enumeration<T> f42374a;

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f42374a.hasMoreElements();
    }

    @Override // java.util.Iterator
    public T next() {
        return this.f42374a.nextElement();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
