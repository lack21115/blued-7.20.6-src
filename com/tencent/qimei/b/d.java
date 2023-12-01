package com.tencent.qimei.b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/b/d.class */
public final class d implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f38314a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("qm-thread-");
            sb.append(this.f38314a.getAndIncrement());
            return new Thread(runnable, sb.toString());
        } catch (Exception e) {
            com.tencent.qimei.k.a.a(e);
            return null;
        } catch (OutOfMemoryError e2) {
            return null;
        }
    }
}
