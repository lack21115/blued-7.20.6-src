package kotlin;

import android.widget.ExpandableListView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/UnsignedKt.class */
public final class UnsignedKt {
    public static final int a(int i, int i2) {
        return Intrinsics.a(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    public static final int a(long j, long j2) {
        return Intrinsics.a(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    public static final String a(long j) {
        return a(j, 10);
    }

    public static final String a(long j, int i) {
        if (j >= 0) {
            String l = Long.toString(j, CharsKt.a(i));
            Intrinsics.c(l, "toString(this, checkRadix(radix))");
            return l;
        }
        long j2 = i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        long j5 = j3;
        long j6 = j4;
        if (j4 >= j2) {
            j6 = j4 - j2;
            j5 = j3 + 1;
        }
        StringBuilder sb = new StringBuilder();
        String l2 = Long.toString(j5, CharsKt.a(i));
        Intrinsics.c(l2, "toString(this, checkRadix(radix))");
        sb.append(l2);
        String l3 = Long.toString(j6, CharsKt.a(i));
        Intrinsics.c(l3, "toString(this, checkRadix(radix))");
        sb.append(l3);
        return sb.toString();
    }

    public static final int b(int i, int i2) {
        return UInt.c((int) ((i & ExpandableListView.PACKED_POSITION_VALUE_NULL) % (i2 & ExpandableListView.PACKED_POSITION_VALUE_NULL)));
    }

    public static final long b(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? j : ULong.c(j - j2);
        } else if (j >= 0) {
            return ULong.c(j % j2);
        } else {
            long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
            if (a(ULong.c(j3), ULong.c(j2)) < 0) {
                j2 = 0;
            }
            return ULong.c(j3 - j2);
        }
    }
}
