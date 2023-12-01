package com.mokee.volley;

import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/NetworkDispatcher.class */
public class NetworkDispatcher extends Thread {
    private static final String[] f = null;
    private final Cache a;
    private final Network b;
    private final BlockingQueue<Request<?>> c;
    private final ResponseDelivery d;
    private volatile boolean e = false;

    static {
        String[] strArr = new String[7];
        throw new VerifyError("bad dex opcode");
    }

    public NetworkDispatcher(BlockingQueue<Request<?>> blockingQueue, Network network, Cache cache, ResponseDelivery responseDelivery) {
        this.c = blockingQueue;
        this.b = network;
        this.a = cache;
        this.d = responseDelivery;
    }

    private void a(Request<?> request) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
        }
    }

    private void a(Request<?> request, VolleyError volleyError) {
        this.d.postError(request, request.parseNetworkError(volleyError));
    }

    public void quit() {
        this.e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Request<?> take;
        NetworkResponse performRequest;
        Response<?> parseNetworkResponse;
        boolean z = Request.e;
        Process.setThreadPriority(10);
        while (true) {
            try {
                take = this.c.take();
                try {
                    take.addMarker(f[6]);
                } catch (VolleyError e) {
                    a(take, e);
                } catch (Exception e2) {
                    VolleyLog.e(e2, f[2], e2.toString());
                    this.d.postError(take, new VolleyError(e2));
                }
            } catch (InterruptedException e3) {
                if (this.e) {
                    return;
                }
            }
            try {
                try {
                    if (take.isCanceled()) {
                        take.b(f[5]);
                        if (!z) {
                            continue;
                        }
                    }
                    if (performRequest.notModified && take.hasHadResponseDelivered()) {
                        take.b(f[0]);
                        if (!z) {
                            continue;
                        }
                    }
                    take.addMarker(f[1]);
                    if (take.shouldCache()) {
                        try {
                            if (parseNetworkResponse.cacheEntry != null) {
                                this.a.put(take.getCacheKey(), parseNetworkResponse.cacheEntry);
                                take.addMarker(f[4]);
                            }
                        } catch (InterruptedException e4) {
                            throw e4;
                        }
                    }
                    take.markDelivered();
                    this.d.postResponse(take, parseNetworkResponse);
                } catch (InterruptedException e5) {
                    throw e5;
                    break;
                }
                take.addMarker(f[3]);
                parseNetworkResponse = take.parseNetworkResponse(performRequest);
            } catch (InterruptedException e6) {
                throw e6;
            }
            a(take);
            performRequest = this.b.performRequest(take);
        }
    }
}
