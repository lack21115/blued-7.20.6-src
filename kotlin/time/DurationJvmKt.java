package kotlin.time;

import java.text.DecimalFormat;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/time/DurationJvmKt.class */
public final class DurationJvmKt {
    private static final boolean a = Duration.class.desiredAssertionStatus();
    private static final ThreadLocal<DecimalFormat>[] b;

    static {
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 4) {
                b = threadLocalArr;
                return;
            } else {
                threadLocalArr[i2] = new ThreadLocal<>();
                i = i2 + 1;
            }
        }
    }

    public static final boolean a() {
        return a;
    }
}
