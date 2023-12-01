package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt__SequencesKt.class */
public class SequencesKt__SequencesKt extends SequencesKt__SequencesJVMKt {
    public static final <T> Sequence<T> a(final T t, Function1<? super T, ? extends T> nextFunction) {
        Intrinsics.e(nextFunction, "nextFunction");
        return t == null ? EmptySequence.f42623a : new GeneratorSequence(new Function0<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                return t;
            }
        }, nextFunction);
    }

    public static final <T> Sequence<T> a(final Iterator<? extends T> it) {
        Intrinsics.e(it, "<this>");
        return SequencesKt.a(new Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return Iterator.this;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Sequence<T> a(Sequence<? extends T> sequence) {
        Intrinsics.e(sequence, "<this>");
        return sequence instanceof ConstrainedOnceSequence ? sequence : new ConstrainedOnceSequence(sequence);
    }
}
