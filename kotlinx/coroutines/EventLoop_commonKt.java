package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/EventLoop_commonKt.class */
public final class EventLoop_commonKt {

    /* renamed from: a */
    private static final Symbol f42824a = new Symbol("REMOVED_TASK");
    private static final Symbol b = new Symbol("CLOSED_EMPTY");

    public static final long a(long j) {
        if (j <= 0) {
            return 0L;
        }
        if (j >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j;
    }

    public static final /* synthetic */ Symbol a() {
        return b;
    }

    public static final long b(long j) {
        return j / 1000000;
    }

    public static final /* synthetic */ Symbol b() {
        return f42824a;
    }
}
