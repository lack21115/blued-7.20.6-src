package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.ao;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/j.class */
public class j {
    private final l anZ;
    private final com.kwad.sdk.core.videocache.a aoa;
    private volatile Thread aoe;
    private volatile boolean li;
    private final Object aob = new Object();
    private final Object aoc = new Object();
    private volatile int aof = -1;
    private final AtomicInteger aod = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/j$a.class */
    public final class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(j jVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.this.yJ();
        }
    }

    public j(l lVar, com.kwad.sdk.core.videocache.a aVar) {
        this.anZ = (l) ao.checkNotNull(lVar);
        this.aoa = (com.kwad.sdk.core.videocache.a) ao.checkNotNull(aVar);
    }

    private void e(long j, long j2) {
        f(j, j2);
        synchronized (this.aob) {
            this.aob.notifyAll();
        }
    }

    private void f(long j, long j2) {
        boolean z = true;
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        int i2 = i == 0 ? 100 : (int) ((((float) j) / ((float) j2)) * 100.0f);
        boolean z2 = i2 != this.aof;
        if (i < 0) {
            z = false;
        }
        if (z && z2) {
            bC(i2);
        }
        this.aof = i2;
    }

    private boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.li;
    }

    private static void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.b.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.b.e("ProxyCache", "ProxyCache error");
        }
    }

    private void tryComplete() {
        synchronized (this.aoc) {
            if (!isStopped() && this.aoa.yw() == this.anZ.length()) {
                this.aoa.complete();
            }
        }
    }

    private void yG() {
        int i = this.aod.get();
        if (i <= 0) {
            return;
        }
        this.aod.set(0);
        throw new ProxyCacheException("Error reading source " + i + " times");
    }

    private void yH() {
        synchronized (this) {
            boolean z = (this.aoe == null || this.aoe.getState() == Thread.State.TERMINATED) ? false : true;
            if (!this.li && !this.aoa.isCompleted() && !z) {
                a aVar = new a(this, (byte) 0);
                this.aoe = new Thread(aVar, "Source reader for " + this.anZ);
                this.aoe.start();
            }
        }
    }

    private void yI() {
        synchronized (this.aob) {
            try {
                this.aob.wait(1000L);
            } catch (InterruptedException e) {
                throw new ProxyCacheException("Waiting source data is interrupted!", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a5, code lost:
        r10 = r10 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void yJ() {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.j.yJ():void");
    }

    private void yK() {
        this.aof = 100;
        bC(this.aof);
    }

    private void yL() {
        try {
            this.anZ.close();
        } catch (ProxyCacheException e) {
            onError(new ProxyCacheException("Error closing source " + this.anZ, e));
        }
    }

    public final int a(byte[] bArr, long j, int i) {
        k.b(bArr, j, 8192);
        while (!this.aoa.isCompleted() && this.aoa.yw() < 8192 + j && !this.li) {
            yH();
            yI();
            yG();
        }
        int a2 = this.aoa.a(bArr, j, 8192);
        if (this.aoa.isCompleted() && this.aof != 100) {
            this.aof = 100;
            bC(100);
        }
        return a2;
    }

    protected void bC(int i) {
    }

    public final void shutdown() {
        synchronized (this.aoc) {
            com.kwad.sdk.core.d.b.d("ProxyCache", "Shutdown proxy for " + this.anZ);
            try {
                this.li = true;
                if (this.aoe != null) {
                    this.aoe.interrupt();
                }
                this.aoa.close();
            } catch (ProxyCacheException e) {
                onError(e);
            }
        }
    }
}
