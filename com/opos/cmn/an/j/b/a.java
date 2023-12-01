package com.opos.cmn.an.j.b;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/j/b/a.class */
public final class a implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private int f24583a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private AtomicInteger f24584c = new AtomicInteger(0);

    public a(String str, int i) {
        this.b = str;
        this.f24583a = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.b + BridgeUtil.UNDERLINE_STR + this.f24584c.incrementAndGet());
        thread.setPriority(this.f24583a);
        return thread;
    }
}
