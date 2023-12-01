package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/BaseRequestOptions.class */
public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private int f7433a;
    private Drawable e;
    private int f;
    private Drawable g;
    private int h;
    private boolean m;
    private Drawable o;
    private int p;
    private boolean t;
    private Resources.Theme u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean z;
    private float b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    private DiskCacheStrategy f7434c = DiskCacheStrategy.e;
    private Priority d = Priority.NORMAL;
    private boolean i = true;
    private int j = -1;
    private int k = -1;
    private Key l = EmptySignature.a();
    private boolean n = true;
    private Options q = new Options();
    private Map<Class<?>, Transformation<?>> r = new CachedHashCodeArrayMap();
    private Class<?> s = Object.class;
    private boolean y = true;

    private T a() {
        if (this.t) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return b();
    }

    private T a(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation, boolean z) {
        T b = z ? b(downsampleStrategy, transformation) : a(downsampleStrategy, transformation);
        b.y = true;
        return b;
    }

    private boolean a(int i) {
        return a(this.f7433a, i);
    }

    private static boolean a(int i, int i2) {
        return (i & i2) != 0;
    }

    private T b() {
        return this;
    }

    private T c(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        return a(downsampleStrategy, transformation, false);
    }

    public final Drawable A() {
        return this.o;
    }

    public final Resources.Theme B() {
        return this.u;
    }

    public final boolean C() {
        return this.i;
    }

    public final Key D() {
        return this.l;
    }

    public final boolean E() {
        return a(8);
    }

    public final Priority F() {
        return this.d;
    }

    public final int G() {
        return this.k;
    }

    public final boolean H() {
        return Util.a(this.k, this.j);
    }

    public final int I() {
        return this.j;
    }

    public final float J() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean K() {
        return this.y;
    }

    public final boolean L() {
        return this.w;
    }

    public final boolean M() {
        return this.z;
    }

    public final boolean N() {
        return this.x;
    }

    /* JADX WARN: Multi-variable type inference failed */
    T a(Transformation<Bitmap> transformation, boolean z) {
        if (this.v) {
            return (T) clone().a(transformation, z);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z);
        a(Bitmap.class, transformation, z);
        a(Drawable.class, drawableTransformation, z);
        a(BitmapDrawable.class, drawableTransformation.a(), z);
        a(GifDrawable.class, new GifDrawableTransformation(transformation), z);
        return a();
    }

    final T a(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        if (this.v) {
            return (T) clone().a(downsampleStrategy, transformation);
        }
        b(downsampleStrategy);
        return a(transformation, false);
    }

    <Y> T a(Class<Y> cls, Transformation<Y> transformation, boolean z) {
        if (this.v) {
            return (T) clone().a(cls, transformation, z);
        }
        Preconditions.a(cls);
        Preconditions.a(transformation);
        this.r.put(cls, transformation);
        int i = this.f7433a | 2048;
        this.f7433a = i;
        this.n = true;
        int i2 = i | 65536;
        this.f7433a = i2;
        this.y = false;
        if (z) {
            this.f7433a = i2 | 131072;
            this.m = true;
        }
        return a();
    }

    public T b(float f) {
        if (this.v) {
            return (T) clone().b(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.b = f;
        this.f7433a |= 2;
        return a();
    }

    public T b(int i, int i2) {
        if (this.v) {
            return (T) clone().b(i, i2);
        }
        this.k = i;
        this.j = i2;
        this.f7433a |= 512;
        return a();
    }

    public T b(Drawable drawable) {
        if (this.v) {
            return (T) clone().b(drawable);
        }
        this.g = drawable;
        int i = this.f7433a | 64;
        this.f7433a = i;
        this.h = 0;
        this.f7433a = i & (-129);
        return a();
    }

    public T b(Priority priority) {
        if (this.v) {
            return (T) clone().b(priority);
        }
        this.d = (Priority) Preconditions.a(priority);
        this.f7433a |= 8;
        return a();
    }

    public T b(Key key) {
        if (this.v) {
            return (T) clone().b(key);
        }
        this.l = (Key) Preconditions.a(key);
        this.f7433a |= 1024;
        return a();
    }

    public <Y> T b(Option<Y> option, Y y) {
        if (this.v) {
            return (T) clone().b(option, y);
        }
        Preconditions.a(option);
        Preconditions.a(y);
        this.q.a(option, y);
        return a();
    }

    public T b(Transformation<Bitmap> transformation) {
        return a(transformation, true);
    }

    public T b(DiskCacheStrategy diskCacheStrategy) {
        if (this.v) {
            return (T) clone().b(diskCacheStrategy);
        }
        this.f7434c = (DiskCacheStrategy) Preconditions.a(diskCacheStrategy);
        this.f7433a |= 4;
        return a();
    }

    public T b(DownsampleStrategy downsampleStrategy) {
        return b((Option<Option>) DownsampleStrategy.h, (Option) Preconditions.a(downsampleStrategy));
    }

    final T b(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        if (this.v) {
            return (T) clone().b(downsampleStrategy, transformation);
        }
        b(downsampleStrategy);
        return b(transformation);
    }

    public T b(BaseRequestOptions<?> baseRequestOptions) {
        if (this.v) {
            return (T) clone().b(baseRequestOptions);
        }
        if (a(baseRequestOptions.f7433a, 2)) {
            this.b = baseRequestOptions.b;
        }
        if (a(baseRequestOptions.f7433a, 262144)) {
            this.w = baseRequestOptions.w;
        }
        if (a(baseRequestOptions.f7433a, 1048576)) {
            this.z = baseRequestOptions.z;
        }
        if (a(baseRequestOptions.f7433a, 4)) {
            this.f7434c = baseRequestOptions.f7434c;
        }
        if (a(baseRequestOptions.f7433a, 8)) {
            this.d = baseRequestOptions.d;
        }
        if (a(baseRequestOptions.f7433a, 16)) {
            this.e = baseRequestOptions.e;
            this.f = 0;
            this.f7433a &= -33;
        }
        if (a(baseRequestOptions.f7433a, 32)) {
            this.f = baseRequestOptions.f;
            this.e = null;
            this.f7433a &= -17;
        }
        if (a(baseRequestOptions.f7433a, 64)) {
            this.g = baseRequestOptions.g;
            this.h = 0;
            this.f7433a &= -129;
        }
        if (a(baseRequestOptions.f7433a, 128)) {
            this.h = baseRequestOptions.h;
            this.g = null;
            this.f7433a &= -65;
        }
        if (a(baseRequestOptions.f7433a, 256)) {
            this.i = baseRequestOptions.i;
        }
        if (a(baseRequestOptions.f7433a, 512)) {
            this.k = baseRequestOptions.k;
            this.j = baseRequestOptions.j;
        }
        if (a(baseRequestOptions.f7433a, 1024)) {
            this.l = baseRequestOptions.l;
        }
        if (a(baseRequestOptions.f7433a, 4096)) {
            this.s = baseRequestOptions.s;
        }
        if (a(baseRequestOptions.f7433a, 8192)) {
            this.o = baseRequestOptions.o;
            this.p = 0;
            this.f7433a &= -16385;
        }
        if (a(baseRequestOptions.f7433a, 16384)) {
            this.p = baseRequestOptions.p;
            this.o = null;
            this.f7433a &= -8193;
        }
        if (a(baseRequestOptions.f7433a, 32768)) {
            this.u = baseRequestOptions.u;
        }
        if (a(baseRequestOptions.f7433a, 65536)) {
            this.n = baseRequestOptions.n;
        }
        if (a(baseRequestOptions.f7433a, 131072)) {
            this.m = baseRequestOptions.m;
        }
        if (a(baseRequestOptions.f7433a, 2048)) {
            this.r.putAll(baseRequestOptions.r);
            this.y = baseRequestOptions.y;
        }
        if (a(baseRequestOptions.f7433a, 524288)) {
            this.x = baseRequestOptions.x;
        }
        if (!this.n) {
            this.r.clear();
            int i = this.f7433a & (-2049);
            this.f7433a = i;
            this.m = false;
            this.f7433a = i & (-131073);
            this.y = true;
        }
        this.f7433a |= baseRequestOptions.f7433a;
        this.q.a(baseRequestOptions.q);
        return a();
    }

    public T b(Class<?> cls) {
        if (this.v) {
            return (T) clone().b(cls);
        }
        this.s = (Class) Preconditions.a(cls);
        this.f7433a |= 4096;
        return a();
    }

    public T b(Transformation<Bitmap>... transformationArr) {
        return transformationArr.length > 1 ? a((Transformation<Bitmap>) new MultiTransformation(transformationArr), true) : transformationArr.length == 1 ? b(transformationArr[0]) : a();
    }

    public T d(boolean z) {
        if (this.v) {
            return (T) clone().d(true);
        }
        this.i = !z;
        this.f7433a |= 256;
        return a();
    }

    public T e(int i) {
        return b(i, i);
    }

    public T e(boolean z) {
        if (this.v) {
            return (T) clone().e(z);
        }
        this.x = z;
        this.f7433a |= 524288;
        return a();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof BaseRequestOptions) {
            BaseRequestOptions baseRequestOptions = (BaseRequestOptions) obj;
            z = false;
            if (Float.compare(baseRequestOptions.b, this.b) == 0) {
                z = false;
                if (this.f == baseRequestOptions.f) {
                    z = false;
                    if (Util.a(this.e, baseRequestOptions.e)) {
                        z = false;
                        if (this.h == baseRequestOptions.h) {
                            z = false;
                            if (Util.a(this.g, baseRequestOptions.g)) {
                                z = false;
                                if (this.p == baseRequestOptions.p) {
                                    z = false;
                                    if (Util.a(this.o, baseRequestOptions.o)) {
                                        z = false;
                                        if (this.i == baseRequestOptions.i) {
                                            z = false;
                                            if (this.j == baseRequestOptions.j) {
                                                z = false;
                                                if (this.k == baseRequestOptions.k) {
                                                    z = false;
                                                    if (this.m == baseRequestOptions.m) {
                                                        z = false;
                                                        if (this.n == baseRequestOptions.n) {
                                                            z = false;
                                                            if (this.w == baseRequestOptions.w) {
                                                                z = false;
                                                                if (this.x == baseRequestOptions.x) {
                                                                    z = false;
                                                                    if (this.f7434c.equals(baseRequestOptions.f7434c)) {
                                                                        z = false;
                                                                        if (this.d == baseRequestOptions.d) {
                                                                            z = false;
                                                                            if (this.q.equals(baseRequestOptions.q)) {
                                                                                z = false;
                                                                                if (this.r.equals(baseRequestOptions.r)) {
                                                                                    z = false;
                                                                                    if (this.s.equals(baseRequestOptions.s)) {
                                                                                        z = false;
                                                                                        if (Util.a(this.l, baseRequestOptions.l)) {
                                                                                            z = false;
                                                                                            if (Util.a(this.u, baseRequestOptions.u)) {
                                                                                                z = true;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public T f(int i) {
        if (this.v) {
            return (T) clone().f(i);
        }
        this.f = i;
        int i2 = this.f7433a | 32;
        this.f7433a = i2;
        this.e = null;
        this.f7433a = i2 & (-17);
        return a();
    }

    public T f(boolean z) {
        if (this.v) {
            return (T) clone().f(z);
        }
        this.z = z;
        this.f7433a |= 1048576;
        return a();
    }

    public T g(int i) {
        if (this.v) {
            return (T) clone().g(i);
        }
        this.p = i;
        int i2 = this.f7433a | 16384;
        this.f7433a = i2;
        this.o = null;
        this.f7433a = i2 & (-8193);
        return a();
    }

    public T h() {
        if (!this.t || this.v) {
            this.v = true;
            return i();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    public T h(int i) {
        if (this.v) {
            return (T) clone().h(i);
        }
        this.h = i;
        int i2 = this.f7433a | 128;
        this.f7433a = i2;
        this.g = null;
        this.f7433a = i2 & (-65);
        return a();
    }

    public int hashCode() {
        return Util.a(this.u, Util.a(this.l, Util.a(this.s, Util.a(this.r, Util.a(this.q, Util.a(this.d, Util.a(this.f7434c, Util.a(this.x, Util.a(this.w, Util.a(this.n, Util.a(this.m, Util.b(this.k, Util.b(this.j, Util.a(this.i, Util.a(this.o, Util.b(this.p, Util.a(this.g, Util.b(this.h, Util.a(this.e, Util.b(this.f, Util.a(this.b)))))))))))))))))))));
    }

    public T i() {
        this.t = true;
        return b();
    }

    public T j() {
        return c(DownsampleStrategy.d, new CenterInside());
    }

    public T k() {
        return c(DownsampleStrategy.f7342c, new FitCenter());
    }

    public T l() {
        return b(DownsampleStrategy.e, new CenterCrop());
    }

    public T m() {
        return a(DownsampleStrategy.e, new CenterCrop());
    }

    @Override // 
    /* renamed from: n */
    public T clone() {
        try {
            T t = (T) super.clone();
            Options options = new Options();
            t.q = options;
            options.a(this.q);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t.r = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.r);
            t.t = false;
            t.v = false;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final boolean o() {
        return this.n;
    }

    public final boolean p() {
        return a(2048);
    }

    public final Map<Class<?>, Transformation<?>> q() {
        return this.r;
    }

    public final boolean r() {
        return this.m;
    }

    public final Options s() {
        return this.q;
    }

    public final Class<?> t() {
        return this.s;
    }

    public final DiskCacheStrategy u() {
        return this.f7434c;
    }

    public final Drawable v() {
        return this.e;
    }

    public final int w() {
        return this.f;
    }

    public final int x() {
        return this.h;
    }

    public final Drawable y() {
        return this.g;
    }

    public final int z() {
        return this.p;
    }
}
