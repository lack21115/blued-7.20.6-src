package android.bluetooth;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothGattCallback.class */
public abstract class BluetoothGattCallback {
    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
    }

    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
    }

    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
    }

    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
    }

    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
    }

    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
    }

    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
    }

    public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
    }

    public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
    }
}
