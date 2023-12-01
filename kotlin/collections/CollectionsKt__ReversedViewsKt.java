package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/CollectionsKt__ReversedViewsKt.class */
class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(List<?> list, int i) {
        if (i >= 0 && i <= CollectionsKt.b((List) list)) {
            return CollectionsKt.b((List) list) - i;
        }
        throw new IndexOutOfBoundsException("Element index " + i + " must be in range [" + new IntRange(0, CollectionsKt.b((List) list)) + "].");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(List<?> list, int i) {
        if (i >= 0 && i <= list.size()) {
            return list.size() - i;
        }
        throw new IndexOutOfBoundsException("Position index " + i + " must be in range [" + new IntRange(0, list.size()) + "].");
    }
}
