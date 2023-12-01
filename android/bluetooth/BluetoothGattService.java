package android.bluetooth;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothGattService.class */
public class BluetoothGattService {
    public static final int SERVICE_TYPE_PRIMARY = 0;
    public static final int SERVICE_TYPE_SECONDARY = 1;
    private boolean mAdvertisePreferred;
    protected List<BluetoothGattCharacteristic> mCharacteristics;
    protected BluetoothDevice mDevice;
    protected int mHandles;
    protected List<BluetoothGattService> mIncludedServices;
    protected int mInstanceId;
    protected int mServiceType;
    protected UUID mUuid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothGattService(BluetoothDevice bluetoothDevice, UUID uuid, int i, int i2) {
        this.mHandles = 0;
        this.mDevice = bluetoothDevice;
        this.mUuid = uuid;
        this.mInstanceId = i;
        this.mServiceType = i2;
        this.mCharacteristics = new ArrayList();
        this.mIncludedServices = new ArrayList();
    }

    public BluetoothGattService(UUID uuid, int i) {
        this.mHandles = 0;
        this.mDevice = null;
        this.mUuid = uuid;
        this.mInstanceId = 0;
        this.mServiceType = i;
        this.mCharacteristics = new ArrayList();
        this.mIncludedServices = new ArrayList();
    }

    public boolean addCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.mCharacteristics.add(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic.setService(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addIncludedService(BluetoothGattService bluetoothGattService) {
        this.mIncludedServices.add(bluetoothGattService);
    }

    public boolean addService(BluetoothGattService bluetoothGattService) {
        this.mIncludedServices.add(bluetoothGattService);
        return true;
    }

    public BluetoothGattCharacteristic getCharacteristic(UUID uuid) {
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.mCharacteristics) {
            if (uuid.equals(bluetoothGattCharacteristic.getUuid())) {
                return bluetoothGattCharacteristic;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothGattCharacteristic getCharacteristic(UUID uuid, int i) {
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.mCharacteristics) {
            if (uuid.equals(bluetoothGattCharacteristic.getUuid()) && bluetoothGattCharacteristic.getInstanceId() == i) {
                return bluetoothGattCharacteristic;
            }
        }
        return null;
    }

    public List<BluetoothGattCharacteristic> getCharacteristics() {
        return this.mCharacteristics;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothDevice getDevice() {
        return this.mDevice;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getHandles() {
        return this.mHandles;
    }

    public List<BluetoothGattService> getIncludedServices() {
        return this.mIncludedServices;
    }

    public int getInstanceId() {
        return this.mInstanceId;
    }

    public int getType() {
        return this.mServiceType;
    }

    public UUID getUuid() {
        return this.mUuid;
    }

    public boolean isAdvertisePreferred() {
        return this.mAdvertisePreferred;
    }

    public void setAdvertisePreferred(boolean z) {
        this.mAdvertisePreferred = z;
    }

    public void setHandles(int i) {
        this.mHandles = i;
    }

    public void setInstanceId(int i) {
        this.mInstanceId = i;
    }
}
