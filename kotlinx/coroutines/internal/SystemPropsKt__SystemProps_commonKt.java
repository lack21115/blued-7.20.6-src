package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/SystemPropsKt__SystemProps_commonKt.class */
public final /* synthetic */ class SystemPropsKt__SystemProps_commonKt {
    public static final int a(String str, int i, int i2, int i3) {
        return (int) SystemPropsKt.a(str, i, i2, i3);
    }

    public static /* synthetic */ int a(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return SystemPropsKt.a(str, i, i2, i3);
    }

    public static final long a(String str, long j, long j2, long j3) {
        String a2 = SystemPropsKt.a(str);
        if (a2 == null) {
            return j;
        }
        Long c2 = StringsKt.c(a2);
        if (c2 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + a2 + '\'').toString());
        }
        long longValue = c2.longValue();
        boolean z = false;
        if (j2 <= longValue) {
            z = false;
            if (longValue <= j3) {
                z = true;
            }
        }
        if (z) {
            return longValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
    }

    public static /* synthetic */ long a(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return SystemPropsKt.a(str, j, j2, j3);
    }

    public static final boolean a(String str, boolean z) {
        String a2 = SystemPropsKt.a(str);
        return a2 == null ? z : Boolean.parseBoolean(a2);
    }
}
