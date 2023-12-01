package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/CollectionsKt__IterablesKt$Iterable$1.class */
public final class CollectionsKt__IterablesKt$Iterable$1<T> implements Iterable<T>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function0<Iterator<T>> f42373a;

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.f42373a.invoke();
    }
}
