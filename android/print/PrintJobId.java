package android.print;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.UUID;

/* loaded from: source-9557208-dex2jar.jar:android/print/PrintJobId.class */
public final class PrintJobId implements Parcelable {
    public static final Parcelable.Creator<PrintJobId> CREATOR = new Parcelable.Creator<PrintJobId>() { // from class: android.print.PrintJobId.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrintJobId createFromParcel(Parcel parcel) {
            return new PrintJobId(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrintJobId[] newArray(int i) {
            return new PrintJobId[i];
        }
    };
    private final String mValue;

    public PrintJobId() {
        this(UUID.randomUUID().toString());
    }

    public PrintJobId(String str) {
        this.mValue = str;
    }

    public static PrintJobId unflattenFromString(String str) {
        return new PrintJobId(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && TextUtils.equals(this.mValue, ((PrintJobId) obj).mValue);
    }

    public String flattenToString() {
        return this.mValue;
    }

    public int hashCode() {
        return (this.mValue != null ? this.mValue.hashCode() : 0) + 31;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mValue);
    }
}
