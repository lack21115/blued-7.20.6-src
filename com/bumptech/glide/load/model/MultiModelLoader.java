package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/MultiModelLoader.class */
class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ModelLoader<Model, Data>> f20895a;
    private final Pools.Pool<List<Throwable>> b;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/MultiModelLoader$MultiFetcher.class */
    static class MultiFetcher<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final List<DataFetcher<Data>> f20896a;
        private final Pools.Pool<List<Throwable>> b;

        /* renamed from: c  reason: collision with root package name */
        private int f20897c;
        private Priority d;
        private DataFetcher.DataCallback<? super Data> e;
        private List<Throwable> f;
        private boolean g;

        MultiFetcher(List<DataFetcher<Data>> list, Pools.Pool<List<Throwable>> pool) {
            this.b = pool;
            Preconditions.a(list);
            this.f20896a = list;
            this.f20897c = 0;
        }

        private void e() {
            if (this.g) {
                return;
            }
            if (this.f20897c < this.f20896a.size() - 1) {
                this.f20897c++;
                a(this.d, this.e);
                return;
            }
            Preconditions.a(this.f);
            this.e.a((Exception) new GlideException("Fetch failed", new ArrayList(this.f)));
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void a() {
            List<Throwable> list = this.f;
            if (list != null) {
                this.b.release(list);
            }
            this.f = null;
            for (DataFetcher<Data> dataFetcher : this.f20896a) {
                dataFetcher.a();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void a(Priority priority, DataFetcher.DataCallback<? super Data> dataCallback) {
            this.d = priority;
            this.e = dataCallback;
            this.f = this.b.acquire();
            this.f20896a.get(this.f20897c).a(priority, this);
            if (this.g) {
                b();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void a(Exception exc) {
            ((List) Preconditions.a(this.f)).add(exc);
            e();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void a(Data data) {
            if (data != null) {
                this.e.a((DataFetcher.DataCallback<? super Data>) data);
            } else {
                e();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void b() {
            this.g = true;
            for (DataFetcher<Data> dataFetcher : this.f20896a) {
                dataFetcher.b();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<Data> c() {
            return this.f20896a.get(0).c();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource d() {
            return this.f20896a.get(0).d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiModelLoader(List<ModelLoader<Model, Data>> list, Pools.Pool<List<Throwable>> pool) {
        this.f20895a = list;
        this.b = pool;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> a(Model model, int i, int i2, Options options) {
        Key key;
        int size = this.f20895a.size();
        ArrayList arrayList = new ArrayList(size);
        int i3 = 0;
        Key key2 = null;
        while (true) {
            key = key2;
            if (i3 >= size) {
                break;
            }
            ModelLoader<Model, Data> modelLoader = this.f20895a.get(i3);
            Key key3 = key;
            if (modelLoader.a(model)) {
                ModelLoader.LoadData<Data> a2 = modelLoader.a(model, i, i2, options);
                key3 = key;
                if (a2 != null) {
                    key3 = a2.f20890a;
                    arrayList.add(a2.f20891c);
                }
            }
            i3++;
            key2 = key3;
        }
        ModelLoader.LoadData<Data> loadData = null;
        if (!arrayList.isEmpty()) {
            loadData = null;
            if (key != null) {
                loadData = new ModelLoader.LoadData<>(key, new MultiFetcher(arrayList, this.b));
            }
        }
        return loadData;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean a(Model model) {
        for (ModelLoader<Model, Data> modelLoader : this.f20895a) {
            if (modelLoader.a(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f20895a.toArray()) + '}';
    }
}
