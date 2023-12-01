package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/InstrumentationInfo.class */
public class InstrumentationInfo extends PackageItemInfo implements Parcelable {
    public static final Parcelable.Creator<InstrumentationInfo> CREATOR = new Parcelable.Creator<InstrumentationInfo>() { // from class: android.content.pm.InstrumentationInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InstrumentationInfo createFromParcel(Parcel parcel) {
            return new InstrumentationInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InstrumentationInfo[] newArray(int i) {
            return new InstrumentationInfo[i];
        }
    };
    public String dataDir;
    public boolean functionalTest;
    public boolean handleProfiling;
    public String nativeLibraryDir;
    public String publicSourceDir;
    public String sourceDir;
    public String[] splitPublicSourceDirs;
    public String[] splitSourceDirs;
    public String targetPackage;

    public InstrumentationInfo() {
    }

    public InstrumentationInfo(InstrumentationInfo instrumentationInfo) {
        super(instrumentationInfo);
        this.targetPackage = instrumentationInfo.targetPackage;
        this.sourceDir = instrumentationInfo.sourceDir;
        this.publicSourceDir = instrumentationInfo.publicSourceDir;
        this.dataDir = instrumentationInfo.dataDir;
        this.nativeLibraryDir = instrumentationInfo.nativeLibraryDir;
        this.handleProfiling = instrumentationInfo.handleProfiling;
        this.functionalTest = instrumentationInfo.functionalTest;
    }

    private InstrumentationInfo(Parcel parcel) {
        super(parcel);
        this.targetPackage = parcel.readString();
        this.sourceDir = parcel.readString();
        this.publicSourceDir = parcel.readString();
        this.dataDir = parcel.readString();
        this.nativeLibraryDir = parcel.readString();
        this.handleProfiling = parcel.readInt() != 0;
        this.functionalTest = parcel.readInt() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "InstrumentationInfo{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.packageName + "}";
    }

    @Override // android.content.pm.PackageItemInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.targetPackage);
        parcel.writeString(this.sourceDir);
        parcel.writeString(this.publicSourceDir);
        parcel.writeString(this.dataDir);
        parcel.writeString(this.nativeLibraryDir);
        parcel.writeInt(!this.handleProfiling ? 0 : 1);
        parcel.writeInt(!this.functionalTest ? 0 : 1);
    }
}
