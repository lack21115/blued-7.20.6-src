package kotlin.internal;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/internal/UProgressionUtilKt.class */
public final class UProgressionUtilKt {
    public static final int a(int i, int i2, int i3) {
        if (i3 > 0) {
            return UnsignedKt.a(i, i2) >= 0 ? i2 : UInt.c(i2 - b(i2, i, UInt.c(i3)));
        } else if (i3 < 0) {
            return UnsignedKt.a(i, i2) <= 0 ? i2 : UInt.c(i2 + b(i, i2, UInt.c(-i3)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    public static final long a(long j, long j2, long j3) {
        int i = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        if (i > 0) {
            return UnsignedKt.a(j, j2) >= 0 ? j2 : ULong.c(j2 - b(j2, j, ULong.c(j3)));
        } else if (i < 0) {
            return UnsignedKt.a(j, j2) <= 0 ? j2 : ULong.c(j2 + b(j, j2, ULong.c(-j3)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    private static final int b(int i, int i2, int i3) {
        int b = UnsignedKt.b(i, i3);
        int b2 = UnsignedKt.b(i2, i3);
        int a2 = UnsignedKt.a(b, b2);
        int c2 = UInt.c(b - b2);
        return a2 >= 0 ? c2 : UInt.c(c2 + i3);
    }

    private static final long b(long j, long j2, long j3) {
        long b = UnsignedKt.b(j, j3);
        long b2 = UnsignedKt.b(j2, j3);
        int a2 = UnsignedKt.a(b, b2);
        long c2 = ULong.c(b - b2);
        return a2 >= 0 ? c2 : ULong.c(c2 + j3);
    }
}
