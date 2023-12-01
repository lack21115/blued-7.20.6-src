package java.util;

import com.igexin.push.core.b;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.MapEntry;

/* loaded from: source-2895416-dex2jar.jar:java/util/EnumMap.class */
public class EnumMap<K extends Enum<K>, V> extends AbstractMap<K, V> implements Serializable, Cloneable, Map<K, V> {
    private static final long serialVersionUID = 458661240069192865L;
    private transient EnumMapEntrySet<K, V> entrySet = null;
    transient int enumSize;
    transient boolean[] hasMapping;
    private Class<K> keyType;
    transient Enum[] keys;
    private transient int mappingsCount;
    transient Object[] values;

    /* loaded from: source-2895416-dex2jar.jar:java/util/EnumMap$Entry.class */
    private static class Entry<KT extends Enum<KT>, VT> extends MapEntry<KT, VT> {
        private final EnumMap<KT, VT> enumMap;
        private final int ordinal;

        Entry(KT kt, VT vt, EnumMap<KT, VT> enumMap) {
            super(kt, vt);
            this.enumMap = enumMap;
            this.ordinal = kt.ordinal();
        }

        private void checkEntryStatus() {
            if (!this.enumMap.hasMapping[this.ordinal]) {
                throw new IllegalStateException();
            }
        }

