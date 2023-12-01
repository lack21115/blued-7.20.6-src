package android.location;

import android.os.Parcel;
import android.os.Parcelable;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* loaded from: source-9557208-dex2jar.jar:android/location/GpsMeasurementsEvent.class */
public class GpsMeasurementsEvent implements Parcelable {
    public static final Parcelable.Creator<GpsMeasurementsEvent> CREATOR = new Parcelable.Creator<GpsMeasurementsEvent>() { // from class: android.location.GpsMeasurementsEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GpsMeasurementsEvent createFromParcel(Parcel parcel) {
            GpsClock gpsClock = (GpsClock) parcel.readParcelable(getClass().getClassLoader());
            GpsMeasurement[] gpsMeasurementArr = new GpsMeasurement[parcel.readInt()];
            parcel.readTypedArray(gpsMeasurementArr, GpsMeasurement.CREATOR);
            return new GpsMeasurementsEvent(gpsClock, gpsMeasurementArr);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GpsMeasurementsEvent[] newArray(int i) {
            return new GpsMeasurementsEvent[i];
        }
    };
    public static final int STATUS_GPS_LOCATION_DISABLED = 2;
    public static final int STATUS_NOT_SUPPORTED = 0;
    public static final int STATUS_READY = 1;
    private final GpsClock mClock;
    private final Collection<GpsMeasurement> mReadOnlyMeasurements;

    /* loaded from: source-9557208-dex2jar.jar:android/location/GpsMeasurementsEvent$Listener.class */
    public interface Listener {
        void onGpsMeasurementsReceived(GpsMeasurementsEvent gpsMeasurementsEvent);

        void onStatusChanged(int i);
    }

    public GpsMeasurementsEvent(GpsClock gpsClock, GpsMeasurement[] gpsMeasurementArr) {
        if (gpsClock == null) {
            throw new InvalidParameterException("Parameter 'clock' must not be null.");
        }
        if (gpsMeasurementArr == null || gpsMeasurementArr.length == 0) {
            throw new InvalidParameterException("Parameter 'measurements' must not be null or empty.");
        }
        this.mClock = gpsClock;
        this.mReadOnlyMeasurements = Collections.unmodifiableCollection(Arrays.asList(gpsMeasurementArr));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public GpsClock getClock() {
        return this.mClock;
    }

    public Collection<GpsMeasurement> getMeasurements() {
        return this.mReadOnlyMeasurements;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ GpsMeasurementsEvent:\n\n");
        sb.append(this.mClock.toString());
        sb.append("\n");
        for (GpsMeasurement gpsMeasurement : this.mReadOnlyMeasurements) {
            sb.append(gpsMeasurement.toString());
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mClock, i);
        GpsMeasurement[] gpsMeasurementArr = (GpsMeasurement[]) this.mReadOnlyMeasurements.toArray(new GpsMeasurement[this.mReadOnlyMeasurements.size()]);
        parcel.writeInt(gpsMeasurementArr.length);
        parcel.writeTypedArray(gpsMeasurementArr, i);
    }
}
