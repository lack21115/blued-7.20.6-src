package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/FilteringSequence.class */
public final class FilteringSequence<T> implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Sequence<T> f42624a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<T, Boolean> f42625c;

    /* JADX WARN: Multi-variable type inference failed */
    public FilteringSequence(Sequence<? extends T> sequence, boolean z, Function1<? super T, Boolean> predicate) {
        Intrinsics.e(sequence, "sequence");
        Intrinsics.e(predicate, "predicate");
        this.f42624a = sequence;
        this.b = z;
        this.f42625c = predicate;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new FilteringSequence$iterator$1(this);
    }
}
