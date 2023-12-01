package com.kwad.sdk.utils;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/g.class */
public class g {
    private static volatile Executor azg;
    private static volatile ScheduledExecutorService azh;

    public static void execute(Runnable runnable) {
        if (azg == null) {
            synchronized (g.class) {
                try {
                    if (azg == null) {
                        azg = GlobalThreadPools.xU();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        azg.execute(runnable);
    }

    public static void schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        if (azh == null) {
            synchronized (g.class) {
                try {
                    if (azh == null) {
                        azh = GlobalThreadPools.xV();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        azh.schedule(runnable, j, timeUnit);
    }
}
