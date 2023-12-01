package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/builders/MapBuilderEntries.class */
public final class MapBuilderEntries<K, V> extends AbstractMapBuilderEntrySet<Map.Entry<K, V>, K, V> {
    private final MapBuilder<K, V> a;

    public MapBuilderEntries(MapBuilder<K, V> backing) {
        Intrinsics.e(backing, "backing");
        this.a = backing;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int a() {
        return this.a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Map.Entry<K, V>> elements) {
        Intrinsics.e(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.collections.builders.AbstractMapBuilderEntrySet
    public boolean b(Map.Entry<? extends K, ? extends V> element) {
        Intrinsics.e(element, "element");
        return this.a.a((Map.Entry) element);
    }

    @Override // kotlin.collections.builders.AbstractMapBuilderEntrySet
    public boolean c(Map.Entry element) {
        Intrinsics.e(element, "element");
        return this.a.b(element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.e(elements, "elements");
        return this.a.a((Collection<?>) elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    /* renamed from: d */
    public boolean add(Map.Entry<K, V> element) {
        Intrinsics.e(element, "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.a.j();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.e(elements, "elements");
        this.a.g();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.e(elements, "elements");
        this.a.g();
        return super.retainAll(elements);
    }
}
