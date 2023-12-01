package kotlin.math;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/math/MathKt__MathJVMKt.class */
public class MathKt__MathJVMKt extends MathKt__MathHKt {
    public static final int a(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d);
    }

    public static final long b(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d);
    }
}
