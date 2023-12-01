package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt___SequencesJvmKt$filterIsInstance$1.class */
final class SequencesKt___SequencesJvmKt$filterIsInstance$1 extends Lambda implements Function1<Object, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Class<R> f42658a;

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Boolean invoke(Object obj) {
        return Boolean.valueOf(this.f42658a.isInstance(obj));
    }
}
