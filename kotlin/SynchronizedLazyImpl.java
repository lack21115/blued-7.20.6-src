package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/SynchronizedLazyImpl.class */
public final class SynchronizedLazyImpl<T> implements Serializable, Lazy<T> {

    /* renamed from: a  reason: collision with root package name */
    private Function0<? extends T> f42297a;
    private volatile Object b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f42298c;

    public SynchronizedLazyImpl(Function0<? extends T> initializer, Object obj) {
        Intrinsics.e(initializer, "initializer");
        this.f42297a = initializer;
        this.b = UNINITIALIZED_VALUE.f42310a;
        this.f42298c = obj == null ? this : obj;
    }

    public /* synthetic */ SynchronizedLazyImpl(Function0 function0, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? null : obj);
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    public boolean a() {
        return this.b != UNINITIALIZED_VALUE.f42310a;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t;
        T t2 = (T) this.b;
        if (t2 != UNINITIALIZED_VALUE.f42310a) {
            return t2;
        }
        synchronized (this.f42298c) {
            t = this.b;
            if (t == UNINITIALIZED_VALUE.f42310a) {
                Function0<? extends T> function0 = this.f42297a;
                Intrinsics.a(function0);
                t = function0.invoke();
                this.b = t;
                this.f42297a = null;
            }
        }
        return (T) t;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
