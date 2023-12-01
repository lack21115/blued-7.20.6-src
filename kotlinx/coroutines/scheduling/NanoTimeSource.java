package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/scheduling/NanoTimeSource.class */
public final class NanoTimeSource extends SchedulerTimeSource {

    /* renamed from: a  reason: collision with root package name */
    public static final NanoTimeSource f43583a = new NanoTimeSource();

    private NanoTimeSource() {
    }

    @Override // kotlinx.coroutines.scheduling.SchedulerTimeSource
    public long a() {
        return System.nanoTime();
    }
}
