package c.t.m.g;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/t2.class */
public class t2 {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, ThreadLocal<SimpleDateFormat>> f3991a = new HashMap<>();

    public static String a(String str) {
        return a(str, System.currentTimeMillis());
    }

    public static String a(String str, long j) {
        return b(str).format(new Date(j));
    }

    public static SimpleDateFormat b(String str) {
        SimpleDateFormat simpleDateFormat;
        synchronized (t2.class) {
            try {
                ThreadLocal<SimpleDateFormat> threadLocal = f3991a.get(str);
                ThreadLocal<SimpleDateFormat> threadLocal2 = threadLocal;
                if (threadLocal == null) {
                    threadLocal2 = new ThreadLocal<>();
                    f3991a.put(str, threadLocal2);
                }
                SimpleDateFormat simpleDateFormat2 = threadLocal2.get();
                simpleDateFormat = simpleDateFormat2;
                if (simpleDateFormat2 == null) {
                    simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
                    threadLocal2.set(simpleDateFormat);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return simpleDateFormat;
    }
}
