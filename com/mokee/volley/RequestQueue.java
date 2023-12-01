package com.mokee.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/RequestQueue.class */
public class RequestQueue {
    private static final String[] k = null;
    private CacheDispatcher a;
    private final Cache b;
    private final Map<String, Queue<Request<?>>> c;
    private final Network d;
    private NetworkDispatcher[] e;
    private AtomicInteger f;
    private final ResponseDelivery g;
    private final PriorityBlockingQueue<Request<?>> h;
    private final Set<Request<?>> i;
    private final PriorityBlockingQueue<Request<?>> j;

    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/RequestQueue$RequestFilter.class */
    public interface RequestFilter {
        boolean apply(Request<?> request);
    }

    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/RequestQueue$a.class */
    class a implements RequestFilter {
        private final /* synthetic */ Object val$tag;

        a(Object obj) {
            this.val$tag = obj;
        }

        @Override // com.mokee.volley.RequestQueue.RequestFilter
        public boolean apply(Request<?> request) {
            return request.getTag() == this.val$tag;
        }
    }

    static {
        String[] strArr = new String[4];
        throw new VerifyError("bad dex opcode");
    }

    public RequestQueue(Cache cache, Network network) {
        this(cache, network, 4);
    }

    public RequestQueue(Cache cache, Network network, int i) {
        this(cache, network, i, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    public RequestQueue(Cache cache, Network network, int i, ResponseDelivery responseDelivery) {
        boolean z = Request.e;
        this.f = new AtomicInteger();
        this.c = new HashMap();
        this.i = new HashSet();
        this.j = new PriorityBlockingQueue<>();
        this.h = new PriorityBlockingQueue<>();
        this.b = cache;
        this.d = network;
        this.e = new NetworkDispatcher[i];
        this.g = responseDelivery;
        if (VolleyError.b) {
            Request.e = !z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Request<?> request) {
        synchronized (this.i) {
            this.i.remove(request);
        }
        if (request.shouldCache()) {
            synchronized (this.c) {
                String cacheKey = request.getCacheKey();
                Queue<Request<?>> remove = this.c.remove(cacheKey);
                if (remove != null) {
                    if (VolleyLog.DEBUG) {
                        VolleyLog.v(k[1], Integer.valueOf(remove.size()), cacheKey);
                    }
                    this.j.addAll(remove);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00af, code lost:
        if (com.mokee.volley.Request.e != false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> com.mokee.volley.Request<T> add(com.mokee.volley.Request<T> r7) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.RequestQueue.add(com.mokee.volley.Request):com.mokee.volley.Request");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:
        if (r0.hasNext() != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (r0 != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
        r0 = r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:
        if (r4.apply(r0) == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0031, code lost:
        r0.cancel();
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003d -> B:6:0x001a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void cancelAll(com.mokee.volley.RequestQueue.RequestFilter r4) {
        /*
            r3 = this;
            boolean r0 = com.mokee.volley.Request.e
            r5 = r0
            r0 = r3
            java.util.Set<com.mokee.volley.Request<?>> r0 = r0.i
            r6 = r0
            r0 = r6
            monitor-enter(r0)
            r0 = r3
            java.util.Set<com.mokee.volley.Request<?>> r0 = r0.i     // Catch: java.lang.Throwable -> L43
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L43
            r7 = r0
            r0 = r5
            if (r0 == 0) goto L36
        L1a:
            r0 = r7
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L43
            com.mokee.volley.Request r0 = (com.mokee.volley.Request) r0     // Catch: java.lang.Throwable -> L43
            r8 = r0
            r0 = r4
            r1 = r8
            boolean r0 = r0.apply(r1)     // Catch: java.lang.Throwable -> L43
            if (r0 == 0) goto L36
            r0 = r8
            r0.cancel()     // Catch: java.lang.Throwable -> L43
        L36:
            r0 = r7
            boolean r0 = r0.hasNext()     // Catch: java.lang.Throwable -> L43
            if (r0 != 0) goto L1a
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L43
            return
        L43:
            r4 = move-exception
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L43
            r0 = r4
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.RequestQueue.cancelAll(com.mokee.volley.RequestQueue$RequestFilter):void");
    }

    public void cancelAll(Object obj) {
        if (obj != null) {
            cancelAll((RequestFilter) new a(obj));
            return;
        }
        try {
            throw new IllegalArgumentException(k[0]);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Cache getCache() {
        return this.b;
    }

    public int getSequenceNumber() {
        return this.f.incrementAndGet();
    }

    public void start() {
        boolean z = Request.e;
        stop();
        this.a = new CacheDispatcher(this.j, this.h, this.b, this.g);
        this.a.start();
        int i = 0;
        if (z) {
            NetworkDispatcher networkDispatcher = new NetworkDispatcher(this.h, this.d, this.b, this.g);
            this.e[0] = networkDispatcher;
            networkDispatcher.start();
            i = 0 + 1;
        }
        while (true) {
            int i2 = i;
            if (i >= this.e.length) {
                return;
            }
            NetworkDispatcher networkDispatcher2 = new NetworkDispatcher(this.h, this.d, this.b, this.g);
            this.e[i2] = networkDispatcher2;
            networkDispatcher2.start();
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
        if (r3.e[r5] == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        r3.e[r5].quit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
        r4 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
        r5 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
        if (r4 < r3.e.length) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (r0 != false) goto L14;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0030 -> B:13:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void stop() {
        /*
            r3 = this;
            boolean r0 = com.mokee.volley.Request.e
            r6 = r0
            r0 = r3
            com.mokee.volley.CacheDispatcher r0 = r0.a     // Catch: java.lang.IllegalArgumentException -> L40
            if (r0 == 0) goto L12
            r0 = r3
            com.mokee.volley.CacheDispatcher r0 = r0.a     // Catch: java.lang.IllegalArgumentException -> L40
            r0.quit()     // Catch: java.lang.IllegalArgumentException -> L40
        L12:
            r0 = 0
            r4 = r0
            r0 = 0
            r5 = r0
            r0 = r6
            if (r0 == 0) goto L34
        L1a:
            r0 = r3
            com.mokee.volley.NetworkDispatcher[] r0 = r0.e     // Catch: java.lang.IllegalArgumentException -> L45
            r1 = r5
            r0 = r0[r1]     // Catch: java.lang.IllegalArgumentException -> L45
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L30
            r0 = r3
            com.mokee.volley.NetworkDispatcher[] r0 = r0.e
            r1 = r5
            r0 = r0[r1]
            r0.quit()
        L30:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r4 = r0
        L34:
            r0 = r4
            r5 = r0
            r0 = r4
            r1 = r3
            com.mokee.volley.NetworkDispatcher[] r1 = r1.e
            int r1 = r1.length
            if (r0 < r1) goto L1a
            return
        L40:
            r7 = move-exception
            r0 = r7
            throw r0
        L45:
            r7 = move-exception
            r0 = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.RequestQueue.stop():void");
    }
}
