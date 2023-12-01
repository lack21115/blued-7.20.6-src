package c.t.m.g;

import android.location.Location;
import android.text.format.DateFormat;
import com.tencent.map.geolocation.TencentLocation;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/y3.class */
public class y3 {
    public static Location a(TencentLocation tencentLocation, boolean z) {
        if (tencentLocation == null) {
            return null;
        }
        String provider = tencentLocation.getProvider();
        Location location = new Location(provider);
        location.setLatitude(tencentLocation.getLatitude());
        location.setLongitude(tencentLocation.getLongitude());
        location.setAccuracy(tencentLocation.getAccuracy());
        location.setTime(tencentLocation.getTime());
        if (z && "gps".equals(provider)) {
            double[] dArr = new double[2];
            f6.a(location, dArr);
            location.setLatitude(dArr[0]);
            location.setLongitude(dArr[1]);
            ((q5) tencentLocation).b(location);
        }
        return location;
    }

    public static String a(TencentLocation tencentLocation, int i) {
        CharSequence format = DateFormat.format("yyyy-MM-dd kk:mm:ss", tencentLocation == null ? System.currentTimeMillis() : tencentLocation.getTime());
        return ((Object) format) + " error=" + i + tencentLocation + "\n";
    }

    public static void a(Location location) {
        if (location.getAccuracy() > 500.0f) {
            location.setAccuracy(500.0f);
        }
    }
}
