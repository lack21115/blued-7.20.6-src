package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt___SequencesKt$minus$1.class */
public final class SequencesKt___SequencesKt$minus$1<T> implements Sequence<T> {
    final /* synthetic */ Sequence<T> a;
    final /* synthetic */ T b;

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Sequence<T> sequence = this.a;
        final T t = this.b;
        return SequencesKt.a((Sequence) sequence, (Function1) new Function1<T, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$1$iterator$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Boolean a(T t2) {
                boolean z = true;
                if (!Ref.BooleanRef.this.a) {
                    z = true;
                    if (Intrinsics.a(t2, t)) {
                        Ref.BooleanRef.this.a = true;
                        z = false;
                    }
                }
                return Boolean.valueOf(z);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Boolean invoke(Object obj) {
                return a(obj);
            }
        }).iterator();
    }
}
