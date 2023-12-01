package android.app.backup;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/app/backup/RestoreDescription.class */
public class RestoreDescription implements Parcelable {
    private static final String NO_MORE_PACKAGES_SENTINEL = "";
    public static final int TYPE_FULL_STREAM = 2;
    public static final int TYPE_KEY_VALUE = 1;
    private final int mDataType;
    private final String mPackageName;
    public static final RestoreDescription NO_MORE_PACKAGES = new RestoreDescription("", 0);
    public static final Parcelable.Creator<RestoreDescription> CREATOR = new Parcelable.Creator<RestoreDescription>() { // from class: android.app.backup.RestoreDescription.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RestoreDescription createFromParcel(Parcel parcel) {
            RestoreDescription restoreDescription = new RestoreDescription(parcel);
            RestoreDescription restoreDescription2 = restoreDescription;
            if ("".equals(restoreDescription.mPackageName)) {
                restoreDescription2 = RestoreDescription.NO_MORE_PACKAGES;
            }
            return restoreDescription2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RestoreDescription[] newArray(int i) {
            return new RestoreDescription[i];
        }
    };

    private RestoreDescription(Parcel parcel) {
        this.mPackageName = parcel.readString();
        this.mDataType = parcel.readInt();
    }

    public RestoreDescription(String str, int i) {
        this.mPackageName = str;
        this.mDataType = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDataType() {
        return this.mDataType;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String toString() {
        return "RestoreDescription{" + this.mPackageName + " : " + (this.mDataType == 1 ? "KEY_VALUE" : "STREAM") + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPackageName);
        parcel.writeInt(this.mDataType);
    }
}
