package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/test/TimedRunnableObsolete.class */
public final class TimedRunnableObsolete implements Comparable<TimedRunnableObsolete>, Runnable, ThreadSafeHeapNode {
    public final long a;
    private final Runnable b;
    private final long c;
    private ThreadSafeHeap<?> d;
    private int e;

    public TimedRunnableObsolete(Runnable runnable, long j, long j2) {
        this.b = runnable;
        this.c = j;
        this.a = j2;
    }

    public /* synthetic */ TimedRunnableObsolete(Runnable runnable, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(runnable, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 0L : j2);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(TimedRunnableObsolete timedRunnableObsolete) {
        long j = this.a;
        long j2 = timedRunnableObsolete.a;
        return j == j2 ? Intrinsics.a(this.c, timedRunnableObsolete.c) : Intrinsics.a(j, j2);
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public ThreadSafeHeap<?> a() {
        return this.d;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public void a(int i) {
        this.e = i;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public void a(ThreadSafeHeap<?> threadSafeHeap) {
        this.d = threadSafeHeap;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public int b() {
        return this.e;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.run();
    }

    public String toString() {
        return "TimedRunnable(time=" + this.a + ", run=" + this.b + ')';
    }
}
