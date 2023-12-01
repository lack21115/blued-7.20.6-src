package android.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/TransceiveResult.class */
public final class TransceiveResult implements Parcelable {
    public static final Parcelable.Creator<TransceiveResult> CREATOR = new Parcelable.Creator<TransceiveResult>() { // from class: android.nfc.TransceiveResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TransceiveResult createFromParcel(Parcel parcel) {
            byte[] bArr;
            int readInt = parcel.readInt();
            if (readInt == 0) {
                byte[] bArr2 = new byte[parcel.readInt()];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            } else {
                bArr = null;
            }
            return new TransceiveResult(readInt, bArr);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TransceiveResult[] newArray(int i) {
            return new TransceiveResult[i];
        }
    };
    public static final int RESULT_EXCEEDED_LENGTH = 3;
    public static final int RESULT_FAILURE = 1;
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_TAGLOST = 2;
    final byte[] mResponseData;
    final int mResult;

    public TransceiveResult(int i, byte[] bArr) {
        this.mResult = i;
        this.mResponseData = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] getResponseOrThrow() throws IOException {
        switch (this.mResult) {
            case 0:
                return this.mResponseData;
            case 1:
            default:
                throw new IOException("Transceive failed");
            case 2:
                throw new TagLostException("Tag was lost.");
            case 3:
                throw new IOException("Transceive length exceeds supported maximum");
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mResult);
        if (this.mResult == 0) {
            parcel.writeInt(this.mResponseData.length);
            parcel.writeByteArray(this.mResponseData);
        }
    }
}
