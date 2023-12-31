package android.bluetooth;

import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothProfile.class */
public interface BluetoothProfile {
    public static final int A2DP = 2;
    public static final int A2DP_SINK = 10;
    public static final int AVRCP_CONTROLLER = 11;
    public static final int DUN = 21;
    public static final String EXTRA_PREVIOUS_STATE = "android.bluetooth.profile.extra.PREVIOUS_STATE";
    public static final String EXTRA_STATE = "android.bluetooth.profile.extra.STATE";
    public static final int GATT = 7;
    public static final int GATT_SERVER = 8;
    public static final int HEADSET = 1;
    public static final int HEADSET_CLIENT = 16;
    public static final int HEALTH = 3;
    public static final int HID_DEVICE = 17;
    public static final int INPUT_DEVICE = 4;
    public static final int MAP = 9;
    public static final int PAN = 5;
    public static final int PBAP = 6;
    public static final int PRIORITY_AUTO_CONNECT = 1000;
    public static final int PRIORITY_OFF = 0;
    public static final int PRIORITY_ON = 100;
    public static final int PRIORITY_UNDEFINED = -1;
    public static final int SAP = 20;
    public static final int STATE_CONNECTED = 2;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_DISCONNECTING = 3;

    /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothProfile$ServiceListener.class */
    public interface ServiceListener {
        void onServiceConnected(int i, BluetoothProfile bluetoothProfile);

        void onServiceDisconnected(int i);
    }

    List<BluetoothDevice> getConnectedDevices();

    int getConnectionState(BluetoothDevice bluetoothDevice);

    List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] iArr);
}
