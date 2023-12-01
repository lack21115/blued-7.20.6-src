package a.a.a.a.a.k.d;

import a.a.a.a.a.e.h;
import a.a.a.a.a.k.c.a;
import android.accounts.AccountManager;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/d/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static Context f1370a;
    public static String b;
    public c f;
    public ArrayList<Float> g;
    public ArrayList<Float> h;
    public ArrayList<Float> i;
    public ArrayList<Float> j;
    public e k = new e();

    /* renamed from: c  reason: collision with root package name */
    public a f1371c = new a(this);
    public b d = new b();
    public d e = new d(this);

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/d/f$a.class */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f1372a;
        public long b;

        public a(f fVar) {
        }

        public final void a() {
            this.b = System.currentTimeMillis();
        }

        public void a(String str, String str2) {
            this.f1372a = str + "." + str2;
        }

        public String toString() {
            a();
            return f.a(this.f1372a) + "\t" + this.b + "\t" + f.a(f.b) + "\t" + f.a("3.0.0");
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/d/f$b.class */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f1373a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f1374c;
        public String d;
        public String e;

        public b() {
        }

        public void a(String str, String str2, String str3, String str4, String str5) {
            this.f1373a = str;
            this.b = str2;
            this.e = str3;
            this.f1374c = str4;
            this.d = str5;
        }

        public String toString() {
            return f.this.f1371c.toString() + "\t" + f.a(this.f1373a) + "\t" + f.a(this.b) + "\t" + f.a(this.f1374c) + "\t" + f.a(this.d) + "\t" + f.a(this.e);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/d/f$c.class */
    public final class c {

        /* renamed from: a  reason: collision with root package name */
        public int f1375a = 0;
        public long b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f1376c = 0;
        public int d = 0;
        public int e = 0;
        public int f = 0;
        public int g = 0;
        public int h = 0;
        public int i = 0;
        public int j = 0;
        public long k = 0;
        public long l = 0;
        public int m;

        public c(f fVar) {
        }

        public boolean a(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j3, long j4, int i9) {
            this.b = j;
            this.f1376c = j2;
            this.f1375a = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
            this.i = i7;
            this.j = i6;
            this.j = i8;
            this.k = j3;
            this.l = j4;
            this.m = i9;
            return true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.b + "\t");
            sb.append(this.f1376c + "\t");
            sb.append(this.f1375a + "\t");
            sb.append(this.d + "\t");
            sb.append(this.e + "\t");
            sb.append(this.f + "\t");
            sb.append(this.g + "\t");
            sb.append(this.h + "\t");
            sb.append(this.i + "\t");
            sb.append(this.j + "\t");
            sb.append(this.k + "\t");
            sb.append(this.l + "\t");
            sb.append(this.m);
            return sb.toString();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/d/f$d.class */
    public final class d {

        /* renamed from: a  reason: collision with root package name */
        public String f1377a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f1378c;
        public String d;
        public String e;

        public d(f fVar) {
        }

        public final void a() {
            this.f1377a = h.i();
            this.b = "Android";
            this.f1378c = h.j();
            this.d = h.i(f.f1370a);
            this.e = h.j(f.f1370a);
        }

        public String toString() {
            a();
            return f.a(this.f1377a) + "\t" + f.a(this.b) + "\t" + f.a(this.f1378c) + "\t" + f.a(this.d) + "\t" + f.a(this.e);
        }
    }

    public static String a(String str) {
        return (str == null || "".equals(str)) ? Constants.ACCEPT_TIME_SEPARATOR_SERVER : str;
    }

    public final float a(ArrayList<Float> arrayList) {
        float f;
        float f2 = 0.0f;
        if (arrayList != null) {
            f2 = 0.0f;
            if (!arrayList.isEmpty()) {
                Iterator<Float> it = arrayList.iterator();
                float f3 = 0.0f;
                while (true) {
                    f = f3;
                    if (!it.hasNext()) {
                        break;
                    }
                    f3 = f + it.next().floatValue();
                }
                f2 = f / arrayList.size();
            }
        }
        return f2;
    }

    public final String a(int i, int i2) {
        float a2 = a(this.g);
        float a3 = a(this.h);
        float a4 = a(this.i);
        float a5 = a(this.j);
        int h = a.a.a.a.a.k.c.a.h();
        return this.e.toString() + "\t" + String.format("%.3f", Float.valueOf(a2)) + "\t" + String.format("%.3f", Float.valueOf(a3)) + "\t" + String.format("%.3f", Float.valueOf(a4)) + "\t" + String.format("%.3f", Float.valueOf(a5)) + "\tlibrtmp-1.1.0;PLDroidCameraStreaming-3.0.0\t" + h + "\t" + i() + "\t0\t0\t0\t" + a((String) null) + "\t" + i + "\t" + i2;
    }

    public void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        f1370a = applicationContext;
        this.k.a(applicationContext);
        b = h.k(f1370a);
    }

    public void a(Intent intent) {
        String stringExtra = intent.getStringExtra("videoEncoderType");
        String stringExtra2 = intent.getStringExtra("audioEncoderType");
        int intExtra = intent.getIntExtra("videoFps", -1);
        int intExtra2 = intent.getIntExtra("audioFps", -1);
        long longExtra = intent.getLongExtra("gopTime", -1L);
        int intExtra3 = intent.getIntExtra("tcpConnect", 0);
        int intExtra4 = intent.getIntExtra("rtmpConnect", 0);
        int intExtra5 = intent.getIntExtra("firstByte", 0);
        this.f1371c.a("stream_start", com.anythink.expressad.foundation.g.a.i);
        String str = this.d.toString() + "\t" + a(stringExtra) + "\t" + a(stringExtra2) + "\t" + intExtra + "\t" + intExtra2 + "\t" + longExtra + "\t" + intExtra3 + "\t" + intExtra4 + "\t" + intExtra5 + "\n";
        d(str);
        c(str);
    }

    public void b(Intent intent) {
        long longExtra = intent.getLongExtra("beginAt", 0L);
        long longExtra2 = intent.getLongExtra("endAt", 0L);
        long longExtra3 = intent.getLongExtra("gopTime", -1L);
        int intExtra = intent.getIntExtra("videoSendFrames", -1);
        int intExtra2 = intent.getIntExtra("videoDroppedFrames", -1);
        int intExtra3 = intent.getIntExtra("audioSendFrames", -1);
        int intExtra4 = intent.getIntExtra("audioDroppedFrames", -1);
        long longExtra4 = intent.getLongExtra("totalSendBytes", -1L);
        int intExtra5 = intent.getIntExtra("tcpFullTime", 0);
        int intExtra6 = intent.getIntExtra(AccountManager.KEY_ERROR_CODE, 0);
        int intExtra7 = intent.getIntExtra("errorOSCode", 0);
        this.f1371c.a("stream_end", com.anythink.expressad.foundation.g.a.i);
        String str = this.d.toString() + "\t" + longExtra + "\t" + longExtra2 + "\t" + longExtra3 + "\t" + intExtra + "\t" + intExtra2 + "\t" + intExtra3 + "\t" + intExtra4 + "\t" + longExtra4 + "\t" + intExtra5 + "\t" + a(intExtra6, intExtra7) + "\n";
        d(str);
        c(str);
        a.a.a.a.a.k.b.b();
    }

    public void c() {
        this.k.b();
    }

    public final void c(String str) {
        this.k.b(str);
    }

    public b d() {
        return this.d;
    }

    public final void d(String str) {
        this.k.a(str);
    }

    public void e() {
        j();
    }

    public void f() {
        k();
    }

    public c g() {
        if (this.f == null) {
            this.f = new c(this);
        }
        return this.f;
    }

    public void h() {
        this.f1371c.a(Instrumentation.REPORT_KEY_STREAMRESULT, com.anythink.expressad.foundation.g.a.i);
        d(this.d.toString() + "\t" + this.f.toString() + "\n");
    }

    public final String i() {
        String[] g;
        String str;
        int parseInt;
        String str2;
        String b2 = a.a.a.a.a.k.c.a.b(f1370a);
        String a2 = a.a.a.a.a.k.c.a.a();
        String d2 = a.a.a.a.a.k.c.a.d();
        boolean equals = b2.equals("WIFI");
        boolean equals2 = b2.equals("None");
        int i = 0;
        if (equals) {
            String[] f = a.a.a.a.a.k.c.a.f(f1370a);
            if (f != null && f.length >= 2) {
                str2 = f[0];
                i = 0;
                if (h.d(f[1])) {
                    i = Integer.parseInt(f[1]);
                }
                parseInt = 0;
                str = null;
                return a(b2) + "\t" + a(a2) + "\t" + a(d2) + "\t" + a(str2) + "\t" + a(str) + "\t" + i + "\t" + parseInt;
            }
            str = null;
        } else {
            if (!equals2 && (g = a.a.a.a.a.k.c.a.g(f1370a)) != null && g.length >= 2) {
                String str3 = g[0];
                str = str3;
                if (h.d(g[1])) {
                    parseInt = Integer.parseInt(g[1]);
                    str = str3;
                    str2 = null;
                    return a(b2) + "\t" + a(a2) + "\t" + a(d2) + "\t" + a(str2) + "\t" + a(str) + "\t" + i + "\t" + parseInt;
                }
            }
            str = null;
        }
        parseInt = 0;
        str2 = null;
        return a(b2) + "\t" + a(a2) + "\t" + a(d2) + "\t" + a(str2) + "\t" + a(str) + "\t" + i + "\t" + parseInt;
    }

    public final void j() {
        this.f1371c.a("network_change", com.anythink.expressad.foundation.g.a.i);
        c(this.f1371c.toString() + "\t" + this.e.toString() + "\t" + i() + "\n");
    }

    public final void k() {
        float f;
        a.C0014a e = a.a.a.a.a.k.c.a.e();
        a.b a2 = a.a.a.a.a.k.c.a.a(f1370a);
        float f2 = e.f1352a / 100.0f;
        float f3 = e.b / 100.0f;
        long j = a2.f1353a;
        float f4 = 0.0f;
        if (j != 0) {
            float f5 = (float) a2.b;
            float f6 = (float) j;
            f4 = f5 / f6;
            f = ((float) a2.f1354c) / f6;
        } else {
            f = 0.0f;
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        if (this.h == null) {
            this.h = new ArrayList<>();
        }
        if (this.i == null) {
            this.i = new ArrayList<>();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.g.add(Float.valueOf(f2));
        this.h.add(Float.valueOf(f3));
        this.i.add(Float.valueOf(f4));
        this.j.add(Float.valueOf(f));
    }
}
