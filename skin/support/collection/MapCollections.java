package skin.support.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:skin/support/collection/MapCollections.class */
public abstract class MapCollections<K, V> {
    MapCollections<K, V>.EntrySet b;

    /* renamed from: c  reason: collision with root package name */
    MapCollections<K, V>.KeySet f44208c;
    MapCollections<K, V>.ValuesCollection d;

    /* loaded from: source-3503164-dex2jar.jar:skin/support/collection/MapCollections$ArrayIterator.class */
    final class ArrayIterator<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f44209a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f44210c;
        boolean d = false;

        ArrayIterator(int i) {
            this.f44209a = i;
            this.b = MapCollections.this.a();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f44210c < this.b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T t = (T) MapCollections.this.a(this.f44210c, this.f44209a);
                this.f44210c++;
                this.d = true;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.d) {
                throw new IllegalStateException();
            }
            int i = this.f44210c - 1;
            this.f44210c = i;
            this.b--;
            this.d = false;
            MapCollections.this.a(i);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:skin/support/collection/MapCollections$EntrySet.class */
    final class EntrySet implements Set<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.Set
        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int a2 = MapCollections.this.a();
            for (Map.Entry<K, V> entry : collection) {
                MapCollections.this.a((MapCollections) entry.getKey(), (K) entry.getValue());
            }
            return a2 != MapCollections.this.a();
        }

        @Override // java.util.Set
        public void clear() {
            MapCollections.this.c();
        }

        @Override // java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int a2 = MapCollections.this.a(entry.getKey());
                if (a2 < 0) {
                    return false;
                }
                return ContainerHelpers.a(MapCollections.this.a(a2, 1), entry.getValue());
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
            return MapCollections.a((Set) this, obj);
        }

        @Override // java.util.Set
        public int hashCode() {
            int i = 0;
            for (int a2 = MapCollections.this.a() - 1; a2 >= 0; a2--) {
                Object a3 = MapCollections.this.a(a2, 0);
                Object a4 = MapCollections.this.a(a2, 1);
                i += (a3 == null ? 0 : a3.hashCode()) ^ (a4 == null ? 0 : a4.hashCode());
            }
            return i;
        }

        @Override // java.util.Set
        public boolean isEmpty() {
            return MapCollections.this.a() == 0;
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
            return MapCollections.this.a();
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

    /* loaded from: source-3503164-dex2jar.jar:skin/support/collection/MapCollections$KeySet.class */
    final class KeySet implements Set<K> {
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
            MapCollections.this.c();
        }

        @Override // java.util.Set
        public boolean contains(Object obj) {
            return MapCollections.this.a(obj) >= 0;
        }

        @Override // java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return MapCollections.a((Map) MapCollections.this.b(), collection);
        }

        @Override // java.util.Set
        public boolean equals(Object obj) {
            return MapCollections.a((Set) this, obj);
        }

        @Override // java.util.Set
        public int hashCode() {
            int i = 0;
            for (int a2 = MapCollections.this.a() - 1; a2 >= 0; a2--) {
                Object a3 = MapCollections.this.a(a2, 0);
                i += a3 == null ? 0 : a3.hashCode();
            }
            return i;
        }

        @Override // java.util.Set
        public boolean isEmpty() {
            return MapCollections.this.a() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new ArrayIterator(0);
        }

        @Override // java.util.Set
        public boolean remove(Object obj) {
            int a2 = MapCollections.this.a(obj);
            if (a2 >= 0) {
                MapCollections.this.a(a2);
                return true;
            }
            return false;
        }

        @Override // java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return MapCollections.b(MapCollections.this.b(), collection);
        }

        @Override // java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return MapCollections.c(MapCollections.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection, java.util.List
        public int size() {
            return MapCollections.this.a();
        }

        @Override // java.util.Set
        public Object[] toArray() {
            return MapCollections.this.b(0);
        }

        @Override // java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.a(tArr, 0);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:skin/support/collection/MapCollections$MapIterator.class */
    final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        int f44213a;

        /* renamed from: c  reason: collision with root package name */
        boolean f44214c = false;
        int b = -1;

        MapIterator() {
            this.f44213a = MapCollections.this.a() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.b++;
                this.f44214c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this.f44214c) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    boolean z = false;
                    if (ContainerHelpers.a(entry.getKey(), MapCollections.this.a(this.b, 0))) {
                        z = false;
                        if (ContainerHelpers.a(entry.getValue(), MapCollections.this.a(this.b, 1))) {
                            z = true;
                        }
                    }
                    return z;
                }
                return false;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f44214c) {
                return (K) MapCollections.this.a(this.b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f44214c) {
                return (V) MapCollections.this.a(this.b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.f44213a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (this.f44214c) {
                int i = 0;
                Object a2 = MapCollections.this.a(this.b, 0);
                Object a3 = MapCollections.this.a(this.b, 1);
                int hashCode = a2 == null ? 0 : a2.hashCode();
                if (a3 != null) {
                    i = a3.hashCode();
                }
                return hashCode ^ i;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f44214c) {
                throw new IllegalStateException();
            }
            MapCollections.this.a(this.b);
            this.b--;
            this.f44213a--;
            this.f44214c = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.f44214c) {
                return (V) MapCollections.this.a(this.b, (int) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:skin/support/collection/MapCollections$ValuesCollection.class */
    final class ValuesCollection implements Collection<V> {
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
            MapCollections.this.c();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapCollections.this.b(obj) >= 0;
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
            return MapCollections.this.a() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ArrayIterator(1);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int b = MapCollections.this.b(obj);
            if (b >= 0) {
                MapCollections.this.a(b);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            int a2 = MapCollections.this.a();
            int i = 0;
            boolean z = false;
            while (i < a2) {
                int i2 = a2;
                int i3 = i;
                if (collection.contains(MapCollections.this.a(i, 1))) {
                    MapCollections.this.a(i);
                    i3 = i - 1;
                    i2 = a2 - 1;
                    z = true;
                }
                i = i3 + 1;
                a2 = i2;
            }
            return z;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            int a2 = MapCollections.this.a();
            int i = 0;
            boolean z = false;
            while (i < a2) {
                int i2 = a2;
                int i3 = i;
                if (!collection.contains(MapCollections.this.a(i, 1))) {
                    MapCollections.this.a(i);
                    i3 = i - 1;
                    i2 = a2 - 1;
                    z = true;
                }
                i = i3 + 1;
                a2 = i2;
            }
            return z;
        }

        @Override // java.util.Collection, java.util.List
        public int size() {
            return MapCollections.this.a();
        }

        @Override // java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapCollections.this.b(1);
        }

        @Override // java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.a(tArr, 1);
        }
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    return set.containsAll(set2);
                }
                return false;
            } catch (ClassCastException | NullPointerException e) {
                return false;
            }
        }
        return false;
    }

    public static <K, V> boolean b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int a();

    protected abstract int a(Object obj);

    protected abstract Object a(int i, int i2);

    protected abstract V a(int i, V v);

    protected abstract void a(int i);

    protected abstract void a(K k, V v);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.lang.Object[]] */
    public <T> T[] a(T[] tArr, int i) {
        int a2 = a();
        T[] tArr2 = tArr;
        if (tArr.length < a2) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a2);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= a2) {
                break;
            }
            tArr2[i3] = a(i3, i);
            i2 = i3 + 1;
        }
        if (tArr2.length > a2) {
            tArr2[a2] = null;
        }
        return tArr2;
    }

    protected abstract int b(Object obj);

    protected abstract Map<K, V> b();

    public Object[] b(int i) {
        int a2 = a();
        Object[] objArr = new Object[a2];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= a2) {
                return objArr;
            }
            objArr[i3] = a(i3, i);
            i2 = i3 + 1;
        }
    }

    protected abstract void c();

    public Set<Map.Entry<K, V>> d() {
        if (this.b == null) {
            this.b = new EntrySet();
        }
        return this.b;
    }

    public Set<K> e() {
        if (this.f44208c == null) {
            this.f44208c = new KeySet();
        }
        return this.f44208c;
    }

    public Collection<V> f() {
        if (this.d == null) {
            this.d = new ValuesCollection();
        }
        return this.d;
    }
}
