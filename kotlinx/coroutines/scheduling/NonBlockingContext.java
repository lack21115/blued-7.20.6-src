package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/scheduling/NonBlockingContext.class */
public final class NonBlockingContext implements TaskContext {
    public static final NonBlockingContext a = new NonBlockingContext();
    private static final int b = 0;

    private NonBlockingContext() {
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public int b() {
        return b;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public void c() {
    }
}
