package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.internal.Util;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/connection/RouteException.class */
public final class RouteException extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private IOException f43875a;
    private IOException b;

    public RouteException(IOException iOException) {
        super(iOException);
        this.f43875a = iOException;
        this.b = iOException;
    }

    public IOException a() {
        return this.f43875a;
    }

    public void a(IOException iOException) {
        Util.a((Throwable) this.f43875a, (Throwable) iOException);
        this.b = iOException;
    }

    public IOException b() {
        return this.b;
    }
}
