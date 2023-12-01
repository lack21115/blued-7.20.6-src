package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysKt$asIterable$$inlined$Iterable$3.class */
public final class ArraysKt___ArraysKt$asIterable$$inlined$Iterable$3 implements Iterable<Short>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ short[] f42346a;

    @Override // java.lang.Iterable
    public Iterator<Short> iterator() {
        return ArrayIteratorsKt.a(this.f42346a);
    }
}
