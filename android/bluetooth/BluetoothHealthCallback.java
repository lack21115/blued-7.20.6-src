package android.bluetooth;

import android.os.ParcelFileDescriptor;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothHealthCallback.class */
public abstract class BluetoothHealthCallback {
    private static final String TAG = "BluetoothHealthCallback";

    public void onHealthAppConfigurationStatusChange(BluetoothHealthAppConfiguration bluetoothHealthAppConfiguration, int i) {
        Log.d(TAG, "onHealthAppConfigurationStatusChange: " + bluetoothHealthAppConfiguration + "Status: " + i);
    }

    public void onHealthChannelStateChange(BluetoothHealthAppConfiguration bluetoothHealthAppConfiguration, BluetoothDevice bluetoothDevice, int i, int i2, ParcelFileDescriptor parcelFileDescriptor, int i3) {
        Log.d(TAG, "onHealthChannelStateChange: " + bluetoothHealthAppConfiguration + "Device: " + bluetoothDevice + "prevState:" + i + "newState:" + i2 + "ParcelFd:" + parcelFileDescriptor + "ChannelId:" + i3);
    }
}
