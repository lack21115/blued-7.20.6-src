package c.t.m.g;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/n0.class */
public class n0 implements Observer {
    public static volatile String g = "";
    public static volatile String h = "";
    public static volatile String i = "";
    public static final HashMap<String, String> j = new HashMap<>();
    public static volatile n0 k = null;
    public volatile ConcurrentHashMap<String, String> b;

    /* renamed from: c  reason: collision with root package name */
    public volatile ConcurrentHashMap<String, List<l0>> f3889c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<Class<?>, Object> f3888a = new HashMap<>();
    public volatile boolean d = false;
    public AtomicBoolean e = new AtomicBoolean(true);
    public AtomicBoolean f = new AtomicBoolean(true);

    public n0() {
        this.b = null;
        this.f3889c = null;
        this.b = new ConcurrentHashMap<>(((j.size() * 4) / 3) + 1);
        this.f3889c = new ConcurrentHashMap<>(((j.size() * 4) / 3) + 1);
        this.f3888a.put(String.class, "");
        this.f3888a.put(Integer.class, Integer.MIN_VALUE);
        this.f3888a.put(Float.class, Float.valueOf(Float.MIN_VALUE));
        this.f3888a.put(Double.class, Double.valueOf(Double.MIN_VALUE));
        this.f3888a.put(Long.class, Long.MIN_VALUE);
        this.f3888a.put(Boolean.class, Boolean.FALSE);
        c();
    }

    public static void a(String str, String str2) {
        g = str;
        i = str2;
        b("app_version", str2);
    }

    public static void a(HashMap<String, String> hashMap) {
        b("cc_version", "-1");
        b("cc_req_interval", "10800000");
        b("last_pull_time", "0");
        b("list_valid_model", "");
        b("list_valid_sdk_int", "");
        for (String str : hashMap.keySet()) {
            b(str, hashMap.get(str));
        }
    }

    public static n0 b() {
        n0 n0Var;
        synchronized (n0.class) {
            try {
                if (k == null) {
                    synchronized (n0.class) {
                        k = new n0();
                    }
                }
                n0Var = k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return n0Var;
    }

    public static void b(String str, String str2) throws IllegalStateException {
        j.put(str, str2);
    }

    public static void f(String str) {
        h = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0030, code lost:
        if (r0.length() == 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005d, code lost:
        if (r4.f.get() == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r5, java.lang.Class<?> r6) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.n0.a(java.lang.String, java.lang.Class):java.lang.Object");
    }

    public final String a(String str) {
        if (j.containsKey(str)) {
            return j.get(str);
        }
        throw new NullPointerException("Not exists property name \"" + str + "\"");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008b A[Catch: all -> 0x00e6, TryCatch #1 {all -> 0x00e6, blocks: (B:15:0x0075, B:17:0x008b, B:19:0x0095, B:23:0x00ba, B:25:0x00c6), top: B:37:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0095 A[Catch: all -> 0x00e6, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00e6, blocks: (B:15:0x0075, B:17:0x008b, B:19:0x0095, B:23:0x00ba, B:25:0x00c6), top: B:37:0x0075 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.n0.a():void");
    }

    public final Object b(String str, Class<?> cls) {
        if (cls == Integer.class) {
            return Integer.valueOf(Integer.parseInt(str));
        }
        if (cls == Long.class) {
            return Long.valueOf(Long.parseLong(str));
        }
        if (cls == Boolean.class) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        if (cls == Float.class) {
            return Float.valueOf(Float.parseFloat(str));
        }
        Object obj = str;
        if (cls == Double.class) {
            obj = Double.valueOf(Double.parseDouble(str));
        }
        return obj;
    }

    public boolean b(String str) {
        return ((Boolean) a(str, Boolean.class)).booleanValue();
    }

    public int c(String str) {
        return ((Integer) a(str, Integer.class)).intValue();
    }

    public final void c() {
        try {
            d();
            e();
        } catch (Throwable th) {
        }
    }

    public long d(String str) {
        return ((Long) a(str, Long.class)).longValue();
    }

    public final void d() {
        SharedPreferences b = o0.a().b();
        if (b == null) {
            return;
        }
        String str = (String) p3.a(b, "app_version", (Object) "");
        if (i.length() <= 0 || i.equals(str)) {
            return;
        }
        b.edit().clear().apply();
        p3.b(b, "app_version", (Object) i);
    }

    public String e(String str) {
        return (String) a(str, String.class);
    }

    public void e() {
        if (o0.a().b() == null) {
            return;
        }
        for (String str : j.keySet()) {
            g(str);
        }
        this.d = true;
        a();
        this.b.toString();
    }

    public void f() {
        this.f3889c.clear();
    }

    public final void g(String str) {
        if (j.get(str) == null) {
            return;
        }
        try {
            SharedPreferences b = o0.a().b();
            if (b != null) {
                this.b.put(str, b.getString(str, a(str)));
            }
        } catch (Throwable th) {
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        String str = obj == null ? null : (String) obj;
        if (str == null || str.length() == 0) {
            return;
        }
        String str2 = "update [" + str + "] : " + this.b.get(str) + " --> ";
        g(str);
        this.b.get(str);
        List<l0> list = this.f3889c.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (l0 l0Var : list) {
            l0Var.a(str);
        }
    }
}
