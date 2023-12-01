package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/internal/DebugProbesImpl$startWeakRefCleanerThread$1.class */
final class DebugProbesImpl$startWeakRefCleanerThread$1 extends Lambda implements Function0<Unit> {
    public static final DebugProbesImpl$startWeakRefCleanerThread$1 a = new DebugProbesImpl$startWeakRefCleanerThread$1();

    DebugProbesImpl$startWeakRefCleanerThread$1() {
        super(0);
    }

    public final void a() {
        ConcurrentWeakMap concurrentWeakMap;
        concurrentWeakMap = DebugProbesImpl.j;
        concurrentWeakMap.e();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* synthetic */ Unit invoke() {
        a();
        return Unit.a;
    }
}
