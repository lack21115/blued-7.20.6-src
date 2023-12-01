package android.hardware.hdmi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiDeviceInfo.class */
public class HdmiDeviceInfo implements Parcelable {
    public static final int ADDR_INTERNAL = 0;
    public static final int DEVICE_AUDIO_SYSTEM = 5;
    public static final int DEVICE_INACTIVE = -1;
    public static final int DEVICE_PLAYBACK = 4;
    public static final int DEVICE_PURE_CEC_SWITCH = 6;
    public static final int DEVICE_RECORDER = 1;
    public static final int DEVICE_RESERVED = 2;
    public static final int DEVICE_TUNER = 3;
    public static final int DEVICE_TV = 0;
    public static final int DEVICE_VIDEO_PROCESSOR = 7;
    private static final int HDMI_DEVICE_TYPE_CEC = 0;
    private static final int HDMI_DEVICE_TYPE_HARDWARE = 2;
    private static final int HDMI_DEVICE_TYPE_INACTIVE = 100;
    private static final int HDMI_DEVICE_TYPE_MHL = 1;
    public static final int ID_INVALID = 65535;
    private static final int ID_OFFSET_CEC = 0;
    private static final int ID_OFFSET_HARDWARE = 192;
    private static final int ID_OFFSET_MHL = 128;
    public static final int PATH_INTERNAL = 0;
    public static final int PATH_INVALID = 65535;
    public static final int PORT_INVALID = -1;
    private final int mAdopterId;
    private final int mDeviceId;
    private final int mDevicePowerStatus;
    private final int mDeviceType;
    private final String mDisplayName;
    private final int mHdmiDeviceType;
    private final int mId;
    private final int mLogicalAddress;
    private final int mPhysicalAddress;
    private final int mPortId;
    private final int mVendorId;
    public static final HdmiDeviceInfo INACTIVE_DEVICE = new HdmiDeviceInfo();
    public static final Parcelable.Creator<HdmiDeviceInfo> CREATOR = new Parcelable.Creator<HdmiDeviceInfo>() { // from class: android.hardware.hdmi.HdmiDeviceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HdmiDeviceInfo createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            switch (readInt) {
                case 0:
                    return new HdmiDeviceInfo(parcel.readInt(), readInt2, readInt3, parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt());
                case 1:
                    return new HdmiDeviceInfo(readInt2, readInt3, parcel.readInt(), parcel.readInt());
                case 2:
                    return new HdmiDeviceInfo(readInt2, readInt3);
                case 100:
                    return HdmiDeviceInfo.INACTIVE_DEVICE;
                default:
                    return null;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HdmiDeviceInfo[] newArray(int i) {
            return new HdmiDeviceInfo[i];
        }
    };

    public HdmiDeviceInfo() {
        this.mHdmiDeviceType = 100;
        this.mPhysicalAddress = 65535;
        this.mId = 65535;
        this.mLogicalAddress = -1;
        this.mDeviceType = -1;
        this.mPortId = -1;
        this.mDevicePowerStatus = -1;
        this.mDisplayName = "Inactive";
        this.mVendorId = 0;
        this.mDeviceId = -1;
        this.mAdopterId = -1;
    }

    public HdmiDeviceInfo(int i, int i2) {
        this.mHdmiDeviceType = 2;
        this.mPhysicalAddress = i;
        this.mPortId = i2;
        this.mId = idForHardware(i2);
        this.mLogicalAddress = -1;
        this.mDeviceType = 2;
        this.mVendorId = 0;
        this.mDevicePowerStatus = -1;
        this.mDisplayName = "HDMI" + i2;
        this.mDeviceId = -1;
        this.mAdopterId = -1;
    }

    public HdmiDeviceInfo(int i, int i2, int i3, int i4) {
        this.mHdmiDeviceType = 1;
        this.mPhysicalAddress = i;
        this.mPortId = i2;
        this.mId = idForMhlDevice(i2);
        this.mLogicalAddress = -1;
        this.mDeviceType = 2;
        this.mVendorId = 0;
        this.mDevicePowerStatus = -1;
        this.mDisplayName = "Mobile";
        this.mDeviceId = i3;
        this.mAdopterId = i4;
    }

    public HdmiDeviceInfo(int i, int i2, int i3, int i4, int i5, String str) {
        this(i, i2, i3, i4, i5, str, -1);
    }

