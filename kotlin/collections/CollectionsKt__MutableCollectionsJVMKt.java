package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/CollectionsKt__MutableCollectionsJVMKt.class */
public class CollectionsKt__MutableCollectionsJVMKt extends CollectionsKt__IteratorsKt {
    public static final <T> void a(List<T> list, Comparator<? super T> comparator) {
        Intrinsics.e(list, "<this>");
        Intrinsics.e(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }

    public static final <T extends Comparable<? super T>> void d(List<T> list) {
        Intrinsics.e(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }
}
