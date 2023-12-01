package android.hardware.hdmi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiHotplugEvent.class */
public final class HdmiHotplugEvent implements Parcelable {
    public static final Parcelable.Creator<HdmiHotplugEvent> CREATOR = new Parcelable.Creator<HdmiHotplugEvent>() { // from class: android.hardware.hdmi.HdmiHotplugEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HdmiHotplugEvent createFromParcel(Parcel parcel) {
            boolean z = true;
            int readInt = parcel.readInt();
            if (parcel.readByte() != 1) {
                z = false;
            }
            return new HdmiHotplugEvent(readInt, z);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HdmiHotplugEvent[] newArray(int i) {
            return new HdmiHotplugEvent[i];
        }
    };
    private final boolean mConnected;
    private final int mPort;

    public HdmiHotplugEvent(int i, boolean z) {
        this.mPort = i;
        this.mConnected = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPort() {
        return this.mPort;
    }

    public boolean isConnected() {
        return this.mConnected;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mPort);
        parcel.writeByte((byte) (this.mConnected ? 1 : 0));
    }
}
