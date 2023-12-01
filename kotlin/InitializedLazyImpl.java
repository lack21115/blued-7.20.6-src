package kotlin;

import java.io.Serializable;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/InitializedLazyImpl.class */
public final class InitializedLazyImpl<T> implements Serializable, Lazy<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f42283a;

    public InitializedLazyImpl(T t) {
        this.f42283a = t;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        return this.f42283a;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
