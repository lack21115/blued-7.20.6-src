package android.print;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: source-9557208-dex2jar.jar:android/print/PrinterId.class */
public final class PrinterId implements Parcelable {
    public static final Parcelable.Creator<PrinterId> CREATOR = new Parcelable.Creator<PrinterId>() { // from class: android.print.PrinterId.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrinterId createFromParcel(Parcel parcel) {
            return new PrinterId(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrinterId[] newArray(int i) {
            return new PrinterId[i];
        }
    };
    private final String mLocalId;
    private final ComponentName mServiceName;

    public PrinterId(ComponentName componentName, String str) {
        this.mServiceName = componentName;
        this.mLocalId = str;
    }

    private PrinterId(Parcel parcel) {
        this.mServiceName = (ComponentName) parcel.readParcelable(null);
        this.mLocalId = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PrinterId printerId = (PrinterId) obj;
            if (this.mServiceName == null) {
                if (printerId.mServiceName != null) {
                    return false;
                }
            } else if (!this.mServiceName.equals(printerId.mServiceName)) {
                return false;
            }
            return TextUtils.equals(this.mLocalId, printerId.mLocalId);
        }
        return false;
    }

    public String getLocalId() {
        return this.mLocalId;
    }

    public ComponentName getServiceName() {
        return this.mServiceName;
    }

    public int hashCode() {
        return (((this.mServiceName != null ? this.mServiceName.hashCode() : 1) + 31) * 31) + this.mLocalId.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PrinterId{");
        sb.append("serviceName=").append(this.mServiceName.flattenToString());
        sb.append(", localId=").append(this.mLocalId);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mServiceName, i);
        parcel.writeString(this.mLocalId);
    }
}
