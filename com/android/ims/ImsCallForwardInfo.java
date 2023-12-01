package com.android.ims;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-4181928-dex2jar.jar:com/android/ims/ImsCallForwardInfo.class */
public class ImsCallForwardInfo implements Parcelable {
    public static final Parcelable.Creator<ImsCallForwardInfo> CREATOR = new Parcelable.Creator<ImsCallForwardInfo>() { // from class: com.android.ims.ImsCallForwardInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImsCallForwardInfo createFromParcel(Parcel parcel) {
            return new ImsCallForwardInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImsCallForwardInfo[] newArray(int i) {
            return new ImsCallForwardInfo[i];
        }
    };
    public int mCondition;
    public int mEndHour;
    public int mEndMinute;
    public String mNumber;
    public int mStartHour;
    public int mStartMinute;
    public int mStatus;
    public int mTimeSeconds;
    public int mToA;

    public ImsCallForwardInfo() {
    }

    public ImsCallForwardInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    private void readFromParcel(Parcel parcel) {
        this.mCondition = parcel.readInt();
        this.mStatus = parcel.readInt();
        this.mToA = parcel.readInt();
        this.mNumber = parcel.readString();
        this.mTimeSeconds = parcel.readInt();
        this.mStartHour = parcel.readInt();
        this.mStartMinute = parcel.readInt();
        this.mEndHour = parcel.readInt();
        this.mEndMinute = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return super.toString() + ", Condition: " + this.mCondition + ", Status: " + (this.mStatus == 0 ? "disabled" : "enabled") + ", ToA: " + this.mToA + ", Number=" + this.mNumber + ", Time (seconds): " + this.mTimeSeconds + ", StartHour : " + this.mStartHour + ", StartMinute : " + this.mStartMinute + ", EndHour : " + this.mEndMinute + ", EndMinute : " + this.mEndMinute;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCondition);
        parcel.writeInt(this.mStatus);
        parcel.writeInt(this.mToA);
        parcel.writeString(this.mNumber);
        parcel.writeInt(this.mTimeSeconds);
        parcel.writeInt(this.mStartHour);
        parcel.writeInt(this.mStartMinute);
        parcel.writeInt(this.mEndHour);
        parcel.writeInt(this.mEndMinute);
    }
}
