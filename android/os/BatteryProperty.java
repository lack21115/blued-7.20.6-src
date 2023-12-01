package android.os;

import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/os/BatteryProperty.class */
public class BatteryProperty implements Parcelable {
    public static final Parcelable.Creator<BatteryProperty> CREATOR = new Parcelable.Creator<BatteryProperty>() { // from class: android.os.BatteryProperty.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BatteryProperty createFromParcel(Parcel parcel) {
            return new BatteryProperty(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BatteryProperty[] newArray(int i) {
            return new BatteryProperty[i];
        }
    };
    private long mValueLong;

    public BatteryProperty() {
        this.mValueLong = Long.MIN_VALUE;
    }

    private BatteryProperty(Parcel parcel) {
        readFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getLong() {
        return this.mValueLong;
    }

    public void readFromParcel(Parcel parcel) {
        this.mValueLong = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mValueLong);
    }
}
