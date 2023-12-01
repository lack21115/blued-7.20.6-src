package com.android.internal.statusbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.UserHandle;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/statusbar/StatusBarIcon.class */
public class StatusBarIcon implements Parcelable {
    public static final Parcelable.Creator<StatusBarIcon> CREATOR = new Parcelable.Creator<StatusBarIcon>() { // from class: com.android.internal.statusbar.StatusBarIcon.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StatusBarIcon createFromParcel(Parcel parcel) {
            return new StatusBarIcon(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StatusBarIcon[] newArray(int i) {
            return new StatusBarIcon[i];
        }
    };
    public CharSequence contentDescription;
    public int iconId;
    public int iconLevel;
    public String iconPackage;
    public int number;
    public UserHandle user;
    public boolean visible = true;

    public StatusBarIcon(Parcel parcel) {
        readFromParcel(parcel);
    }

    public StatusBarIcon(String str, UserHandle userHandle, int i, int i2, int i3, CharSequence charSequence) {
        this.iconPackage = str;
        this.user = userHandle;
        this.iconId = i;
        this.iconLevel = i2;
        this.number = i3;
        this.contentDescription = charSequence;
    }

    /* renamed from: clone */
    public StatusBarIcon m9043clone() {
        StatusBarIcon statusBarIcon = new StatusBarIcon(this.iconPackage, this.user, this.iconId, this.iconLevel, this.number, this.contentDescription);
        statusBarIcon.visible = this.visible;
        return statusBarIcon;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.iconPackage = parcel.readString();
        this.user = (UserHandle) parcel.readParcelable(null);
        this.iconId = parcel.readInt();
        this.iconLevel = parcel.readInt();
        this.visible = parcel.readInt() != 0;
        this.number = parcel.readInt();
        this.contentDescription = parcel.readCharSequence();
    }

    public String toString() {
        return "StatusBarIcon(pkg=" + this.iconPackage + "user=" + this.user.getIdentifier() + " id=0x" + Integer.toHexString(this.iconId) + " level=" + this.iconLevel + " visible=" + this.visible + " num=" + this.number + " )";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeString(this.iconPackage);
        parcel.writeParcelable(this.user, 0);
        parcel.writeInt(this.iconId);
        parcel.writeInt(this.iconLevel);
        if (this.visible) {
            i2 = 1;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.number);
        parcel.writeCharSequence(this.contentDescription);
    }
}
