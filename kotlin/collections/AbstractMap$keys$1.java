package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: Add missing generic type declarations: [K] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/AbstractMap$keys$1.class */
public final class AbstractMap$keys$1<K> extends AbstractSet<K> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AbstractMap<K, V> f42328a;

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f42328a.containsKey(obj);
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f42328a.size();
    }

    @Override // kotlin.collections.AbstractSet, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<K> iterator() {
        return new AbstractMap$keys$1$iterator$1(this.f42328a.entrySet().iterator());
    }
}
