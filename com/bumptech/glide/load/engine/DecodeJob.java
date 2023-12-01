package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/DecodeJob.class */
class DecodeJob<R> implements DataFetcherGenerator.FetcherReadyCallback, FactoryPools.Poolable, Comparable<DecodeJob<?>>, Runnable {
    private DataSource A;
    private DataFetcher<?> B;
    private volatile DataFetcherGenerator C;
    private volatile boolean D;
    private volatile boolean E;
    private final DiskCacheProvider d;
    private final Pools.Pool<DecodeJob<?>> e;
    private GlideContext h;
    private Key i;
    private Priority j;
    private EngineKey k;
    private int l;
    private int m;
    private DiskCacheStrategy n;
    private Options o;
    private Callback<R> p;
    private int q;
    private Stage r;
    private RunReason s;
    private long t;
    private boolean u;
    private Object v;
    private Thread w;
    private Key x;
    private Key y;
    private Object z;

    /* renamed from: a  reason: collision with root package name */
    private final DecodeHelper<R> f20747a = new DecodeHelper<>();
    private final List<Throwable> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final StateVerifier f20748c = StateVerifier.a();
    private final DeferredEncodeManager<?> f = new DeferredEncodeManager<>();
    private final ReleaseManager g = new ReleaseManager();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$1  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/DecodeJob$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20749a;
        static final /* synthetic */ int[] b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f20750c;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x008a -> B:49:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008e -> B:6:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0092 -> B:59:0x0033). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0096 -> B:53:0x003e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x009a -> B:47:0x0049). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x009e -> B:61:0x0054). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a2 -> B:17:0x005f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00a6 -> B:51:0x0073). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00aa -> B:45:0x007e). Please submit an issue!!! */
        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            f20750c = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20750c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[Stage.values().length];
            b = iArr2;
            try {
                iArr2[Stage.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[Stage.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                b[Stage.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                b[Stage.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                b[Stage.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            int[] iArr3 = new int[RunReason.values().length];
            f20749a = iArr3;
            try {
                iArr3[RunReason.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f20749a[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f20749a[RunReason.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/DecodeJob$Callback.class */
    public interface Callback<R> {
        void a(DecodeJob<?> decodeJob);

        void a(GlideException glideException);

        void a(Resource<R> resource, DataSource dataSource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/DecodeJob$DecodeCallback.class */
    public final class DecodeCallback<Z> implements DecodePath.DecodeCallback<Z> {
        private final DataSource b;

        DecodeCallback(DataSource dataSource) {
            this.b = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.DecodePath.DecodeCallback
        public Resource<Z> a(Resource<Z> resource) {
            return DecodeJob.this.a(this.b, resource);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/DecodeJob$DeferredEncodeManager.class */
    public static class DeferredEncodeManager<Z> {

        /* renamed from: a  reason: collision with root package name */
        private Key f20752a;
        private ResourceEncoder<Z> b;

        /* renamed from: c  reason: collision with root package name */
        private LockedResource<Z> f20753c;

        DeferredEncodeManager() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void a(Key key, ResourceEncoder<X> resourceEncoder, LockedResource<X> lockedResource) {
            this.f20752a = key;
            this.b = resourceEncoder;
            this.f20753c = lockedResource;
        }

        void a(DiskCacheProvider diskCacheProvider, Options options) {
            GlideTrace.a("DecodeJob.encode");
            try {
                diskCacheProvider.a().a(this.f20752a, new DataCacheWriter(this.b, this.f20753c, options));
            } finally {
                this.f20753c.e();
                GlideTrace.a();
            }
        }

        boolean a() {
            return this.f20753c != null;
        }

        void b() {
            this.f20752a = null;
            this.b = null;
            this.f20753c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/DecodeJob$DiskCacheProvider.class */
    public interface DiskCacheProvider {
        DiskCache a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/DecodeJob$ReleaseManager.class */
    public static class ReleaseManager {

        /* renamed from: a  reason: collision with root package name */
        private boolean f20754a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f20755c;

        ReleaseManager() {
        }

        private boolean b(boolean z) {
            return (this.f20755c || z || this.b) && this.f20754a;
        }

        boolean a() {
            boolean b;
            synchronized (this) {
                this.b = true;
                b = b(false);
            }
            return b;
        }

        boolean a(boolean z) {
            boolean b;
            synchronized (this) {
                this.f20754a = true;
                b = b(z);
            }
            return b;
        }

        boolean b() {
            boolean b;
            synchronized (this) {
                this.f20755c = true;
                b = b(false);
            }
            return b;
        }

        void c() {
            synchronized (this) {
                this.b = false;
                this.f20754a = false;
                this.f20755c = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/DecodeJob$RunReason.class */
    public enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/DecodeJob$Stage.class */
    public enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodeJob(DiskCacheProvider diskCacheProvider, Pools.Pool<DecodeJob<?>> pool) {
        this.d = diskCacheProvider;
        this.e = pool;
    }

    private Options a(DataSource dataSource) {
        Options options = this.o;
        if (Build.VERSION.SDK_INT < 26) {
            return options;
        }
        boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f20747a.m();
        Boolean bool = (Boolean) options.a(Downsampler.e);
        if (bool == null || (bool.booleanValue() && !z)) {
            Options options2 = new Options();
            options2.a(this.o);
            options2.a(Downsampler.e, Boolean.valueOf(z));
            return options2;
        }
        return options;
    }

    private Stage a(Stage stage) {
        int i = AnonymousClass1.b[stage.ordinal()];
        if (i == 1) {
            return this.n.b() ? Stage.DATA_CACHE : a(Stage.DATA_CACHE);
        } else if (i == 2) {
            return this.u ? Stage.FINISHED : Stage.SOURCE;
        } else if (i == 3 || i == 4) {
            return Stage.FINISHED;
        } else {
            if (i == 5) {
                return this.n.a() ? Stage.RESOURCE_CACHE : a(Stage.RESOURCE_CACHE);
            }
            throw new IllegalArgumentException("Unrecognized stage: " + stage);
        }
    }

    private <Data> Resource<R> a(DataFetcher<?> dataFetcher, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            dataFetcher.a();
            return null;
        }
        try {
            long a2 = LogTime.a();
            Resource<R> a3 = a((DecodeJob<R>) data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Decoded result " + a3, a2);
            }
            return a3;
        } finally {
            dataFetcher.a();
        }
    }

    private <Data> Resource<R> a(Data data, DataSource dataSource) throws GlideException {
        return a((DecodeJob<R>) data, dataSource, (LoadPath<DecodeJob<R>, ResourceType, R>) ((LoadPath<Data, ?, R>) this.f20747a.b(data.getClass())));
    }

    private <Data, ResourceType> Resource<R> a(Data data, DataSource dataSource, LoadPath<Data, ResourceType, R> loadPath) throws GlideException {
        Options a2 = a(dataSource);
        DataRewinder<Data> b = this.h.d().b((Registry) data);
        try {
            return loadPath.a(b, a2, this.l, this.m, new DecodeCallback(dataSource));
        } finally {
            b.b();
        }
    }

    private void a(Resource<R> resource, DataSource dataSource) {
        m();
        this.p.a(resource, dataSource);
    }

    private void a(String str, long j) {
        a(str, j, (String) null);
    }

    private void a(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(LogTime.a(j));
        sb.append(", load key: ");
        sb.append(this.k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    private void b(Resource<R> resource, DataSource dataSource) {
        if (resource instanceof Initializable) {
            ((Initializable) resource).d();
        }
        LockedResource lockedResource = null;
        LockedResource lockedResource2 = resource;
        if (this.f.a()) {
            lockedResource2 = LockedResource.a(resource);
            lockedResource = lockedResource2;
        }
        a((Resource) lockedResource2, dataSource);
        this.r = Stage.ENCODE;
        try {
            if (this.f.a()) {
                this.f.a(this.d, this.o);
            }
            e();
        } finally {
            if (lockedResource != null) {
                lockedResource.e();
            }
        }
    }

    private void e() {
        if (this.g.a()) {
            g();
        }
    }

    private void f() {
        if (this.g.b()) {
            g();
        }
    }

    private void g() {
        this.g.c();
        this.f.b();
        this.f20747a.a();
        this.D = false;
        this.h = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.k = null;
        this.p = null;
        this.r = null;
        this.C = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.t = 0L;
        this.E = false;
        this.v = null;
        this.b.clear();
        this.e.release(this);
    }

    private int h() {
        return this.j.ordinal();
    }

    private void i() {
        int i = AnonymousClass1.f20749a[this.s.ordinal()];
        if (i == 1) {
            this.r = a(Stage.INITIALIZE);
            this.C = j();
            k();
        } else if (i == 2) {
            k();
        } else if (i == 3) {
            n();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.s);
        }
    }

    private DataFetcherGenerator j() {
        int i = AnonymousClass1.b[this.r.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return null;
                    }
                    throw new IllegalStateException("Unrecognized stage: " + this.r);
                }
                return new SourceGenerator(this.f20747a, this);
            }
            return new DataCacheGenerator(this.f20747a, this);
        }
        return new ResourceCacheGenerator(this.f20747a, this);
    }

    private void k() {
        this.w = Thread.currentThread();
        this.t = LogTime.a();
        boolean z = false;
        do {
            boolean z2 = z;
            if (!this.E) {
                z2 = z;
                if (this.C != null) {
                    z = this.C.a();
                    z2 = z;
                    if (!z) {
                        this.r = a(this.r);
                        this.C = j();
                    }
                }
            }
            if ((this.r == Stage.FINISHED || this.E) && !z2) {
                l();
                return;
            }
            return;
        } while (this.r != Stage.SOURCE);
        c();
    }

    private void l() {
        m();
        this.p.a(new GlideException("Failed to load resource", new ArrayList(this.b)));
        f();
    }

    private void m() {
        Throwable th;
        this.f20748c.b();
        if (!this.D) {
            this.D = true;
            return;
        }
        if (this.b.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.b;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    private void n() {
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Retrieved data", this.t, "data: " + this.z + ", cache key: " + this.x + ", fetcher: " + this.B);
        }
        Resource<R> resource = null;
        try {
            resource = a(this.B, (DataFetcher<?>) this.z, this.A);
        } catch (GlideException e) {
            e.a(this.y, this.A);
            this.b.add(e);
        }
        if (resource != null) {
            b(resource, this.A);
        } else {
            k();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(DecodeJob<?> decodeJob) {
        int h = h() - decodeJob.h();
        int i = h;
        if (h == 0) {
            i = this.q - decodeJob.q;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodeJob<R> a(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options, Callback<R> callback, int i3) {
        this.f20747a.a(glideContext, obj, key, i, i2, diskCacheStrategy, cls, cls2, priority, options, map, z, z2, this.d);
        this.h = glideContext;
        this.i = key;
        this.j = priority;
        this.k = engineKey;
        this.l = i;
        this.m = i2;
        this.n = diskCacheStrategy;
        this.u = z3;
        this.o = options;
        this.p = callback;
        this.q = i3;
        this.s = RunReason.INITIALIZE;
        this.v = obj;
        return this;
    }

    <Z> Resource<Z> a(DataSource dataSource, Resource<Z> resource) {
        Resource<Z> resource2;
        Transformation<Z> transformation;
        EncodeStrategy encodeStrategy;
        ResourceEncoder<Z> resourceEncoder;
        Key dataCacheKey;
        Class<?> cls = resource.f().getClass();
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            transformation = this.f20747a.c(cls);
            resource2 = transformation.a(this.h, resource, this.l, this.m);
        } else {
            resource2 = resource;
            transformation = null;
        }
        if (!resource.equals(resource2)) {
            resource.c();
        }
        if (this.f20747a.a((Resource<?>) resource2)) {
            resourceEncoder = this.f20747a.b(resource2);
            encodeStrategy = resourceEncoder.a(this.o);
        } else {
            encodeStrategy = EncodeStrategy.NONE;
            resourceEncoder = null;
        }
        if (this.n.a(!this.f20747a.a(this.x), dataSource, encodeStrategy)) {
            if (resourceEncoder != null) {
                int i = AnonymousClass1.f20750c[encodeStrategy.ordinal()];
                if (i == 1) {
                    dataCacheKey = new DataCacheKey(this.x, this.i);
                } else if (i != 2) {
                    throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
                } else {
                    dataCacheKey = new ResourceCacheKey(this.f20747a.i(), this.x, this.i, this.l, this.m, transformation, cls, this.o);
                }
                LockedResource a2 = LockedResource.a(resource2);
                this.f.a(dataCacheKey, resourceEncoder, a2);
                return a2;
            }
            throw new Registry.NoResultEncoderAvailableException(resource2.f().getClass());
        }
        return resource2;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void a(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        dataFetcher.a();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.a(key, dataSource, dataFetcher.c());
        this.b.add(glideException);
        if (Thread.currentThread() == this.w) {
            k();
            return;
        }
        this.s = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.p.a((DecodeJob<?>) this);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void a(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.x = key;
        this.z = obj;
        this.B = dataFetcher;
        this.A = dataSource;
        this.y = key2;
        if (Thread.currentThread() != this.w) {
            this.s = RunReason.DECODE_DATA;
            this.p.a((DecodeJob<?>) this);
            return;
        }
        GlideTrace.a("DecodeJob.decodeFromRetrievedData");
        try {
            n();
        } finally {
            GlideTrace.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        if (this.g.a(z)) {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        Stage a2 = a(Stage.INITIALIZE);
        return a2 == Stage.RESOURCE_CACHE || a2 == Stage.DATA_CACHE;
    }

    public void b() {
        this.E = true;
        DataFetcherGenerator dataFetcherGenerator = this.C;
        if (dataFetcherGenerator != null) {
            dataFetcherGenerator.b();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void c() {
        this.s = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.p.a((DecodeJob<?>) this);
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public StateVerifier d() {
        return this.f20748c;
    }

    @Override // java.lang.Runnable
    public void run() {
        GlideTrace.a("DecodeJob#run(model=%s)", this.v);
        DataFetcher<?> dataFetcher = this.B;
        try {
            try {
                if (this.E) {
                    l();
                    if (dataFetcher != null) {
                        dataFetcher.a();
                    }
                    GlideTrace.a();
                    return;
                }
                i();
                if (dataFetcher != null) {
                    dataFetcher.a();
                }
                GlideTrace.a();
            } catch (CallbackException e) {
                throw e;
            }
        }
    }
}
