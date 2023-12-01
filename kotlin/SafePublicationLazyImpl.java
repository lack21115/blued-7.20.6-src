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

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f42295a = new Companion(null);
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> e = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "c");
    private volatile Function0<? extends T> b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Object f42296c;
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
        this.f42296c = UNINITIALIZED_VALUE.f42310a;
        this.d = UNINITIALIZED_VALUE.f42310a;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    public boolean a() {
        return this.f42296c != UNINITIALIZED_VALUE.f42310a;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t = (T) this.f42296c;
        if (t != UNINITIALIZED_VALUE.f42310a) {
            return t;
        }
        Function0<? extends T> function0 = this.b;
        if (function0 != null) {
            T invoke = function0.invoke();
            if (e.compareAndSet(this, UNINITIALIZED_VALUE.f42310a, invoke)) {
                this.b = null;
                return invoke;
            }
        }
        return (T) this.f42296c;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
