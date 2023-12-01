package com.tencent.cloud.huiyansdkface.okhttp3.internal.connection;

import com.tencent.cloud.huiyansdkface.okhttp3.Address;
import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.ConnectionPool;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import com.tencent.cloud.huiyansdkface.okhttp3.Route;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RouteSelector;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/connection/StreamAllocation.class */
public final class StreamAllocation {
    static final /* synthetic */ boolean d = !StreamAllocation.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public final Address f22252a;
    public final Call b;

    /* renamed from: c  reason: collision with root package name */
    public final EventListener f22253c;
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

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/connection/StreamAllocation$StreamAllocationReference.class */
    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f22254a;

        StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.f22254a = obj;
        }
    }

    public StreamAllocation(ConnectionPool connectionPool, Address address, Call call, EventListener eventListener, Object obj) {
        this.g = connectionPool;
        this.f22252a = address;
        this.b = call;
        this.f22253c = eventListener;
        this.i = new RouteSelector(address, b(), call, eventListener);
        this.h = obj;
    }

    private RealConnection a(int i, int i2, int i3, int i4, boolean z) throws IOException {
        Socket a2;
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
            a2 = a();
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
                Internal.f22211a.get(this.g, this.f22252a, this, null);
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
        Util.closeQuietly(a2);
        if (realConnection2 != null) {
            this.f22253c.connectionReleased(this.b, realConnection2);
        }
        if (z2) {
            this.f22253c.connectionAcquired(this.b, realConnection);
        }
        if (realConnection != null) {
            return realConnection;
        }
        if (route != null || ((selection = this.e) != null && selection.hasNext())) {
            z3 = false;
        } else {
            this.e = this.i.next();
            z3 = true;
        }
        synchronized (this.g) {
            if (this.n) {
                throw new IOException("Canceled");
            }
            RealConnection realConnection6 = realConnection;
            z4 = z2;
            if (z3) {
                List<Route> all = this.e.getAll();
                int size = all.size();
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    realConnection6 = realConnection;
                    z4 = z2;
                    if (i6 >= size) {
                        break;
                    }
                    Route route2 = all.get(i6);
                    Internal.f22211a.get(this.g, this.f22252a, this, route2);
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
                    route3 = this.e.next();
                }
                this.f = route3;
                this.j = 0;
                realConnection3 = new RealConnection(this.g, route3);
                acquire(realConnection3, false);
            }
        }
        if (!z4) {
            realConnection3.connect(i, i2, i3, i4, z, this.b, this.f22253c);
            b().connected(realConnection3.route());
            synchronized (this.g) {
                this.l = true;
                Internal.f22211a.put(this.g, realConnection3);
                realConnection4 = realConnection3;
                socket = null;
                if (realConnection3.isMultiplexed()) {
                    socket = Internal.f22211a.deduplicate(this.g, this.f22252a, this);
                    realConnection4 = this.k;
                }
            }
            Util.closeQuietly(socket);
            realConnection3 = realConnection4;
        }
        this.f22253c.connectionAcquired(this.b, realConnection3);
        return realConnection3;
    }

    private RealConnection a(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            RealConnection a2 = a(i, i2, i3, i4, z);
            synchronized (this.g) {
                if (a2.b == 0) {
                    return a2;
                }
                if (a2.isHealthy(z2)) {
                    return a2;
                }
                noNewStreams();
            }
        }
    }

    private Socket a() {
        if (d || Thread.holdsLock(this.g)) {
            RealConnection realConnection = this.k;
            if (realConnection == null || !realConnection.f22244a) {
                return null;
            }
            return a(false, false, true);
        }
        throw new AssertionError();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0066, code lost:
        if (r4.k.f22244a != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.net.Socket a(boolean r5, boolean r6, boolean r7) {
        /*
            r4 = this;
            boolean r0 = com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation.d
            if (r0 != 0) goto L1b
            r0 = r4
            com.tencent.cloud.huiyansdkface.okhttp3.ConnectionPool r0 = r0.g
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
            com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection r0 = r0.k
            r10 = r0
            r0 = r9
            r8 = r0
            r0 = r10
            if (r0 == 0) goto Laf
            r0 = r5
            if (r0 == 0) goto L49
            r0 = r10
            r1 = 1
            r0.f22244a = r1
        L49:
            r0 = r9
            r8 = r0
            r0 = r4
            com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec r0 = r0.o
            if (r0 != 0) goto Laf
            r0 = r4
            boolean r0 = r0.m
            if (r0 != 0) goto L69
            r0 = r9
            r8 = r0
            r0 = r4
            com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection r0 = r0.k
            boolean r0 = r0.f22244a
            if (r0 == 0) goto Laf
        L69:
            r0 = r4
            r1 = r4
            com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection r1 = r1.k
            r0.a(r1)
            r0 = r4
            com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection r0 = r0.k
            java.util.List<java.lang.ref.Reference<com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation>> r0 = r0.d
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto La7
            r0 = r4
            com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection r0 = r0.k
            long r1 = java.lang.System.nanoTime()
            r0.e = r1
            com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal r0 = com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal.f22211a
            r1 = r4
            com.tencent.cloud.huiyansdkface.okhttp3.ConnectionPool r1 = r1.g
            r2 = r4
            com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection r2 = r2.k
            boolean r0 = r0.connectionBecameIdle(r1, r2)
            if (r0 == 0) goto La7
            r0 = r4
            com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection r0 = r0.k
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation.a(boolean, boolean, boolean):java.net.Socket");
    }

    private void a(RealConnection realConnection) {
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

    private RouteDatabase b() {
        return Internal.f22211a.routeDatabase(this.g);
    }

    public void acquire(RealConnection realConnection, boolean z) {
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

    public void cancel() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        synchronized (this.g) {
            this.n = true;
            httpCodec = this.o;
            realConnection = this.k;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public HttpCodec codec() {
        HttpCodec httpCodec;
        synchronized (this.g) {
            httpCodec = this.o;
        }
        return httpCodec;
    }

    public RealConnection connection() {
        RealConnection realConnection;
        synchronized (this) {
            realConnection = this.k;
        }
        return realConnection;
    }

    public boolean hasMoreRoutes() {
        if (this.f == null) {
            RouteSelector.Selection selection = this.e;
            return (selection != null && selection.hasNext()) || this.i.hasNext();
        }
        return true;
    }

    public HttpCodec newStream(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        try {
            HttpCodec newCodec = a(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).newCodec(okHttpClient, chain, this);
            synchronized (this.g) {
                this.o = newCodec;
            }
            return newCodec;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    public void noNewStreams() {
        RealConnection realConnection;
        Socket a2;
        synchronized (this.g) {
            realConnection = this.k;
            a2 = a(true, false, false);
            if (this.k != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(a2);
        if (realConnection != null) {
            this.f22253c.connectionReleased(this.b, realConnection);
        }
    }

    public void release() {
        RealConnection realConnection;
        Socket a2;
        synchronized (this.g) {
            realConnection = this.k;
            a2 = a(false, true, false);
            if (this.k != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(a2);
        if (realConnection != null) {
            Internal.f22211a.timeoutExit(this.b, null);
            this.f22253c.connectionReleased(this.b, realConnection);
            this.f22253c.callEnd(this.b);
        }
    }

    public Socket releaseAndAcquire(RealConnection realConnection) {
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

    public Route route() {
        return this.f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
        if (r0 > 1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
        if (r0 != com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ErrorCode.CANCEL) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009c A[Catch: all -> 0x00c2, TryCatch #0 {, blocks: (B:4:0x0009, B:7:0x0015, B:9:0x0024, B:31:0x0083, B:33:0x0095, B:35:0x009c, B:40:0x00ab, B:16:0x0040, B:13:0x0038, B:17:0x0047, B:19:0x004e, B:21:0x0058, B:24:0x0060, B:26:0x0069, B:30:0x0074), top: B:54:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void streamFailed(java.io.IOException r6) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation.streamFailed(java.io.IOException):void");
    }

    public void streamFinished(boolean z, HttpCodec httpCodec, long j, IOException iOException) {
        RealConnection realConnection;
        Socket a2;
        boolean z2;
        this.f22253c.responseBodyEnd(this.b, j);
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
        Util.closeQuietly(a2);
        if (realConnection != null) {
            this.f22253c.connectionReleased(this.b, realConnection);
        }
        if (iOException != null) {
            this.f22253c.callFailed(this.b, Internal.f22211a.timeoutExit(this.b, iOException));
        } else if (z2) {
            Internal.f22211a.timeoutExit(this.b, null);
            this.f22253c.callEnd(this.b);
        }
    }

    public String toString() {
        RealConnection connection = connection();
        return connection != null ? connection.toString() : this.f22252a.toString();
    }
}
