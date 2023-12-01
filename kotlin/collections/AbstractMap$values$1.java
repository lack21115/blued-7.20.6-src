package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: Add missing generic type declarations: [V] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/AbstractMap$values$1.class */
public final class AbstractMap$values$1<V> extends AbstractCollection<V> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AbstractMap<K, V> f42331a;

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f42331a.containsValue(obj);
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f42331a.size();
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return new AbstractMap$values$1$iterator$1(this.f42331a.entrySet().iterator());
    }
}
