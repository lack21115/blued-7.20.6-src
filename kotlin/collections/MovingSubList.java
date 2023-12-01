package kotlin.collections;

import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/MovingSubList.class */
public final class MovingSubList<E> extends AbstractList<E> implements RandomAccess {
    private final List<E> a;
    private int b;
    private int c;

    @Override // kotlin.collections.AbstractList, java.util.List
    public E get(int i) {
        AbstractList.Companion.a(i, this.c);
        return this.a.get(this.b + i);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.c;
    }
}
