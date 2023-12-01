package kotlin.collections;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [V] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/AbstractMap$values$1$iterator$1.class */
public final class AbstractMap$values$1$iterator$1<V> implements Iterator<V>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Iterator<Map.Entry<K, V>> f42332a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public AbstractMap$values$1$iterator$1(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
        this.f42332a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f42332a.hasNext();
    }

    @Override // java.util.Iterator
    public V next() {
        return (V) ((Map.Entry) this.f42332a.next()).getValue();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
