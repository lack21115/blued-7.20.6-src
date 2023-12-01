package android.bluetooth.le;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/le/ResultStorageDescriptor.class */
public final class ResultStorageDescriptor implements Parcelable {
    public static final Parcelable.Creator<ResultStorageDescriptor> CREATOR = new Parcelable.Creator<ResultStorageDescriptor>() { // from class: android.bluetooth.le.ResultStorageDescriptor.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResultStorageDescriptor createFromParcel(Parcel parcel) {
            return new ResultStorageDescriptor(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResultStorageDescriptor[] newArray(int i) {
            return new ResultStorageDescriptor[i];
        }
    };
    private int mLength;
    private int mOffset;
    private int mType;

    public ResultStorageDescriptor(int i, int i2, int i3) {
        this.mType = i;
        this.mOffset = i2;
        this.mLength = i3;
    }

    private ResultStorageDescriptor(Parcel parcel) {
        ReadFromParcel(parcel);
    }

    private void ReadFromParcel(Parcel parcel) {
        this.mType = parcel.readInt();
        this.mOffset = parcel.readInt();
        this.mLength = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getLength() {
        return this.mLength;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public int getType() {
        return this.mType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mOffset);
        parcel.writeInt(this.mLength);
    }
}
