package com.tencent.qimei.y;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/y/j.class */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f24761a;

    public j(k kVar) {
        this.f24761a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f24761a.a();
        } catch (Throwable th) {
            com.tencent.qimei.k.a.a(th);
        }
    }
}
