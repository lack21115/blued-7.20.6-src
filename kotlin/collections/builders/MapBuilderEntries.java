package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/builders/MapBuilderEntries.class */
public final class MapBuilderEntries<K, V> extends AbstractMapBuilderEntrySet<Map.Entry<K, V>, K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final MapBuilder<K, V> f42410a;

    public MapBuilderEntries(MapBuilder<K, V> backing) {
        Intrinsics.e(backing, "backing");
        this.f42410a = backing;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int a() {
        return this.f42410a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends Map.Entry<K, V>> elements) {
        Intrinsics.e(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.collections.builders.AbstractMapBuilderEntrySet
    public boolean b(Map.Entry<? extends K, ? extends V> element) {
        Intrinsics.e(element, "element");
        return this.f42410a.a((Map.Entry) element);
    }

    @Override // kotlin.collections.builders.AbstractMapBuilderEntrySet
    public boolean c(Map.Entry element) {
        Intrinsics.e(element, "element");
        return this.f42410a.b(element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f42410a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.e(elements, "elements");
        return this.f42410a.a((Collection<?>) elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* renamed from: d */
    public boolean add(Map.Entry<K, V> element) {
        Intrinsics.e(element, "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f42410a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f42410a.j();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.e(elements, "elements");
        this.f42410a.g();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.e(elements, "elements");
        this.f42410a.g();
        return super.retainAll(elements);
    }
}
