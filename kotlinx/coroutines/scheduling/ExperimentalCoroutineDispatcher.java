package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher.class */
public class ExperimentalCoroutineDispatcher extends ExecutorCoroutineDispatcher {
    private final int b;
    private final int d;
    private final long e;
    private final String f;
    private CoroutineScheduler g;

    public ExperimentalCoroutineDispatcher(int i, int i2, long j, String str) {
        this.b = i;
        this.d = i2;
        this.e = j;
        this.f = str;
        this.g = b();
    }

    public ExperimentalCoroutineDispatcher(int i, int i2, String str) {
        this(i, i2, TasksKt.e, str);
    }

    public /* synthetic */ ExperimentalCoroutineDispatcher(int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? TasksKt.c : i, (i3 & 2) != 0 ? TasksKt.d : i2, (i3 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    private final CoroutineScheduler b() {
        return new CoroutineScheduler(this.b, this.d, this.e, this.f);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor a() {
        return this.g;
    }

    public final void a(Runnable runnable, TaskContext taskContext, boolean z) {
        try {
            this.g.a(runnable, taskContext, z);
        } catch (RejectedExecutionException e) {
            DefaultExecutor.b.a(this.g.a(runnable, taskContext));
        }
    }

    public void close() {
        this.g.close();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            CoroutineScheduler.a(this.g, runnable, null, false, 6, null);
        } catch (RejectedExecutionException e) {
            DefaultExecutor.b.dispatch(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            CoroutineScheduler.a(this.g, runnable, null, true, 2, null);
        } catch (RejectedExecutionException e) {
            DefaultExecutor.b.dispatchYield(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return super.toString() + "[scheduler = " + this.g + ']';
    }
}
