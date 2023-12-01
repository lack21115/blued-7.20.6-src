package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/connection/StreamAllocation.class */
public final class StreamAllocation {
    static final /* synthetic */ boolean d = !StreamAllocation.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public final Address f43879a;
    public final Call b;

    /* renamed from: c  reason: collision with root package name */
    public final EventListener f43880c;
    private RouteSelector.Selection e;
    private Route f;
    private final ConnectionPool g;
    private final Object h;
    private final RouteSelector i;
    private int j;
    private RealConnection k;
    private boolean l;
    private boolean m;
    private boolean n;
    private HttpCodec o;

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/connection/StreamAllocation$StreamAllocationReference.class */
    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f43881a;

        StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.f43881a = obj;
        }
    }

    public StreamAllocation(ConnectionPool connectionPool, Address address, Call call, EventListener eventListener, Object obj) {
        this.g = connectionPool;
        this.f43879a = address;
        this.b = call;
        this.f43880c = eventListener;
        this.i = new RouteSelector(address, i(), call, eventListener);
        this.h = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0066, code lost:
        if (r4.k.f43871a != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.net.Socket a(boolean r5, boolean r6, boolean r7) {
        /*
            r4 = this;
            boolean r0 = okhttp3.internal.connection.StreamAllocation.d
            if (r0 != 0) goto L1b
            r0 = r4
            okhttp3.ConnectionPool r0 = r0.g
            boolean r0 = java.lang.Thread.holdsLock(r0)
            if (r0 == 0) goto L13
            goto L1b
        L13:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r1 = r0
            r1.<init>()
            throw r0
        L1b:
            r0 = 0
            r9 = r0
            r0 = r7
            if (r0 == 0) goto L27
            r0 = r4
            r1 = 0
            r0.o = r1
        L27:
            r0 = r6
            if (r0 == 0) goto L30
            r0 = r4
            r1 = 1
            r0.m = r1
        L30:
            r0 = r4
            okhttp3.internal.connection.RealConnection r0 = r0.k
            r10 = r0
            r0 = r9
            r8 = r0
            r0 = r10
            if (r0 == 0) goto Laf
            r0 = r5
            if (r0 == 0) goto L49
            r0 = r10
            r1 = 1
            r0.f43871a = r1
        L49:
            r0 = r9
            r8 = r0
            r0 = r4
            okhttp3.internal.http.HttpCodec r0 = r0.o
            if (r0 != 0) goto Laf
            r0 = r4
            boolean r0 = r0.m
            if (r0 != 0) goto L69
            r0 = r9
            r8 = r0
            r0 = r4
            okhttp3.internal.connection.RealConnection r0 = r0.k
            boolean r0 = r0.f43871a
            if (r0 == 0) goto Laf
        L69:
            r0 = r4
            r1 = r4
            okhttp3.internal.connection.RealConnection r1 = r1.k
            r0.b(r1)
            r0 = r4
            okhttp3.internal.connection.RealConnection r0 = r0.k
            java.util.List<java.lang.ref.Reference<okhttp3.internal.connection.StreamAllocation>> r0 = r0.d
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto La7
            r0 = r4
            okhttp3.internal.connection.RealConnection r0 = r0.k
            long r1 = java.lang.System.nanoTime()
            r0.e = r1
            okhttp3.internal.Internal r0 = okhttp3.internal.Internal.instance
            r1 = r4
            okhttp3.ConnectionPool r1 = r1.g
            r2 = r4
            okhttp3.internal.connection.RealConnection r2 = r2.k
            boolean r0 = r0.connectionBecameIdle(r1, r2)
            if (r0 == 0) goto La7
            r0 = r4
            okhttp3.internal.connection.RealConnection r0 = r0.k
            java.net.Socket r0 = r0.socket()
            r8 = r0
            goto Laa
        La7:
            r0 = 0
            r8 = r0
        Laa:
            r0 = r4
            r1 = 0
            r0.k = r1
        Laf:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.a(boolean, boolean, boolean):java.net.Socket");
    }

    private RealConnection a(int i, int i2, int i3, int i4, boolean z) throws IOException {
        Socket h;
        RealConnection realConnection;
        RealConnection realConnection2;
        Route route;
        boolean z2;
        boolean z3;
        boolean z4;
        RealConnection realConnection3;
        RealConnection realConnection4;
        Socket socket;
        RouteSelector.Selection selection;
        synchronized (this.g) {
            if (this.m) {
                throw new IllegalStateException("released");
            }
            if (this.o != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.n) {
                throw new IOException("Canceled");
            }
            RealConnection realConnection5 = this.k;
            h = h();
            if (this.k != null) {
                realConnection = this.k;
                realConnection5 = null;
            } else {
                realConnection = null;
            }
            realConnection2 = realConnection5;
            if (!this.l) {
                realConnection2 = null;
            }
            if (realConnection == null) {
                Internal.instance.get(this.g, this.f43879a, this, null);
                if (this.k != null) {
                    realConnection = this.k;
                    route = null;
                    z2 = true;
                } else {
                    route = this.f;
                }
            } else {
                route = null;
            }
            z2 = false;
        }
        Util.a(h);
        if (realConnection2 != null) {
            this.f43880c.connectionReleased(this.b, realConnection2);
        }
        if (z2) {
            this.f43880c.connectionAcquired(this.b, realConnection);
        }
        if (realConnection != null) {
            this.f = this.k.route();
            return realConnection;
        }
        if (route != null || ((selection = this.e) != null && selection.a())) {
            z3 = false;
        } else {
            this.e = this.i.b();
            z3 = true;
        }
        synchronized (this.g) {
            if (this.n) {
                throw new IOException("Canceled");
            }
            RealConnection realConnection6 = realConnection;
            z4 = z2;
            if (z3) {
                List<Route> c2 = this.e.c();
                int size = c2.size();
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    realConnection6 = realConnection;
                    z4 = z2;
                    if (i6 >= size) {
                        break;
                    }
                    Route route2 = c2.get(i6);
                    Internal.instance.get(this.g, this.f43879a, this, route2);
                    if (this.k != null) {
                        realConnection6 = this.k;
                        this.f = route2;
                        z4 = true;
                        break;
                    }
                    i5 = i6 + 1;
                }
            }
            realConnection3 = realConnection6;
            if (!z4) {
                Route route3 = route;
                if (route == null) {
                    route3 = this.e.b();
                }
                this.f = route3;
                this.j = 0;
                realConnection3 = new RealConnection(this.g, route3);
                a(realConnection3, false);
            }
        }
        if (z4) {
            this.f43880c.connectionAcquired(this.b, realConnection3);
            return realConnection3;
        }
        realConnection3.a(i, i2, i3, i4, z, this.b, this.f43880c);
        i().b(realConnection3.route());
        synchronized (this.g) {
            this.l = true;
            Internal.instance.put(this.g, realConnection3);
            realConnection4 = realConnection3;
            socket = null;
            if (realConnection3.b()) {
                socket = Internal.instance.deduplicate(this.g, this.f43879a, this);
                realConnection4 = this.k;
            }
        }
        Util.a(socket);
        this.f43880c.connectionAcquired(this.b, realConnection4);
        return realConnection4;
    }

    private RealConnection a(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            RealConnection a2 = a(i, i2, i3, i4, z);
            synchronized (this.g) {
                if (a2.b == 0 && !a2.b()) {
                    return a2;
                }
                if (a2.a(z2)) {
                    return a2;
                }
                e();
            }
        }
    }

    private void b(RealConnection realConnection) {
        int size = realConnection.d.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                throw new IllegalStateException();
            }
            if (realConnection.d.get(i2).get() == this) {
                realConnection.d.remove(i2);
                return;
            }
            i = i2 + 1;
        }
    }

    private Socket h() {
        if (d || Thread.holdsLock(this.g)) {
            RealConnection realConnection = this.k;
            if (realConnection == null || !realConnection.f43871a) {
                return null;
            }
            return a(false, false, true);
        }
        throw new AssertionError();
    }

    private RouteDatabase i() {
        return Internal.instance.routeDatabase(this.g);
    }

    public Socket a(RealConnection realConnection) {
        if (d || Thread.holdsLock(this.g)) {
            if (this.o == null && this.k.d.size() == 1) {
                Reference<StreamAllocation> reference = this.k.d.get(0);
                Socket a2 = a(true, false, false);
                this.k = realConnection;
                realConnection.d.add(reference);
                return a2;
            }
            throw new IllegalStateException();
        }
        throw new AssertionError();
    }

    public HttpCodec a() {
        HttpCodec httpCodec;
        synchronized (this.g) {
            httpCodec = this.o;
        }
        return httpCodec;
    }

    public HttpCodec a(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        try {
            HttpCodec a2 = a(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).a(okHttpClient, chain, this);
            synchronized (this.g) {
                this.o = a2;
            }
            return a2;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    public void a(IOException iOException) {
        boolean z;
        Socket a2;
        RealConnection realConnection;
        synchronized (this.g) {
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).f43963a;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    int i = this.j + 1;
                    this.j = i;
                    if (i > 1) {
                        this.f = null;
                        z = true;
                    }
                    z = false;
                } else {
                    if (errorCode != ErrorCode.CANCEL) {
                        this.f = null;
                        z = true;
                    }
                    z = false;
                }
            } else {
                if (this.k != null && (!this.k.b() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.k.b == 0) {
                        if (this.f != null && iOException != null) {
                            this.i.a(this.f, iOException);
                        }
                        this.f = null;
                    }
                    z = true;
                }
                z = false;
            }
            RealConnection realConnection2 = this.k;
            a2 = a(z, false, true);
            realConnection = null;
            if (this.k == null) {
                realConnection = !this.l ? null : realConnection2;
            }
        }
        Util.a(a2);
        if (realConnection != null) {
            this.f43880c.connectionReleased(this.b, realConnection);
        }
    }

    public void a(RealConnection realConnection, boolean z) {
        if (!d && !Thread.holdsLock(this.g)) {
            throw new AssertionError();
        }
        if (this.k != null) {
            throw new IllegalStateException();
        }
        this.k = realConnection;
        this.l = z;
        realConnection.d.add(new StreamAllocationReference(this, this.h));
    }

    public void a(boolean z, HttpCodec httpCodec, long j, IOException iOException) {
        RealConnection realConnection;
        Socket a2;
        boolean z2;
        this.f43880c.responseBodyEnd(this.b, j);
        synchronized (this.g) {
            if (httpCodec != null) {
                if (httpCodec == this.o) {
                    if (!z) {
                        this.k.b++;
                    }
                    realConnection = this.k;
                    a2 = a(z, false, true);
                    if (this.k != null) {
                        realConnection = null;
                    }
                    z2 = this.m;
                }
            }
            throw new IllegalStateException("expected " + this.o + " but was " + httpCodec);
        }
        Util.a(a2);
        if (realConnection != null) {
            this.f43880c.connectionReleased(this.b, realConnection);
        }
        if (iOException != null) {
            this.f43880c.callFailed(this.b, Internal.instance.timeoutExit(this.b, iOException));
        } else if (z2) {
            Internal.instance.timeoutExit(this.b, null);
            this.f43880c.callEnd(this.b);
        }
    }

    public Route b() {
        return this.f;
    }

    public RealConnection c() {
        RealConnection realConnection;
        synchronized (this) {
            realConnection = this.k;
        }
        return realConnection;
    }

    public void d() {
        RealConnection realConnection;
        Socket a2;
        synchronized (this.g) {
            realConnection = this.k;
            a2 = a(false, true, false);
            if (this.k != null) {
                realConnection = null;
            }
        }
        Util.a(a2);
        if (realConnection != null) {
            Internal.instance.timeoutExit(this.b, null);
            this.f43880c.connectionReleased(this.b, realConnection);
            this.f43880c.callEnd(this.b);
        }
    }

    public void e() {
        RealConnection realConnection;
        Socket a2;
        synchronized (this.g) {
            realConnection = this.k;
            a2 = a(true, false, false);
            if (this.k != null) {
                realConnection = null;
            }
        }
        Util.a(a2);
        if (realConnection != null) {
            this.f43880c.connectionReleased(this.b, realConnection);
        }
    }

    public void f() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        synchronized (this.g) {
            this.n = true;
            httpCodec = this.o;
            realConnection = this.k;
        }
        if (httpCodec != null) {
            httpCodec.c();
        } else if (realConnection != null) {
            realConnection.a();
        }
    }

    public boolean g() {
        if (this.f == null) {
            RouteSelector.Selection selection = this.e;
            return (selection != null && selection.a()) || this.i.a();
        }
        return true;
    }

    public String toString() {
        RealConnection c2 = c();
        return c2 != null ? c2.toString() : this.f43879a.toString();
    }
}
