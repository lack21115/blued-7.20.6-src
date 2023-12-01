package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/connection/RouteDatabase.class */
public final class RouteDatabase {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Route> f43874a = new LinkedHashSet();

    public void a(Route route) {
        synchronized (this) {
            this.f43874a.add(route);
        }
    }

    public void b(Route route) {
        synchronized (this) {
            this.f43874a.remove(route);
        }
    }

    public boolean c(Route route) {
        boolean contains;
        synchronized (this) {
            contains = this.f43874a.contains(route);
        }
        return contains;
    }
}
