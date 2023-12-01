package c.t.m.g;

import android.content.Context;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.Pair;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/b.class */
public class b {
    public static volatile b o;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public e f3754c;
    public HandlerThread d;
    public volatile Location e;
    public volatile Location f;
    public volatile List<d> g;
    public volatile d h;
    public volatile List<ScanResult> i;
    public LruCache<String, Pair<Double, Double>> j;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f3753a = new byte[0];
    public long k = 180000;
    public long l = 0;
    public long m = 0;
    public long n = 0;

    public b(Context context) {
        Context applicationContext = context == null ? null : context.getApplicationContext();
        this.b = applicationContext;
        if (applicationContext == null) {
            throw new IllegalArgumentException("context cannot be null!");
        }
        q2.a(context);
        this.j = new LruCache<>(100);
        String str = "";
        try {
            if (!j.f3844a) {
                str = "";
                if (!j.b) {
                    str = z2.a(this.b, "data").getAbsolutePath();
                }
            }
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = this.b.getFilesDir().getAbsolutePath() + "/data/";
            }
            if (!TextUtils.isEmpty(str2)) {
                this.f3754c = new e(this.b, str2);
                e();
            }
            o = this;
        } catch (Throwable th) {
            this.f3754c = null;
        }
    }

    public static b a() {
        return o;
    }

    public static String b() {
        return "1.7.6_220414";
    }

    public final Location a(Location location, Location location2) {
        Location location3 = location;
        if (location == null) {
            location3 = new Location("gps");
        }
        if (location2 != null) {
            location3.set(location2);
        }
        return location3;
    }

    public void a(int i, long j, Object obj) {
        synchronized (this.f3753a) {
            try {
                this.f3754c.a(i, j, obj);
            }
        }
    }

    public void a(int i, Location location) {
        synchronized (this.f3753a) {
            if (c()) {
                if (location != null && "gps".equals(location.getProvider())) {
                    if (j.h || Build.VERSION.SDK_INT < 18 || !location.isFromMockProvider()) {
                        if (this.f3754c != null) {
                            this.f3754c.a(i, location);
                        }
                        if (!k3.a(location.getAltitude(), 0.0d) || !k3.a(location.getSpeed(), 0.0d)) {
                            this.e = a(this.e, location);
                            if (this.f == null || (this.e != null && this.e.distanceTo(this.f) >= 50.0f && System.currentTimeMillis() - this.n >= 5000)) {
                                g();
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(long j, int i, double d, double d2, double d3) {
        synchronized (this.f3753a) {
            if (c()) {
                g3.a();
                if (this.f3754c != null) {
                    this.f3754c.a(j, i, d, d2, d3);
                }
            }
        }
    }

    @Deprecated
    public void a(Location location) {
        a(0, location);
    }

    public void a(Looper looper) {
        synchronized (this.f3753a) {
            d();
            if (this.f3754c != null) {
                Looper looper2 = looper;
                if (looper == null) {
                    HandlerThread b = a3.b("th_loc_extra");
                    this.d = b;
                    looper2 = b.getLooper();
                }
                this.f3754c.a(looper2);
            }
        }
    }

    public void a(c cVar) {
        synchronized (this.f3753a) {
            j.i = cVar;
            if (g3.a()) {
                cVar.f();
                cVar.b();
                cVar.c();
                cVar.d();
                cVar.e();
            }
        }
    }

    public void a(d dVar, List<d> list) {
        synchronized (this.f3753a) {
            if (c()) {
                ArrayList arrayList = new ArrayList();
                for (d dVar2 : list) {
                    if (i.a(dVar2.f, dVar2.f3781a, dVar2.b, dVar2.f3782c, dVar2.e)) {
                        if (a(dVar2.f3782c + BridgeUtil.UNDERLINE_STR + dVar2.e, this.e)) {
                            arrayList.add(dVar2);
                        }
                    }
                }
                this.g = arrayList;
                this.l = System.currentTimeMillis();
                if (dVar != null && !dVar.equals(this.h)) {
                    this.h = dVar;
                    g();
                }
            }
        }
    }

    public void a(String str, String str2) {
        synchronized (this.f3753a) {
            if (this.f3754c == null || m3.a(str2)) {
                return;
            }
            g3.a();
            if ("D_CH_ID".equals(str)) {
                k.a(str2);
            } else if ("D_FC_SRC".equals(str)) {
                k.b(str2);
            } else if ("D_POS_COLL".equals(str)) {
                j.f3845c = Boolean.parseBoolean(str2.toLowerCase());
            } else if ("D_WRITE_MAC".equals(str)) {
                j.d = Boolean.parseBoolean(str2.toLowerCase());
            } else if ("D_UP_NET".equals(str)) {
                if ("m".equals(str2.toLowerCase())) {
                    j.f = true;
                } else if (IAdInterListener.AdReqParam.WIDTH.equals(str2.toLowerCase())) {
                    j.f = false;
                    j.g = false;
                } else if ("w_m1".equals(str2.toLowerCase())) {
                    j.f = false;
                    j.g = true;
                }
            } else if ("D_EXTRA_SET_SN".equals(str)) {
                if (m3.a(str2)) {
                    str2 = "";
                }
                m.f3878a = str2;
            } else {
                this.f3754c.a(str, str2);
            }
        }
    }

    public void a(List<ScanResult> list) {
        long currentTimeMillis;
        boolean a2;
        synchronized (this.f3753a) {
            if (c()) {
                try {
                    currentTimeMillis = System.currentTimeMillis();
                    a2 = n.a(this.i, list);
                    g3.a();
                } catch (Throwable th) {
                }
                if (!a2 || currentTimeMillis - this.m <= 30000) {
                    if (this.f3754c != null) {
                        this.f3754c.a(list);
                    }
                    if (this.f3754c != null && this.e != null && !m3.a((Collection) list)) {
                        if (list.size() == 1) {
                            if ("123456789abc".equals(list.get(0).BSSID.toLowerCase())) {
                                return;
                            }
                        } else if (list.size() > 1 && n.a(list)) {
                            return;
                        }
                        if (j.f && currentTimeMillis - this.m < 5000) {
                            return;
                        }
                        if (!a2) {
                            this.m = currentTimeMillis;
                            this.i = list;
                        }
                        this.f3754c.a(this.e, list, currentTimeMillis - this.l < this.k ? this.g : null);
                    }
                }
            }
        }
    }

    public final boolean a(String str, Location location) {
        boolean z = false;
        if (!m3.a(str)) {
            z = false;
            if (location != null) {
                z = false;
                if (location.getLatitude() != 0.0d) {
                    if (location.getLongitude() == 0.0d) {
                        return false;
                    }
                    Pair<Double, Double> pair = this.j.get(str);
                    if (pair == null) {
                        this.j.put(str, Pair.create(Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
                        return true;
                    }
                    z = false;
                    if (f3.a(location.getLatitude(), location.getLongitude(), pair.first.doubleValue(), pair.second.doubleValue()) < 6000.0d) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public boolean c() {
        e eVar = this.f3754c;
        if (eVar == null) {
            return false;
        }
        return eVar.b();
    }

    public final void d() {
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.l = 0L;
        this.m = 0L;
        this.n = 0L;
        this.j.evictAll();
    }

    public final void e() {
        for (Map.Entry<String, String> entry : j.a().entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    public void f() {
        synchronized (this.f3753a) {
            if (this.f3754c != null && this.f3754c.b()) {
                this.f3754c.c();
            }
            if (this.d != null) {
                a3.a("th_loc_extra", 300L);
                this.d = null;
            }
            d();
        }
    }

    public final void g() {
        if (!m3.b(this.f3754c, this.e) || m3.a((Collection) this.g)) {
            return;
        }
        if (j.f && n.a(this.b) == 3) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.l < this.k) {
            this.n = currentTimeMillis;
            this.f = a(this.f, this.e);
            this.f3754c.a(this.e, (List<ScanResult>) null, this.g);
        }
    }
}
