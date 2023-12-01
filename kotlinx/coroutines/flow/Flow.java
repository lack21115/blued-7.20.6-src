package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/Flow.class */
public interface Flow<T> {
    Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation);
}
