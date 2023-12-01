package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/DataCacheGenerator.class */
public class DataCacheGenerator implements DataFetcher.DataCallback<Object>, DataFetcherGenerator {

    /* renamed from: a  reason: collision with root package name */
    private final List<Key> f7134a;
    private final DecodeHelper<?> b;

    /* renamed from: c  reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f7135c;
    private int d;
    private Key e;
    private List<ModelLoader<File, ?>> f;
    private int g;
    private volatile ModelLoader.LoadData<?> h;
    private File i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this(decodeHelper.o(), decodeHelper, fetcherReadyCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheGenerator(List<Key> list, DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.d = -1;
        this.f7134a = list;
        this.b = decodeHelper;
        this.f7135c = fetcherReadyCallback;
    }

    private boolean c() {
        return this.g < this.f.size();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void a(Exception exc) {
        this.f7135c.a(this.e, exc, this.h.f7285c, DataSource.DATA_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void a(Object obj) {
        this.f7135c.a(this.e, obj, this.h.f7285c, DataSource.DATA_DISK_CACHE, this.e);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.f != null && c()) {
                this.h = null;
                while (!z && c()) {
                    List<ModelLoader<File, ?>> list = this.f;
                    int i = this.g;
                    this.g = i + 1;
                    this.h = list.get(i).a(this.i, this.b.g(), this.b.h(), this.b.e());
                    if (this.h != null && this.b.a(this.h.f7285c.c())) {
                        this.h.f7285c.a(this.b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.d + 1;
            this.d = i2;
            if (i2 >= this.f7134a.size()) {
                return false;
            }
            Key key = this.f7134a.get(this.d);
            File a2 = this.b.b().a(new DataCacheKey(key, this.b.f()));
            this.i = a2;
            if (a2 != null) {
                this.e = key;
                this.f = this.b.a(a2);
                this.g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void b() {
        ModelLoader.LoadData<?> loadData = this.h;
        if (loadData != null) {
            loadData.f7285c.b();
        }
    }
}