    public HdmiDeviceInfo(int i, int i2, int i3, int i4, int i5, String str, int i6) {
        this.mHdmiDeviceType = 0;
        this.mPhysicalAddress = i2;
        this.mPortId = i3;
        this.mId = idForCecDevice(i);
        this.mLogicalAddress = i;
        this.mDeviceType = i4;
        this.mVendorId = i5;
        this.mDevicePowerStatus = i6;
        this.mDisplayName = str;
        this.mDeviceId = -1;
        this.mAdopterId = -1;
    }

    public static int idForCecDevice(int i) {
        return i + 0;
    }

    public static int idForHardware(int i) {
        return i + 192;
    }

    public static int idForMhlDevice(int i) {
        return i + 128;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof HdmiDeviceInfo) {
            HdmiDeviceInfo hdmiDeviceInfo = (HdmiDeviceInfo) obj;
            return this.mHdmiDeviceType == hdmiDeviceInfo.mHdmiDeviceType && this.mPhysicalAddress == hdmiDeviceInfo.mPhysicalAddress && this.mPortId == hdmiDeviceInfo.mPortId && this.mLogicalAddress == hdmiDeviceInfo.mLogicalAddress && this.mDeviceType == hdmiDeviceInfo.mDeviceType && this.mVendorId == hdmiDeviceInfo.mVendorId && this.mDevicePowerStatus == hdmiDeviceInfo.mDevicePowerStatus && this.mDisplayName.equals(hdmiDeviceInfo.mDisplayName) && this.mDeviceId == hdmiDeviceInfo.mDeviceId && this.mAdopterId == hdmiDeviceInfo.mAdopterId;
        }
        return false;
    }

    public int getAdopterId() {
        return this.mAdopterId;
    }

    public int getDeviceId() {
        return this.mDeviceId;
    }

    public int getDevicePowerStatus() {
        return this.mDevicePowerStatus;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public int getId() {
        return this.mId;
    }

    public int getLogicalAddress() {
        return this.mLogicalAddress;
    }

    public int getPhysicalAddress() {
        return this.mPhysicalAddress;
    }

    public int getPortId() {
        return this.mPortId;
    }

    public int getVendorId() {
        return this.mVendorId;
    }

    public boolean isCecDevice() {
        return this.mHdmiDeviceType == 0;
    }

    public boolean isInactivated() {
        return this.mHdmiDeviceType == 100;
    }

    public boolean isMhlDevice() {
        return this.mHdmiDeviceType == 1;
    }

    public boolean isSourceType() {
        boolean z = false;
        if (isCecDevice()) {
            if (this.mDeviceType == 4 || this.mDeviceType == 1 || this.mDeviceType == 3) {
                z = true;
            }
        } else if (isMhlDevice()) {
            return true;
        }
        return z;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        switch (this.mHdmiDeviceType) {
            case 0:
                stringBuffer.append("CEC: ");
                stringBuffer.append("logical_address: ").append(String.format("0x%02X", Integer.valueOf(this.mLogicalAddress)));
                stringBuffer.append(" ");
                stringBuffer.append("device_type: ").append(this.mDeviceType).append(" ");
                stringBuffer.append("vendor_id: ").append(this.mVendorId).append(" ");
                stringBuffer.append("display_name: ").append(this.mDisplayName).append(" ");
                stringBuffer.append("power_status: ").append(this.mDevicePowerStatus).append(" ");
                break;
            case 1:
                stringBuffer.append("MHL: ");
                stringBuffer.append("device_id: ").append(String.format("0x%04X", Integer.valueOf(this.mDeviceId))).append(" ");
                stringBuffer.append("adopter_id: ").append(String.format("0x%04X", Integer.valueOf(this.mAdopterId))).append(" ");
                break;
            case 2:
                stringBuffer.append("Hardware: ");
                break;
            case 100:
                stringBuffer.append("Inactivated: ");
                break;
            default:
                return "";
        }
        stringBuffer.append("physical_address: ").append(String.format("0x%04X", Integer.valueOf(this.mPhysicalAddress)));
        stringBuffer.append(" ");
        stringBuffer.append("port_id: ").append(this.mPortId);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mHdmiDeviceType);
        parcel.writeInt(this.mPhysicalAddress);
        parcel.writeInt(this.mPortId);
        switch (this.mHdmiDeviceType) {
            case 0:
                parcel.writeInt(this.mLogicalAddress);
                parcel.writeInt(this.mDeviceType);
                parcel.writeInt(this.mVendorId);
                parcel.writeInt(this.mDevicePowerStatus);
                parcel.writeString(this.mDisplayName);
                return;
            case 1:
                parcel.writeInt(this.mDeviceId);
                parcel.writeInt(this.mAdopterId);
                return;
            default:
                return;
        }
    }
}
