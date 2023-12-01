package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/scheduling/NanoTimeSource.class */
public final class NanoTimeSource extends SchedulerTimeSource {
    public static final NanoTimeSource a = new NanoTimeSource();

    private NanoTimeSource() {
    }

    @Override // kotlinx.coroutines.scheduling.SchedulerTimeSource
    public long a() {
        return System.nanoTime();
    }
}
