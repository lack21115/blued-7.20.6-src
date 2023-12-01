package com.android.internal.statusbar;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.PrintWriter;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/statusbar/StatusBarIconList.class */
public class StatusBarIconList implements Parcelable {
    public static final Parcelable.Creator<StatusBarIconList> CREATOR = new Parcelable.Creator<StatusBarIconList>() { // from class: com.android.internal.statusbar.StatusBarIconList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StatusBarIconList createFromParcel(Parcel parcel) {
            return new StatusBarIconList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StatusBarIconList[] newArray(int i) {
            return new StatusBarIconList[i];
        }
    };
    private StatusBarIcon[] mIcons;
    private String[] mSlots;

    public StatusBarIconList() {
    }

    public StatusBarIconList(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void copyFrom(StatusBarIconList statusBarIconList) {
        if (statusBarIconList.mSlots == null) {
            this.mSlots = null;
            this.mIcons = null;
            return;
        }
        int length = statusBarIconList.mSlots.length;
        this.mSlots = new String[length];
        this.mIcons = new StatusBarIcon[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.mSlots[i2] = statusBarIconList.mSlots[i2];
            this.mIcons[i2] = statusBarIconList.mIcons[i2] != null ? statusBarIconList.mIcons[i2].m2596clone() : null;
            i = i2 + 1;
        }
    }

    public void defineSlots(String[] strArr) {
        int length = strArr.length;
        String[] strArr2 = new String[length];
        this.mSlots = strArr2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.mIcons = new StatusBarIcon[length];
                return;
            } else {
                strArr2[i2] = strArr[i2];
                i = i2 + 1;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dump(PrintWriter printWriter) {
        int length = this.mSlots.length;
        printWriter.println("Icon list:");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            printWriter.printf("  %2d: (%s) %s\n", Integer.valueOf(i2), this.mSlots[i2], this.mIcons[i2]);
            i = i2 + 1;
        }
    }

    public StatusBarIcon getIcon(int i) {
        return this.mIcons[i];
    }

    public String getSlot(int i) {
        return this.mSlots[i];
    }

    public int getSlotIndex(String str) {
        int length = this.mSlots.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return -1;
            }
            if (str.equals(this.mSlots[i2])) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public int getViewIndex(int i) {
        int i2 = 0;
        int i3 = 0;
        while (i3 < i) {
            int i4 = i2;
            if (this.mIcons[i3] != null) {
                i4 = i2 + 1;
            }
            i3++;
            i2 = i4;
        }
        return i2;
    }

    public void readFromParcel(Parcel parcel) {
        this.mSlots = parcel.readStringArray();
        int readInt = parcel.readInt();
        if (readInt < 0) {
            this.mIcons = null;
            return;
        }
        this.mIcons = new StatusBarIcon[readInt];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            if (parcel.readInt() != 0) {
                this.mIcons[i2] = new StatusBarIcon(parcel);
            }
            i = i2 + 1;
        }
    }

    public void removeIcon(int i) {
        this.mIcons[i] = null;
    }

    public void setIcon(int i, StatusBarIcon statusBarIcon) {
        this.mIcons[i] = statusBarIcon.m2596clone();
    }

    public int size() {
        return this.mSlots.length;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(this.mSlots);
        if (this.mIcons == null) {
            parcel.writeInt(-1);
            return;
        }
        int length = this.mIcons.length;
        parcel.writeInt(length);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            StatusBarIcon statusBarIcon = this.mIcons[i3];
            if (statusBarIcon == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                statusBarIcon.writeToParcel(parcel, i);
            }
            i2 = i3 + 1;
        }
    }
}
