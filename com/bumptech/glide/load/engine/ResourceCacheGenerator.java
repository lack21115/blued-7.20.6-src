package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/ResourceCacheGenerator.class */
public class ResourceCacheGenerator implements DataFetcher.DataCallback<Object>, DataFetcherGenerator {

    /* renamed from: a  reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f20792a;
    private final DecodeHelper<?> b;

    /* renamed from: c  reason: collision with root package name */
    private int f20793c;
    private int d = -1;
    private Key e;
    private List<ModelLoader<File, ?>> f;
    private int g;
    private volatile ModelLoader.LoadData<?> h;
    private File i;
    private ResourceCacheKey j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResourceCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.b = decodeHelper;
        this.f20792a = fetcherReadyCallback;
    }

    private boolean c() {
        return this.g < this.f.size();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void a(Exception exc) {
        this.f20792a.a(this.j, exc, this.h.f20891c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void a(Object obj) {
        this.f20792a.a(this.e, obj, this.h.f20891c, DataSource.RESOURCE_DISK_CACHE, this.j);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean a() {
        List<Key> o = this.b.o();
        boolean z = false;
        if (o.isEmpty()) {
            return false;
        }
        List<Class<?>> l = this.b.l();
        if (l.isEmpty()) {
            if (File.class.equals(this.b.j())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.b.k() + " to " + this.b.j());
        }
        while (true) {
            if (this.f != null && c()) {
                this.h = null;
                while (!z && c()) {
                    List<ModelLoader<File, ?>> list = this.f;
                    int i = this.g;
                    this.g = i + 1;
                    this.h = list.get(i).a(this.i, this.b.g(), this.b.h(), this.b.e());
                    if (this.h != null && this.b.a(this.h.f20891c.c())) {
                        this.h.f20891c.a(this.b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.d + 1;
            this.d = i2;
            if (i2 >= l.size()) {
                int i3 = this.f20793c + 1;
                this.f20793c = i3;
                if (i3 >= o.size()) {
                    return false;
                }
                this.d = 0;
            }
            Key key = o.get(this.f20793c);
            Class<?> cls = l.get(this.d);
            this.j = new ResourceCacheKey(this.b.i(), key, this.b.f(), this.b.g(), this.b.h(), this.b.c(cls), cls, this.b.e());
            File a2 = this.b.b().a(this.j);
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
            loadData.f20891c.b();
        }
    }
}
