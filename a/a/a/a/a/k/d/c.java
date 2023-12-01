package a.a.a.a.a.k.d;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/d/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public Object f1407a = new Object();
    public StringBuilder b = new StringBuilder();

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/d/c$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f1408a = new c();
    }

    public static c a() {
        return a.f1408a;
    }

    public boolean a(String str) {
        if (str == null || str.equals("") || this.b.length() > 65536) {
            return false;
        }
        try {
            synchronized (this.f1407a) {
                this.b.append(str);
            }
            return true;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return true;
        }
    }

    public void b() {
        synchronized (this.f1407a) {
            this.b.delete(0, this.b.length());
        }
    }

    public String c() {
        String sb;
        StringBuilder sb2 = this.b;
        if (sb2 == null || sb2.length() == 0) {
            return null;
        }
        synchronized (this.f1407a) {
            sb = this.b.toString();
        }
        return sb;
    }
}
