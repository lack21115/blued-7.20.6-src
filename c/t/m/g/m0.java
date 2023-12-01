package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/m0.class */
public class m0 extends e2 {
    public static volatile m0 g;
    public static Context h;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f3879c = true;
    public volatile u1 d = u1.f4005a;
    public Handler e;
    public volatile String f;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/m0$a.class */
    public static final class a extends Thread {
        public a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                m0.h();
                o0.a();
                n0.b();
                p3.b(o0.a().b(), "last_pull_time", (Object) String.valueOf(0));
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/m0$b.class */
    public class b extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        public final JSONObject f3880a = new JSONObject();
        public n0 b;

        /* renamed from: c  reason: collision with root package name */
        public o0 f3881c;

        public b() {
            this.b = null;
            this.f3881c = null;
            this.b = n0.b();
            this.f3881c = o0.a();
        }

        public final void a() {
            boolean b = m0.this.b();
            if (b) {
                try {
                    this.f3881c.c();
                } catch (Throwable th) {
                    this.b.e();
                    if (!b) {
                        return;
                    }
                }
            }
            JSONObject b2 = b();
            if (b2 != this.f3880a) {
                if (Integer.parseInt(b2.optString("status", "-5")) == 0 && b2.has("version")) {
                    a(b2);
                }
                p3.b(this.f3881c.b(), "last_pull_time", (Object) String.valueOf(System.currentTimeMillis()));
                Thread.sleep(1000L);
            }
            this.b.e();
            if (!b) {
                return;
            }
            this.f3881c.d();
        }

        public final void a(SharedPreferences.Editor editor, String str, String str2, JSONObject jSONObject) {
            try {
                String e = this.b.e(str);
                if (e == null) {
                    return;
                }
                editor.putString(str, jSONObject.optString(str2, e));
            } catch (Exception e2) {
            }
        }

        public final void a(JSONObject jSONObject) throws JSONException {
            int i;
            long j;
            SharedPreferences b = this.f3881c.b();
            if (b == null) {
                return;
            }
            int c2 = this.b.c("cc_version");
            try {
                i = Integer.parseInt(jSONObject.optString("version", this.b.e("cc_version")));
            } catch (Throwable th) {
                i = c2;
            }
            if (i == c2) {
                return;
            }
            b.edit().clear().apply();
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            JSONObject jSONObject2 = optJSONObject;
            if (optJSONObject == null) {
                jSONObject2 = this.f3880a;
            }
            SharedPreferences.Editor edit = b.edit();
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                a(edit, next, next, jSONObject2);
            }
            edit.putString("cc_version", String.valueOf(i));
            edit.putString("app_version", n0.i);
            try {
                long parseLong = Long.parseLong(jSONObject2.optString("cc_req_interval", this.b.e("cc_req_interval")));
                if (parseLong < 1800000) {
                    j = 1800000;
                } else {
                    j = parseLong;
                    if (parseLong > 86400000) {
                        j = 86400000;
                    }
                }
                edit.putString("cc_req_interval", String.valueOf(j));
            } catch (Throwable th2) {
            }
            edit.apply();
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x007e, code lost:
            if ("0123456789ABCDEF".equals(r0) != false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0095, code lost:
            if ("0123456789ABCDEF".equals(r7) != false) goto L48;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final org.json.JSONObject b() {
            /*
                Method dump skipped, instructions count: 333
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.m0.b.b():org.json.JSONObject");
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                if (Math.abs(System.currentTimeMillis() - this.b.d("last_pull_time")) >= m0.this.g()) {
                    a();
                }
                if (m0.this.b()) {
                    m0.this.i();
                }
            } catch (Throwable th) {
            }
        }
    }

    public m0() {
        Context context = h;
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalStateException("Please invoke initial(context,...) first when app started!");
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context == null || context.getApplicationContext() == null) {
            throw new NullPointerException("context cannot be null!");
        }
        Context applicationContext = context.getApplicationContext();
        h = applicationContext;
        q2.a(applicationContext);
        o0.a(str);
        n0.a(str, str2);
        new a("th_loc_tmp").start();
    }

    public static void a(String str) {
        n0.f(str);
    }

    public static void a(HashMap<String, String> hashMap) {
        n0.a(hashMap);
    }

    public static m0 h() {
        m0 m0Var;
        synchronized (m0.class) {
            try {
                if (g == null) {
                    synchronized (m0.class) {
                        if (g == null) {
                            g = new m0();
                        }
                    }
                }
                m0Var = g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return m0Var;
    }

    @Override // c.t.m.g.e2
    public String a() {
        return "TxCC";
    }

    public final void a(long j) {
        Handler handler = this.e;
        b bVar = new b();
        long j2 = j;
        if (j < 0) {
            j2 = 0;
        }
        c3.a(handler, bVar, j2);
    }

    @Override // c.t.m.g.e2
    public void d() {
        try {
            n0.b().f();
            c3.b(this.e);
            a(0L);
            a3.a("th_loc_task_t_consume", 100L);
            this.e = null;
        } catch (Throwable th) {
        }
    }

    @Override // c.t.m.g.e2
    public int f() {
        this.e = new Handler(a3.b("th_loc_task_t_consume").getLooper());
        a(5000L);
        return 0;
    }

    public final long g() {
        long d = n0.b().d("cc_req_interval");
        long j = d;
        if (d > 86400000) {
            j = 86400000;
        }
        long j2 = j;
        if (j < 1800000) {
            j2 = 1800000;
        }
        return j2;
    }

    public final void i() {
        try {
            a(n0.b().c("cc_version") == -1 ? 10800000L : g());
        } catch (Throwable th) {
        }
    }
}
