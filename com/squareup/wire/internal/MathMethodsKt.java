package com.squareup.wire.internal;

import kotlin.Metadata;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/MathMethodsKt.class */
public final class MathMethodsKt {
    public static final long NANOS_PER_SECOND = 1000000000;

    public static final long addExactLong(long j, long j2) {
        long j3 = j + j2;
        boolean z = true;
        boolean z2 = (j2 ^ j) < 0;
        if ((j ^ j3) < 0) {
            z = false;
        }
        if (z2 || z) {
            return j3;
        }
        throw new ArithmeticException();
    }

    public static final long floorDivLong(long j, long j2) {
        long j3 = j / j2;
        if (j - (j2 * j3) == 0) {
            return j3;
        }
        long j4 = j3;
        if ((((j ^ j2) >> 63) | 1) < 0) {
            j4 = j3 - 1;
        }
        return j4;
    }

    public static final long floorModLong(long j, long j2) {
        long j3 = j % j2;
        if (j3 == 0) {
            return 0L;
        }
        return (((j ^ j2) >> 63) | 1) > 0 ? j3 : j3 + j2;
    }
}
