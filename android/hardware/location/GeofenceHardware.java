package android.hardware.location;

import android.hardware.location.IGeofenceHardwareCallback;
import android.hardware.location.IGeofenceHardwareMonitorCallback;
import android.location.Location;
import android.os.Build;
import android.os.RemoteException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/location/GeofenceHardware.class */
public final class GeofenceHardware {
    public static final int GEOFENCE_ENTERED = 1;
    public static final int GEOFENCE_ERROR_ID_EXISTS = 2;
    public static final int GEOFENCE_ERROR_ID_UNKNOWN = 3;
    public static final int GEOFENCE_ERROR_INSUFFICIENT_MEMORY = 6;
    public static final int GEOFENCE_ERROR_INVALID_TRANSITION = 4;
    public static final int GEOFENCE_ERROR_TOO_MANY_GEOFENCES = 1;
    public static final int GEOFENCE_EXITED = 2;
    public static final int GEOFENCE_FAILURE = 5;
    public static final int GEOFENCE_SUCCESS = 0;
    public static final int GEOFENCE_UNCERTAIN = 4;
    public static final int MONITORING_TYPE_FUSED_HARDWARE = 1;
    public static final int MONITORING_TYPE_GPS_HARDWARE = 0;
    public static final int MONITOR_CURRENTLY_AVAILABLE = 0;
    public static final int MONITOR_CURRENTLY_UNAVAILABLE = 1;
    public static final int MONITOR_UNSUPPORTED = 2;
    static final int NUM_MONITORS = 2;
    public static final int SOURCE_TECHNOLOGY_BLUETOOTH = 16;
    public static final int SOURCE_TECHNOLOGY_CELL = 8;
    public static final int SOURCE_TECHNOLOGY_GNSS = 1;
    public static final int SOURCE_TECHNOLOGY_SENSORS = 4;
    public static final int SOURCE_TECHNOLOGY_WIFI = 2;
    private HashMap<GeofenceHardwareCallback, GeofenceHardwareCallbackWrapper> mCallbacks = new HashMap<>();
    private HashMap<GeofenceHardwareMonitorCallback, GeofenceHardwareMonitorCallbackWrapper> mMonitorCallbacks = new HashMap<>();
    private IGeofenceHardware mService;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/location/GeofenceHardware$GeofenceHardwareCallbackWrapper.class */
    public class GeofenceHardwareCallbackWrapper extends IGeofenceHardwareCallback.Stub {
        private WeakReference<GeofenceHardwareCallback> mCallback;

        GeofenceHardwareCallbackWrapper(GeofenceHardwareCallback geofenceHardwareCallback) {
            this.mCallback = new WeakReference<>(geofenceHardwareCallback);
        }

        @Override // android.hardware.location.IGeofenceHardwareCallback
        public void onGeofenceAdd(int i, int i2) {
            GeofenceHardwareCallback geofenceHardwareCallback = this.mCallback.get();
            if (geofenceHardwareCallback != null) {
                geofenceHardwareCallback.onGeofenceAdd(i, i2);
            }
        }

        @Override // android.hardware.location.IGeofenceHardwareCallback
        public void onGeofencePause(int i, int i2) {
            GeofenceHardwareCallback geofenceHardwareCallback = this.mCallback.get();
            if (geofenceHardwareCallback != null) {
                geofenceHardwareCallback.onGeofencePause(i, i2);
            }
        }

        @Override // android.hardware.location.IGeofenceHardwareCallback
        public void onGeofenceRemove(int i, int i2) {
            GeofenceHardwareCallback geofenceHardwareCallback = this.mCallback.get();
            if (geofenceHardwareCallback != null) {
                geofenceHardwareCallback.onGeofenceRemove(i, i2);
                GeofenceHardware.this.removeCallback(geofenceHardwareCallback);
            }
        }

        @Override // android.hardware.location.IGeofenceHardwareCallback
        public void onGeofenceResume(int i, int i2) {
            GeofenceHardwareCallback geofenceHardwareCallback = this.mCallback.get();
            if (geofenceHardwareCallback != null) {
                geofenceHardwareCallback.onGeofenceResume(i, i2);
            }
        }

