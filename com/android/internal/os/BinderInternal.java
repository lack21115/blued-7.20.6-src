package com.android.internal.os;

import android.os.IBinder;
import android.os.SystemClock;
import android.util.EventLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BinderInternal.class */
public class BinderInternal {
    private static final int GC_DELAY_MAX_DURATION = 3000;
    private static final int POSTPONED_GC_MAX = 5;
    static long sLastGcTime;
    static WeakReference<GcWatcher> sGcWatcher = new WeakReference<>(new GcWatcher());
    static ArrayList<Runnable> sGcWatchers = new ArrayList<>();
    static Runnable[] sTmpWatchers = new Runnable[1];
    static long lastGcDelayRequestTime = SystemClock.uptimeMillis();
    static TimerGc timerGcInstance = null;
    static FutureTask<Void> futureTaskInstance = null;
    static ExecutorService executor = Executors.newFixedThreadPool(1);
    static int postponedGcCount = 0;
    static Object delayGcMonitorObject = new Object();

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BinderInternal$GcWatcher.class */
    static final class GcWatcher {
        GcWatcher() {
        }

        protected void finalize() throws Throwable {
            BinderInternal.handleGc();
            BinderInternal.sLastGcTime = SystemClock.uptimeMillis();
            synchronized (BinderInternal.sGcWatchers) {
                BinderInternal.sTmpWatchers = (Runnable[]) BinderInternal.sGcWatchers.toArray(BinderInternal.sTmpWatchers);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= BinderInternal.sTmpWatchers.length) {
                    BinderInternal.sGcWatcher = new WeakReference<>(new GcWatcher());
                    return;
                }
                if (BinderInternal.sTmpWatchers[i2] != null) {
                    BinderInternal.sTmpWatchers[i2].run();
                }
                i = i2 + 1;
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BinderInternal$TimerGc.class */
    public static class TimerGc implements Callable<Void> {
        private long waitTime;

        public TimerGc(long j) {
            this.waitTime = j;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            Thread.sleep(this.waitTime);
            BinderInternal.forceGc("Binder");
            BinderInternal.postponedGcCount = 0;
            return null;
        }
    }

    public static void addGcWatcher(Runnable runnable) {
        synchronized (sGcWatchers) {
            sGcWatchers.add(runnable);
        }
    }

    public static final native void disableBackgroundScheduling(boolean z);

    static void forceBinderGc() {
        synchronized (delayGcMonitorObject) {
            if (futureTaskInstance != null) {
                long uptimeMillis = SystemClock.uptimeMillis() - lastGcDelayRequestTime;
                if (uptimeMillis < 3000) {
                    if (postponedGcCount != 0) {
                        return;
                    }
                    futureTaskInstance.cancel(true);
                    timerGcInstance = new TimerGc(3000 - uptimeMillis);
                    futureTaskInstance = new FutureTask<>(timerGcInstance);
                    postponedGcCount = 1;
                    executor.execute(futureTaskInstance);
                    return;
                }
            }
            forceGc("Binder");
        }
    }

    public static void forceGc(String str) {
        EventLog.writeEvent(2741, str);
        Runtime.getRuntime().gc();
    }

    public static final native IBinder getContextObject();

    public static long getLastGcTime() {
        return sLastGcTime;
    }

    static final native void handleGc();

    public static final native void joinThreadPool();

    public static void modifyDelayedGcParams() {
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (delayGcMonitorObject) {
            if (futureTaskInstance == null || postponedGcCount == 0) {
                lastGcDelayRequestTime = uptimeMillis;
                timerGcInstance = new TimerGc(3000L);
                futureTaskInstance = new FutureTask<>(timerGcInstance);
            } else if (postponedGcCount <= 5) {
                futureTaskInstance.cancel(true);
                if (futureTaskInstance.isCancelled()) {
                    lastGcDelayRequestTime = uptimeMillis;
                    postponedGcCount++;
                    timerGcInstance = new TimerGc(3000L);
                    futureTaskInstance = new FutureTask<>(timerGcInstance);
                    executor.execute(futureTaskInstance);
                }
            }
        }
    }
}
