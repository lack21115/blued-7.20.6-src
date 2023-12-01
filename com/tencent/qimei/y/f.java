package com.tencent.qimei.y;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/y/f.class */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f24757a;

    public f(g gVar) {
        this.f24757a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f24757a.a();
        } catch (Exception e) {
            com.tencent.qimei.k.a.a(e);
        }
    }
}
