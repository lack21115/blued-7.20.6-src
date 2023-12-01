package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ErrorsKt$retry$4.class */
final class FlowKt__ErrorsKt$retry$4 extends Lambda implements Function1<Throwable, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final FlowKt__ErrorsKt$retry$4 f43183a = new FlowKt__ErrorsKt$retry$4();

    FlowKt__ErrorsKt$retry$4() {
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
