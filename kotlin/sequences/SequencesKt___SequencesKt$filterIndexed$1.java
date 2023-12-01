package kotlin.sequences;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt___SequencesKt$filterIndexed$1.class */
final class SequencesKt___SequencesKt$filterIndexed$1<T> extends Lambda implements Function1<IndexedValue<? extends T>, Boolean> {
    final /* synthetic */ Function2<Integer, T, Boolean> a;

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Boolean invoke(IndexedValue<? extends T> it) {
        Intrinsics.e(it, "it");
        return this.a.invoke(Integer.valueOf(it.a()), it.b());
    }
}
