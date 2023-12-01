package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArrayAsCollection.class */
public final class ArrayAsCollection<T> implements Collection<T>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    private final T[] f42333a;
    private final boolean b;

    public ArrayAsCollection(T[] values, boolean z) {
        Intrinsics.e(values, "values");
        this.f42333a = values;
        this.b = z;
    }

    public int a() {
        return this.f42333a.length;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return ArraysKt.b(this.f42333a, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> elements) {
        boolean z;
        Intrinsics.e(elements, "elements");
        Collection<? extends Object> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<? extends Object> it = collection.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            } else if (!contains(it.next())) {
                z = false;
                break;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f42333a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return ArrayIteratorKt.a(this.f42333a);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public final int size() {
        return a();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return CollectionsKt.a(this.f42333a, this.b);
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] array) {
        Intrinsics.e(array, "array");
        return (T[]) CollectionToArray.a(this, array);
    }
}
