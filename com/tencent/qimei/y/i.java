package com.tencent.qimei.y;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/y/i.class */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f24760a;

    public i(k kVar) {
        this.f24760a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f24760a.b();
        } catch (Throwable th) {
            com.tencent.qimei.k.a.a(th);
        }
    }
}
