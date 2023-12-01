package com.tencent.qimei.j;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/j/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final Object f24654a;
    public int b;

    public f(Object obj, int i) {
        this.f24654a = obj;
        this.b = i;
    }

    public void a() {
        synchronized (this.f24654a) {
            this.f24654a.notifyAll();
        }
    }

    public void b() {
        try {
            synchronized (this.f24654a) {
                this.f24654a.wait(this.b);
            }
        } catch (InterruptedException e) {
            com.tencent.qimei.k.a.a(e);
        }
    }
}
