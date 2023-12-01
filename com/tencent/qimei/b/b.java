package com.tencent.qimei.b;

import com.tencent.qimei.j.e;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/b/b.class */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f38312a;

    public b(c cVar, Runnable runnable) {
        this.f38312a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f38312a.run();
        } catch (Throwable th) {
            e.a(th.getMessage());
            com.tencent.qimei.k.a.a(th);
        }
    }
}
