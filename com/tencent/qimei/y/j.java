package com.tencent.qimei.y;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/y/j.class */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f38452a;

    public j(k kVar) {
        this.f38452a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f38452a.a();
        } catch (Throwable th) {
            com.tencent.qimei.k.a.a(th);
        }
    }
}
