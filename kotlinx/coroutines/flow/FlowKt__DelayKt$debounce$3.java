package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.time.Duration;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__DelayKt$debounce$3.class */
final class FlowKt__DelayKt$debounce$3<T> extends Lambda implements Function1<T, Long> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function1<T, Duration> f43121a;

    public final long a(T t) {
        return DelayKt.a(this.f43121a.invoke(t).a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Long invoke(Object obj) {
        return Long.valueOf(a(obj));
    }
}
