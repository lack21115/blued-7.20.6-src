package android.hardware.location;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.location.IGeofenceHardware;
import android.location.IFusedGeofenceHardware;
import android.location.IGpsGeofenceHardware;
import android.os.Binder;
import android.os.IBinder;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/location/GeofenceHardwareService.class */
public class GeofenceHardwareService extends Service {
    private IBinder mBinder = new IGeofenceHardware.Stub() { // from class: android.hardware.location.GeofenceHardwareService.1
        @Override // android.hardware.location.IGeofenceHardware
        public boolean addCircularFence(int i, GeofenceHardwareRequestParcelable geofenceHardwareRequestParcelable, IGeofenceHardwareCallback iGeofenceHardwareCallback) {
            GeofenceHardwareService.this.mContext.enforceCallingPermission(Manifest.permission.LOCATION_HARDWARE, "Location Hardware permission not granted to access hardware geofence");
            GeofenceHardwareService.this.checkPermission(Binder.getCallingPid(), Binder.getCallingUid(), i);
            return GeofenceHardwareService.this.mGeofenceHardwareImpl.addCircularFence(i, geofenceHardwareRequestParcelable, iGeofenceHardwareCallback);
        }

        @Override // android.hardware.location.IGeofenceHardware
        public int[] getMonitoringTypes() {
            GeofenceHardwareService.this.mContext.enforceCallingPermission(Manifest.permission.LOCATION_HARDWARE, "Location Hardware permission not granted to access hardware geofence");
            return GeofenceHardwareService.this.mGeofenceHardwareImpl.getMonitoringTypes();
        }

        @Override // android.hardware.location.IGeofenceHardware
        public int getStatusOfMonitoringType(int i) {
            GeofenceHardwareService.this.mContext.enforceCallingPermission(Manifest.permission.LOCATION_HARDWARE, "Location Hardware permission not granted to access hardware geofence");
            return GeofenceHardwareService.this.mGeofenceHardwareImpl.getStatusOfMonitoringType(i);
        }

        @Override // android.hardware.location.IGeofenceHardware
        public boolean pauseGeofence(int i, int i2) {
            GeofenceHardwareService.this.mContext.enforceCallingPermission(Manifest.permission.LOCATION_HARDWARE, "Location Hardware permission not granted to access hardware geofence");
            GeofenceHardwareService.this.checkPermission(Binder.getCallingPid(), Binder.getCallingUid(), i2);
            return GeofenceHardwareService.this.mGeofenceHardwareImpl.pauseGeofence(i, i2);
        }

        @Override // android.hardware.location.IGeofenceHardware
        public boolean registerForMonitorStateChangeCallback(int i, IGeofenceHardwareMonitorCallback iGeofenceHardwareMonitorCallback) {
            GeofenceHardwareService.this.mContext.enforceCallingPermission(Manifest.permission.LOCATION_HARDWARE, "Location Hardware permission not granted to access hardware geofence");
            GeofenceHardwareService.this.checkPermission(Binder.getCallingPid(), Binder.getCallingUid(), i);
            return GeofenceHardwareService.this.mGeofenceHardwareImpl.registerForMonitorStateChangeCallback(i, iGeofenceHardwareMonitorCallback);
        }

        @Override // android.hardware.location.IGeofenceHardware
        public boolean removeGeofence(int i, int i2) {
            GeofenceHardwareService.this.mContext.enforceCallingPermission(Manifest.permission.LOCATION_HARDWARE, "Location Hardware permission not granted to access hardware geofence");
            GeofenceHardwareService.this.checkPermission(Binder.getCallingPid(), Binder.getCallingUid(), i2);
            return GeofenceHardwareService.this.mGeofenceHardwareImpl.removeGeofence(i, i2);
        }

        @Override // android.hardware.location.IGeofenceHardware
        public boolean resumeGeofence(int i, int i2, int i3) {
            GeofenceHardwareService.this.mContext.enforceCallingPermission(Manifest.permission.LOCATION_HARDWARE, "Location Hardware permission not granted to access hardware geofence");
            GeofenceHardwareService.this.checkPermission(Binder.getCallingPid(), Binder.getCallingUid(), i2);
            return GeofenceHardwareService.this.mGeofenceHardwareImpl.resumeGeofence(i, i2, i3);
        }

        @Override // android.hardware.location.IGeofenceHardware
        public void setFusedGeofenceHardware(IFusedGeofenceHardware iFusedGeofenceHardware) {
            GeofenceHardwareService.this.mGeofenceHardwareImpl.setFusedGeofenceHardware(iFusedGeofenceHardware);
        }

        @Override // android.hardware.location.IGeofenceHardware
        public void setGpsGeofenceHardware(IGpsGeofenceHardware iGpsGeofenceHardware) {
            GeofenceHardwareService.this.mGeofenceHardwareImpl.setGpsHardwareGeofence(iGpsGeofenceHardware);
        }

        @Override // android.hardware.location.IGeofenceHardware
        public boolean unregisterForMonitorStateChangeCallback(int i, IGeofenceHardwareMonitorCallback iGeofenceHardwareMonitorCallback) {
            GeofenceHardwareService.this.mContext.enforceCallingPermission(Manifest.permission.LOCATION_HARDWARE, "Location Hardware permission not granted to access hardware geofence");
            GeofenceHardwareService.this.checkPermission(Binder.getCallingPid(), Binder.getCallingUid(), i);
            return GeofenceHardwareService.this.mGeofenceHardwareImpl.unregisterForMonitorStateChangeCallback(i, iGeofenceHardwareMonitorCallback);
        }
    };
    private Context mContext;
    private GeofenceHardwareImpl mGeofenceHardwareImpl;

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPermission(int i, int i2, int i3) {
        if (this.mGeofenceHardwareImpl.getAllowedResolutionLevel(i, i2) < this.mGeofenceHardwareImpl.getMonitoringResolutionLevel(i3)) {
            throw new SecurityException("Insufficient permissions to access hardware geofence for type: " + i3);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.mContext = this;
        this.mGeofenceHardwareImpl = GeofenceHardwareImpl.getInstance(this.mContext);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.mGeofenceHardwareImpl = null;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return false;
    }
}
