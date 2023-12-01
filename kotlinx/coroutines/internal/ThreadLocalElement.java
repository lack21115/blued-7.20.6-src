package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/ThreadLocalElement.class */
public final class ThreadLocalElement<T> implements ThreadContextElement<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f43570a;
    private final ThreadLocal<T> b;

    /* renamed from: c  reason: collision with root package name */
    private final CoroutineContext.Key<?> f43571c;

    @Override // kotlinx.coroutines.ThreadContextElement
    public void a(CoroutineContext coroutineContext, T t) {
        this.b.set(t);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public T b(CoroutineContext coroutineContext) {
        T t = this.b.get();
        this.b.set(this.f43570a);
        return t;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) ThreadContextElement.DefaultImpls.a(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        if (Intrinsics.a(getKey(), key)) {
            return this;
        }
        return null;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key<?> getKey() {
        return this.f43571c;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return Intrinsics.a(getKey(), key) ? EmptyCoroutineContext.f42457a : this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return ThreadContextElement.DefaultImpls.a(this, coroutineContext);
    }

    public String toString() {
        return "ThreadLocal(value=" + this.f43570a + ", threadLocal = " + this.b + ')';
    }
}
