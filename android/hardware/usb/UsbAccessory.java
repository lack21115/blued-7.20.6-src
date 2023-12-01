package android.hardware.usb;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/usb/UsbAccessory.class */
public class UsbAccessory implements Parcelable {
    public static final Parcelable.Creator<UsbAccessory> CREATOR = new Parcelable.Creator<UsbAccessory>() { // from class: android.hardware.usb.UsbAccessory.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UsbAccessory createFromParcel(Parcel parcel) {
            return new UsbAccessory(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UsbAccessory[] newArray(int i) {
            return new UsbAccessory[i];
        }
    };
    public static final int DESCRIPTION_STRING = 2;
    public static final int MANUFACTURER_STRING = 0;
    public static final int MODEL_STRING = 1;
    public static final int SERIAL_STRING = 5;
    private static final String TAG = "UsbAccessory";
    public static final int URI_STRING = 4;
    public static final int VERSION_STRING = 3;
    private final String mDescription;
    private final String mManufacturer;
    private final String mModel;
    private final String mSerial;
    private final String mUri;
    private final String mVersion;

    public UsbAccessory(String str, String str2, String str3, String str4, String str5, String str6) {
        this.mManufacturer = str;
        this.mModel = str2;
        this.mDescription = str3;
        this.mVersion = str4;
        this.mUri = str5;
        this.mSerial = str6;
    }

    public UsbAccessory(String[] strArr) {
        this.mManufacturer = strArr[0];
        this.mModel = strArr[1];
        this.mDescription = strArr[2];
        this.mVersion = strArr[3];
        this.mUri = strArr[4];
        this.mSerial = strArr[5];
    }

    private static boolean compare(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof UsbAccessory) {
            UsbAccessory usbAccessory = (UsbAccessory) obj;
            z = false;
            if (compare(this.mManufacturer, usbAccessory.getManufacturer())) {
                z = false;
                if (compare(this.mModel, usbAccessory.getModel())) {
                    z = false;
                    if (compare(this.mDescription, usbAccessory.getDescription())) {
                        z = false;
                        if (compare(this.mVersion, usbAccessory.getVersion())) {
                            z = false;
                            if (compare(this.mUri, usbAccessory.getUri())) {
                                z = false;
                                if (compare(this.mSerial, usbAccessory.getSerial())) {
                                    z = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getManufacturer() {
        return this.mManufacturer;
    }

    public String getModel() {
        return this.mModel;
    }

    public String getSerial() {
        return this.mSerial;
    }

    public String getUri() {
        return this.mUri;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.mManufacturer == null ? 0 : this.mManufacturer.hashCode();
        int hashCode2 = this.mModel == null ? 0 : this.mModel.hashCode();
        int hashCode3 = this.mDescription == null ? 0 : this.mDescription.hashCode();
        int hashCode4 = this.mVersion == null ? 0 : this.mVersion.hashCode();
        int hashCode5 = this.mUri == null ? 0 : this.mUri.hashCode();
        if (this.mSerial != null) {
            i = this.mSerial.hashCode();
        }
        return (hashCode5 ^ (((hashCode2 ^ hashCode) ^ hashCode3) ^ hashCode4)) ^ i;
    }

    public String toString() {
        return "UsbAccessory[mManufacturer=" + this.mManufacturer + ", mModel=" + this.mModel + ", mDescription=" + this.mDescription + ", mVersion=" + this.mVersion + ", mUri=" + this.mUri + ", mSerial=" + this.mSerial + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mManufacturer);
        parcel.writeString(this.mModel);
        parcel.writeString(this.mDescription);
        parcel.writeString(this.mVersion);
        parcel.writeString(this.mUri);
        parcel.writeString(this.mSerial);
    }
}