        @Override // android.hardware.location.IGeofenceHardwareCallback
        public void onGeofenceTransition(int i, int i2, Location location, long j, int i3) {
            GeofenceHardwareCallback geofenceHardwareCallback = this.mCallback.get();
            if (geofenceHardwareCallback != null) {
                geofenceHardwareCallback.onGeofenceTransition(i, i2, location, j, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/location/GeofenceHardware$GeofenceHardwareMonitorCallbackWrapper.class */
    public class GeofenceHardwareMonitorCallbackWrapper extends IGeofenceHardwareMonitorCallback.Stub {
        private WeakReference<GeofenceHardwareMonitorCallback> mCallback;

        GeofenceHardwareMonitorCallbackWrapper(GeofenceHardwareMonitorCallback geofenceHardwareMonitorCallback) {
            this.mCallback = new WeakReference<>(geofenceHardwareMonitorCallback);
        }

        @Override // android.hardware.location.IGeofenceHardwareMonitorCallback
        public void onMonitoringSystemChange(GeofenceHardwareMonitorEvent geofenceHardwareMonitorEvent) {
            GeofenceHardwareMonitorCallback geofenceHardwareMonitorCallback = this.mCallback.get();
            if (geofenceHardwareMonitorCallback == null) {
                return;
            }
            geofenceHardwareMonitorCallback.onMonitoringSystemChange(geofenceHardwareMonitorEvent.getMonitoringType(), geofenceHardwareMonitorEvent.getMonitoringStatus() == 0, geofenceHardwareMonitorEvent.getLocation());
            if (Build.VERSION.SDK_INT >= 21) {
                geofenceHardwareMonitorCallback.onMonitoringSystemChange(geofenceHardwareMonitorEvent);
            }
        }
    }

    public GeofenceHardware(IGeofenceHardware iGeofenceHardware) {
        this.mService = iGeofenceHardware;
    }

    private GeofenceHardwareCallbackWrapper getCallbackWrapper(GeofenceHardwareCallback geofenceHardwareCallback) {
        GeofenceHardwareCallbackWrapper geofenceHardwareCallbackWrapper;
        synchronized (this.mCallbacks) {
            GeofenceHardwareCallbackWrapper geofenceHardwareCallbackWrapper2 = this.mCallbacks.get(geofenceHardwareCallback);
            geofenceHardwareCallbackWrapper = geofenceHardwareCallbackWrapper2;
            if (geofenceHardwareCallbackWrapper2 == null) {
                geofenceHardwareCallbackWrapper = new GeofenceHardwareCallbackWrapper(geofenceHardwareCallback);
                this.mCallbacks.put(geofenceHardwareCallback, geofenceHardwareCallbackWrapper);
            }
        }
        return geofenceHardwareCallbackWrapper;
    }

    private GeofenceHardwareMonitorCallbackWrapper getMonitorCallbackWrapper(GeofenceHardwareMonitorCallback geofenceHardwareMonitorCallback) {
        GeofenceHardwareMonitorCallbackWrapper geofenceHardwareMonitorCallbackWrapper;
        synchronized (this.mMonitorCallbacks) {
            GeofenceHardwareMonitorCallbackWrapper geofenceHardwareMonitorCallbackWrapper2 = this.mMonitorCallbacks.get(geofenceHardwareMonitorCallback);
            geofenceHardwareMonitorCallbackWrapper = geofenceHardwareMonitorCallbackWrapper2;
            if (geofenceHardwareMonitorCallbackWrapper2 == null) {
                geofenceHardwareMonitorCallbackWrapper = new GeofenceHardwareMonitorCallbackWrapper(geofenceHardwareMonitorCallback);
                this.mMonitorCallbacks.put(geofenceHardwareMonitorCallback, geofenceHardwareMonitorCallbackWrapper);
            }
        }
        return geofenceHardwareMonitorCallbackWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCallback(GeofenceHardwareCallback geofenceHardwareCallback) {
        synchronized (this.mCallbacks) {
            this.mCallbacks.remove(geofenceHardwareCallback);
        }
    }

    private void removeMonitorCallback(GeofenceHardwareMonitorCallback geofenceHardwareMonitorCallback) {
        synchronized (this.mMonitorCallbacks) {
            this.mMonitorCallbacks.remove(geofenceHardwareMonitorCallback);
        }
    }

    public boolean addGeofence(int i, int i2, GeofenceHardwareRequest geofenceHardwareRequest, GeofenceHardwareCallback geofenceHardwareCallback) {
        try {
            if (geofenceHardwareRequest.getType() == 0) {
                return this.mService.addCircularFence(i2, new GeofenceHardwareRequestParcelable(i, geofenceHardwareRequest), getCallbackWrapper(geofenceHardwareCallback));
            }
            throw new IllegalArgumentException("Geofence Request type not supported");
        } catch (RemoteException e) {
            return false;
        }
    }

    public int[] getMonitoringTypes() {
        try {
            return this.mService.getMonitoringTypes();
        } catch (RemoteException e) {
            return new int[0];
        }
    }

    public int getStatusOfMonitoringType(int i) {
        try {
            return this.mService.getStatusOfMonitoringType(i);
        } catch (RemoteException e) {
            return 2;
        }
    }

    public boolean pauseGeofence(int i, int i2) {
        try {
            return this.mService.pauseGeofence(i, i2);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean registerForMonitorStateChangeCallback(int i, GeofenceHardwareMonitorCallback geofenceHardwareMonitorCallback) {
        try {
            return this.mService.registerForMonitorStateChangeCallback(i, getMonitorCallbackWrapper(geofenceHardwareMonitorCallback));
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean removeGeofence(int i, int i2) {
        try {
            return this.mService.removeGeofence(i, i2);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean resumeGeofence(int i, int i2, int i3) {
        try {
            return this.mService.resumeGeofence(i, i2, i3);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean unregisterForMonitorStateChangeCallback(int i, GeofenceHardwareMonitorCallback geofenceHardwareMonitorCallback) {
        boolean z = false;
        try {
            boolean unregisterForMonitorStateChangeCallback = this.mService.unregisterForMonitorStateChangeCallback(i, getMonitorCallbackWrapper(geofenceHardwareMonitorCallback));
            if (unregisterForMonitorStateChangeCallback) {
                z = unregisterForMonitorStateChangeCallback;
                removeMonitorCallback(geofenceHardwareMonitorCallback);
            }
            return unregisterForMonitorStateChangeCallback;
        } catch (RemoteException e) {
            return z;
        }
    }
}
