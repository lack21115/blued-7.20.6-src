package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__DelayKt$debounce$2.class */
final class FlowKt__DelayKt$debounce$2<T> extends Lambda implements Function1<T, Long> {
    final /* synthetic */ long a;

    public final long a(T t) {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Long invoke(Object obj) {
        return Long.valueOf(a(obj));
    }
}
