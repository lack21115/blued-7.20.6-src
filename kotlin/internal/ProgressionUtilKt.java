package kotlin.internal;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/internal/ProgressionUtilKt.class */
public final class ProgressionUtilKt {
    private static final int a(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    public static final int a(int i, int i2, int i3) {
        if (i3 > 0) {
            return i >= i2 ? i2 : i2 - b(i2, i, i3);
        } else if (i3 < 0) {
            return i <= i2 ? i2 : i2 + b(i, i2, -i3);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    private static final long a(long j, long j2) {
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }

    public static final long a(long j, long j2, long j3) {
        int i = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        if (i > 0) {
            return j >= j2 ? j2 : j2 - b(j2, j, j3);
        } else if (i < 0) {
            return j <= j2 ? j2 : j2 + b(j, j2, -j3);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    private static final int b(int i, int i2, int i3) {
        return a(a(i, i3) - a(i2, i3), i3);
    }

    private static final long b(long j, long j2, long j3) {
        return a(a(j, j3) - a(j2, j3), j3);
    }
}
