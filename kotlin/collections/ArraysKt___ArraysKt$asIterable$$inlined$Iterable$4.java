package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysKt$asIterable$$inlined$Iterable$4.class */
public final class ArraysKt___ArraysKt$asIterable$$inlined$Iterable$4 implements Iterable<Integer>, KMappedMarker {
    final /* synthetic */ int[] a;

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return ArrayIteratorsKt.a(this.a);
    }
}
