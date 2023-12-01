package android.net.wifi.p2p.nsd;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/nsd/WifiP2pDnsSdServiceRequest.class */
public class WifiP2pDnsSdServiceRequest extends WifiP2pServiceRequest {
    private WifiP2pDnsSdServiceRequest() {
        super(1, null);
    }

    private WifiP2pDnsSdServiceRequest(String str) {
        super(1, str);
    }

    private WifiP2pDnsSdServiceRequest(String str, int i, int i2) {
        super(1, WifiP2pDnsSdServiceInfo.createRequest(str, i, i2));
    }

    public static WifiP2pDnsSdServiceRequest newInstance() {
        return new WifiP2pDnsSdServiceRequest();
    }

    public static WifiP2pDnsSdServiceRequest newInstance(String str) {
        if (str == null) {
            throw new IllegalArgumentException("service type cannot be null");
        }
        return new WifiP2pDnsSdServiceRequest(str + ".local.", 12, 1);
    }

    public static WifiP2pDnsSdServiceRequest newInstance(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("instance name or service type cannot be null");
        }
        return new WifiP2pDnsSdServiceRequest(str + "." + str2 + ".local.", 16, 1);
    }
}
