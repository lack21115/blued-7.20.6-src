package c.t.m.g;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import c.t.m.g.b5;
import com.tencent.map.geolocation.util.SoUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/t4.class */
public class t4 {

    /* renamed from: a  reason: collision with root package name */
    public final t3 f3947a;

    /* renamed from: c  reason: collision with root package name */
    public final LocationManager f3948c;
    public final HandlerThread e;
    public b f;
    public Looper g;
    public int l;
    public String m;
    public int n;
    public int o;
    public c p;
    public int b = 0;
    public final byte[] h = new byte[0];
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    public final a d = new a();

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/t4$a.class */
    public class a implements LocationListener {
        public a() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            try {
                String str = "system nlp callback,location: " + location;
                boolean unused = t4.this.j;
                if (t4.this.j) {
                    return;
                }
                t4.this.i = true;
                t4.this.b(t4.this.a(location));
            } catch (Exception e) {
                t4.this.i = false;
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

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/t4$b.class */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public final void a(Message message) {
            int i = message.what;
            Location location = null;
            boolean z = false;
            boolean z2 = false;
            switch (i) {
                case 1001:
                    t4.this.j = false;
                    t4.this.i = false;
                    try {
                        List<String> allProviders = t4.this.f3948c.getAllProviders();
                        if (allProviders != null) {
                            Iterator<String> it = allProviders.iterator();
                            while (true) {
                                z = z2;
                                if (it.hasNext()) {
                                    if ("network".equals(it.next())) {
                                        z2 = true;
                                    }
                                }
                            }
                        }
                        if (z) {
                            t4.this.f3948c.requestLocationUpdates("network", 1000L, 0.0f, t4.this.d, t4.this.g);
                        }
                    } catch (Exception e) {
                    }
                    t4.this.b = 1;
                    return;
                case 1002:
                    t4.this.j = false;
                    t4.this.i = false;
                    removeCallbacksAndMessages(null);
                    t4.this.f3948c.removeUpdates(t4.this.d);
                    t4.this.b = 0;
                    return;
                case 1003:
                    boolean unused = t4.this.i;
                    if (t4.this.i) {
                        return;
                    }
                    try {
                        Location lastKnownLocation = t4.this.f3948c.getLastKnownLocation("network");
                        StringBuilder sb = new StringBuilder();
                        sb.append("getLastKownLocation, ");
                        sb.append(lastKnownLocation);
                        location = lastKnownLocation;
                        sb.toString();
                        location = lastKnownLocation;
                    } catch (Throwable th) {
                    }
                    t4.this.b(t4.this.a(location));
                    t4.this.j = true;
                    return;
                default:
                    return;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                a(message);
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/t4$c.class */
    public interface c {
        void a(q5 q5Var, int i);
    }

    public t4(t3 t3Var) {
        this.f3947a = t3Var;
        this.f3948c = t3Var.b();
        HandlerThread handlerThread = new HandlerThread("loc_nlp_thread");
        this.e = handlerThread;
        handlerThread.start();
        this.g = this.e.getLooper();
        this.f = new b(this.g);
    }

    public Location a(Location location) {
        if (location == null) {
            return l4.f3825a;
        }
        if (!(this.k && w5.a(location.getLatitude(), location.getLongitude()))) {
            a(location, location.getLatitude(), location.getLongitude(), 0, 0);
            return location;
        }
        double[] dArr = new double[2];
        f6.a(location, dArr);
        a(location, dArr[0], dArr[1], 0, 0);
        return location;
    }

    public final String a(byte[] bArr, int i) {
        if (!j5.a() && bArr != null) {
            try {
                if (SoUtils.fun_o(bArr, 1) >= 0) {
                    return l4.a(1, i, 1);
                }
            } catch (UnsatisfiedLinkError e) {
                return null;
            }
        }
        return l4.a(1, i, 0);
    }

    public void a(int i) {
        this.n = i;
    }

    public final void a(Location location, double d, double d2, int i, int i2) {
        Bundle extras = location.getExtras();
        Bundle bundle = extras;
        if (extras == null) {
            bundle = new Bundle();
        }
        bundle.putDouble("lat", d);
        bundle.putDouble("lng", d2);
        bundle.putInt("rssi", i);
        bundle.putInt("fakeCode", i2);
        location.setExtras(bundle);
    }

    public void a(c cVar) {
        this.p = cVar;
    }

    public void a(String str) {
        this.m = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r6, c.t.m.g.c5 r7, int r8, c.t.m.g.b5 r9) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.t4.a(java.lang.String, c.t.m.g.c5, int, c.t.m.g.b5):void");
    }

    public void a(boolean z) {
        this.k = z;
    }

    public boolean a() {
        if (this.b == 0) {
            return false;
        }
        synchronized (this.h) {
            c3.b(this.f, 1002, 0, 0, null);
        }
        return true;
    }

    public void b(int i) {
        this.o = i;
    }

    public final void b(Location location) {
        b5 b5Var = new b5(location, System.currentTimeMillis(), 0, 0, 0, b5.a.NONE);
        c5 c5Var = new c5(null, null, b5Var, null);
        String a2 = c5Var.a(this.l, this.m, this.f3947a, true, false, false);
        if (!(a2 == null || !f6.a(a2))) {
            a(a2, c5Var, this.n, b5Var);
            return;
        }
        c cVar = this.p;
        if (cVar != null) {
            cVar.a(q5.q, this.o);
        }
    }

    public boolean b() {
        if (this.b == 1) {
            return false;
        }
        synchronized (this.h) {
            c3.b(this.f, 1001, 0, 0, null);
            c3.a(this.f, 1003, 500L);
        }
        return true;
    }

    public void c(int i) {
        this.l = i;
    }
}
