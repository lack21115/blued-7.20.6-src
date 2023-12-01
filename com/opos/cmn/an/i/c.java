package com.opos.cmn.an.i;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/i/c.class */
public class c implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f24567a = new AtomicInteger(0);
    private String b;

    public c(String str) {
        this.b = str + BridgeUtil.UNDERLINE_STR;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.b + this.f24567a.incrementAndGet());
        thread.setUncaughtExceptionHandler(b.a());
        thread.setPriority(5);
        return thread;
    }
}
