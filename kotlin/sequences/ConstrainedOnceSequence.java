package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/ConstrainedOnceSequence.class */
public final class ConstrainedOnceSequence<T> implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<Sequence<T>> f42614a;

    public ConstrainedOnceSequence(Sequence<? extends T> sequence) {
        Intrinsics.e(sequence, "sequence");
        this.f42614a = new AtomicReference<>(sequence);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        Sequence<T> andSet = this.f42614a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
