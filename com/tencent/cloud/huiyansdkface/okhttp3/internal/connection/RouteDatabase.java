package com.tencent.cloud.huiyansdkface.okhttp3.internal.connection;

import com.tencent.cloud.huiyansdkface.okhttp3.Route;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/connection/RouteDatabase.class */
public final class RouteDatabase {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Route> f35938a = new LinkedHashSet();

    public void connected(Route route) {
        synchronized (this) {
            this.f35938a.remove(route);
        }
    }

    public void failed(Route route) {
        synchronized (this) {
            this.f35938a.add(route);
        }
    }

    public boolean shouldPostpone(Route route) {
        boolean contains;
        synchronized (this) {
            contains = this.f35938a.contains(route);
        }
        return contains;
    }
}
