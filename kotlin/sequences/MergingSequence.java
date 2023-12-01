package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/MergingSequence.class */
public final class MergingSequence<T1, T2, V> implements Sequence<V> {
    private final Sequence<T1> a;
    private final Sequence<T2> b;
    private final Function2<T1, T2, V> c;

    @Override // kotlin.sequences.Sequence
    public Iterator<V> iterator() {
        return new MergingSequence$iterator$1(this);
    }
}
