package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowCollector.class */
public interface FlowCollector<T> {
    Object emit(T t, Continuation<? super Unit> continuation);
}
