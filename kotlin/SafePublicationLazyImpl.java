package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/SafePublicationLazyImpl.class */
public final class SafePublicationLazyImpl<T> implements Serializable, Lazy<T> {
    public static final Companion a = new Companion(null);
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> e = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "c");
    private volatile Function0<? extends T> b;
    private volatile Object c;
    private final Object d;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/SafePublicationLazyImpl$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SafePublicationLazyImpl(Function0<? extends T> initializer) {
        Intrinsics.e(initializer, "initializer");
        this.b = initializer;
        this.c = UNINITIALIZED_VALUE.a;
        this.d = UNINITIALIZED_VALUE.a;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    public boolean a() {
        return this.c != UNINITIALIZED_VALUE.a;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t = (T) this.c;
        if (t != UNINITIALIZED_VALUE.a) {
            return t;
        }
        Function0<? extends T> function0 = this.b;
        if (function0 != null) {
            T invoke = function0.invoke();
            if (e.compareAndSet(this, UNINITIALIZED_VALUE.a, invoke)) {
                this.b = null;
                return invoke;
            }
        }
        return (T) this.c;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
