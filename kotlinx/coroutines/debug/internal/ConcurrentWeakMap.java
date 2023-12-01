package kotlinx.coroutines.debug.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin._Assertions;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/internal/ConcurrentWeakMap.class */
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f43016a = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");
    private volatile /* synthetic */ int _size;
    private final ReferenceQueue<K> b;
    volatile /* synthetic */ Object core;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core.class */
    public final class Core {
        private static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(Core.class, "load");

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ AtomicReferenceArray f43017a;
        /* synthetic */ AtomicReferenceArray b;
        private final int d;
        private final int e;
        private final int f;
        private volatile /* synthetic */ int load = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata
        /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator.class */
        public final class KeyValueIterator<E> implements Iterator<E>, KMutableIterator {
            private final Function2<K, V, E> b;

            /* renamed from: c  reason: collision with root package name */
            private int f43020c = -1;
            private K d;
            private V e;

            /* JADX WARN: Multi-variable type inference failed */
            public KeyValueIterator(Function2<? super K, ? super V, ? extends E> function2) {
                this.b = function2;
                b();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Object] */
            private final void b() {
                while (true) {
                    int i = this.f43020c + 1;
                    this.f43020c = i;
                    if (i >= ((Core) Core.this).d) {
                        return;
                    }
                    HashedWeakRef hashedWeakRef = (HashedWeakRef) Core.this.f43017a.get(this.f43020c);
                    K k = hashedWeakRef == null ? null : hashedWeakRef.get();
                    if (k != null) {
                        this.d = k;
                        Object obj = Core.this.b.get(this.f43020c);
                        Object obj2 = obj;
                        if (obj instanceof Marked) {
                            obj2 = ((Marked) obj).f43041a;
                        }
                        if (obj2 != null) {
                            this.e = (V) obj2;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            /* renamed from: a */
            public Void remove() {
                ConcurrentWeakMapKt.b();
                throw new KotlinNothingValueException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f43020c < ((Core) Core.this).d;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.f43020c < ((Core) Core.this).d) {
                    Function2<K, V, E> function2 = this.b;
                    K k = this.d;
                    if (k == null) {
                        Intrinsics.c("key");
                        throw null;
                    }
                    V v = this.e;
                    if (v == null) {
                        Intrinsics.c("value");
                        throw null;
                    }
                    E invoke = function2.invoke(k, v);
                    b();
                    return invoke;
                }
                throw new NoSuchElementException();
            }
        }

        public Core(int i) {
            this.d = i;
            this.e = Integer.numberOfLeadingZeros(i) + 1;
            this.f = (this.d * 2) / 3;
            this.f43017a = new AtomicReferenceArray(this.d);
            this.b = new AtomicReferenceArray(this.d);
        }

        private final int a(int i) {
            return (i * (-1640531527)) >>> this.e;
        }

        public static /* synthetic */ Object a(Core core, Object obj, Object obj2, HashedWeakRef hashedWeakRef, int i, Object obj3) {
            if ((i & 4) != 0) {
                hashedWeakRef = null;
            }
            return core.a(obj, obj2, hashedWeakRef);
        }

        private final void b(int i) {
            Object obj;
            do {
                obj = this.b.get(i);
                if (obj == null || (obj instanceof Marked)) {
                    return;
                }
            } while (!this.b.compareAndSet(i, obj, null));
            ConcurrentWeakMap.this.f();
        }

        public final V a(K k) {
            int a2 = a(k.hashCode());
            while (true) {
                int i = a2;
                HashedWeakRef hashedWeakRef = (HashedWeakRef) this.f43017a.get(i);
                if (hashedWeakRef == null) {
                    return null;
                }
                T t = hashedWeakRef.get();
                if (Intrinsics.a(k, t)) {
                    Object obj = this.b.get(i);
                    Object obj2 = obj;
                    if (obj instanceof Marked) {
                        obj2 = ((Marked) obj).f43041a;
                    }
                    return (V) obj2;
                }
                if (t == 0) {
                    b(i);
                }
                int i2 = i;
                if (i == 0) {
                    i2 = this.d;
                }
                a2 = i2 - 1;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
            r0 = r6.b.get(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00b1, code lost:
            if ((r0 instanceof kotlinx.coroutines.debug.internal.Marked) == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00b7, code lost:
            return kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00c3, code lost:
            if (r6.b.compareAndSet(r10, r0, r8) == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00c7, code lost:
            return r0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object a(K r7, V r8, kotlinx.coroutines.debug.internal.HashedWeakRef<K> r9) {
            /*
                Method dump skipped, instructions count: 235
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.a(java.lang.Object, java.lang.Object, kotlinx.coroutines.debug.internal.HashedWeakRef):java.lang.Object");
        }

        public final <E> Iterator<E> a(Function2<? super K, ? super V, ? extends E> function2) {
            return new KeyValueIterator(function2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final ConcurrentWeakMap<K, V>.Core a() {
            V v;
            while (true) {
                ConcurrentWeakMap<K, V>.Core core = new Core(Integer.highestOneBit(RangesKt.c(ConcurrentWeakMap.this.size(), 4)) * 4);
                int i = this.d;
                if (i <= 0) {
                    return core;
                }
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    int i4 = i3 + 1;
                    HashedWeakRef<K> hashedWeakRef = (HashedWeakRef) this.f43017a.get(i3);
                    K k = hashedWeakRef == null ? null : hashedWeakRef.get();
                    if (hashedWeakRef != null && k == null) {
                        b(i3);
                    }
                    while (true) {
                        v = this.b.get(i3);
                        if (!(v instanceof Marked)) {
                            if (this.b.compareAndSet(i3, v, ConcurrentWeakMapKt.a(v))) {
                                break;
                            }
                        } else {
                            v = ((Marked) v).f43041a;
                            break;
                        }
                    }
                    if (k != null && v != null) {
                        Object a2 = core.a(k, v, hashedWeakRef);
                        if (a2 == ConcurrentWeakMapKt.a()) {
                            break;
                        }
                        boolean z = a2 == null;
                        if (_Assertions.b && !z) {
                            throw new AssertionError("Assertion failed");
                        }
                    }
                    if (i4 >= i) {
                        return core;
                    }
                    i2 = i4;
                }
            }
        }

        public final void a(HashedWeakRef<?> hashedWeakRef) {
            int a2 = a(hashedWeakRef.f43040a);
            while (true) {
                int i = a2;
                HashedWeakRef<?> hashedWeakRef2 = (HashedWeakRef) this.f43017a.get(i);
                if (hashedWeakRef2 == null) {
                    return;
                }
                if (hashedWeakRef2 == hashedWeakRef) {
                    b(i);
                    return;
                }
                int i2 = i;
                if (i == 0) {
                    i2 = this.d;
                }
                a2 = i2 - 1;
            }
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/internal/ConcurrentWeakMap$Entry.class */
    static final class Entry<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {

        /* renamed from: a  reason: collision with root package name */
        private final K f43021a;
        private final V b;

        public Entry(K k, V v) {
            this.f43021a = k;
            this.b = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f43021a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            ConcurrentWeakMapKt.b();
            throw new KotlinNothingValueException();
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/internal/ConcurrentWeakMap$KeyValueSet.class */
    final class KeyValueSet<E> extends AbstractMutableSet<E> {
        private final Function2<K, V, E> b;

        /* JADX WARN: Multi-variable type inference failed */
        public KeyValueSet(Function2<? super K, ? super V, ? extends E> function2) {
            this.b = function2;
        }

        @Override // kotlin.collections.AbstractMutableSet
        public int a() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            ConcurrentWeakMapKt.b();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return ((Core) ConcurrentWeakMap.this.core).a((Function2) this.b);
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    public ConcurrentWeakMap(boolean z) {
        this._size = 0;
        this.core = new Core(16);
        this.b = z ? new ReferenceQueue<>() : null;
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    private final V a(K k, V v) {
        V v2;
        synchronized (this) {
            Core core = (Core) this.core;
            while (true) {
                v2 = (V) Core.a(core, k, v, null, 4, null);
                if (v2 == ConcurrentWeakMapKt.a()) {
                    core = core.a();
                    this.core = core;
                }
            }
        }
        return v2;
    }

    private final void a(HashedWeakRef<?> hashedWeakRef) {
        ((Core) this.core).a(hashedWeakRef);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        f43016a.decrementAndGet(this);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<Map.Entry<K, V>> a() {
        return new KeyValueSet(new Function2<K, V, Map.Entry<K, V>>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$entries$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a */
            public final Map.Entry<K, V> invoke(K k, V v) {
                return new ConcurrentWeakMap.Entry(k, v);
            }
        });
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<K> b() {
        return new KeyValueSet(new Function2<K, V, K>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$keys$1
            @Override // kotlin.jvm.functions.Function2
            public final K invoke(K k, V v) {
                return k;
            }
        });
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int c() {
        return this._size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (K k : keySet()) {
            remove(k);
        }
    }

    public final void e() {
        if (!(this.b != null)) {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
        while (true) {
            try {
                Reference<? extends K> remove = this.b.remove();
                if (remove == null) {
                    break;
                }
                a((HashedWeakRef) remove);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        return (V) ((Core) this.core).a((Core) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Object a2 = Core.a((Core) this.core, k, v, null, 4, null);
        V v2 = a2;
        if (a2 == ConcurrentWeakMapKt.a()) {
            v2 = a(k, v);
        }
        if (v2 == null) {
            f43016a.incrementAndGet(this);
        }
        return v2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == 0) {
            return null;
        }
        Object a2 = Core.a((Core) this.core, obj, null, null, 4, null);
        V v = a2;
        if (a2 == ConcurrentWeakMapKt.a()) {
            v = a(obj, null);
        }
        if (v != null) {
            f43016a.decrementAndGet(this);
        }
        return v;
    }
}
