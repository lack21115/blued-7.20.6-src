package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysJvmKt.class */
public class ArraysKt___ArraysJvmKt extends ArraysKt__ArraysKt {
    public static final <C extends Collection<? super R>, R> C a(Object[] objArr, C destination, Class<R> klass) {
        Intrinsics.e(objArr, "<this>");
        Intrinsics.e(destination, "destination");
        Intrinsics.e(klass, "klass");
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return destination;
            }
            Object obj = objArr[i2];
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
            i = i2 + 1;
        }
    }

    public static final List<Byte> a(byte[] bArr) {
        Intrinsics.e(bArr, "<this>");
        return new ArraysKt___ArraysJvmKt$asList$1(bArr);
    }

    public static final <T> List<T> a(T[] tArr) {
        Intrinsics.e(tArr, "<this>");
        List<T> a2 = ArraysUtilJVM.a(tArr);
        Intrinsics.c(a2, "asList(this)");
        return a2;
    }

    public static final <R> List<R> a(Object[] objArr, Class<R> klass) {
        Intrinsics.e(objArr, "<this>");
        Intrinsics.e(klass, "klass");
        return (List) ArraysKt.a(objArr, new ArrayList(), klass);
    }

    public static final void a(int[] iArr, int i, int i2, int i3) {
        Intrinsics.e(iArr, "<this>");
        Arrays.fill(iArr, i2, i3, i);
    }

    public static final <T> void a(T[] tArr, T t, int i, int i2) {
        Intrinsics.e(tArr, "<this>");
        Arrays.fill(tArr, i, i2, t);
    }

    public static /* synthetic */ void a(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        ArraysKt.a(objArr, obj, i, i2);
    }

    public static final <T> void a(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.e(tArr, "<this>");
        Intrinsics.e(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static final byte[] a(byte[] bArr, int i, int i2) {
        Intrinsics.e(bArr, "<this>");
        ArraysKt.a(i2, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
        Intrinsics.c(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static final byte[] a(byte[] bArr, byte[] destination, int i, int i2, int i3) {
        Intrinsics.e(bArr, "<this>");
        Intrinsics.e(destination, "destination");
        System.arraycopy((Object) bArr, i2, (Object) destination, i, i3 - i2);
        return destination;
    }

    public static /* synthetic */ byte[] a(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        return ArraysKt.a(bArr, bArr2, i, i2, i3);
    }

    public static final <T> T[] a(T[] tArr, int i, int i2) {
        Intrinsics.e(tArr, "<this>");
        ArraysKt.a(i2, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i, i2);
        Intrinsics.c(tArr2, "copyOfRange(this, fromIndex, toIndex)");
        return tArr2;
    }

    public static final <T> T[] a(T[] tArr, T t) {
        Intrinsics.e(tArr, "<this>");
        int length = tArr.length;
        T[] result = (T[]) Arrays.copyOf(tArr, length + 1);
        result[length] = t;
        Intrinsics.c(result, "result");
        return result;
    }

    public static final <T> T[] a(T[] tArr, T[] destination, int i, int i2, int i3) {
        Intrinsics.e(tArr, "<this>");
        Intrinsics.e(destination, "destination");
        System.arraycopy(tArr, i2, destination, i, i3 - i2);
        return destination;
    }

    public static /* synthetic */ Object[] a(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return ArraysKt.a(objArr, objArr2, i, i2, i3);
    }
}
