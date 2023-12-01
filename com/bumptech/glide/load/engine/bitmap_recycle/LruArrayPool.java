package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/LruArrayPool.class */
public final class LruArrayPool implements ArrayPool {

    /* renamed from: a  reason: collision with root package name */
    private final GroupedLinkedMap<Key, Object> f20806a;
    private final KeyPool b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f20807c;
    private final Map<Class<?>, ArrayAdapterInterface<?>> d;
    private final int e;
    private int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/LruArrayPool$Key.class */
    public static final class Key implements Poolable {

        /* renamed from: a  reason: collision with root package name */
        int f20808a;
        private final KeyPool b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f20809c;

        Key(KeyPool keyPool) {
            this.b = keyPool;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void a() {
            this.b.a(this);
        }

        void a(int i, Class<?> cls) {
            this.f20808a = i;
            this.f20809c = cls;
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (obj instanceof Key) {
                Key key = (Key) obj;
                z = false;
                if (this.f20808a == key.f20808a) {
                    z = false;
                    if (this.f20809c == key.f20809c) {
                        z = true;
                    }
                }
            }
            return z;
        }

        public int hashCode() {
            int i = this.f20808a;
            Class<?> cls = this.f20809c;
            return (i * 31) + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f20808a + "array=" + this.f20809c + '}';
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/LruArrayPool$KeyPool.class */
    static final class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        /* renamed from: a */
        public Key b() {
            return new Key(this);
        }

        Key a(int i, Class<?> cls) {
            Key c2 = c();
            c2.a(i, cls);
            return c2;
        }
    }

    public LruArrayPool() {
        this.f20806a = new GroupedLinkedMap<>();
        this.b = new KeyPool();
        this.f20807c = new HashMap();
        this.d = new HashMap();
        this.e = 4194304;
    }

    public LruArrayPool(int i) {
        this.f20806a = new GroupedLinkedMap<>();
        this.b = new KeyPool();
        this.f20807c = new HashMap();
        this.d = new HashMap();
        this.e = i;
    }

    private <T> T a(Key key) {
        return (T) this.f20806a.a((GroupedLinkedMap<Key, Object>) key);
    }

    private <T> T a(Key key, Class<T> cls) {
        ArrayAdapterInterface<T> b = b((Class) cls);
        T t = (T) a(key);
        if (t != null) {
            this.f -= b.a((ArrayAdapterInterface<T>) t) * b.b();
            c(b.a((ArrayAdapterInterface<T>) t), cls);
        }
        T t2 = t;
        if (t == null) {
            if (Log.isLoggable(b.a(), 2)) {
                Log.v(b.a(), "Allocated " + key.f20808a + " bytes");
            }
            t2 = b.a(key.f20808a);
        }
        return t2;
    }

    private NavigableMap<Integer, Integer> a(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f20807c.get(cls);
        TreeMap treeMap = navigableMap;
        if (navigableMap == null) {
            treeMap = new TreeMap();
            this.f20807c.put(cls, treeMap);
        }
        return treeMap;
    }

    private boolean a(int i, Integer num) {
        if (num != null) {
            return b() || num.intValue() <= i * 8;
        }
        return false;
    }

    private <T> ArrayAdapterInterface<T> b(Class<T> cls) {
        ArrayAdapterInterface byteArrayAdapter;
        ArrayAdapterInterface<T> arrayAdapterInterface = (ArrayAdapterInterface<T>) this.d.get(cls);
        if (arrayAdapterInterface == null) {
            if (cls.equals(int[].class)) {
                byteArrayAdapter = new IntegerArrayAdapter();
            } else if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            } else {
                byteArrayAdapter = new ByteArrayAdapter();
            }
            this.d.put(cls, byteArrayAdapter);
            return byteArrayAdapter;
        }
        return arrayAdapterInterface;
    }

    private <T> ArrayAdapterInterface<T> b(T t) {
        return b((Class) t.getClass());
    }

    private boolean b() {
        int i = this.f;
        return i == 0 || this.e / i >= 2;
    }

    private boolean b(int i) {
        return i <= this.e / 2;
    }

    private void c() {
        c(this.e);
    }

    private void c(int i) {
        while (this.f > i) {
            Object a2 = this.f20806a.a();
            Preconditions.a(a2);
            ArrayAdapterInterface b = b((LruArrayPool) a2);
            this.f -= b.a((ArrayAdapterInterface) a2) * b.b();
            c(b.a((ArrayAdapterInterface) a2), a2.getClass());
            if (Log.isLoggable(b.a(), 2)) {
                Log.v(b.a(), "evicted: " + b.a((ArrayAdapterInterface) a2));
            }
        }
    }

    private void c(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> a2 = a(cls);
        Integer num = a2.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                a2.remove(Integer.valueOf(i));
                return;
            } else {
                a2.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public <T> T a(int i, Class<T> cls) {
        T t;
        synchronized (this) {
            Integer ceilingKey = a((Class<?>) cls).ceilingKey(Integer.valueOf(i));
            t = (T) a(a(i, ceilingKey) ? this.b.a(ceilingKey.intValue(), cls) : this.b.a(i, cls), cls);
        }
        return t;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public void a() {
        synchronized (this) {
            c(0);
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public void a(int i) {
        synchronized (this) {
            if (i >= 40) {
                a();
            } else if (i >= 20 || i == 15) {
                c(this.e / 2);
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public <T> void a(T t) {
        synchronized (this) {
            Class<?> cls = t.getClass();
            ArrayAdapterInterface<T> b = b((Class) cls);
            int a2 = b.a((ArrayAdapterInterface<T>) t);
            int b2 = b.b() * a2;
            if (b(b2)) {
                Key a3 = this.b.a(a2, cls);
                this.f20806a.a(a3, t);
                NavigableMap<Integer, Integer> a4 = a(cls);
                Integer num = a4.get(Integer.valueOf(a3.f20808a));
                int i = a3.f20808a;
                int i2 = 1;
                if (num != null) {
                    i2 = 1 + num.intValue();
                }
                a4.put(Integer.valueOf(i), Integer.valueOf(i2));
                this.f += b2;
                c();
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public <T> T b(int i, Class<T> cls) {
        T t;
        synchronized (this) {
            t = (T) a(this.b.a(i, cls), cls);
        }
        return t;
    }
}
