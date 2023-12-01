package c.t.m.g;

import android.location.GnssMeasurementsEvent;
import android.location.GnssNavigationMessage;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Looper;
import android.os.Message;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/q0.class */
public class q0 extends c2 {
    public int e = 0;
    public volatile g f = g.f3942a;
    public LocationManager g = null;
    public Object h;
    public Object i;
    public Object j;
    public Object k;
    public Object l;
    public Object m;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/q0$a.class */
    public class a extends GnssMeasurementsEvent.Callback {
        public a() {
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
            q0.this.f.a(gnssMeasurementsEvent);
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onStatusChanged(int i) {
            q0.this.f.a(i);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/q0$b.class */
    public class b extends GnssNavigationMessage.Callback {
        public b() {
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onGnssNavigationMessageReceived(GnssNavigationMessage gnssNavigationMessage) {
            q0.this.f.b(gnssNavigationMessage);
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onStatusChanged(int i) {
            q0.this.f.b(i);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/q0$c.class */
    public class c extends GnssStatus.Callback {
        public c() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
            q0.this.f.c(i);
            q0.this.f.d(3);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            q0.this.f.c(gnssStatus);
            q0.this.f.d(4);
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            q0.this.f.a();
            q0.this.f.d(1);
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            q0.this.f.b();
            q0.this.f.d(2);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/q0$d.class */
    public class d implements GpsStatus.Listener {
        public d() {
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            q0.this.f.d(i);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/q0$e.class */
    public class e implements OnNmeaMessageListener {
        public e() {
        }

        @Override // android.location.OnNmeaMessageListener
        public void onNmeaMessage(String str, long j) {
            q0.this.f.a(j, str);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/q0$f.class */
    public class f implements GpsStatus.NmeaListener {
        public f() {
        }

        @Override // android.location.GpsStatus.NmeaListener
        public void onNmeaReceived(long j, String str) {
            q0.this.f.a(j, str);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/q0$g.class */
    public static abstract class g {

        /* renamed from: a  reason: collision with root package name */
        public static final g f3942a = new a();

        /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/q0$g$a.class */
        public static final class a extends g {
        }

        public void a() {
        }

        public void a(int i) {
        }

        public void a(long j, String str) {
        }

        public void a(Object obj) {
        }

        public void b() {
        }

        public void b(int i) {
        }

        public void b(Object obj) {
        }

        public void c(int i) {
        }

        public void c(Object obj) {
        }

        public void d(int i) {
        }
    }

    @Override // c.t.m.g.f2
    public int a(Looper looper) {
        if (this.f != g.f3942a) {
            LocationManager locationManager = (LocationManager) q2.a().getSystemService("location");
            this.g = locationManager;
            if (locationManager == null) {
                return -1;
            }
            i();
            h();
            if (Build.VERSION.SDK_INT >= 24) {
                if ((this.e & 8) != 0) {
                    a aVar = new a();
                    this.m = aVar;
                    this.g.registerGnssMeasurementsCallback(aVar, d());
                }
                if ((this.e & 16) != 0) {
                    b bVar = new b();
                    this.l = bVar;
                    this.g.registerGnssNavigationMessageCallback(bVar, d());
                    return 0;
                }
                return 0;
            }
            return 0;
        }
        throw new IllegalStateException("Please invoke startup(GpsRequest,GpsInfoCallback,Looper).");
    }

    @Override // c.t.m.g.f2
    public String a() {
        return "GpsExtraInfoPro";
    }

    public void a(int i, g gVar, Looper looper) {
        synchronized (this.b) {
            this.e = i;
            this.f = gVar;
            b(looper);
        }
    }

    @Override // c.t.m.g.c2
    public void a(Message message) {
    }

    @Override // c.t.m.g.f2
    public void c() {
        if (this.g != null) {
            k();
            j();
            if (Build.VERSION.SDK_INT >= 24) {
                if ((this.e & 8) != 0) {
                    this.g.unregisterGnssMeasurementsCallback((GnssMeasurementsEvent.Callback) this.m);
                    this.m = null;
                }
                if ((this.e & 16) != 0) {
                    this.g.unregisterGnssNavigationMessageCallback((GnssNavigationMessage.Callback) this.l);
                    this.l = null;
                }
            }
        }
        this.e = 0;
        this.f = g.f3942a;
        this.g = null;
    }

    public final void h() {
        if ((this.e & 4) == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            e eVar = new e();
            this.k = eVar;
            this.g.addNmeaListener(eVar, d());
            return;
        }
        f fVar = new f();
        this.i = fVar;
        o3.a(this.g, "addNmeaListener", new Class[]{GpsStatus.NmeaListener.class}, new Object[]{fVar});
    }

    public final void i() {
        if ((this.e & 2) == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            c cVar = new c();
            this.j = cVar;
            this.g.registerGnssStatusCallback(cVar, d());
            return;
        }
        d dVar = new d();
        this.h = dVar;
        this.g.addGpsStatusListener(dVar);
    }

    public final void j() {
        if ((this.e & 4) == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.g.removeNmeaListener((OnNmeaMessageListener) this.k);
            this.k = null;
            return;
        }
        o3.a(this.g, "removeNmeaListener", new Class[]{GpsStatus.NmeaListener.class}, new Object[]{this.i});
        this.i = null;
    }

    public final void k() {
        if ((this.e & 2) == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.g.unregisterGnssStatusCallback((GnssStatus.Callback) this.j);
            this.j = null;
            return;
        }
        this.g.removeGpsStatusListener((GpsStatus.Listener) this.h);
        this.h = null;
    }
}
