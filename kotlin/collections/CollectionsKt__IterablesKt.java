package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/CollectionsKt__IterablesKt.class */
public class CollectionsKt__IterablesKt extends CollectionsKt__CollectionsKt {
    public static final <T> int a(Iterable<? extends T> iterable, int i) {
        Intrinsics.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            i = ((Collection) iterable).size();
        }
        return i;
    }

    public static final <T> List<T> a(Iterable<? extends Iterable<? extends T>> iterable) {
        Intrinsics.e(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Iterable<? extends T> iterable2 : iterable) {
            CollectionsKt.a((Collection) arrayList, (Iterable) iterable2);
        }
        return arrayList;
    }
}
