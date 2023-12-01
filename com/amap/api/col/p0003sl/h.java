package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
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
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.android.internal.util.cm.QSConstants;
import com.anythink.core.common.c.g;
import com.anythink.core.common.g.c;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.d;
import com.autonavi.aps.amapapi.utils.e;
import com.autonavi.aps.amapapi.utils.g;
import com.autonavi.aps.amapapi.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.h  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/h.class */
public final class h {
    static AMapLocation j;
    static long k;
    static Object l = new Object();
    static long q = 0;
    static boolean t = false;
    static boolean u = false;
    public static volatile AMapLocation y = null;
    private GnssStatus.Callback F;
    Handler a;
    LocationManager b;
    AMapLocationClientOption c;
    com.autonavi.aps.amapapi.filters.a f;
    private Context z;
    private long A = 0;
    long d = 0;
    boolean e = false;
    private int B = 0;
    int g = 240;
    int h = 80;
    AMapLocation i = null;
    long m = 0;
    float n = 0.0f;
    Object o = new Object();
    Object p = new Object();
    private int C = 0;
    private GpsStatus D = null;
    private GpsStatus.Listener E = null;
    AMapLocationClientOption.GeoLanguage r = AMapLocationClientOption.GeoLanguage.DEFAULT;
    boolean s = true;
    long v = 0;
    int w = 0;
    LocationListener x = null;
    private String G = null;
    private boolean H = false;
    private int I = 0;
    private boolean J = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.h$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/h$a.class */
    public static final class a implements LocationListener {
        private h a;

        a(h hVar) {
            this.a = hVar;
        }

