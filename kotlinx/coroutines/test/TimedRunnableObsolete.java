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

    /* renamed from: a  reason: collision with root package name */
    public final long f43647a;
    private final Runnable b;

    /* renamed from: c  reason: collision with root package name */
    private final long f43648c;
    private ThreadSafeHeap<?> d;
    private int e;

    public TimedRunnableObsolete(Runnable runnable, long j, long j2) {
        this.b = runnable;
        this.f43648c = j;
        this.f43647a = j2;
    }

    public /* synthetic */ TimedRunnableObsolete(Runnable runnable, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(runnable, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 0L : j2);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(TimedRunnableObsolete timedRunnableObsolete) {
        long j = this.f43647a;
        long j2 = timedRunnableObsolete.f43647a;
        return j == j2 ? Intrinsics.a(this.f43648c, timedRunnableObsolete.f43648c) : Intrinsics.a(j, j2);
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
        return "TimedRunnable(time=" + this.f43647a + ", run=" + this.b + ')';
    }
}
