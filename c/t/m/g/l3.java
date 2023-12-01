package c.t.m.g;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/l3.class */
public class l3 {
    public static <T> T a(T t, T t2) {
        a(t2);
        T t3 = t;
        if (t == null) {
            t3 = t2;
        }
        return t3;
    }

    public static void a(Object obj) {
        if (obj == null) {
            throw new NullPointerException("object is null.");
        }
    }
}
