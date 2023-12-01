package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SubSequence.class */
public final class SubSequence<T> implements DropTakeSequence<T>, Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Sequence<T> f42695a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f42696c;

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new SubSequence$iterator$1(this);
    }
}
