package android.content.pm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/ThemeInfo.class */
public final class ThemeInfo extends BaseThemeInfo {
    public static final Parcelable.Creator<ThemeInfo> CREATOR = new Parcelable.Creator<ThemeInfo>() { // from class: android.content.pm.ThemeInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ThemeInfo createFromParcel(Parcel parcel) {
            return new ThemeInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ThemeInfo[] newArray(int i) {
            return new ThemeInfo[i];
        }
    };
    public static final String META_TAG_AUTHOR = "org.mokee.theme.author";
    public static final String META_TAG_AUTHOR_CM = "org.cyanogenmod.theme.author";
    public static final String META_TAG_NAME = "org.mokee.theme.name";
    public static final String META_TAG_NAME_CM = "org.cyanogenmod.theme.name";

    public ThemeInfo(Bundle bundle) {
        this.name = bundle.getString(META_TAG_NAME);
        if (TextUtils.isEmpty(this.name)) {
            this.name = bundle.getString(META_TAG_NAME_CM);
        }
        this.themeId = this.name;
        this.author = bundle.getString(META_TAG_AUTHOR);
        if (TextUtils.isEmpty(this.author)) {
            this.author = bundle.getString(META_TAG_AUTHOR_CM);
        }
    }

    private ThemeInfo(Parcel parcel) {
        super(parcel);
    }
}
