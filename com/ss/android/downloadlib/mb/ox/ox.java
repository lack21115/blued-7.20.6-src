package com.ss.android.downloadlib.mb.ox;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/mb/ox/ox.class */
public class ox implements Parcelable {
    public static final Parcelable.Creator<ox> CREATOR = new Parcelable.Creator<ox>() { // from class: com.ss.android.downloadlib.mb.ox.ox.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: mb */
        public ox createFromParcel(Parcel parcel) {
            return new ox(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: mb */
        public ox[] newArray(int i) {
            return new ox[i];
        }
    };
    public String b;
    public String h;
    public int hj;
    public int mb;
    public int ox;
    public String u;

    public ox() {
        this.b = "";
        this.h = "";
        this.u = "";
    }

    protected ox(Parcel parcel) {
        this.b = "";
        this.h = "";
        this.u = "";
        this.mb = parcel.readInt();
        this.ox = parcel.readInt();
        this.b = parcel.readString();
        this.h = parcel.readString();
        this.u = parcel.readString();
        this.hj = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ox oxVar = (ox) obj;
        if (this.mb == oxVar.mb && this.ox == oxVar.ox) {
            String str = this.b;
            return str != null ? str.equals(oxVar.b) : oxVar.b == null;
        }
        return false;
    }

    public int hashCode() {
        int i = this.mb;
        int i2 = this.ox;
        String str = this.b;
        return (((i * 31) + i2) * 31) + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mb);
        parcel.writeInt(this.ox);
        parcel.writeString(this.b);
        parcel.writeString(this.h);
        parcel.writeString(this.u);
        parcel.writeInt(this.hj);
    }
}
