package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/ModelLoaderRegistry.class */
public class ModelLoaderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final MultiModelLoaderFactory f7286a;
    private final ModelLoaderCache b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/ModelLoaderRegistry$ModelLoaderCache.class */
    public static class ModelLoaderCache {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, Entry<?>> f7287a = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/ModelLoaderRegistry$ModelLoaderCache$Entry.class */
        public static class Entry<Model> {

            /* renamed from: a  reason: collision with root package name */
            final List<ModelLoader<Model, ?>> f7288a;

            public Entry(List<ModelLoader<Model, ?>> list) {
                this.f7288a = list;
            }
        }

        ModelLoaderCache() {
        }

        public <Model> List<ModelLoader<Model, ?>> a(Class<Model> cls) {
            Entry<?> entry = this.f7287a.get(cls);
            if (entry == null) {
                return null;
            }
            return (List<ModelLoader<Model, ?>>) entry.f7288a;
        }

        public void a() {
            this.f7287a.clear();
        }

        public <Model> void a(Class<Model> cls, List<ModelLoader<Model, ?>> list) {
            if (this.f7287a.put(cls, new Entry<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public ModelLoaderRegistry(Pools.Pool<List<Throwable>> pool) {
        this(new MultiModelLoaderFactory(pool));
    }

    private ModelLoaderRegistry(MultiModelLoaderFactory multiModelLoaderFactory) {
        this.b = new ModelLoaderCache();
        this.f7286a = multiModelLoaderFactory;
    }

    private <Model, Data> void a(List<ModelLoaderFactory<? extends Model, ? extends Data>> list) {
        for (ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory : list) {
            modelLoaderFactory.a();
        }
    }

    private static <A> Class<A> b(A a2) {
        return (Class<A>) a2.getClass();
    }

    private <A> List<ModelLoader<A, ?>> b(Class<A> cls) {
        List<ModelLoader<A, ?>> list;
        synchronized (this) {
            List<ModelLoader<A, ?>> a2 = this.b.a(cls);
            list = a2;
            if (a2 == null) {
                list = Collections.unmodifiableList(this.f7286a.a(cls));
                this.b.a(cls, list);
            }
        }
        return list;
    }

    public List<Class<?>> a(Class<?> cls) {
        List<Class<?>> b;
        synchronized (this) {
            b = this.f7286a.b(cls);
        }
        return b;
    }

    public <A> List<ModelLoader<A, ?>> a(A a2) {
        List<ModelLoader<A, ?>> b = b((Class) b(a2));
        if (b.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException(a2);
        }
        int size = b.size();
        ArrayList emptyList = Collections.emptyList();
        boolean z = true;
        int i = 0;
        while (i < size) {
            ModelLoader<A, ?> modelLoader = b.get(i);
            List<ModelLoader<A, ?>> list = emptyList;
            boolean z2 = z;
            if (modelLoader.a(a2)) {
                z2 = z;
                if (z) {
                    emptyList = new ArrayList(size - i);
                    z2 = false;
                }
                emptyList.add(modelLoader);
                list = emptyList;
            }
            i++;
            emptyList = list;
            z = z2;
        }
        if (emptyList.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException(a2, b);
        }
        return emptyList;
    }

    public <Model, Data> void a(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        synchronized (this) {
            this.f7286a.a(cls, cls2, modelLoaderFactory);
            this.b.a();
        }
    }

    public <Model, Data> void b(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        synchronized (this) {
            a((List) this.f7286a.b(cls, cls2, modelLoaderFactory));
            this.b.a();
        }
    }
}
