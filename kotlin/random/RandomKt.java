package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/random/RandomKt.class */
public final class RandomKt {
    public static final int a(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static final int a(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }

    public static final int a(Random random, IntRange range) {
        Intrinsics.e(random, "<this>");
        Intrinsics.e(range, "range");
        if (!range.e()) {
            return range.b() < Integer.MAX_VALUE ? random.a(range.a(), range.b() + 1) : range.a() > Integer.MIN_VALUE ? random.a(range.a() - 1, range.b()) + 1 : random.b();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final String a(Object from, Object until) {
        Intrinsics.e(from, "from");
        Intrinsics.e(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void b(int i, int i2) {
        if (!(i2 > i)) {
            throw new IllegalArgumentException(a(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }
}
