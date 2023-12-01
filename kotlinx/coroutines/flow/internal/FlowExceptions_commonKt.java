package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/FlowExceptions_commonKt.class */
public final class FlowExceptions_commonKt {
    public static final void a(AbortFlowException abortFlowException, FlowCollector<?> flowCollector) {
        if (abortFlowException.a() != flowCollector) {
            throw abortFlowException;
        }
    }
}
