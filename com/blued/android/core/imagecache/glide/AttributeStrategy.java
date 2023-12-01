package com.blued.android.core.imagecache.glide;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/glide/AttributeStrategy.class */
public class AttributeStrategy implements LruPoolStrategy {
    private final KeyPool a = new KeyPool();
    private final GroupedLinkedMap<Key, Bitmap> b = new GroupedLinkedMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/glide/AttributeStrategy$Key.class */
    public static class Key implements Poolable {
        private final KeyPool a;
        private int b;
        private int c;
        private Bitmap.Config d;

        public Key(KeyPool keyPool) {
            this.a = keyPool;
        }

        @Override // com.blued.android.core.imagecache.glide.Poolable
        public void a() {
            this.a.a(this);
        }

        public void a(int i, int i2, Bitmap.Config config) {
            this.b = i;
            this.c = i2;
            this.d = config;
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (obj instanceof Key) {
                Key key = (Key) obj;
                z = false;
                if (this.b == key.b) {
                    z = false;
                    if (this.c == key.c) {
                        z = false;
                        if (this.d == key.d) {
                            z = true;
                        }
                    }
                }
            }
            return z;
        }

        public int hashCode() {
            int i = this.b;
            int i2 = this.c;
            Bitmap.Config config = this.d;
            return (((i * 31) + i2) * 31) + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return AttributeStrategy.c(this.b, this.c, this.d);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/glide/AttributeStrategy$KeyPool.class */
    static class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.core.imagecache.glide.BaseKeyPool
        /* renamed from: a */
        public Key b() {
            return new Key(this);
        }

        public Key a(int i, int i2, Bitmap.Config config) {
            Key c = c();
            c.a(i, i2, config);
            return c;
        }
    }

    static String c(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    private static String d(Bitmap bitmap) {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.blued.android.core.imagecache.glide.LruPoolStrategy
    public Bitmap a() {
        return this.b.a();
    }

    @Override // com.blued.android.core.imagecache.glide.LruPoolStrategy
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.b.a((GroupedLinkedMap<Key, Bitmap>) this.a.a(i, i2, config));
    }

    @Override // com.blued.android.core.imagecache.glide.LruPoolStrategy
    public void a(Bitmap bitmap) {
        this.b.a(this.a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.blued.android.core.imagecache.glide.LruPoolStrategy
    public String b(int i, int i2, Bitmap.Config config) {
        return c(i, i2, config);
    }

    @Override // com.blued.android.core.imagecache.glide.LruPoolStrategy
    public String b(Bitmap bitmap) {
        return d(bitmap);
    }

    @Override // com.blued.android.core.imagecache.glide.LruPoolStrategy
    public int c(Bitmap bitmap) {
        return Util.a(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.b;
    }
}
