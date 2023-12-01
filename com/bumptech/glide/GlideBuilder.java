package com.bumptech.glide;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/GlideBuilder.class */
public final class GlideBuilder {
    private Engine b;

    /* renamed from: c  reason: collision with root package name */
    private BitmapPool f20648c;
    private ArrayPool d;
    private MemoryCache e;
    private GlideExecutor f;
    private GlideExecutor g;
    private DiskCache.Factory h;
    private MemorySizeCalculator i;
    private ConnectivityMonitorFactory j;
    private RequestManagerRetriever.RequestManagerFactory m;
    private GlideExecutor n;
    private boolean o;
    private List<RequestListener<Object>> p;
    private boolean q;
    private boolean r;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, TransitionOptions<?, ?>> f20647a = new ArrayMap();
    private int k = 4;
    private Glide.RequestOptionsFactory l = new Glide.RequestOptionsFactory() { // from class: com.bumptech.glide.GlideBuilder.1
        @Override // com.bumptech.glide.Glide.RequestOptionsFactory
        public RequestOptions a() {
            return new RequestOptions();
        }
    };

    /* renamed from: com.bumptech.glide.GlideBuilder$2  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/GlideBuilder$2.class */
    class AnonymousClass2 implements Glide.RequestOptionsFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RequestOptions f20650a;

        @Override // com.bumptech.glide.Glide.RequestOptionsFactory
        public RequestOptions a() {
            RequestOptions requestOptions = this.f20650a;
            return requestOptions != null ? requestOptions : new RequestOptions();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Glide a(Context context) {
        if (this.f == null) {
            this.f = GlideExecutor.d();
        }
        if (this.g == null) {
            this.g = GlideExecutor.b();
        }
        if (this.n == null) {
            this.n = GlideExecutor.g();
        }
        if (this.i == null) {
            this.i = new MemorySizeCalculator.Builder(context).a();
        }
        if (this.j == null) {
            this.j = new DefaultConnectivityMonitorFactory();
        }
        if (this.f20648c == null) {
            int b = this.i.b();
            if (b > 0) {
                this.f20648c = new LruBitmapPool(b);
            } else {
                this.f20648c = new BitmapPoolAdapter();
            }
        }
        if (this.d == null) {
            this.d = new LruArrayPool(this.i.c());
        }
        if (this.e == null) {
            this.e = new LruResourceCache(this.i.a());
        }
        if (this.h == null) {
            this.h = new InternalCacheDiskCacheFactory(context);
        }
        if (this.b == null) {
            this.b = new Engine(this.e, this.h, this.g, this.f, GlideExecutor.e(), this.n, this.o);
        }
        List<RequestListener<Object>> list = this.p;
        if (list == null) {
            this.p = Collections.emptyList();
        } else {
            this.p = Collections.unmodifiableList(list);
        }
        return new Glide(context, this.b, this.e, this.f20648c, this.d, new RequestManagerRetriever(this.m), this.j, this.k, this.l, this.f20647a, this.p, this.q, this.r);
    }

    public GlideBuilder a(int i) {
        if (i < 2 || i > 6) {
            throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
        }
        this.k = i;
        return this;
    }

    public GlideBuilder a(BitmapPool bitmapPool) {
        this.f20648c = bitmapPool;
        return this;
    }

    public GlideBuilder a(DiskCache.Factory factory) {
        this.h = factory;
        return this;
    }

    public GlideBuilder a(MemoryCache memoryCache) {
        this.e = memoryCache;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.m = requestManagerFactory;
    }
}
