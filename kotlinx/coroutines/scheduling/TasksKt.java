package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/scheduling/TasksKt.class */
public final class TasksKt {
    public static final long a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final long e;
    public static SchedulerTimeSource f;

    static {
        long a2;
        int a3;
        int a4;
        int a5;
        long a6;
        a2 = SystemPropsKt__SystemProps_commonKt.a("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, (Object) null);
        a = a2;
        a3 = SystemPropsKt__SystemProps_commonKt.a("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, (Object) null);
        b = a3;
        a4 = SystemPropsKt__SystemProps_commonKt.a("kotlinx.coroutines.scheduler.core.pool.size", RangesKt.c(SystemPropsKt.a(), 2), 1, 0, 8, (Object) null);
        c = a4;
        a5 = SystemPropsKt__SystemProps_commonKt.a("kotlinx.coroutines.scheduler.max.pool.size", RangesKt.a(SystemPropsKt.a() * 128, c, 2097150), 0, 2097150, 4, (Object) null);
        d = a5;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a6 = SystemPropsKt__SystemProps_commonKt.a("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, (Object) null);
        e = timeUnit.toNanos(a6);
        f = NanoTimeSource.a;
    }
}
