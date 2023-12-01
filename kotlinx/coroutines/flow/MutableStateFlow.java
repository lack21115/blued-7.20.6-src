package kotlinx.coroutines.flow;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/MutableStateFlow.class */
public interface MutableStateFlow<T> extends MutableSharedFlow<T>, StateFlow<T> {
    boolean a(T t, T t2);

    void b(T t);

    T c();
}
