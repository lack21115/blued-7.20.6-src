package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt___SequencesJvmKt$filterIsInstance$1.class */
final class SequencesKt___SequencesJvmKt$filterIsInstance$1 extends Lambda implements Function1<Object, Boolean> {
    final /* synthetic */ Class<R> a;

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Boolean invoke(Object obj) {
        return Boolean.valueOf(this.a.isInstance(obj));
    }
}
