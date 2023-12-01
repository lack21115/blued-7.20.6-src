package android.telephony.cdma;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/cdma/CdmaSmsCbProgramData.class */
public class CdmaSmsCbProgramData implements Parcelable {
    public static final int ALERT_OPTION_DEFAULT_ALERT = 1;
    public static final int ALERT_OPTION_HIGH_PRIORITY_ONCE = 10;
    public static final int ALERT_OPTION_HIGH_PRIORITY_REPEAT = 11;
    public static final int ALERT_OPTION_LOW_PRIORITY_ONCE = 6;
    public static final int ALERT_OPTION_LOW_PRIORITY_REPEAT = 7;
    public static final int ALERT_OPTION_MED_PRIORITY_ONCE = 8;
    public static final int ALERT_OPTION_MED_PRIORITY_REPEAT = 9;
    public static final int ALERT_OPTION_NO_ALERT = 0;
    public static final int ALERT_OPTION_VIBRATE_ONCE = 2;
    public static final int ALERT_OPTION_VIBRATE_REPEAT = 3;
    public static final int ALERT_OPTION_VISUAL_ONCE = 4;
    public static final int ALERT_OPTION_VISUAL_REPEAT = 5;
    public static final Parcelable.Creator<CdmaSmsCbProgramData> CREATOR = new Parcelable.Creator<CdmaSmsCbProgramData>() { // from class: android.telephony.cdma.CdmaSmsCbProgramData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CdmaSmsCbProgramData createFromParcel(Parcel parcel) {
            return new CdmaSmsCbProgramData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CdmaSmsCbProgramData[] newArray(int i) {
            return new CdmaSmsCbProgramData[i];
        }
    };
    public static final int OPERATION_ADD_CATEGORY = 1;
    public static final int OPERATION_CLEAR_CATEGORIES = 2;
    public static final int OPERATION_DELETE_CATEGORY = 0;
    private final int mAlertOption;
    private final int mCategory;
    private final String mCategoryName;
    private final int mLanguage;
    private final int mMaxMessages;
    private final int mOperation;

    public CdmaSmsCbProgramData(int i, int i2, int i3, int i4, int i5, String str) {
        this.mOperation = i;
        this.mCategory = i2;
        this.mLanguage = i3;
        this.mMaxMessages = i4;
        this.mAlertOption = i5;
        this.mCategoryName = str;
    }

    CdmaSmsCbProgramData(Parcel parcel) {
        this.mOperation = parcel.readInt();
        this.mCategory = parcel.readInt();
        this.mLanguage = parcel.readInt();
        this.mMaxMessages = parcel.readInt();
        this.mAlertOption = parcel.readInt();
        this.mCategoryName = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAlertOption() {
        return this.mAlertOption;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public String getCategoryName() {
        return this.mCategoryName;
    }

    public int getLanguage() {
        return this.mLanguage;
    }

    public int getMaxMessages() {
        return this.mMaxMessages;
    }

    public int getOperation() {
        return this.mOperation;
    }

    public String toString() {
        return "CdmaSmsCbProgramData{operation=" + this.mOperation + ", category=" + this.mCategory + ", language=" + this.mLanguage + ", max messages=" + this.mMaxMessages + ", alert option=" + this.mAlertOption + ", category name=" + this.mCategoryName + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mOperation);
        parcel.writeInt(this.mCategory);
        parcel.writeInt(this.mLanguage);
        parcel.writeInt(this.mMaxMessages);
        parcel.writeInt(this.mAlertOption);
        parcel.writeString(this.mCategoryName);
    }
}
