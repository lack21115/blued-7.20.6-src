package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/connection/RouteDatabase.class */
public final class RouteDatabase {
    private final Set<Route> a = new LinkedHashSet();

    public void a(Route route) {
        synchronized (this) {
            this.a.add(route);
        }
    }

    public void b(Route route) {
        synchronized (this) {
            this.a.remove(route);
        }
    }

    public boolean c(Route route) {
        boolean contains;
        synchronized (this) {
            contains = this.a.contains(route);
        }
        return contains;
    }
}
