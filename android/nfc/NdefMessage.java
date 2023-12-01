package android.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/NdefMessage.class */
public final class NdefMessage implements Parcelable {
    public static final Parcelable.Creator<NdefMessage> CREATOR = new Parcelable.Creator<NdefMessage>() { // from class: android.nfc.NdefMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NdefMessage createFromParcel(Parcel parcel) {
            NdefRecord[] ndefRecordArr = new NdefRecord[parcel.readInt()];
            parcel.readTypedArray(ndefRecordArr, NdefRecord.CREATOR);
            return new NdefMessage(ndefRecordArr);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NdefMessage[] newArray(int i) {
            return new NdefMessage[i];
        }
    };
    private final NdefRecord[] mRecords;

    public NdefMessage(NdefRecord ndefRecord, NdefRecord... ndefRecordArr) {
        if (ndefRecord == null) {
            throw new NullPointerException("record cannot be null");
        }
        int length = ndefRecordArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.mRecords = new NdefRecord[ndefRecordArr.length + 1];
                this.mRecords[0] = ndefRecord;
                System.arraycopy(ndefRecordArr, 0, this.mRecords, 1, ndefRecordArr.length);
                return;
            } else if (ndefRecordArr[i2] == null) {
                throw new NullPointerException("record cannot be null");
            } else {
                i = i2 + 1;
            }
        }
    }

    public NdefMessage(byte[] bArr) throws FormatException {
        if (bArr == null) {
            throw new NullPointerException("data is null");
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.mRecords = NdefRecord.parse(wrap, false);
        if (wrap.remaining() > 0) {
            throw new FormatException("trailing data");
        }
    }

    public NdefMessage(NdefRecord[] ndefRecordArr) {
        if (ndefRecordArr.length < 1) {
            throw new IllegalArgumentException("must have at least one record");
        }
        int length = ndefRecordArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.mRecords = ndefRecordArr;
                return;
            } else if (ndefRecordArr[i2] == null) {
                throw new NullPointerException("records cannot contain null");
            } else {
                i = i2 + 1;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            z = true;
        } else {
            z = false;
            if (obj != null) {
                z = false;
                if (getClass() == obj.getClass()) {
                    return Arrays.equals(this.mRecords, ((NdefMessage) obj).mRecords);
                }
            }
        }
        return z;
    }

    public int getByteArrayLength() {
        int i = 0;
        NdefRecord[] ndefRecordArr = this.mRecords;
        int length = ndefRecordArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return i;
            }
            i += ndefRecordArr[i3].getByteLength();
            i2 = i3 + 1;
        }
    }

    public NdefRecord[] getRecords() {
        return this.mRecords;
    }

    public int hashCode() {
        return Arrays.hashCode(this.mRecords);
    }

    public byte[] toByteArray() {
        ByteBuffer allocate = ByteBuffer.allocate(getByteArrayLength());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mRecords.length) {
                return allocate.array();
            }
            this.mRecords[i2].writeToByteBuffer(allocate, i2 == 0, i2 == this.mRecords.length - 1);
            i = i2 + 1;
        }
    }

    public String toString() {
        return "NdefMessage " + Arrays.toString(this.mRecords);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mRecords.length);
        parcel.writeTypedArray(this.mRecords, i);
    }
}
