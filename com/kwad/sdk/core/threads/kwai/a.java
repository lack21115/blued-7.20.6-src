package com.kwad.sdk.core.threads.kwai;

import android.os.SystemClock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/threads/kwai/a.class */
public final class a extends ScheduledThreadPoolExecutor implements c {
    public static volatile boolean amK = false;
    private final ConcurrentHashMap<Runnable, Long> amL;
    private long amM;
    private int amN;

    public a(int i, ThreadFactory threadFactory) {
        super(1, threadFactory);
        this.amL = new ConcurrentHashMap<>();
        this.amM = 0L;
        this.amN = 0;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (amK && this.amL.containsKey(runnable) && this.amL.get(runnable) != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.amL.get(runnable).longValue();
            if (elapsedRealtime >= 0 && elapsedRealtime < 1800000) {
                long j = this.amM;
                int i = this.amN;
                this.amM = ((j * i) + elapsedRealtime) / (i + 1);
                this.amN = i + 1;
            }
            this.amL.remove(runnable);
        }
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (amK) {
            this.amL.put(runnable, Long.valueOf(SystemClock.elapsedRealtime()));
        }
        super.execute(runnable);
    }

    @Override // com.kwad.sdk.core.threads.kwai.c
    public final long yg() {
        return this.amM;
    }
}
