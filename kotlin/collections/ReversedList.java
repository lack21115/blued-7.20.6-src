package kotlin.collections;

import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ReversedList.class */
final class ReversedList<T> extends AbstractMutableList<T> {
    private final List<T> a;

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        int d;
        List<T> list = this.a;
        d = CollectionsKt__ReversedViewsKt.d(this, i);
        list.add(d, t);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        int c;
        List<T> list = this.a;
        c = CollectionsKt__ReversedViewsKt.c(this, i);
        return list.get(c);
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.a.size();
    }

    @Override // kotlin.collections.AbstractMutableList
    public T removeAt(int i) {
        int c;
        List<T> list = this.a;
        c = CollectionsKt__ReversedViewsKt.c(this, i);
        return list.remove(c);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        int c;
        List<T> list = this.a;
        c = CollectionsKt__ReversedViewsKt.c(this, i);
        return list.set(c, t);
    }
}
