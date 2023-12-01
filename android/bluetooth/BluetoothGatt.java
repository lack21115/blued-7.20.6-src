package android.bluetooth;

import android.content.Context;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothGatt.class */
public final class BluetoothGatt implements BluetoothProfile {
    static final int AUTHENTICATION_MITM = 2;
    static final int AUTHENTICATION_NONE = 0;
    static final int AUTHENTICATION_NO_MITM = 1;
    public static final int CONNECTION_PRIORITY_BALANCED = 0;
    public static final int CONNECTION_PRIORITY_HIGH = 1;
    public static final int CONNECTION_PRIORITY_LOW_POWER = 2;
    private static final int CONN_STATE_CLOSED = 4;
    private static final int CONN_STATE_CONNECTED = 2;
    private static final int CONN_STATE_CONNECTING = 1;
    private static final int CONN_STATE_DISCONNECTING = 3;
    private static final int CONN_STATE_IDLE = 0;
    private static final boolean DBG = true;
    public static final int GATT_CONNECTION_CONGESTED = 143;
    public static final int GATT_FAILURE = 257;
    public static final int GATT_INSUFFICIENT_AUTHENTICATION = 5;
    public static final int GATT_INSUFFICIENT_ENCRYPTION = 15;
    public static final int GATT_INVALID_ATTRIBUTE_LENGTH = 13;
    public static final int GATT_INVALID_OFFSET = 7;
    public static final int GATT_READ_NOT_PERMITTED = 2;
    public static final int GATT_REQUEST_NOT_SUPPORTED = 6;
    public static final int GATT_SUCCESS = 0;
    public static final int GATT_WRITE_NOT_PERMITTED = 3;
    private static final String TAG = "BluetoothGatt";
    private static final boolean VDBG = false;
    private boolean mAutoConnect;
    private BluetoothGattCallback mCallback;
    private int mClientIf;
    private final Context mContext;
    private BluetoothDevice mDevice;
    private IBluetoothGatt mService;
    private int mTransport;
    private boolean mAuthRetry = false;
    private final Object mStateLock = new Object();
    private Boolean mDeviceBusy = false;
    private final IBluetoothGattCallback mBluetoothGattCallback = new BluetoothGattCallbackWrapper() { // from class: android.bluetooth.BluetoothGatt.1
        @Override // android.bluetooth.BluetoothGattCallbackWrapper, android.bluetooth.IBluetoothGattCallback
        public void onCharacteristicRead(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2, byte[] bArr) {
            BluetoothGattCharacteristic characteristic;
            if (str.equals(BluetoothGatt.this.mDevice.getAddress())) {
                synchronized (BluetoothGatt.this.mDeviceBusy) {
                    BluetoothGatt.this.mDeviceBusy = false;
                }
                if ((i == 5 || i == 15) && !BluetoothGatt.this.mAuthRetry) {
                    try {
                        BluetoothGatt.this.mAuthRetry = true;
                        BluetoothGatt.this.mService.readCharacteristic(BluetoothGatt.this.mClientIf, str, i2, i3, parcelUuid, i4, parcelUuid2, 2);
                        return;
                    } catch (RemoteException e) {
                        Log.e(BluetoothGatt.TAG, "", e);
                    }
                }
                BluetoothGatt.this.mAuthRetry = false;
                BluetoothGattService service = BluetoothGatt.this.getService(BluetoothGatt.this.mDevice, parcelUuid.getUuid(), i3, i2);
                if (service == null || (characteristic = service.getCharacteristic(parcelUuid2.getUuid(), i4)) == null) {
                    return;
                }
                if (i == 0) {
                    characteristic.setValue(bArr);
                }
                try {
                    BluetoothGatt.this.mCallback.onCharacteristicRead(BluetoothGatt.this, characteristic, i);
                } catch (Exception e2) {
                    Log.w(BluetoothGatt.TAG, "Unhandled exception in callback", e2);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallbackWrapper, android.bluetooth.IBluetoothGattCallback
        public void onCharacteristicWrite(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2) {
            BluetoothGattCharacteristic characteristic;
            if (str.equals(BluetoothGatt.this.mDevice.getAddress())) {
                synchronized (BluetoothGatt.this.mDeviceBusy) {
                    BluetoothGatt.this.mDeviceBusy = false;
                }
                BluetoothGattService service = BluetoothGatt.this.getService(BluetoothGatt.this.mDevice, parcelUuid.getUuid(), i3, i2);
                if (service == null || (characteristic = service.getCharacteristic(parcelUuid2.getUuid(), i4)) == null) {
                    return;
                }
                if ((i == 5 || i == 15) && !BluetoothGatt.this.mAuthRetry) {
                    try {
                        BluetoothGatt.this.mAuthRetry = true;
                        BluetoothGatt.this.mService.writeCharacteristic(BluetoothGatt.this.mClientIf, str, i2, i3, parcelUuid, i4, parcelUuid2, characteristic.getWriteType(), 2, characteristic.getValue());
                        return;
                    } catch (RemoteException e) {
                        Log.e(BluetoothGatt.TAG, "", e);
                    }
                }
                BluetoothGatt.this.mAuthRetry = false;
                try {
                    BluetoothGatt.this.mCallback.onCharacteristicWrite(BluetoothGatt.this, characteristic, i);
                } catch (Exception e2) {
                    Log.w(BluetoothGatt.TAG, "Unhandled exception in callback", e2);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallbackWrapper, android.bluetooth.IBluetoothGattCallback
        public void onClientConnectionState(int i, int i2, boolean z, String str) {
            Log.d(BluetoothGatt.TAG, "onClientConnectionState() - status=" + i + " clientIf=" + i2 + " device=" + str);
            if (str.equals(BluetoothGatt.this.mDevice.getAddress())) {
                try {
                    BluetoothGatt.this.mCallback.onConnectionStateChange(BluetoothGatt.this, i, z ? 2 : 0);
                } catch (Exception e) {
                    Log.w(BluetoothGatt.TAG, "Unhandled exception in callback", e);
                }
                synchronized (BluetoothGatt.this.mStateLock) {
                    if (z) {
                        BluetoothGatt.this.mConnState = 2;
                    } else {
                        BluetoothGatt.this.mConnState = 0;
                    }
                }
                synchronized (BluetoothGatt.this.mDeviceBusy) {
                    BluetoothGatt.this.mDeviceBusy = false;
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallbackWrapper, android.bluetooth.IBluetoothGattCallback
        public void onClientRegistered(int i, int i2) {
            boolean z = false;
            Log.d(BluetoothGatt.TAG, "onClientRegistered() - status=" + i + " clientIf=" + i2);
            BluetoothGatt.this.mClientIf = i2;
            if (i != 0) {
                BluetoothGatt.this.mCallback.onConnectionStateChange(BluetoothGatt.this, 257, 0);
                synchronized (BluetoothGatt.this.mStateLock) {
                    BluetoothGatt.this.mConnState = 0;
                }
                return;
            }
            try {
                IBluetoothGatt iBluetoothGatt = BluetoothGatt.this.mService;
                int i3 = BluetoothGatt.this.mClientIf;
                String address = BluetoothGatt.this.mDevice.getAddress();
                if (!BluetoothGatt.this.mAutoConnect) {
                    z = true;
                }
                iBluetoothGatt.clientConnect(i3, address, z, BluetoothGatt.this.mTransport);
            } catch (RemoteException e) {
                Log.e(BluetoothGatt.TAG, "", e);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallbackWrapper, android.bluetooth.IBluetoothGattCallback
        public void onConfigureMTU(String str, int i, int i2) {
            Log.d(BluetoothGatt.TAG, "onConfigureMTU() - Device=" + str + " mtu=" + i + " status=" + i2);
            if (str.equals(BluetoothGatt.this.mDevice.getAddress())) {
                try {
                    BluetoothGatt.this.mCallback.onMtuChanged(BluetoothGatt.this, i, i2);
                } catch (Exception e) {
                    Log.w(BluetoothGatt.TAG, "Unhandled exception in callback", e);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallbackWrapper, android.bluetooth.IBluetoothGattCallback
        public void onDescriptorRead(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2, int i5, ParcelUuid parcelUuid3, byte[] bArr) {
            BluetoothGattCharacteristic characteristic;
            BluetoothGattDescriptor descriptor;
            if (str.equals(BluetoothGatt.this.mDevice.getAddress())) {
                synchronized (BluetoothGatt.this.mDeviceBusy) {
                    BluetoothGatt.this.mDeviceBusy = false;
                }
                BluetoothGattService service = BluetoothGatt.this.getService(BluetoothGatt.this.mDevice, parcelUuid.getUuid(), i3, i2);
                if (service == null || (characteristic = service.getCharacteristic(parcelUuid2.getUuid(), i4)) == null || (descriptor = characteristic.getDescriptor(parcelUuid3.getUuid(), i5)) == null) {
                    return;
                }
                if (i == 0) {
                    descriptor.setValue(bArr);
                }
                if ((i == 5 || i == 15) && !BluetoothGatt.this.mAuthRetry) {
                    try {
                        BluetoothGatt.this.mAuthRetry = true;
                        BluetoothGatt.this.mService.readDescriptor(BluetoothGatt.this.mClientIf, str, i2, i3, parcelUuid, i4, parcelUuid2, i5, parcelUuid3, 2);
                        return;
                    } catch (RemoteException e) {
                        Log.e(BluetoothGatt.TAG, "", e);
                    }
                }
                BluetoothGatt.this.mAuthRetry = true;
                try {
                    BluetoothGatt.this.mCallback.onDescriptorRead(BluetoothGatt.this, descriptor, i);
                } catch (Exception e2) {
                    Log.w(BluetoothGatt.TAG, "Unhandled exception in callback", e2);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallbackWrapper, android.bluetooth.IBluetoothGattCallback
        public void onDescriptorWrite(String str, int i, int i2, int i3, ParcelUuid parcelUuid, int i4, ParcelUuid parcelUuid2, int i5, ParcelUuid parcelUuid3) {
            BluetoothGattCharacteristic characteristic;
            BluetoothGattDescriptor descriptor;
            if (str.equals(BluetoothGatt.this.mDevice.getAddress())) {
                synchronized (BluetoothGatt.this.mDeviceBusy) {
                    BluetoothGatt.this.mDeviceBusy = false;
                }
                BluetoothGattService service = BluetoothGatt.this.getService(BluetoothGatt.this.mDevice, parcelUuid.getUuid(), i3, i2);
                if (service == null || (characteristic = service.getCharacteristic(parcelUuid2.getUuid(), i4)) == null || (descriptor = characteristic.getDescriptor(parcelUuid3.getUuid(), i5)) == null) {
                    return;
                }
                if ((i == 5 || i == 15) && !BluetoothGatt.this.mAuthRetry) {
                    try {
                        BluetoothGatt.this.mAuthRetry = true;
                        BluetoothGatt.this.mService.writeDescriptor(BluetoothGatt.this.mClientIf, str, i2, i3, parcelUuid, i4, parcelUuid2, i5, parcelUuid3, characteristic.getWriteType(), 2, descriptor.getValue());
                        return;
                    } catch (RemoteException e) {
                        Log.e(BluetoothGatt.TAG, "", e);
                    }
                }
                BluetoothGatt.this.mAuthRetry = false;
                try {
                    BluetoothGatt.this.mCallback.onDescriptorWrite(BluetoothGatt.this, descriptor, i);
                } catch (Exception e2) {
                    Log.w(BluetoothGatt.TAG, "Unhandled exception in callback", e2);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallbackWrapper, android.bluetooth.IBluetoothGattCallback
        public void onExecuteWrite(String str, int i) {
            if (str.equals(BluetoothGatt.this.mDevice.getAddress())) {
                synchronized (BluetoothGatt.this.mDeviceBusy) {
                    BluetoothGatt.this.mDeviceBusy = false;
                }
                try {
                    BluetoothGatt.this.mCallback.onReliableWriteCompleted(BluetoothGatt.this, i);
                } catch (Exception e) {
                    Log.w(BluetoothGatt.TAG, "Unhandled exception in callback", e);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallbackWrapper, android.bluetooth.IBluetoothGattCallback
        public void onGetCharacteristic(String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, int i4) {
            BluetoothGattService service;
            if (str.equals(BluetoothGatt.this.mDevice.getAddress()) && (service = BluetoothGatt.this.getService(BluetoothGatt.this.mDevice, parcelUuid.getUuid(), i2, i)) != null) {
                service.addCharacteristic(new BluetoothGattCharacteristic(service, parcelUuid2.getUuid(), i3, i4, 0));
            }
        }

        @Override // android.bluetooth.BluetoothGattCallbackWrapper, android.bluetooth.IBluetoothGattCallback
        public void onGetDescriptor(String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, int i4, ParcelUuid parcelUuid3) {
            BluetoothGattService service;
            BluetoothGattCharacteristic characteristic;
            if (!str.equals(BluetoothGatt.this.mDevice.getAddress()) || (service = BluetoothGatt.this.getService(BluetoothGatt.this.mDevice, parcelUuid.getUuid(), i2, i)) == null || (characteristic = service.getCharacteristic(parcelUuid2.getUuid(), i3)) == null) {
                return;
            }
            characteristic.addDescriptor(new BluetoothGattDescriptor(characteristic, parcelUuid3.getUuid(), i4, 0));
        }

        @Override // android.bluetooth.BluetoothGattCallbackWrapper, android.bluetooth.IBluetoothGattCallback
        public void onGetIncludedService(String str, int i, int i2, ParcelUuid parcelUuid, int i3, int i4, ParcelUuid parcelUuid2) {
            if (str.equals(BluetoothGatt.this.mDevice.getAddress())) {
                BluetoothGattService service = BluetoothGatt.this.getService(BluetoothGatt.this.mDevice, parcelUuid.getUuid(), i2, i);
                BluetoothGattService service2 = BluetoothGatt.this.getService(BluetoothGatt.this.mDevice, parcelUuid2.getUuid(), i4, i3);
                if (service == null || service2 == null) {
                    return;
                }
                service.addIncludedService(service2);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallbackWrapper, android.bluetooth.IBluetoothGattCallback
        public void onGetService(String str, int i, int i2, ParcelUuid parcelUuid) {
            if (str.equals(BluetoothGatt.this.mDevice.getAddress())) {
                BluetoothGatt.this.mServices.add(new BluetoothGattService(BluetoothGatt.this.mDevice, parcelUuid.getUuid(), i2, i));
            }
        }

        @Override // android.bluetooth.BluetoothGattCallbackWrapper, android.bluetooth.IBluetoothGattCallback
        public void onNotify(String str, int i, int i2, ParcelUuid parcelUuid, int i3, ParcelUuid parcelUuid2, byte[] bArr) {
            BluetoothGattService service;
            BluetoothGattCharacteristic characteristic;
            if (!str.equals(BluetoothGatt.this.mDevice.getAddress()) || (service = BluetoothGatt.this.getService(BluetoothGatt.this.mDevice, parcelUuid.getUuid(), i2, i)) == null || (characteristic = service.getCharacteristic(parcelUuid2.getUuid(), i3)) == null) {
                return;
            }
            characteristic.setValue(bArr);
            try {
                BluetoothGatt.this.mCallback.onCharacteristicChanged(BluetoothGatt.this, characteristic);
            } catch (Exception e) {
                Log.w(BluetoothGatt.TAG, "Unhandled exception in callback", e);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallbackWrapper, android.bluetooth.IBluetoothGattCallback
        public void onReadRemoteRssi(String str, int i, int i2) {
            if (str.equals(BluetoothGatt.this.mDevice.getAddress())) {
                try {
                    BluetoothGatt.this.mCallback.onReadRemoteRssi(BluetoothGatt.this, i, i2);
                } catch (Exception e) {
                    Log.w(BluetoothGatt.TAG, "Unhandled exception in callback", e);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallbackWrapper, android.bluetooth.IBluetoothGattCallback
        public void onSearchComplete(String str, int i) {
            Log.d(BluetoothGatt.TAG, "onSearchComplete() = Device=" + str + " Status=" + i);
            if (str.equals(BluetoothGatt.this.mDevice.getAddress())) {
                try {
                    BluetoothGatt.this.mCallback.onServicesDiscovered(BluetoothGatt.this, i);
                } catch (Exception e) {
                    Log.w(BluetoothGatt.TAG, "Unhandled exception in callback", e);
                }
            }
        }
    };
    private List<BluetoothGattService> mServices = new ArrayList();
    private int mConnState = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothGatt(Context context, IBluetoothGatt iBluetoothGatt, BluetoothDevice bluetoothDevice, int i) {
        this.mContext = context;
        this.mService = iBluetoothGatt;
        this.mDevice = bluetoothDevice;
        this.mTransport = i;
    }

    private boolean registerApp(BluetoothGattCallback bluetoothGattCallback) {
        Log.d(TAG, "registerApp()");
        if (this.mService == null) {
            return false;
        }
        this.mCallback = bluetoothGattCallback;
        UUID randomUUID = UUID.randomUUID();
        Log.d(TAG, "registerApp() - UUID=" + randomUUID);
        try {
            this.mService.registerClient(new ParcelUuid(randomUUID), this.mBluetoothGattCallback);
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
            return false;
        }
    }

    private void unregisterApp() {
        Log.d(TAG, "unregisterApp() - mClientIf=" + this.mClientIf);
        if (this.mService == null || this.mClientIf == 0) {
            return;
        }
        try {
            this.mCallback = null;
            this.mService.unregisterClient(this.mClientIf);
            this.mClientIf = 0;
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
        }
    }

    public void abortReliableWrite() {
        if (this.mService == null || this.mClientIf == 0) {
            return;
        }
        try {
            this.mService.endReliableWrite(this.mClientIf, this.mDevice.getAddress(), false);
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
        }
    }

    public void abortReliableWrite(BluetoothDevice bluetoothDevice) {
        abortReliableWrite();
    }

    public boolean beginReliableWrite() {
        if (this.mService == null || this.mClientIf == 0) {
            return false;
        }
        try {
            this.mService.beginReliableWrite(this.mClientIf, this.mDevice.getAddress());
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
            return false;
        }
    }

    public void close() {
        Log.d(TAG, "close()");
        if (BluetoothAdapter.getDefaultAdapter().getState() != 12) {
            return;
        }
        unregisterApp();
        this.mConnState = 4;
    }

    public boolean connect() {
        try {
            this.mService.clientConnect(this.mClientIf, this.mDevice.getAddress(), false, this.mTransport);
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean connect(Boolean bool, BluetoothGattCallback bluetoothGattCallback) {
        Log.d(TAG, "connect() - device: " + this.mDevice.getAddress() + ", auto: " + bool);
        synchronized (this.mStateLock) {
            if (this.mConnState != 0) {
                throw new IllegalStateException("Not idle");
            }
            this.mConnState = 1;
        }
        if (registerApp(bluetoothGattCallback)) {
            this.mAutoConnect = bool.booleanValue();
            return true;
        }
        synchronized (this.mStateLock) {
            this.mConnState = 0;
        }
        Log.e(TAG, "Failed to register callback");
        return false;
    }

    public void disconnect() {
        Log.d(TAG, "cancelOpen() - device: " + this.mDevice.getAddress());
        if (this.mService == null || this.mClientIf == 0 || BluetoothAdapter.getDefaultAdapter().getState() != 12) {
            return;
        }
        try {
            this.mService.clientDisconnect(this.mClientIf, this.mDevice.getAddress());
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
        }
    }

    public boolean discoverServices() {
        Log.d(TAG, "discoverServices() - device: " + this.mDevice.getAddress());
        if (this.mService == null || this.mClientIf == 0) {
            return false;
        }
        this.mServices.clear();
        try {
            this.mService.discoverServices(this.mClientIf, this.mDevice.getAddress());
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
            return false;
        }
    }

    public boolean executeReliableWrite() {
        if (this.mService == null || this.mClientIf == 0) {
            return false;
        }
        synchronized (this.mDeviceBusy) {
            if (this.mDeviceBusy.booleanValue()) {
                return false;
            }
            this.mDeviceBusy = true;
            try {
                this.mService.endReliableWrite(this.mClientIf, this.mDevice.getAddress(), true);
                return true;
            } catch (RemoteException e) {
                Log.e(TAG, "", e);
                this.mDeviceBusy = false;
                return false;
            }
        }
    }

    @Override // android.bluetooth.BluetoothProfile
    public List<BluetoothDevice> getConnectedDevices() {
        throw new UnsupportedOperationException("Use BluetoothManager#getConnectedDevices instead.");
    }

    @Override // android.bluetooth.BluetoothProfile
    public int getConnectionState(BluetoothDevice bluetoothDevice) {
        throw new UnsupportedOperationException("Use BluetoothManager#getConnectionState instead.");
    }

    public BluetoothDevice getDevice() {
        return this.mDevice;
    }

    @Override // android.bluetooth.BluetoothProfile
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] iArr) {
        throw new UnsupportedOperationException("Use BluetoothManager#getDevicesMatchingConnectionStates instead.");
    }

    BluetoothGattService getService(BluetoothDevice bluetoothDevice, UUID uuid, int i, int i2) {
        for (BluetoothGattService bluetoothGattService : this.mServices) {
            if (bluetoothGattService.getDevice().equals(bluetoothDevice) && bluetoothGattService.getType() == i2 && bluetoothGattService.getInstanceId() == i && bluetoothGattService.getUuid().equals(uuid)) {
                return bluetoothGattService;
            }
        }
        return null;
    }

    public BluetoothGattService getService(UUID uuid) {
        for (BluetoothGattService bluetoothGattService : this.mServices) {
            if (bluetoothGattService.getDevice().equals(this.mDevice) && bluetoothGattService.getUuid().equals(uuid)) {
                return bluetoothGattService;
            }
        }
        return null;
    }

    public List<BluetoothGattService> getServices() {
        ArrayList arrayList = new ArrayList();
        for (BluetoothGattService bluetoothGattService : this.mServices) {
            if (bluetoothGattService.getDevice().equals(this.mDevice)) {
                arrayList.add(bluetoothGattService);
            }
        }
        return arrayList;
    }

    public boolean readCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGattService service;
        BluetoothDevice device;
        if ((bluetoothGattCharacteristic.getProperties() & 2) == 0 || this.mService == null || this.mClientIf == 0 || (service = bluetoothGattCharacteristic.getService()) == null || (device = service.getDevice()) == null) {
            return false;
        }
        synchronized (this.mDeviceBusy) {
            if (this.mDeviceBusy.booleanValue()) {
                return false;
            }
            this.mDeviceBusy = true;
            try {
                this.mService.readCharacteristic(this.mClientIf, device.getAddress(), service.getType(), service.getInstanceId(), new ParcelUuid(service.getUuid()), bluetoothGattCharacteristic.getInstanceId(), new ParcelUuid(bluetoothGattCharacteristic.getUuid()), 0);
                return true;
            } catch (RemoteException e) {
                Log.e(TAG, "", e);
                this.mDeviceBusy = false;
                return false;
            }
        }
    }

    public boolean readDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service;
        BluetoothDevice device;
        if (this.mService == null || this.mClientIf == 0 || (characteristic = bluetoothGattDescriptor.getCharacteristic()) == null || (service = characteristic.getService()) == null || (device = service.getDevice()) == null) {
            return false;
        }
        synchronized (this.mDeviceBusy) {
            if (this.mDeviceBusy.booleanValue()) {
                return false;
            }
            this.mDeviceBusy = true;
            try {
                this.mService.readDescriptor(this.mClientIf, device.getAddress(), service.getType(), service.getInstanceId(), new ParcelUuid(service.getUuid()), characteristic.getInstanceId(), new ParcelUuid(characteristic.getUuid()), bluetoothGattDescriptor.getInstanceId(), new ParcelUuid(bluetoothGattDescriptor.getUuid()), 0);
                return true;
            } catch (RemoteException e) {
                Log.e(TAG, "", e);
                this.mDeviceBusy = false;
                return false;
            }
        }
    }

    public boolean readRemoteRssi() {
        Log.d(TAG, "readRssi() - device: " + this.mDevice.getAddress());
        if (this.mService == null || this.mClientIf == 0) {
            return false;
        }
        try {
            this.mService.readRemoteRssi(this.mClientIf, this.mDevice.getAddress());
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
            return false;
        }
    }

    public boolean refresh() {
        Log.d(TAG, "refresh() - device: " + this.mDevice.getAddress());
        if (this.mService == null || this.mClientIf == 0) {
            return false;
        }
        try {
            this.mService.refreshDevice(this.mClientIf, this.mDevice.getAddress());
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
            return false;
        }
    }

    public boolean requestConnectionPriority(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("connectionPriority not within valid range");
        }
        Log.d(TAG, "requestConnectionPriority() - params: " + i);
        if (this.mService == null || this.mClientIf == 0) {
            return false;
        }
        try {
            this.mService.connectionParameterUpdate(this.mClientIf, this.mDevice.getAddress(), i);
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
            return false;
        }
    }

    public boolean requestMtu(int i) {
        Log.d(TAG, "configureMTU() - device: " + this.mDevice.getAddress() + " mtu: " + i);
        if (this.mService == null || this.mClientIf == 0) {
            return false;
        }
        try {
            this.mService.configureMTU(this.mClientIf, this.mDevice.getAddress(), i);
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
            return false;
        }
    }

    public boolean setCharacteristicNotification(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        BluetoothGattService service;
        BluetoothDevice device;
        Log.d(TAG, "setCharacteristicNotification() - uuid: " + bluetoothGattCharacteristic.getUuid() + " enable: " + z);
        if (this.mService == null || this.mClientIf == 0 || (service = bluetoothGattCharacteristic.getService()) == null || (device = service.getDevice()) == null) {
            return false;
        }
        try {
            this.mService.registerForNotification(this.mClientIf, device.getAddress(), service.getType(), service.getInstanceId(), new ParcelUuid(service.getUuid()), bluetoothGattCharacteristic.getInstanceId(), new ParcelUuid(bluetoothGattCharacteristic.getUuid()), z);
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
            return false;
        }
    }

    public boolean writeCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGattService service;
        BluetoothDevice device;
        if (((bluetoothGattCharacteristic.getProperties() & 8) == 0 && (bluetoothGattCharacteristic.getProperties() & 4) == 0) || this.mService == null || this.mClientIf == 0 || bluetoothGattCharacteristic.getValue() == null || (service = bluetoothGattCharacteristic.getService()) == null || (device = service.getDevice()) == null) {
            return false;
        }
        synchronized (this.mDeviceBusy) {
            if (this.mDeviceBusy.booleanValue()) {
                return false;
            }
            this.mDeviceBusy = true;
            try {
                this.mService.writeCharacteristic(this.mClientIf, device.getAddress(), service.getType(), service.getInstanceId(), new ParcelUuid(service.getUuid()), bluetoothGattCharacteristic.getInstanceId(), new ParcelUuid(bluetoothGattCharacteristic.getUuid()), bluetoothGattCharacteristic.getWriteType(), 0, bluetoothGattCharacteristic.getValue());
                return true;
            } catch (RemoteException e) {
                Log.e(TAG, "", e);
                this.mDeviceBusy = false;
                return false;
            }
        }
    }

    public boolean writeDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service;
        BluetoothDevice device;
        if (this.mService == null || this.mClientIf == 0 || bluetoothGattDescriptor.getValue() == null || (characteristic = bluetoothGattDescriptor.getCharacteristic()) == null || (service = characteristic.getService()) == null || (device = service.getDevice()) == null) {
            return false;
        }
        synchronized (this.mDeviceBusy) {
            if (this.mDeviceBusy.booleanValue()) {
                return false;
            }
            this.mDeviceBusy = true;
            try {
                this.mService.writeDescriptor(this.mClientIf, device.getAddress(), service.getType(), service.getInstanceId(), new ParcelUuid(service.getUuid()), characteristic.getInstanceId(), new ParcelUuid(characteristic.getUuid()), bluetoothGattDescriptor.getInstanceId(), new ParcelUuid(bluetoothGattDescriptor.getUuid()), characteristic.getWriteType(), 0, bluetoothGattDescriptor.getValue());
                return true;
            } catch (RemoteException e) {
                Log.e(TAG, "", e);
                this.mDeviceBusy = false;
                return false;
            }
        }
    }
}
