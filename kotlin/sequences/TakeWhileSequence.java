package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/TakeWhileSequence.class */
public final class TakeWhileSequence<T> implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Sequence<T> f42701a;
    private final Function1<T, Boolean> b;

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new TakeWhileSequence$iterator$1(this);
    }
}
