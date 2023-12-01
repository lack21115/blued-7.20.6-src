package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.util.i;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageInfoLite.class */
public class PackageInfoLite implements Parcelable {
    public static final Parcelable.Creator<PackageInfoLite> CREATOR = new Parcelable.Creator<PackageInfoLite>() { // from class: android.content.pm.PackageInfoLite.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PackageInfoLite createFromParcel(Parcel parcel) {
            return new PackageInfoLite(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PackageInfoLite[] newArray(int i) {
            return new PackageInfoLite[i];
        }
    };
    public int baseRevisionCode;
    public int installLocation;
    public boolean isTheme;
    public boolean multiArch;
    public String packageName;
    public int recommendedInstallLocation;
    public String[] splitNames;
    public int[] splitRevisionCodes;
    public VerifierInfo[] verifiers;
    public int versionCode;

    public PackageInfoLite() {
    }

    private PackageInfoLite(Parcel parcel) {
        this.packageName = parcel.readString();
        this.splitNames = parcel.createStringArray();
        this.versionCode = parcel.readInt();
        this.baseRevisionCode = parcel.readInt();
        this.splitRevisionCodes = parcel.createIntArray();
        this.recommendedInstallLocation = parcel.readInt();
        this.installLocation = parcel.readInt();
        this.multiArch = parcel.readInt() != 0;
        this.isTheme = parcel.readInt() == 1;
        int readInt = parcel.readInt();
        if (readInt == 0) {
            this.verifiers = new VerifierInfo[0];
            return;
        }
        this.verifiers = new VerifierInfo[readInt];
        parcel.readTypedArray(this.verifiers, VerifierInfo.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PackageInfoLite{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.packageName + i.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.packageName);
        parcel.writeStringArray(this.splitNames);
        parcel.writeInt(this.versionCode);
        parcel.writeInt(this.baseRevisionCode);
        parcel.writeIntArray(this.splitRevisionCodes);
        parcel.writeInt(this.recommendedInstallLocation);
        parcel.writeInt(this.installLocation);
        parcel.writeInt(this.multiArch ? 1 : 0);
        parcel.writeInt(this.isTheme ? 1 : 0);
        if (this.verifiers == null || this.verifiers.length == 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.verifiers.length);
        parcel.writeTypedArray(this.verifiers, i);
    }
}
