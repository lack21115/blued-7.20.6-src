package kotlinx.coroutines.flow;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/MutableSharedFlow.class */
public interface MutableSharedFlow<T> extends FlowCollector<T>, SharedFlow<T> {
    StateFlow<Integer> a();

    boolean a(T t);

    void b();
}
