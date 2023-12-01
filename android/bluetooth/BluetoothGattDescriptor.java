package android.bluetooth;

import java.util.UUID;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothGattDescriptor.class */
public class BluetoothGattDescriptor {
    public static final int PERMISSION_READ = 1;
    public static final int PERMISSION_READ_ENCRYPTED = 2;
    public static final int PERMISSION_READ_ENCRYPTED_MITM = 4;
    public static final int PERMISSION_WRITE = 16;
    public static final int PERMISSION_WRITE_ENCRYPTED = 32;
    public static final int PERMISSION_WRITE_ENCRYPTED_MITM = 64;
    public static final int PERMISSION_WRITE_SIGNED = 128;
    public static final int PERMISSION_WRITE_SIGNED_MITM = 256;
    protected BluetoothGattCharacteristic mCharacteristic;
    protected int mInstance;
    protected int mPermissions;
    protected UUID mUuid;
    protected byte[] mValue;
    public static final byte[] ENABLE_NOTIFICATION_VALUE = {1, 0};
    public static final byte[] ENABLE_INDICATION_VALUE = {2, 0};
    public static final byte[] DISABLE_NOTIFICATION_VALUE = {0, 0};

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothGattDescriptor(BluetoothGattCharacteristic bluetoothGattCharacteristic, UUID uuid, int i, int i2) {
        initDescriptor(bluetoothGattCharacteristic, uuid, i, i2);
    }

    public BluetoothGattDescriptor(UUID uuid, int i) {
        initDescriptor(null, uuid, 0, i);
    }

    private void initDescriptor(BluetoothGattCharacteristic bluetoothGattCharacteristic, UUID uuid, int i, int i2) {
        this.mCharacteristic = bluetoothGattCharacteristic;
        this.mUuid = uuid;
        this.mInstance = i;
        this.mPermissions = i2;
    }

    public BluetoothGattCharacteristic getCharacteristic() {
        return this.mCharacteristic;
    }

    public int getInstanceId() {
        return this.mInstance;
    }

    public int getPermissions() {
        return this.mPermissions;
    }

    public UUID getUuid() {
        return this.mUuid;
    }

    public byte[] getValue() {
        return this.mValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.mCharacteristic = bluetoothGattCharacteristic;
    }

    public boolean setValue(byte[] bArr) {
        this.mValue = bArr;
        return true;
    }
}
