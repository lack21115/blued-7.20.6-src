package kotlin.collections;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/AbstractMutableSet.class */
public abstract class AbstractMutableSet<E> extends java.util.AbstractSet<E> implements Set<E>, KMutableSet {
    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return a();
    }
}
