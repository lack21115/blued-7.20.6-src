package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/CollectionsKt__CollectionsJVMKt.class */
public class CollectionsKt__CollectionsJVMKt {
    public static final <E> List<E> a() {
        return new ListBuilder();
    }

    public static final <E> List<E> a(int i) {
        return new ListBuilder(i);
    }

    public static final <T> List<T> a(T t) {
        List<T> singletonList = Collections.singletonList(t);
        Intrinsics.c(singletonList, "singletonList(element)");
        return singletonList;
    }

    public static final <E> List<E> a(List<E> builder) {
        Intrinsics.e(builder, "builder");
        return ((ListBuilder) builder).a();
    }

    public static final <T> Object[] a(T[] tArr, boolean z) {
        Intrinsics.e(tArr, "<this>");
        if (z && Intrinsics.a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        Intrinsics.c(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }
}
