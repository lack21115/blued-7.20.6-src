package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ErrorsKt$onErrorCollect$1.class */
final class FlowKt__ErrorsKt$onErrorCollect$1 extends Lambda implements Function1<Throwable, Boolean> {
    public static final FlowKt__ErrorsKt$onErrorCollect$1 a = new FlowKt__ErrorsKt$onErrorCollect$1();

    FlowKt__ErrorsKt$onErrorCollect$1() {
        super(1);
    }

    public final boolean a(Throwable th) {
        return true;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Boolean invoke(Throwable th) {
        return Boolean.valueOf(a(th));
    }
}
