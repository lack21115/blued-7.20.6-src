package kotlin.collections;

import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ReversedListReadOnly.class */
class ReversedListReadOnly<T> extends AbstractList<T> {

    /* renamed from: a  reason: collision with root package name */
    private final List<T> f42390a;

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int i) {
        int c2;
        List<T> list = this.f42390a;
        c2 = CollectionsKt__ReversedViewsKt.c(this, i);
        return list.get(c2);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f42390a.size();
    }
}
