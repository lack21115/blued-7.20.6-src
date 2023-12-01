package c.t.m.g;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/c0.class */
public class c0 extends d2 {

    /* renamed from: c  reason: collision with root package name */
    public LocationManager f3721c;
    public Handler d;
    public volatile Location f;
    public volatile int g = 2;
    public LocationListener h = new b();
    public Runnable e = new a();

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/c0$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (c0.this.d == null || c0.this.g == 0) {
                    return;
                }
                int i = c0.this.g;
                String str = LocationManager.PASSIVE_PROVIDER;
                if (i == 1) {
                    str = "gps";
                } else {
                    int unused = c0.this.g;
                }
                c0.this.f3721c.requestLocationUpdates(str, 1000L, 0.0f, c0.this.h, c0.this.d.getLooper());
            } catch (Throwable th) {
                j0.a("ArGpsProvider", "No Permission,can not add location listener", th);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/c0$b.class */
    public class b implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        public long f3723a = 0;

        public b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location != null) {
                try {
                    if ("gps".equals(location.getProvider())) {
                        if (i0.f3788a || Build.VERSION.SDK_INT < 18 || !location.isFromMockProvider()) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (Math.abs(currentTimeMillis - this.f3723a) < 1000) {
                                return;
                            }
                            this.f3723a = currentTimeMillis;
                            c0.this.f = location;
                            float speed = location.hasSpeed() ? location.getSpeed() : -1.0f;
                            if (b0.b() != null) {
                                b0.b().a(currentTimeMillis, speed);
                            }
                        }
                    }
                } catch (Throwable th) {
                    j0.a("ArGpsProvider", "onLocationChanged error.", th);
                }
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public c0() {
        this.f3721c = null;
        this.f3721c = (LocationManager) q2.a().getSystemService("location");
    }

    @Override // c.t.m.g.e2
    public String a() {
        return "ArGpsProvider";
    }

    public void a(int i) {
        this.g = i;
    }

    @Override // c.t.m.g.d2
    public int b(Looper looper) {
        Handler handler = new Handler(looper);
        this.d = handler;
        handler.post(this.e);
        j0.a("ArGpsProvider", "status:[start]");
        return 0;
    }

    @Override // c.t.m.g.e2
    public void d() {
        try {
            this.f3721c.removeUpdates(this.h);
        } catch (Throwable th) {
            j0.a("ArGpsProvider", "remove updates error.", th);
        }
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.d = null;
        j0.a("ArGpsProvider", "status:[shutdown]");
    }
}
