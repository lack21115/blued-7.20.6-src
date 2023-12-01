package android.net.wifi.p2p;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pGroup.class */
public class WifiP2pGroup implements Parcelable {
    public static final int PERSISTENT_NET_ID = -2;
    public static final int TEMPORARY_NET_ID = -1;
    private List<WifiP2pDevice> mClients = new ArrayList();
    private String mInterface;
    private boolean mIsGroupOwner;
    private int mNetId;
    private String mNetworkName;
    private WifiP2pDevice mOwner;
    private String mPassphrase;
    private static final Pattern groupStartedPattern = Pattern.compile("ssid=\"(.+)\" freq=(\\d+) (?:psk=)?([0-9a-fA-F]{64})?(?:passphrase=)?(?:\"(.{0,63})\")? go_dev_addr=((?:[0-9a-f]{2}:){5}[0-9a-f]{2}) ?(\\[PERSISTENT\\])?");
    public static final Parcelable.Creator<WifiP2pGroup> CREATOR = new Parcelable.Creator<WifiP2pGroup>() { // from class: android.net.wifi.p2p.WifiP2pGroup.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pGroup createFromParcel(Parcel parcel) {
            WifiP2pGroup wifiP2pGroup = new WifiP2pGroup();
            wifiP2pGroup.setNetworkName(parcel.readString());
            wifiP2pGroup.setOwner((WifiP2pDevice) parcel.readParcelable(null));
            wifiP2pGroup.setIsGroupOwner(parcel.readByte() == 1);
            int readInt = parcel.readInt();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    wifiP2pGroup.setPassphrase(parcel.readString());
                    wifiP2pGroup.setInterface(parcel.readString());
                    wifiP2pGroup.setNetworkId(parcel.readInt());
                    return wifiP2pGroup;
                }
                wifiP2pGroup.addClient((WifiP2pDevice) parcel.readParcelable(null));
                i = i2 + 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pGroup[] newArray(int i) {
            return new WifiP2pGroup[i];
        }
    };

    public WifiP2pGroup() {
    }

    public WifiP2pGroup(WifiP2pGroup wifiP2pGroup) {
        if (wifiP2pGroup != null) {
            this.mNetworkName = wifiP2pGroup.getNetworkName();
            this.mOwner = new WifiP2pDevice(wifiP2pGroup.getOwner());
            this.mIsGroupOwner = wifiP2pGroup.mIsGroupOwner;
            for (WifiP2pDevice wifiP2pDevice : wifiP2pGroup.getClientList()) {
                this.mClients.add(wifiP2pDevice);
            }
            this.mPassphrase = wifiP2pGroup.getPassphrase();
            this.mInterface = wifiP2pGroup.getInterface();
            this.mNetId = wifiP2pGroup.getNetworkId();
        }
    }

    public WifiP2pGroup(String str) throws IllegalArgumentException {
        String str2;
        String[] split = str.split(" ");
        if (split.length < 3) {
            throw new IllegalArgumentException("Malformed supplicant event");
        }
        if (split[0].startsWith("P2P-GROUP")) {
            this.mInterface = split[1];
            this.mIsGroupOwner = split[2].equals("GO");
            Matcher matcher = groupStartedPattern.matcher(str);
            if (matcher.find()) {
                this.mNetworkName = matcher.group(1);
                this.mPassphrase = matcher.group(4);
                this.mOwner = new WifiP2pDevice(matcher.group(5));
                if (matcher.group(6) != null) {
                    this.mNetId = -2;
                } else {
                    this.mNetId = -1;
                }
            }
        } else if (!split[0].equals("P2P-INVITATION-RECEIVED")) {
            throw new IllegalArgumentException("Malformed supplicant event");
        } else {
            String str3 = null;
            this.mNetId = -2;
            int length = split.length;
            int i = 0;
            while (i < length) {
                String[] split2 = split[i].split("=");
                if (split2.length != 2) {
                    str2 = str3;
                } else if (split2[0].equals("sa")) {
                    str2 = split2[1];
                    WifiP2pDevice wifiP2pDevice = new WifiP2pDevice();
                    wifiP2pDevice.deviceAddress = split2[1];
                    this.mClients.add(wifiP2pDevice);
                } else if (split2[0].equals("go_dev_addr")) {
                    this.mOwner = new WifiP2pDevice(split2[1]);
                    str2 = str3;
                } else {
                    str2 = str3;
                    if (split2[0].equals("persistent")) {
                        this.mOwner = new WifiP2pDevice(str3);
                        this.mNetId = Integer.parseInt(split2[1]);
                        str2 = str3;
                    }
                }
                i++;
                str3 = str2;
            }
        }
    }

    public void addClient(WifiP2pDevice wifiP2pDevice) {
        for (WifiP2pDevice wifiP2pDevice2 : this.mClients) {
            if (wifiP2pDevice2.equals(wifiP2pDevice)) {
                return;
            }
        }
        this.mClients.add(wifiP2pDevice);
    }

    public void addClient(String str) {
        addClient(new WifiP2pDevice(str));
    }

    public boolean contains(WifiP2pDevice wifiP2pDevice) {
        return this.mOwner.equals(wifiP2pDevice) || this.mClients.contains(wifiP2pDevice);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Collection<WifiP2pDevice> getClientList() {
        return Collections.unmodifiableCollection(this.mClients);
    }

    public String getInterface() {
        return this.mInterface;
    }

    public int getNetworkId() {
        return this.mNetId;
    }

    public String getNetworkName() {
        return this.mNetworkName;
    }

    public WifiP2pDevice getOwner() {
        return this.mOwner;
    }

    public String getPassphrase() {
        return this.mPassphrase;
    }

    public boolean isClientListEmpty() {
        return this.mClients.size() == 0;
    }

    public boolean isGroupOwner() {
        return this.mIsGroupOwner;
    }

    public boolean removeClient(WifiP2pDevice wifiP2pDevice) {
        return this.mClients.remove(wifiP2pDevice);
    }

    public boolean removeClient(String str) {
        return this.mClients.remove(new WifiP2pDevice(str));
    }

    public void setInterface(String str) {
        this.mInterface = str;
    }

    public void setIsGroupOwner(boolean z) {
        this.mIsGroupOwner = z;
    }

    public void setNetworkId(int i) {
        this.mNetId = i;
    }

    public void setNetworkName(String str) {
        this.mNetworkName = str;
    }

    public void setOwner(WifiP2pDevice wifiP2pDevice) {
        this.mOwner = wifiP2pDevice;
    }

    public void setPassphrase(String str) {
        this.mPassphrase = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("network: ").append(this.mNetworkName);
        stringBuffer.append("\n isGO: ").append(this.mIsGroupOwner);
        stringBuffer.append("\n GO: ").append(this.mOwner);
        for (WifiP2pDevice wifiP2pDevice : this.mClients) {
            stringBuffer.append("\n Client: ").append(wifiP2pDevice);
        }
        stringBuffer.append("\n interface: ").append(this.mInterface);
        stringBuffer.append("\n networkId: ").append(this.mNetId);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mNetworkName);
        parcel.writeParcelable(this.mOwner, i);
        parcel.writeByte(this.mIsGroupOwner ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mClients.size());
        for (WifiP2pDevice wifiP2pDevice : this.mClients) {
            parcel.writeParcelable(wifiP2pDevice, i);
        }
        parcel.writeString(this.mPassphrase);
        parcel.writeString(this.mInterface);
        parcel.writeInt(this.mNetId);
    }
}
