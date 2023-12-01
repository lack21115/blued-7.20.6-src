package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.internal.Util;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/connection/RouteException.class */
public final class RouteException extends RuntimeException {
    private IOException a;
    private IOException b;

    public RouteException(IOException iOException) {
        super(iOException);
        this.a = iOException;
        this.b = iOException;
    }

    public IOException a() {
        return this.a;
    }

    public void a(IOException iOException) {
        Util.a((Throwable) this.a, (Throwable) iOException);
        this.b = iOException;
    }

    public IOException b() {
        return this.b;
    }
}
