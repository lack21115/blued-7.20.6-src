package android.hardware.location;

import android.location.Location;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/location/GeofenceHardwareMonitorCallback.class */
public abstract class GeofenceHardwareMonitorCallback {
    @Deprecated
    public void onMonitoringSystemChange(int i, boolean z, Location location) {
    }

    public void onMonitoringSystemChange(GeofenceHardwareMonitorEvent geofenceHardwareMonitorEvent) {
    }
}
