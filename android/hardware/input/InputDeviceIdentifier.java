package android.hardware.input;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/input/InputDeviceIdentifier.class */
public final class InputDeviceIdentifier implements Parcelable {
    public static final Parcelable.Creator<InputDeviceIdentifier> CREATOR = new Parcelable.Creator<InputDeviceIdentifier>() { // from class: android.hardware.input.InputDeviceIdentifier.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputDeviceIdentifier createFromParcel(Parcel parcel) {
            return new InputDeviceIdentifier(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputDeviceIdentifier[] newArray(int i) {
            return new InputDeviceIdentifier[i];
        }
    };
    private final String mDescriptor;
    private final int mProductId;
    private final int mVendorId;

    private InputDeviceIdentifier(Parcel parcel) {
        this.mDescriptor = parcel.readString();
        this.mVendorId = parcel.readInt();
        this.mProductId = parcel.readInt();
    }

    public InputDeviceIdentifier(String str, int i, int i2) {
        this.mDescriptor = str;
        this.mVendorId = i;
        this.mProductId = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDescriptor() {
        return this.mDescriptor;
    }

    public int getProductId() {
        return this.mProductId;
    }

    public int getVendorId() {
        return this.mVendorId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mDescriptor);
        parcel.writeInt(this.mVendorId);
        parcel.writeInt(this.mProductId);
    }
}
