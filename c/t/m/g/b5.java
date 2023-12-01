package c.t.m.g;

import android.location.Location;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/b5.class */
public class b5 extends d5 {

    /* renamed from: a  reason: collision with root package name */
    public final Location f3715a;
    public final long b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3716c;
    public final int d;
    public final int e;
    public final a f;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/b5$a.class */
    public enum a {
        NONE,
        GPS,
        PDR,
        VDR
    }

    public b5(Location location, long j, int i, int i2, int i3, a aVar) {
        this.f3715a = location;
        this.b = j;
        this.f3716c = i;
        this.d = i2;
        this.e = i3;
        this.f = aVar;
    }

    public b5(b5 b5Var) {
        this.f3715a = b5Var.f3715a == null ? null : new Location(b5Var.f3715a);
        this.b = b5Var.b;
        this.f3716c = b5Var.f3716c;
        this.d = b5Var.d;
        this.e = b5Var.e;
        this.f = b5Var.f;
    }

    public String toString() {
        return "TxGpsInfo [location=" + this.f3715a + ", gpsTime=" + this.b + ", visbleSatelliteNum=" + this.f3716c + ", usedSatelliteNum=" + this.d + ", gpsStatus=" + this.e + "]";
    }
}
