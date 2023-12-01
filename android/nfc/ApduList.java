package android.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/ApduList.class */
public class ApduList implements Parcelable {
    public static final Parcelable.Creator<ApduList> CREATOR = new Parcelable.Creator<ApduList>() { // from class: android.nfc.ApduList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ApduList createFromParcel(Parcel parcel) {
            return new ApduList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ApduList[] newArray(int i) {
            return new ApduList[i];
        }
    };
    private ArrayList<byte[]> commands;

    public ApduList() {
        this.commands = new ArrayList<>();
    }

    private ApduList(Parcel parcel) {
        this.commands = new ArrayList<>();
        int readInt = parcel.readInt();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            this.commands.add(bArr);
            i = i2 + 1;
        }
    }

    public void add(byte[] bArr) {
        this.commands.add(bArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<byte[]> get() {
        return this.commands;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.commands.size());
        Iterator<byte[]> it = this.commands.iterator();
        while (it.hasNext()) {
            byte[] next = it.next();
            parcel.writeInt(next.length);
            parcel.writeByteArray(next);
        }
    }
}
