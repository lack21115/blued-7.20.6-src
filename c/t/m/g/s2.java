package c.t.m.g;

import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/s2.class */
public class s2 {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Object> f3925a = new HashMap<>();

    public static <T> T a(String str, T t) {
        T t2;
        synchronized (s2.class) {
            try {
                t2 = f3925a.get(str);
                if (t2 == null) {
                    t2 = t;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t2;
    }

    public static <T> void b(String str, T t) {
        synchronized (s2.class) {
            try {
                f3925a.put(str, t);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
