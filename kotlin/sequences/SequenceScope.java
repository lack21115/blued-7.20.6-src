package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequenceScope.class */
public abstract class SequenceScope<T> {
    public abstract Object a(T t, Continuation<? super Unit> continuation);

    public abstract Object a(Iterator<? extends T> it, Continuation<? super Unit> continuation);

    public final Object a(Sequence<? extends T> sequence, Continuation<? super Unit> continuation) {
        Object a2 = a((Iterator) sequence.iterator(), continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
