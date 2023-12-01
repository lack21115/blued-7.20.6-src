package android.nfc;

import android.nfc.INfcTag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcBarcode;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/Tag.class */
public final class Tag implements Parcelable {
    public static final Parcelable.Creator<Tag> CREATOR = new Parcelable.Creator<Tag>() { // from class: android.nfc.Tag.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Tag createFromParcel(Parcel parcel) {
            byte[] readBytesWithNull = Tag.readBytesWithNull(parcel);
            int[] iArr = new int[parcel.readInt()];
            parcel.readIntArray(iArr);
            return new Tag(readBytesWithNull, iArr, (Bundle[]) parcel.createTypedArray(Bundle.CREATOR), parcel.readInt(), parcel.readInt() == 0 ? INfcTag.Stub.asInterface(parcel.readStrongBinder()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Tag[] newArray(int i) {
            return new Tag[i];
        }
    };
    int mConnectedTechnology;
    final byte[] mId;
    final int mServiceHandle;
    final INfcTag mTagService;
    final Bundle[] mTechExtras;
    final int[] mTechList;
    final String[] mTechStringList;

    public Tag(byte[] bArr, int[] iArr, Bundle[] bundleArr, int i, INfcTag iNfcTag) {
        if (iArr == null) {
            throw new IllegalArgumentException("rawTargets cannot be null");
        }
        this.mId = bArr;
        this.mTechList = Arrays.copyOf(iArr, iArr.length);
        this.mTechStringList = generateTechStringList(iArr);
        this.mTechExtras = (Bundle[]) Arrays.copyOf(bundleArr, iArr.length);
        this.mServiceHandle = i;
        this.mTagService = iNfcTag;
        this.mConnectedTechnology = -1;
    }

    public static Tag createMockTag(byte[] bArr, int[] iArr, Bundle[] bundleArr) {
        return new Tag(bArr, iArr, bundleArr, 0, null);
    }

    private String[] generateTechStringList(int[] iArr) {
        int length = iArr.length;
        String[] strArr = new String[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return strArr;
            }
            switch (iArr[i2]) {
                case 1:
                    strArr[i2] = NfcA.class.getName();
                    break;
                case 2:
                    strArr[i2] = NfcB.class.getName();
                    break;
                case 3:
                    strArr[i2] = IsoDep.class.getName();
                    break;
                case 4:
                    strArr[i2] = NfcF.class.getName();
                    break;
                case 5:
                    strArr[i2] = NfcV.class.getName();
                    break;
                case 6:
                    strArr[i2] = Ndef.class.getName();
                    break;
                case 7:
                    strArr[i2] = NdefFormatable.class.getName();
                    break;
                case 8:
                    strArr[i2] = MifareClassic.class.getName();
                    break;
                case 9:
                    strArr[i2] = MifareUltralight.class.getName();
                    break;
                case 10:
                    strArr[i2] = NfcBarcode.class.getName();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown tech type " + iArr[i2]);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] getTechCodesFromStrings(String[] strArr) throws IllegalArgumentException {
        if (strArr == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        int[] iArr = new int[strArr.length];
        HashMap<String, Integer> techStringToCodeMap = getTechStringToCodeMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return iArr;
            }
            Integer num = techStringToCodeMap.get(strArr[i2]);
            if (num == null) {
                throw new IllegalArgumentException("Unknown tech type " + strArr[i2]);
            }
            iArr[i2] = num.intValue();
            i = i2 + 1;
        }
    }

    private static HashMap<String, Integer> getTechStringToCodeMap() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put(IsoDep.class.getName(), 3);
        hashMap.put(MifareClassic.class.getName(), 8);
        hashMap.put(MifareUltralight.class.getName(), 9);
        hashMap.put(Ndef.class.getName(), 6);
        hashMap.put(NdefFormatable.class.getName(), 7);
        hashMap.put(NfcA.class.getName(), 1);
        hashMap.put(NfcB.class.getName(), 2);
        hashMap.put(NfcF.class.getName(), 4);
        hashMap.put(NfcV.class.getName(), 5);
        hashMap.put(NfcBarcode.class.getName(), 10);
        return hashMap;
    }

    static byte[] readBytesWithNull(Parcel parcel) {
        int readInt = parcel.readInt();
        byte[] bArr = null;
        if (readInt >= 0) {
            bArr = new byte[readInt];
            parcel.readByteArray(bArr);
        }
        return bArr;
    }

    static void writeBytesWithNull(Parcel parcel, byte[] bArr) {
        if (bArr == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getConnectedTechnology() {
        return this.mConnectedTechnology;
    }

    public byte[] getId() {
        return this.mId;
    }

    public int getServiceHandle() {
        return this.mServiceHandle;
    }

    public INfcTag getTagService() {
        return this.mTagService;
    }

    public int[] getTechCodeList() {
        return this.mTechList;
    }

    public Bundle getTechExtras(int i) {
        int i2;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            i2 = -1;
            if (i4 >= this.mTechList.length) {
                break;
            } else if (this.mTechList[i4] == i) {
                i2 = i4;
                break;
            } else {
                i3 = i4 + 1;
            }
        }
        if (i2 < 0) {
            return null;
        }
        return this.mTechExtras[i2];
    }

    public String[] getTechList() {
        return this.mTechStringList;
    }

    public boolean hasTech(int i) {
        int[] iArr = this.mTechList;
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            if (iArr[i3] == i) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    public Tag rediscover() throws IOException {
        if (getConnectedTechnology() != -1) {
            throw new IllegalStateException("Close connection to the technology first!");
        }
        if (this.mTagService == null) {
            throw new IOException("Mock tags don't support this operation.");
        }
        try {
            Tag rediscover = this.mTagService.rediscover(getServiceHandle());
            if (rediscover != null) {
                return rediscover;
            }
            throw new IOException("Failed to rediscover tag");
        } catch (RemoteException e) {
            throw new IOException("NFC service dead");
        }
    }

    public void setConnectedTechnology(int i) {
        synchronized (this) {
            if (this.mConnectedTechnology != -1) {
                throw new IllegalStateException("Close other technology first!");
            }
            this.mConnectedTechnology = i;
        }
    }

    public void setTechnologyDisconnected() {
        this.mConnectedTechnology = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TAG: Tech [");
        String[] techList = getTechList();
        int length = techList.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(techList[i2]);
            if (i2 < length - 1) {
                sb.append(", ");
            }
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = this.mTagService == null ? 1 : 0;
        writeBytesWithNull(parcel, this.mId);
        parcel.writeInt(this.mTechList.length);
        parcel.writeIntArray(this.mTechList);
        parcel.writeTypedArray(this.mTechExtras, 0);
        parcel.writeInt(this.mServiceHandle);
        parcel.writeInt(i2);
        if (i2 == 0) {
            parcel.writeStrongBinder(this.mTagService.asBinder());
        }
    }
}
