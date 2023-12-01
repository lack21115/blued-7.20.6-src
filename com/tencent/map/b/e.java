package com.tencent.map.b;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/e.class */
public final class e {
    private static LocationManager b;
    private static float d;

    /* renamed from: a  reason: collision with root package name */
    private Context f23526a = null;

    /* renamed from: c  reason: collision with root package name */
    private a f23527c = null;
    private c e = null;
    private b f = null;
    private boolean g = false;
    private byte[] h = new byte[0];
    private int i = 1024;
    private long j = 0;
    private boolean k = false;
    private int l = 0;
    private int m = 0;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/e$a.class */
    final class a implements GpsStatus.Listener, LocationListener {
        private a() {
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
            if (r4 != 3) goto L7;
         */
        @Override // android.location.GpsStatus.Listener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onGpsStatusChanged(int r4) {
            /*
                r3 = this;
                r0 = 1
                r5 = r0
                r0 = r4
                r1 = 1
                if (r0 == r1) goto L20
                r0 = 2
                r5 = r0
                r0 = r4
                r1 = 2
                if (r0 == r1) goto L16
                r0 = r4
                r1 = 3
                if (r0 == r1) goto L20
                goto L2b
            L16:
                r0 = r3
                com.tencent.map.b.e r0 = com.tencent.map.b.e.this
                r6 = r0
                r0 = 0
                r5 = r0
                goto L25
            L20:
                r0 = r3
                com.tencent.map.b.e r0 = com.tencent.map.b.e.this
                r6 = r0
            L25:
                r0 = r6
                r1 = r5
                int r0 = com.tencent.map.b.e.a(r0, r1)
            L2b:
                r0 = r3
                com.tencent.map.b.e r0 = com.tencent.map.b.e.this
                com.tencent.map.b.e.a(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.b.e.a.onGpsStatusChanged(int):void");
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            if (location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                boolean z = false;
                if (latitude != 29.999998211860657d) {
                    if (longitude == 103.99999916553497d) {
                        z = false;
                    } else {
                        z = false;
                        if (Math.abs(latitude) >= 1.0E-8d) {
                            if (Math.abs(longitude) < 1.0E-8d) {
                                z = false;
                            } else {
                                z = false;
                                if (latitude >= -90.0d) {
                                    z = false;
                                    if (latitude <= 90.0d) {
                                        z = false;
                                        if (longitude >= -180.0d) {
                                            z = longitude <= 180.0d;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (z) {
                    e.this.j = System.currentTimeMillis();
                    e.this.b();
                    e.a(e.this, 2);
                    e eVar = e.this;
                    eVar.f = new b(eVar, location, eVar.l, e.this.m, e.this.i, e.this.j);
                    if (e.this.e != null) {
                        e.this.e.a(e.this.f);
                    }
                }
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            if (str != null) {
                try {
                    if (str.equals("gps")) {
                        e eVar = e.this;
                        eVar.l = e.c(eVar, 0);
                        e.this.i = 0;
                        if (e.this.e != null) {
                            e.this.e.a(e.this.i);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
            if (str != null) {
                try {
                    if (str.equals("gps")) {
                        e.this.i = 4;
                        if (e.this.e != null) {
                            e.this.e.a(e.this.i);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/e$b.class */
    public final class b implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        private Location f23529a;
        private long b;

        /* renamed from: c  reason: collision with root package name */
        private int f23530c;

        public b(e eVar, Location location, int i, int i2, int i3, long j) {
            this.f23529a = null;
            this.b = 0L;
            this.f23530c = 0;
            if (location != null) {
                this.f23529a = new Location(location);
                this.f23530c = i2;
                this.b = j;
            }
        }

        public final boolean a() {
            if (this.f23529a == null) {
                return false;
            }
            int i = this.f23530c;
            return (i <= 0 || i >= 3) && System.currentTimeMillis() - this.b <= 30000;
        }

        public final Location b() {
            return this.f23529a;
        }

        public final Object clone() {
            b bVar;
            try {
                bVar = (b) super.clone();
            } catch (Exception e) {
                bVar = null;
            }
            if (this.f23529a != null) {
                bVar.f23529a = new Location(this.f23529a);
            }
            return bVar;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/e$c.class */
    public interface c {
        void a(int i);

        void a(b bVar);
    }

    static /* synthetic */ int a(e eVar, int i) {
        int i2 = i | eVar.i;
        eVar.i = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int i;
        this.m = 0;
        this.l = 0;
        GpsStatus gpsStatus = b.getGpsStatus(null);
        if (gpsStatus == null) {
            return;
        }
        int maxSatellites = gpsStatus.getMaxSatellites();
        Iterator<GpsSatellite> it = gpsStatus.getSatellites().iterator();
        if (it == null) {
            return;
        }
        while (it.hasNext() && (i = this.l) <= maxSatellites) {
            this.l = i + 1;
            if (it.next().usedInFix()) {
                this.m++;
            }
        }
    }

    static /* synthetic */ int c(e eVar, int i) {
        eVar.m = 0;
        return 0;
    }

    public final void a() {
        synchronized (this.h) {
            if (this.g) {
                if (b != null && this.f23527c != null) {
                    b.removeGpsStatusListener(this.f23527c);
                    b.removeUpdates(this.f23527c);
                }
                this.g = false;
            }
        }
    }

    public final boolean a(c cVar, Context context) {
        synchronized (this.h) {
            if (this.g) {
                return true;
            }
            if (context == null || cVar == null) {
                return false;
            }
            this.f23526a = context;
            this.e = cVar;
            try {
                b = (LocationManager) context.getSystemService("location");
                a aVar = new a(this, (byte) 0);
                this.f23527c = aVar;
                if (b == null || aVar == null) {
                    return false;
                }
                try {
                    b.requestLocationUpdates("gps", 1000L, 0.0f, aVar);
                    b.addGpsStatusListener(this.f23527c);
                    if (b.isProviderEnabled("gps")) {
                        this.i = 4;
                    } else {
                        this.i = 0;
                    }
                    this.g = true;
                    return true;
                } catch (Exception e) {
                    return false;
                }
            } catch (Exception e2) {
                return false;
            }
        }
    }
}
