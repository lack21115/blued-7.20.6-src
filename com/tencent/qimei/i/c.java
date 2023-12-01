package com.tencent.qimei.i;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/i/c.class */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f38334a;

    public c(e eVar) {
        this.f38334a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            synchronized (this.f38334a.g) {
                byte[] a2 = this.f38334a.a(this.f38334a.f38337c.toString().getBytes("ISO8859-1"));
                if (a2 == null) {
                    return;
                }
                if (a2.length + 10 > this.f38334a.e) {
                    this.f38334a.e = a2.length + 10;
                    this.f38334a.a(this.f38334a.e);
                }
                this.f38334a.d.putInt(0, a2.length);
                this.f38334a.d.position(10);
                this.f38334a.d.put(a2);
                this.f38334a.d.force();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
