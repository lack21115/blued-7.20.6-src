package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/ThreadLocalKey.class */
public final class ThreadLocalKey implements CoroutineContext.Key<ThreadLocalElement<?>> {
    private final ThreadLocal<?> a;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ThreadLocalKey) && Intrinsics.a(this.a, ((ThreadLocalKey) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.a + ')';
    }
}
