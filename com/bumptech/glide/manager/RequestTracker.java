package com.bumptech.glide.manager;

import android.util.Log;
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
    private final Set<Request> f7415a = Collections.newSetFromMap(new WeakHashMap());
    private final List<Request> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f7416c;

    public void a() {
        this.f7416c = true;
        for (Request request : Util.a(this.f7415a)) {
            if (request.d()) {
                request.c();
                this.b.add(request);
            }
        }
    }

    public void a(Request request) {
        this.f7415a.add(request);
        if (!this.f7416c) {
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
        this.f7416c = true;
        for (Request request : Util.a(this.f7415a)) {
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
        boolean remove = this.f7415a.remove(request);
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
        this.f7416c = false;
        for (Request request : Util.a(this.f7415a)) {
            if (!request.e() && !request.d()) {
                request.a();
            }
        }
        this.b.clear();
    }

    public void d() {
        for (Request request : Util.a(this.f7415a)) {
            b(request);
        }
        this.b.clear();
    }

    public void e() {
        for (Request request : Util.a(this.f7415a)) {
            if (!request.e() && !request.f()) {
                request.b();
                if (this.f7416c) {
                    this.b.add(request);
                } else {
                    request.a();
                }
            }
        }
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f7415a.size() + ", isPaused=" + this.f7416c + "}";
    }
}
