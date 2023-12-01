package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/scheduling/LimitingDispatcher.class */
final class LimitingDispatcher extends ExecutorCoroutineDispatcher implements Executor, TaskContext {
    private static final /* synthetic */ AtomicIntegerFieldUpdater h = AtomicIntegerFieldUpdater.newUpdater(LimitingDispatcher.class, "inFlightTasks");
    private final ExperimentalCoroutineDispatcher b;
    private final int d;
    private final String e;
    private final int f;
    private final ConcurrentLinkedQueue<Runnable> g = new ConcurrentLinkedQueue<>();
    private volatile /* synthetic */ int inFlightTasks = 0;

    public LimitingDispatcher(ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int i, String str, int i2) {
        this.b = experimentalCoroutineDispatcher;
        this.d = i;
        this.e = str;
        this.f = i2;
    }

    private final void a(Runnable runnable, boolean z) {
        while (h.incrementAndGet(this) > this.d) {
            this.g.add(runnable);
            if (h.decrementAndGet(this) >= this.d) {
                return;
            }
            Runnable poll = this.g.poll();
            runnable = poll;
            if (poll == null) {
                return;
            }
        }
        this.b.a(runnable, this, z);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor a() {
        return this;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public int b() {
        return this.f;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public void c() {
        Runnable poll = this.g.poll();
        if (poll != null) {
            this.b.a(poll, this, true);
            return;
        }
        h.decrementAndGet(this);
        Runnable poll2 = this.g.poll();
        if (poll2 == null) {
            return;
        }
        a(poll2, true);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        a(runnable, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        a(runnable, true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        a(runnable, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String str = this.e;
        String str2 = str;
        if (str == null) {
            str2 = super.toString() + "[dispatcher = " + this.b + ']';
        }
        return str2;
    }
}
