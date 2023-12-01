package android.hardware.hdmi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiPortInfo.class */
public final class HdmiPortInfo implements Parcelable {
    public static final Parcelable.Creator<HdmiPortInfo> CREATOR = new Parcelable.Creator<HdmiPortInfo>() { // from class: android.hardware.hdmi.HdmiPortInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HdmiPortInfo createFromParcel(Parcel parcel) {
            return new HdmiPortInfo(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HdmiPortInfo[] newArray(int i) {
            return new HdmiPortInfo[i];
        }
    };
    public static final int PORT_INPUT = 0;
    public static final int PORT_OUTPUT = 1;
    private final int mAddress;
    private final boolean mArcSupported;
    private final boolean mCecSupported;
    private final int mId;
    private final boolean mMhlSupported;
    private final int mType;

    public HdmiPortInfo(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.mId = i;
        this.mType = i2;
        this.mAddress = i3;
        this.mCecSupported = z;
        this.mArcSupported = z3;
        this.mMhlSupported = z2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof HdmiPortInfo) {
            HdmiPortInfo hdmiPortInfo = (HdmiPortInfo) obj;
            return this.mId == hdmiPortInfo.mId && this.mType == hdmiPortInfo.mType && this.mAddress == hdmiPortInfo.mAddress && this.mCecSupported == hdmiPortInfo.mCecSupported && this.mArcSupported == hdmiPortInfo.mArcSupported && this.mMhlSupported == hdmiPortInfo.mMhlSupported;
        }
        return false;
    }

    public int getAddress() {
        return this.mAddress;
    }

    public int getId() {
        return this.mId;
    }

    public int getType() {
        return this.mType;
    }

    public boolean isArcSupported() {
        return this.mArcSupported;
    }

    public boolean isCecSupported() {
        return this.mCecSupported;
    }

    public boolean isMhlSupported() {
        return this.mMhlSupported;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("port_id: ").append(this.mId).append(", ");
        stringBuffer.append("address: ").append(String.format("0x%04x", Integer.valueOf(this.mAddress))).append(", ");
        stringBuffer.append("cec: ").append(this.mCecSupported).append(", ");
        stringBuffer.append("arc: ").append(this.mArcSupported).append(", ");
        stringBuffer.append("mhl: ").append(this.mMhlSupported);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mId);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mAddress);
        parcel.writeInt(this.mCecSupported ? 1 : 0);
        parcel.writeInt(this.mArcSupported ? 1 : 0);
        parcel.writeInt(this.mMhlSupported ? 1 : 0);
    }
}
