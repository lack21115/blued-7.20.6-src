package kotlin.math;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/math/Constants.class */
final class Constants {
    public static final Constants a = new Constants();
    public static final double b = Math.log(2.0d);
    public static final double c;
    public static final double d;
    public static final double e;
    public static final double f;
    public static final double g;

    static {
        double ulp = Math.ulp(1.0d);
        c = ulp;
        double sqrt = Math.sqrt(ulp);
        d = sqrt;
        double sqrt2 = Math.sqrt(sqrt);
        e = sqrt2;
        double d2 = 1;
        f = d2 / d;
        g = d2 / sqrt2;
    }

    private Constants() {
    }
}
