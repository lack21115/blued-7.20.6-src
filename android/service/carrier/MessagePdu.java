package android.service.carrier;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/service/carrier/MessagePdu.class */
public final class MessagePdu implements Parcelable {
    public static final Parcelable.Creator<MessagePdu> CREATOR = new Parcelable.Creator<MessagePdu>() { // from class: android.service.carrier.MessagePdu.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessagePdu createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            int readInt = parcel.readInt();
            if (readInt != -1) {
                ArrayList arrayList2 = new ArrayList(readInt);
                int i = 0;
                while (true) {
                    int i2 = i;
                    arrayList = arrayList2;
                    if (i2 >= readInt) {
                        break;
                    }
                    arrayList2.add(parcel.createByteArray());
                    i = i2 + 1;
                }
            } else {
                arrayList = null;
            }
            return new MessagePdu(arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessagePdu[] newArray(int i) {
            return new MessagePdu[i];
        }
    };
    private static final int NULL_LENGTH = -1;
    private final List<byte[]> mPduList;

    public MessagePdu(List<byte[]> list) {
        if (list == null || list.contains(null)) {
            throw new IllegalArgumentException("pduList must not be null or contain nulls");
        }
        this.mPduList = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<byte[]> getPdus() {
        return this.mPduList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.mPduList == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(this.mPduList.size());
        for (byte[] bArr : this.mPduList) {
            parcel.writeByteArray(bArr);
        }
    }
}
