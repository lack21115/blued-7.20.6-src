package android.telecom;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/CameraCapabilities.class */
public final class CameraCapabilities implements Parcelable {
    public static final Parcelable.Creator<CameraCapabilities> CREATOR = new Parcelable.Creator<CameraCapabilities>() { // from class: android.telecom.CameraCapabilities.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraCapabilities createFromParcel(Parcel parcel) {
            return new CameraCapabilities(parcel.readByte() != 0, parcel.readFloat(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraCapabilities[] newArray(int i) {
            return new CameraCapabilities[i];
        }
    };
    private final int mHeight;
    private final float mMaxZoom;
    private final int mWidth;
    private final boolean mZoomSupported;

    public CameraCapabilities(boolean z, float f, int i, int i2) {
        this.mZoomSupported = z;
        this.mMaxZoom = f;
        this.mWidth = i;
        this.mHeight = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public float getMaxZoom() {
        return this.mMaxZoom;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isZoomSupported() {
        return this.mZoomSupported;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (isZoomSupported() ? 1 : 0));
        parcel.writeFloat(getMaxZoom());
        parcel.writeInt(getWidth());
        parcel.writeInt(getHeight());
    }
}
