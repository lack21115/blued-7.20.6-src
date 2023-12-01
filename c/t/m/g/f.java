package c.t.m.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/f.class */
public class f extends c2 {
    public volatile Handler e = null;
    public volatile b f = new b();
    public StringBuilder g = new StringBuilder();
    public AtomicInteger h = new AtomicInteger(0);

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/f$b.class */
    public static class b implements t1, Runnable {

        /* renamed from: a  reason: collision with root package name */
        public volatile String f3758a;
        public volatile int b;

        public b() {
            this.b = 0;
        }

        @Override // c.t.m.g.t1
        public void a(String str) {
            g3.a();
        }

        public void a(String str, int i) {
            if (m3.a(str)) {
                this.f3758a = "";
            } else {
                this.f3758a = str;
            }
            this.b = i;
        }

        public final void a(byte[] bArr) {
            byte[] a2 = r2.a(bArr);
            byte[] a3 = o2.a(a2.length);
            byte[] bArr2 = new byte[a3.length + 1 + a2.length];
            bArr2[0] = 1;
            System.arraycopy(a3, 0, bArr2, 1, a3.length);
            System.arraycopy(a2, 0, bArr2, a3.length + 1, a2.length);
            byte[] a4 = v2.a(bArr2, v2.a("fc_gps_for_navi"));
            if (g3.a()) {
                int length = bArr.length;
                int length2 = a4.length;
            }
            u1.f3957a.a("https://rttgpsreport.map.qq.com/report?type=sdk&key=5e1fe70424035ee83066ac22b24f31dc", a4, this);
        }

        @Override // c.t.m.g.t1
        public void b(String str) {
            g3.a("FC", "NaviGps," + this.b);
            g3.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (m3.a(this.f3758a)) {
                    return;
                }
                byte[] bytes = this.f3758a.getBytes("UTF-8");
                this.f3758a = "";
                a(bytes);
            } catch (Throwable th) {
                g3.a();
            }
        }
    }

    @Override // c.t.m.g.f2
    public int a(Looper looper) {
        c3.a(d(), 1001, 5000L);
        this.e = new Handler(a3.b("th_loc_task_t_consume").getLooper());
        this.g.setLength(0);
        this.h.set(0);
        return 0;
    }

    @Override // c.t.m.g.f2
    public String a() {
        return "GpsNaviPro";
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008b, code lost:
        if ("0123456789ABCDEF".equals(r0) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r11, android.location.Location r12) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.f.a(int, android.location.Location):void");
    }

    @Override // c.t.m.g.c2
    public void a(Message message) throws Exception {
        String sb;
        if (message.what != 1001) {
            return;
        }
        c3.a(d(), 1001);
        c3.a(d(), 1001, 5000L);
        int i = this.h.get();
        synchronized (this.b) {
            sb = this.g.toString();
            this.g.setLength(0);
            this.h.set(0);
        }
        if (sb.length() <= 0 || this.e == null) {
            return;
        }
        this.f.a(sb, i);
        c3.a(this.e, this.f);
    }

    @Override // c.t.m.g.f2
    public void c() {
        this.g.setLength(0);
        this.h.set(0);
        this.f.a("", 0);
        this.e = null;
        a3.a("th_loc_task_t_consume");
    }
}
