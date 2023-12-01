package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/SingleRequest.class */
public final class SingleRequest<R> implements Request, ResourceCallback, SizeReadyCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f7442a = Log.isLoggable("Request", 2);
    private int A;
    private int B;
    private boolean C;
    private RuntimeException D;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final StateVerifier f7443c;
    private final Object d;
    private final RequestListener<R> e;
    private final RequestCoordinator f;
    private final Context g;
    private final GlideContext h;
    private final Object i;
    private final Class<R> j;
    private final BaseRequestOptions<?> k;
    private final int l;
    private final int m;
    private final Priority n;
    private final Target<R> o;
    private final List<RequestListener<R>> p;
    private final TransitionFactory<? super R> q;
    private final Executor r;
    private Resource<R> s;
    private Engine.LoadStatus t;
    private long u;
    private volatile Engine v;
    private Status w;
    private Drawable x;
    private Drawable y;
    private Drawable z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/SingleRequest$Status.class */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private SingleRequest(Context context, GlideContext glideContext, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        this.b = f7442a ? String.valueOf(super.hashCode()) : null;
        this.f7443c = StateVerifier.a();
        this.d = obj;
        this.g = context;
        this.h = glideContext;
        this.i = obj2;
        this.j = cls;
        this.k = baseRequestOptions;
        this.l = i;
        this.m = i2;
        this.n = priority;
        this.o = target;
        this.e = requestListener;
        this.p = list;
        this.f = requestCoordinator;
        this.v = engine;
        this.q = transitionFactory;
        this.r = executor;
        this.w = Status.PENDING;
        if (this.D == null && glideContext.g()) {
            this.D = new RuntimeException("Glide request origin trace");
        }
    }

    private static int a(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * i);
    }

    private Drawable a(int i) {
        return DrawableDecoderCompat.a(this.h, i, this.k.B() != null ? this.k.B() : this.g.getTheme());
    }

    public static <R> SingleRequest<R> a(Context context, GlideContext glideContext, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        return new SingleRequest<>(context, glideContext, obj, obj2, cls, baseRequestOptions, i, i2, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
    }

    private void a(GlideException glideException, int i) {
        boolean z;
        this.f7443c.b();
        synchronized (this.d) {
            glideException.a(this.D);
            int e = this.h.e();
            if (e <= i) {
                Log.w("Glide", "Load failed for " + this.i + " with size [" + this.A + "x" + this.B + "]", glideException);
                if (e <= 4) {
                    glideException.a("Glide");
                }
            }
            this.t = null;
            this.w = Status.FAILED;
            this.C = true;
            if (this.p != null) {
                Iterator<RequestListener<R>> it = this.p.iterator();
                boolean z2 = false;
                while (true) {
                    z = z2;
                    if (!it.hasNext()) {
                        break;
                    }
                    z2 |= it.next().onLoadFailed(glideException, this.i, this.o, r());
                }
            } else {
                z = false;
            }
            if (!(z | (this.e != null && this.e.onLoadFailed(glideException, this.i, this.o, r())))) {
                n();
            }
            this.C = false;
            t();
        }
    }

    private void a(Resource<R> resource, R r, DataSource dataSource) {
        boolean z;
        boolean r2 = r();
        this.w = Status.COMPLETE;
        this.s = resource;
        if (this.h.e() <= 3) {
            Log.d("Glide", "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.i + " with size [" + this.A + "x" + this.B + "] in " + LogTime.a(this.u) + " ms");
        }
        this.C = true;
        try {
            if (this.p != null) {
                Iterator<RequestListener<R>> it = this.p.iterator();
                boolean z2 = false;
                while (true) {
                    z = z2;
                    if (!it.hasNext()) {
                        break;
                    }
                    z2 |= it.next().onResourceReady(r, this.i, this.o, dataSource, r2);
                }
            } else {
                z = false;
            }
            if (!((this.e != null && this.e.onResourceReady(r, this.i, this.o, dataSource, r2)) | z)) {
                this.o.onResourceReady(r, this.q.a(dataSource, r2));
            }
            this.C = false;
            s();
        } catch (Throwable th) {
            this.C = false;
            throw th;
        }
    }

    private void a(String str) {
        Log.v("Request", str + " this: " + this.b);
    }

    private void i() {
        j();
        this.f7443c.b();
        this.o.removeCallback(this);
        Engine.LoadStatus loadStatus = this.t;
        if (loadStatus != null) {
            loadStatus.a();
            this.t = null;
        }
    }

    private void j() {
        if (this.C) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private Drawable k() {
        if (this.x == null) {
            Drawable v = this.k.v();
            this.x = v;
            if (v == null && this.k.w() > 0) {
                this.x = a(this.k.w());
            }
        }
        return this.x;
    }

    private Drawable l() {
        if (this.y == null) {
            Drawable y = this.k.y();
            this.y = y;
            if (y == null && this.k.x() > 0) {
                this.y = a(this.k.x());
            }
        }
        return this.y;
    }

    private Drawable m() {
        if (this.z == null) {
            Drawable A = this.k.A();
            this.z = A;
            if (A == null && this.k.z() > 0) {
                this.z = a(this.k.z());
            }
        }
        return this.z;
    }

    private void n() {
        if (q()) {
            Drawable drawable = null;
            if (this.i == null) {
                drawable = m();
            }
            Drawable drawable2 = drawable;
            if (drawable == null) {
                drawable2 = k();
            }
            Drawable drawable3 = drawable2;
            if (drawable2 == null) {
                drawable3 = l();
            }
            this.o.onLoadFailed(drawable3);
        }
    }

    private boolean o() {
        RequestCoordinator requestCoordinator = this.f;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    private boolean p() {
        RequestCoordinator requestCoordinator = this.f;
        return requestCoordinator == null || requestCoordinator.d(this);
    }

    private boolean q() {
        RequestCoordinator requestCoordinator = this.f;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    private boolean r() {
        RequestCoordinator requestCoordinator = this.f;
        return requestCoordinator == null || !requestCoordinator.h().g();
    }

    private void s() {
        RequestCoordinator requestCoordinator = this.f;
        if (requestCoordinator != null) {
            requestCoordinator.e(this);
        }
    }

    private void t() {
        RequestCoordinator requestCoordinator = this.f;
        if (requestCoordinator != null) {
            requestCoordinator.f(this);
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void a() {
        synchronized (this.d) {
            j();
            this.f7443c.b();
            this.u = LogTime.a();
            if (this.i == null) {
                if (Util.a(this.l, this.m)) {
                    this.A = this.l;
                    this.B = this.m;
                }
                a(new GlideException("Received null model"), m() == null ? 5 : 3);
            } else if (this.w == Status.RUNNING) {
                throw new IllegalArgumentException("Cannot restart a running request");
            } else {
                if (this.w == Status.COMPLETE) {
                    a((Resource<?>) this.s, DataSource.MEMORY_CACHE);
                    return;
                }
                this.w = Status.WAITING_FOR_SIZE;
                if (Util.a(this.l, this.m)) {
                    a(this.l, this.m);
                } else {
                    this.o.getSize(this);
                }
                if ((this.w == Status.RUNNING || this.w == Status.WAITING_FOR_SIZE) && q()) {
                    this.o.onLoadStarted(l());
                }
                if (f7442a) {
                    a("finished run method in " + LogTime.a(this.u));
                }
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 33, insn: 0x01cd: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r33 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:52:0x01cd */
    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void a(int i, int i2) {
        Object obj;
        this.f7443c.b();
        Object obj2 = this.d;
        synchronized (obj2) {
            try {
                try {
                    if (f7442a) {
                        a("Got onSizeReady in " + LogTime.a(this.u));
                    }
                    if (this.w != Status.WAITING_FOR_SIZE) {
                        return;
                    }
                    this.w = Status.RUNNING;
                    float J = this.k.J();
                    this.A = a(i, J);
                    this.B = a(i2, J);
                    if (f7442a) {
                        a("finished setup for calling load in " + LogTime.a(this.u));
                    }
                    try {
                        this.t = this.v.a(this.h, this.i, this.k.D(), this.A, this.B, this.k.t(), this.j, this.n, this.k.u(), this.k.q(), this.k.r(), this.k.K(), this.k.s(), this.k.C(), this.k.L(), this.k.M(), this.k.N(), this, this.r);
                        if (this.w != Status.RUNNING) {
                            this.t = null;
                        }
                        if (f7442a) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("finished onSizeReady in ");
                            sb.append(LogTime.a(this.u));
                            a(sb.toString());
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                obj2 = obj;
            }
        }
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public void a(GlideException glideException) {
        a(glideException, 5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bb, code lost:
        if (r6 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00be, code lost:
        r5.v.a(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c6, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x016b, code lost:
        if (r6 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x016e, code lost:
        r5.v.a(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0176, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:?, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.ResourceCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.bumptech.glide.load.engine.Resource<?> r6, com.bumptech.glide.load.DataSource r7) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.a(com.bumptech.glide.load.engine.Resource, com.bumptech.glide.load.DataSource):void");
    }

    @Override // com.bumptech.glide.request.Request
    public boolean a(Request request) {
        int i;
        int i2;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        Priority priority;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        Priority priority2;
        int size2;
        if (request instanceof SingleRequest) {
            synchronized (this.d) {
                i = this.l;
                i2 = this.m;
                obj = this.i;
                cls = this.j;
                baseRequestOptions = this.k;
                priority = this.n;
                size = this.p != null ? this.p.size() : 0;
            }
            SingleRequest singleRequest = (SingleRequest) request;
            synchronized (singleRequest.d) {
                i3 = singleRequest.l;
                i4 = singleRequest.m;
                obj2 = singleRequest.i;
                cls2 = singleRequest.j;
                baseRequestOptions2 = singleRequest.k;
                priority2 = singleRequest.n;
                size2 = singleRequest.p != null ? singleRequest.p.size() : 0;
            }
            return i == i3 && i2 == i4 && Util.b(obj, obj2) && cls.equals(cls2) && baseRequestOptions.equals(baseRequestOptions2) && priority == priority2 && size == size2;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.Request
    public void b() {
        synchronized (this.d) {
            j();
            this.f7443c.b();
            if (this.w == Status.CLEARED) {
                return;
            }
            i();
            Resource resource = null;
            if (this.s != null) {
                resource = (Resource<R>) this.s;
                this.s = null;
            }
            if (p()) {
                this.o.onLoadCleared(l());
            }
            this.w = Status.CLEARED;
            if (resource != null) {
                this.v.a(resource);
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void c() {
        synchronized (this.d) {
            if (d()) {
                b();
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean d() {
        boolean z;
        synchronized (this.d) {
            if (this.w != Status.RUNNING && this.w != Status.WAITING_FOR_SIZE) {
                z = false;
            }
            z = true;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean e() {
        boolean z;
        synchronized (this.d) {
            z = this.w == Status.COMPLETE;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean f() {
        boolean z;
        synchronized (this.d) {
            z = this.w == Status.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request, com.bumptech.glide.request.RequestCoordinator
    public boolean g() {
        boolean z;
        synchronized (this.d) {
            z = this.w == Status.COMPLETE;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public Object h() {
        this.f7443c.b();
        return this.d;
    }
}
