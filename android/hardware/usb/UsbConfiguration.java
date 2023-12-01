package android.hardware.usb;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/usb/UsbConfiguration.class */
public class UsbConfiguration implements Parcelable {
    private static final int ATTR_REMOTE_WAKEUP = 32;
    private static final int ATTR_SELF_POWERED = 64;
    public static final Parcelable.Creator<UsbConfiguration> CREATOR = new Parcelable.Creator<UsbConfiguration>() { // from class: android.hardware.usb.UsbConfiguration.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UsbConfiguration createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            Parcelable[] readParcelableArray = parcel.readParcelableArray(UsbInterface.class.getClassLoader());
            UsbConfiguration usbConfiguration = new UsbConfiguration(readInt, readString, readInt2, readInt3);
            usbConfiguration.setInterfaces(readParcelableArray);
            return usbConfiguration;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UsbConfiguration[] newArray(int i) {
            return new UsbConfiguration[i];
        }
    };
    private final int mAttributes;
    private final int mId;
    private Parcelable[] mInterfaces;
    private final int mMaxPower;
    private final String mName;

    public UsbConfiguration(int i, String str, int i2, int i3) {
        this.mId = i;
        this.mName = str;
        this.mAttributes = i2;
        this.mMaxPower = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getId() {
        return this.mId;
    }

    public UsbInterface getInterface(int i) {
        return (UsbInterface) this.mInterfaces[i];
    }

    public int getInterfaceCount() {
        return this.mInterfaces.length;
    }

    public int getMaxPower() {
        return this.mMaxPower * 2;
    }

    public String getName() {
        return this.mName;
    }

    public boolean isRemoteWakeup() {
        return (this.mAttributes & 32) != 0;
    }

    public boolean isSelfPowered() {
        return (this.mAttributes & 64) != 0;
    }

    public void setInterfaces(Parcelable[] parcelableArr) {
        this.mInterfaces = parcelableArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UsbConfiguration[mId=" + this.mId + ",mName=" + this.mName + ",mAttributes=" + this.mAttributes + ",mMaxPower=" + this.mMaxPower + ",mInterfaces=[");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mInterfaces.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append("\n");
            sb.append(this.mInterfaces[i2].toString());
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mId);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mAttributes);
        parcel.writeInt(this.mMaxPower);
        parcel.writeParcelableArray(this.mInterfaces, 0);
    }
}
