package android.app;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/app/ProfilerInfo.class */
public class ProfilerInfo implements Parcelable {
    public static final Parcelable.Creator<ProfilerInfo> CREATOR = new Parcelable.Creator<ProfilerInfo>() { // from class: android.app.ProfilerInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProfilerInfo createFromParcel(Parcel parcel) {
            return new ProfilerInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProfilerInfo[] newArray(int i) {
            return new ProfilerInfo[i];
        }
    };
    public final boolean autoStopProfiler;
    public ParcelFileDescriptor profileFd;
    public final String profileFile;
    public final int samplingInterval;

    private ProfilerInfo(Parcel parcel) {
        this.profileFile = parcel.readString();
        this.profileFd = parcel.readInt() != 0 ? ParcelFileDescriptor.CREATOR.createFromParcel(parcel) : null;
        this.samplingInterval = parcel.readInt();
        this.autoStopProfiler = parcel.readInt() != 0;
    }

    public ProfilerInfo(String str, ParcelFileDescriptor parcelFileDescriptor, int i, boolean z) {
        this.profileFile = str;
        this.profileFd = parcelFileDescriptor;
        this.samplingInterval = i;
        this.autoStopProfiler = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        if (this.profileFd != null) {
            return this.profileFd.describeContents();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.profileFile);
        if (this.profileFd != null) {
            parcel.writeInt(1);
            this.profileFd.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.samplingInterval);
        parcel.writeInt(this.autoStopProfiler ? 1 : 0);
    }
}
