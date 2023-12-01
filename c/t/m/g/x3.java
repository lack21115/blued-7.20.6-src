package c.t.m.g;

import android.app.PendingIntent;
import android.location.Location;
import com.opos.acs.st.STManager;
import com.tencent.map.geolocation.TencentGeofence;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/x3.class */
public class x3 {

    /* renamed from: a  reason: collision with root package name */
    public final TencentGeofence f4005a;
    public final Location b;

    /* renamed from: c  reason: collision with root package name */
    public final long f4006c;
    public final PendingIntent d;
    public int e = 0;
    public double f = Double.MAX_VALUE;
    public Object g;

    public x3(TencentGeofence tencentGeofence, long j, String str, PendingIntent pendingIntent) {
        this.f4005a = tencentGeofence;
        this.f4006c = j;
        this.d = pendingIntent;
        Location location = new Location("");
        this.b = location;
        location.setLatitude(tencentGeofence.getLatitude());
        this.b.setLongitude(tencentGeofence.getLongitude());
        this.b.setTime(0L);
        this.b.setSpeed(-0.001f);
    }

    public double a() {
        if (Double.compare(this.f, Double.MAX_VALUE) == 0) {
            return Double.MAX_VALUE;
        }
        return Math.abs(this.f4005a.getRadius() - this.f);
    }

    public final double a(double d, double d2, long j, long j2) {
        if (j == 0) {
            return -0.0010000000474974513d;
        }
        if (d2 >= d) {
            return 0.0d;
        }
        long abs = Math.abs(j2 - j) / 1000;
        double abs2 = Math.abs(d - d2);
        if (abs == 0) {
            abs++;
        }
        return abs2 / abs;
    }

    public int a(Location location) {
        if (location == this.g) {
            return 0;
        }
        this.g = location;
        double d = this.f;
        double a2 = f6.a(location.getLatitude(), location.getLongitude(), this.b.getLatitude(), this.b.getLongitude());
        long time = this.b.getTime();
        long time2 = location.getTime();
        float a3 = (float) a(d, a2, time, time2);
        this.b.setTime(time2);
        this.b.setSpeed(a3);
        this.f = a2;
        int i = this.e;
        if (a2 <= ((double) this.f4005a.getRadius())) {
            this.e = 1;
            return i != 1 ? 1 : 0;
        }
        this.e = 2;
        return i == 1 ? 2 : 0;
    }

    public float b() {
        float speed = this.b.getSpeed();
        if (speed <= -0.001f) {
            return -0.001f;
        }
        if (speed > 25.0f) {
            return 25.0f;
        }
        if (speed < 1.0f) {
            return 1.0f;
        }
        return speed;
    }

    public boolean c() {
        return this.e != 1 && this.b.getSpeed() >= 0.0f;
    }

    public String toString() {
        int i = this.e;
        return String.format(Locale.US, "%s dist=%5gm speed=%.2fm/s state=%s", this.f4005a.toString(), Double.valueOf(this.f), Float.valueOf(b()), i != 1 ? i != 2 ? "?" : "OUT" : STManager.REGION_OF_IN);
    }
}
