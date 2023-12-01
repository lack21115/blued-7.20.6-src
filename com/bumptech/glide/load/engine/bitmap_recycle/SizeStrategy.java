package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;
import java.util.NavigableMap;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/SizeStrategy.class */
final class SizeStrategy implements LruPoolStrategy {

    /* renamed from: a  reason: collision with root package name */
    private final KeyPool f20818a = new KeyPool();
    private final GroupedLinkedMap<Key, Bitmap> b = new GroupedLinkedMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final NavigableMap<Integer, Integer> f20819c = new PrettyPrintTreeMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/SizeStrategy$Key.class */
    public static final class Key implements Poolable {

        /* renamed from: a  reason: collision with root package name */
        int f20820a;
        private final KeyPool b;

        Key(KeyPool keyPool) {
            this.b = keyPool;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void a() {
            this.b.a((KeyPool) this);
        }

        public void a(int i) {
            this.f20820a = i;
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (obj instanceof Key) {
                z = false;
                if (this.f20820a == ((Key) obj).f20820a) {
                    z = true;
                }
            }
            return z;
        }

        public int hashCode() {
            return this.f20820a;
        }

        public String toString() {
            return SizeStrategy.a(this.f20820a);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/SizeStrategy$KeyPool.class */
    static class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        /* renamed from: a */
        public Key b() {
            return new Key(this);
        }

        public Key a(int i) {
            Key key = (Key) super.c();
            key.a(i);
            return key;
        }
    }

    SizeStrategy() {
    }

    static String a(int i) {
        return "[" + i + "]";
    }

    private void a(Integer num) {
        Integer num2 = this.f20819c.get(num);
        if (num2.intValue() == 1) {
            this.f20819c.remove(num);
        } else {
            this.f20819c.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private static String d(Bitmap bitmap) {
        return a(Util.a(bitmap));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap a() {
        Bitmap a2 = this.b.a();
        if (a2 != null) {
            a(Integer.valueOf(Util.a(a2)));
        }
        return a2;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        int a2 = Util.a(i, i2, config);
        Key a3 = this.f20818a.a(a2);
        Integer ceilingKey = this.f20819c.ceilingKey(Integer.valueOf(a2));
        Key key = a3;
        if (ceilingKey != null) {
            key = a3;
            if (ceilingKey.intValue() != a2) {
                key = a3;
                if (ceilingKey.intValue() <= a2 * 8) {
                    this.f20818a.a((KeyPool) a3);
                    key = this.f20818a.a(ceilingKey.intValue());
                }
            }
        }
        Bitmap a4 = this.b.a((GroupedLinkedMap<Key, Bitmap>) key);
        if (a4 != null) {
            a4.reconfigure(i, i2, config);
            a(ceilingKey);
        }
        return a4;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void a(Bitmap bitmap) {
        Key a2 = this.f20818a.a(Util.a(bitmap));
        this.b.a(a2, bitmap);
        Integer num = this.f20819c.get(Integer.valueOf(a2.f20820a));
        NavigableMap<Integer, Integer> navigableMap = this.f20819c;
        int i = a2.f20820a;
        int i2 = 1;
        if (num != null) {
            i2 = 1 + num.intValue();
        }
        navigableMap.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String b(int i, int i2, Bitmap.Config config) {
        return a(Util.a(i, i2, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String b(Bitmap bitmap) {
        return d(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int c(Bitmap bitmap) {
        return Util.a(bitmap);
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.b + "\n  SortedSizes" + this.f20819c;
    }
}
