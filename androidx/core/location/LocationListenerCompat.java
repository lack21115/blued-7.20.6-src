package androidx.core.location;

import android.location.LocationListener;
import android.os.Bundle;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationListenerCompat.class */
public interface LocationListenerCompat extends LocationListener {

    /* renamed from: androidx.core.location.LocationListenerCompat$-CC  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationListenerCompat$-CC.class */
    public final /* synthetic */ class CC {
        public static void $default$onProviderDisabled(LocationListenerCompat locationListenerCompat, String str) {
        }

        public static void $default$onProviderEnabled(LocationListenerCompat locationListenerCompat, String str) {
        }

        public static void $default$onStatusChanged(LocationListenerCompat locationListenerCompat, String str, int i, Bundle bundle) {
        }
    }

    @Override // android.location.LocationListener
    void onProviderDisabled(String str);

    @Override // android.location.LocationListener
    void onProviderEnabled(String str);

    @Override // android.location.LocationListener
    void onStatusChanged(String str, int i, Bundle bundle);
}
