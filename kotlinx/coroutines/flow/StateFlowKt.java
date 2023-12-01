package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/StateFlowKt.class */
public final class StateFlowKt {
    private static final Symbol a = new Symbol("NONE");
    private static final Symbol b = new Symbol("PENDING");

    public static final <T> Flow<T> a(StateFlow<? extends T> stateFlow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        if (DebugKt.a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        return (((i >= 0 && i <= 1) || i == -2) && bufferOverflow == BufferOverflow.DROP_OLDEST) ? stateFlow : SharedFlowKt.a(stateFlow, coroutineContext, i, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [kotlinx.coroutines.internal.Symbol] */
    public static final <T> MutableStateFlow<T> a(T t) {
        T t2 = t;
        if (t == null) {
            t2 = NullSurrogateKt.a;
        }
        return new StateFlowImpl(t2);
    }

    public static final void a(MutableStateFlow<Integer> mutableStateFlow, int i) {
        int intValue;
        do {
            intValue = mutableStateFlow.c().intValue();
        } while (!mutableStateFlow.a(Integer.valueOf(intValue), Integer.valueOf(intValue + i)));
    }
}
