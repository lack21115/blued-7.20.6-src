package android.net.wifi.p2p.nsd;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.nsd.WifiP2pServiceResponse;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/nsd/WifiP2pUpnpServiceResponse.class */
public class WifiP2pUpnpServiceResponse extends WifiP2pServiceResponse {
    private List<String> mUniqueServiceNames;
    private int mVersion;

    protected WifiP2pUpnpServiceResponse(int i, int i2, WifiP2pDevice wifiP2pDevice, byte[] bArr) {
        super(2, i, i2, wifiP2pDevice, bArr);
        if (!parse()) {
            throw new IllegalArgumentException("Malformed upnp service response");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WifiP2pUpnpServiceResponse newInstance(int i, int i2, WifiP2pDevice wifiP2pDevice, byte[] bArr) {
        if (i != 0) {
            return new WifiP2pUpnpServiceResponse(i, i2, wifiP2pDevice, null);
        }
        try {
            return new WifiP2pUpnpServiceResponse(i, i2, wifiP2pDevice, bArr);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean parse() {
        if (this.mData == null) {
            return true;
        }
        if (this.mData.length < 1) {
            return false;
        }
        this.mVersion = this.mData[0] & 255;
        String[] split = new String(this.mData, 1, this.mData.length - 1).split(",");
        this.mUniqueServiceNames = new ArrayList();
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            this.mUniqueServiceNames.add(split[i2]);
            i = i2 + 1;
        }
    }

    public List<String> getUniqueServiceNames() {
        return this.mUniqueServiceNames;
    }

    public int getVersion() {
        return this.mVersion;
    }

    @Override // android.net.wifi.p2p.nsd.WifiP2pServiceResponse
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("serviceType:UPnP(").append(this.mServiceType).append(")");
        stringBuffer.append(" status:").append(WifiP2pServiceResponse.Status.toString(this.mStatus));
        stringBuffer.append(" srcAddr:").append(this.mDevice.deviceAddress);
        stringBuffer.append(" version:").append(String.format("%02x", Integer.valueOf(this.mVersion)));
        if (this.mUniqueServiceNames != null) {
            for (String str : this.mUniqueServiceNames) {
                stringBuffer.append(" usn:").append(str);
            }
        }
        return stringBuffer.toString();
    }
}
