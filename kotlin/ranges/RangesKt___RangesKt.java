package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.ranges.IntProgression;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/RangesKt___RangesKt.class */
public class RangesKt___RangesKt extends RangesKt__RangesKt {
    public static final float a(float f, float f2) {
        float f3 = f;
        if (f < f2) {
            f3 = f2;
        }
        return f3;
    }

    public static final int a(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static final int a(IntRange intRange, Random random) {
        Intrinsics.e(intRange, "<this>");
        Intrinsics.e(random, "random");
        try {
            return RandomKt.a(random, intRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final long a(long j, long j2) {
        long j3 = j;
        if (j < j2) {
            j3 = j2;
        }
        return j3;
    }

    public static final IntProgression a(int i, int i2) {
        return IntProgression.f42576a.a(i, i2, -1);
    }

    public static final IntProgression a(IntProgression intProgression, int i) {
        Intrinsics.e(intProgression, "<this>");
        RangesKt.a(i > 0, Integer.valueOf(i));
        IntProgression.Companion companion = IntProgression.f42576a;
        int a2 = intProgression.a();
        int b = intProgression.b();
        if (intProgression.c() <= 0) {
            i = -i;
        }
        return companion.a(a2, b, i);
    }

    public static final float b(float f, float f2) {
        float f3 = f;
        if (f > f2) {
            f3 = f2;
        }
        return f3;
    }

    public static final long b(long j, long j2) {
        long j3 = j;
        if (j > j2) {
            j3 = j2;
        }
        return j3;
    }

    public static final IntRange b(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? IntRange.b.a() : new IntRange(i, i2 - 1);
    }

    public static final int c(int i, int i2) {
        int i3 = i;
        if (i < i2) {
            i3 = i2;
        }
        return i3;
    }

    public static final int d(int i, int i2) {
        int i3 = i;
        if (i > i2) {
            i3 = i2;
        }
        return i3;
    }
}
