package kotlin.collections.builders;

import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/builders/ListBuilderKt.class */
public final class ListBuilderKt {
    public static final <E> void a(E[] eArr, int i, int i2) {
        Intrinsics.e(eArr, "<this>");
        while (i < i2) {
            b(eArr, i);
            i++;
        }
    }

    public static final <E> E[] a(int i) {
        if (i >= 0) {
            return (E[]) new Object[i];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final <T> T[] a(T[] tArr, int i) {
        Intrinsics.e(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i);
        Intrinsics.c(tArr2, "copyOf(this, newSize)");
        return tArr2;
    }

    public static final <E> void b(E[] eArr, int i) {
        Intrinsics.e(eArr, "<this>");
        eArr[i] = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean b(T[] tArr, int i, int i2, List<?> list) {
        if (i2 != list.size()) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return true;
            }
            if (!Intrinsics.a(tArr[i + i4], list.get(i4))) {
                return false;
            }
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> String d(T[] tArr, int i, int i2) {
        StringBuilder sb = new StringBuilder((i2 * 3) + 2);
        sb.append("[");
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                sb.append("]");
                String sb2 = sb.toString();
                Intrinsics.c(sb2, "sb.toString()");
                return sb2;
            }
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(tArr[i + i4]);
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int e(T[] tArr, int i, int i2) {
        int i3 = 1;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i2) {
                return i3;
            }
            T t = tArr[i + i5];
            i3 = (i3 * 31) + (t != null ? t.hashCode() : 0);
            i4 = i5 + 1;
        }
    }
}
