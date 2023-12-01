package android.location;

import android.os.Bundle;

/* loaded from: source-9557208-dex2jar.jar:android/location/LocationListener.class */
public interface LocationListener {
    void onLocationChanged(Location location);

    void onProviderDisabled(String str);

    void onProviderEnabled(String str);

    void onStatusChanged(String str, int i, Bundle bundle);
}
