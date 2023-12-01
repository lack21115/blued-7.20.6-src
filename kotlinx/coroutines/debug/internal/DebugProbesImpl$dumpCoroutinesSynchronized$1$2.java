package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/internal/DebugProbesImpl$dumpCoroutinesSynchronized$1$2.class */
final class DebugProbesImpl$dumpCoroutinesSynchronized$1$2 extends Lambda implements Function1<DebugProbesImpl.CoroutineOwner<?>, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final DebugProbesImpl$dumpCoroutinesSynchronized$1$2 f43038a = new DebugProbesImpl$dumpCoroutinesSynchronized$1$2();

    DebugProbesImpl$dumpCoroutinesSynchronized$1$2() {
        super(1);
    }

    public final boolean a(DebugProbesImpl.CoroutineOwner<?> coroutineOwner) {
        boolean a2;
        a2 = DebugProbesImpl.f43034a.a((DebugProbesImpl.CoroutineOwner<?>) coroutineOwner);
        return !a2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Boolean invoke(DebugProbesImpl.CoroutineOwner<?> coroutineOwner) {
        return Boolean.valueOf(a(coroutineOwner));
    }
}
