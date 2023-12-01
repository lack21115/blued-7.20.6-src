package android.print;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: source-9557208-dex2jar.jar:android/print/PrinterInfo.class */
public final class PrinterInfo implements Parcelable {
    public static final Parcelable.Creator<PrinterInfo> CREATOR = new Parcelable.Creator<PrinterInfo>() { // from class: android.print.PrinterInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrinterInfo createFromParcel(Parcel parcel) {
            return new PrinterInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrinterInfo[] newArray(int i) {
            return new PrinterInfo[i];
        }
    };
    public static final int STATUS_BUSY = 2;
    public static final int STATUS_IDLE = 1;
    public static final int STATUS_UNAVAILABLE = 3;
    private PrinterCapabilitiesInfo mCapabilities;
    private String mDescription;
    private PrinterId mId;
    private String mName;
    private int mStatus;

    /* loaded from: source-9557208-dex2jar.jar:android/print/PrinterInfo$Builder.class */
    public static final class Builder {
        private final PrinterInfo mPrototype;

        public Builder(PrinterId printerId, String str, int i) {
            if (printerId == null) {
                throw new IllegalArgumentException("printerId cannot be null.");
            }
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("name cannot be empty.");
            }
            if (!isValidStatus(i)) {
                throw new IllegalArgumentException("status is invalid.");
            }
            this.mPrototype = new PrinterInfo();
            this.mPrototype.mId = printerId;
            this.mPrototype.mName = str;
            this.mPrototype.mStatus = i;
        }

        public Builder(PrinterInfo printerInfo) {
            this.mPrototype = new PrinterInfo();
            this.mPrototype.copyFrom(printerInfo);
        }

        private boolean isValidStatus(int i) {
            return i == 1 || i == 2 || i == 3;
        }

        public PrinterInfo build() {
            return this.mPrototype;
        }

        public Builder setCapabilities(PrinterCapabilitiesInfo printerCapabilitiesInfo) {
            this.mPrototype.mCapabilities = printerCapabilitiesInfo;
            return this;
        }

        public Builder setDescription(String str) {
            this.mPrototype.mDescription = str;
            return this;
        }

        public Builder setName(String str) {
            this.mPrototype.mName = str;
            return this;
        }

        public Builder setStatus(int i) {
            this.mPrototype.mStatus = i;
            return this;
        }
    }

    private PrinterInfo() {
    }

    private PrinterInfo(Parcel parcel) {
        this.mId = (PrinterId) parcel.readParcelable(null);
        this.mName = parcel.readString();
        this.mStatus = parcel.readInt();
        this.mDescription = parcel.readString();
        this.mCapabilities = (PrinterCapabilitiesInfo) parcel.readParcelable(null);
    }

    private PrinterInfo(PrinterInfo printerInfo) {
        copyFrom(printerInfo);
    }

    public void copyFrom(PrinterInfo printerInfo) {
        if (this == printerInfo) {
            return;
        }
        this.mId = printerInfo.mId;
        this.mName = printerInfo.mName;
        this.mStatus = printerInfo.mStatus;
        this.mDescription = printerInfo.mDescription;
        if (printerInfo.mCapabilities == null) {
            this.mCapabilities = null;
        } else if (this.mCapabilities != null) {
            this.mCapabilities.copyFrom(printerInfo.mCapabilities);
        } else {
            this.mCapabilities = new PrinterCapabilitiesInfo(printerInfo.mCapabilities);
        }
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
            PrinterInfo printerInfo = (PrinterInfo) obj;
            if (this.mId == null) {
                if (printerInfo.mId != null) {
                    return false;
                }
            } else if (!this.mId.equals(printerInfo.mId)) {
                return false;
            }
            if (TextUtils.equals(this.mName, printerInfo.mName) && this.mStatus == printerInfo.mStatus && TextUtils.equals(this.mDescription, printerInfo.mDescription)) {
                return this.mCapabilities == null ? printerInfo.mCapabilities == null : this.mCapabilities.equals(printerInfo.mCapabilities);
            }
            return false;
        }
        return false;
    }

    public PrinterCapabilitiesInfo getCapabilities() {
        return this.mCapabilities;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public PrinterId getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.mId != null ? this.mId.hashCode() : 0;
        int hashCode2 = this.mName != null ? this.mName.hashCode() : 0;
        int i2 = this.mStatus;
        int hashCode3 = this.mDescription != null ? this.mDescription.hashCode() : 0;
        if (this.mCapabilities != null) {
            i = this.mCapabilities.hashCode();
        }
        return ((((((((hashCode + 31) * 31) + hashCode2) * 31) + i2) * 31) + hashCode3) * 31) + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PrinterInfo{");
        sb.append("id=").append(this.mId);
        sb.append(", name=").append(this.mName);
        sb.append(", status=").append(this.mStatus);
        sb.append(", description=").append(this.mDescription);
        sb.append(", capabilities=").append(this.mCapabilities);
        sb.append("\"}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mId, i);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mStatus);
        parcel.writeString(this.mDescription);
        parcel.writeParcelable(this.mCapabilities, i);
    }
}
