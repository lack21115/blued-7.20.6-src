package android.print;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/print/PrintJobInfo.class */
public final class PrintJobInfo implements Parcelable {
    public static final Parcelable.Creator<PrintJobInfo> CREATOR = new Parcelable.Creator<PrintJobInfo>() { // from class: android.print.PrintJobInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrintJobInfo createFromParcel(Parcel parcel) {
            return new PrintJobInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrintJobInfo[] newArray(int i) {
            return new PrintJobInfo[i];
        }
    };
    public static final int STATE_ANY = -1;
    public static final int STATE_ANY_ACTIVE = -3;
    public static final int STATE_ANY_SCHEDULED = -4;
    public static final int STATE_ANY_VISIBLE_TO_CLIENTS = -2;
    public static final int STATE_BLOCKED = 4;
    public static final int STATE_CANCELED = 7;
    public static final int STATE_COMPLETED = 5;
    public static final int STATE_CREATED = 1;
    public static final int STATE_FAILED = 6;
    public static final int STATE_QUEUED = 2;
    public static final int STATE_STARTED = 3;
    private Bundle mAdvancedOptions;
    private int mAppId;
    private PrintAttributes mAttributes;
    private boolean mCanceling;
    private int mCopies;
    private long mCreationTime;
    private PrintDocumentInfo mDocumentInfo;
    private PrintJobId mId;
    private String mLabel;
    private PageRange[] mPageRanges;
    private PrinterId mPrinterId;
    private String mPrinterName;
    private int mState;
    private String mStateReason;
    private String mTag;

    /* loaded from: source-9557208-dex2jar.jar:android/print/PrintJobInfo$Builder.class */
    public static final class Builder {
        private final PrintJobInfo mPrototype;

        public Builder(PrintJobInfo printJobInfo) {
            this.mPrototype = printJobInfo != null ? new PrintJobInfo(printJobInfo) : new PrintJobInfo();
        }

        public PrintJobInfo build() {
            return this.mPrototype;
        }

        public void putAdvancedOption(String str, int i) {
            if (this.mPrototype.mAdvancedOptions == null) {
                this.mPrototype.mAdvancedOptions = new Bundle();
            }
            this.mPrototype.mAdvancedOptions.putInt(str, i);
        }

        public void putAdvancedOption(String str, String str2) {
            if (this.mPrototype.mAdvancedOptions == null) {
                this.mPrototype.mAdvancedOptions = new Bundle();
            }
            this.mPrototype.mAdvancedOptions.putString(str, str2);
        }

        public void setAttributes(PrintAttributes printAttributes) {
            this.mPrototype.mAttributes = printAttributes;
        }

        public void setCopies(int i) {
            this.mPrototype.mCopies = i;
        }

        public void setPages(PageRange[] pageRangeArr) {
            this.mPrototype.mPageRanges = pageRangeArr;
        }
    }

    public PrintJobInfo() {
    }

