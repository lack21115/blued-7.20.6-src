package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt___SequencesKt$requireNoNulls$1.class */
final class SequencesKt___SequencesKt$requireNoNulls$1<T> extends Lambda implements Function1<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Sequence<T> f42680a;

    @Override // kotlin.jvm.functions.Function1
    public final T invoke(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("null element found in " + this.f42680a + '.');
    }
}
