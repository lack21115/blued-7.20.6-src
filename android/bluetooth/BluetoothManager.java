package android.bluetooth;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothManager.class */
public final class BluetoothManager {
    private static final boolean DBG = true;
    private static final String TAG = "BluetoothManager";
    private static final boolean VDBG = true;
    private final BluetoothAdapter mAdapter;

    public BluetoothManager(Context context) {
        if (context.getApplicationContext() == null) {
            throw new IllegalArgumentException("context not associated with any application (using a mock context?)");
        }
        this.mAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public BluetoothAdapter getAdapter() {
        return this.mAdapter;
    }

    public List<BluetoothDevice> getConnectedDevices(int i) {
        IBluetoothGatt bluetoothGatt;
        Log.d(TAG, "getConnectedDevices");
        if (i == 7 || i == 8) {
            ArrayList arrayList = new ArrayList();
            try {
                bluetoothGatt = this.mAdapter.getBluetoothManager().getBluetoothGatt();
            } catch (RemoteException e) {
                Log.e(TAG, "", e);
            }
            if (bluetoothGatt == null) {
                return arrayList;
            }
            arrayList = bluetoothGatt.getDevicesMatchingConnectionStates(new int[]{2});
            return arrayList;
        }
        throw new IllegalArgumentException("Profile not supported: " + i);
    }

    public int getConnectionState(BluetoothDevice bluetoothDevice, int i) {
        Log.d(TAG, "getConnectionState()");
        for (BluetoothDevice bluetoothDevice2 : getConnectedDevices(i)) {
            if (bluetoothDevice.equals(bluetoothDevice2)) {
                return 2;
            }
        }
        return 0;
    }

    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int i, int[] iArr) {
        ArrayList arrayList;
        IBluetoothGatt bluetoothGatt;
        Log.d(TAG, "getDevicesMatchingConnectionStates");
        if (i == 7 || i == 8) {
            ArrayList arrayList2 = new ArrayList();
            try {
                bluetoothGatt = this.mAdapter.getBluetoothManager().getBluetoothGatt();
            } catch (RemoteException e) {
                Log.e(TAG, "", e);
                arrayList = arrayList2;
            }
            if (bluetoothGatt == null) {
                return arrayList2;
            }
            arrayList = bluetoothGatt.getDevicesMatchingConnectionStates(iArr);
            return arrayList;
        }
        throw new IllegalArgumentException("Profile not supported: " + i);
    }

    public BluetoothGattServer openGattServer(Context context, BluetoothGattServerCallback bluetoothGattServerCallback) {
        return openGattServer(context, bluetoothGattServerCallback, 0);
    }

    public BluetoothGattServer openGattServer(Context context, BluetoothGattServerCallback bluetoothGattServerCallback, int i) {
        if (context == null || bluetoothGattServerCallback == null) {
            throw new IllegalArgumentException("null parameter: " + context + " " + bluetoothGattServerCallback);
        }
        try {
            IBluetoothGatt bluetoothGatt = this.mAdapter.getBluetoothManager().getBluetoothGatt();
            if (bluetoothGatt == null) {
                Log.e(TAG, "Fail to get GATT Server connection");
                return null;
            }
            BluetoothGattServer bluetoothGattServer = new BluetoothGattServer(context, bluetoothGatt, i);
            if (!Boolean.valueOf(bluetoothGattServer.registerCallback(bluetoothGattServerCallback)).booleanValue()) {
                bluetoothGattServer = null;
            }
            return bluetoothGattServer;
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
            return null;
        }
    }
}
