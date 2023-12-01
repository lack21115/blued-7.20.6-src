package android.bluetooth.le;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.util.ArrayMap;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/le/AdvertiseData.class */
public final class AdvertiseData implements Parcelable {
    public static final Parcelable.Creator<AdvertiseData> CREATOR = new Parcelable.Creator<AdvertiseData>() { // from class: android.bluetooth.le.AdvertiseData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdvertiseData createFromParcel(Parcel parcel) {
            Builder builder = new Builder();
            ArrayList<ParcelUuid> readArrayList = parcel.readArrayList(ParcelUuid.class.getClassLoader());
            if (readArrayList != null) {
                for (ParcelUuid parcelUuid : readArrayList) {
                    builder.addServiceUuid(parcelUuid);
                }
            }
            int readInt = parcel.readInt();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    break;
                }
                int readInt2 = parcel.readInt();
                if (parcel.readInt() == 1) {
                    byte[] bArr = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr);
                    builder.addManufacturerData(readInt2, bArr);
                }
                i = i2 + 1;
            }
            int readInt3 = parcel.readInt();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= readInt3) {
                    break;
                }
                ParcelUuid parcelUuid2 = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                if (parcel.readInt() == 1) {
                    byte[] bArr2 = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr2);
                    builder.addServiceData(parcelUuid2, bArr2);
                }
                i3 = i4 + 1;
            }
            builder.setIncludeTxPowerLevel(parcel.readByte() == 1);
            builder.setIncludeDeviceName(parcel.readByte() == 1);
            return builder.build();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdvertiseData[] newArray(int i) {
            return new AdvertiseData[i];
        }
    };
    private final boolean mIncludeDeviceName;
    private final boolean mIncludeTxPowerLevel;
    private final SparseArray<byte[]> mManufacturerSpecificData;
    private final Map<ParcelUuid, byte[]> mServiceData;
    private final List<ParcelUuid> mServiceUuids;

    /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/le/AdvertiseData$Builder.class */
    public static final class Builder {
        private boolean mIncludeDeviceName;
        private boolean mIncludeTxPowerLevel;
        private List<ParcelUuid> mServiceUuids = new ArrayList();
        private SparseArray<byte[]> mManufacturerSpecificData = new SparseArray<>();
        private Map<ParcelUuid, byte[]> mServiceData = new ArrayMap();

        public Builder addManufacturerData(int i, byte[] bArr) {
            if (i < 0) {
                throw new IllegalArgumentException("invalid manufacturerId - " + i);
            }
            if (bArr == null) {
                throw new IllegalArgumentException("manufacturerSpecificData is null");
            }
            this.mManufacturerSpecificData.put(i, bArr);
            return this;
        }

        public Builder addServiceData(ParcelUuid parcelUuid, byte[] bArr) {
            if (parcelUuid == null || bArr == null) {
                throw new IllegalArgumentException("serviceDataUuid or serviceDataUuid is null");
            }
            this.mServiceData.put(parcelUuid, bArr);
            return this;
        }

        public Builder addServiceUuid(ParcelUuid parcelUuid) {
            if (parcelUuid == null) {
                throw new IllegalArgumentException("serivceUuids are null");
            }
            this.mServiceUuids.add(parcelUuid);
            return this;
        }

        public AdvertiseData build() {
            return new AdvertiseData(this.mServiceUuids, this.mManufacturerSpecificData, this.mServiceData, this.mIncludeTxPowerLevel, this.mIncludeDeviceName);
        }

        public Builder setIncludeDeviceName(boolean z) {
            this.mIncludeDeviceName = z;
            return this;
        }

        public Builder setIncludeTxPowerLevel(boolean z) {
            this.mIncludeTxPowerLevel = z;
            return this;
        }
    }

    private AdvertiseData(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, boolean z, boolean z2) {
        this.mServiceUuids = list;
        this.mManufacturerSpecificData = sparseArray;
        this.mServiceData = map;
        this.mIncludeTxPowerLevel = z;
        this.mIncludeDeviceName = z2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdvertiseData advertiseData = (AdvertiseData) obj;
        return Objects.equals(this.mServiceUuids, advertiseData.mServiceUuids) && BluetoothLeUtils.equals(this.mManufacturerSpecificData, advertiseData.mManufacturerSpecificData) && BluetoothLeUtils.equals(this.mServiceData, advertiseData.mServiceData) && this.mIncludeDeviceName == advertiseData.mIncludeDeviceName && this.mIncludeTxPowerLevel == advertiseData.mIncludeTxPowerLevel;
    }

    public boolean getIncludeDeviceName() {
        return this.mIncludeDeviceName;
    }

    public boolean getIncludeTxPowerLevel() {
        return this.mIncludeTxPowerLevel;
    }

    public SparseArray<byte[]> getManufacturerSpecificData() {
        return this.mManufacturerSpecificData;
    }

    public Map<ParcelUuid, byte[]> getServiceData() {
        return this.mServiceData;
    }

    public List<ParcelUuid> getServiceUuids() {
        return this.mServiceUuids;
    }

    public int hashCode() {
        return Objects.hash(this.mServiceUuids, this.mManufacturerSpecificData, this.mServiceData, Boolean.valueOf(this.mIncludeDeviceName), Boolean.valueOf(this.mIncludeTxPowerLevel));
    }

    public String toString() {
        return "AdvertiseData [mServiceUuids=" + this.mServiceUuids + ", mManufacturerSpecificData=" + BluetoothLeUtils.toString(this.mManufacturerSpecificData) + ", mServiceData=" + BluetoothLeUtils.toString(this.mServiceData) + ", mIncludeTxPowerLevel=" + this.mIncludeTxPowerLevel + ", mIncludeDeviceName=" + this.mIncludeDeviceName + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.mServiceUuids);
        parcel.writeInt(this.mManufacturerSpecificData.size());
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mManufacturerSpecificData.size()) {
                break;
            }
            parcel.writeInt(this.mManufacturerSpecificData.keyAt(i3));
            byte[] valueAt = this.mManufacturerSpecificData.valueAt(i3);
            if (valueAt == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(valueAt.length);
                parcel.writeByteArray(valueAt);
            }
            i2 = i3 + 1;
        }
        parcel.writeInt(this.mServiceData.size());
        for (ParcelUuid parcelUuid : this.mServiceData.keySet()) {
            parcel.writeParcelable(parcelUuid, i);
            byte[] bArr = this.mServiceData.get(parcelUuid);
            if (bArr == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(bArr.length);
                parcel.writeByteArray(bArr);
            }
        }
        parcel.writeByte((byte) (getIncludeTxPowerLevel() ? 1 : 0));
        parcel.writeByte((byte) (getIncludeDeviceName() ? 1 : 0));
    }
}
