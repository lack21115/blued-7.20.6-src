package com.tencent.qimei.o;

import com.tencent.qimei.sdk.Qimei;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/p.class */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f38389a;

    public p(r rVar) {
        this.f38389a = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicInteger atomicInteger;
        Qimei i = com.tencent.qimei.a.a.i(this.f38389a.i);
        if (i != null && !i.isEmpty()) {
            this.f38389a.b();
            return;
        }
        atomicInteger = this.f38389a.b;
        if (atomicInteger.getAndIncrement() > 30) {
            return;
        }
        this.f38389a.d();
    }
}
