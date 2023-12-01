package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/SourceGenerator.class */
public class SourceGenerator implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {

    /* renamed from: a  reason: collision with root package name */
    private final DecodeHelper<?> f20796a;
    private final DataFetcherGenerator.FetcherReadyCallback b;

    /* renamed from: c  reason: collision with root package name */
    private int f20797c;
    private DataCacheGenerator d;
    private Object e;
    private volatile ModelLoader.LoadData<?> f;
    private DataCacheKey g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SourceGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f20796a = decodeHelper;
        this.b = fetcherReadyCallback;
    }

    private void a(Object obj) {
        long a2 = LogTime.a();
        try {
            Encoder<X> a3 = this.f20796a.a((DecodeHelper<?>) obj);
            DataCacheWriter dataCacheWriter = new DataCacheWriter(a3, obj, this.f20796a.e());
            this.g = new DataCacheKey(this.f.f20890a, this.f20796a.f());
            this.f20796a.b().a(this.g, dataCacheWriter);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.g + ", data: " + obj + ", encoder: " + a3 + ", duration: " + LogTime.a(a2));
            }
            this.f.f20891c.a();
            this.d = new DataCacheGenerator(Collections.singletonList(this.f.f20890a), this.f20796a, this);
        } catch (Throwable th) {
            this.f.f20891c.a();
            throw th;
        }
    }

    private void b(final ModelLoader.LoadData<?> loadData) {
        this.f.f20891c.a(this.f20796a.d(), new DataFetcher.DataCallback<Object>() { // from class: com.bumptech.glide.load.engine.SourceGenerator.1
            @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
            public void a(Exception exc) {
                if (SourceGenerator.this.a(loadData)) {
                    SourceGenerator.this.a(loadData, exc);
                }
            }

            @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
            public void a(Object obj) {
                if (SourceGenerator.this.a(loadData)) {
                    SourceGenerator.this.a(loadData, obj);
                }
            }
        });
    }

    private boolean d() {
        return this.f20797c < this.f20796a.n().size();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void a(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.b.a(key, exc, dataFetcher, this.f.f20891c.d());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void a(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.b.a(key, obj, dataFetcher, this.f.f20891c.d(), key);
    }

    void a(ModelLoader.LoadData<?> loadData, Exception exc) {
        this.b.a(this.g, exc, loadData.f20891c, loadData.f20891c.d());
    }

    void a(ModelLoader.LoadData<?> loadData, Object obj) {
        DiskCacheStrategy c2 = this.f20796a.c();
        if (obj == null || !c2.a(loadData.f20891c.d())) {
            this.b.a(loadData.f20890a, obj, loadData.f20891c, loadData.f20891c.d(), this.g);
            return;
        }
        this.e = obj;
        this.b.c();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean a() {
        Object obj = this.e;
        if (obj != null) {
            this.e = null;
            a(obj);
        }
        DataCacheGenerator dataCacheGenerator = this.d;
        if (dataCacheGenerator == null || !dataCacheGenerator.a()) {
            this.d = null;
            this.f = null;
            boolean z = false;
            while (!z && d()) {
                List<ModelLoader.LoadData<?>> n = this.f20796a.n();
                int i = this.f20797c;
                this.f20797c = i + 1;
                this.f = n.get(i);
                if (this.f != null && (this.f20796a.c().a(this.f.f20891c.d()) || this.f20796a.a(this.f.f20891c.c()))) {
                    b(this.f);
                    z = true;
                }
            }
            return z;
        }
        return true;
    }

    boolean a(ModelLoader.LoadData<?> loadData) {
        ModelLoader.LoadData<?> loadData2 = this.f;
        return loadData2 != null && loadData2 == loadData;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void b() {
        ModelLoader.LoadData<?> loadData = this.f;
        if (loadData != null) {
            loadData.f20891c.b();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void c() {
        throw new UnsupportedOperationException();
    }
}
