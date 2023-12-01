package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/SupervisorKt.class */
public final class SupervisorKt {
    public static final CompletableJob a(Job job) {
        return new SupervisorJobImpl(job);
    }

    public static /* synthetic */ CompletableJob a(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return a(job);
    }
}
