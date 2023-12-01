package android.hardware.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/location/GeofenceHardwareRequestParcelable.class */
public final class GeofenceHardwareRequestParcelable implements Parcelable {
    public static final Parcelable.Creator<GeofenceHardwareRequestParcelable> CREATOR = new Parcelable.Creator<GeofenceHardwareRequestParcelable>() { // from class: android.hardware.location.GeofenceHardwareRequestParcelable.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeofenceHardwareRequestParcelable createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt != 0) {
                Log.e("GeofenceHardwareRequest", String.format("Invalid Geofence type: %d", Integer.valueOf(readInt)));
                return null;
            }
            GeofenceHardwareRequest createCircularGeofence = GeofenceHardwareRequest.createCircularGeofence(parcel.readDouble(), parcel.readDouble(), parcel.readDouble());
            createCircularGeofence.setLastTransition(parcel.readInt());
            createCircularGeofence.setMonitorTransitions(parcel.readInt());
            createCircularGeofence.setUnknownTimer(parcel.readInt());
            createCircularGeofence.setNotificationResponsiveness(parcel.readInt());
            createCircularGeofence.setSourceTechnologies(parcel.readInt());
            return new GeofenceHardwareRequestParcelable(parcel.readInt(), createCircularGeofence);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeofenceHardwareRequestParcelable[] newArray(int i) {
            return new GeofenceHardwareRequestParcelable[i];
        }
    };
    private int mId;
    private GeofenceHardwareRequest mRequest;

    public GeofenceHardwareRequestParcelable(int i, GeofenceHardwareRequest geofenceHardwareRequest) {
        this.mId = i;
        this.mRequest = geofenceHardwareRequest;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getId() {
        return this.mId;
    }

    public int getLastTransition() {
        return this.mRequest.getLastTransition();
    }

    public double getLatitude() {
        return this.mRequest.getLatitude();
    }

    public double getLongitude() {
        return this.mRequest.getLongitude();
    }

    public int getMonitorTransitions() {
        return this.mRequest.getMonitorTransitions();
    }

    public int getNotificationResponsiveness() {
        return this.mRequest.getNotificationResponsiveness();
    }

    public double getRadius() {
        return this.mRequest.getRadius();
    }

    int getSourceTechnologies() {
        return this.mRequest.getSourceTechnologies();
    }

    int getType() {
        return this.mRequest.getType();
    }

    public int getUnknownTimer() {
        return this.mRequest.getUnknownTimer();
    }

    public String toString() {
        return "id=" + this.mId + ", type=" + this.mRequest.getType() + ", latitude=" + this.mRequest.getLatitude() + ", longitude=" + this.mRequest.getLongitude() + ", radius=" + this.mRequest.getRadius() + ", lastTransition=" + this.mRequest.getLastTransition() + ", unknownTimer=" + this.mRequest.getUnknownTimer() + ", monitorTransitions=" + this.mRequest.getMonitorTransitions() + ", notificationResponsiveness=" + this.mRequest.getNotificationResponsiveness() + ", sourceTechnologies=" + this.mRequest.getSourceTechnologies();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getType());
        parcel.writeDouble(getLatitude());
        parcel.writeDouble(getLongitude());
        parcel.writeDouble(getRadius());
        parcel.writeInt(getLastTransition());
        parcel.writeInt(getMonitorTransitions());
        parcel.writeInt(getUnknownTimer());
        parcel.writeInt(getNotificationResponsiveness());
        parcel.writeInt(getSourceTechnologies());
        parcel.writeInt(getId());
    }
}
