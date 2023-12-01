package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.util.i;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/FeatureInfo.class */
public class FeatureInfo implements Parcelable {
    public static final Parcelable.Creator<FeatureInfo> CREATOR = new Parcelable.Creator<FeatureInfo>() { // from class: android.content.pm.FeatureInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FeatureInfo createFromParcel(Parcel parcel) {
            return new FeatureInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FeatureInfo[] newArray(int i) {
            return new FeatureInfo[i];
        }
    };
    public static final int FLAG_REQUIRED = 1;
    public static final int GL_ES_VERSION_UNDEFINED = 0;
    public int flags;
    public String name;
    public int reqGlEsVersion;

    public FeatureInfo() {
    }

    public FeatureInfo(FeatureInfo featureInfo) {
        this.name = featureInfo.name;
        this.reqGlEsVersion = featureInfo.reqGlEsVersion;
        this.flags = featureInfo.flags;
    }

    private FeatureInfo(Parcel parcel) {
        this.name = parcel.readString();
        this.reqGlEsVersion = parcel.readInt();
        this.flags = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getGlEsVersion() {
        return String.valueOf((this.reqGlEsVersion & (-65536)) >> 16) + "." + String.valueOf(this.reqGlEsVersion & 65535);
    }

    public String toString() {
        return this.name != null ? "FeatureInfo{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.name + " fl=0x" + Integer.toHexString(this.flags) + i.d : "FeatureInfo{" + Integer.toHexString(System.identityHashCode(this)) + " glEsVers=" + getGlEsVersion() + " fl=0x" + Integer.toHexString(this.flags) + i.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeInt(this.reqGlEsVersion);
        parcel.writeInt(this.flags);
    }
}
