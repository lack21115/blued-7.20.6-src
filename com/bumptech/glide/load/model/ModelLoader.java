package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.Preconditions;
import java.util.Collections;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/ModelLoader.class */
public interface ModelLoader<Model, Data> {

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/ModelLoader$LoadData.class */
    public static class LoadData<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final Key f7284a;
        public final List<Key> b;

        /* renamed from: c  reason: collision with root package name */
        public final DataFetcher<Data> f7285c;

        public LoadData(Key key, DataFetcher<Data> dataFetcher) {
            this(key, Collections.emptyList(), dataFetcher);
        }

        public LoadData(Key key, List<Key> list, DataFetcher<Data> dataFetcher) {
            this.f7284a = (Key) Preconditions.a(key);
            this.b = (List) Preconditions.a(list);
            this.f7285c = (DataFetcher) Preconditions.a(dataFetcher);
        }
    }

    LoadData<Data> a(Model model, int i, int i2, Options options);

    boolean a(Model model);
}
