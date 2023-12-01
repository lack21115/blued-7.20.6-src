package kotlin.collections;

import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/CollectionsKt___CollectionsJvmKt.class */
public class CollectionsKt___CollectionsJvmKt extends CollectionsKt__ReversedViewsKt {
    public static final <T> void g(List<T> list) {
        Intrinsics.e(list, "<this>");
        Collections.reverse(list);
    }
}
