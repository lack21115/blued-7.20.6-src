package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/FilteringSequence.class */
public final class FilteringSequence<T> implements Sequence<T> {
    private final Sequence<T> a;
    private final boolean b;
    private final Function1<T, Boolean> c;

    /* JADX WARN: Multi-variable type inference failed */
    public FilteringSequence(Sequence<? extends T> sequence, boolean z, Function1<? super T, Boolean> predicate) {
        Intrinsics.e(sequence, "sequence");
        Intrinsics.e(predicate, "predicate");
        this.a = sequence;
        this.b = z;
        this.c = predicate;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new FilteringSequence$iterator$1(this);
    }
}
