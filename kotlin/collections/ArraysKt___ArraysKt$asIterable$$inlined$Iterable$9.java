package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysKt$asIterable$$inlined$Iterable$9.class */
public final class ArraysKt___ArraysKt$asIterable$$inlined$Iterable$9 implements Iterable<Character>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ char[] f42352a;

    @Override // java.lang.Iterable
    public Iterator<Character> iterator() {
        return ArrayIteratorsKt.a(this.f42352a);
    }
}
