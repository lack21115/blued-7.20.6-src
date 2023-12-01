package android.hardware;

import android.hardware.Camera;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/CameraInfo.class */
public class CameraInfo implements Parcelable {
    public static final Parcelable.Creator<CameraInfo> CREATOR = new Parcelable.Creator<CameraInfo>() { // from class: android.hardware.CameraInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraInfo createFromParcel(Parcel parcel) {
            CameraInfo cameraInfo = new CameraInfo();
            cameraInfo.readFromParcel(parcel);
            return cameraInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraInfo[] newArray(int i) {
            return new CameraInfo[i];
        }
    };
    public Camera.CameraInfo info = new Camera.CameraInfo();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.info.facing = parcel.readInt();
        this.info.orientation = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.info.facing);
        parcel.writeInt(this.info.orientation);
    }
}
