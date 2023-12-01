package kotlin.collections;

import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ReversedList.class */
final class ReversedList<T> extends AbstractMutableList<T> {

    /* renamed from: a  reason: collision with root package name */
    private final List<T> f42389a;

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        int d;
        List<T> list = this.f42389a;
        d = CollectionsKt__ReversedViewsKt.d(this, i);
        list.add(d, t);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f42389a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        int c2;
        List<T> list = this.f42389a;
        c2 = CollectionsKt__ReversedViewsKt.c(this, i);
        return list.get(c2);
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.f42389a.size();
    }

    @Override // kotlin.collections.AbstractMutableList
    public T removeAt(int i) {
        int c2;
        List<T> list = this.f42389a;
        c2 = CollectionsKt__ReversedViewsKt.c(this, i);
        return list.remove(c2);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        int c2;
        List<T> list = this.f42389a;
        c2 = CollectionsKt__ReversedViewsKt.c(this, i);
        return list.set(c2, t);
    }
}
