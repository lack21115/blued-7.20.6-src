package kotlin.time;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/time/DurationKt.class */
public final class DurationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long b(long j, int i) {
        return Duration.s((j << 1) + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long c(long j) {
        return j * 1000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long d(long j) {
        return Duration.s((j << 1) + 1);
    }
}
