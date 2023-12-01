package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.DebugStringsKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/scheduling/TaskImpl.class */
public final class TaskImpl extends Task {
    public final Runnable a;

    public TaskImpl(Runnable runnable, long j, TaskContext taskContext) {
        super(j, taskContext);
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.run();
        } finally {
            this.g.c();
        }
    }

    public String toString() {
        return "Task[" + DebugStringsKt.b(this.a) + '@' + DebugStringsKt.a(this.a) + ", " + this.f + ", " + this.g + ']';
    }
}
