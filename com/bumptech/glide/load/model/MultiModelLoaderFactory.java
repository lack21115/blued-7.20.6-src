package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/MultiModelLoaderFactory.class */
public class MultiModelLoaderFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final Factory f20898a = new Factory();
    private static final ModelLoader<Object, Object> b = new EmptyModelLoader();

    /* renamed from: c  reason: collision with root package name */
    private final List<Entry<?, ?>> f20899c;
    private final Factory d;
    private final Set<Entry<?, ?>> e;
    private final Pools.Pool<List<Throwable>> f;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/MultiModelLoaderFactory$EmptyModelLoader.class */
    static class EmptyModelLoader implements ModelLoader<Object, Object> {
        EmptyModelLoader() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public ModelLoader.LoadData<Object> a(Object obj, int i, int i2, Options options) {
            return null;
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public boolean a(Object obj) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/MultiModelLoaderFactory$Entry.class */
    public static class Entry<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        final Class<Data> f20900a;
        final ModelLoaderFactory<? extends Model, ? extends Data> b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<Model> f20901c;

        public Entry(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
            this.f20901c = cls;
            this.f20900a = cls2;
            this.b = modelLoaderFactory;
        }

        public boolean a(Class<?> cls) {
            return this.f20901c.isAssignableFrom(cls);
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return a(cls) && this.f20900a.isAssignableFrom(cls2);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/MultiModelLoaderFactory$Factory.class */
    static class Factory {
        Factory() {
        }

        public <Model, Data> MultiModelLoader<Model, Data> a(List<ModelLoader<Model, Data>> list, Pools.Pool<List<Throwable>> pool) {
            return new MultiModelLoader<>(list, pool);
        }
    }

    public MultiModelLoaderFactory(Pools.Pool<List<Throwable>> pool) {
        this(pool, f20898a);
    }

    MultiModelLoaderFactory(Pools.Pool<List<Throwable>> pool, Factory factory) {
        this.f20899c = new ArrayList();
        this.e = new HashSet();
        this.f = pool;
        this.d = factory;
    }

    private static <Model, Data> ModelLoader<Model, Data> a() {
        return (ModelLoader<Model, Data>) b;
    }

    private <Model, Data> ModelLoaderFactory<Model, Data> a(Entry<?, ?> entry) {
        return (ModelLoaderFactory<Model, Data>) entry.b;
    }

    private <Model, Data> void a(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory, boolean z) {
        Entry<?, ?> entry = new Entry<>(cls, cls2, modelLoaderFactory);
        List<Entry<?, ?>> list = this.f20899c;
        list.add(z ? list.size() : 0, entry);
    }

    private <Model, Data> ModelLoader<Model, Data> b(Entry<?, ?> entry) {
        return (ModelLoader) Preconditions.a(entry.b.a(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Model> List<ModelLoader<Model, ?>> a(Class<Model> cls) {
        ArrayList arrayList;
        synchronized (this) {
            try {
                arrayList = new ArrayList();
                for (Entry<?, ?> entry : this.f20899c) {
                    if (!this.e.contains(entry) && entry.a(cls)) {
                        this.e.add(entry);
                        arrayList.add(b(entry));
                        this.e.remove(entry);
                    }
                }
            } catch (Throwable th) {
                this.e.clear();
                throw th;
            }
        }
        return arrayList;
    }

    <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> a(Class<Model> cls, Class<Data> cls2) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            Iterator<Entry<?, ?>> it = this.f20899c.iterator();
            while (it.hasNext()) {
                Entry<?, ?> next = it.next();
                if (next.a(cls, cls2)) {
                    it.remove();
                    arrayList.add(a(next));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Model, Data> void a(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        synchronized (this) {
            a(cls, cls2, modelLoaderFactory, true);
        }
    }

    public <Model, Data> ModelLoader<Model, Data> b(Class<Model> cls, Class<Data> cls2) {
        synchronized (this) {
            try {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (Entry<?, ?> entry : this.f20899c) {
                    if (this.e.contains(entry)) {
                        z = true;
                    } else if (entry.a(cls, cls2)) {
                        this.e.add(entry);
                        arrayList.add(b(entry));
                        this.e.remove(entry);
                    }
                }
                if (arrayList.size() > 1) {
                    return this.d.a(arrayList, this.f);
                } else if (arrayList.size() == 1) {
                    return (ModelLoader) arrayList.get(0);
                } else if (z) {
                    return a();
                } else {
                    throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
                }
            } catch (Throwable th) {
                this.e.clear();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Class<?>> b(Class<?> cls) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            for (Entry<?, ?> entry : this.f20899c) {
                if (!arrayList.contains(entry.f20900a) && entry.a(cls)) {
                    arrayList.add(entry.f20900a);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> b(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        List<ModelLoaderFactory<? extends Model, ? extends Data>> a2;
        synchronized (this) {
            a2 = a(cls, cls2);
            a(cls, cls2, modelLoaderFactory);
        }
        return a2;
    }
}
