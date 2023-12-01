package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/ScanSettings.class */
public class ScanSettings implements Parcelable {
    public static final Parcelable.Creator<ScanSettings> CREATOR = new Parcelable.Creator<ScanSettings>() { // from class: android.net.wifi.ScanSettings.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScanSettings createFromParcel(Parcel parcel) {
            ScanSettings scanSettings = new ScanSettings();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                scanSettings.channelSet = new ArrayList(readInt);
                while (readInt > 0) {
                    scanSettings.channelSet.add(WifiChannel.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            }
            return scanSettings;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScanSettings[] newArray(int i) {
            return new ScanSettings[i];
        }
    };
    public Collection<WifiChannel> channelSet;

    public ScanSettings() {
    }

    public ScanSettings(ScanSettings scanSettings) {
        if (scanSettings.channelSet != null) {
            this.channelSet = new ArrayList(scanSettings.channelSet);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isValid() {
        for (WifiChannel wifiChannel : this.channelSet) {
            if (!wifiChannel.isValid()) {
                return false;
            }
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.channelSet == null ? 0 : this.channelSet.size());
        if (this.channelSet != null) {
            for (WifiChannel wifiChannel : this.channelSet) {
                wifiChannel.writeToParcel(parcel, i);
            }
        }
    }
}
