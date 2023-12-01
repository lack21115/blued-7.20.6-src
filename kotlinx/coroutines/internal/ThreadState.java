package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/ThreadState.class */
public final class ThreadState {
    public final CoroutineContext a;
    private final Object[] b;
    private final ThreadContextElement<Object>[] c;
    private int d;

    public ThreadState(CoroutineContext coroutineContext, int i) {
        this.a = coroutineContext;
        this.b = new Object[i];
        this.c = new ThreadContextElement[i];
    }

    public final void a(CoroutineContext coroutineContext) {
        int length = this.c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            ThreadContextElement<Object> threadContextElement = this.c[length];
            Intrinsics.a(threadContextElement);
            threadContextElement.a(coroutineContext, this.b[length]);
            if (i < 0) {
                return;
            }
            length = i;
        }
    }

    public final void a(ThreadContextElement<?> threadContextElement, Object obj) {
        Object[] objArr = this.b;
        int i = this.d;
        objArr[i] = obj;
        ThreadContextElement<Object>[] threadContextElementArr = this.c;
        this.d = i + 1;
        threadContextElementArr[i] = threadContextElement;
    }
}
