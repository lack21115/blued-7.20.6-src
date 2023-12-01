package com.tencent.qimei.y;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/y/f.class */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f38448a;

    public f(g gVar) {
        this.f38448a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f38448a.a();
        } catch (Exception e) {
            com.tencent.qimei.k.a.a(e);
        }
    }
}
