package android.bluetooth;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothGattCharacteristic.class */
public class BluetoothGattCharacteristic {
    public static final int FORMAT_FLOAT = 52;
    public static final int FORMAT_SFLOAT = 50;
    public static final int FORMAT_SINT16 = 34;
    public static final int FORMAT_SINT32 = 36;
    public static final int FORMAT_SINT8 = 33;
    public static final int FORMAT_UINT16 = 18;
    public static final int FORMAT_UINT32 = 20;
    public static final int FORMAT_UINT8 = 17;
    public static final int PERMISSION_READ = 1;
    public static final int PERMISSION_READ_ENCRYPTED = 2;
    public static final int PERMISSION_READ_ENCRYPTED_MITM = 4;
    public static final int PERMISSION_WRITE = 16;
    public static final int PERMISSION_WRITE_ENCRYPTED = 32;
    public static final int PERMISSION_WRITE_ENCRYPTED_MITM = 64;
    public static final int PERMISSION_WRITE_SIGNED = 128;
    public static final int PERMISSION_WRITE_SIGNED_MITM = 256;
    public static final int PROPERTY_BROADCAST = 1;
    public static final int PROPERTY_EXTENDED_PROPS = 128;
    public static final int PROPERTY_INDICATE = 32;
    public static final int PROPERTY_NOTIFY = 16;
    public static final int PROPERTY_READ = 2;
    public static final int PROPERTY_SIGNED_WRITE = 64;
    public static final int PROPERTY_WRITE = 8;
    public static final int PROPERTY_WRITE_NO_RESPONSE = 4;
    public static final int WRITE_TYPE_DEFAULT = 2;
    public static final int WRITE_TYPE_NO_RESPONSE = 1;
    public static final int WRITE_TYPE_SIGNED = 4;
    protected List<BluetoothGattDescriptor> mDescriptors;
    protected int mInstance;
    protected int mKeySize = 16;
    protected int mPermissions;
    protected int mProperties;
    protected BluetoothGattService mService;
    protected UUID mUuid;
    protected byte[] mValue;
    protected int mWriteType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothGattCharacteristic(BluetoothGattService bluetoothGattService, UUID uuid, int i, int i2, int i3) {
        initCharacteristic(bluetoothGattService, uuid, i, i2, i3);
    }

    public BluetoothGattCharacteristic(UUID uuid, int i, int i2) {
        initCharacteristic(null, uuid, 0, i, i2);
    }

    private float bytesToFloat(byte b, byte b2) {
        return (float) (unsignedToSigned(unsignedByteToInt(b) + ((unsignedByteToInt(b2) & 15) << 8), 12) * Math.pow(10.0d, unsignedToSigned(unsignedByteToInt(b2) >> 4, 4)));
    }

    private float bytesToFloat(byte b, byte b2, byte b3, byte b4) {
        return (float) (unsignedToSigned(unsignedByteToInt(b) + (unsignedByteToInt(b2) << 8) + (unsignedByteToInt(b3) << 16), 24) * Math.pow(10.0d, b4));
    }

    private int getTypeLen(int i) {
        return i & 15;
    }

    private void initCharacteristic(BluetoothGattService bluetoothGattService, UUID uuid, int i, int i2, int i3) {
        this.mUuid = uuid;
        this.mInstance = i;
        this.mProperties = i2;
        this.mPermissions = i3;
        this.mService = bluetoothGattService;
        this.mValue = null;
        this.mDescriptors = new ArrayList();
        if ((this.mProperties & 4) != 0) {
            this.mWriteType = 1;
        } else {
            this.mWriteType = 2;
        }
    }

    private int intToSignedBits(int i, int i2) {
        int i3 = i;
        if (i < 0) {
            i3 = (1 << (i2 - 1)) + (((1 << (i2 - 1)) - 1) & i);
        }
        return i3;
    }

    private int unsignedByteToInt(byte b) {
        return b & 255;
    }

