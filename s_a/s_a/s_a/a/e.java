package s_a.s_a.s_a.a;

/* loaded from: source-3503164-dex2jar.jar:s_a/s_a/s_a/a/e.class */
public class e {
    public String a;
    public long b;

    public e(String str, long j) {
        this.a = str;
        this.b = j;
    }

    public boolean a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.b;
        if (currentTimeMillis < j - 600000 && Math.abs(j - currentTimeMillis) <= a.b(str) + 600000) {
            return true;
        }
        f.a("invalid");
        return false;
    }
}
