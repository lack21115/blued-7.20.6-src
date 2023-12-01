package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/ThreadLocalKey.class */
public final class ThreadLocalKey implements CoroutineContext.Key<ThreadLocalElement<?>> {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal<?> f43572a;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ThreadLocalKey) && Intrinsics.a(this.f43572a, ((ThreadLocalKey) obj).f43572a);
    }

    public int hashCode() {
        return this.f43572a.hashCode();
    }

    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f43572a + ')';
    }
}
