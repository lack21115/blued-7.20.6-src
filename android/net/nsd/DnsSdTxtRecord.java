package android.net.nsd;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.util.i;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/net/nsd/DnsSdTxtRecord.class */
public class DnsSdTxtRecord implements Parcelable {
    public static final Parcelable.Creator<DnsSdTxtRecord> CREATOR = new Parcelable.Creator<DnsSdTxtRecord>() { // from class: android.net.nsd.DnsSdTxtRecord.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DnsSdTxtRecord createFromParcel(Parcel parcel) {
            DnsSdTxtRecord dnsSdTxtRecord = new DnsSdTxtRecord();
            parcel.readByteArray(dnsSdTxtRecord.mData);
            return dnsSdTxtRecord;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DnsSdTxtRecord[] newArray(int i) {
            return new DnsSdTxtRecord[i];
        }
    };
    private static final byte mSeperator = 61;
    private byte[] mData;

    public DnsSdTxtRecord() {
        this.mData = new byte[0];
    }

    public DnsSdTxtRecord(DnsSdTxtRecord dnsSdTxtRecord) {
        if (dnsSdTxtRecord == null || dnsSdTxtRecord.mData == null) {
            return;
        }
        this.mData = (byte[]) dnsSdTxtRecord.mData.clone();
    }

    public DnsSdTxtRecord(byte[] bArr) {
        this.mData = (byte[]) bArr.clone();
    }

    private String getKey(int i) {
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i || i3 >= this.mData.length) {
                break;
            }
            i3 += this.mData[i3] + 1;
            i4 = i5 + 1;
        }
        if (i3 < this.mData.length) {
            byte b = this.mData[i3];
            int i6 = 0;
            while (true) {
                i2 = i6;
                if (i2 >= b || this.mData[i3 + i2 + 1] == 61) {
                    break;
                }
                i6 = i2 + 1;
            }
            return new String(this.mData, i3 + 1, i2);
        }
        return null;
    }

    private byte[] getValue(int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i || i2 >= this.mData.length) {
                break;
            }
            i2 += this.mData[i2] + 1;
            i3 = i4 + 1;
        }
        byte[] bArr = null;
        if (i2 < this.mData.length) {
            byte b = this.mData[i2];
            int i5 = 0;
            while (true) {
                int i6 = i5;
                bArr = null;
                if (i6 >= b) {
                    break;
                } else if (this.mData[i2 + i6 + 1] == 61) {
                    bArr = new byte[(b - i6) - 1];
                    System.arraycopy(this.mData, i2 + i6 + 2, bArr, 0, (b - i6) - 1);
                    break;
                } else {
                    i5 = i6 + 1;
                }
            }
        }
        return bArr;
    }

    private byte[] getValue(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            String key = getKey(i2);
            if (key == null) {
                return null;
            }
            if (str.compareToIgnoreCase(key) == 0) {
                return getValue(i2);
            }
            i = i2 + 1;
        }
    }

    private String getValueAsString(int i) {
        byte[] value = getValue(i);
        if (value != null) {
            return new String(value);
        }
        return null;
    }

    private void insert(byte[] bArr, byte[] bArr2, int i) {
        byte[] bArr3 = this.mData;
        int length = bArr2 != null ? bArr2.length : 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i || i2 >= this.mData.length) {
                break;
            }
            i2 += (this.mData[i2] + 1) & 255;
            i3 = i4 + 1;
        }
        int length2 = bArr.length + length + (bArr2 != null ? 1 : 0);
        int length3 = bArr3.length + length2 + 1;
        this.mData = new byte[length3];
        System.arraycopy(bArr3, 0, this.mData, 0, i2);
        int length4 = bArr3.length - i2;
        System.arraycopy(bArr3, i2, this.mData, length3 - length4, length4);
        this.mData[i2] = (byte) length2;
        System.arraycopy(bArr, 0, this.mData, i2 + 1, bArr.length);
        if (bArr2 != null) {
            this.mData[i2 + 1 + bArr.length] = 61;
            System.arraycopy(bArr2, 0, this.mData, bArr.length + i2 + 2, length);
        }
    }

    public boolean contains(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            String key = getKey(i2);
            if (key == null) {
                return false;
            }
            if (str.compareToIgnoreCase(key) == 0) {
                return true;
            }
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DnsSdTxtRecord) {
            return Arrays.equals(((DnsSdTxtRecord) obj).mData, this.mData);
        }
        return false;
    }

    public String get(String str) {
        byte[] value = getValue(str);
        if (value != null) {
            return new String(value);
        }
        return null;
    }

    public byte[] getRawData() {
        return (byte[]) this.mData.clone();
    }

    public int hashCode() {
        return Arrays.hashCode(this.mData);
    }

    public int keyCount() {
        int i = 0;
        int i2 = 0;
        while (i2 < this.mData.length) {
            i2 += (this.mData[i2] + 1) & 255;
            i++;
        }
        return i;
    }

    public int remove(String str) {
        byte b = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (b >= this.mData.length) {
                return -1;
            }
            byte b2 = this.mData[b];
            if (str.length() <= b2 && ((str.length() == b2 || this.mData[str.length() + b + 1] == 61) && str.compareToIgnoreCase(new String(this.mData, b + 1, str.length())) == 0)) {
                byte[] bArr = this.mData;
                this.mData = new byte[(bArr.length - b2) - 1];
                System.arraycopy(bArr, 0, this.mData, 0, (int) b);
                System.arraycopy(bArr, b + b2 + 1, this.mData, (int) b, ((bArr.length - b) - b2) - 1);
                return i2;
            }
            b += (b2 + 1) & 255;
            i = i2 + 1;
        }
    }

    public void set(String str, String str2) {
        byte[] bArr;
        int i;
        if (str2 != null) {
            bArr = str2.getBytes();
            i = bArr.length;
        } else {
            bArr = null;
            i = 0;
        }
        try {
            byte[] bytes = str.getBytes("US-ASCII");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= bytes.length) {
                    if (bytes.length + i >= 255) {
                        throw new IllegalArgumentException("Key and Value length cannot exceed 255 bytes");
                    }
                    int remove = remove(str);
                    int i4 = remove;
                    if (remove == -1) {
                        i4 = keyCount();
                    }
                    insert(bytes, bArr, i4);
                    return;
                } else if (bytes[i3] == 61) {
                    throw new IllegalArgumentException("= is not a valid character in key");
                } else {
                    i2 = i3 + 1;
                }
            }
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("key should be US-ASCII");
        }
    }

    public int size() {
        return this.mData.length;
    }

    public String toString() {
        String str = null;
        int i = 0;
        while (true) {
            String key = getKey(i);
            if (key == null) {
                break;
            }
            String str2 = "{" + key;
            String valueAsString = getValueAsString(i);
            String str3 = valueAsString != null ? str2 + "=" + valueAsString + i.d : str2 + i.d;
            if (str != null) {
                str3 = str + ", " + str3;
            }
            i++;
            str = str3;
        }
        return str != null ? str : "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.mData);
    }
}
