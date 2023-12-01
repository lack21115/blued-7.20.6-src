package android.content.pm;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/BaseThemeInfo.class */
public class BaseThemeInfo implements Parcelable {
    public static final Parcelable.Creator<BaseThemeInfo> CREATOR = new Parcelable.Creator<BaseThemeInfo>() { // from class: android.content.pm.BaseThemeInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BaseThemeInfo createFromParcel(Parcel parcel) {
            return new BaseThemeInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BaseThemeInfo[] newArray(int i) {
            return new BaseThemeInfo[i];
        }
    };
    public String author;
    public String name;
    public String themeId;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseThemeInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseThemeInfo(Parcel parcel) {
        this.themeId = parcel.readString();
        this.name = parcel.readString();
        this.author = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getResolvedString(Resources resources, AttributeSet attributeSet, int i) {
        int attributeResourceValue = attributeSet.getAttributeResourceValue(i, 0);
        return attributeResourceValue != 0 ? resources.getString(attributeResourceValue) : attributeSet.getAttributeValue(i);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.themeId);
        parcel.writeString(this.name);
        parcel.writeString(this.author);
    }
}
