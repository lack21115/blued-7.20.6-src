package com.tencent.qimei.i;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/i/c.class */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f24643a;

    public c(e eVar) {
        this.f24643a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            synchronized (this.f24643a.g) {
                byte[] a2 = this.f24643a.a(this.f24643a.f24646c.toString().getBytes("ISO8859-1"));
                if (a2 == null) {
                    return;
                }
                if (a2.length + 10 > this.f24643a.e) {
                    this.f24643a.e = a2.length + 10;
                    this.f24643a.a(this.f24643a.e);
                }
                this.f24643a.d.putInt(0, a2.length);
                this.f24643a.d.position(10);
                this.f24643a.d.put(a2);
                this.f24643a.d.force();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
