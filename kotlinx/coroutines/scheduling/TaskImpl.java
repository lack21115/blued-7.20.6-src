package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.DebugStringsKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/scheduling/TaskImpl.class */
public final class TaskImpl extends Task {

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f43585a;

    public TaskImpl(Runnable runnable, long j, TaskContext taskContext) {
        super(j, taskContext);
        this.f43585a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f43585a.run();
        } finally {
            this.g.c();
        }
    }

    public String toString() {
        return "Task[" + DebugStringsKt.b(this.f43585a) + '@' + DebugStringsKt.a(this.f43585a) + ", " + this.f + ", " + this.g + ']';
    }
}
