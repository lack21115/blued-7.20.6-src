package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RouteDatabase;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/ConnectionPool.class */
public final class ConnectionPool {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ boolean f35834c = !ConnectionPool.class.desiredAssertionStatus();
    private static final Executor d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));

    /* renamed from: a  reason: collision with root package name */
    final RouteDatabase f35835a;
    boolean b;
    private final int e;
    private final long f;
    private final Runnable g;
    private final Deque<RealConnection> h;

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public ConnectionPool(int i, long j, TimeUnit timeUnit) {
        this.g = new Runnable() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.ConnectionPool.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long a2 = ConnectionPool.this.a(System.nanoTime());
                    if (a2 == -1) {
                        return;
                    }
                    if (a2 > 0) {
                        long j2 = a2 / 1000000;
                        synchronized (ConnectionPool.this) {
                            try {
                                ConnectionPool.this.wait(j2, (int) (a2 - (1000000 * j2)));
                            } catch (InterruptedException e) {
                            }
                        }
                    }
                }
            }
        };
        this.h = new ArrayDeque();
        this.f35835a = new RouteDatabase();
        this.e = i;
        this.f = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    private int a(RealConnection realConnection, long j) {
        List<Reference<StreamAllocation>> list = realConnection.d;
        int i = 0;
        while (i < list.size()) {
            Reference<StreamAllocation> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                Platform.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((StreamAllocation.StreamAllocationReference) reference).f35945a);
                list.remove(i);
                realConnection.f35935a = true;
                if (list.isEmpty()) {
                    realConnection.e = j - this.f;
                    return 0;
                }
            }
        }
        return list.size();
    }

    long a(long j) {
        synchronized (this) {
            RealConnection realConnection = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (RealConnection realConnection2 : this.h) {
                if (a(realConnection2, j) > 0) {
                    i2++;
                } else {
                    int i3 = i + 1;
                    long j3 = j - realConnection2.e;
                    i = i3;
                    if (j3 > j2) {
                        realConnection = realConnection2;
                        j2 = j3;
                        i = i3;
                    }
                }
            }
            if (j2 < this.f && i <= this.e) {
                if (i > 0) {
                    return this.f - j2;
                } else if (i2 > 0) {
                    return this.f;
                } else {
                    this.b = false;
                    return -1L;
                }
            }
            this.h.remove(realConnection);
            Util.closeQuietly(realConnection.socket());
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RealConnection a(Address address, StreamAllocation streamAllocation, Route route) {
        if (f35834c || Thread.holdsLock(this)) {
            for (RealConnection realConnection : this.h) {
                if (realConnection.isEligible(address, route)) {
                    streamAllocation.acquire(realConnection, true);
                    return realConnection;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Socket a(Address address, StreamAllocation streamAllocation) {
        if (f35834c || Thread.holdsLock(this)) {
            for (RealConnection realConnection : this.h) {
                if (realConnection.isEligible(address, null) && realConnection.isMultiplexed() && realConnection != streamAllocation.connection()) {
                    return streamAllocation.releaseAndAcquire(realConnection);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RealConnection realConnection) {
        if (!f35834c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.b) {
            this.b = true;
            d.execute(this.g);
        }
        this.h.add(realConnection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(RealConnection realConnection) {
        if (f35834c || Thread.holdsLock(this)) {
            if (realConnection.f35935a || this.e == 0) {
                this.h.remove(realConnection);
                return true;
            }
            notifyAll();
            return false;
        }
        throw new AssertionError();
    }

    public int connectionCount() {
        int size;
        synchronized (this) {
            size = this.h.size();
        }
        return size;
    }

    public void evictAll() {
        ArrayList<RealConnection> arrayList = new ArrayList();
        synchronized (this) {
            Iterator<RealConnection> it = this.h.iterator();
            while (it.hasNext()) {
                RealConnection next = it.next();
                if (next.d.isEmpty()) {
                    next.f35935a = true;
                    arrayList.add(next);
                    it.remove();
                }
            }
        }
        for (RealConnection realConnection : arrayList) {
            Util.closeQuietly(realConnection.socket());
        }
    }

    public int idleConnectionCount() {
        int i;
        synchronized (this) {
            i = 0;
            for (RealConnection realConnection : this.h) {
                if (realConnection.d.isEmpty()) {
                    i++;
                }
            }
        }
        return i;
    }
}
