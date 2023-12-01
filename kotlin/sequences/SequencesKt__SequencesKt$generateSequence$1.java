package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt__SequencesKt$generateSequence$1.class */
final class SequencesKt__SequencesKt$generateSequence$1<T> extends Lambda implements Function1<T, T> {
    final /* synthetic */ Function0<T> a;

    @Override // kotlin.jvm.functions.Function1
    public final T invoke(T it) {
        Intrinsics.e(it, "it");
        return this.a.invoke();
    }
}
