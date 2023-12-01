package kotlin.math;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/math/Constants.class */
final class Constants {

    /* renamed from: a  reason: collision with root package name */
    public static final Constants f42557a = new Constants();
    public static final double b = Math.log(2.0d);

    /* renamed from: c  reason: collision with root package name */
    public static final double f42558c;
    public static final double d;
    public static final double e;
    public static final double f;
    public static final double g;

    static {
        double ulp = Math.ulp(1.0d);
        f42558c = ulp;
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
