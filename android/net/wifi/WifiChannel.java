package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiChannel.class */
public class WifiChannel implements Parcelable {
    public static final Parcelable.Creator<WifiChannel> CREATOR = new Parcelable.Creator<WifiChannel>() { // from class: android.net.wifi.WifiChannel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiChannel createFromParcel(Parcel parcel) {
            WifiChannel wifiChannel = new WifiChannel();
            wifiChannel.freqMHz = parcel.readInt();
            wifiChannel.channelNum = parcel.readInt();
            wifiChannel.isDFS = parcel.readInt() != 0;
            wifiChannel.ibssAllowed = parcel.readInt() != 0;
            return wifiChannel;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiChannel[] newArray(int i) {
            return new WifiChannel[i];
        }
    };
    private static final int MAX_CHANNEL_NUM = 196;
    private static final int MAX_FREQ_MHZ = 5825;
    private static final int MIN_CHANNEL_NUM = 1;
    private static final int MIN_FREQ_MHZ = 2412;
    public int channelNum;
    public int freqMHz;
    public boolean ibssAllowed;
    public boolean isDFS;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isValid() {
        boolean z = true;
        if (this.freqMHz < MIN_FREQ_MHZ || this.freqMHz > MAX_FREQ_MHZ) {
            z = false;
        } else if (this.channelNum < 1 || this.channelNum > 196) {
            return false;
        }
        return z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.freqMHz);
        parcel.writeInt(this.channelNum);
        parcel.writeInt(this.isDFS ? 1 : 0);
        parcel.writeInt(this.ibssAllowed ? 1 : 0);
    }
}
