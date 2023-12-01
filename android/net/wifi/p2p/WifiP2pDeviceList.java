package android.net.wifi.p2p;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pDeviceList.class */
public class WifiP2pDeviceList implements Parcelable {
    public static final Parcelable.Creator<WifiP2pDeviceList> CREATOR = new Parcelable.Creator<WifiP2pDeviceList>() { // from class: android.net.wifi.p2p.WifiP2pDeviceList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pDeviceList createFromParcel(Parcel parcel) {
            WifiP2pDeviceList wifiP2pDeviceList = new WifiP2pDeviceList();
            int readInt = parcel.readInt();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    return wifiP2pDeviceList;
                }
                wifiP2pDeviceList.update((WifiP2pDevice) parcel.readParcelable(null));
                i = i2 + 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pDeviceList[] newArray(int i) {
            return new WifiP2pDeviceList[i];
        }
    };
    private final HashMap<String, WifiP2pDevice> mDevices = new HashMap<>();

    public WifiP2pDeviceList() {
    }

    public WifiP2pDeviceList(WifiP2pDeviceList wifiP2pDeviceList) {
        if (wifiP2pDeviceList != null) {
            for (WifiP2pDevice wifiP2pDevice : wifiP2pDeviceList.getDeviceList()) {
                this.mDevices.put(wifiP2pDevice.deviceAddress, new WifiP2pDevice(wifiP2pDevice));
            }
        }
    }

    public WifiP2pDeviceList(ArrayList<WifiP2pDevice> arrayList) {
        Iterator<WifiP2pDevice> it = arrayList.iterator();
        while (it.hasNext()) {
            WifiP2pDevice next = it.next();
            if (next.deviceAddress != null) {
                this.mDevices.put(next.deviceAddress, new WifiP2pDevice(next));
            }
        }
    }

    private void validateDevice(WifiP2pDevice wifiP2pDevice) {
        if (wifiP2pDevice == null) {
            throw new IllegalArgumentException("Null device");
        }
        if (TextUtils.isEmpty(wifiP2pDevice.deviceAddress)) {
            throw new IllegalArgumentException("Empty deviceAddress");
        }
    }

    private void validateDeviceAddress(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty deviceAddress");
        }
    }

    public boolean clear() {
        if (this.mDevices.isEmpty()) {
            return false;
        }
        this.mDevices.clear();
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WifiP2pDevice get(String str) {
        validateDeviceAddress(str);
        return this.mDevices.get(str);
    }

    public Collection<WifiP2pDevice> getDeviceList() {
        return Collections.unmodifiableCollection(this.mDevices.values());
    }

    public boolean isGroupOwner(String str) {
        validateDeviceAddress(str);
        WifiP2pDevice wifiP2pDevice = this.mDevices.get(str);
        if (wifiP2pDevice == null) {
            throw new IllegalArgumentException("Device not found " + str);
        }
        return wifiP2pDevice.isGroupOwner();
    }

    public WifiP2pDevice remove(String str) {
        validateDeviceAddress(str);
        return this.mDevices.remove(str);
    }

    public boolean remove(WifiP2pDevice wifiP2pDevice) {
        validateDevice(wifiP2pDevice);
        return this.mDevices.remove(wifiP2pDevice.deviceAddress) != null;
    }

    public boolean remove(WifiP2pDeviceList wifiP2pDeviceList) {
        boolean z = false;
        for (WifiP2pDevice wifiP2pDevice : wifiP2pDeviceList.mDevices.values()) {
            if (remove(wifiP2pDevice)) {
                z = true;
            }
        }
        return z;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (WifiP2pDevice wifiP2pDevice : this.mDevices.values()) {
            stringBuffer.append("\n").append(wifiP2pDevice);
        }
        return stringBuffer.toString();
    }

    public void update(WifiP2pDevice wifiP2pDevice) {
        updateSupplicantDetails(wifiP2pDevice);
        this.mDevices.get(wifiP2pDevice.deviceAddress).status = wifiP2pDevice.status;
    }

    public void updateGroupCapability(String str, int i) {
        validateDeviceAddress(str);
        WifiP2pDevice wifiP2pDevice = this.mDevices.get(str);
        if (wifiP2pDevice != null) {
            wifiP2pDevice.groupCapability = i;
        }
    }

    public void updateStatus(String str, int i) {
        validateDeviceAddress(str);
        WifiP2pDevice wifiP2pDevice = this.mDevices.get(str);
        if (wifiP2pDevice != null) {
            wifiP2pDevice.status = i;
        }
    }

    public void updateSupplicantDetails(WifiP2pDevice wifiP2pDevice) {
        validateDevice(wifiP2pDevice);
        WifiP2pDevice wifiP2pDevice2 = this.mDevices.get(wifiP2pDevice.deviceAddress);
        if (wifiP2pDevice2 == null) {
            this.mDevices.put(wifiP2pDevice.deviceAddress, wifiP2pDevice);
            return;
        }
        wifiP2pDevice2.deviceName = wifiP2pDevice.deviceName;
        wifiP2pDevice2.primaryDeviceType = wifiP2pDevice.primaryDeviceType;
        wifiP2pDevice2.secondaryDeviceType = wifiP2pDevice.secondaryDeviceType;
        wifiP2pDevice2.wpsConfigMethodsSupported = wifiP2pDevice.wpsConfigMethodsSupported;
        wifiP2pDevice2.deviceCapability = wifiP2pDevice.deviceCapability;
        wifiP2pDevice2.groupCapability = wifiP2pDevice.groupCapability;
        wifiP2pDevice2.wfdInfo = wifiP2pDevice.wfdInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mDevices.size());
        for (WifiP2pDevice wifiP2pDevice : this.mDevices.values()) {
            parcel.writeParcelable(wifiP2pDevice, i);
        }
    }
}
