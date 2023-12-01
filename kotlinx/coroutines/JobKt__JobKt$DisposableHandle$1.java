package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/JobKt__JobKt$DisposableHandle$1.class */
public final class JobKt__JobKt$DisposableHandle$1 implements DisposableHandle {
    final /* synthetic */ Function0<Unit> a;

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        this.a.invoke();
    }
}
