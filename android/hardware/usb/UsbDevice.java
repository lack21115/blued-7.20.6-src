package android.hardware.usb;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/usb/UsbDevice.class */
public class UsbDevice implements Parcelable {
    public static final Parcelable.Creator<UsbDevice> CREATOR = new Parcelable.Creator<UsbDevice>() { // from class: android.hardware.usb.UsbDevice.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UsbDevice createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            int readInt5 = parcel.readInt();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            Parcelable[] readParcelableArray = parcel.readParcelableArray(UsbInterface.class.getClassLoader());
            UsbDevice usbDevice = new UsbDevice(readString, readInt, readInt2, readInt3, readInt4, readInt5, readString2, readString3, readString4);
            usbDevice.setConfigurations(readParcelableArray);
            return usbDevice;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UsbDevice[] newArray(int i) {
            return new UsbDevice[i];
        }
    };
    private static final String TAG = "UsbDevice";
    private final int mClass;
    private Parcelable[] mConfigurations;
    private UsbInterface[] mInterfaces;
    private final String mManufacturerName;
    private final String mName;
    private final int mProductId;
    private final String mProductName;
    private final int mProtocol;
    private final String mSerialNumber;
    private final int mSubclass;
    private final int mVendorId;

    public UsbDevice(String str, int i, int i2, int i3, int i4, int i5, String str2, String str3, String str4) {
        this.mName = str;
        this.mVendorId = i;
        this.mProductId = i2;
        this.mClass = i3;
        this.mSubclass = i4;
        this.mProtocol = i5;
        this.mManufacturerName = str2;
        this.mProductName = str3;
        this.mSerialNumber = str4;
    }

    public static int getDeviceId(String str) {
        return native_get_device_id(str);
    }

    public static String getDeviceName(int i) {
        return native_get_device_name(i);
    }

    private UsbInterface[] getInterfaceList() {
        if (this.mInterfaces == null) {
            int length = this.mConfigurations.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                i += ((UsbConfiguration) this.mConfigurations[i3]).getInterfaceCount();
                i2 = i3 + 1;
            }
            this.mInterfaces = new UsbInterface[i];
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= length) {
                    break;
                }
                UsbConfiguration usbConfiguration = (UsbConfiguration) this.mConfigurations[i6];
                int interfaceCount = usbConfiguration.getInterfaceCount();
                int i7 = 0;
                while (i7 < interfaceCount) {
                    this.mInterfaces[i4] = usbConfiguration.getInterface(i7);
                    i7++;
                    i4++;
                }
                i5 = i6 + 1;
            }
        }
        return this.mInterfaces;
    }

    private static native int native_get_device_id(String str);

    private static native String native_get_device_name(int i);

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof UsbDevice) {
            return ((UsbDevice) obj).mName.equals(this.mName);
        }
        if (obj instanceof String) {
            return ((String) obj).equals(this.mName);
        }
        return false;
    }

    public UsbConfiguration getConfiguration(int i) {
        return (UsbConfiguration) this.mConfigurations[i];
    }

    public int getConfigurationCount() {
        return this.mConfigurations.length;
    }

    public int getDeviceClass() {
        return this.mClass;
    }

    public int getDeviceId() {
        return getDeviceId(this.mName);
    }

    public String getDeviceName() {
        return this.mName;
    }

    public int getDeviceProtocol() {
        return this.mProtocol;
    }

    public int getDeviceSubclass() {
        return this.mSubclass;
    }

    public UsbInterface getInterface(int i) {
        return getInterfaceList()[i];
    }

    public int getInterfaceCount() {
        return getInterfaceList().length;
    }

    public String getManufacturerName() {
        return this.mManufacturerName;
    }

    public int getProductId() {
        return this.mProductId;
    }

    public String getProductName() {
        return this.mProductName;
    }

    public String getSerialNumber() {
        return this.mSerialNumber;
    }

    public int getVendorId() {
        return this.mVendorId;
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public void setConfigurations(Parcelable[] parcelableArr) {
        this.mConfigurations = parcelableArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UsbDevice[mName=" + this.mName + ",mVendorId=" + this.mVendorId + ",mProductId=" + this.mProductId + ",mClass=" + this.mClass + ",mSubclass=" + this.mSubclass + ",mProtocol=" + this.mProtocol + ",mManufacturerName=" + this.mManufacturerName + ",mProductName=" + this.mProductName + ",mSerialNumber=" + this.mSerialNumber + ",mConfigurations=[");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mConfigurations.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append("\n");
            sb.append(this.mConfigurations[i2].toString());
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeInt(this.mVendorId);
        parcel.writeInt(this.mProductId);
        parcel.writeInt(this.mClass);
        parcel.writeInt(this.mSubclass);
        parcel.writeInt(this.mProtocol);
        parcel.writeString(this.mManufacturerName);
        parcel.writeString(this.mProductName);
        parcel.writeString(this.mSerialNumber);
        parcel.writeParcelableArray(this.mConfigurations, 0);
    }
}