        @Override // java.util.MapEntry, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this.enumMap.hasMapping[this.ordinal]) {
                boolean z = false;
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    z = false;
                    if (((Enum) this.key).equals(entry.getKey())) {
                        Object value = entry.getValue();
                        z = this.enumMap.values[this.ordinal] == null ? value == null : this.enumMap.values[this.ordinal].equals(value);
                    }
                }
                return z;
            }
            return false;
        }

        @Override // java.util.MapEntry, java.util.Map.Entry
        public KT getKey() {
            checkEntryStatus();
            return (KT) this.enumMap.keys[this.ordinal];
        }

        @Override // java.util.MapEntry, java.util.Map.Entry
        public VT getValue() {
            checkEntryStatus();
            return (VT) this.enumMap.values[this.ordinal];
        }

        @Override // java.util.MapEntry, java.util.Map.Entry
        public int hashCode() {
            int i = 0;
            int hashCode = this.enumMap.keys[this.ordinal] == null ? 0 : this.enumMap.keys[this.ordinal].hashCode();
            if (this.enumMap.values[this.ordinal] != null) {
                i = this.enumMap.values[this.ordinal].hashCode();
            }
            return hashCode ^ i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.MapEntry, java.util.Map.Entry
        public VT setValue(VT vt) {
            checkEntryStatus();
            return (VT) this.enumMap.put((EnumMap<KT, VT>) this.enumMap.keys[this.ordinal], (Enum) vt);
        }

        @Override // java.util.MapEntry
        public String toString() {
            StringBuilder sb = new StringBuilder(this.enumMap.keys[this.ordinal].toString());
            sb.append("=");
            sb.append(this.enumMap.values[this.ordinal] == null ? b.l : this.enumMap.values[this.ordinal].toString());
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/EnumMap$EnumMapEntryIterator.class */
    public static class EnumMapEntryIterator<E, KT extends Enum<KT>, VT> extends EnumMapIterator<E, KT, VT> {
        EnumMapEntryIterator(MapEntry.Type<E, KT, VT> type, EnumMap<KT, VT> enumMap) {
            super(type, enumMap);
        }

        @Override // java.util.EnumMap.EnumMapIterator, java.util.Iterator
        public E next() {
            if (hasNext()) {
                int i = this.position;
                this.position = i + 1;
                this.prePosition = i;
                return this.type.get(new Entry(this.enumMap.keys[this.prePosition], this.enumMap.values[this.prePosition], this.enumMap));
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/EnumMap$EnumMapEntrySet.class */
    public static class EnumMapEntrySet<KT extends Enum<KT>, VT> extends AbstractSet<Map.Entry<KT, VT>> {
        private final EnumMap<KT, VT> enumMap;

        EnumMapEntrySet(EnumMap<KT, VT> enumMap) {
            this.enumMap = enumMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.enumMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            boolean z = false;
            if (obj instanceof Map.Entry) {
                Object key = ((Map.Entry) obj).getKey();
                Object value = ((Map.Entry) obj).getValue();
                z = false;
                if (this.enumMap.containsKey(key)) {
                    VT vt = this.enumMap.get(key);
                    if (vt != null) {
                        return vt.equals(value);
                    }
                    if (value != null) {
                        return false;
                    }
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<KT, VT>> iterator() {
            return new EnumMapEntryIterator(new MapEntry.Type<Map.Entry<KT, VT>, KT, VT>() { // from class: java.util.EnumMap.EnumMapEntrySet.1
                @Override // java.util.MapEntry.Type
                public Map.Entry<KT, VT> get(MapEntry<KT, VT> mapEntry) {
                    return mapEntry;
                }
            }, this.enumMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj)) {
                this.enumMap.remove(((Map.Entry) obj).getKey());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.enumMap.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return toArray(new Object[this.enumMap.size()]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray(Object[] objArr) {
            int size = this.enumMap.size();
            int i = 0;
            Object[] objArr2 = objArr;
            if (size > objArr.length) {
                objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
            }
            Iterator<Map.Entry<KT, VT>> it = iterator();
            while (i < size) {
                Map.Entry<KT, VT> next = it.next();
                objArr2[i] = new MapEntry(next.getKey(), next.getValue());
                i++;
            }
            if (i < objArr.length) {
                objArr2[i] = null;
            }
            return objArr2;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/EnumMap$EnumMapIterator.class */
    private static class EnumMapIterator<E, KT extends Enum<KT>, VT> implements Iterator<E> {
        final EnumMap<KT, VT> enumMap;
        int position = 0;
        int prePosition = -1;
        final MapEntry.Type<E, KT, VT> type;

        EnumMapIterator(MapEntry.Type<E, KT, VT> type, EnumMap<KT, VT> enumMap) {
            this.enumMap = enumMap;
            this.type = type;
        }

        private void checkStatus() {
            if (this.prePosition == -1) {
                throw new IllegalStateException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.enumMap.enumSize;
            while (this.position < i && !this.enumMap.hasMapping[this.position]) {
                this.position++;
            }
            return this.position != i;
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                int i = this.position;
                this.position = i + 1;
                this.prePosition = i;
                return this.type.get(new MapEntry<>(this.enumMap.keys[this.prePosition], this.enumMap.values[this.prePosition]));
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            checkStatus();
            if (this.enumMap.hasMapping[this.prePosition]) {
                this.enumMap.remove(this.enumMap.keys[this.prePosition]);
            }
            this.prePosition = -1;
        }

        public String toString() {
            return this.prePosition == -1 ? super.toString() : this.type.get(new MapEntry<>(this.enumMap.keys[this.prePosition], this.enumMap.values[this.prePosition])).toString();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/EnumMap$EnumMapKeySet.class */
    private static class EnumMapKeySet<KT extends Enum<KT>, VT> extends AbstractSet<KT> {
        private final EnumMap<KT, VT> enumMap;

        EnumMapKeySet(EnumMap<KT, VT> enumMap) {
            this.enumMap = enumMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.enumMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.enumMap.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new EnumMapIterator(new MapEntry.Type<KT, KT, VT>() { // from class: java.util.EnumMap.EnumMapKeySet.1
                @Override // java.util.MapEntry.Type
                public KT get(MapEntry<KT, VT> mapEntry) {
                    return mapEntry.key;
                }

                @Override // java.util.MapEntry.Type
                public /* bridge */ /* synthetic */ Object get(MapEntry mapEntry) {
                    return get((MapEntry<Enum, VT>) mapEntry);
                }
            }, this.enumMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj)) {
                this.enumMap.remove(obj);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.enumMap.size();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/EnumMap$EnumMapValueCollection.class */
    private static class EnumMapValueCollection<KT extends Enum<KT>, VT> extends AbstractCollection<VT> {
        private final EnumMap<KT, VT> enumMap;

        EnumMapValueCollection(EnumMap<KT, VT> enumMap) {
            this.enumMap = enumMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.enumMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.enumMap.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new EnumMapIterator(new MapEntry.Type<VT, KT, VT>() { // from class: java.util.EnumMap.EnumMapValueCollection.1
                @Override // java.util.MapEntry.Type
                public VT get(MapEntry<KT, VT> mapEntry) {
                    return mapEntry.value;
                }
            }, this.enumMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj == null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.enumMap.enumSize) {
                        return false;
                    }
                    if (this.enumMap.hasMapping[i2] && this.enumMap.values[i2] == null) {
                        this.enumMap.remove(this.enumMap.keys[i2]);
                        return true;
                    }
                    i = i2 + 1;
                }
            } else {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= this.enumMap.enumSize) {
                        return false;
                    }
                    if (this.enumMap.hasMapping[i4] && obj.equals(this.enumMap.values[i4])) {
                        this.enumMap.remove(this.enumMap.keys[i4]);
                        return true;
                    }
                    i3 = i4 + 1;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.enumMap.size();
        }
    }

    public EnumMap(Class<K> cls) {
        initialization(cls);
    }

    public EnumMap(EnumMap<K, ? extends V> enumMap) {
        initialization(enumMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EnumMap(Map<K, ? extends V> map) {
        if (map instanceof EnumMap) {
            initialization((EnumMap) map);
        } else if (map.isEmpty()) {
            throw new IllegalArgumentException("map is empty");
        } else {
            Class<?> cls = map.keySet().iterator().next().getClass();
            if (cls.isEnum()) {
                initialization(cls);
            } else {
                initialization(cls.getSuperclass());
            }
            putAllImpl(map);
        }
    }

    private void initialization(Class<K> cls) {
        this.keyType = cls;
        this.keys = Enum.getSharedConstants(this.keyType);
        this.enumSize = this.keys.length;
        this.values = new Object[this.enumSize];
        this.hasMapping = new boolean[this.enumSize];
    }

    private void initialization(EnumMap enumMap) {
        this.keyType = enumMap.keyType;
        this.keys = enumMap.keys;
        this.enumSize = enumMap.enumSize;
        this.values = (Object[]) enumMap.values.clone();
        this.hasMapping = (boolean[]) enumMap.hasMapping.clone();
        this.mappingsCount = enumMap.mappingsCount;
    }

    private boolean isValidKeyType(Object obj) {
        return obj != null && this.keyType.isInstance(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void putAllImpl(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            putImpl((Enum) entry.getKey(), entry.getValue());
        }
    }

    private V putImpl(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        this.keyType.cast(k);
        int ordinal = k.ordinal();
        if (!this.hasMapping[ordinal]) {
            this.hasMapping[ordinal] = true;
            this.mappingsCount++;
        }
        V v2 = (V) this.values[ordinal];
        this.values[ordinal] = v;
        return v2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        initialization(this.keyType);
        int readInt = objectInputStream.readInt();
        while (true) {
            int i = readInt;
            if (i <= 0) {
                return;
            }
            putImpl((Enum) objectInputStream.readObject(), objectInputStream.readObject());
            readInt = i - 1;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.mappingsCount);
        for (Map.Entry<K, V> entry : entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.values, (Object) null);
        Arrays.fill(this.hasMapping, false);
        this.mappingsCount = 0;
    }

    @Override // java.util.AbstractMap
    public EnumMap<K, V> clone() {
        try {
            EnumMap<K, V> enumMap = (EnumMap) super.clone();
            enumMap.initialization(this);
            return enumMap;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (isValidKeyType(obj)) {
            return this.hasMapping[((Enum) obj).ordinal()];
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.enumSize) {
                    return false;
                }
                if (this.hasMapping[i2] && this.values[i2] == null) {
                    return true;
                }
                i = i2 + 1;
            }
        } else {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.enumSize) {
                    return false;
                }
                if (this.hasMapping[i4] && obj.equals(this.values[i4])) {
                    return true;
                }
                i3 = i4 + 1;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new EnumMapEntrySet<>(this);
        }
        return this.entrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EnumMap) {
            EnumMap enumMap = (EnumMap) obj;
            return this.keyType == enumMap.keyType && size() == enumMap.size() && Arrays.equals(this.hasMapping, enumMap.hasMapping) && Arrays.equals(this.values, enumMap.values);
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (isValidKeyType(obj)) {
            return (V) this.values[((Enum) obj).ordinal()];
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = new EnumMapKeySet(this);
        }
        return (Set<K>) this.keySet;
    }

    public V put(K k, V v) {
        return putImpl(k, v);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((EnumMap<K, V>) ((Enum) obj), (Enum) obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        putAllImpl(map);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (isValidKeyType(obj)) {
            int ordinal = ((Enum) obj).ordinal();
            if (this.hasMapping[ordinal]) {
                this.hasMapping[ordinal] = false;
                this.mappingsCount--;
            }
            V v = (V) this.values[ordinal];
            this.values[ordinal] = null;
            return v;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.mappingsCount;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        if (this.valuesCollection == null) {
            this.valuesCollection = new EnumMapValueCollection(this);
        }
        return this.valuesCollection;
    }
}
