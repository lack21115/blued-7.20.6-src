package com.tencent.qimei.y;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/y/e.class */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f24756a;

    public e(g gVar) {
        this.f24756a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            g.a(this.f24756a);
        } catch (Exception e) {
            com.tencent.qimei.k.a.a(e);
        }
    }
}
