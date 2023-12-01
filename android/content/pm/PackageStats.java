package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.UserHandle;
import com.alipay.sdk.util.i;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageStats.class */
public class PackageStats implements Parcelable {
    public static final Parcelable.Creator<PackageStats> CREATOR = new Parcelable.Creator<PackageStats>() { // from class: android.content.pm.PackageStats.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PackageStats createFromParcel(Parcel parcel) {
            return new PackageStats(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PackageStats[] newArray(int i) {
            return new PackageStats[i];
        }
    };
    public long cacheSize;
    public long codeSize;
    public long dataSize;
    public long externalCacheSize;
    public long externalCodeSize;
    public long externalDataSize;
    public long externalMediaSize;
    public long externalObbSize;
    public String packageName;
    public int userHandle;

    public PackageStats(PackageStats packageStats) {
        this.packageName = packageStats.packageName;
        this.userHandle = packageStats.userHandle;
        this.codeSize = packageStats.codeSize;
        this.dataSize = packageStats.dataSize;
        this.cacheSize = packageStats.cacheSize;
        this.externalCodeSize = packageStats.externalCodeSize;
        this.externalDataSize = packageStats.externalDataSize;
        this.externalCacheSize = packageStats.externalCacheSize;
        this.externalMediaSize = packageStats.externalMediaSize;
        this.externalObbSize = packageStats.externalObbSize;
    }

    public PackageStats(Parcel parcel) {
        this.packageName = parcel.readString();
        this.userHandle = parcel.readInt();
        this.codeSize = parcel.readLong();
        this.dataSize = parcel.readLong();
        this.cacheSize = parcel.readLong();
        this.externalCodeSize = parcel.readLong();
        this.externalDataSize = parcel.readLong();
        this.externalCacheSize = parcel.readLong();
        this.externalMediaSize = parcel.readLong();
        this.externalObbSize = parcel.readLong();
    }

    public PackageStats(String str) {
        this.packageName = str;
        this.userHandle = UserHandle.myUserId();
    }

    public PackageStats(String str, int i) {
        this.packageName = str;
        this.userHandle = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PackageStats{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" ");
        sb.append(this.packageName);
        if (this.codeSize != 0) {
            sb.append(" code=");
            sb.append(this.codeSize);
        }
        if (this.dataSize != 0) {
            sb.append(" data=");
            sb.append(this.dataSize);
        }
        if (this.cacheSize != 0) {
            sb.append(" cache=");
            sb.append(this.cacheSize);
        }
        if (this.externalCodeSize != 0) {
            sb.append(" extCode=");
            sb.append(this.externalCodeSize);
        }
        if (this.externalDataSize != 0) {
            sb.append(" extData=");
            sb.append(this.externalDataSize);
        }
        if (this.externalCacheSize != 0) {
            sb.append(" extCache=");
            sb.append(this.externalCacheSize);
        }
        if (this.externalMediaSize != 0) {
            sb.append(" media=");
            sb.append(this.externalMediaSize);
        }
        if (this.externalObbSize != 0) {
            sb.append(" obb=");
            sb.append(this.externalObbSize);
        }
        sb.append(i.d);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.packageName);
        parcel.writeInt(this.userHandle);
        parcel.writeLong(this.codeSize);
        parcel.writeLong(this.dataSize);
        parcel.writeLong(this.cacheSize);
        parcel.writeLong(this.externalCodeSize);
        parcel.writeLong(this.externalDataSize);
        parcel.writeLong(this.externalCacheSize);
        parcel.writeLong(this.externalMediaSize);
        parcel.writeLong(this.externalObbSize);
    }
}
