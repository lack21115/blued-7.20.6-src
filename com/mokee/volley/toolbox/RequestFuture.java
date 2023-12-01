package com.mokee.volley.toolbox;

import com.mokee.volley.Request;
import com.mokee.volley.Response;
import com.mokee.volley.VolleyError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/RequestFuture.class */
public class RequestFuture<T> implements Future<T>, Response.Listener<T>, Response.ErrorListener {

    /* renamed from: a  reason: collision with root package name */
    private VolleyError f24270a;
    private T b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24271c = false;
    private Request<?> d;

    private RequestFuture() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x003e, code lost:
        if (com.mokee.volley.toolbox.ImageLoader.h != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private T a(java.lang.Long r6) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        /*
            r5 = this;
            r0 = r5
            monitor-enter(r0)
            r0 = r5
            com.mokee.volley.VolleyError r0 = r0.f24270a     // Catch: java.lang.InterruptedException -> L15 java.lang.Throwable -> L18
            if (r0 == 0) goto L1d
            java.util.concurrent.ExecutionException r0 = new java.util.concurrent.ExecutionException     // Catch: java.lang.InterruptedException -> L15 java.lang.Throwable -> L18
            r1 = r0
            r2 = r5
            com.mokee.volley.VolleyError r2 = r2.f24270a     // Catch: java.lang.InterruptedException -> L15 java.lang.Throwable -> L18
            r1.<init>(r2)     // Catch: java.lang.InterruptedException -> L15 java.lang.Throwable -> L18
            throw r0     // Catch: java.lang.InterruptedException -> L15 java.lang.Throwable -> L18
        L15:
            r6 = move-exception
            r0 = r6
            throw r0     // Catch: java.lang.Throwable -> L18
        L18:
            r6 = move-exception
            r0 = r5
            monitor-exit(r0)
            r0 = r6
            throw r0
        L1d:
            r0 = r5
            boolean r0 = r0.f24271c     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L2d
            if (r0 == 0) goto L30
            r0 = r5
            T r0 = r0.b     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L2d
            r6 = r0
        L29:
            r0 = r5
            monitor-exit(r0)
            r0 = r6
            return r0
        L2d:
            r6 = move-exception
            r0 = r6
            throw r0     // Catch: java.lang.Throwable -> L18
        L30:
            r0 = r6
            if (r0 != 0) goto L41
            r0 = r5
            r1 = 0
            r0.wait(r1)     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L6a
            boolean r0 = com.mokee.volley.toolbox.ImageLoader.h     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L6a
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L54
        L41:
            r0 = r6
            long r0 = r0.longValue()     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L6d
            r8 = r0
            r0 = r8
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L54
            r0 = r5
            r1 = r6
            long r1 = r1.longValue()     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L70
            r0.wait(r1)     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L70
        L54:
            r0 = r5
            com.mokee.volley.VolleyError r0 = r0.f24270a     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L67
            if (r0 == 0) goto L73
            java.util.concurrent.ExecutionException r0 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L67
            r1 = r0
            r2 = r5
            com.mokee.volley.VolleyError r2 = r2.f24270a     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L67
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L67
            throw r0     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L67
        L67:
            r6 = move-exception
            r0 = r6
            throw r0     // Catch: java.lang.Throwable -> L18
        L6a:
            r6 = move-exception
            r0 = r6
            throw r0     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L6d
        L6d:
            r6 = move-exception
            r0 = r6
            throw r0     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L70
        L70:
            r6 = move-exception
            r0 = r6
            throw r0     // Catch: java.lang.Throwable -> L18
        L73:
            r0 = r5
            boolean r0 = r0.f24271c     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L82
            if (r0 != 0) goto L85
            java.util.concurrent.TimeoutException r0 = new java.util.concurrent.TimeoutException     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L82
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L82
            throw r0     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L82
        L82:
            r6 = move-exception
            r0 = r6
            throw r0     // Catch: java.lang.Throwable -> L18
        L85:
            r0 = r5
            T r0 = r0.b     // Catch: java.lang.Throwable -> L18
            r6 = r0
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.toolbox.RequestFuture.a(java.lang.Long):java.lang.Object");
    }

    public static <E> RequestFuture<E> newFuture() {
        return new RequestFuture<>();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (this.d != null && !isDone()) {
                this.d.cancel();
                z2 = true;
            }
        }
        return z2;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        try {
            return a(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        if (this.d == null) {
            return false;
        }
        return this.d.isCanceled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean z;
        synchronized (this) {
            if (!this.f24271c && this.f24270a == null) {
                if (!isCancelled()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @Override // com.mokee.volley.Response.ErrorListener
    public void onErrorResponse(VolleyError volleyError) {
        synchronized (this) {
            this.f24270a = volleyError;
            notifyAll();
        }
    }

    @Override // com.mokee.volley.Response.Listener
    public void onResponse(T t) {
        synchronized (this) {
            this.f24271c = true;
            this.b = t;
            notifyAll();
        }
    }

    public void setRequest(Request<?> request) {
        this.d = request;
    }
}
