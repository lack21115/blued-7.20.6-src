package com.opos.cmn.an.e;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import com.opos.cmn.an.e.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/e/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f10810a;

    /* renamed from: c  reason: collision with root package name */
    private Context f10811c;
    private volatile CountDownLatch f;
    private volatile LocationManager g;
    private volatile b h;
    private volatile long i;
    private volatile b j;
    private LocationListener b = new LocationListener() { // from class: com.opos.cmn.an.e.c.1
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            com.opos.cmn.an.f.a.b("LocationManager", "location onLocationChanged location");
            if (location != null) {
                c.this.a(location);
                CountDownLatch countDownLatch = c.this.f;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("LocationListener onProviderDisabled provider=");
            if (str == null) {
                str = com.igexin.push.core.b.l;
            }
            sb.append(str);
            com.opos.cmn.an.f.a.b("LocationManager", sb.toString());
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("LocationListener onProviderEnabled provider=");
            if (str == null) {
                str = com.igexin.push.core.b.l;
            }
            sb.append(str);
            com.opos.cmn.an.f.a.b("LocationManager", sb.toString());
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            StringBuilder sb = new StringBuilder();
            sb.append("LocationListener onStatusChanged provider=");
            if (str == null) {
                str = com.igexin.push.core.b.l;
            }
            sb.append(str);
            sb.append(",status=");
            sb.append(i);
            sb.append(",extras=");
            String str2 = com.igexin.push.core.b.l;
            if (bundle != null) {
                str2 = bundle.toString();
            }
            sb.append(str2);
            com.opos.cmn.an.f.a.b("LocationManager", sb.toString());
        }
    };
    private LocationListener k = new LocationListener() { // from class: com.opos.cmn.an.e.c.2
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            com.opos.cmn.an.f.a.b("LocationManager", "passive onLocationChanged location");
            if (location != null) {
                c.this.a(location);
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
    };
    private a e = new a(new a.b() { // from class: com.opos.cmn.an.e.c.3
        @Override // com.opos.cmn.an.e.a.b
        public void a(final a.InterfaceC0448a interfaceC0448a) {
            com.opos.cmn.an.j.b.d(new Runnable() { // from class: com.opos.cmn.an.e.c.3.1
                @Override // java.lang.Runnable
                public void run() {
                    com.opos.cmn.an.f.a.b("LocationManager", "init");
                    try {
                        c.this.a(interfaceC0448a);
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("LocationManager", "init fail", e);
                    }
                }
            });
        }
    });
    private a d = new a(new a.b() { // from class: com.opos.cmn.an.e.c.4
        @Override // com.opos.cmn.an.e.a.b
        public void a(final a.InterfaceC0448a interfaceC0448a) {
            com.opos.cmn.an.j.b.d(new Runnable() { // from class: com.opos.cmn.an.e.c.4.1
                @Override // java.lang.Runnable
                public void run() {
                    com.opos.cmn.an.f.a.b("LocationManager", "locate");
                    try {
                        c.this.b(interfaceC0448a);
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("LocationManager", "locate fail", e);
                    }
                }
            });
        }
    });

    private c() {
    }

    public static c a() {
        c cVar = f10810a;
        if (cVar != null) {
            return cVar;
        }
        synchronized (c.class) {
            try {
                if (f10810a == null) {
                    f10810a = new c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f10810a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        com.opos.cmn.an.f.a.b("LocationManager", "reset location provider:" + location.getProvider());
        if ("gps".equals(location.getProvider())) {
            b bVar = this.h;
            if (bVar == null || bVar.a() < location.getElapsedRealtimeNanos()) {
                this.h = b(location);
            }
        } else if (!"network".equals(location.getProvider())) {
            com.opos.cmn.an.f.a.b("LocationManager", "location with unexpected provider");
        } else {
            b bVar2 = this.j;
            if (bVar2 == null || bVar2.a() < location.getElapsedRealtimeNanos()) {
                this.j = b(location);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.InterfaceC0448a interfaceC0448a) {
        LocationManager g;
        if (f() && (g = g()) != null) {
            Location lastKnownLocation = g.getLastKnownLocation("gps");
            if (lastKnownLocation != null) {
                a(lastKnownLocation);
            }
            Location lastKnownLocation2 = g.getLastKnownLocation("network");
            if (lastKnownLocation2 != null) {
                a(lastKnownLocation2);
            }
            if (j()) {
                g.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 60000L, 50.0f, this.k, Looper.getMainLooper());
                interfaceC0448a.a();
                return;
            }
        }
        interfaceC0448a.b();
    }

    private static final boolean a(b bVar) {
        if (bVar == null) {
            return true;
        }
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() - bVar.a();
        com.opos.cmn.an.f.a.b("LocationManager", "internal :" + elapsedRealtimeNanos);
        return elapsedRealtimeNanos > 300000000000L;
    }

    private double[] a(b bVar, double[] dArr) {
        dArr[0] = ((int) (bVar.b() * 10000.0d)) / 10000.0d;
        dArr[1] = ((int) (bVar.c() * 10000.0d)) / 10000.0d;
        return dArr;
    }

    private b b(Location location) {
        return new b(location.getLatitude(), location.getLongitude(), location.getElapsedRealtimeNanos());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a.InterfaceC0448a interfaceC0448a) {
        if (f() && this.f10811c != null) {
            b bVar = this.h;
            com.opos.cmn.an.f.a.b("LocationManager", "gps:" + this.i);
            if (a(bVar) && this.i + 180000 < SystemClock.elapsedRealtime()) {
                d();
            }
            if (this.f10811c != null) {
                if (a(this.j)) {
                    e();
                }
                interfaceC0448a.a();
                return;
            }
        }
        interfaceC0448a.b();
    }

    private void d() {
        com.opos.cmn.an.f.a.b("LocationManager", "locate gps");
        LocationManager g = g();
        if (g != null && h()) {
            this.i = SystemClock.elapsedRealtime();
            g.requestLocationUpdates("gps", 60000L, 1.0f, this.b, Looper.getMainLooper());
            this.f = new CountDownLatch(1);
            try {
                try {
                    this.f.await(60000L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("LocationManager", "await fail", e);
                }
                com.opos.cmn.an.f.a.b("LocationManager", "remove locate gps");
                g.removeUpdates(this.b);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.b("LocationManager", "remove locate gps");
                g.removeUpdates(this.b);
                throw th;
            }
        }
    }

    private void e() {
        com.opos.cmn.an.f.a.b("LocationManager", "locate net");
        LocationManager g = g();
        if (g != null && i()) {
            g.requestLocationUpdates("network", 10000L, 1.0f, this.b, Looper.getMainLooper());
            this.f = new CountDownLatch(1);
            try {
                try {
                    this.f.await(10000L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("LocationManager", "await fail", e);
                }
                com.opos.cmn.an.f.a.b("LocationManager", "remove locate net");
                g.removeUpdates(this.b);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.b("LocationManager", "remove locate net");
                g.removeUpdates(this.b);
                throw th;
            }
        }
    }

    private boolean f() {
        return this.f10811c.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 && this.f10811c.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    private LocationManager g() {
        Context context;
        if (this.g == null && (context = this.f10811c) != null) {
            this.g = (LocationManager) context.getSystemService("location");
        }
        return this.g;
    }

    private boolean h() {
        boolean z;
        try {
            z = g().isProviderEnabled("gps");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("LocationManager", "", (Throwable) e);
            z = false;
        }
        com.opos.cmn.an.f.a.b("LocationManager", "isGpsProviderEnabled =" + z);
        return z;
    }

    private boolean i() {
        boolean z;
        try {
            z = g().isProviderEnabled("network");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("LocationManager", "", (Throwable) e);
            z = false;
        }
        com.opos.cmn.an.f.a.b("LocationManager", "isNetProviderEnabled =" + z);
        return z;
    }

    private boolean j() {
        boolean z;
        try {
            z = g().isProviderEnabled(LocationManager.PASSIVE_PROVIDER);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("LocationManager", "", (Throwable) e);
            z = false;
        }
        com.opos.cmn.an.f.a.b("LocationManager", "isPassiveProviderEnabled =" + z);
        return z;
    }

    public void a(Context context) {
        if (context != null && this.f10811c == null) {
            synchronized (this) {
                if (this.f10811c == null) {
                    this.f10811c = context.getApplicationContext();
                }
            }
            this.e.a();
        }
    }

    public void b() {
        com.opos.cmn.an.f.a.b("LocationManager", "destroy");
        if (this.f10811c == null) {
            return;
        }
        try {
            LocationManager g = f() ? g() : null;
            this.f10811c = null;
            CountDownLatch countDownLatch = this.f;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            if (g != null) {
                g.removeUpdates(this.k);
                g.removeUpdates(this.b);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("LocationManager", "", (Throwable) e);
        }
    }

    public double[] c() {
        com.opos.cmn.an.f.a.b("LocationManager", "obtainLocation");
        double[] dArr = {0.0d, 0.0d};
        if (this.f10811c == null) {
            return dArr;
        }
        b bVar = this.h;
        b bVar2 = this.j;
        if (a(bVar) || a(bVar2)) {
            this.d.a();
        }
        if (a(bVar)) {
            if (a(bVar2) && (bVar == null || bVar2 == null || bVar2.a() <= bVar.a() + 300000000000L)) {
                if (bVar == null) {
                    if (bVar2 == null) {
                        return dArr;
                    }
                }
            }
            return a(bVar2, dArr);
        }
        return a(bVar, dArr);
    }
}
