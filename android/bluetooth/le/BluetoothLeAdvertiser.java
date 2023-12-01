package android.bluetooth.le;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattCallbackWrapper;
import android.bluetooth.BluetoothUuid;
import android.bluetooth.IBluetoothGatt;
import android.bluetooth.IBluetoothManager;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/le/BluetoothLeAdvertiser.class */
public final class BluetoothLeAdvertiser {
    private static final int FLAGS_FIELD_BYTES = 3;
    private static final int MANUFACTURER_SPECIFIC_DATA_LENGTH = 2;
    private static final int MAX_ADVERTISING_DATA_BYTES = 31;
    private static final int OVERHEAD_BYTES_PER_FIELD = 2;
    private static final int SERVICE_DATA_UUID_LENGTH = 2;
    private static final String TAG = "BluetoothLeAdvertiser";
    private final IBluetoothManager mBluetoothManager;
    private final Map<AdvertiseCallback, AdvertiseCallbackWrapper> mLeAdvertisers = new HashMap();
    private BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/le/BluetoothLeAdvertiser$AdvertiseCallbackWrapper.class */
    public class AdvertiseCallbackWrapper extends BluetoothGattCallbackWrapper {
        private static final int LE_CALLBACK_TIMEOUT_MILLIS = 2000;
        private final AdvertiseCallback mAdvertiseCallback;
        private final AdvertiseData mAdvertisement;
        private final IBluetoothGatt mBluetoothGatt;
        private final AdvertiseData mScanResponse;
        private final AdvertiseSettings mSettings;
        private boolean mIsAdvertising = false;
        private int mClientIf = 0;

        public AdvertiseCallbackWrapper(AdvertiseCallback advertiseCallback, AdvertiseData advertiseData, AdvertiseData advertiseData2, AdvertiseSettings advertiseSettings, IBluetoothGatt iBluetoothGatt) {
            this.mAdvertiseCallback = advertiseCallback;
            this.mAdvertisement = advertiseData;
            this.mScanResponse = advertiseData2;
            this.mSettings = advertiseSettings;
            this.mBluetoothGatt = iBluetoothGatt;
        }

