package a.a.a.a.a.f;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/f/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f1367a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f1368c;
    public volatile int d;

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/f/b$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f1369a = new b();
    }

    public static b a() {
        return a.f1369a;
    }

    public void a(int i) {
        this.f1368c = i;
    }

    public void a(long j) {
        this.f1367a = j;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    public void b(int i) {
        this.d = i;
    }

    public boolean b(long j) {
        return this.f1367a / 1000 == j;
    }

    public boolean c() {
        return this.d > 0 && this.d < this.f1368c;
    }

    public void d() {
        this.d++;
    }

    public void e() {
        if (this.f1368c <= 0 || this.d != this.f1368c) {
            return;
        }
        this.f1368c = 0;
        this.d = 0;
        this.b = null;
        this.f1367a = 0L;
    }
}
