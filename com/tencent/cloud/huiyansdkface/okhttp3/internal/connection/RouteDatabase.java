package com.tencent.cloud.huiyansdkface.okhttp3.internal.connection;

import com.tencent.cloud.huiyansdkface.okhttp3.Route;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/connection/RouteDatabase.class */
public final class RouteDatabase {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Route> f22247a = new LinkedHashSet();

    public void connected(Route route) {
        synchronized (this) {
            this.f22247a.remove(route);
        }
    }

    public void failed(Route route) {
        synchronized (this) {
            this.f22247a.add(route);
        }
    }

    public boolean shouldPostpone(Route route) {
        boolean contains;
        synchronized (this) {
            contains = this.f22247a.contains(route);
        }
        return contains;
    }
}
