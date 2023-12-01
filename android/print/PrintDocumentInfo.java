package android.print;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: source-9557208-dex2jar.jar:android/print/PrintDocumentInfo.class */
public final class PrintDocumentInfo implements Parcelable {
    public static final int CONTENT_TYPE_DOCUMENT = 0;
    public static final int CONTENT_TYPE_PHOTO = 1;
    public static final int CONTENT_TYPE_UNKNOWN = -1;
    public static final Parcelable.Creator<PrintDocumentInfo> CREATOR = new Parcelable.Creator<PrintDocumentInfo>() { // from class: android.print.PrintDocumentInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrintDocumentInfo createFromParcel(Parcel parcel) {
            return new PrintDocumentInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrintDocumentInfo[] newArray(int i) {
            return new PrintDocumentInfo[i];
        }
    };
    public static final int PAGE_COUNT_UNKNOWN = -1;
    private int mContentType;
    private long mDataSize;
    private String mName;
    private int mPageCount;

    /* loaded from: source-9557208-dex2jar.jar:android/print/PrintDocumentInfo$Builder.class */
    public static final class Builder {
        private final PrintDocumentInfo mPrototype;

        public Builder(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("name cannot be empty");
            }
            this.mPrototype = new PrintDocumentInfo();
            this.mPrototype.mName = str;
        }

        public PrintDocumentInfo build() {
            if (this.mPrototype.mPageCount == 0) {
                this.mPrototype.mPageCount = -1;
            }
            return new PrintDocumentInfo();
        }

        public Builder setContentType(int i) {
            this.mPrototype.mContentType = i;
            return this;
        }

        public Builder setPageCount(int i) {
            if (i >= 0 || i == -1) {
                this.mPrototype.mPageCount = i;
                return this;
            }
            throw new IllegalArgumentException("pageCount must be greater than or equal to zero or DocumentInfo#PAGE_COUNT_UNKNOWN");
        }
    }

    private PrintDocumentInfo() {
    }

    private PrintDocumentInfo(Parcel parcel) {
        this.mName = parcel.readString();
        this.mPageCount = parcel.readInt();
        this.mContentType = parcel.readInt();
        this.mDataSize = parcel.readLong();
    }

    private PrintDocumentInfo(PrintDocumentInfo printDocumentInfo) {
        this.mName = printDocumentInfo.mName;
        this.mPageCount = printDocumentInfo.mPageCount;
        this.mContentType = printDocumentInfo.mContentType;
        this.mDataSize = printDocumentInfo.mDataSize;
    }

    private String contentTyepToString(int i) {
        switch (i) {
            case 0:
                return "CONTENT_TYPE_DOCUMENT";
            case 1:
                return "CONTENT_TYPE_PHOTO";
            default:
                return "CONTENT_TYPE_UNKNOWN";
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
            PrintDocumentInfo printDocumentInfo = (PrintDocumentInfo) obj;
            return TextUtils.equals(this.mName, printDocumentInfo.mName) && this.mContentType == printDocumentInfo.mContentType && this.mPageCount == printDocumentInfo.mPageCount && this.mDataSize == printDocumentInfo.mDataSize;
        }
        return false;
    }

    public int getContentType() {
        return this.mContentType;
    }

    public long getDataSize() {
        return this.mDataSize;
    }

    public String getName() {
        return this.mName;
    }

    public int getPageCount() {
        return this.mPageCount;
    }

    public int hashCode() {
        return ((((((((((this.mName != null ? this.mName.hashCode() : 0) + 31) * 31) + this.mContentType) * 31) + this.mPageCount) * 31) + ((int) this.mDataSize)) * 31) + ((int) this.mDataSize)) >> 32;
    }

    public void setDataSize(long j) {
        this.mDataSize = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PrintDocumentInfo{");
        sb.append("name=").append(this.mName);
        sb.append(", pageCount=").append(this.mPageCount);
        sb.append(", contentType=").append(contentTyepToString(this.mContentType));
        sb.append(", dataSize=").append(this.mDataSize);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeInt(this.mPageCount);
        parcel.writeInt(this.mContentType);
        parcel.writeLong(this.mDataSize);
    }
}
