package c.t.m.g;

import android.content.SharedPreferences;
import c.t.m.g.d3;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/r0.class */
public class r0 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f3955a = true;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/r0$a.class */
    public static final class a extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Timer f3956a;

        public a(Timer timer) {
            this.f3956a = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a3.a("th_loc_task_t_consume", new b(null));
            this.f3956a.cancel();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/r0$b.class */
    public static class b implements Runnable {

        /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/r0$b$a.class */
        public class a implements d3.c {
            public a(b bVar) {
            }

            @Override // c.t.m.g.d3.c
            public void a(String str) {
            }

            @Override // c.t.m.g.d3.c
            public void b(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.getInt("status") == 0) {
                        String string = jSONObject.getString("version");
                        String a2 = w2.a(jSONObject.getString("key"));
                        x2.a(l2.a(a2), string);
                        SharedPreferences a3 = p3.a();
                        p3.b(a3, "loc_comm_rsa_pub_key_ver", (Object) string);
                        p3.b(a3, "loc_comm_rsa_pub_key_64", (Object) a2);
                        p3.b(a3, "loc_comm_rsa_key_update_time", Long.valueOf(System.currentTimeMillis()));
                    }
                } catch (Throwable th) {
                }
            }
        }

        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r0.f3955a) {
                d3.a("https://cs.map.qq.com/key", new a(this));
            }
        }
    }

    public static void b() {
        SharedPreferences a2 = p3.a();
        long longValue = ((Long) p3.a(a2, "loc_comm_rsa_key_update_time", (Object) 0L)).longValue();
        if (longValue != 0) {
            x2.a(l2.a((String) p3.a(a2, "loc_comm_rsa_pub_key_64", (Object) "")), (String) p3.a(a2, "loc_comm_rsa_pub_key_ver", (Object) ""));
        }
        if (Math.abs(System.currentTimeMillis() - longValue) < 259200000) {
            return;
        }
        Timer timer = new Timer();
        timer.schedule(new a(timer), 5000L);
    }
}
