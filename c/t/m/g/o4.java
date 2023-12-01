package c.t.m.g;

import android.app.backup.FullBackup;
import android.content.Context;
import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.format.DateFormat;
import c.t.m.g.b5;
import c.t.m.g.q0;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tencentmap.lbssdk.service.TxGposListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/o4.class */
public final class o4 implements LocationListener, TxGposListener {
    public static LinkedList<a> G = new LinkedList<>();
    public volatile Location A;
    public c C;
    public h4 D;

    /* renamed from: a  reason: collision with root package name */
    public final t3 f3857a;

    /* renamed from: c  reason: collision with root package name */
    public volatile GpsStatus f3858c;
    public volatile Object d;
    public volatile Location e;
    public boolean n;
    public volatile boolean p;
    public boolean v;
    public b y;
    public LocationManager z;
    public AtomicInteger b = new AtomicInteger(1024);
    public volatile long g = 0;
    public volatile long h = 0;
    public volatile long i = 0;
    public boolean j = false;
    public boolean k = false;
    public AtomicInteger l = new AtomicInteger(0);
    public AtomicInteger m = new AtomicInteger(0);
    public ArrayList<Float> o = new ArrayList<>();
    public volatile boolean q = true;
    public volatile long s = 0;
    public int t = 0;
    public boolean u = false;
    public long x = -1;
    public final double[] E = new double[2];
    public boolean F = true;
    public Location f = new Location("gps");
    public f4 w = f4.a();
    public o4 r = this;
    public q0 B = new q0();

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/o4$a.class */
    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public double f3859a;
        public double b;

        /* renamed from: c  reason: collision with root package name */
        public float f3860c;
        public long d;

        public a(Location location) {
            if (location == null) {
                return;
            }
            this.f3859a = location.getLatitude();
            this.b = location.getLongitude();
            this.f3860c = location.getAccuracy();
            this.d = location.getTime();
        }

        public float a() {
            return this.f3860c;
        }

        public double b() {
            return this.f3859a;
        }

        public double c() {
            return this.b;
        }

        public long d() {
            return this.d;
        }

