package com.qiniu.pili.droid.shortvideo.gl.a;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private c f27690a;

    public d(Object obj, int i) {
        if (com.qiniu.pili.droid.shortvideo.f.d.b()) {
            this.f27690a = new b(obj, i);
        } else {
            this.f27690a = new a(obj, i);
        }
    }

    public static Object b() {
        return com.qiniu.pili.droid.shortvideo.f.d.b() ? b.b() : a.b();
    }

    public void a() {
        this.f27690a.a();
    }

    public void a(Object obj) {
        this.f27690a.a(obj);
    }

    public void a(Object obj, long j) {
        this.f27690a.a(obj, j);
    }

    public Object b(Object obj) {
        return this.f27690a.b(obj);
    }

    public void c(Object obj) {
        this.f27690a.c(obj);
    }

    public boolean d(Object obj) {
        return this.f27690a.d(obj);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.f27690a != null) {
                this.f27690a.finalize();
            }
        } finally {
            super.finalize();
        }
    }
}
