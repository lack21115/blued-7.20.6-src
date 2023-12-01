package android.bluetooth;

import android.bluetooth.IBluetoothGattCallback;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.ScanResult;
import android.os.ParcelUuid;
import android.os.RemoteException;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothGattCallbackWrapper.class */
public class BluetoothGattCallbackWrapper extends IBluetoothGattCallback.Stub {
    @Override // android.bluetooth.IBluetoothGattCallback
    public void onBatchScanResults(List<ScanResult> list) throws RemoteException {
    }

    public void onCharacteristicRead(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2, byte[] bArr) throws RemoteException {
    }

    public void onCharacteristicWrite(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2) throws RemoteException {
    }

    public void onClientConnectionState(int i, int i2, boolean z, String str) throws RemoteException {
    }

    public void onClientRegistered(int i, int i2) throws RemoteException {
    }

    public void onConfigureMTU(String str, int i, int i2) throws RemoteException {
    }

    public void onDescriptorRead(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2, int i5, ParcelUuid parcelUuid3, byte[] bArr) throws RemoteException {
    }

    public void onDescriptorWrite(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2, int i5, ParcelUuid parcelUuid3) throws RemoteException {
    }

    public void onExecuteWrite(String str, int i) throws RemoteException {
    }

    @Override // android.bluetooth.IBluetoothGattCallback
    public void onFoundOrLost(boolean z, ScanResult scanResult) throws RemoteException {
    }

    public void onGetCharacteristic(String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, int i4) throws RemoteException {
    }

    public void onGetDescriptor(String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, int i4, ParcelUuid parcelUuid3) throws RemoteException {
    }

    public void onGetIncludedService(String str, int i, int i2, ParcelUuid parcelUuid, int i3, int i4, ParcelUuid parcelUuid2) throws RemoteException {
    }

    public void onGetService(String str, int i, int i2, ParcelUuid parcelUuid) throws RemoteException {
    }

    @Override // android.bluetooth.IBluetoothGattCallback
    public void onMultiAdvertiseCallback(int i, boolean z, AdvertiseSettings advertiseSettings) throws RemoteException {
    }

    public void onNotify(String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, byte[] bArr) throws RemoteException {
    }

    public void onReadRemoteRssi(String str, int i, int i2) throws RemoteException {
    }

    @Override // android.bluetooth.IBluetoothGattCallback
    public void onScanResult(ScanResult scanResult) throws RemoteException {
    }

    public void onSearchComplete(String str, int i) throws RemoteException {
    }
}
