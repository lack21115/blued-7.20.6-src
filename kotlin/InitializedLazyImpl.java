package kotlin;

import java.io.Serializable;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/InitializedLazyImpl.class */
public final class InitializedLazyImpl<T> implements Serializable, Lazy<T> {
    private final T a;

    public InitializedLazyImpl(T t) {
        this.a = t;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        return this.a;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
