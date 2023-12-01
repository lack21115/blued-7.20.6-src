package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/FlatteningSequence.class */
public final class FlatteningSequence<T, R, E> implements Sequence<E> {

    /* renamed from: a  reason: collision with root package name */
    private final Sequence<T> f42628a;
    private final Function1<T, R> b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<R, Iterator<E>> f42629c;

    @Override // kotlin.sequences.Sequence
    public Iterator<E> iterator() {
        return new FlatteningSequence$iterator$1(this);
    }
}
