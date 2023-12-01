package com.android.ims;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: source-4181928-dex2jar.jar:com/android/ims/ImsSuppServiceNotification.class */
public class ImsSuppServiceNotification implements Parcelable {
    public static final Parcelable.Creator<ImsSuppServiceNotification> CREATOR = new Parcelable.Creator<ImsSuppServiceNotification>() { // from class: com.android.ims.ImsSuppServiceNotification.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImsSuppServiceNotification createFromParcel(Parcel parcel) {
            return new ImsSuppServiceNotification(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImsSuppServiceNotification[] newArray(int i) {
            return new ImsSuppServiceNotification[i];
        }
    };
    private static final String TAG = "ImsSuppServiceNotification";
    public int code;
    public String[] history;
    public int index;
    public int notificationType;
    public String number;
    public int type;

    public ImsSuppServiceNotification() {
    }

    public ImsSuppServiceNotification(Parcel parcel) {
        readFromParcel(parcel);
    }

    private void readFromParcel(Parcel parcel) {
        this.notificationType = parcel.readInt();
        this.code = parcel.readInt();
        this.index = parcel.readInt();
        this.type = parcel.readInt();
        this.number = parcel.readString();
        this.history = parcel.createStringArray();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "{ notificationType=" + this.notificationType + ", code=" + this.code + ", index=" + this.index + ", type=" + this.type + ", number=" + this.number + ", history=" + Arrays.toString(this.history) + " }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.notificationType);
        parcel.writeInt(this.code);
        parcel.writeInt(this.index);
        parcel.writeInt(this.type);
        parcel.writeString(this.number);
        parcel.writeStringArray(this.history);
    }
}
