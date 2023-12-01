package android.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import libcore.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/util/MapCollections.class */
public abstract class MapCollections<K, V> {
    MapCollections<K, V>.EntrySet mEntrySet;
    MapCollections<K, V>.KeySet mKeySet;
    MapCollections<K, V>.ValuesCollection mValues;

    /* loaded from: source-9557208-dex2jar.jar:android/util/MapCollections$ArrayIterator.class */
    final class ArrayIterator<T> implements Iterator<T> {
        boolean mCanRemove = false;
        int mIndex;
        final int mOffset;
        int mSize;

        ArrayIterator(int i) {
            this.mOffset = i;
            this.mSize = MapCollections.this.colGetSize();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mIndex < this.mSize;
        }

        @Override // java.util.Iterator
        public T next() {
            T t = (T) MapCollections.this.colGetEntry(this.mIndex, this.mOffset);
            this.mIndex++;
            this.mCanRemove = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.mCanRemove) {
                throw new IllegalStateException();
            }
            this.mIndex--;
            this.mSize--;
            this.mCanRemove = false;
            MapCollections.this.colRemoveAt(this.mIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/util/MapCollections$EntrySet.class */
    public final class EntrySet implements Set<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.Set
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            return add((Map.Entry) ((Map.Entry) obj));
        }

        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int colGetSize = MapCollections.this.colGetSize();
            for (Map.Entry<K, V> entry : collection) {
                MapCollections.this.colPut(entry.getKey(), entry.getValue());
            }
            return colGetSize != MapCollections.this.colGetSize();
        }

        @Override // java.util.Set
        public void clear() {
            MapCollections.this.colClear();
        }

