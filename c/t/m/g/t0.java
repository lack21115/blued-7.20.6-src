package c.t.m.g;

import android.content.Context;
import android.text.TextUtils;
import c.t.m.g.v0;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/t0.class */
public class t0 implements v0.b {
    public static volatile String d = "";
    public static volatile boolean e = false;

    /* renamed from: a  reason: collision with root package name */
    public Context f3988a = q2.a();
    public v0 b;

    /* renamed from: c  reason: collision with root package name */
    public s0 f3989c;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/t0$a.class */
    public static final class a implements Runnable {

        /* renamed from: c.t.m.g.t0$a$a  reason: collision with other inner class name */
        /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/t0$a$a.class */
        public class C0041a implements s0 {
            public C0041a(a aVar) {
            }

            @Override // c.t.m.g.s0
            public void a(String str) {
                if (m3.a(str)) {
                    return;
                }
                if (!t0.d.equals(str)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    g3.a("LOG", "update oaid," + t0.d + "," + str + "," + currentTimeMillis);
                    p3.b(p3.a(), "loc_id_oaid", str);
                    p3.b(p3.a(), "loc_id_oaid_time", Long.valueOf(currentTimeMillis));
                    String unused = t0.d = str;
                }
                String unused2 = t0.d;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                new t0(new C0041a(this));
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/t0$b.class */
    public static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f3990a;

        public b(Runnable runnable) {
            this.f3990a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            Future<?> submit = newSingleThreadExecutor.submit(this.f3990a);
            try {
                newSingleThreadExecutor.shutdown();
                if (newSingleThreadExecutor.awaitTermination(15L, TimeUnit.SECONDS)) {
                    return;
                }
                g3.a("LOG", "get oaid terminated.");
                if (submit.isDone()) {
                    return;
                }
                submit.cancel(true);
            } catch (Throwable th) {
            }
        }
    }

    public t0(s0 s0Var) {
        this.f3989c = s0Var;
        v0 v0Var = new v0(this);
        this.b = v0Var;
        v0Var.a(this.f3988a);
    }

    public static String b() {
        String a2;
        synchronized (t0.class) {
            try {
                if (TextUtils.isEmpty(d)) {
                    d = p3.a(p3.a(), "loc_id_oaid", "");
                }
                if (!e) {
                    e = true;
                    b bVar = new b(new a());
                    long currentTimeMillis = System.currentTimeMillis();
                    long longValue = ((Long) p3.a(p3.a(), "loc_id_oaid_time", (Object) 0L)).longValue();
                    if (!q3.p() && Math.abs(currentTimeMillis - longValue) >= 432000000) {
                        a3.a("th_loc_oaid", bVar);
                    }
                }
                a2 = q3.a(d);
            } catch (Throwable th) {
                throw th;
            }
        }
        return a2;
    }

    @Override // c.t.m.g.v0.b
    public void a(String str, boolean z) {
        s0 s0Var = this.f3989c;
        if (s0Var != null) {
            if (!z) {
                str = null;
            }
            s0Var.a(str);
        }
    }
}
