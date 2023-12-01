package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/scheduling/DefaultScheduler.class */
public final class DefaultScheduler extends ExperimentalCoroutineDispatcher {
    public static final DefaultScheduler b;
    private static final CoroutineDispatcher d;

    static {
        int a2;
        DefaultScheduler defaultScheduler = new DefaultScheduler();
        b = defaultScheduler;
        a2 = SystemPropsKt__SystemProps_commonKt.a("kotlinx.coroutines.io.parallelism", RangesKt.c(64, SystemPropsKt.a()), 0, 0, 12, (Object) null);
        d = new LimitingDispatcher(defaultScheduler, a2, "Dispatchers.IO", 1);
    }

    private DefaultScheduler() {
        super(0, 0, null, 7, null);
    }

    public final CoroutineDispatcher b() {
        return d;
    }

    @Override // kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.Default";
    }
}
