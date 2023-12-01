package android.net.wifi.p2p;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pProvDiscEvent.class */
public class WifiP2pProvDiscEvent {
    public static final int ENTER_PIN = 3;
    public static final int PBC_REQ = 1;
    public static final int PBC_RSP = 2;
    public static final int SHOW_PIN = 4;
    private static final String TAG = "WifiP2pProvDiscEvent";
    public WifiP2pDevice device;
    public int event;
    public String pin;

    public WifiP2pProvDiscEvent() {
        this.device = new WifiP2pDevice();
    }

    public WifiP2pProvDiscEvent(String str) throws IllegalArgumentException {
        String[] split = str.split(" ");
        if (split.length < 2) {
            throw new IllegalArgumentException("Malformed event " + str);
        }
        if (split[0].endsWith("PBC-REQ")) {
            this.event = 1;
        } else if (split[0].endsWith("PBC-RESP")) {
            this.event = 2;
        } else if (split[0].endsWith("ENTER-PIN")) {
            this.event = 3;
        } else if (!split[0].endsWith("SHOW-PIN")) {
            throw new IllegalArgumentException("Malformed event " + str);
        } else {
            this.event = 4;
        }
        this.device = new WifiP2pDevice();
        this.device.deviceAddress = split[1];
        if (this.event == 4) {
            this.pin = split[2];
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.device);
        stringBuffer.append("\n event: ").append(this.event);
        stringBuffer.append("\n pin: ").append(this.pin);
        return stringBuffer.toString();
    }
}
