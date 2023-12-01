package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/scheduling/Task.class */
public abstract class Task implements Runnable {
    public long f;
    public TaskContext g;

    public Task() {
        this(0L, NonBlockingContext.a);
    }

    public Task(long j, TaskContext taskContext) {
        this.f = j;
        this.g = taskContext;
    }
}
