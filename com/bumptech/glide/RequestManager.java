package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.alipay.sdk.util.i;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/RequestManager.class */
public class RequestManager implements ComponentCallbacks2, ModelTypes<RequestBuilder<Drawable>>, LifecycleListener {
    private static final RequestOptions d = RequestOptions.c(Bitmap.class).i();
    private static final RequestOptions e = RequestOptions.c(GifDrawable.class).i();
    private static final RequestOptions f = RequestOptions.c(DiskCacheStrategy.f20763c).b(Priority.LOW).d(true);

    /* renamed from: a  reason: collision with root package name */
    protected final Glide f20667a;
    protected final Context b;

    /* renamed from: c  reason: collision with root package name */
    final Lifecycle f20668c;
    private final RequestTracker g;
    private final RequestManagerTreeNode h;
    private final TargetTracker i;
    private final Runnable j;
    private final Handler k;
    private final ConnectivityMonitor l;
    private final CopyOnWriteArrayList<RequestListener<Object>> m;
    private RequestOptions n;
    private boolean o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/RequestManager$ClearTarget.class */
    public static class ClearTarget extends CustomViewTarget<View, Object> {
        ClearTarget(View view) {
            super(view);
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public void a(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object obj, Transition<? super Object> transition) {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/RequestManager$RequestManagerConnectivityListener.class */
    class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {
        private final RequestTracker b;

        RequestManagerConnectivityListener(RequestTracker requestTracker) {
            this.b = requestTracker;
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        public void a(boolean z) {
            if (z) {
                synchronized (RequestManager.this) {
                    this.b.e();
                }
            }
        }
    }

    public RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new RequestTracker(), glide.c(), context);
    }

    RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        this.i = new TargetTracker();
        this.j = new Runnable() { // from class: com.bumptech.glide.RequestManager.1
            @Override // java.lang.Runnable
            public void run() {
                RequestManager.this.f20668c.a(RequestManager.this);
            }
        };
        this.k = new Handler(Looper.getMainLooper());
        this.f20667a = glide;
        this.f20668c = lifecycle;
        this.h = requestManagerTreeNode;
        this.g = requestTracker;
        this.b = context;
        this.l = connectivityMonitorFactory.a(context.getApplicationContext(), new RequestManagerConnectivityListener(requestTracker));
        if (Util.d()) {
            this.k.post(this.j);
        } else {
            lifecycle.a(this);
        }
        lifecycle.a(this.l);
        this.m = new CopyOnWriteArrayList<>(glide.d().a());
        a(glide.d().b());
        glide.a(this);
    }

    private void c(Target<?> target) {
        boolean b = b(target);
        Request request = target.getRequest();
        if (b || this.f20667a.a(target) || request == null) {
            return;
        }
        target.setRequest(null);
        request.b();
    }

    public void a(View view) {
        a(new ClearTarget(view));
    }

    public void a(RequestOptions requestOptions) {
        synchronized (this) {
            this.n = requestOptions.clone().h();
        }
    }

    public void a(Target<?> target) {
        if (target == null) {
            return;
        }
        c(target);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Target<?> target, Request request) {
        synchronized (this) {
            this.i.a(target);
            this.g.a(request);
        }
    }

    public <ResourceType> RequestBuilder<ResourceType> b(Class<ResourceType> cls) {
        return new RequestBuilder<>(this.f20667a, this, cls, this.b);
    }

    public RequestBuilder<Drawable> b(Integer num) {
        return e().b(num);
    }

    public RequestBuilder<Drawable> b(String str) {
        return e().b(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Target<?> target) {
        synchronized (this) {
            Request request = target.getRequest();
            if (request == null) {
                return true;
            }
            if (this.g.b(request)) {
                this.i.b(target);
                target.setRequest(null);
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> TransitionOptions<?, T> c(Class<T> cls) {
        return this.f20667a.d().a(cls);
    }

    public RequestBuilder<File> d() {
        return b(File.class).b(RequestOptions.g(true));
    }

    public RequestBuilder<Drawable> e() {
        return b(Drawable.class);
    }

    public RequestBuilder<Bitmap> f() {
        return b(Bitmap.class).b(d);
    }

    public void g() {
        synchronized (this) {
            this.g.a();
        }
    }

    public void h() {
        synchronized (this) {
            this.g.b();
        }
    }

    public void i() {
        synchronized (this) {
            h();
            for (RequestManager requestManager : this.h.a()) {
                requestManager.h();
            }
        }
    }

    public void j() {
        synchronized (this) {
            this.g.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<RequestListener<Object>> k() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestOptions l() {
        RequestOptions requestOptions;
        synchronized (this) {
            requestOptions = this.n;
        }
        return requestOptions;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        synchronized (this) {
            this.i.onDestroy();
            for (Target<?> target : this.i.a()) {
                a(target);
            }
            this.i.b();
            this.g.d();
            this.f20668c.b(this);
            this.f20668c.b(this.l);
            this.k.removeCallbacks(this.j);
            this.f20667a.b(this);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        synchronized (this) {
            j();
            this.i.onStart();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        synchronized (this) {
            g();
            this.i.onStop();
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 60 && this.o) {
            i();
        }
    }

    public String toString() {
        String str;
        synchronized (this) {
            str = super.toString() + "{tracker=" + this.g + ", treeNode=" + this.h + i.d;
        }
        return str;
    }
}
