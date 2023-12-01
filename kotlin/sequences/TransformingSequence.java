package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/TransformingSequence.class */
public final class TransformingSequence<T, R> implements Sequence<R> {

    /* renamed from: a  reason: collision with root package name */
    private final Sequence<T> f42707a;
    private final Function1<T, R> b;

    /* JADX WARN: Multi-variable type inference failed */
    public TransformingSequence(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transformer) {
        Intrinsics.e(sequence, "sequence");
        Intrinsics.e(transformer, "transformer");
        this.f42707a = sequence;
        this.b = transformer;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<R> iterator() {
        return new TransformingSequence$iterator$1(this);
    }
}
