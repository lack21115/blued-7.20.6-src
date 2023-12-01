package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/AbstractSet.class */
public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E>, KMappedMarker {
    public static final Companion b = new Companion(null);

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/collections/AbstractSet$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(Collection<?> c) {
            Intrinsics.e(c, "c");
            Iterator<?> it = c.iterator();
            int i = 0;
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                Object next = it.next();
                i = i2 + (next != null ? next.hashCode() : 0);
            }
        }

        public final boolean a(Set<?> c, Set<?> other) {
            Intrinsics.e(c, "c");
            Intrinsics.e(other, "other");
            if (c.size() != other.size()) {
                return false;
            }
            return c.containsAll(other);
        }
    }

    protected AbstractSet() {
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            return b.a(this, (Set) obj);
        }
        return false;
    }

    @Override // java.util.Collection
    public int hashCode() {
        return b.a(this);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
