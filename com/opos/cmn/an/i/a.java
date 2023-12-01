package com.opos.cmn.an.i;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/i/a.class */
public final class a {
    public static ExecutorService a() {
        return new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(15), new c("cmn_net"), new ThreadPoolExecutor.DiscardPolicy());
    }

    public static ExecutorService b() {
        return new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(20), new c("cmn_io"), new ThreadPoolExecutor.DiscardPolicy());
    }

    public static ExecutorService c() {
        return new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(25), new c("cmn_dl"), new ThreadPoolExecutor.DiscardPolicy());
    }

    public static ExecutorService d() {
        return new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(15), new c("cmn_biz"), new ThreadPoolExecutor.DiscardPolicy());
    }

    public static ExecutorService e() {
        return Executors.newSingleThreadExecutor(new c("cmn_single"));
    }

    public static ScheduledExecutorService f() {
        return Executors.newScheduledThreadPool(1, new c("cmn_schedule"));
    }

    public static ExecutorService g() {
        return Executors.newSingleThreadExecutor(new c("cmn_br"));
    }
}
