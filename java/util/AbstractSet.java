package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/AbstractSet.class */
public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E> {
    @Override // java.util.Collection
    public boolean equals(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this == obj) {
            z2 = true;
        } else if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        z = true;
                        return z;
                    }
                }
                z = false;
                return z;
            } catch (ClassCastException e) {
                return false;
            } catch (NullPointerException e2) {
                return false;
            }
        }
        return z2;
    }

    @Override // java.util.Collection
    public int hashCode() {
        int i = 0;
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            E next = it.next();
            i += next == null ? 0 : next.hashCode();
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean z;
        boolean z2 = false;
        if (size() > collection.size()) {
            Iterator<?> it = collection.iterator();
            boolean z3 = false;
            while (true) {
                boolean z4 = z3;
                z = z4;
                if (!it.hasNext()) {
                    break;
                }
                z3 = remove(it.next()) || z4;
            }
        } else {
            Iterator<E> it2 = iterator();
            while (true) {
                z = z2;
                if (!it2.hasNext()) {
                    break;
                } else if (collection.contains(it2.next())) {
                    it2.remove();
                    z2 = true;
                }
            }
        }
        return z;
    }
}
