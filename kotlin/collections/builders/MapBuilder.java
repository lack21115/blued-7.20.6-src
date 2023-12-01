package kotlin.collections.builders;

import com.alipay.sdk.util.i;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/builders/MapBuilder.class */
public final class MapBuilder<K, V> implements Serializable, Map<K, V>, KMutableMap {
    private static final Companion a = new Companion(null);
    private K[] b;
    private V[] c;
    private int[] d;
    private int[] e;
    private int f;
    private int g;
    private int h;
    private int i;
    private MapBuilderKeys<K> j;
    private MapBuilderValues<V> k;
    private MapBuilderEntries<K, V> l;
    private boolean m;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/collections/builders/MapBuilder$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int a(int i) {
            return Integer.highestOneBit(RangesKt.c(i, 1) * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b(int i) {
            return Integer.numberOfLeadingZeros(i) + 1;
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/collections/builders/MapBuilder$EntriesItr.class */
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EntriesItr(MapBuilder<K, V> map) {
            super(map);
            Intrinsics.e(map, "map");
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public EntryRef<K, V> next() {
            if (d() < ((MapBuilder) c()).g) {
                int d = d();
                a(d + 1);
                b(d);
                EntryRef<K, V> entryRef = new EntryRef<>(c(), e());
                f();
                return entryRef;
            }
            throw new NoSuchElementException();
        }

        public final void a(StringBuilder sb) {
            Intrinsics.e(sb, "sb");
            if (d() >= ((MapBuilder) c()).g) {
                throw new NoSuchElementException();
            }
            int d = d();
            a(d + 1);
            b(d);
            Object obj = ((MapBuilder) c()).b[e()];
            if (Intrinsics.a(obj, c())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = ((MapBuilder) c()).c;
            Intrinsics.a(objArr);
            Object obj2 = objArr[e()];
            if (Intrinsics.a(obj2, c())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            f();
        }

        public final int b() {
            if (d() < ((MapBuilder) c()).g) {
                int d = d();
                a(d + 1);
                b(d);
                Object obj = ((MapBuilder) c()).b[e()];
                int i = 0;
                int hashCode = obj != null ? obj.hashCode() : 0;
                Object[] objArr = ((MapBuilder) c()).c;
                Intrinsics.a(objArr);
                Object obj2 = objArr[e()];
                if (obj2 != null) {
                    i = obj2.hashCode();
                }
                f();
                return hashCode ^ i;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/collections/builders/MapBuilder$EntryRef.class */
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        private final MapBuilder<K, V> a;
        private final int b;

        public EntryRef(MapBuilder<K, V> map, int i) {
            Intrinsics.e(map, "map");
            this.a = map;
            this.b = i;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return Intrinsics.a(entry.getKey(), getKey()) && Intrinsics.a(entry.getValue(), getValue());
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((MapBuilder) this.a).b[this.b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((MapBuilder) this.a).c;
            Intrinsics.a(objArr);
            return (V) objArr[this.b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int i = 0;
            int hashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            if (value != null) {
                i = value.hashCode();
            }
            return hashCode ^ i;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            this.a.g();
            Object[] m = this.a.m();
            int i = this.b;
            V v2 = (V) m[i];
            m[i] = v;
            return v2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/collections/builders/MapBuilder$Itr.class */
    public static class Itr<K, V> {
        private final MapBuilder<K, V> a;
        private int b;
        private int c;

        public Itr(MapBuilder<K, V> map) {
            Intrinsics.e(map, "map");
            this.a = map;
            this.c = -1;
            f();
        }

        public final void a(int i) {
            this.b = i;
        }

        public final void b(int i) {
            this.c = i;
        }

        public final MapBuilder<K, V> c() {
            return this.a;
        }

        public final int d() {
            return this.b;
        }

        public final int e() {
            return this.c;
        }

        public final void f() {
            while (this.b < ((MapBuilder) this.a).g) {
                int[] iArr = ((MapBuilder) this.a).d;
                int i = this.b;
                if (iArr[i] >= 0) {
                    return;
                }
                this.b = i + 1;
            }
        }

        public final boolean hasNext() {
            return this.b < ((MapBuilder) this.a).g;
        }

        public final void remove() {
            if (!(this.c != -1)) {
                throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
            }
            this.a.g();
            this.a.e(this.c);
            this.c = -1;
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/collections/builders/MapBuilder$KeysItr.class */
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMutableIterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KeysItr(MapBuilder<K, V> map) {
            super(map);
            Intrinsics.e(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (d() < ((MapBuilder) c()).g) {
                int d = d();
                a(d + 1);
                b(d);
                K k = (K) ((MapBuilder) c()).b[e()];
                f();
                return k;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/collections/builders/MapBuilder$ValuesItr.class */
    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMutableIterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValuesItr(MapBuilder<K, V> map) {
            super(map);
            Intrinsics.e(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (d() < ((MapBuilder) c()).g) {
                int d = d();
                a(d + 1);
                b(d);
                Object[] objArr = ((MapBuilder) c()).c;
                Intrinsics.a(objArr);
                V v = (V) objArr[e()];
                f();
                return v;
            }
            throw new NoSuchElementException();
        }
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i) {
        this(ListBuilderKt.a(i), null, new int[i], new int[a.a(i)], 2, 0);
    }

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i, int i2) {
        this.b = kArr;
        this.c = vArr;
        this.d = iArr;
        this.e = iArr2;
        this.f = i;
        this.g = i2;
        this.h = a.b(l());
    }

    private final void a(int i) {
        b(this.g + i);
    }

    private final boolean a(Map<?, ?> map) {
        return size() == map.size() && a((Collection<?>) map.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v29, types: [java.lang.Object[]] */
    private final void b(int i) {
        if (i < 0) {
            throw new OutOfMemoryError();
        }
        if (i <= k()) {
            if ((this.g + i) - size() > k()) {
                c(l());
                return;
            }
            return;
        }
        int k = (k() * 3) / 2;
        if (i <= k) {
            i = k;
        }
        this.b = (K[]) ListBuilderKt.a(this.b, i);
        V[] vArr = this.c;
        this.c = vArr != null ? ListBuilderKt.a(vArr, i) : null;
        int[] copyOf = Arrays.copyOf(this.d, i);
        Intrinsics.c(copyOf, "copyOf(this, newSize)");
        this.d = copyOf;
        int a2 = a.a(i);
        if (a2 > l()) {
            c(a2);
        }
    }

    private final boolean b(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z = false;
        if (collection.isEmpty()) {
            return false;
        }
        a(collection.size());
        for (Map.Entry<? extends K, ? extends V> entry : collection) {
            if (c((Map.Entry) entry)) {
                z = true;
            }
        }
        return z;
    }

    private final void c(int i) {
        int i2;
        if (this.g > size()) {
            n();
        }
        if (i != l()) {
            this.e = new int[i];
            this.h = a.b(i);
            i2 = 0;
        } else {
            ArraysKt.a(this.e, 0, 0, l());
            i2 = 0;
        }
        while (true) {
            int i3 = i2;
            if (i3 >= this.g) {
                return;
            }
            if (!d(i3)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i2 = i3 + 1;
        }
    }

    private final boolean c(Map.Entry<? extends K, ? extends V> entry) {
        int a2 = a((MapBuilder<K, V>) entry.getKey());
        V[] m = m();
        if (a2 >= 0) {
            m[a2] = entry.getValue();
            return true;
        }
        int i = (-a2) - 1;
        if (Intrinsics.a(entry.getValue(), m[i])) {
            return false;
        }
        m[i] = entry.getValue();
        return true;
    }

    private final int d(K k) {
        return ((k != null ? k.hashCode() : 0) * (-1640531527)) >>> this.h;
    }

    private final boolean d(int i) {
        int d = d((MapBuilder<K, V>) this.b[i]);
        int i2 = this.f;
        while (true) {
            int[] iArr = this.e;
            if (iArr[d] == 0) {
                iArr[d] = i + 1;
                this.d[i] = d;
                return true;
            }
            i2--;
            if (i2 < 0) {
                return false;
            }
            d = d == 0 ? l() - 1 : d - 1;
        }
    }

    private final int e(K k) {
        int d = d((MapBuilder<K, V>) k);
        int i = this.f;
        while (true) {
            int i2 = this.e[d];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (Intrinsics.a(this.b[i3], k)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            d = d == 0 ? l() - 1 : d - 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(int i) {
        ListBuilderKt.b(this.b, i);
        f(this.d[i]);
        this.d[i] = -1;
        this.i = size() - 1;
    }

    private final int f(V v) {
        int i = this.g;
        while (true) {
            int i2 = i - 1;
            if (i2 < 0) {
                return -1;
            }
            i = i2;
            if (this.d[i2] >= 0) {
                V[] vArr = this.c;
                Intrinsics.a(vArr);
                i = i2;
                if (Intrinsics.a(vArr[i2], v)) {
                    return i2;
                }
            }
        }
    }

    private final void f(int i) {
        int i2;
        int i3;
        int d = RangesKt.d(this.f * 2, l() / 2);
        int i4 = 0;
        int i5 = i;
        do {
            i = i == 0 ? l() - 1 : i - 1;
            int i6 = i4 + 1;
            if (i6 > this.f) {
                this.e[i5] = 0;
                return;
            }
            int[] iArr = this.e;
            int i7 = iArr[i];
            if (i7 == 0) {
                iArr[i5] = 0;
                return;
            }
            if (i7 < 0) {
                iArr[i5] = -1;
            } else {
                int i8 = i7 - 1;
                i2 = i5;
                i4 = i6;
                if (((d((MapBuilder<K, V>) this.b[i8]) - i) & (l() - 1)) >= i6) {
                    this.e[i5] = i7;
                    this.d[i8] = i5;
                }
                i3 = d - 1;
                i5 = i2;
                d = i3;
            }
            i2 = i;
            i4 = 0;
            i3 = d - 1;
            i5 = i2;
            d = i3;
        } while (i3 >= 0);
        this.e[i2] = -1;
    }

    private final int k() {
        return this.b.length;
    }

    private final int l() {
        return this.e.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] m() {
        V[] vArr = this.c;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) ListBuilderKt.a(k());
        this.c = vArr2;
        return vArr2;
    }

    private final void n() {
        int i;
        int i2;
        V[] vArr = this.c;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = i4;
            i2 = this.g;
            if (i3 >= i2) {
                break;
            }
            int i5 = i;
            if (this.d[i3] >= 0) {
                K[] kArr = this.b;
                kArr[i] = kArr[i3];
                if (vArr != null) {
                    vArr[i] = vArr[i3];
                }
                i5 = i + 1;
            }
            i3++;
            i4 = i5;
        }
        ListBuilderKt.a(this.b, i, i2);
        if (vArr != null) {
            ListBuilderKt.a(vArr, i, this.g);
        }
        this.g = i;
    }

    private final Object writeReplace() {
        if (this.m) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public int a() {
        return this.i;
    }

    public final int a(K k) {
        g();
        while (true) {
            int d = d((MapBuilder<K, V>) k);
            int d2 = RangesKt.d(this.f * 2, l() / 2);
            int i = 0;
            while (true) {
                int i2 = this.e[d];
                if (i2 <= 0) {
                    if (this.g < k()) {
                        int i3 = this.g;
                        int i4 = i3 + 1;
                        this.g = i4;
                        this.b[i3] = k;
                        this.d[i3] = d;
                        this.e[d] = i4;
                        this.i = size() + 1;
                        if (i > this.f) {
                            this.f = i;
                        }
                        return i3;
                    }
                    a(1);
                } else if (Intrinsics.a(this.b[i2 - 1], k)) {
                    return -i2;
                } else {
                    i++;
                    if (i > d2) {
                        c(l() * 2);
                        break;
                    }
                    d = d == 0 ? l() - 1 : d - 1;
                }
            }
        }
    }

    public final boolean a(Collection<?> m) {
        Intrinsics.e(m, "m");
        for (Object obj : m) {
            if (obj == null) {
                return false;
            }
            try {
                if (!a((Map.Entry) ((Map.Entry) obj))) {
                    return false;
                }
            } catch (ClassCastException e) {
                return false;
            }
        }
        return true;
    }

    public final boolean a(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.e(entry, "entry");
        int e = e((MapBuilder<K, V>) entry.getKey());
        if (e < 0) {
            return false;
        }
        V[] vArr = this.c;
        Intrinsics.a(vArr);
        return Intrinsics.a(vArr[e], entry.getValue());
    }

    public final int b(K k) {
        g();
        int e = e((MapBuilder<K, V>) k);
        if (e < 0) {
            return -1;
        }
        e(e);
        return e;
    }

    public final boolean b() {
        return this.m;
    }

    public final boolean b(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.e(entry, "entry");
        g();
        int e = e((MapBuilder<K, V>) entry.getKey());
        if (e < 0) {
            return false;
        }
        V[] vArr = this.c;
        Intrinsics.a(vArr);
        if (Intrinsics.a(vArr[e], entry.getValue())) {
            e(e);
            return true;
        }
        return false;
    }

    public final Map<K, V> c() {
        g();
        this.m = true;
        return this;
    }

    public final boolean c(V v) {
        g();
        int f = f((MapBuilder<K, V>) v);
        if (f < 0) {
            return false;
        }
        e(f);
        return true;
    }

    @Override // java.util.Map
    public void clear() {
        g();
        int i = this.g - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                int[] iArr = this.d;
                int i4 = iArr[i3];
                if (i4 >= 0) {
                    this.e[i4] = 0;
                    iArr[i3] = -1;
                }
                if (i3 == i) {
                    break;
                }
                i2 = i3 + 1;
            }
        }
        ListBuilderKt.a(this.b, 0, this.g);
        V[] vArr = this.c;
        if (vArr != null) {
            ListBuilderKt.a(vArr, 0, this.g);
        }
        this.i = 0;
        this.g = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return e((MapBuilder<K, V>) obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return f((MapBuilder<K, V>) obj) >= 0;
    }

    public Set<K> d() {
        MapBuilderKeys<K> mapBuilderKeys = this.j;
        if (mapBuilderKeys == null) {
            MapBuilderKeys<K> mapBuilderKeys2 = new MapBuilderKeys<>(this);
            this.j = mapBuilderKeys2;
            return mapBuilderKeys2;
        }
        return mapBuilderKeys;
    }

    public Collection<V> e() {
        MapBuilderValues<V> mapBuilderValues = this.k;
        if (mapBuilderValues == null) {
            MapBuilderValues<V> mapBuilderValues2 = new MapBuilderValues<>(this);
            this.k = mapBuilderValues2;
            return mapBuilderValues2;
        }
        return mapBuilderValues;
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return f();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof Map) && a((Map) obj);
        }
        return true;
    }

    public Set<Map.Entry<K, V>> f() {
        MapBuilderEntries<K, V> mapBuilderEntries = this.l;
        if (mapBuilderEntries == null) {
            MapBuilderEntries<K, V> mapBuilderEntries2 = new MapBuilderEntries<>(this);
            this.l = mapBuilderEntries2;
            return mapBuilderEntries2;
        }
        return mapBuilderEntries;
    }

    public final void g() {
        if (this.m) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object obj) {
        int e = e((MapBuilder<K, V>) obj);
        if (e < 0) {
            return null;
        }
        V[] vArr = this.c;
        Intrinsics.a(vArr);
        return vArr[e];
    }

    public final KeysItr<K, V> h() {
        return new KeysItr<>(this);
    }

    @Override // java.util.Map
    public int hashCode() {
        EntriesItr<K, V> j = j();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!j.hasNext()) {
                return i2;
            }
            i = i2 + j.b();
        }
    }

    public final ValuesItr<K, V> i() {
        return new ValuesItr<>(this);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final EntriesItr<K, V> j() {
        return new EntriesItr<>(this);
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        return d();
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        g();
        int a2 = a((MapBuilder<K, V>) k);
        V[] m = m();
        if (a2 >= 0) {
            m[a2] = v;
            return null;
        }
        int i = (-a2) - 1;
        V v2 = m[i];
        m[i] = v;
        return v2;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        Intrinsics.e(from, "from");
        g();
        b((Collection) from.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object obj) {
        int b = b((MapBuilder<K, V>) obj);
        if (b < 0) {
            return null;
        }
        V[] vArr = this.c;
        Intrinsics.a(vArr);
        V v = vArr[b];
        ListBuilderKt.b(vArr, b);
        return v;
    }

    @Override // java.util.Map
    public final int size() {
        return a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        EntriesItr<K, V> j = j();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!j.hasNext()) {
                sb.append(i.d);
                String sb2 = sb.toString();
                Intrinsics.c(sb2, "sb.toString()");
                return sb2;
            }
            if (i2 > 0) {
                sb.append(", ");
            }
            j.a(sb);
            i = i2 + 1;
        }
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return e();
    }
}
