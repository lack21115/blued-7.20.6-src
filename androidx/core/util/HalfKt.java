package androidx.core.util;

import android.util.Half;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/util/HalfKt.class */
public final class HalfKt {
    public static final Half toHalf(double d) {
        Half valueOf = Half.valueOf((float) d);
        Intrinsics.c(valueOf, "valueOf(this)");
        return valueOf;
    }

    public static final Half toHalf(float f) {
        Half valueOf = Half.valueOf(f);
        Intrinsics.c(valueOf, "valueOf(this)");
        return valueOf;
    }

    public static final Half toHalf(String str) {
        Intrinsics.e(str, "<this>");
        Half valueOf = Half.valueOf(str);
        Intrinsics.c(valueOf, "valueOf(this)");
        return valueOf;
    }

    public static final Half toHalf(short s) {
        Half valueOf = Half.valueOf(s);
        Intrinsics.c(valueOf, "valueOf(this)");
        return valueOf;
    }
}
