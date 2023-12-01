package android.content.pm;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/LabeledIntent.class */
public class LabeledIntent extends Intent {
    public static final Parcelable.Creator<LabeledIntent> CREATOR = new Parcelable.Creator<LabeledIntent>() { // from class: android.content.pm.LabeledIntent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LabeledIntent createFromParcel(Parcel parcel) {
            return new LabeledIntent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LabeledIntent[] newArray(int i) {
            return new LabeledIntent[i];
        }
    };
    private int mIcon;
    private int mLabelRes;
    private CharSequence mNonLocalizedLabel;
    private String mSourcePackage;

    public LabeledIntent(Intent intent, String str, int i, int i2) {
        super(intent);
        this.mSourcePackage = str;
        this.mLabelRes = i;
        this.mNonLocalizedLabel = null;
        this.mIcon = i2;
    }

    public LabeledIntent(Intent intent, String str, CharSequence charSequence, int i) {
        super(intent);
        this.mSourcePackage = str;
        this.mLabelRes = 0;
        this.mNonLocalizedLabel = charSequence;
        this.mIcon = i;
    }

    protected LabeledIntent(Parcel parcel) {
        readFromParcel(parcel);
    }

    public LabeledIntent(String str, int i, int i2) {
        this.mSourcePackage = str;
        this.mLabelRes = i;
        this.mNonLocalizedLabel = null;
        this.mIcon = i2;
    }

    public LabeledIntent(String str, CharSequence charSequence, int i) {
        this.mSourcePackage = str;
        this.mLabelRes = 0;
        this.mNonLocalizedLabel = charSequence;
        this.mIcon = i;
    }

    public int getIconResource() {
        return this.mIcon;
    }

    public int getLabelResource() {
        return this.mLabelRes;
    }

    public CharSequence getNonLocalizedLabel() {
        return this.mNonLocalizedLabel;
    }

    public String getSourcePackage() {
        return this.mSourcePackage;
    }

    public Drawable loadIcon(PackageManager packageManager) {
        Drawable drawable;
        if (this.mIcon == 0 || this.mSourcePackage == null || (drawable = packageManager.getDrawable(this.mSourcePackage, this.mIcon, null)) == null) {
            return null;
        }
        return drawable;
    }

    public CharSequence loadLabel(PackageManager packageManager) {
        CharSequence charSequence;
        if (this.mNonLocalizedLabel != null) {
            charSequence = this.mNonLocalizedLabel;
        } else if (this.mLabelRes == 0 || this.mSourcePackage == null) {
            return null;
        } else {
            CharSequence text = packageManager.getText(this.mSourcePackage, this.mLabelRes, null);
            charSequence = text;
            if (text == null) {
                return null;
            }
        }
        return charSequence;
    }

    @Override // android.content.Intent
    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.mSourcePackage = parcel.readString();
        this.mLabelRes = parcel.readInt();
        this.mNonLocalizedLabel = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mIcon = parcel.readInt();
    }

    @Override // android.content.Intent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mSourcePackage);
        parcel.writeInt(this.mLabelRes);
        TextUtils.writeToParcel(this.mNonLocalizedLabel, parcel, i);
        parcel.writeInt(this.mIcon);
    }
}
