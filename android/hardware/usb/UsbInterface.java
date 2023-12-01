package android.hardware.usb;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/usb/UsbInterface.class */
public class UsbInterface implements Parcelable {
    public static final Parcelable.Creator<UsbInterface> CREATOR = new Parcelable.Creator<UsbInterface>() { // from class: android.hardware.usb.UsbInterface.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UsbInterface createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            String readString = parcel.readString();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            int readInt5 = parcel.readInt();
            Parcelable[] readParcelableArray = parcel.readParcelableArray(UsbEndpoint.class.getClassLoader());
            UsbInterface usbInterface = new UsbInterface(readInt, readInt2, readString, readInt3, readInt4, readInt5);
            usbInterface.setEndpoints(readParcelableArray);
            return usbInterface;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UsbInterface[] newArray(int i) {
            return new UsbInterface[i];
        }
    };
    private final int mAlternateSetting;
    private final int mClass;
    private Parcelable[] mEndpoints;
    private final int mId;
    private final String mName;
    private final int mProtocol;
    private final int mSubclass;

    public UsbInterface(int i, int i2, String str, int i3, int i4, int i5) {
        this.mId = i;
        this.mAlternateSetting = i2;
        this.mName = str;
        this.mClass = i3;
        this.mSubclass = i4;
        this.mProtocol = i5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAlternateSetting() {
        return this.mAlternateSetting;
    }

    public UsbEndpoint getEndpoint(int i) {
        return (UsbEndpoint) this.mEndpoints[i];
    }

    public int getEndpointCount() {
        return this.mEndpoints.length;
    }

    public int getId() {
        return this.mId;
    }

    public int getInterfaceClass() {
        return this.mClass;
    }

    public int getInterfaceProtocol() {
        return this.mProtocol;
    }

    public int getInterfaceSubclass() {
        return this.mSubclass;
    }

    public String getName() {
        return this.mName;
    }

    public void setEndpoints(Parcelable[] parcelableArr) {
        this.mEndpoints = parcelableArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UsbInterface[mId=" + this.mId + ",mAlternateSetting=" + this.mAlternateSetting + ",mName=" + this.mName + ",mClass=" + this.mClass + ",mSubclass=" + this.mSubclass + ",mProtocol=" + this.mProtocol + ",mEndpoints=[");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mEndpoints.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append("\n");
            sb.append(this.mEndpoints[i2].toString());
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mId);
        parcel.writeInt(this.mAlternateSetting);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mClass);
        parcel.writeInt(this.mSubclass);
        parcel.writeInt(this.mProtocol);
        parcel.writeParcelableArray(this.mEndpoints, 0);
    }
}
