package com.opos.cmn.biz.web.a.a.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/a/a/a/b.class */
public class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f11020a = new AtomicInteger(0);
    private String b;

    public b(String str) {
        this.b = str + "_";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.b + this.f11020a.incrementAndGet());
        thread.setUncaughtExceptionHandler(a.a());
        thread.setPriority(5);
        return thread;
    }
}
