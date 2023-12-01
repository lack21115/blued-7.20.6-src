package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/DropSequence.class */
public final class DropSequence<T> implements DropTakeSequence<T>, Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Sequence<T> f42618a;
    private final int b;

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new DropSequence$iterator$1(this);
    }
}
