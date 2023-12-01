package android.hardware.location;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/location/GeofenceHardwareRequest.class */
public final class GeofenceHardwareRequest {
    static final int GEOFENCE_TYPE_CIRCLE = 0;
    private double mLatitude;
    private double mLongitude;
    private double mRadius;
    private int mType;
    private int mLastTransition = 4;
    private int mUnknownTimer = 30000;
    private int mMonitorTransitions = 7;
    private int mNotificationResponsiveness = 5000;
    private int mSourceTechnologies = 1;

    public static GeofenceHardwareRequest createCircularGeofence(double d, double d2, double d3) {
        GeofenceHardwareRequest geofenceHardwareRequest = new GeofenceHardwareRequest();
        geofenceHardwareRequest.setCircularGeofence(d, d2, d3);
        return geofenceHardwareRequest;
    }

    private void setCircularGeofence(double d, double d2, double d3) {
        this.mLatitude = d;
        this.mLongitude = d2;
        this.mRadius = d3;
        this.mType = 0;
    }

    public int getLastTransition() {
        return this.mLastTransition;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public int getMonitorTransitions() {
        return this.mMonitorTransitions;
    }

    public int getNotificationResponsiveness() {
        return this.mNotificationResponsiveness;
    }

    public double getRadius() {
        return this.mRadius;
    }

    public int getSourceTechnologies() {
        return this.mSourceTechnologies;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getType() {
        return this.mType;
    }

    public int getUnknownTimer() {
        return this.mUnknownTimer;
    }

    public void setLastTransition(int i) {
        this.mLastTransition = i;
    }

    public void setMonitorTransitions(int i) {
        this.mMonitorTransitions = i;
    }

    public void setNotificationResponsiveness(int i) {
        this.mNotificationResponsiveness = i;
    }

    public void setSourceTechnologies(int i) {
        int i2 = i & 31;
        if (i2 == 0) {
            throw new IllegalArgumentException("At least one valid source technology must be set.");
        }
        this.mSourceTechnologies = i2;
    }

    public void setUnknownTimer(int i) {
        this.mUnknownTimer = i;
    }
}
