package kotlin.collections;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [K] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/AbstractMap$keys$1$iterator$1.class */
public final class AbstractMap$keys$1$iterator$1<K> implements Iterator<K>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Iterator<Map.Entry<K, V>> f42329a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public AbstractMap$keys$1$iterator$1(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
        this.f42329a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f42329a.hasNext();
    }

    @Override // java.util.Iterator
    public K next() {
        return (K) ((Map.Entry) this.f42329a.next()).getKey();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
