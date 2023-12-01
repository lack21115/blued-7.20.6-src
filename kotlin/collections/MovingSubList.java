package kotlin.collections;

import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/MovingSubList.class */
public final class MovingSubList<E> extends AbstractList<E> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    private final List<E> f42386a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f42387c;

    @Override // kotlin.collections.AbstractList, java.util.List
    public E get(int i) {
        AbstractList.Companion.a(i, this.f42387c);
        return this.f42386a.get(this.b + i);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f42387c;
    }
}
