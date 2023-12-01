package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/builders/SetBuilder.class */
public final class SetBuilder<E> extends AbstractMutableSet<E> implements Serializable, Set<E>, KMutableSet {

    /* renamed from: a  reason: collision with root package name */
    private final MapBuilder<E, ?> f42416a;

    public SetBuilder() {
        this(new MapBuilder());
    }

    public SetBuilder(int i) {
        this(new MapBuilder(i));
    }

    public SetBuilder(MapBuilder<E, ?> backing) {
        Intrinsics.e(backing, "backing");
        this.f42416a = backing;
    }

    private final Object writeReplace() {
        if (this.f42416a.b()) {
            return new SerializedCollection(this, 1);
        }
        throw new NotSerializableException("The set cannot be serialized while it is being built.");
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int a() {
        return this.f42416a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        return this.f42416a.a((MapBuilder<E, ?>) e) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.e(elements, "elements");
        this.f42416a.g();
        return super.addAll(elements);
    }

    public final Set<E> b() {
        this.f42416a.c();
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f42416a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f42416a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f42416a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.f42416a.h();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f42416a.b((MapBuilder<E, ?>) obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.e(elements, "elements");
        this.f42416a.g();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.e(elements, "elements");
        this.f42416a.g();
        return super.retainAll(elements);
    }
}
