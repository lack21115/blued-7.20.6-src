package android.content;

import android.os.Parcel;
import android.os.Parcelable;
import com.blued.das.live.LiveProtos;

/* loaded from: source-9557208-dex2jar.jar:android/content/RestrictionEntry.class */
public class RestrictionEntry implements Parcelable {
    public static final Parcelable.Creator<RestrictionEntry> CREATOR = new Parcelable.Creator<RestrictionEntry>() { // from class: android.content.RestrictionEntry.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RestrictionEntry createFromParcel(Parcel parcel) {
            return new RestrictionEntry(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RestrictionEntry[] newArray(int i) {
            return new RestrictionEntry[i];
        }
    };
    public static final int TYPE_BOOLEAN = 1;
    public static final int TYPE_CHOICE = 2;
    public static final int TYPE_CHOICE_LEVEL = 3;
    public static final int TYPE_INTEGER = 5;
    public static final int TYPE_MULTI_SELECT = 4;
    public static final int TYPE_NULL = 0;
    public static final int TYPE_STRING = 6;
    private String[] mChoiceEntries;
    private String[] mChoiceValues;
    private String mCurrentValue;
    private String[] mCurrentValues;
    private String mDescription;
    private String mKey;
    private String mTitle;
    private int mType;

    public RestrictionEntry(int i, String str) {
        this.mType = i;
        this.mKey = str;
    }

    public RestrictionEntry(Parcel parcel) {
        this.mType = parcel.readInt();
        this.mKey = parcel.readString();
        this.mTitle = parcel.readString();
        this.mDescription = parcel.readString();
        this.mChoiceEntries = readArray(parcel);
        this.mChoiceValues = readArray(parcel);
        this.mCurrentValue = parcel.readString();
        this.mCurrentValues = readArray(parcel);
    }

    public RestrictionEntry(String str, int i) {
        this.mKey = str;
        this.mType = 5;
        setIntValue(i);
    }

    public RestrictionEntry(String str, String str2) {
        this.mKey = str;
        this.mType = 2;
        this.mCurrentValue = str2;
    }

    public RestrictionEntry(String str, boolean z) {
        this.mKey = str;
        this.mType = 1;
        setSelectedState(z);
    }

    public RestrictionEntry(String str, String[] strArr) {
        this.mKey = str;
        this.mType = 4;
        this.mCurrentValues = strArr;
    }

    private boolean equalArrays(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return true;
            }
            if (!strArr[i2].equals(strArr2[i2])) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private String[] readArray(Parcel parcel) {
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return strArr;
            }
            strArr[i2] = parcel.readString();
            i = i2 + 1;
        }
    }

    private void writeArray(Parcel parcel, String[] strArr) {
        if (strArr == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(strArr.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            parcel.writeString(strArr[i2]);
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RestrictionEntry) {
            RestrictionEntry restrictionEntry = (RestrictionEntry) obj;
            if (this.mType == restrictionEntry.mType && this.mKey.equals(restrictionEntry.mKey)) {
                if (this.mCurrentValues == null && restrictionEntry.mCurrentValues == null && this.mCurrentValue != null && this.mCurrentValue.equals(restrictionEntry.mCurrentValue)) {
                    return true;
                }
                return this.mCurrentValue == null && restrictionEntry.mCurrentValue == null && this.mCurrentValues != null && equalArrays(this.mCurrentValues, restrictionEntry.mCurrentValues);
            }
            return false;
        }
        return false;
    }

    public String[] getAllSelectedStrings() {
        return this.mCurrentValues;
    }

    public String[] getChoiceEntries() {
        return this.mChoiceEntries;
    }

    public String[] getChoiceValues() {
        return this.mChoiceValues;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getIntValue() {
        return Integer.parseInt(this.mCurrentValue);
    }

    public String getKey() {
        return this.mKey;
    }

    public boolean getSelectedState() {
        return Boolean.parseBoolean(this.mCurrentValue);
    }

    public String getSelectedString() {
        return this.mCurrentValue;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getType() {
        return this.mType;
    }

    public int hashCode() {
        int i;
        int hashCode = this.mKey.hashCode() + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE;
        if (this.mCurrentValue != null) {
            i = (hashCode * 31) + this.mCurrentValue.hashCode();
        } else {
            i = hashCode;
            if (this.mCurrentValues != null) {
                String[] strArr = this.mCurrentValues;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    i = hashCode;
                    if (i2 >= length) {
                        break;
                    }
                    String str = strArr[i2];
                    int i3 = hashCode;
                    if (str != null) {
                        i3 = (hashCode * 31) + str.hashCode();
                    }
                    i2++;
                    hashCode = i3;
                }
            }
        }
        return i;
    }

    public void setAllSelectedStrings(String[] strArr) {
        this.mCurrentValues = strArr;
    }

    public void setChoiceEntries(Context context, int i) {
        this.mChoiceEntries = context.getResources().getStringArray(i);
    }

    public void setChoiceEntries(String[] strArr) {
        this.mChoiceEntries = strArr;
    }

    public void setChoiceValues(Context context, int i) {
        this.mChoiceValues = context.getResources().getStringArray(i);
    }

    public void setChoiceValues(String[] strArr) {
        this.mChoiceValues = strArr;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setIntValue(int i) {
        this.mCurrentValue = Integer.toString(i);
    }

    public void setSelectedState(boolean z) {
        this.mCurrentValue = Boolean.toString(z);
    }

    public void setSelectedString(String str) {
        this.mCurrentValue = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public String toString() {
        return "RestrictionsEntry {type=" + this.mType + ", key=" + this.mKey + ", value=" + this.mCurrentValue + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mType);
        parcel.writeString(this.mKey);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mDescription);
        writeArray(parcel, this.mChoiceEntries);
        writeArray(parcel, this.mChoiceValues);
        parcel.writeString(this.mCurrentValue);
        writeArray(parcel, this.mCurrentValues);
    }
}
