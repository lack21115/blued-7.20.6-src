package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysKt$asIterable$$inlined$Iterable$8.class */
public final class ArraysKt___ArraysKt$asIterable$$inlined$Iterable$8 implements Iterable<Boolean>, KMappedMarker {
    final /* synthetic */ boolean[] a;

    @Override // java.lang.Iterable
    public Iterator<Boolean> iterator() {
        return ArrayIteratorsKt.a(this.a);
    }
}
