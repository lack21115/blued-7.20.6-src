package android.media.projection;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.UserHandle;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/media/projection/MediaProjectionInfo.class */
public final class MediaProjectionInfo implements Parcelable {
    public static final Parcelable.Creator<MediaProjectionInfo> CREATOR = new Parcelable.Creator<MediaProjectionInfo>() { // from class: android.media.projection.MediaProjectionInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaProjectionInfo createFromParcel(Parcel parcel) {
            return new MediaProjectionInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaProjectionInfo[] newArray(int i) {
            return new MediaProjectionInfo[i];
        }
    };
    private final String mPackageName;
    private final UserHandle mUserHandle;

    public MediaProjectionInfo(Parcel parcel) {
        this.mPackageName = parcel.readString();
        this.mUserHandle = UserHandle.readFromParcel(parcel);
    }

    public MediaProjectionInfo(String str, UserHandle userHandle) {
        this.mPackageName = str;
        this.mUserHandle = userHandle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof MediaProjectionInfo) {
            MediaProjectionInfo mediaProjectionInfo = (MediaProjectionInfo) obj;
            z = false;
            if (Objects.equals(mediaProjectionInfo.mPackageName, this.mPackageName)) {
                z = false;
                if (Objects.equals(mediaProjectionInfo.mUserHandle, this.mUserHandle)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public UserHandle getUserHandle() {
        return this.mUserHandle;
    }

    public int hashCode() {
        return Objects.hash(this.mPackageName, this.mUserHandle);
    }

    public String toString() {
        return "MediaProjectionInfo{mPackageName=" + this.mPackageName + ", mUserHandle=" + this.mUserHandle + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPackageName);
        UserHandle.writeToParcel(this.mUserHandle, parcel);
    }
}
