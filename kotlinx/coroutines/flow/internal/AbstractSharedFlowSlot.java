package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/AbstractSharedFlowSlot.class */
public abstract class AbstractSharedFlowSlot<F> {
    public abstract boolean a(F f);

    public abstract Continuation<Unit>[] b(F f);
}
