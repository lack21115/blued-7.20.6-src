package kotlin.collections;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/SetsKt__SetsKt.class */
public class SetsKt__SetsKt extends SetsKt__SetsJVMKt {
    public static final <T> Set<T> a() {
        return EmptySet.a;
    }

    public static final <T> Set<T> a(T... elements) {
        Intrinsics.e(elements, "elements");
        return elements.length > 0 ? ArraysKt.h(elements) : SetsKt.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> b(Set<? extends T> set) {
        Intrinsics.e(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : SetsKt.a(set.iterator().next()) : SetsKt.a();
    }
}
