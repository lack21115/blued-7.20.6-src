package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/DecodeHelper.class */
public final class DecodeHelper<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ModelLoader.LoadData<?>> f7139a = new ArrayList();
    private final List<Key> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private GlideContext f7140c;
    private Object d;
    private int e;
    private int f;
    private Class<?> g;
    private DecodeJob.DiskCacheProvider h;
    private Options i;
    private Map<Class<?>, Transformation<?>> j;
    private Class<Transcode> k;
    private boolean l;
    private boolean m;
    private Key n;
    private Priority o;
    private DiskCacheStrategy p;
    private boolean q;
    private boolean r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public <X> Encoder<X> a(X x) throws Registry.NoSourceEncoderAvailableException {
        return this.f7140c.d().a((Registry) x);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ModelLoader<File, ?>> a(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f7140c.d().c(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f7140c = null;
        this.d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.f7139a.clear();
        this.l = false;
        this.b.clear();
        this.m = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <R> void a(GlideContext glideContext, Object obj, Key key, int i, int i2, DiskCacheStrategy diskCacheStrategy, Class<?> cls, Class<R> cls2, Priority priority, Options options, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, DecodeJob.DiskCacheProvider diskCacheProvider) {
        this.f7140c = glideContext;
        this.d = obj;
        this.n = key;
        this.e = i;
        this.f = i2;
        this.p = diskCacheStrategy;
        this.g = cls;
        this.h = diskCacheProvider;
        this.k = cls2;
        this.o = priority;
        this.i = options;
        this.j = map;
        this.q = z;
        this.r = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Key key) {
        List<ModelLoader.LoadData<?>> n = n();
        int size = n.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            if (n.get(i2).f7284a.equals(key)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Resource<?> resource) {
        return this.f7140c.d().a(resource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean a(Class<?> cls) {
        return b(cls) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> ResourceEncoder<Z> b(Resource<Z> resource) {
        return this.f7140c.d().b((Resource) resource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Data> LoadPath<Data, ?, Transcode> b(Class<Data> cls) {
        return this.f7140c.d().a(cls, this.g, this.k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DiskCache b() {
        return this.h.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> Transformation<Z> c(Class<Z> cls) {
        Transformation<?> transformation = this.j.get(cls);
        Transformation<?> transformation2 = transformation;
        if (transformation == null) {
            Iterator<Map.Entry<Class<?>, Transformation<?>>> it = this.j.entrySet().iterator();
            while (true) {
                transformation2 = transformation;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, Transformation<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    transformation2 = next.getValue();
                    break;
                }
            }
        }
        if (transformation2 == null) {
            if (this.j.isEmpty() && this.q) {
                throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            }
            return UnitTransformation.a();
        }
        return (Transformation<Z>) transformation2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DiskCacheStrategy c() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Priority d() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Options e() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Key f() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayPool i() {
        return this.f7140c.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> j() {
        return (Class<Transcode>) this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> k() {
        return this.d.getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Class<?>> l() {
        return this.f7140c.d().b(this.d.getClass(), this.g, this.k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ModelLoader.LoadData<?>> n() {
        if (!this.l) {
            this.l = true;
            this.f7139a.clear();
            List c2 = this.f7140c.d().c(this.d);
            int size = c2.size();
            for (int i = 0; i < size; i++) {
                ModelLoader.LoadData<?> a2 = ((ModelLoader) c2.get(i)).a(this.d, this.e, this.f, this.i);
                if (a2 != null) {
                    this.f7139a.add(a2);
                }
            }
        }
        return this.f7139a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Key> o() {
        if (!this.m) {
            this.m = true;
            this.b.clear();
            List<ModelLoader.LoadData<?>> n = n();
            int size = n.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                ModelLoader.LoadData<?> loadData = n.get(i2);
                if (!this.b.contains(loadData.f7284a)) {
                    this.b.add(loadData.f7284a);
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < loadData.b.size()) {
                        if (!this.b.contains(loadData.b.get(i4))) {
                            this.b.add(loadData.b.get(i4));
                        }
                        i3 = i4 + 1;
                    }
                }
                i = i2 + 1;
            }
        }
        return this.b;
    }
}
