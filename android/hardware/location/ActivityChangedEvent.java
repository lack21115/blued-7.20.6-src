package android.hardware.location;

import android.os.Parcel;
import android.os.Parcelable;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/location/ActivityChangedEvent.class */
public class ActivityChangedEvent implements Parcelable {
    public static final Parcelable.Creator<ActivityChangedEvent> CREATOR = new Parcelable.Creator<ActivityChangedEvent>() { // from class: android.hardware.location.ActivityChangedEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityChangedEvent createFromParcel(Parcel parcel) {
            ActivityRecognitionEvent[] activityRecognitionEventArr = new ActivityRecognitionEvent[parcel.readInt()];
            parcel.readTypedArray(activityRecognitionEventArr, ActivityRecognitionEvent.CREATOR);
            return new ActivityChangedEvent(activityRecognitionEventArr);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityChangedEvent[] newArray(int i) {
            return new ActivityChangedEvent[i];
        }
    };
    private final List<ActivityRecognitionEvent> mActivityRecognitionEvents;

    public ActivityChangedEvent(ActivityRecognitionEvent[] activityRecognitionEventArr) {
        if (activityRecognitionEventArr == null) {
            throw new InvalidParameterException("Parameter 'activityRecognitionEvents' must not be null.");
        }
        this.mActivityRecognitionEvents = Arrays.asList(activityRecognitionEventArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Iterable<ActivityRecognitionEvent> getActivityRecognitionEvents() {
        return this.mActivityRecognitionEvents;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ActivityChangedEvent:");
        for (ActivityRecognitionEvent activityRecognitionEvent : this.mActivityRecognitionEvents) {
            sb.append("\n    ");
            sb.append(activityRecognitionEvent.toString());
        }
        sb.append("\n]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ActivityRecognitionEvent[] activityRecognitionEventArr = (ActivityRecognitionEvent[]) this.mActivityRecognitionEvents.toArray(new ActivityRecognitionEvent[0]);
        parcel.writeInt(activityRecognitionEventArr.length);
        parcel.writeTypedArray(activityRecognitionEventArr, i);
    }
}
