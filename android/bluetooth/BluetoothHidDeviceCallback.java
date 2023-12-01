package android.bluetooth;

import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothHidDeviceCallback.class */
public abstract class BluetoothHidDeviceCallback {
    private static final String TAG = BluetoothHidDeviceCallback.class.getSimpleName();

    public void onAppStatusChanged(BluetoothDevice bluetoothDevice, BluetoothHidDeviceAppConfiguration bluetoothHidDeviceAppConfiguration, boolean z) {
        Log.d(TAG, "onAppStatusChanged: pluggedDevice=" + (bluetoothDevice == null ? null : bluetoothDevice.toString()) + " registered=" + z);
    }

    public void onConnectionStateChanged(BluetoothDevice bluetoothDevice, int i) {
        Log.d(TAG, "onConnectionStateChanged: device=" + bluetoothDevice.toString() + " state=" + i);
    }

    public void onGetReport(byte b, byte b2, int i) {
        Log.d(TAG, "onGetReport: type=" + ((int) b) + " id=" + ((int) b2) + " bufferSize=" + i);
    }

    public void onIntrData(byte b, byte[] bArr) {
        Log.d(TAG, "onIntrData: reportId=" + ((int) b));
    }

    public void onSetProtocol(byte b) {
        Log.d(TAG, "onSetProtocol: protocol=" + ((int) b));
    }

    public void onSetReport(byte b, byte b2, byte[] bArr) {
        Log.d(TAG, "onSetReport: type=" + ((int) b) + " id=" + ((int) b2));
    }

    public void onVirtualCableUnplug() {
        Log.d(TAG, "onVirtualCableUnplug");
    }
}
