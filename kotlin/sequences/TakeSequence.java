package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/TakeSequence.class */
public final class TakeSequence<T> implements DropTakeSequence<T>, Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Sequence<T> f42699a;
    private final int b;

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new TakeSequence$iterator$1(this);
    }
}
