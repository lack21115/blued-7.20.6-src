package c.t.m.g;

import android.location.Location;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/k6.class */
public class k6 {
    public static volatile k6 g;

    /* renamed from: a  reason: collision with root package name */
    public d4 f3819a;
    public TencentLocationManager b;

    /* renamed from: c  reason: collision with root package name */
    public t3 f3820c;
    public l6 d;
    public l6 e;
    public final TencentLocationListener f;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/k6$a.class */
    public class a implements TencentLocationListener {
        public a() {
        }

        @Override // com.tencent.map.geolocation.TencentLocationListener
        public void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
            g3.b("SDK", String.format(Locale.ENGLISH, "callback,%d,%s,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f", Integer.valueOf(i), tencentLocation.getProvider(), Double.valueOf(tencentLocation.getLatitude()), Double.valueOf(tencentLocation.getLongitude()), Double.valueOf(tencentLocation.getAltitude()), Float.valueOf(tencentLocation.getAccuracy()), Float.valueOf(tencentLocation.getBearing()), Float.valueOf(tencentLocation.getSpeed())));
            if (k6.this.d == l6.k) {
                k6.this.d = new l6(tencentLocation);
            } else {
                k6.this.d.a(tencentLocation);
            }
            k6.this.d.a(i);
        }

        @Override // com.tencent.map.geolocation.TencentLocationListener
        public void onStatusUpdate(String str, int i, String str2) {
        }
    }

    public k6(t3 t3Var) {
        l6 l6Var = l6.k;
        this.d = l6Var;
        this.e = l6Var;
        this.f = new a();
        this.f3820c = t3Var;
        this.f3819a = t3Var.c().a();
        this.b = TencentLocationManager.getInstance(t3Var.f3944a);
    }

    public static k6 a(t3 t3Var) {
        if (g == null) {
            synchronized (k6.class) {
                try {
                    if (g == null) {
                        g = new k6(t3Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return g;
    }

    public int a(int i) {
        if (this.f3820c.h()) {
            int startDrEngine = this.f3819a.startDrEngine(i);
            if (this.f3819a.a()) {
                c();
            }
            return startDrEngine;
        }
        return -1;
    }

    public TencentLocation a() {
        double[] position = this.f3819a.getPosition();
        if (position != null && p2.a(position[1], position[2])) {
            Location location = new Location("gps");
            location.setLatitude(position[1]);
            location.setLongitude(position[2]);
            double[] dArr = new double[2];
            f6.a(location, dArr);
            position[1] = dArr[0];
            position[2] = dArr[1];
        }
        i6 i6Var = new i6(position);
        l6 l6Var = this.e;
        if (l6Var == l6.k) {
            this.e = new l6(i6Var);
        } else {
            l6Var.a(i6Var);
        }
        g3.b("DR", String.format(Locale.ENGLISH, "update,%d,%s,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f", Integer.valueOf(this.e.b()), this.e.getProvider(), Double.valueOf(this.e.getLatitude()), Double.valueOf(this.e.getLongitude()), Double.valueOf(this.e.getAltitude()), Float.valueOf(this.e.getAccuracy()), Float.valueOf(this.e.getBearing()), Float.valueOf(this.e.getSpeed())));
        if (this.e.b() == 0) {
            g3.b("TxDR", "callback,DR");
            l6 l6Var2 = new l6(this.d);
            l6Var2.a(i6Var);
            return l6Var2;
        } else if (this.d.b() == 0) {
            g3.b("TxDR", "callback,SDK");
            return new l6(this.d);
        } else {
            g3.b("TxDR", "callback,ERR");
            return l6.k;
        }
    }

    public boolean b() {
        if (this.f3820c.h()) {
            return this.f3819a.isSupport();
        }
        return false;
    }

    public final void c() {
        TencentLocationRequest interval = TencentLocationRequest.create().setInterval(1000L);
        interval.setAllowGPS(true);
        int requestLocationUpdates = this.b.requestLocationUpdates(interval, this.f);
        g3.b("SDK", "register " + requestLocationUpdates);
    }

    public void d() {
        this.b.removeUpdates(this.f);
        this.f3819a.terminateDrEngine();
    }
}
