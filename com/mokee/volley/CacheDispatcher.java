package com.mokee.volley;

import android.os.Process;
import com.mokee.volley.Cache;
import java.util.concurrent.BlockingQueue;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/CacheDispatcher.class */
public class CacheDispatcher extends Thread {

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f24229c = false;
    private static final String[] g = null;

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue<Request<?>> f24230a;
    private final Cache b;
    private final BlockingQueue<Request<?>> d;
    private volatile boolean e = false;
    private final ResponseDelivery f;

    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/CacheDispatcher$a.class */
    class a implements Runnable {
        private final /* synthetic */ Request val$request;

        a(Request request) {
            this.val$request = request;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                CacheDispatcher.this.d.put(this.val$request);
            } catch (InterruptedException e) {
            }
        }
    }

    static {
        String[] strArr = new String[8];
        throw new VerifyError("bad dex opcode");
    }

    public CacheDispatcher(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, Cache cache, ResponseDelivery responseDelivery) {
        this.f24230a = blockingQueue;
        this.d = blockingQueue2;
        this.b = cache;
        this.f = responseDelivery;
    }

    public void quit() {
        this.e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Request<?> take;
        Cache.Entry entry;
        Response<?> parseNetworkResponse;
        boolean z = Request.e;
        try {
            if (f24229c) {
                VolleyLog.v(g[1], new Object[0]);
            }
            Process.setThreadPriority(10);
            this.b.initialize();
            while (true) {
                try {
                    take = this.f24230a.take();
                    take.addMarker(g[4]);
                } catch (InterruptedException e) {
                    if (this.e) {
                        return;
                    }
                }
                try {
                    if (take.isCanceled()) {
                        take.b(g[6]);
                        if (!z) {
                            continue;
                        }
                    }
                    if (entry == null) {
                        take.addMarker(g[7]);
                        this.d.put(take);
                        if (!z) {
                            continue;
                        }
                    }
                    if (entry.isExpired()) {
                        take.addMarker(g[5]);
                        take.setCacheEntry(entry);
                        this.d.put(take);
                        if (!z) {
                            continue;
                        }
                    }
                    take.addMarker(g[0]);
                    if (!entry.refreshNeeded()) {
                        this.f.postResponse(take, parseNetworkResponse);
                        if (z) {
                        }
                    }
                    take.addMarker(g[2]);
                    take.setCacheEntry(entry);
                    parseNetworkResponse.intermediate = true;
                    this.f.postResponse(take, parseNetworkResponse, new a(take));
                } catch (InterruptedException e2) {
                    throw e2;
                    break;
                }
                entry = this.b.get(take.getCacheKey());
                take.addMarker(g[3]);
                parseNetworkResponse = take.parseNetworkResponse(new NetworkResponse(entry.data, entry.responseHeaders));
            }
        } catch (InterruptedException e3) {
            throw e3;
        }
    }
}
