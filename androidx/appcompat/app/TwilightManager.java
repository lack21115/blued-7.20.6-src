package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import java.util.Calendar;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/TwilightManager.class */
class TwilightManager {

    /* renamed from: a  reason: collision with root package name */
    private static TwilightManager f1557a;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final LocationManager f1558c;
    private final TwilightState d = new TwilightState();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/TwilightManager$TwilightState.class */
    public static class TwilightState {

        /* renamed from: a  reason: collision with root package name */
        boolean f1559a;
        long b;

        /* renamed from: c  reason: collision with root package name */
        long f1560c;
        long d;
        long e;
        long f;

        TwilightState() {
        }
    }

    TwilightManager(Context context, LocationManager locationManager) {
        this.b = context;
        this.f1558c = locationManager;
    }

    private Location a(String str) {
        try {
            if (this.f1558c.isProviderEnabled(str)) {
                return this.f1558c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TwilightManager a(Context context) {
        if (f1557a == null) {
            Context applicationContext = context.getApplicationContext();
            f1557a = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f1557a;
    }

    private void a(Location location) {
        long j;
        TwilightState twilightState = this.d;
        long currentTimeMillis = System.currentTimeMillis();
        TwilightCalculator a2 = TwilightCalculator.a();
        a2.calculateTwilight(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a2.sunset;
        a2.calculateTwilight(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a2.state == 1;
        long j3 = a2.sunrise;
        long j4 = a2.sunset;
        a2.calculateTwilight(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a2.sunrise;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
        }
        twilightState.f1559a = z;
        twilightState.b = j2;
        twilightState.f1560c = j3;
        twilightState.d = j4;
        twilightState.e = j5;
        twilightState.f = j;
    }

    private Location b() {
        Location location = null;
        Location a2 = PermissionChecker.checkSelfPermission(this.b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        if (PermissionChecker.checkSelfPermission(this.b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = a("gps");
        }
        if (location == null || a2 == null) {
            if (location != null) {
                a2 = location;
            }
            return a2;
        }
        Location location2 = a2;
        if (location.getTime() > a2.getTime()) {
            location2 = location;
        }
        return location2;
    }

    private boolean c() {
        return this.d.f > System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        TwilightState twilightState = this.d;
        if (c()) {
            return twilightState.f1559a;
        }
        Location b = b();
        if (b != null) {
            a(b);
            return twilightState.f1559a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
