package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import com.blued.das.live.LiveProtos;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageCleanItem.class */
public class PackageCleanItem {
    public static final Parcelable.Creator<PackageCleanItem> CREATOR = new Parcelable.Creator<PackageCleanItem>() { // from class: android.content.pm.PackageCleanItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PackageCleanItem createFromParcel(Parcel parcel) {
            return new PackageCleanItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PackageCleanItem[] newArray(int i) {
            return new PackageCleanItem[i];
        }
    };
    public final boolean andCode;
    public final String packageName;
    public final int userId;

    public PackageCleanItem(int i, String str, boolean z) {
        this.userId = i;
        this.packageName = str;
        this.andCode = z;
    }

    private PackageCleanItem(Parcel parcel) {
        this.userId = parcel.readInt();
        this.packageName = parcel.readString();
        this.andCode = parcel.readInt() != 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            try {
                PackageCleanItem packageCleanItem = (PackageCleanItem) obj;
                if (this.userId == packageCleanItem.userId && this.packageName.equals(packageCleanItem.packageName)) {
                    return this.andCode == packageCleanItem.andCode;
                }
                return false;
            } catch (ClassCastException e) {
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.userId;
        return ((((i + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.packageName.hashCode()) * 31) + (this.andCode ? 1 : 0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.userId);
        parcel.writeString(this.packageName);
        parcel.writeInt(this.andCode ? 1 : 0);
    }
}
