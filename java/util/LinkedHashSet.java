package java.util;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/util/LinkedHashSet.class */
public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable {
    private static final long serialVersionUID = -2851667679971038690L;

    public LinkedHashSet() {
        super(new LinkedHashMap());
    }

    public LinkedHashSet(int i) {
        super(new LinkedHashMap(i));
    }

    public LinkedHashSet(int i, float f) {
        super(new LinkedHashMap(i, f));
    }

    public LinkedHashSet(Collection<? extends E> collection) {
        super(new LinkedHashMap(collection.size() < 6 ? 11 : collection.size() * 2));
        for (E e : collection) {
            add(e);
        }
    }

    @Override // java.util.HashSet
    HashMap<E, HashSet<E>> createBackingMap(int i, float f) {
        return new LinkedHashMap(i, f);
    }
}
