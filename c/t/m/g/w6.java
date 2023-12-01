package c.t.m.g;

import android.content.Context;
import android.location.GnssMeasurementsEvent;
import android.location.GnssNavigationMessage;
import android.location.GnssStatus;
import android.location.LocationManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/w6.class */
public class w6 {

    /* renamed from: a  reason: collision with root package name */
    public final List<x6> f3992a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3993c;
    public boolean d;
    public boolean e;
    public long f;
    public long g;
    public long h;
    public boolean i;
    public HandlerThread j;
    public Looper k;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/w6$a.class */
    public class a extends GnssStatus.Callback {
        public a() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            for (x6 x6Var : w6.this.f3992a) {
                x6Var.a(gnssStatus);
            }
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/w6$b.class */
    public class b extends GnssNavigationMessage.Callback {
        public b() {
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onGnssNavigationMessageReceived(GnssNavigationMessage gnssNavigationMessage) {
            if (w6.this.f3993c) {
                for (x6 x6Var : w6.this.f3992a) {
                    x6Var.a(gnssNavigationMessage);
                }
            }
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onStatusChanged(int i) {
            if (w6.this.f3993c) {
                for (x6 x6Var : w6.this.f3992a) {
                    x6Var.a(i);
                }
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/w6$c.class */
    public class c extends GnssMeasurementsEvent.Callback {
        public c() {
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
            if (w6.this.d) {
                for (x6 x6Var : w6.this.f3992a) {
                    x6Var.a(gnssMeasurementsEvent);
                }
            }
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onStatusChanged(int i) {
            if (w6.this.d) {
                for (x6 x6Var : w6.this.f3992a) {
                    x6Var.b(i);
                }
            }
        }
    }

    static {
        TimeUnit.SECONDS.toMillis(1L);
    }

    public w6(Context context, x6... x6VarArr) {
        new a();
        this.b = true;
        this.f3993c = true;
        new b();
        this.d = true;
        new c();
        this.e = true;
        this.f = 0L;
        this.g = 0L;
        this.h = 0L;
        this.i = true;
        HandlerThread handlerThread = new HandlerThread("GPS_DEMO");
        this.j = handlerThread;
        handlerThread.start();
        this.k = this.j.getLooper();
        new Handler(this.k);
        this.f3992a = Arrays.asList(x6VarArr);
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
    }
}