        @Override // android.bluetooth.BluetoothGattCallbackWrapper, android.bluetooth.IBluetoothGattCallback
        public void onClientRegistered(int i, int i2) {
            Log.d(BluetoothLeAdvertiser.TAG, "onClientRegistered() - status=" + i + " clientIf=" + i2);
            synchronized (this) {
                if (i == 0) {
                    if (BluetoothLeAdvertiser.this.mBluetoothAdapter.isEnabled()) {
                        this.mClientIf = i2;
                        try {
                            this.mBluetoothGatt.startMultiAdvertising(this.mClientIf, this.mAdvertisement, this.mScanResponse, this.mSettings);
                            return;
                        } catch (RemoteException e) {
                            Log.e(BluetoothLeAdvertiser.TAG, "failed to start advertising", e);
                        }
                    }
                }
                this.mClientIf = -1;
                notifyAll();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallbackWrapper, android.bluetooth.IBluetoothGattCallback
        public void onMultiAdvertiseCallback(int i, boolean z, AdvertiseSettings advertiseSettings) {
            synchronized (this) {
                if (!z) {
                    try {
                        this.mBluetoothGatt.unregisterClient(this.mClientIf);
                        this.mClientIf = -1;
                        this.mIsAdvertising = false;
                        BluetoothLeAdvertiser.this.mLeAdvertisers.remove(this.mAdvertiseCallback);
                    } catch (RemoteException e) {
                        Log.e(BluetoothLeAdvertiser.TAG, "remote exception when unregistering", e);
                    }
                } else if (i == 0) {
                    this.mIsAdvertising = true;
                    BluetoothLeAdvertiser.this.postStartSuccess(this.mAdvertiseCallback, advertiseSettings);
                    if (!BluetoothLeAdvertiser.this.mLeAdvertisers.containsKey(this.mAdvertiseCallback)) {
                        BluetoothLeAdvertiser.this.mLeAdvertisers.put(this.mAdvertiseCallback, this);
                    }
                } else {
                    BluetoothLeAdvertiser.this.postStartFailure(this.mAdvertiseCallback, i);
                }
                notifyAll();
            }
        }

        public void startRegisteration() {
            synchronized (this) {
                if (this.mClientIf == -1) {
                    return;
                }
                try {
                    this.mBluetoothGatt.registerClient(new ParcelUuid(UUID.randomUUID()), this);
                    wait(2000L);
                } catch (RemoteException | InterruptedException e) {
                    Log.e(BluetoothLeAdvertiser.TAG, "Failed to start registeration", e);
                }
                if (this.mClientIf <= 0 || !this.mIsAdvertising) {
                    if (this.mClientIf <= 0) {
                        BluetoothLeAdvertiser.this.postStartFailure(this.mAdvertiseCallback, 4);
                    } else {
                        try {
                            this.mBluetoothGatt.unregisterClient(this.mClientIf);
                            this.mClientIf = -1;
                        } catch (RemoteException e2) {
                            Log.e(BluetoothLeAdvertiser.TAG, "remote exception when unregistering", e2);
                        }
                    }
                } else if (!BluetoothLeAdvertiser.this.mLeAdvertisers.containsKey(this.mAdvertiseCallback)) {
                    BluetoothLeAdvertiser.this.mLeAdvertisers.put(this.mAdvertiseCallback, this);
                }
            }
        }

        public void stopAdvertising() {
            synchronized (this) {
                try {
                    this.mBluetoothGatt.stopMultiAdvertising(this.mClientIf);
                    wait(2000L);
                } catch (RemoteException | InterruptedException e) {
                    Log.e(BluetoothLeAdvertiser.TAG, "Failed to stop advertising", e);
                }
                if (BluetoothLeAdvertiser.this.mLeAdvertisers.containsKey(this.mAdvertiseCallback)) {
                    BluetoothLeAdvertiser.this.mLeAdvertisers.remove(this.mAdvertiseCallback);
                }
            }
        }
    }

    public BluetoothLeAdvertiser(IBluetoothManager iBluetoothManager) {
        this.mBluetoothManager = iBluetoothManager;
    }

    private int byteLength(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postStartFailure(final AdvertiseCallback advertiseCallback, final int i) {
        this.mHandler.post(new Runnable() { // from class: android.bluetooth.le.BluetoothLeAdvertiser.1
            @Override // java.lang.Runnable
            public void run() {
                advertiseCallback.onStartFailure(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postStartSuccess(final AdvertiseCallback advertiseCallback, final AdvertiseSettings advertiseSettings) {
        this.mHandler.post(new Runnable() { // from class: android.bluetooth.le.BluetoothLeAdvertiser.2
            @Override // java.lang.Runnable
            public void run() {
                advertiseCallback.onStartSuccess(advertiseSettings);
            }
        });
    }

    private int totalBytes(AdvertiseData advertiseData, boolean z) {
        int i;
        int i2 = 0;
        if (advertiseData != null) {
            int i3 = z ? 3 : 0;
            int i4 = i3;
            if (advertiseData.getServiceUuids() != null) {
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                for (ParcelUuid parcelUuid : advertiseData.getServiceUuids()) {
                    if (BluetoothUuid.is16BitUuid(parcelUuid)) {
                        i5++;
                    } else if (BluetoothUuid.is32BitUuid(parcelUuid)) {
                        i6++;
                    } else {
                        i7++;
                    }
                }
                int i8 = i3;
                if (i5 != 0) {
                    i8 = i3 + (i5 * 2) + 2;
                }
                int i9 = i8;
                if (i6 != 0) {
                    i9 = i8 + (i6 * 4) + 2;
                }
                i4 = i9;
                if (i7 != 0) {
                    i4 = i9 + (i7 * 16) + 2;
                }
            }
            Iterator<ParcelUuid> it = advertiseData.getServiceData().keySet().iterator();
            int i10 = i4;
            while (true) {
                i = i10;
                if (!it.hasNext()) {
                    break;
                }
                i10 = i + byteLength(advertiseData.getServiceData().get(it.next())) + 4;
            }
            int i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 >= advertiseData.getManufacturerSpecificData().size()) {
                    break;
                }
                i += byteLength(advertiseData.getManufacturerSpecificData().valueAt(i12)) + 4;
                i11 = i12 + 1;
            }
            int i13 = i;
            if (advertiseData.getIncludeTxPowerLevel()) {
                i13 = i + 3;
            }
            i2 = i13;
            if (advertiseData.getIncludeDeviceName()) {
                i2 = i13;
                if (this.mBluetoothAdapter.getName() != null) {
                    return i13 + this.mBluetoothAdapter.getName().length() + 2;
                }
            }
        }
        return i2;
    }

    public void cleanup() {
        this.mLeAdvertisers.clear();
    }

    public void startAdvertising(AdvertiseSettings advertiseSettings, AdvertiseData advertiseData, AdvertiseCallback advertiseCallback) {
        startAdvertising(advertiseSettings, advertiseData, null, advertiseCallback);
    }

    public void startAdvertising(AdvertiseSettings advertiseSettings, AdvertiseData advertiseData, AdvertiseData advertiseData2, AdvertiseCallback advertiseCallback) {
        synchronized (this.mLeAdvertisers) {
            BluetoothLeUtils.checkAdapterStateOn(this.mBluetoothAdapter);
            if (advertiseCallback == null) {
                throw new IllegalArgumentException("callback cannot be null");
            }
            if (!this.mBluetoothAdapter.isMultipleAdvertisementSupported() && !this.mBluetoothAdapter.isPeripheralModeSupported()) {
                postStartFailure(advertiseCallback, 5);
            } else if (totalBytes(advertiseData, advertiseSettings.isConnectable()) > 31 || totalBytes(advertiseData2, false) > 31) {
                postStartFailure(advertiseCallback, 1);
            } else if (this.mLeAdvertisers.containsKey(advertiseCallback)) {
                postStartFailure(advertiseCallback, 3);
            } else {
                try {
                    new AdvertiseCallbackWrapper(advertiseCallback, advertiseData, advertiseData2, advertiseSettings, this.mBluetoothManager.getBluetoothGatt()).startRegisteration();
                } catch (RemoteException e) {
                    Log.e(TAG, "Failed to get Bluetooth gatt - ", e);
                    postStartFailure(advertiseCallback, 4);
                }
            }
        }
    }

    public void stopAdvertising(AdvertiseCallback advertiseCallback) {
        synchronized (this.mLeAdvertisers) {
            BluetoothLeUtils.checkAdapterStateOn(this.mBluetoothAdapter);
            if (advertiseCallback == null) {
                throw new IllegalArgumentException("callback cannot be null");
            }
            AdvertiseCallbackWrapper advertiseCallbackWrapper = this.mLeAdvertisers.get(advertiseCallback);
            if (advertiseCallbackWrapper == null) {
                return;
            }
            advertiseCallbackWrapper.stopAdvertising();
        }
    }
}
