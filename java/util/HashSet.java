package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/util/HashSet.class */
public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable {
    private static final long serialVersionUID = -5024744406713321676L;
    transient HashMap<E, HashSet<E>> backingMap;

    public HashSet() {
        this(new HashMap());
    }

    public HashSet(int i) {
        this(new HashMap(i));
    }

    public HashSet(int i, float f) {
        this(new HashMap(i, f));
    }

    public HashSet(Collection<? extends E> collection) {
        this(new HashMap(collection.size() < 6 ? 11 : collection.size() * 2));
        for (E e : collection) {
            add(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashSet(HashMap<E, HashSet<E>> hashMap) {
        this.backingMap = hashMap;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.backingMap = createBackingMap(objectInputStream.readInt(), objectInputStream.readFloat());
        int readInt = objectInputStream.readInt();
        while (true) {
            readInt--;
            if (readInt < 0) {
                return;
            }
            ((HashMap<E, HashSet<E>>) this.backingMap).put(objectInputStream.readObject(), this);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.backingMap.table.length);
        objectOutputStream.writeFloat(0.75f);
        objectOutputStream.writeInt(size());
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        return this.backingMap.put(e, this) == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.backingMap.clear();
    }

    public Object clone() {
        try {
            HashSet hashSet = (HashSet) super.clone();
            hashSet.backingMap = (HashMap) this.backingMap.clone();
            return hashSet;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.backingMap.containsKey(obj);
    }

    HashMap<E, HashSet<E>> createBackingMap(int i, float f) {
        return new HashMap<>(i, f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.backingMap.keySet().iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.backingMap.remove(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.backingMap.size();
    }
}
