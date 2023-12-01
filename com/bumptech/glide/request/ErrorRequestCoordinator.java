package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/ErrorRequestCoordinator.class */
public final class ErrorRequestCoordinator implements Request, RequestCoordinator {

    /* renamed from: a  reason: collision with root package name */
    private final Object f7435a;
    private final RequestCoordinator b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Request f7436c;
    private volatile Request d;
    private RequestCoordinator.RequestState e = RequestCoordinator.RequestState.CLEARED;
    private RequestCoordinator.RequestState f = RequestCoordinator.RequestState.CLEARED;

    public ErrorRequestCoordinator(Object obj, RequestCoordinator requestCoordinator) {
        this.f7435a = obj;
        this.b = requestCoordinator;
    }

    private boolean g(Request request) {
        if (request.equals(this.f7436c)) {
            return true;
        }
        return this.e == RequestCoordinator.RequestState.FAILED && request.equals(this.d);
    }

    private boolean i() {
        RequestCoordinator requestCoordinator = this.b;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    private boolean j() {
        RequestCoordinator requestCoordinator = this.b;
        return requestCoordinator == null || requestCoordinator.d(this);
    }

    private boolean k() {
        RequestCoordinator requestCoordinator = this.b;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @Override // com.bumptech.glide.request.Request
    public void a() {
        synchronized (this.f7435a) {
            if (this.e != RequestCoordinator.RequestState.RUNNING) {
                this.e = RequestCoordinator.RequestState.RUNNING;
                this.f7436c.a();
            }
        }
    }

    public void a(Request request, Request request2) {
        this.f7436c = request;
        this.d = request2;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean a(Request request) {
        boolean z = false;
        if (request instanceof ErrorRequestCoordinator) {
            ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
            z = false;
            if (this.f7436c.a(errorRequestCoordinator.f7436c)) {
                z = false;
                if (this.d.a(errorRequestCoordinator.d)) {
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public void b() {
        synchronized (this.f7435a) {
            this.e = RequestCoordinator.RequestState.CLEARED;
            this.f7436c.b();
            if (this.f != RequestCoordinator.RequestState.CLEARED) {
                this.f = RequestCoordinator.RequestState.CLEARED;
                this.d.b();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean b(Request request) {
        boolean z;
        synchronized (this.f7435a) {
            z = i() && g(request);
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public void c() {
        synchronized (this.f7435a) {
            if (this.e == RequestCoordinator.RequestState.RUNNING) {
                this.e = RequestCoordinator.RequestState.PAUSED;
                this.f7436c.c();
            }
            if (this.f == RequestCoordinator.RequestState.RUNNING) {
                this.f = RequestCoordinator.RequestState.PAUSED;
                this.d.c();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(Request request) {
        boolean z;
        synchronized (this.f7435a) {
            z = k() && g(request);
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean d() {
        boolean z;
        synchronized (this.f7435a) {
            if (this.e != RequestCoordinator.RequestState.RUNNING && this.f != RequestCoordinator.RequestState.RUNNING) {
                z = false;
            }
            z = true;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean d(Request request) {
        boolean z;
        synchronized (this.f7435a) {
            z = j() && g(request);
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void e(Request request) {
        synchronized (this.f7435a) {
            if (request.equals(this.f7436c)) {
                this.e = RequestCoordinator.RequestState.SUCCESS;
            } else if (request.equals(this.d)) {
                this.f = RequestCoordinator.RequestState.SUCCESS;
            }
            if (this.b != null) {
                this.b.e(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean e() {
        boolean z;
        synchronized (this.f7435a) {
            if (this.e != RequestCoordinator.RequestState.SUCCESS && this.f != RequestCoordinator.RequestState.SUCCESS) {
                z = false;
            }
            z = true;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void f(Request request) {
        synchronized (this.f7435a) {
            if (request.equals(this.d)) {
                this.f = RequestCoordinator.RequestState.FAILED;
                if (this.b != null) {
                    this.b.f(this);
                }
                return;
            }
            this.e = RequestCoordinator.RequestState.FAILED;
            if (this.f != RequestCoordinator.RequestState.RUNNING) {
                this.f = RequestCoordinator.RequestState.RUNNING;
                this.d.a();
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean f() {
        boolean z;
        synchronized (this.f7435a) {
            z = this.e == RequestCoordinator.RequestState.CLEARED && this.f == RequestCoordinator.RequestState.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request, com.bumptech.glide.request.RequestCoordinator
    public boolean g() {
        boolean z;
        synchronized (this.f7435a) {
            if (!this.f7436c.g() && !this.d.g()) {
                z = false;
            }
            z = true;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator h() {
        ErrorRequestCoordinator h;
        synchronized (this.f7435a) {
            h = this.b != null ? this.b.h() : this;
        }
        return h;
    }
}
