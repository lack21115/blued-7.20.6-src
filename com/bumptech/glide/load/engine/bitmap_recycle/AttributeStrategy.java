package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/AttributeStrategy.class */
public class AttributeStrategy implements LruPoolStrategy {

    /* renamed from: a  reason: collision with root package name */
    private final KeyPool f20799a = new KeyPool();
    private final GroupedLinkedMap<Key, Bitmap> b = new GroupedLinkedMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/AttributeStrategy$Key.class */
    public static class Key implements Poolable {

        /* renamed from: a  reason: collision with root package name */
        private final KeyPool f20800a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f20801c;
        private Bitmap.Config d;

        public Key(KeyPool keyPool) {
            this.f20800a = keyPool;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void a() {
            this.f20800a.a(this);
        }

        public void a(int i, int i2, Bitmap.Config config) {
            this.b = i;
            this.f20801c = i2;
            this.d = config;
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (obj instanceof Key) {
                Key key = (Key) obj;
                z = false;
                if (this.b == key.b) {
                    z = false;
                    if (this.f20801c == key.f20801c) {
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
            int i2 = this.f20801c;
            Bitmap.Config config = this.d;
            return (((i * 31) + i2) * 31) + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return AttributeStrategy.c(this.b, this.f20801c, this.d);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/AttributeStrategy$KeyPool.class */
    static class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        /* renamed from: a */
        public Key b() {
            return new Key(this);
        }

        Key a(int i, int i2, Bitmap.Config config) {
            Key c2 = c();
            c2.a(i, i2, config);
            return c2;
        }
    }

    static String c(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    private static String d(Bitmap bitmap) {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap a() {
        return this.b.a();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.b.a((GroupedLinkedMap<Key, Bitmap>) this.f20799a.a(i, i2, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void a(Bitmap bitmap) {
        this.b.a(this.f20799a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String b(int i, int i2, Bitmap.Config config) {
        return c(i, i2, config);
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
        return "AttributeStrategy:\n  " + this.b;
    }
}
