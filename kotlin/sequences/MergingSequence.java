package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/MergingSequence.class */
public final class MergingSequence<T1, T2, V> implements Sequence<V> {

    /* renamed from: a  reason: collision with root package name */
    private final Sequence<T1> f42637a;
    private final Sequence<T2> b;

    /* renamed from: c  reason: collision with root package name */
    private final Function2<T1, T2, V> f42638c;

    @Override // kotlin.sequences.Sequence
    public Iterator<V> iterator() {
        return new MergingSequence$iterator$1(this);
    }
}
