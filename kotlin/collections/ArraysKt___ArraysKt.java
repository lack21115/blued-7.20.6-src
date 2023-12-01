package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysKt.class */
public class ArraysKt___ArraysKt extends ArraysKt___ArraysJvmKt {
    public static final char a(char[] cArr) {
        Intrinsics.e(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            if (length == 1) {
                return cArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T, A extends Appendable> A a(T[] tArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        int i2;
        Intrinsics.e(tArr, "<this>");
        Intrinsics.e(buffer, "buffer");
        Intrinsics.e(separator, "separator");
        Intrinsics.e(prefix, "prefix");
        Intrinsics.e(postfix, "postfix");
        Intrinsics.e(truncated, "truncated");
        buffer.append(prefix);
        int length = tArr.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i2 = i4;
            if (i3 >= length) {
                break;
            }
            T t = tArr[i3];
            i4++;
            if (i4 > 1) {
                buffer.append(separator);
            }
            if (i >= 0) {
                i2 = i4;
                if (i4 > i) {
                    break;
                }
            }
            StringsKt.a(buffer, t, function1);
            i3++;
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static /* synthetic */ Appendable a(Object[] objArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
            i = -1;
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
            function1 = null;
        }
        return ArraysKt.a(objArr, appendable, charSequence, charSequence2, charSequence3, i, charSequence4, function1);
    }

    public static final <T, C extends Collection<? super T>> C a(T[] tArr, C destination) {
        Intrinsics.e(tArr, "<this>");
        Intrinsics.e(destination, "destination");
        int length = tArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return destination;
            }
            destination.add(tArr[i2]);
            i = i2 + 1;
        }
    }

    public static final List<Byte> a(byte[] bArr, IntRange indices) {
        Intrinsics.e(bArr, "<this>");
        Intrinsics.e(indices, "indices");
        return indices.e() ? CollectionsKt.b() : ArraysKt.a(ArraysKt.a(bArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final boolean a(byte[] bArr, byte b) {
        Intrinsics.e(bArr, "<this>");
        return ArraysKt.b(bArr, b) >= 0;
    }

    public static final boolean a(char[] cArr, char c2) {
        Intrinsics.e(cArr, "<this>");
        return ArraysKt.b(cArr, c2) >= 0;
    }

    public static final boolean a(int[] iArr, int i) {
        Intrinsics.e(iArr, "<this>");
        return ArraysKt.b(iArr, i) >= 0;
    }

    public static final boolean a(long[] jArr, long j) {
        Intrinsics.e(jArr, "<this>");
        return ArraysKt.b(jArr, j) >= 0;
    }

    public static final boolean a(short[] sArr, short s) {
        Intrinsics.e(sArr, "<this>");
        return ArraysKt.b(sArr, s) >= 0;
    }

    public static final boolean a(boolean[] zArr, boolean z) {
        Intrinsics.e(zArr, "<this>");
        return ArraysKt.b(zArr, z) >= 0;
    }

    public static final int b(byte[] bArr, byte b) {
        Intrinsics.e(bArr, "<this>");
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return -1;
            }
            if (b == bArr[i2]) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public static final int b(char[] cArr, char c2) {
        Intrinsics.e(cArr, "<this>");
        int length = cArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return -1;
            }
            if (c2 == cArr[i2]) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public static final int b(int[] iArr, int i) {
        Intrinsics.e(iArr, "<this>");
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return -1;
            }
            if (i == iArr[i3]) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    public static final int b(long[] jArr, long j) {
        Intrinsics.e(jArr, "<this>");
        int length = jArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return -1;
            }
            if (j == jArr[i2]) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public static final int b(short[] sArr, short s) {
        Intrinsics.e(sArr, "<this>");
        int length = sArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return -1;
            }
            if (s == sArr[i2]) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public static final int b(boolean[] zArr, boolean z) {
        Intrinsics.e(zArr, "<this>");
        int length = zArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return -1;
            }
            if (z == zArr[i2]) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public static final <T> T b(T[] tArr) {
        Intrinsics.e(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T> boolean b(T[] tArr, T t) {
        Intrinsics.e(tArr, "<this>");
        return ArraysKt.c(tArr, t) >= 0;
    }

    public static final <T> T[] b(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.e(tArr, "<this>");
        Intrinsics.e(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        Intrinsics.c(tArr2, "copyOf(this, size)");
        ArraysKt.a((Object[]) tArr2, (Comparator) comparator);
        return tArr2;
    }

    public static final int c(byte[] bArr, byte b) {
        Intrinsics.e(bArr, "<this>");
        int length = bArr.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i = length - 1;
            if (b == bArr[length]) {
                return length;
            }
            if (i < 0) {
                return -1;
            }
            length = i;
        }
    }

    public static final int c(char[] cArr, char c2) {
        Intrinsics.e(cArr, "<this>");
        int length = cArr.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i = length - 1;
            if (c2 == cArr[length]) {
                return length;
            }
            if (i < 0) {
                return -1;
            }
            length = i;
        }
    }

    public static final int c(int[] iArr, int i) {
        Intrinsics.e(iArr, "<this>");
        int length = iArr.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i2 = length - 1;
            if (i == iArr[length]) {
                return length;
            }
            if (i2 < 0) {
                return -1;
            }
            length = i2;
        }
    }

    public static final int c(long[] jArr, long j) {
        Intrinsics.e(jArr, "<this>");
        int length = jArr.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i = length - 1;
            if (j == jArr[length]) {
                return length;
            }
            if (i < 0) {
                return -1;
            }
            length = i;
        }
    }

    public static final <T> int c(T[] tArr, T t) {
        Intrinsics.e(tArr, "<this>");
        if (t == null) {
            int length = tArr.length;
            for (int i = 0; i < length; i++) {
                if (tArr[i] == null) {
                    return i;
                }
            }
            return -1;
        }
        int length2 = tArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length2) {
                return -1;
            }
            if (Intrinsics.a(t, tArr[i3])) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    public static final int c(short[] sArr, short s) {
        Intrinsics.e(sArr, "<this>");
        int length = sArr.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i = length - 1;
            if (s == sArr[length]) {
                return length;
            }
            if (i < 0) {
                return -1;
            }
            length = i;
        }
    }

    public static final int c(boolean[] zArr, boolean z) {
        Intrinsics.e(zArr, "<this>");
        int length = zArr.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i = length - 1;
            if (z == zArr[length]) {
                return length;
            }
            if (i < 0) {
                return -1;
            }
            length = i;
        }
    }

    public static final <T> List<T> c(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.e(tArr, "<this>");
        Intrinsics.e(comparator, "comparator");
        return ArraysKt.a(ArraysKt.b((Object[]) tArr, (Comparator) comparator));
    }

    public static final <T> void c(T[] tArr) {
        Intrinsics.e(tArr, "<this>");
        int length = (tArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int d = ArraysKt.d(tArr);
        int i = 0;
        if (length < 0) {
            return;
        }
        while (true) {
            T t = tArr[i];
            tArr[i] = tArr[d];
            tArr[d] = t;
            d--;
            if (i == length) {
                return;
            }
            i++;
        }
    }

    public static final <T> int d(T[] tArr) {
        Intrinsics.e(tArr, "<this>");
        return tArr.length - 1;
    }

    public static final <T> HashSet<T> e(T[] tArr) {
        Intrinsics.e(tArr, "<this>");
        return (HashSet) ArraysKt.a((Object[]) tArr, new HashSet(MapsKt.b(tArr.length)));
    }

    public static final <T> List<T> f(T[] tArr) {
        Intrinsics.e(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? ArraysKt.g(tArr) : CollectionsKt.a(tArr[0]) : CollectionsKt.b();
    }

    public static final <T> List<T> g(T[] tArr) {
        Intrinsics.e(tArr, "<this>");
        return new ArrayList(CollectionsKt.a((Object[]) tArr));
    }

    public static final <T> Set<T> h(T[] tArr) {
        Intrinsics.e(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? (Set) ArraysKt.a((Object[]) tArr, new LinkedHashSet(MapsKt.b(tArr.length))) : SetsKt.a(tArr[0]) : SetsKt.a();
    }
}