    private int unsignedBytesToInt(byte b, byte b2) {
        return unsignedByteToInt(b) + (unsignedByteToInt(b2) << 8);
    }

    private int unsignedBytesToInt(byte b, byte b2, byte b3, byte b4) {
        return unsignedByteToInt(b) + (unsignedByteToInt(b2) << 8) + (unsignedByteToInt(b3) << 16) + (unsignedByteToInt(b4) << 24);
    }

    private int unsignedToSigned(int i, int i2) {
        int i3 = i;
        if (((1 << (i2 - 1)) & i) != 0) {
            i3 = ((1 << (i2 - 1)) - (((1 << (i2 - 1)) - 1) & i)) * (-1);
        }
        return i3;
    }

    public boolean addDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor) {
        this.mDescriptors.add(bluetoothGattDescriptor);
        bluetoothGattDescriptor.setCharacteristic(this);
        return true;
    }

    public BluetoothGattDescriptor getDescriptor(UUID uuid) {
        for (BluetoothGattDescriptor bluetoothGattDescriptor : this.mDescriptors) {
            if (bluetoothGattDescriptor.getUuid().equals(uuid)) {
                return bluetoothGattDescriptor;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothGattDescriptor getDescriptor(UUID uuid, int i) {
        for (BluetoothGattDescriptor bluetoothGattDescriptor : this.mDescriptors) {
            if (bluetoothGattDescriptor.getUuid().equals(uuid) && bluetoothGattDescriptor.getInstanceId() == i) {
                return bluetoothGattDescriptor;
            }
        }
        return null;
    }

    public List<BluetoothGattDescriptor> getDescriptors() {
        return this.mDescriptors;
    }

    public Float getFloatValue(int i, int i2) {
        if (getTypeLen(i) + i2 > this.mValue.length) {
            return null;
        }
        switch (i) {
            case 50:
                return Float.valueOf(bytesToFloat(this.mValue[i2], this.mValue[i2 + 1]));
            case 51:
            default:
                return null;
            case 52:
                return Float.valueOf(bytesToFloat(this.mValue[i2], this.mValue[i2 + 1], this.mValue[i2 + 2], this.mValue[i2 + 3]));
        }
    }

    public int getInstanceId() {
        return this.mInstance;
    }

    public Integer getIntValue(int i, int i2) {
        if (getTypeLen(i) + i2 > this.mValue.length) {
            return null;
        }
        switch (i) {
            case 17:
                return Integer.valueOf(unsignedByteToInt(this.mValue[i2]));
            case 18:
                return Integer.valueOf(unsignedBytesToInt(this.mValue[i2], this.mValue[i2 + 1]));
            case 20:
                return Integer.valueOf(unsignedBytesToInt(this.mValue[i2], this.mValue[i2 + 1], this.mValue[i2 + 2], this.mValue[i2 + 3]));
            case 33:
                return Integer.valueOf(unsignedToSigned(unsignedByteToInt(this.mValue[i2]), 8));
            case 34:
                return Integer.valueOf(unsignedToSigned(unsignedBytesToInt(this.mValue[i2], this.mValue[i2 + 1]), 16));
            case 36:
                return Integer.valueOf(unsignedToSigned(unsignedBytesToInt(this.mValue[i2], this.mValue[i2 + 1], this.mValue[i2 + 2], this.mValue[i2 + 3]), 32));
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getKeySize() {
        return this.mKeySize;
    }

    public int getPermissions() {
        return this.mPermissions;
    }

    public int getProperties() {
        return this.mProperties;
    }

    public BluetoothGattService getService() {
        return this.mService;
    }

    public String getStringValue(int i) {
        if (this.mValue == null || i > this.mValue.length) {
            return null;
        }
        byte[] bArr = new byte[this.mValue.length - i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 == this.mValue.length - i) {
                return new String(bArr);
            }
            bArr[i3] = this.mValue[i + i3];
            i2 = i3 + 1;
        }
    }

    public UUID getUuid() {
        return this.mUuid;
    }

    public byte[] getValue() {
        return this.mValue;
    }

    public int getWriteType() {
        return this.mWriteType;
    }

    public void setKeySize(int i) {
        this.mKeySize = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setService(BluetoothGattService bluetoothGattService) {
        this.mService = bluetoothGattService;
    }

    public boolean setValue(int i, int i2, int i3) {
        int typeLen = i3 + getTypeLen(i2);
        if (this.mValue == null) {
            this.mValue = new byte[typeLen];
        }
        if (typeLen > this.mValue.length) {
            return false;
        }
        int i4 = i;
        int i5 = i;
        int i6 = i;
        switch (i2) {
            case 17:
                this.mValue[i3] = (byte) (i4 & 255);
                return true;
            case 18:
                this.mValue[i3] = (byte) (i5 & 255);
                this.mValue[i3 + 1] = (byte) ((i5 >> 8) & 255);
                return true;
            case 20:
                int i7 = i3 + 1;
                this.mValue[i3] = (byte) (i6 & 255);
                int i8 = i7 + 1;
                this.mValue[i7] = (byte) ((i6 >> 8) & 255);
                this.mValue[i8] = (byte) ((i6 >> 16) & 255);
                this.mValue[i8 + 1] = (byte) ((i6 >> 24) & 255);
                return true;
            case 33:
                i4 = intToSignedBits(i, 8);
                this.mValue[i3] = (byte) (i4 & 255);
                return true;
            case 34:
                i5 = intToSignedBits(i, 16);
                this.mValue[i3] = (byte) (i5 & 255);
                this.mValue[i3 + 1] = (byte) ((i5 >> 8) & 255);
                return true;
            case 36:
                i6 = intToSignedBits(i, 32);
                int i72 = i3 + 1;
                this.mValue[i3] = (byte) (i6 & 255);
                int i82 = i72 + 1;
                this.mValue[i72] = (byte) ((i6 >> 8) & 255);
                this.mValue[i82] = (byte) ((i6 >> 16) & 255);
                this.mValue[i82 + 1] = (byte) ((i6 >> 24) & 255);
                return true;
            default:
                return false;
        }
    }

    public boolean setValue(int i, int i2, int i3, int i4) {
        int typeLen = i4 + getTypeLen(i3);
        if (this.mValue == null) {
            this.mValue = new byte[typeLen];
        }
        if (typeLen > this.mValue.length) {
            return false;
        }
        switch (i3) {
            case 50:
                int intToSignedBits = intToSignedBits(i, 12);
                int intToSignedBits2 = intToSignedBits(i2, 4);
                int i5 = i4 + 1;
                this.mValue[i4] = (byte) (intToSignedBits & 255);
                this.mValue[i5] = (byte) ((intToSignedBits >> 8) & 15);
                byte[] bArr = this.mValue;
                bArr[i5] = (byte) (bArr[i5] + ((byte) ((intToSignedBits2 & 15) << 4)));
                return true;
            case 51:
            default:
                return false;
            case 52:
                int intToSignedBits3 = intToSignedBits(i, 24);
                int intToSignedBits4 = intToSignedBits(i2, 8);
                int i6 = i4 + 1;
                this.mValue[i4] = (byte) (intToSignedBits3 & 255);
                int i7 = i6 + 1;
                this.mValue[i6] = (byte) ((intToSignedBits3 >> 8) & 255);
                int i8 = i7 + 1;
                this.mValue[i7] = (byte) ((intToSignedBits3 >> 16) & 255);
                byte[] bArr2 = this.mValue;
                bArr2[i8] = (byte) (bArr2[i8] + ((byte) (intToSignedBits4 & 255)));
                return true;
        }
    }

    public boolean setValue(String str) {
        this.mValue = str.getBytes();
        return true;
    }

    public boolean setValue(byte[] bArr) {
        this.mValue = bArr;
        return true;
    }

    public void setWriteType(int i) {
        this.mWriteType = i;
    }
}
