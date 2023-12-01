package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/TransformingIndexedSequence.class */
public final class TransformingIndexedSequence<T, R> implements Sequence<R> {

    /* renamed from: a  reason: collision with root package name */
    private final Sequence<T> f42704a;
    private final Function2<Integer, T, R> b;

    @Override // kotlin.sequences.Sequence
    public Iterator<R> iterator() {
        return new TransformingIndexedSequence$iterator$1(this);
    }
}
