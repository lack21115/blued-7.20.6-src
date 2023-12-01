package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1.class */
public final class ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1<T> implements Iterable<T>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object[] f42344a;

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return ArrayIteratorKt.a(this.f42344a);
    }
}
