package android.app.backup;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/app/backup/RestoreSet.class */
public class RestoreSet implements Parcelable {
    public static final Parcelable.Creator<RestoreSet> CREATOR = new Parcelable.Creator<RestoreSet>() { // from class: android.app.backup.RestoreSet.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RestoreSet createFromParcel(Parcel parcel) {
            return new RestoreSet(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RestoreSet[] newArray(int i) {
            return new RestoreSet[i];
        }
    };
    public String device;
    public String name;
    public long token;

    public RestoreSet() {
    }

    private RestoreSet(Parcel parcel) {
        this.name = parcel.readString();
        this.device = parcel.readString();
        this.token = parcel.readLong();
    }

    public RestoreSet(String str, String str2, long j) {
        this.name = str;
        this.device = str2;
        this.token = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.device);
        parcel.writeLong(this.token);
    }
}
