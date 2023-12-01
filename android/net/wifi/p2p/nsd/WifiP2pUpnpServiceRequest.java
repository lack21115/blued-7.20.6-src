package android.net.wifi.p2p.nsd;

import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/nsd/WifiP2pUpnpServiceRequest.class */
public class WifiP2pUpnpServiceRequest extends WifiP2pServiceRequest {
    protected WifiP2pUpnpServiceRequest() {
        super(2, null);
    }

    protected WifiP2pUpnpServiceRequest(String str) {
        super(2, str);
    }

    public static WifiP2pUpnpServiceRequest newInstance() {
        return new WifiP2pUpnpServiceRequest();
    }

    public static WifiP2pUpnpServiceRequest newInstance(String str) {
        if (str == null) {
            throw new IllegalArgumentException("search target cannot be null");
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format(Locale.US, "%02x", 16));
        stringBuffer.append(WifiP2pServiceInfo.bin2HexStr(str.getBytes()));
        return new WifiP2pUpnpServiceRequest(stringBuffer.toString());
    }
}
