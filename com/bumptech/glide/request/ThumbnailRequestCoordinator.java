package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/ThumbnailRequestCoordinator.class */
public class ThumbnailRequestCoordinator implements Request, RequestCoordinator {

    /* renamed from: a  reason: collision with root package name */
    private final RequestCoordinator f7446a;
    private final Object b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Request f7447c;
    private volatile Request d;
    private RequestCoordinator.RequestState e = RequestCoordinator.RequestState.CLEARED;
    private RequestCoordinator.RequestState f = RequestCoordinator.RequestState.CLEARED;
    private boolean g;

    public ThumbnailRequestCoordinator(Object obj, RequestCoordinator requestCoordinator) {
        this.b = obj;
        this.f7446a = requestCoordinator;
    }

    private boolean i() {
        RequestCoordinator requestCoordinator = this.f7446a;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    private boolean j() {
        RequestCoordinator requestCoordinator = this.f7446a;
        return requestCoordinator == null || requestCoordinator.d(this);
    }

    private boolean k() {
        RequestCoordinator requestCoordinator = this.f7446a;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @Override // com.bumptech.glide.request.Request
    public void a() {
        synchronized (this.b) {
            this.g = true;
            if (this.e != RequestCoordinator.RequestState.SUCCESS && this.f != RequestCoordinator.RequestState.RUNNING) {
                this.f = RequestCoordinator.RequestState.RUNNING;
                this.d.a();
            }
            if (this.g && this.e != RequestCoordinator.RequestState.RUNNING) {
                this.e = RequestCoordinator.RequestState.RUNNING;
                this.f7447c.a();
            }
            this.g = false;
        }
    }

    public void a(Request request, Request request2) {
        this.f7447c = request;
        this.d = request2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0036, code lost:
        if (r3.f7447c.a(r0.f7447c) != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
        if (r3.d != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
        if (r0.d != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
        if (r3.d.a(r0.d) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005e, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0021, code lost:
        if (r0.f7447c == null) goto L7;
     */
    @Override // com.bumptech.glide.request.Request
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.bumptech.glide.request.Request r4) {
        /*
            r3 = this;
            r0 = r4
            boolean r0 = r0 instanceof com.bumptech.glide.request.ThumbnailRequestCoordinator
            r7 = r0
            r0 = 0
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r7
            if (r0 == 0) goto L60
            r0 = r4
            com.bumptech.glide.request.ThumbnailRequestCoordinator r0 = (com.bumptech.glide.request.ThumbnailRequestCoordinator) r0
            r4 = r0
            r0 = r3
            com.bumptech.glide.request.Request r0 = r0.f7447c
            if (r0 != 0) goto L27
            r0 = r6
            r5 = r0
            r0 = r4
            com.bumptech.glide.request.Request r0 = r0.f7447c
            if (r0 != 0) goto L60
            goto L39
        L27:
            r0 = r6
            r5 = r0
            r0 = r3
            com.bumptech.glide.request.Request r0 = r0.f7447c
            r1 = r4
            com.bumptech.glide.request.Request r1 = r1.f7447c
            boolean r0 = r0.a(r1)
            if (r0 == 0) goto L60
        L39:
            r0 = r3
            com.bumptech.glide.request.Request r0 = r0.d
            if (r0 != 0) goto L4c
            r0 = r6
            r5 = r0
            r0 = r4
            com.bumptech.glide.request.Request r0 = r0.d
            if (r0 != 0) goto L60
            goto L5e
        L4c:
            r0 = r6
            r5 = r0
            r0 = r3
            com.bumptech.glide.request.Request r0 = r0.d
            r1 = r4
            com.bumptech.glide.request.Request r1 = r1.d
            boolean r0 = r0.a(r1)
            if (r0 == 0) goto L60
        L5e:
            r0 = 1
            r5 = r0
        L60:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.a(com.bumptech.glide.request.Request):boolean");
    }

    @Override // com.bumptech.glide.request.Request
    public void b() {
        synchronized (this.b) {
            this.g = false;
            this.e = RequestCoordinator.RequestState.CLEARED;
            this.f = RequestCoordinator.RequestState.CLEARED;
            this.d.b();
            this.f7447c.b();
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean b(Request request) {
        boolean z;
        synchronized (this.b) {
            if (!i() || (!request.equals(this.f7447c) && this.e == RequestCoordinator.RequestState.SUCCESS)) {
                z = false;
            }
            z = true;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public void c() {
        synchronized (this.b) {
            if (!this.f.a()) {
                this.f = RequestCoordinator.RequestState.PAUSED;
                this.d.c();
            }
            if (!this.e.a()) {
                this.e = RequestCoordinator.RequestState.PAUSED;
                this.f7447c.c();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(Request request) {
        boolean z;
        synchronized (this.b) {
            z = k() && request.equals(this.f7447c) && !g();
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean d() {
        boolean z;
        synchronized (this.b) {
            z = this.e == RequestCoordinator.RequestState.RUNNING;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean d(Request request) {
        boolean z;
        synchronized (this.b) {
            z = j() && request.equals(this.f7447c) && this.e != RequestCoordinator.RequestState.PAUSED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void e(Request request) {
        synchronized (this.b) {
            if (request.equals(this.d)) {
                this.f = RequestCoordinator.RequestState.SUCCESS;
                return;
            }
            this.e = RequestCoordinator.RequestState.SUCCESS;
            if (this.f7446a != null) {
                this.f7446a.e(this);
            }
            if (!this.f.a()) {
                this.d.b();
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean e() {
        boolean z;
        synchronized (this.b) {
            z = this.e == RequestCoordinator.RequestState.SUCCESS;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void f(Request request) {
        synchronized (this.b) {
            if (!request.equals(this.f7447c)) {
                this.f = RequestCoordinator.RequestState.FAILED;
                return;
            }
            this.e = RequestCoordinator.RequestState.FAILED;
            if (this.f7446a != null) {
                this.f7446a.f(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean f() {
        boolean z;
        synchronized (this.b) {
            z = this.e == RequestCoordinator.RequestState.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request, com.bumptech.glide.request.RequestCoordinator
    public boolean g() {
        boolean z;
        synchronized (this.b) {
            if (!this.d.g() && !this.f7447c.g()) {
                z = false;
            }
            z = true;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator h() {
        ThumbnailRequestCoordinator h;
        synchronized (this.b) {
            h = this.f7446a != null ? this.f7446a.h() : this;
        }
        return h;
    }
}