        public String toString() {
            return "BasicGpsInfo{latitude=" + this.f3859a + ", longitude=" + this.b + ", accuracy=" + this.f3860c + ", timeStamp=" + this.d + '}';
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/o4$b.class */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public final void a(Message message) {
            removeMessages(message.what);
            switch (message.what) {
                case 1101:
                    Location location = (Location) message.obj;
                    if (location == null) {
                        s3.a("G", "gl null");
                        return;
                    }
                    boolean c2 = o4.this.c(location);
                    o4 o4Var = o4.this;
                    int a2 = o4Var.a(o4Var.f3857a.f3944a, location);
                    if (!c2 || a2 == 1 || a2 == 3) {
                        s3.a("G", "gl inRegular");
                        if (a2 == 1 || a2 == 3) {
                            e4.b().a(a2);
                            return;
                        }
                        return;
                    }
                    e4.b().c();
                    o4 o4Var2 = o4.this;
                    boolean a3 = o4Var2.a(location, o4Var2.A);
                    o4.this.A = location;
                    if (a3) {
                        location.getLatitude();
                        location.getLongitude();
                        s3.a("G", String.format(Locale.ENGLISH, "l,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f,%s", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getBearing()), Float.valueOf(location.getSpeed()), FullBackup.DATA_TREE_TOKEN));
                        return;
                    } else if (!o4.this.d(location)) {
                        String.format(Locale.ENGLISH, "l,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f,%s", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getBearing()), Float.valueOf(location.getSpeed()), FullBackup.DATA_TREE_TOKEN);
                        s3.a("G", String.format(Locale.ENGLISH, "l,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f,%s", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getBearing()), Float.valueOf(location.getSpeed()), "nf"));
                        return;
                    } else {
                        o4.this.a(location, a2);
                        String str = "notifyListeners, location: " + location + ", fakeCode: " + a2;
                        o4.this.n();
                        o4.this.b.set(o4.this.b.get() | 2);
                        if (o4.this.x == -1 || o4.this.x == 0) {
                            o4.this.a(true);
                            o4.this.x = System.currentTimeMillis();
                            return;
                        }
                        return;
                    }
                case 1102:
                    o4.this.n();
                    s3.a("G", "vf:" + o4.this.l.get() + "," + o4.this.m.get());
                    o4.this.i();
                    if (o4.this.f3858c != null && o4.this.o != null && o4.this.o.size() > 0) {
                        try {
                            o4.this.q = o4.this.w.a(o4.this.o, o4.this.l.get());
                        } catch (Throwable th) {
                        }
                    }
                    if (o4.this.q) {
                        if (o4.this.x == -1 || o4.this.x == 0) {
                            o4.this.a(true);
                        }
                        o4.this.s = System.currentTimeMillis();
                        o4.this.x = System.currentTimeMillis();
                    } else if (o4.this.x == -1 || (System.currentTimeMillis() - o4.this.x > 40000 && o4.this.x != 0)) {
                        o4.this.a(false);
                        o4.this.x = 0L;
                    }
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (o4.this.n || o4.this.l.get() <= 10 || o4.this.l.get() >= 100 || o4.this.A == null || currentTimeMillis - o4.this.A.getTime() <= 60000) {
                            return;
                        }
                        o4.this.l.get();
                        o4.this.m.get();
                        o4.this.A.getTime();
                        s3.a("G", "restart gps.");
                        o4.this.m();
                        o4.this.k();
                        o4.this.n = true;
                        return;
                    } catch (Throwable th2) {
                        return;
                    }
                case 1103:
                    o4.this.b.set(4);
                    o4.this.j();
                    return;
                case 1104:
                    o4.this.l.set(0);
                    o4.this.m.set(0);
                    o4.this.b.set(0);
                    o4.this.j = false;
                    o4.this.j();
                    return;
                case TXLiveConstants.PUSH_WARNING_BEAUTYSURFACE_VIEW_INIT_FAIL /* 1105 */:
                    o4.this.a();
                    return;
                case TXLiveConstants.PUSH_WARNING_VIDEO_ENCODE_BITRATE_OVERFLOW /* 1106 */:
                    o4.this.o();
                    return;
                default:
                    return;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            try {
                a(message);
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/o4$c.class */
    public class c extends q0.g {
        public c() {
        }

        @Override // c.t.m.g.q0.g
        public void a() {
            super.a();
            o4.this.a(1, (Object) null);
        }

        @Override // c.t.m.g.q0.g
        public void a(int i) {
            h4 h4Var;
            super.a(i);
            if (!o4.this.h() || o4.this.D == null || (h4Var = o4.this.D) == null) {
                return;
            }
            h4Var.a(6005, i, 0, null);
        }

        @Override // c.t.m.g.q0.g
        public void a(long j, String str) {
            h4 h4Var;
            super.a(j, str);
            f5 f5Var = new f5(str, j);
            if (!o4.this.h() || o4.this.D == null || (h4Var = o4.this.D) == null) {
                return;
            }
            h4Var.a(AuthCode.StatusCode.PERMISSION_EXPIRED, 0, 0, f5Var);
        }

        @Override // c.t.m.g.q0.g
        public void a(Object obj) {
            h4 h4Var;
            GnssMeasurementsEvent gnssMeasurementsEvent;
            super.a(obj);
            if ((Build.VERSION.SDK_INT < 24 || !((gnssMeasurementsEvent = (GnssMeasurementsEvent) obj) == null || gnssMeasurementsEvent.getClock() == null || gnssMeasurementsEvent.getMeasurements() == null)) && o4.this.h() && o4.this.D != null && (h4Var = o4.this.D) != null) {
                h4Var.a(6004, 0, 0, obj);
            }
        }

        @Override // c.t.m.g.q0.g
        public void b() {
            super.b();
            o4.this.a(2, (Object) null);
        }

        @Override // c.t.m.g.q0.g
        public void b(int i) {
            h4 h4Var;
            super.b(i);
            if (!o4.this.h() || o4.this.D == null || (h4Var = o4.this.D) == null) {
                return;
            }
            h4Var.a(6003, i, 0, null);
        }

        @Override // c.t.m.g.q0.g
        public void b(Object obj) {
            h4 h4Var;
            super.b(obj);
            if (!o4.this.h() || o4.this.D == null || (h4Var = o4.this.D) == null) {
                return;
            }
            h4Var.a(6002, 0, 0, obj);
        }

        @Override // c.t.m.g.q0.g
        public void c(int i) {
            super.c(i);
            o4.this.a(3, (Object) null);
        }

        @Override // c.t.m.g.q0.g
        public void c(Object obj) {
            super.c(obj);
            o4.this.a(4, obj);
        }

        @Override // c.t.m.g.q0.g
        public void d(int i) {
            if (Build.VERSION.SDK_INT >= 24) {
                return;
            }
            o4.this.a(i, (Object) null);
        }
    }

    public o4(t3 t3Var, boolean z) {
        this.f3857a = t3Var;
        this.z = this.f3857a.b();
        if (z) {
            this.D = new h4(t3Var.f3944a);
        }
    }

    public final int a(float f, double d, double d2) {
        if (d <= 100000.0d || d / d2 <= 200.0d || d <= f) {
            return (d > 100000.0d || d / d2 <= 50.0d || d <= ((double) f)) ? 0 : 1;
        }
        return 1;
    }

    public final int a(Context context, Location location) {
        if (e4.a() || h4.a(location)) {
            return 0;
        }
        int a2 = a(location);
        if (a2 != 0) {
            return a2;
        }
        try {
        } catch (Throwable th) {
            th.toString();
        }
        if (this.f3857a.b().isProviderEnabled("gps")) {
            if (Build.VERSION.SDK_INT >= 18) {
                if (location.isFromMockProvider()) {
                    return 1;
                }
            }
            if (b(location)) {
                if (!this.q && this.m.get() < 4 && System.currentTimeMillis() - this.s > com.igexin.push.config.c.l) {
                    s3.a("G", "Mock:2");
                    return 2;
                }
                Location location2 = this.f;
                if (location2 == null || location2.getTime() == 0 || System.currentTimeMillis() - this.f.getTime() >= 30000) {
                    return 0;
                }
                float distanceTo = location.distanceTo(this.f);
                if (distanceTo > 100.0f) {
                    s3.a("G", "D:3:" + distanceTo);
                    return !this.q ? 3 : 0;
                }
                return 0;
            }
            return 1;
        }
        return 1;
    }

    public final int a(Location location) {
        int i;
        long time;
        if (location == null) {
            return 0;
        }
        if (G == null) {
            G = new LinkedList<>();
        }
        Iterator<a> it = G.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            a next = it.next();
            float accuracy = location.getAccuracy();
            float a2 = next.a();
            double distanceBetween = TencentLocationUtils.distanceBetween(next.b(), next.c(), location.getLatitude(), location.getLongitude());
            if (location.getTime() - next.d() >= 2000) {
                i2 += a(accuracy + a2, distanceBetween, ((float) time) / 1000.0f);
            }
        }
        if (i2 >= 3) {
            i = -2;
        } else {
            a aVar = new a(location);
            if (G.isEmpty()) {
                G.add(aVar);
            } else {
                a last = G.getLast();
                if (System.currentTimeMillis() - last.d() >= 2000 && a(aVar, last)) {
                    G.add(aVar);
                }
            }
            i = 0;
        }
        if (G.size() > 10) {
            LinkedList<a> linkedList = G;
            linkedList.subList(0, linkedList.size() - 10).clear();
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0118 A[Catch: IOException -> 0x011d, TRY_ENTER, TryCatch #9 {IOException -> 0x011d, blocks: (B:29:0x00c0, B:50:0x0118), top: B:76:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.o4.a():void");
    }

    public final void a(int i) {
        b bVar = this.y;
        if (bVar != null) {
            bVar.obtainMessage(i).sendToTarget();
        }
    }

    public final void a(int i, Location location) {
        try {
            b bVar = this.y;
            if (bVar != null) {
                bVar.getLooper().getThread().isAlive();
                Message obtainMessage = bVar.obtainMessage(i);
                obtainMessage.obj = location;
                bVar.sendMessage(obtainMessage);
            }
        } catch (Throwable th) {
            s3.a("G", th.toString());
        }
    }

    public void a(int i, Object obj) {
        h4 h4Var;
        s3.a("G", "e[" + i + "]");
        if (i == 1) {
            AtomicInteger atomicInteger = this.b;
            atomicInteger.set(atomicInteger.get() | 1);
        } else if (i == 2) {
            this.b.set(0);
        } else if (i == 3) {
            AtomicInteger atomicInteger2 = this.b;
            atomicInteger2.set(atomicInteger2.get() | 2);
        } else if (i != 4) {
        } else {
            if (Build.VERSION.SDK_INT < 24) {
                try {
                    this.f3858c = this.f3857a.b().getGpsStatus(this.f3858c);
                    GpsStatus gpsStatus = this.f3858c;
                } catch (Throwable th) {
                }
            } else {
                this.d = obj;
                if (h() && (h4Var = this.D) != null && h4Var != null) {
                    h4Var.a(6001, 0, 0, obj);
                }
            }
            a(1102);
        }
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

    public final void a(Location location, int i) {
        int i2 = (this.m.get() < 4 || this.m.get() > 6) ? this.m.get() >= 7 ? 3 : 1 : 2;
        if (this.v && w5.a(location.getLatitude(), location.getLongitude())) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 > 3) {
                    break;
                }
                double[] dArr = this.E;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                f6.a(location, dArr);
                double[] dArr2 = this.E;
                double d = dArr2[0];
                double d2 = dArr2[1];
                if (dArr2[0] != 0.0d && dArr2[1] != 0.0d) {
                    break;
                }
                i3 = i4 + 1;
            }
            double[] dArr3 = this.E;
            a(location, dArr3[0], dArr3[1], i2, i);
            double[] dArr4 = this.E;
            double d3 = dArr4[0];
            double d4 = dArr4[1];
        } else {
            a(location, location.getLatitude(), location.getLongitude(), i2, i);
        }
        this.g = System.currentTimeMillis();
        this.f3857a.a(new b5(location, c(), e(), d(), b(), b5.a.GPS));
    }

    public void a(Location location, String str) {
        if (z5.f4028a) {
            double[] dArr = new double[2];
            f6.a(location, dArr);
            String.format(Locale.getDefault(), ": %f,%f,%f,%f,%f,%f,%d", Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Double.valueOf(location.getAltitude()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getBearing()), Float.valueOf(location.getSpeed()), Long.valueOf(location.getTime()));
        }
        if ("gps".equals(location.getProvider())) {
            Bundle extras = location.getExtras();
            Bundle bundle = extras;
            if (extras == null) {
                bundle = new Bundle();
            }
            bundle.putString("gnss_source", str);
            location.setExtras(bundle);
            if (str.equals(TencentLocation.BEIDOU_PROVIDER)) {
                this.h = System.currentTimeMillis();
            } else {
                this.i = System.currentTimeMillis();
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.h;
            long currentTimeMillis2 = System.currentTimeMillis();
            long j2 = this.i;
            if (this.t == 21) {
                if (str.equals("gps") && currentTimeMillis - j < com.igexin.push.config.c.j) {
                    return;
                }
            } else if (str.equals(TencentLocation.BEIDOU_PROVIDER) && currentTimeMillis2 - j2 < com.anythink.expressad.video.module.a.a.m.ag) {
                return;
            }
            if (location.getExtras() != null) {
                int i = location.getExtras().getInt("SourceType", 0);
                if ((i & 128) == 128) {
                    s3.a("G", "SourceType:" + i);
                    return;
                }
            }
            if (this.e == null || location.getTime() - this.e.getTime() > 10000 || this.F) {
                s3.a("G", String.format(Locale.ENGLISH, "l,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f,%s", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getBearing()), Float.valueOf(location.getSpeed()), str));
            }
            this.F = !this.F;
            this.e = location;
            a(1101, location);
        }
    }

    public void a(Handler handler, Handler handler2, Handler handler3, boolean z) {
        h4 h4Var;
        if (this.p) {
            return;
        }
        this.p = true;
        this.g = 0L;
        Looper looper = handler == null ? null : handler.getLooper();
        b bVar = this.y;
        if (bVar == null || bVar.getLooper() != looper) {
            if (looper != null) {
                this.y = new b(looper);
            } else {
                this.y = new b(Looper.getMainLooper());
            }
        }
        if (z) {
            try {
                this.z.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 2000L, 1.0f, this);
            } catch (Throwable th) {
                th.toString();
            }
        } else {
            k();
            if (h() && (h4Var = this.D) != null) {
                h4Var.a(this, this.y.getLooper());
            }
            this.n = false;
            try {
                this.C = new c();
                this.B.a(h() ? 30 : 2, this.C, this.y.getLooper());
                this.s = System.currentTimeMillis();
            } catch (Throwable th2) {
                th2.toString();
            }
        }
        if (g()) {
            this.b.set(4);
            j();
        }
        a(TXLiveConstants.PUSH_WARNING_BEAUTYSURFACE_VIEW_INIT_FAIL);
    }

    public final void a(boolean z) {
        int i = z ? 3 : 4;
        Message message = new Message();
        message.what = 12999;
        message.arg1 = 12004;
        message.arg2 = i;
        this.f3857a.a(message);
    }

    public final boolean a(double d) {
        return Math.abs(((double) Double.valueOf(d).longValue()) - d) < Double.MIN_VALUE;
    }

    public final boolean a(Location location, Location location2) {
        if (location == null) {
            return true;
        }
        return location2 != null && this.m.get() < 3 && location.getLongitude() == location2.getLongitude() && location.getLatitude() == location2.getLatitude() && location.getAccuracy() == location2.getAccuracy() && location.getSpeed() == 0.0f && location2.getSpeed() == 0.0f && location.getBearing() == 0.0f && location2.getBearing() == 0.0f && location.getAltitude() == 0.0d && location2.getAltitude() == 0.0d;
    }

    public final boolean a(a aVar, a aVar2) {
        if (aVar.b() == 0.0d || aVar.c() == 0.0d) {
            return false;
        }
        return Math.abs(aVar.b() - aVar2.b()) >= 1.0E-7d || Math.abs(aVar.c() - aVar2.c()) >= 1.0E-7d;
    }

    public int b() {
        return this.b.get();
    }

    public void b(int i) {
        this.t = i;
    }

    public void b(boolean z) {
        this.u = z;
    }

    public final boolean b(Location location) {
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                return location.getElapsedRealtimeNanos() != 0;
            } catch (Throwable th) {
                return true;
            }
        }
        return true;
    }

    public long c() {
        return this.g;
    }

    public void c(boolean z) {
        this.v = z;
    }

    public final boolean c(Location location) {
        try {
            if (location.getAccuracy() > 10000.0f) {
                return false;
            }
            if (!(a(location.getLatitude()) && a(location.getLongitude())) && Math.abs(location.getLatitude()) >= 1.0E-8d && Math.abs(location.getLongitude()) >= 1.0E-8d && Math.abs(location.getLatitude() - 1.0d) >= 1.0E-8d && Math.abs(location.getLongitude() - 1.0d) >= 1.0E-8d && location.getLatitude() >= -90.0d && location.getLatitude() <= 90.0d && location.getLongitude() >= -180.0d) {
                return location.getLongitude() <= 180.0d;
            }
            return false;
        } catch (Throwable th) {
            th.toString();
            return true;
        }
    }

    public int d() {
        return this.m.get();
    }

    public final boolean d(Location location) {
        return (this.m.get() == 0 && location.getBearing() == 0.0f && location.getSpeed() <= 0.0f) ? false : true;
    }

    public int e() {
        return this.l.get();
    }

    public boolean f() {
        return System.currentTimeMillis() - this.g < 20000;
    }

    public boolean g() {
        try {
            return this.f3857a.b().isProviderEnabled("gps");
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean h() {
        return this.u;
    }

    public final boolean i() {
        int i = this.l.get();
        int i2 = this.m.get();
        if (i > 0) {
            this.k = true;
        }
        if (i2 > 0) {
            this.j = true;
        }
        if (!this.k || i > 2) {
            return this.j ? i2 >= 3 || i2 == 0 : i2 == 0;
        }
        return false;
    }

    public final void j() {
        int i = this.b.get() == 4 ? 1 : this.b.get() == 0 ? 0 : -1;
        Message message = new Message();
        message.what = 12999;
        message.arg1 = 12002;
        message.arg2 = i;
        this.f3857a.a(message);
    }

    public final void k() {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                this.z.requestLocationUpdates("gps", 1000L, 0.0f, this, Looper.getMainLooper());
                s3.a("G", "request in thread[" + Thread.currentThread().getName() + "]");
            } else {
                this.z.requestLocationUpdates("gps", 1000L, 0.0f, this, this.y == null ? Looper.getMainLooper() : this.y.getLooper());
                s3.a("G", "request in thread[" + Thread.currentThread().getName() + "]");
            }
        } catch (Throwable th) {
            v5.f3980a = true;
            s3.a("G", "request failed.");
        }
        try {
            Bundle bundle = new Bundle();
            this.z.sendExtraCommand("gps", "force_xtra_injection", bundle);
            this.z.sendExtraCommand("gps", "force_time_injection", bundle);
        } catch (Exception e) {
        }
    }

    public final void l() {
        h4 h4Var;
        if (this.p) {
            this.p = false;
            this.b.set(1024);
            this.j = false;
            this.k = false;
            this.l.set(0);
            this.m.set(0);
            this.o.clear();
            this.x = -1L;
            this.v = false;
            this.n = false;
            Arrays.fill(this.E, 0.0d);
            a(TXLiveConstants.PUSH_WARNING_VIDEO_ENCODE_BITRATE_OVERFLOW);
            m();
            this.y = null;
            this.e = null;
            this.A = null;
            try {
                this.B.f();
                this.C = null;
            } catch (Exception e) {
            }
            if (!h() || (h4Var = this.D) == null) {
                return;
            }
            h4Var.a();
        }
    }

    public final void m() {
        try {
            this.f3857a.b().removeUpdates(this.r);
        } catch (Exception e) {
        }
    }

    public final void n() {
        int i;
        int i2;
        int i3;
        this.o.clear();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        try {
            c.t.m.g.b a2 = c.t.m.g.b.a();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    GnssStatus gnssStatus = (GnssStatus) this.d;
                    if (gnssStatus != null) {
                        i7 = 0;
                        int i9 = 0;
                        while (true) {
                            try {
                                i6 = i9;
                                if (i8 >= gnssStatus.getSatelliteCount()) {
                                    break;
                                }
                                int i10 = i7;
                                try {
                                    this.o.add(Float.valueOf(gnssStatus.getCn0DbHz(i8)));
                                    int i11 = i7 + 1;
                                    i7 = i11;
                                    i3 = i6;
                                    if (gnssStatus.usedInFix(i8)) {
                                        i3 = i6 + 1;
                                        i7 = i11;
                                    }
                                } catch (Throwable th) {
                                    i7 = i10;
                                    i3 = i6;
                                }
                                i8++;
                                i9 = i3;
                            } catch (Throwable th2) {
                                this.l.set(i7);
                                this.m.set(i6);
                                return;
                            }
                        }
                        i4 = i7;
                    } else {
                        i6 = 0;
                    }
                    i = i4;
                    i2 = i6;
                    if (a2 != null) {
                        a2.a(2, currentTimeMillis, gnssStatus);
                        i = i4;
                        i2 = i6;
                    }
                } else {
                    GpsStatus gpsStatus = this.f3858c;
                    Iterator<GpsSatellite> it = gpsStatus == null ? null : gpsStatus.getSatellites().iterator();
                    int i12 = 0;
                    int i13 = 0;
                    if (it != null) {
                        while (true) {
                            i6 = i5;
                            i12 = i13;
                            if (!it.hasNext()) {
                                break;
                            }
                            int i14 = i5;
                            GpsSatellite next = it.next();
                            int i15 = i5 + 1;
                            this.o.add(Float.valueOf(next.getSnr()));
                            i5 = i15;
                            if (next.usedInFix()) {
                                i13++;
                                i5 = i15;
                            }
                        }
                    }
                    i = i6;
                    i2 = i12;
                    if (a2 != null) {
                        a2.a(1, currentTimeMillis, gpsStatus);
                        i2 = i12;
                        i = i6;
                    }
                }
                this.l.set(i);
                this.m.set(i2);
            } catch (Throwable th3) {
                i6 = 0;
            }
        } catch (Throwable th4) {
            i6 = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d5 A[Catch: IOException -> 0x00dc, TRY_ENTER, TRY_LEAVE, TryCatch #9 {IOException -> 0x00dc, blocks: (B:22:0x0076, B:42:0x00d5), top: B:73:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00dd -> B:72:0x00e1). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void o() {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.o4.o():void");
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        h4 h4Var;
        if (location == null) {
            return;
        }
        try {
            DateFormat.format("yyyy-MM-dd kk:mm:ss", location.getTime());
            if (Build.VERSION.SDK_INT >= 17) {
                location.getElapsedRealtimeNanos();
            }
            location.getLatitude();
            location.getLongitude();
            location.toString();
            Location location2 = new Location(location);
            if (h() && this.D != null && (h4Var = this.D) != null) {
                h4Var.a(6007, 0, 0, location2);
            }
            a(location, "gps");
        } catch (Throwable th) {
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        if ("gps".equals(str)) {
            a(1104);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        if ("gps".equals(str)) {
            a(1103);
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
        h4 h4Var;
        e5 e5Var = new e5(str, i, bundle);
        if (!h() || (h4Var = this.D) == null || h4Var == null) {
            return;
        }
        h4Var.a(6008, 0, 0, e5Var);
    }

    @Override // com.tencent.tencentmap.lbssdk.service.TxGposListener
    public void onTxGposLocation(int[] iArr, double[] dArr) {
    }

    @Override // com.tencent.tencentmap.lbssdk.service.TxGposListener
    public void onTxGposLocationBDS(int[] iArr, double[] dArr) {
        int i = iArr[0];
        if (iArr[0] > 0) {
            Location location = new Location("gps");
            location.setLatitude(dArr[0]);
            location.setLongitude(dArr[1]);
            location.setAltitude(dArr[2]);
            location.setAccuracy((float) dArr[3]);
            location.setBearing((float) dArr[4]);
            location.setSpeed((float) dArr[5]);
            location.setTime((long) dArr[6]);
            String str = "onTxGposLocationBDS, GnssSourceFirst is " + this.t + ", beidou result: " + location;
            a(location, TencentLocation.BEIDOU_PROVIDER);
        }
    }

    @Override // com.tencent.tencentmap.lbssdk.service.TxGposListener
    public void onTxRtcmReceived(int[] iArr) {
    }
}
