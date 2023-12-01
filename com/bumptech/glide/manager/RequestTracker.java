package com.bumptech.glide.manager;

import android.util.Log;
import com.alipay.sdk.util.i;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/manager/RequestTracker.class */
public class RequestTracker {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Request> f21021a = Collections.newSetFromMap(new WeakHashMap());
    private final List<Request> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f21022c;

    public void a() {
        this.f21022c = true;
        for (Request request : Util.a(this.f21021a)) {
            if (request.d()) {
                request.c();
                this.b.add(request);
            }
        }
    }

    public void a(Request request) {
        this.f21021a.add(request);
        if (!this.f21022c) {
            request.a();
            return;
        }
        request.b();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.b.add(request);
    }

    public void b() {
        this.f21022c = true;
        for (Request request : Util.a(this.f21021a)) {
            if (request.d() || request.e()) {
                request.b();
                this.b.add(request);
            }
        }
    }

    public boolean b(Request request) {
        if (request == null) {
            return true;
        }
        boolean remove = this.f21021a.remove(request);
        boolean z = true;
        if (!this.b.remove(request)) {
            z = remove;
        }
        if (z) {
            request.b();
        }
        return z;
    }

    public void c() {
        this.f21022c = false;
        for (Request request : Util.a(this.f21021a)) {
            if (!request.e() && !request.d()) {
                request.a();
            }
        }
        this.b.clear();
    }

    public void d() {
        for (Request request : Util.a(this.f21021a)) {
            b(request);
        }
        this.b.clear();
    }

    public void e() {
        for (Request request : Util.a(this.f21021a)) {
            if (!request.e() && !request.f()) {
                request.b();
                if (this.f21022c) {
                    this.b.add(request);
                } else {
                    request.a();
                }
            }
        }
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f21021a.size() + ", isPaused=" + this.f21022c + i.d;
    }
}
