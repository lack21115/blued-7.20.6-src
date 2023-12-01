package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.io.RealConnection;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.Sink;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/internal/http/StreamAllocation.class */
public final class StreamAllocation {
    public final Address address;
    private boolean canceled;
    private RealConnection connection;
    private final ConnectionPool connectionPool;
    private boolean released;
    private RouteSelector routeSelector;
    private HttpStream stream;

    public StreamAllocation(ConnectionPool connectionPool, Address address) {
        this.connectionPool = connectionPool;
        this.address = address;
    }

    private void connectionFailed(IOException iOException) {
        synchronized (this.connectionPool) {
            if (this.routeSelector != null) {
                if (this.connection.streamCount == 0) {
                    this.routeSelector.connectFailed(this.connection.getRoute(), iOException);
                } else {
                    this.routeSelector = null;
                }
            }
        }
        connectionFailed();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
        if (r4.connection.noNewStreams != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void deallocate(boolean r5, boolean r6, boolean r7) {
        /*
            r4 = this;
            r0 = r4
            com.squareup.okhttp.ConnectionPool r0 = r0.connectionPool
            r10 = r0
            r0 = r10
            monitor-enter(r0)
            r0 = 0
            r9 = r0
            r0 = r7
            if (r0 == 0) goto L18
            r0 = r4
            r1 = 0
            r0.stream = r1     // Catch: java.lang.Throwable -> Lbe
            goto L18
        L18:
            r0 = r6
            if (r0 == 0) goto L21
            r0 = r4
            r1 = 1
            r0.released = r1     // Catch: java.lang.Throwable -> Lbe
        L21:
            r0 = r9
            r8 = r0
            r0 = r4
            com.squareup.okhttp.internal.io.RealConnection r0 = r0.connection     // Catch: java.lang.Throwable -> Lbe
            if (r0 == 0) goto La7
            r0 = r5
            if (r0 == 0) goto L38
            r0 = r4
            com.squareup.okhttp.internal.io.RealConnection r0 = r0.connection     // Catch: java.lang.Throwable -> Lbe
            r1 = 1
            r0.noNewStreams = r1     // Catch: java.lang.Throwable -> Lbe
        L38:
            r0 = r9
            r8 = r0
            r0 = r4
            com.squareup.okhttp.internal.http.HttpStream r0 = r0.stream     // Catch: java.lang.Throwable -> Lbe
            if (r0 != 0) goto La7
            r0 = r4
            boolean r0 = r0.released     // Catch: java.lang.Throwable -> Lbe
            if (r0 != 0) goto L58
            r0 = r9
            r8 = r0
            r0 = r4
            com.squareup.okhttp.internal.io.RealConnection r0 = r0.connection     // Catch: java.lang.Throwable -> Lbe
            boolean r0 = r0.noNewStreams     // Catch: java.lang.Throwable -> Lbe
            if (r0 == 0) goto La7
        L58:
            r0 = r4
            r1 = r4
            com.squareup.okhttp.internal.io.RealConnection r1 = r1.connection     // Catch: java.lang.Throwable -> Lbe
            r0.release(r1)     // Catch: java.lang.Throwable -> Lbe
            r0 = r4
            com.squareup.okhttp.internal.io.RealConnection r0 = r0.connection     // Catch: java.lang.Throwable -> Lbe
            int r0 = r0.streamCount     // Catch: java.lang.Throwable -> Lbe
            if (r0 <= 0) goto L6f
            r0 = r4
            r1 = 0
            r0.routeSelector = r1     // Catch: java.lang.Throwable -> Lbe
        L6f:
            r0 = r4
            com.squareup.okhttp.internal.io.RealConnection r0 = r0.connection     // Catch: java.lang.Throwable -> Lbe
            java.util.List<java.lang.ref.Reference<com.squareup.okhttp.internal.http.StreamAllocation>> r0 = r0.allocations     // Catch: java.lang.Throwable -> Lbe
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> Lbe
            if (r0 == 0) goto Lc3
            r0 = r4
            com.squareup.okhttp.internal.io.RealConnection r0 = r0.connection     // Catch: java.lang.Throwable -> Lbe
            long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> Lbe
            r0.idleAtNanos = r1     // Catch: java.lang.Throwable -> Lbe
            com.squareup.okhttp.internal.Internal r0 = com.squareup.okhttp.internal.Internal.instance     // Catch: java.lang.Throwable -> Lbe
            r1 = r4
            com.squareup.okhttp.ConnectionPool r1 = r1.connectionPool     // Catch: java.lang.Throwable -> Lbe
            r2 = r4
            com.squareup.okhttp.internal.io.RealConnection r2 = r2.connection     // Catch: java.lang.Throwable -> Lbe
            boolean r0 = r0.connectionBecameIdle(r1, r2)     // Catch: java.lang.Throwable -> Lbe
            if (r0 == 0) goto Lc3
            r0 = r4
            com.squareup.okhttp.internal.io.RealConnection r0 = r0.connection     // Catch: java.lang.Throwable -> Lbe
            r8 = r0
            goto La2
        La2:
            r0 = r4
            r1 = 0
            r0.connection = r1     // Catch: java.lang.Throwable -> Lbe
        La7:
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lbe
            r0 = r8
            if (r0 == 0) goto Lb7
            r0 = r8
            java.net.Socket r0 = r0.getSocket()
            com.squareup.okhttp.internal.Util.closeQuietly(r0)
        Lb7:
            return
        Lb8:
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lbe
            r0 = r8
            throw r0
        Lbe:
            r8 = move-exception
            goto Lb8
        Lc3:
            r0 = 0
            r8 = r0
            goto La2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.http.StreamAllocation.deallocate(boolean, boolean, boolean):void");
    }

    private RealConnection findConnection(int i, int i2, int i3, boolean z) throws IOException, RouteException {
        synchronized (this.connectionPool) {
            if (this.released) {
                throw new IllegalStateException("released");
            }
            if (this.stream == null) {
                if (this.canceled) {
                    throw new IOException("Canceled");
                }
                RealConnection realConnection = this.connection;
                if (realConnection == null || realConnection.noNewStreams) {
                    RealConnection realConnection2 = Internal.instance.get(this.connectionPool, this.address, this);
                    if (realConnection2 != null) {
                        this.connection = realConnection2;
                        return realConnection2;
                    }
                    if (this.routeSelector == null) {
                        this.routeSelector = new RouteSelector(this.address, routeDatabase());
                    }
                    RealConnection realConnection3 = new RealConnection(this.routeSelector.next());
                    acquire(realConnection3);
                    synchronized (this.connectionPool) {
                        Internal.instance.put(this.connectionPool, realConnection3);
                        this.connection = realConnection3;
                        if (this.canceled) {
                            throw new IOException("Canceled");
                        }
                    }
                    realConnection3.connect(i, i2, i3, this.address.getConnectionSpecs(), z);
                    routeDatabase().connected(realConnection3.getRoute());
                    return realConnection3;
                }
                return realConnection;
            }
            throw new IllegalStateException("stream != null");
        }
    }

    private RealConnection findHealthyConnection(int i, int i2, int i3, boolean z, boolean z2) throws IOException, RouteException {
        while (true) {
            RealConnection findConnection = findConnection(i, i2, i3, z);
            synchronized (this.connectionPool) {
                if (findConnection.streamCount == 0) {
                    return findConnection;
                }
                if (findConnection.isHealthy(z2)) {
                    return findConnection;
                }
                connectionFailed();
            }
        }
    }

    private boolean isRecoverable(RouteException routeException) {
        IOException lastConnectException = routeException.getLastConnectException();
        if (lastConnectException instanceof ProtocolException) {
            return false;
        }
        return lastConnectException instanceof InterruptedIOException ? lastConnectException instanceof SocketTimeoutException : (((lastConnectException instanceof SSLHandshakeException) && (lastConnectException.getCause() instanceof CertificateException)) || (lastConnectException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private boolean isRecoverable(IOException iOException) {
        return ((iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) ? false : true;
    }

    private void release(RealConnection realConnection) {
        int size = realConnection.allocations.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                throw new IllegalStateException();
            }
            if (realConnection.allocations.get(i2).get() == this) {
                realConnection.allocations.remove(i2);
                return;
            }
            i = i2 + 1;
        }
    }

    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }

    public void acquire(RealConnection realConnection) {
        realConnection.allocations.add(new WeakReference(this));
    }

    public void cancel() {
        HttpStream httpStream;
        RealConnection realConnection;
        synchronized (this.connectionPool) {
            this.canceled = true;
            httpStream = this.stream;
            realConnection = this.connection;
        }
        if (httpStream != null) {
            httpStream.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public RealConnection connection() {
        RealConnection realConnection;
        synchronized (this) {
            realConnection = this.connection;
        }
        return realConnection;
    }

    public void connectionFailed() {
        deallocate(true, false, true);
    }

    public HttpStream newStream(int i, int i2, int i3, boolean z, boolean z2) throws RouteException, IOException {
        HttpStream http1xStream;
        try {
            RealConnection findHealthyConnection = findHealthyConnection(i, i2, i3, z, z2);
            if (findHealthyConnection.framedConnection != null) {
                http1xStream = new Http2xStream(this, findHealthyConnection.framedConnection);
            } else {
                findHealthyConnection.getSocket().setSoTimeout(i2);
                findHealthyConnection.source.timeout().timeout(i2, TimeUnit.MILLISECONDS);
                findHealthyConnection.sink.timeout().timeout(i3, TimeUnit.MILLISECONDS);
                http1xStream = new Http1xStream(this, findHealthyConnection.source, findHealthyConnection.sink);
            }
            synchronized (this.connectionPool) {
                findHealthyConnection.streamCount++;
                this.stream = http1xStream;
            }
            return http1xStream;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    public void noNewStreams() {
        deallocate(true, false, false);
    }

    public boolean recover(RouteException routeException) {
        if (this.connection != null) {
            connectionFailed(routeException.getLastConnectException());
        }
        RouteSelector routeSelector = this.routeSelector;
        return (routeSelector == null || routeSelector.hasNext()) && isRecoverable(routeException);
    }

    public boolean recover(IOException iOException, Sink sink) {
        RealConnection realConnection = this.connection;
        if (realConnection != null) {
            int i = realConnection.streamCount;
            connectionFailed(iOException);
            if (i == 1) {
                return false;
            }
        }
        boolean z = sink == null || (sink instanceof RetryableSink);
        RouteSelector routeSelector = this.routeSelector;
        return (routeSelector == null || routeSelector.hasNext()) && isRecoverable(iOException) && z;
    }

    public void release() {
        deallocate(false, true, false);
    }

    public HttpStream stream() {
        HttpStream httpStream;
        synchronized (this.connectionPool) {
            httpStream = this.stream;
        }
        return httpStream;
    }

    public void streamFinished(HttpStream httpStream) {
        synchronized (this.connectionPool) {
            if (httpStream != null) {
                if (httpStream == this.stream) {
                }
            }
            throw new IllegalStateException("expected " + this.stream + " but was " + httpStream);
        }
        deallocate(false, false, true);
    }

    public String toString() {
        return this.address.toString();
    }
}
