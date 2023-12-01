package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/SlidingWindowKt.class */
public final class SlidingWindowKt {
    public static final <T> Iterator<List<T>> a(Iterator<? extends T> iterator, int i, int i2, boolean z, boolean z2) {
        Intrinsics.e(iterator, "iterator");
        return !iterator.hasNext() ? EmptyIterator.f42378a : SequencesKt.b(new SlidingWindowKt$windowedIterator$1(i, i2, iterator, z2, z, null));
    }
}
