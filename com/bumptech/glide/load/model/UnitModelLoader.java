package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/UnitModelLoader.class */
public class UnitModelLoader<Model> implements ModelLoader<Model, Model> {

    /* renamed from: a  reason: collision with root package name */
    private static final UnitModelLoader<?> f7303a = new UnitModelLoader<>();

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/UnitModelLoader$Factory.class */
    public static class Factory<Model> implements ModelLoaderFactory<Model, Model> {

        /* renamed from: a  reason: collision with root package name */
        private static final Factory<?> f7304a = new Factory<>();

        public static <T> Factory<T> b() {
            return (Factory<T>) f7304a;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Model, Model> a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return UnitModelLoader.a();
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void a() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/UnitModelLoader$UnitFetcher.class */
    static class UnitFetcher<Model> implements DataFetcher<Model> {

        /* renamed from: a  reason: collision with root package name */
        private final Model f7305a;

        UnitFetcher(Model model) {
            this.f7305a = model;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void a() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void a(Priority priority, DataFetcher.DataCallback<? super Model> dataCallback) {
            dataCallback.a((DataFetcher.DataCallback<? super Model>) ((Model) this.f7305a));
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<Model> c() {
            return (Class<Model>) this.f7305a.getClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource d() {
            return DataSource.LOCAL;
        }
    }

    public static <T> UnitModelLoader<T> a() {
        return (UnitModelLoader<T>) f7303a;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Model> a(Model model, int i, int i2, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(model), new UnitFetcher(model));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean a(Model model) {
        return true;
    }
}
