package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysKt$asIterable$$inlined$Iterable$2.class */
public final class ArraysKt___ArraysKt$asIterable$$inlined$Iterable$2 implements Iterable<Byte>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ byte[] f42345a;

    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return ArrayIteratorsKt.a(this.f42345a);
    }
}
