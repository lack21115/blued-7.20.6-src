package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/RequestFutureTarget.class */
public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {

    /* renamed from: a  reason: collision with root package name */
    private static final Waiter f7439a = new Waiter();
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7440c;
    private final boolean d;
    private final Waiter e;
    private R f;
    private Request g;
    private boolean h;
    private boolean i;
    private boolean j;
    private GlideException k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/RequestFutureTarget$Waiter.class */
    public static class Waiter {
        Waiter() {
        }

        void a(Object obj) {
            obj.notifyAll();
        }

        void a(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }
    }

    public RequestFutureTarget(int i, int i2) {
        this(i, i2, true, f7439a);
    }

    RequestFutureTarget(int i, int i2, boolean z, Waiter waiter) {
        this.b = i;
        this.f7440c = i2;
        this.d = z;
        this.e = waiter;
    }

    private R a(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        synchronized (this) {
            if (this.d && !isDone()) {
                Util.b();
            }
            if (this.h) {
                throw new CancellationException();
            }
            if (this.j) {
                throw new ExecutionException(this.k);
            }
            if (this.i) {
                return this.f;
            }
            if (l == null) {
                this.e.a(this, 0L);
            } else if (l.longValue() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long longValue = l.longValue() + currentTimeMillis;
                while (!isDone() && currentTimeMillis < longValue) {
                    this.e.a(this, longValue - currentTimeMillis);
                    currentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.j) {
                throw new ExecutionException(this.k);
            }
            if (this.h) {
                throw new CancellationException();
            }
            if (this.i) {
                return this.f;
            }
            throw new TimeoutException();
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.h = true;
            this.e.a(this);
            Request request = null;
            if (z) {
                request = this.g;
                this.g = null;
            }
            if (request != null) {
                request.b();
                return true;
            }
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return a(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public R get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j)));
    }

    @Override // com.bumptech.glide.request.target.Target
    public Request getRequest() {
        Request request;
        synchronized (this) {
            request = this.g;
        }
        return request;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.a(this.b, this.f7440c);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        boolean z;
        synchronized (this) {
            z = this.h;
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean z;
        synchronized (this) {
            if (!this.h && !this.i) {
                if (!this.j) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
        synchronized (this) {
        }
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(GlideException glideException, Object obj, Target<R> target, boolean z) {
        synchronized (this) {
            this.j = true;
            this.k = glideException;
            this.e.a(this);
        }
        return false;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(R r, Transition<? super R> transition) {
        synchronized (this) {
        }
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onResourceReady(R r, Object obj, Target<R> target, DataSource dataSource, boolean z) {
        synchronized (this) {
            this.i = true;
            this.f = r;
            this.e.a(this);
        }
        return false;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(SizeReadyCallback sizeReadyCallback) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void setRequest(Request request) {
        synchronized (this) {
            this.g = request;
        }
    }
}
