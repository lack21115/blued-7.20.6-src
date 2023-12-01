package android.bluetooth;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothGattServerCallback.class */
public abstract class BluetoothGattServerCallback {
    public void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
    }

    public void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte[] bArr) {
    }

    public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2) {
    }

    public void onDescriptorReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattDescriptor bluetoothGattDescriptor) {
    }

    public void onDescriptorWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z, boolean z2, int i2, byte[] bArr) {
    }

    public void onExecuteWrite(BluetoothDevice bluetoothDevice, int i, boolean z) {
    }

    public void onMtuChanged(BluetoothDevice bluetoothDevice, int i) {
    }

    public void onNotificationSent(BluetoothDevice bluetoothDevice, int i) {
    }

    public void onServiceAdded(int i, BluetoothGattService bluetoothGattService) {
    }
}
