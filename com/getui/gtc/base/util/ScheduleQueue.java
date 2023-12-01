package com.getui.gtc.base.util;

import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/util/ScheduleQueue.class */
public class ScheduleQueue {
    private static final String TAG = "ScheduleQueue";
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private ScheduledThreadPoolExecutor exec;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/util/ScheduleQueue$SingletonHolder.class */
    public static class SingletonHolder {
        private static final ScheduleQueue instance = new ScheduleQueue();

        private SingletonHolder() {
        }
    }

    private ScheduleQueue() {
        this.exec = null;
        this.exec = new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: com.getui.gtc.base.util.ScheduleQueue.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("Gtc-ScheduleQueue-" + ScheduleQueue.poolNumber.getAndIncrement());
                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.getui.gtc.base.util.ScheduleQueue.1.1
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public void uncaughtException(Thread thread2, Throwable th) {
                        Log.e("gtc", "caught an exception from " + thread2.getName(), th);
                    }
                });
                return thread;
            }
        });
    }

    public static ScheduleQueue getInstance() {
        return SingletonHolder.instance;
    }

    public boolean addSchedule(Runnable runnable) {
        try {
            this.exec.execute(runnable);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean addSchedule(Runnable runnable, long j) {
        try {
            this.exec.schedule(runnable, j, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean addSchedule(Runnable runnable, long j, long j2) {
        try {
            this.exec.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public ScheduledFuture addScheduler(Runnable runnable, long j, long j2) {
        try {
            return this.exec.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            return null;
        }
    }

    public void shutDown() {
        this.exec.shutdown();
    }
}