    private PrintJobInfo(Parcel parcel) {
        this.mId = (PrintJobId) parcel.readParcelable(null);
        this.mLabel = parcel.readString();
        this.mPrinterId = (PrinterId) parcel.readParcelable(null);
        this.mPrinterName = parcel.readString();
        this.mState = parcel.readInt();
        this.mAppId = parcel.readInt();
        this.mTag = parcel.readString();
        this.mCreationTime = parcel.readLong();
        this.mCopies = parcel.readInt();
        this.mStateReason = parcel.readString();
        Parcelable[] readParcelableArray = parcel.readParcelableArray(null);
        if (readParcelableArray != null) {
            this.mPageRanges = new PageRange[readParcelableArray.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readParcelableArray.length) {
                    break;
                }
                this.mPageRanges[i2] = (PageRange) readParcelableArray[i2];
                i = i2 + 1;
            }
        }
        this.mAttributes = (PrintAttributes) parcel.readParcelable(null);
        this.mDocumentInfo = (PrintDocumentInfo) parcel.readParcelable(null);
        this.mCanceling = parcel.readInt() == 1;
        this.mAdvancedOptions = parcel.readBundle();
    }

    public PrintJobInfo(PrintJobInfo printJobInfo) {
        this.mId = printJobInfo.mId;
        this.mLabel = printJobInfo.mLabel;
        this.mPrinterId = printJobInfo.mPrinterId;
        this.mPrinterName = printJobInfo.mPrinterName;
        this.mState = printJobInfo.mState;
        this.mAppId = printJobInfo.mAppId;
        this.mTag = printJobInfo.mTag;
        this.mCreationTime = printJobInfo.mCreationTime;
        this.mCopies = printJobInfo.mCopies;
        this.mStateReason = printJobInfo.mStateReason;
        this.mPageRanges = printJobInfo.mPageRanges;
        this.mAttributes = printJobInfo.mAttributes;
        this.mDocumentInfo = printJobInfo.mDocumentInfo;
        this.mCanceling = printJobInfo.mCanceling;
        this.mAdvancedOptions = printJobInfo.mAdvancedOptions;
    }

    public static String stateToString(int i) {
        switch (i) {
            case 1:
                return "STATE_CREATED";
            case 2:
                return "STATE_QUEUED";
            case 3:
                return "STATE_STARTED";
            case 4:
                return "STATE_BLOCKED";
            case 5:
                return "STATE_COMPLETED";
            case 6:
                return "STATE_FAILED";
            case 7:
                return "STATE_CANCELED";
            default:
                return "STATE_UNKNOWN";
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAdvancedIntOption(String str) {
        if (this.mAdvancedOptions != null) {
            return this.mAdvancedOptions.getInt(str);
        }
        return 0;
    }

    public Bundle getAdvancedOptions() {
        return this.mAdvancedOptions;
    }

    public String getAdvancedStringOption(String str) {
        if (this.mAdvancedOptions != null) {
            return this.mAdvancedOptions.getString(str);
        }
        return null;
    }

    public int getAppId() {
        return this.mAppId;
    }

    public PrintAttributes getAttributes() {
        return this.mAttributes;
    }

    public int getCopies() {
        return this.mCopies;
    }

    public long getCreationTime() {
        return this.mCreationTime;
    }

    public PrintDocumentInfo getDocumentInfo() {
        return this.mDocumentInfo;
    }

    public PrintJobId getId() {
        return this.mId;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public PageRange[] getPages() {
        return this.mPageRanges;
    }

    public PrinterId getPrinterId() {
        return this.mPrinterId;
    }

    public String getPrinterName() {
        return this.mPrinterName;
    }

    public int getState() {
        return this.mState;
    }

    public String getStateReason() {
        return this.mStateReason;
    }

    public String getTag() {
        return this.mTag;
    }

    public boolean hasAdvancedOption(String str) {
        return this.mAdvancedOptions != null && this.mAdvancedOptions.containsKey(str);
    }

    public boolean isCancelling() {
        return this.mCanceling;
    }

    public void setAdvancedOptions(Bundle bundle) {
        this.mAdvancedOptions = bundle;
    }

    public void setAppId(int i) {
        this.mAppId = i;
    }

    public void setAttributes(PrintAttributes printAttributes) {
        this.mAttributes = printAttributes;
    }

    public void setCancelling(boolean z) {
        this.mCanceling = z;
    }

    public void setCopies(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Copies must be more than one.");
        }
        this.mCopies = i;
    }

    public void setCreationTime(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("creationTime must be non-negative.");
        }
        this.mCreationTime = j;
    }

    public void setDocumentInfo(PrintDocumentInfo printDocumentInfo) {
        this.mDocumentInfo = printDocumentInfo;
    }

    public void setId(PrintJobId printJobId) {
        this.mId = printJobId;
    }

    public void setLabel(String str) {
        this.mLabel = str;
    }

    public void setPages(PageRange[] pageRangeArr) {
        this.mPageRanges = pageRangeArr;
    }

    public void setPrinterId(PrinterId printerId) {
        this.mPrinterId = printerId;
    }

    public void setPrinterName(String str) {
        this.mPrinterName = str;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public void setStateReason(String str) {
        this.mStateReason = str;
    }

    public void setTag(String str) {
        this.mTag = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PrintJobInfo{");
        sb.append("label: ").append(this.mLabel);
        sb.append(", id: ").append(this.mId);
        sb.append(", state: ").append(stateToString(this.mState));
        sb.append(", printer: " + this.mPrinterId);
        sb.append(", tag: ").append(this.mTag);
        sb.append(", creationTime: " + this.mCreationTime);
        sb.append(", copies: ").append(this.mCopies);
        sb.append(", attributes: " + (this.mAttributes != null ? this.mAttributes.toString() : null));
        sb.append(", documentInfo: " + (this.mDocumentInfo != null ? this.mDocumentInfo.toString() : null));
        sb.append(", cancelling: " + this.mCanceling);
        StringBuilder append = new StringBuilder().append(", pages: ");
        String str = null;
        if (this.mPageRanges != null) {
            str = Arrays.toString(this.mPageRanges);
        }
        sb.append(append.append(str).toString());
        sb.append(", hasAdvancedOptions: " + (this.mAdvancedOptions != null));
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mId, i);
        parcel.writeString(this.mLabel);
        parcel.writeParcelable(this.mPrinterId, i);
        parcel.writeString(this.mPrinterName);
        parcel.writeInt(this.mState);
        parcel.writeInt(this.mAppId);
        parcel.writeString(this.mTag);
        parcel.writeLong(this.mCreationTime);
        parcel.writeInt(this.mCopies);
        parcel.writeString(this.mStateReason);
        parcel.writeParcelableArray(this.mPageRanges, i);
        parcel.writeParcelable(this.mAttributes, i);
        parcel.writeParcelable(this.mDocumentInfo, 0);
        int i2 = 0;
        if (this.mCanceling) {
            i2 = 1;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.mAdvancedOptions);
    }
}
