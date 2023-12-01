package c.t.m.g;

import java.io.Closeable;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/e3.class */
public class e3 {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }
}
