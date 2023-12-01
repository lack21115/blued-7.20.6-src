package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/DistinctSequence.class */
public final class DistinctSequence<T, K> implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Sequence<T> f42617a;
    private final Function1<T, K> b;

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new DistinctIterator(this.f42617a.iterator(), this.b);
    }
}
