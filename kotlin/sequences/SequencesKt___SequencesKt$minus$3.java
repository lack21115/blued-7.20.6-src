package kotlin.sequences;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.BrittleContainsOptimizationKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt___SequencesKt$minus$3.class */
public final class SequencesKt___SequencesKt$minus$3<T> implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Iterable<T> f42674a;
    final /* synthetic */ Sequence<T> b;

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        final Collection a2 = BrittleContainsOptimizationKt.a(this.f42674a);
        return a2.isEmpty() ? this.b.iterator() : SequencesKt.b(this.b, new Function1<T, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$3$iterator$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final Boolean invoke(T t) {
                return Boolean.valueOf(a2.contains(t));
            }
        }).iterator();
    }
}