        @Override // java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int colIndexOfKey = MapCollections.this.colIndexOfKey(entry.getKey());
                if (colIndexOfKey >= 0) {
                    return Objects.equal(MapCollections.this.colGetEntry(colIndexOfKey, 1), entry.getValue());
                }
                return false;
            }
            return false;
        }

        @Override // java.util.Set
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set
        public boolean equals(Object obj) {
            return MapCollections.equalsSetHelper(this, obj);
        }

        @Override // java.util.Set
        public int hashCode() {
            int i = 0;
            int colGetSize = MapCollections.this.colGetSize();
            while (true) {
                int i2 = colGetSize - 1;
                if (i2 < 0) {
                    return i;
                }
                Object colGetEntry = MapCollections.this.colGetEntry(i2, 0);
                Object colGetEntry2 = MapCollections.this.colGetEntry(i2, 1);
                i += (colGetEntry2 == null ? 0 : colGetEntry2.hashCode()) ^ (colGetEntry == null ? 0 : colGetEntry.hashCode());
                colGetSize = i2;
            }
        }

        @Override // java.util.Set
        public boolean isEmpty() {
            return MapCollections.this.colGetSize() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new MapIterator();
        }

        @Override // java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection, java.util.List
        public int size() {
            return MapCollections.this.colGetSize();
        }

        @Override // java.util.Set
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/util/MapCollections$KeySet.class */
    public final class KeySet implements Set<K> {
        KeySet() {
        }

        @Override // java.util.Set
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public void clear() {
            MapCollections.this.colClear();
        }

        @Override // java.util.Set
        public boolean contains(Object obj) {
            return MapCollections.this.colIndexOfKey(obj) >= 0;
        }

        @Override // java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return MapCollections.containsAllHelper(MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set
        public boolean equals(Object obj) {
            return MapCollections.equalsSetHelper(this, obj);
        }

        @Override // java.util.Set
        public int hashCode() {
            int i = 0;
            int colGetSize = MapCollections.this.colGetSize();
            while (true) {
                int i2 = colGetSize - 1;
                if (i2 < 0) {
                    return i;
                }
                Object colGetEntry = MapCollections.this.colGetEntry(i2, 0);
                i += colGetEntry == null ? 0 : colGetEntry.hashCode();
                colGetSize = i2;
            }
        }

        @Override // java.util.Set
        public boolean isEmpty() {
            return MapCollections.this.colGetSize() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new ArrayIterator(0);
        }

        @Override // java.util.Set
        public boolean remove(Object obj) {
            int colIndexOfKey = MapCollections.this.colIndexOfKey(obj);
            if (colIndexOfKey >= 0) {
                MapCollections.this.colRemoveAt(colIndexOfKey);
                return true;
            }
            return false;
        }

        @Override // java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return MapCollections.removeAllHelper(MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return MapCollections.retainAllHelper(MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection, java.util.List
        public int size() {
            return MapCollections.this.colGetSize();
        }

        @Override // java.util.Set
        public Object[] toArray() {
            return MapCollections.this.toArrayHelper(0);
        }

        @Override // java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.toArrayHelper(tArr, 0);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/util/MapCollections$MapIterator.class */
    final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        int mEnd;
        boolean mEntryValid = false;
        int mIndex = -1;

        MapIterator() {
            this.mEnd = MapCollections.this.colGetSize() - 1;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            boolean z = true;
            if (this.mEntryValid) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (!Objects.equal(entry.getKey(), MapCollections.this.colGetEntry(this.mIndex, 0)) || !Objects.equal(entry.getValue(), MapCollections.this.colGetEntry(this.mIndex, 1))) {
                        z = false;
                    }
                    return z;
                }
                return false;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.mEntryValid) {
                return (K) MapCollections.this.colGetEntry(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.mEntryValid) {
                return (V) MapCollections.this.colGetEntry(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mIndex < this.mEnd;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            int i = 0;
            if (this.mEntryValid) {
                Object colGetEntry = MapCollections.this.colGetEntry(this.mIndex, 0);
                Object colGetEntry2 = MapCollections.this.colGetEntry(this.mIndex, 1);
                int hashCode = colGetEntry == null ? 0 : colGetEntry.hashCode();
                if (colGetEntry2 != null) {
                    i = colGetEntry2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.mIndex++;
            this.mEntryValid = true;
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.mEntryValid) {
                throw new IllegalStateException();
            }
            MapCollections.this.colRemoveAt(this.mIndex);
            this.mIndex--;
            this.mEnd--;
            this.mEntryValid = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.mEntryValid) {
                return (V) MapCollections.this.colSetValue(this.mIndex, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/util/MapCollections$ValuesCollection.class */
    public final class ValuesCollection implements Collection<V> {
        ValuesCollection() {
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public void clear() {
            MapCollections.this.colClear();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapCollections.this.colIndexOfValue(obj) >= 0;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapCollections.this.colGetSize() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ArrayIterator(1);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int colIndexOfValue = MapCollections.this.colIndexOfValue(obj);
            if (colIndexOfValue >= 0) {
                MapCollections.this.colRemoveAt(colIndexOfValue);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            int colGetSize = MapCollections.this.colGetSize();
            boolean z = false;
            int i = 0;
            while (i < colGetSize) {
                int i2 = colGetSize;
                int i3 = i;
                if (collection.contains(MapCollections.this.colGetEntry(i, 1))) {
                    MapCollections.this.colRemoveAt(i);
                    i3 = i - 1;
                    i2 = colGetSize - 1;
                    z = true;
                }
                i = i3 + 1;
                colGetSize = i2;
            }
            return z;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            int colGetSize = MapCollections.this.colGetSize();
            boolean z = false;
            int i = 0;
            while (i < colGetSize) {
                int i2 = colGetSize;
                int i3 = i;
                if (!collection.contains(MapCollections.this.colGetEntry(i, 1))) {
                    MapCollections.this.colRemoveAt(i);
                    i3 = i - 1;
                    i2 = colGetSize - 1;
                    z = true;
                }
                i = i3 + 1;
                colGetSize = i2;
            }
            return z;
        }

        @Override // java.util.Collection, java.util.List
        public int size() {
            return MapCollections.this.colGetSize();
        }

        @Override // java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapCollections.this.toArrayHelper(1);
        }

        @Override // java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.toArrayHelper(tArr, 1);
        }
    }

    public static <K, V> boolean containsAllHelper(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean equalsSetHelper(Set<T> set, Object obj) {
        boolean z;
        boolean z2 = false;
        if (set == obj) {
            z2 = true;
        } else if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
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

    public static <K, V> boolean removeAllHelper(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean retainAllHelper(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract void colClear();

    protected abstract Object colGetEntry(int i, int i2);

    protected abstract Map<K, V> colGetMap();

    protected abstract int colGetSize();

    protected abstract int colIndexOfKey(Object obj);

    protected abstract int colIndexOfValue(Object obj);

    protected abstract void colPut(K k, V v);

    protected abstract void colRemoveAt(int i);

    protected abstract V colSetValue(int i, V v);

    public Set<Map.Entry<K, V>> getEntrySet() {
        if (this.mEntrySet == null) {
            this.mEntrySet = new EntrySet();
        }
        return this.mEntrySet;
    }

    public Set<K> getKeySet() {
        if (this.mKeySet == null) {
            this.mKeySet = new KeySet();
        }
        return this.mKeySet;
    }

    public Collection<V> getValues() {
        if (this.mValues == null) {
            this.mValues = new ValuesCollection();
        }
        return this.mValues;
    }

    public Object[] toArrayHelper(int i) {
        int colGetSize = colGetSize();
        Object[] objArr = new Object[colGetSize];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= colGetSize) {
                return objArr;
            }
            objArr[i3] = colGetEntry(i3, i);
            i2 = i3 + 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.Object[]] */
    public <T> T[] toArrayHelper(T[] tArr, int i) {
        int colGetSize = colGetSize();
        T[] tArr2 = tArr;
        if (tArr.length < colGetSize) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), colGetSize);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= colGetSize) {
                break;
            }
            tArr2[i3] = colGetEntry(i3, i);
            i2 = i3 + 1;
        }
        if (tArr2.length > colGetSize) {
            tArr2[colGetSize] = null;
        }
        return tArr2;
    }
}
