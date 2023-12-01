package android.nfc;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/TechListParcel.class */
public class TechListParcel implements Parcelable {
    public static final Parcelable.Creator<TechListParcel> CREATOR = new Parcelable.Creator<TechListParcel>() { // from class: android.nfc.TechListParcel.1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String[], java.lang.String[][]] */
        @Override // android.os.Parcelable.Creator
        public TechListParcel createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            ?? r0 = new String[readInt];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    return new TechListParcel(r0);
                }
                r0[i2] = parcel.readStringArray();
                i = i2 + 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TechListParcel[] newArray(int i) {
            return new TechListParcel[i];
        }
    };
    private String[][] mTechLists;

    public TechListParcel(String[]... strArr) {
        this.mTechLists = strArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String[][] getTechLists() {
        return this.mTechLists;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int length = this.mTechLists.length;
        parcel.writeInt(length);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            parcel.writeStringArray(this.mTechLists[i3]);
            i2 = i3 + 1;
        }
    }
}
