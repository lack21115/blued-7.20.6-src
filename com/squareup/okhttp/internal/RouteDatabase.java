package com.squareup.okhttp.internal;

import com.squareup.okhttp.Route;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/internal/RouteDatabase.class */
public final class RouteDatabase {
    private final Set<Route> failedRoutes = new LinkedHashSet();

    public void connected(Route route) {
        synchronized (this) {
            this.failedRoutes.remove(route);
        }
    }

    public void failed(Route route) {
        synchronized (this) {
            this.failedRoutes.add(route);
        }
    }

    public int failedRoutesCount() {
        int size;
        synchronized (this) {
            size = this.failedRoutes.size();
        }
        return size;
    }

    public boolean shouldPostpone(Route route) {
        boolean contains;
        synchronized (this) {
            contains = this.failedRoutes.contains(route);
        }
        return contains;
    }
}
