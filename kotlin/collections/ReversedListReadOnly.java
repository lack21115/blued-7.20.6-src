package kotlin.collections;

import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ReversedListReadOnly.class */
class ReversedListReadOnly<T> extends AbstractList<T> {
    private final List<T> a;

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int i) {
        int c;
        List<T> list = this.a;
        c = CollectionsKt__ReversedViewsKt.c(this, i);
        return list.get(c);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.a.size();
    }
}
