package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/UnsafeLazyImpl.class */
public final class UnsafeLazyImpl<T> implements Serializable, Lazy<T> {

    /* renamed from: a  reason: collision with root package name */
    private Function0<? extends T> f42315a;
    private Object b;

    public UnsafeLazyImpl(Function0<? extends T> initializer) {
        Intrinsics.e(initializer, "initializer");
        this.f42315a = initializer;
        this.b = UNINITIALIZED_VALUE.f42310a;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    public boolean a() {
        return this.b != UNINITIALIZED_VALUE.f42310a;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        if (this.b == UNINITIALIZED_VALUE.f42310a) {
            Function0<? extends T> function0 = this.f42315a;
            Intrinsics.a(function0);
            this.b = function0.invoke();
            this.f42315a = null;
        }
        return (T) this.b;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
