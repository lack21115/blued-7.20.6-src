package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/CollectionsKt__CollectionsKt.class */
public class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    public static final <T extends Comparable<? super T>> int a(List<? extends T> list, T t, int i, int i2) {
        Intrinsics.e(list, "<this>");
        a(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int a2 = ComparisonsKt.a(list.get(i4), t);
            if (a2 < 0) {
                i = i4 + 1;
            } else if (a2 <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static /* synthetic */ int a(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return CollectionsKt.a(list, comparable, i, i2);
    }

    public static final <T> Collection<T> a(T[] tArr) {
        Intrinsics.e(tArr, "<this>");
        return new ArrayAsCollection(tArr, false);
    }

    public static final IntRange a(Collection<?> collection) {
        Intrinsics.e(collection, "<this>");
        return new IntRange(0, collection.size() - 1);
    }

    private static final void a(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("fromIndex (" + i2 + ") is greater than toIndex (" + i3 + ").");
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is less than zero.");
        } else if (i3 <= i) {
        } else {
            throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i + ").");
        }
    }

    public static final <T> int b(List<? extends T> list) {
        Intrinsics.e(list, "<this>");
        return list.size() - 1;
    }

    public static final <T> List<T> b() {
        return EmptyList.f42379a;
    }

    public static final <T> List<T> b(T... elements) {
        Intrinsics.e(elements, "elements");
        return elements.length > 0 ? ArraysKt.a(elements) : CollectionsKt.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> c(List<? extends T> list) {
        Intrinsics.e(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : CollectionsKt.a(list.get(0)) : CollectionsKt.b();
    }

    public static final <T> List<T> c(T... elements) {
        Intrinsics.e(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(elements, true));
    }

    public static final void c() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static final <T> ArrayList<T> d(T... elements) {
        Intrinsics.e(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(new ArrayAsCollection(elements, true));
    }

    public static final void d() {
        throw new ArithmeticException("Count overflow has happened.");
    }
}
