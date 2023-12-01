package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/SynchronizedLazyImpl.class */
public final class SynchronizedLazyImpl<T> implements Serializable, Lazy<T> {
    private Function0<? extends T> a;
    private volatile Object b;
    private final Object c;

    public SynchronizedLazyImpl(Function0<? extends T> initializer, Object obj) {
        Intrinsics.e(initializer, "initializer");
        this.a = initializer;
        this.b = UNINITIALIZED_VALUE.a;
        this.c = obj == null ? this : obj;
    }

    public /* synthetic */ SynchronizedLazyImpl(Function0 function0, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? null : obj);
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    public boolean a() {
        return this.b != UNINITIALIZED_VALUE.a;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t;
        T t2 = (T) this.b;
        if (t2 != UNINITIALIZED_VALUE.a) {
            return t2;
        }
        synchronized (this.c) {
            t = this.b;
            if (t == UNINITIALIZED_VALUE.a) {
                Function0<? extends T> function0 = this.a;
                Intrinsics.a(function0);
                t = function0.invoke();
                this.b = t;
                this.a = null;
            }
        }
        return (T) t;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
