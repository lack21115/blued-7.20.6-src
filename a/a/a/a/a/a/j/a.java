package a.a.a.a.a.a.j;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public int f1205a = 30;
    public float b = -1.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f1206c = 0.0f;
    public long d = 0;
    public long e = 0;
    public int f = 0;
    public boolean g = true;

    /* renamed from: a.a.a.a.a.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/a$a.class */
    public static class C0002a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f1207a = new a();
    }

    public static a a() {
        return C0002a.f1207a;
    }

    public void a(int i) {
        this.f1205a = i;
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
        eVar.c("FPSController", "set desire fps:" + this.f1205a);
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean b() {
        int i;
        if (this.g) {
            this.d++;
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.d;
            if (j != 0) {
                long j2 = currentTimeMillis - this.e;
                if (j2 > 1000) {
                    int round = Math.round((float) ((j * 1000) / j2));
                    this.e = currentTimeMillis;
                    this.d = 0L;
                    if (round <= this.f1205a) {
                        this.b = -1.0f;
                    } else {
                        this.b = round / (round - i);
                    }
                    this.f = round;
                    a.a.a.a.a.e.e.g.b("FPSController", "average fps = " + round + ", delta fps = " + this.b);
                }
            }
            float f = this.b;
            if (f < 0.0f) {
                return false;
            }
            float f2 = this.f1206c + 1.0f;
            this.f1206c = f2;
            if (f2 >= f) {
                this.f1206c = f2 - f;
                return true;
            }
            return false;
        }
        return false;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.f1205a;
    }
}
