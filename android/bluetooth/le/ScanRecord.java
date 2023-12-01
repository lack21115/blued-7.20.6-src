package android.bluetooth.le;

import android.bluetooth.BluetoothUuid;
import android.os.ParcelUuid;
import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/le/ScanRecord.class */
public final class ScanRecord {
    private static final int DATA_TYPE_FLAGS = 1;
    private static final int DATA_TYPE_LOCAL_NAME_COMPLETE = 9;
    private static final int DATA_TYPE_LOCAL_NAME_SHORT = 8;
    private static final int DATA_TYPE_MANUFACTURER_SPECIFIC_DATA = 255;
    private static final int DATA_TYPE_SERVICE_DATA = 22;
    private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_COMPLETE = 7;
    private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_PARTIAL = 6;
    private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_COMPLETE = 3;
    private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_PARTIAL = 2;
    private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_COMPLETE = 5;
    private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_PARTIAL = 4;
    private static final int DATA_TYPE_TX_POWER_LEVEL = 10;
    private static final String TAG = "ScanRecord";
    private final int mAdvertiseFlags;
    private final byte[] mBytes;
    private final String mDeviceName;
    private final SparseArray<byte[]> mManufacturerSpecificData;
    private final Map<ParcelUuid, byte[]> mServiceData;
    private final List<ParcelUuid> mServiceUuids;
    private final int mTxPowerLevel;

    private ScanRecord(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i, int i2, String str, byte[] bArr) {
        this.mServiceUuids = list;
        this.mManufacturerSpecificData = sparseArray;
        this.mServiceData = map;
        this.mDeviceName = str;
        this.mAdvertiseFlags = i;
        this.mTxPowerLevel = i2;
        this.mBytes = bArr;
    }

    private static byte[] extractBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static ScanRecord parseFromBytes(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int i = -1;
        ArrayList arrayList = new ArrayList();
        String str = null;
        byte b = -2147483648;
        SparseArray sparseArray = new SparseArray();
        ArrayMap arrayMap = new ArrayMap();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            try {
                if (i3 < bArr.length) {
                    int i4 = i3 + 1;
                    int i5 = bArr[i3] & 255;
                    if (i5 != 0) {
                        int i6 = i5 - 1;
                        int i7 = i4 + 1;
                        switch (bArr[i4] & 255) {
                            case 1:
                                i = bArr[i7] & 255;
                                break;
                            case 2:
                            case 3:
                                parseServiceUuid(bArr, i7, i6, 2, arrayList);
                                break;
                            case 4:
                            case 5:
                                parseServiceUuid(bArr, i7, i6, 4, arrayList);
                                break;
                            case 6:
                            case 7:
                                parseServiceUuid(bArr, i7, i6, 16, arrayList);
                                break;
                            case 8:
                            case 9:
                                str = new String(extractBytes(bArr, i7, i6));
                                break;
                            case 10:
                                b = bArr[i7];
                                break;
                            case 22:
                                arrayMap.put(BluetoothUuid.parseUuidFrom(extractBytes(bArr, i7, 2)), extractBytes(bArr, i7 + 2, i6 - 2));
                                break;
                            case 255:
                                sparseArray.put(((bArr[i7 + 1] & 255) << 8) + (bArr[i7] & 255), extractBytes(bArr, i7 + 2, i6 - 2));
                                break;
                        }
                        i2 = i7 + i6;
                    }
                }
            } catch (Exception e) {
            }
        }
        ArrayList arrayList2 = arrayList;
        try {
            if (arrayList.isEmpty()) {
                arrayList2 = null;
            }
            return new ScanRecord(arrayList2, sparseArray, arrayMap, i, b, str, bArr);
        } catch (Exception e2) {
            Log.e(TAG, "unable to parse scan record: " + Arrays.toString(bArr));
            return new ScanRecord(null, null, null, -1, Integer.MIN_VALUE, null, bArr);
        }
    }

    private static int parseServiceUuid(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(BluetoothUuid.parseUuidFrom(extractBytes(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    public int getAdvertiseFlags() {
        return this.mAdvertiseFlags;
    }

    public byte[] getBytes() {
        return this.mBytes;
    }

    public String getDeviceName() {
        return this.mDeviceName;
    }

    public SparseArray<byte[]> getManufacturerSpecificData() {
        return this.mManufacturerSpecificData;
    }

    public byte[] getManufacturerSpecificData(int i) {
        return this.mManufacturerSpecificData.get(i);
    }

    public Map<ParcelUuid, byte[]> getServiceData() {
        return this.mServiceData;
    }

    public byte[] getServiceData(ParcelUuid parcelUuid) {
        if (parcelUuid == null) {
            return null;
        }
        return this.mServiceData.get(parcelUuid);
    }

    public List<ParcelUuid> getServiceUuids() {
        return this.mServiceUuids;
    }

    public int getTxPowerLevel() {
        return this.mTxPowerLevel;
    }

    public String toString() {
        return "ScanRecord [mAdvertiseFlags=" + this.mAdvertiseFlags + ", mServiceUuids=" + this.mServiceUuids + ", mManufacturerSpecificData=" + BluetoothLeUtils.toString(this.mManufacturerSpecificData) + ", mServiceData=" + BluetoothLeUtils.toString(this.mServiceData) + ", mTxPowerLevel=" + this.mTxPowerLevel + ", mDeviceName=" + this.mDeviceName + "]";
    }
}