        final void a() {
            this.a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                Thread.currentThread().getId();
                if (this.a != null) {
                    this.a.a(location);
                }
            } catch (Throwable th) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                if (this.a != null) {
                    this.a.a(str);
                }
            } catch (Throwable th) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
            try {
                if (this.a != null) {
                    this.a.a(i);
                }
            } catch (Throwable th) {
            }
        }
    }

    public h(Context context, Handler handler) {
        this.f = null;
        this.z = context;
        this.a = handler;
        try {
            this.b = (LocationManager) context.getSystemService(QSConstants.TILE_LOCATION);
        } catch (Throwable th) {
            b.a(th, "GpsLocation", "<init>");
        }
        this.f = new com.autonavi.aps.amapapi.filters.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i == 0) {
            try {
                this.d = 0L;
                this.C = 0;
            } catch (Throwable th) {
            }
        }
    }

    private void a(int i, int i2, String str, long j2) {
        try {
            if (this.a == null || this.c.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
                return;
            }
            Message obtain = Message.obtain();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setProvider(GeocodeSearch.GPS);
            aMapLocation.setErrorCode(i2);
            aMapLocation.setLocationDetail(str);
            aMapLocation.setLocationType(1);
            obtain.obj = aMapLocation;
            obtain.what = i;
            this.a.sendMessageDelayed(obtain, j2);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GnssStatus gnssStatus) {
        int i = 0;
        int i2 = 0;
        if (gnssStatus != null) {
            i2 = 0;
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    int satelliteCount = gnssStatus.getSatelliteCount();
                    int i3 = 0;
                    while (true) {
                        i2 = i3;
                        if (i >= satelliteCount) {
                            break;
                        }
                        try {
                            int i4 = i2;
                            if (gnssStatus.usedInFix(i)) {
                                i4 = i2 + 1;
                            }
                            i++;
                            i3 = i4;
                        } catch (Throwable th) {
                            th = th;
                            b.a(th, "GpsLocation_Gnss", "GPS_EVENT_SATELLITE_STATUS");
                            this.C = i2;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                i2 = 0;
            }
        }
        this.C = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        Handler handler = this.a;
        if (handler != null) {
            handler.removeMessages(8);
        }
        if (location == null) {
            return;
        }
        try {
            AMapLocation aMapLocation = new AMapLocation(location);
            if (i.a(aMapLocation)) {
                aMapLocation.setProvider(GeocodeSearch.GPS);
                aMapLocation.setLocationType(1);
                if (!this.e && i.a(aMapLocation)) {
                    g.a(this.z, i.b() - this.A, b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                    this.e = true;
                }
                if (i.a(aMapLocation, this.C)) {
                    aMapLocation.setMock(true);
                    aMapLocation.setTrustedLevel(4);
                    if (!this.c.isMockEnable()) {
                        if (this.w <= 3) {
                            this.w++;
                            return;
                        }
                        g.a((String) null, 2152);
                        aMapLocation.setErrorCode(15);
                        aMapLocation.setLocationDetail("GpsLocation has been mocked!#1501");
                        aMapLocation.setLatitude(0.0d);
                        aMapLocation.setLongitude(0.0d);
                        aMapLocation.setAltitude(0.0d);
                        aMapLocation.setSpeed(0.0f);
                        aMapLocation.setAccuracy(0.0f);
                        aMapLocation.setBearing(0.0f);
                        aMapLocation.setExtras(null);
                        c(aMapLocation);
                        return;
                    }
                } else {
                    this.w = 0;
                }
                aMapLocation.setSatellites(this.C);
                e(aMapLocation);
                f(aMapLocation);
                h(aMapLocation);
                AMapLocation g = g(aMapLocation);
                a(g);
                b(g);
                synchronized (this.o) {
                    a(g, y);
                }
                if (i.a(g)) {
                    if (this.i != null) {
                        this.m = location.getTime() - this.i.getTime();
                        this.n = i.a(this.i, g);
                    }
                    synchronized (this.p) {
                        this.i = g.m8814clone();
                    }
                    this.G = null;
                    this.H = false;
                    this.I = 0;
                }
                c(g);
            }
        } catch (Throwable th) {
            b.a(th, "GpsLocation", "onLocationChanged");
        }
    }

    private void a(AMapLocation aMapLocation) {
        if (i.a(aMapLocation)) {
            this.d = i.b();
            synchronized (l) {
                k = i.b();
                j = aMapLocation.m8814clone();
            }
            this.B++;
        }
    }

    private void a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null || !this.c.isNeedAddress() || i.a(aMapLocation, aMapLocation2) >= this.g) {
            return;
        }
        b.a(aMapLocation, aMapLocation2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            if (GeocodeSearch.GPS.equalsIgnoreCase(str)) {
                this.d = 0L;
                this.C = 0;
            }
        } catch (Throwable th) {
        }
    }

    private static boolean a(LocationManager locationManager) {
        try {
            if (t) {
                return u;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders == null || allProviders.size() <= 0) {
                u = false;
            } else {
                u = allProviders.contains(GeocodeSearch.GPS);
            }
            t = true;
            return u;
        } catch (Throwable th) {
            th.getMessage();
            return u;
        }
    }

    private void b(AMapLocation aMapLocation) {
        if (i.a(aMapLocation) && this.a != null) {
            long b = i.b();
            if (this.c.getInterval() <= 8000 || b - this.v > this.c.getInterval() - 8000) {
                Bundle bundle = new Bundle();
                bundle.putDouble(c.B, aMapLocation.getLatitude());
                bundle.putDouble(c.C, aMapLocation.getLongitude());
                bundle.putFloat("radius", aMapLocation.getAccuracy());
                bundle.putLong(g.a.g, aMapLocation.getTime());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 5;
                synchronized (this.o) {
                    if (y == null) {
                        this.a.sendMessage(obtain);
                    } else if (i.a(aMapLocation, y) > this.h) {
                        this.a.sendMessage(obtain);
                    }
                }
            }
        }
    }

    private boolean b(String str) {
        try {
            ArrayList b = i.b(str);
            ArrayList b2 = i.b(this.G);
            boolean z = false;
            if (b.size() >= 8) {
                z = false;
                if (b2.size() >= 8) {
                    z = i.a(this.G, str);
                }
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    private void c(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 15 || AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.c.getLocationMode())) {
            if (this.c.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.c.getDeviceModeDistanceFilter() > 0.0f) {
                d(aMapLocation);
            } else if (i.b() - this.v >= this.c.getInterval() - 200) {
                this.v = i.b();
                d(aMapLocation);
            }
        }
    }

    private void d(AMapLocation aMapLocation) {
        if (this.a != null) {
            Message obtain = Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 2;
            this.a.sendMessage(obtain);
        }
    }

    private void e(AMapLocation aMapLocation) {
        try {
            if (!b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) || !this.c.isOffset()) {
                aMapLocation.setOffset(false);
                aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
                return;
            }
            DPoint a2 = d.a(this.z, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
            aMapLocation.setLatitude(a2.getLatitude());
            aMapLocation.setLongitude(a2.getLongitude());
            aMapLocation.setOffset(this.c.isOffset());
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
        } catch (Throwable th) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        }
    }

    private void f(AMapLocation aMapLocation) {
        try {
            if (this.C >= 4) {
                aMapLocation.setGpsAccuracyStatus(1);
            } else if (this.C == 0) {
                aMapLocation.setGpsAccuracyStatus(-1);
            } else {
                aMapLocation.setGpsAccuracyStatus(0);
            }
        } catch (Throwable th) {
        }
    }

    private AMapLocation g(AMapLocation aMapLocation) {
        if (i.a(aMapLocation) && this.B >= 3) {
            if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
                aMapLocation.setAccuracy(0.0f);
            }
            if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
                aMapLocation.setSpeed(0.0f);
            }
            return this.f.a(aMapLocation);
        }
        return aMapLocation;
    }

    private static void h(AMapLocation aMapLocation) {
        if (i.a(aMapLocation) && com.autonavi.aps.amapapi.utils.a.r()) {
            long time = aMapLocation.getTime();
            long currentTimeMillis = System.currentTimeMillis();
            long a2 = com.autonavi.aps.amapapi.utils.c.a(time, currentTimeMillis, com.autonavi.aps.amapapi.utils.a.s());
            if (a2 != time) {
                aMapLocation.setTime(a2);
                com.autonavi.aps.amapapi.utils.g.a(time, currentTimeMillis);
            }
        }
    }

    private void i() {
        if (this.b == null) {
            return;
        }
        try {
            n();
            this.s = true;
            Looper myLooper = Looper.myLooper();
            Looper looper = myLooper;
            if (myLooper == null) {
                looper = this.z.getMainLooper();
            }
            this.A = i.b();
            if (!a(this.b)) {
                a(8, 14, "no gps provider#1402", 0L);
                return;
            }
            try {
                if (i.a() - q >= 259200000) {
                    if (i.c(this.z, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==")) {
                        this.b.sendExtraCommand(GeocodeSearch.GPS, "force_xtra_injection", null);
                        q = i.a();
                        SharedPreferences.Editor a2 = com.autonavi.aps.amapapi.utils.h.a(this.z, "pref");
                        com.autonavi.aps.amapapi.utils.h.a(a2, "lagt", q);
                        com.autonavi.aps.amapapi.utils.h.a(a2);
                    } else {
                        b.a(new Exception("n_alec"), "OPENSDK_GL", "rlu_n_alec");
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
            }
            if (this.x == null) {
                this.x = new a(this);
            }
            this.b.requestLocationUpdates(GeocodeSearch.GPS, this.c.getInterval(), this.c.getDeviceModeDistanceFilter(), this.x, looper);
            if (Build.VERSION.SDK_INT >= 24) {
                GnssStatus.Callback callback = new GnssStatus.Callback() { // from class: com.amap.api.col.3sl.h.1
                    @Override // android.location.GnssStatus.Callback
                    public final void onFirstFix(int i) {
                        h.l();
                    }

                    @Override // android.location.GnssStatus.Callback
                    public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
                        h.this.a(gnssStatus);
                    }

                    @Override // android.location.GnssStatus.Callback
                    public final void onStarted() {
                        h.j();
                    }

                    @Override // android.location.GnssStatus.Callback
                    public final void onStopped() {
                        h.this.k();
                    }
                };
                this.F = callback;
                this.b.registerGnssStatusCallback(callback);
            } else {
                GpsStatus.Listener listener = new GpsStatus.Listener() { // from class: com.amap.api.col.3sl.h.2
                    @Override // android.location.GpsStatus.Listener
                    public final void onGpsStatusChanged(int i) {
                        try {
                            if (h.this.b == null) {
                                return;
                            }
                            h.this.D = h.this.b.getGpsStatus(h.this.D);
                            if (i == 1) {
                                h.j();
                            } else if (i == 2) {
                                h.this.k();
                            } else if (i == 3) {
                                h.l();
                            } else if (i != 4) {
                            } else {
                                h.this.m();
                            }
                        } catch (Throwable th2) {
                            th2.getMessage();
                            b.a(th2, "GpsLocation", "onGpsStatusChanged");
                        }
                    }
                };
                this.E = listener;
                this.b.addGpsStatusListener(listener);
            }
            a(8, 14, "no enough satellites#1401", this.c.getHttpTimeOut());
        } catch (SecurityException e) {
            this.s = false;
            com.autonavi.aps.amapapi.utils.g.a((String) null, 2121);
            a(2, 12, e.getMessage() + "#1201", 0L);
        } catch (Throwable th2) {
            th2.getMessage();
            b.a(th2, "GpsLocation", "requestLocationUpdates part2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.C = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        try {
            if (this.D != null) {
                Iterable<GpsSatellite> satellites = this.D.getSatellites();
                i3 = 0;
                if (satellites != null) {
                    Iterator<GpsSatellite> it = satellites.iterator();
                    int maxSatellites = this.D.getMaxSatellites();
                    while (true) {
                        i2 = i;
                        i3 = i;
                        if (!it.hasNext()) {
                            break;
                        }
                        i3 = i;
                        if (i >= maxSatellites) {
                            break;
                        } else if (it.next().usedInFix()) {
                            i++;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            b.a(th, "GpsLocation", "GPS_EVENT_SATELLITE_STATUS");
            i3 = i2;
        }
        this.C = i3;
    }

    private void n() {
        if (i.b() - k > 5000 || !i.a(j)) {
            return;
        }
        if (this.c.isMockEnable() || !j.isMock()) {
            this.d = i.b();
            c(j);
        }
    }

    private static boolean o() {
        try {
            return ((Boolean) e.a(ib.c("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), ib.c("UaXNOYXZpU3RhcnRlZA=="), (Object[]) null, (Class[]) null)).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    private AMapLocation p() {
        float f;
        float f2;
        try {
            if (i.a(this.i) && com.autonavi.aps.amapapi.utils.a.j() && o()) {
                JSONObject jSONObject = new JSONObject((String) e.a(ib.c("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), ib.c("UZ2V0TmF2aUxvY2F0aW9u"), (Object[]) null, (Class[]) null));
                long optLong = jSONObject.optLong(g.a.g);
                if (!this.J) {
                    this.J = true;
                    com.autonavi.aps.amapapi.utils.g.a("useNaviLoc", "use NaviLoc");
                }
                if (i.a() - optLong <= 5500) {
                    double optDouble = jSONObject.optDouble(c.B, 0.0d);
                    double optDouble2 = jSONObject.optDouble("lng", 0.0d);
                    float f3 = 0.0f;
                    try {
                        f = Float.parseFloat(jSONObject.optString("accuracy", "0"));
                    } catch (NumberFormatException e) {
                        f = 0.0f;
                    }
                    double optDouble3 = jSONObject.optDouble("altitude", 0.0d);
                    try {
                        f2 = Float.parseFloat(jSONObject.optString("bearing", "0"));
                    } catch (NumberFormatException e2) {
                        f2 = 0.0f;
                    }
                    try {
                        f3 = (Float.parseFloat(jSONObject.optString("speed", "0")) * 10.0f) / 36.0f;
                    } catch (NumberFormatException e3) {
                    }
                    AMapLocation aMapLocation = new AMapLocation("lbs");
                    aMapLocation.setLocationType(9);
                    aMapLocation.setLatitude(optDouble);
                    aMapLocation.setLongitude(optDouble2);
                    aMapLocation.setAccuracy(f);
                    aMapLocation.setAltitude(optDouble3);
                    aMapLocation.setBearing(f2);
                    aMapLocation.setSpeed(f3);
                    aMapLocation.setTime(optLong);
                    aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                    if (i.a(aMapLocation, this.i) <= 300.0f) {
                        synchronized (this.p) {
                            this.i.setLongitude(optDouble2);
                            this.i.setLatitude(optDouble);
                            this.i.setAccuracy(f);
                            this.i.setBearing(f2);
                            this.i.setSpeed(f3);
                            this.i.setTime(optLong);
                            this.i.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                        }
                        return aMapLocation;
                    }
                    return null;
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.amap.api.location.AMapLocation a(com.amap.api.location.AMapLocation r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.h.a(com.amap.api.location.AMapLocation, java.lang.String):com.amap.api.location.AMapLocation");
    }

    public final void a() {
        LocationManager locationManager = this.b;
        if (locationManager == null) {
            return;
        }
        try {
            if (this.x != null) {
                locationManager.removeUpdates(this.x);
                ((a) this.x).a();
                this.x = null;
            }
        } catch (Throwable th) {
        }
        try {
            if (this.E != null) {
                this.b.removeGpsStatusListener(this.E);
            }
        } catch (Throwable th2) {
        }
        try {
            if (this.F != null) {
                this.b.unregisterGnssStatusCallback(this.F);
            }
        } catch (Throwable th3) {
        }
        try {
            if (this.a != null) {
                this.a.removeMessages(8);
            }
        } catch (Throwable th4) {
        }
        this.C = 0;
        this.A = 0L;
        this.v = 0L;
        this.d = 0L;
        this.B = 0;
        this.w = 0;
        this.f.a();
        this.i = null;
        this.m = 0L;
        this.n = 0.0f;
        this.G = null;
        this.J = false;
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.g = bundle.getInt("I_MAX_GEO_DIS");
                this.h = bundle.getInt("I_MIN_GEO_DIS");
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    return;
                }
                synchronized (this.o) {
                    y = aMapLocation;
                }
            } catch (Throwable th) {
                b.a(th, "GpsLocation", "setLastGeoLocation");
            }
        }
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.c = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.c = new AMapLocationClientOption();
        }
        try {
            q = com.autonavi.aps.amapapi.utils.h.a(this.z, "pref", "lagt", q);
        } catch (Throwable th) {
        }
        i();
    }

    public final void b(AMapLocationClientOption aMapLocationClientOption) {
        Handler handler;
        AMapLocationClientOption aMapLocationClientOption2 = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption2 = new AMapLocationClientOption();
        }
        this.c = aMapLocationClientOption2;
        if (aMapLocationClientOption2.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors && (handler = this.a) != null) {
            handler.removeMessages(8);
        }
        if (this.r != this.c.getGeoLanguage()) {
            synchronized (this.o) {
                y = null;
            }
        }
        this.r = this.c.getGeoLanguage();
    }

    public final boolean b() {
        return i.b() - this.d <= 2800;
    }

    public final void c() {
        this.w = 0;
    }

    public final int d() {
        LocationManager locationManager = this.b;
        if (locationManager != null && a(locationManager)) {
            if (Build.VERSION.SDK_INT >= 19) {
                int i = Settings.Secure.getInt(this.z.getContentResolver(), "location_mode", 0);
                if (i == 0) {
                    return 2;
                }
                if (i == 2) {
                    return 3;
                }
            } else if (!this.b.isProviderEnabled(GeocodeSearch.GPS)) {
                return 2;
            }
            return !this.s ? 4 : 0;
        }
        return 1;
    }

    public final int e() {
        return this.C;
    }

    public final boolean f() {
        AMapLocationClientOption aMapLocationClientOption = this.c;
        return (aMapLocationClientOption == null || aMapLocationClientOption.isOnceLocation() || i.b() - this.d <= 300000) ? false : true;
    }
}
