package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/ModelCache.class */
public class ModelCache<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private final LruCache<ModelKey<A>, B> f20886a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/ModelCache$ModelKey.class */
    public static final class ModelKey<A> {

        /* renamed from: a  reason: collision with root package name */
        private static final Queue<ModelKey<?>> f20888a = Util.a(0);
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f20889c;
        private A d;

        private ModelKey() {
        }

        static <A> ModelKey<A> a(A a2, int i, int i2) {
            ModelKey<?> poll;
            synchronized (f20888a) {
                poll = f20888a.poll();
            }
            ModelKey<?> modelKey = poll;
            if (poll == null) {
                modelKey = new ModelKey<>();
            }
            modelKey.b(a2, i, i2);
            return (ModelKey<A>) modelKey;
        }

        private void b(A a2, int i, int i2) {
            this.d = a2;
            this.f20889c = i;
            this.b = i2;
        }

        public void a() {
            synchronized (f20888a) {
                f20888a.offer(this);
            }
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (obj instanceof ModelKey) {
                ModelKey modelKey = (ModelKey) obj;
                z = false;
                if (this.f20889c == modelKey.f20889c) {
                    z = false;
                    if (this.b == modelKey.b) {
                        z = false;
                        if (this.d.equals(modelKey.d)) {
                            z = true;
                        }
                    }
                }
            }
            return z;
        }

        public int hashCode() {
            return (((this.b * 31) + this.f20889c) * 31) + this.d.hashCode();
        }
    }

    public ModelCache() {
        this(250L);
    }

    public ModelCache(long j) {
        this.f20886a = new LruCache<ModelKey<A>, B>(j) { // from class: com.bumptech.glide.load.model.ModelCache.1
            protected void a(ModelKey<A> modelKey, B b) {
                modelKey.a();
            }

            @Override // com.bumptech.glide.util.LruCache
            public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
                a((ModelKey) ((ModelKey) obj), (ModelKey<A>) obj2);
            }
        };
    }

    public B a(A a2, int i, int i2) {
        ModelKey<A> a3 = ModelKey.a(a2, i, i2);
        B b = this.f20886a.b(a3);
        a3.a();
        return b;
    }

    public void a(A a2, int i, int i2, B b) {
        this.f20886a.b(ModelKey.a(a2, i, i2), b);
    }
}
