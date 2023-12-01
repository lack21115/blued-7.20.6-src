package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/ThreadSafeHeapNode.class */
public interface ThreadSafeHeapNode {
    ThreadSafeHeap<?> a();

    void a(int i);

    void a(ThreadSafeHeap<?> threadSafeHeap);

    int b();
}
