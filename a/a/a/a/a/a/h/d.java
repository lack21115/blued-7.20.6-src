package a.a.a.a.a.a.h;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/h/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public c f1235a;

    public d(Object obj, int i) {
        if (a.a.a.a.a.e.h.h()) {
            this.f1235a = new b(obj, i);
        } else {
            this.f1235a = new a(obj, i);
        }
    }

    public static Object a() {
        return a.a.a.a.a.e.h.h() ? b.a() : a.a();
    }

    public int a(Object obj, int i) {
        return this.f1235a.a(obj, i);
    }

    public Object a(int i, int i2) {
        return this.f1235a.a(i, i2);
    }

    public void a(Object obj) {
        this.f1235a.a(obj);
    }

    public void a(Object obj, long j) {
        this.f1235a.a(obj, j);
    }

    public Object b(Object obj) {
        return this.f1235a.b(obj);
    }

    public void b() {
        this.f1235a.b();
    }

    public void c(Object obj) {
        this.f1235a.c(obj);
    }

    public boolean d(Object obj) {
        return this.f1235a.d(obj);
    }

    public boolean e(Object obj) {
        return this.f1235a.e(obj);
    }

    public void finalize() throws Throwable {
        try {
            if (this.f1235a != null) {
                this.f1235a.finalize();
            }
        } finally {
            super.finalize();
        }
    }
}
