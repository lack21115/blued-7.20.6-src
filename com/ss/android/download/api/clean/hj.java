package com.ss.android.download.api.clean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/clean/hj.class */
public class hj extends ox implements Parcelable {
    public static final Parcelable.Creator<hj> CREATOR = new Parcelable.Creator<hj>() { // from class: com.ss.android.download.api.clean.hj.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: mb */
        public hj createFromParcel(Parcel parcel) {
            return new hj(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: mb */
        public hj[] newArray(int i) {
            return new hj[i];
        }
    };
    private String h;

    public hj() {
    }

    hj(Parcel parcel) {
        this.h = parcel.readString();
    }

    @Override // com.ss.android.download.api.clean.ox, com.ss.android.download.api.clean.u, com.ss.android.download.api.clean.h, com.ss.android.download.api.clean.b, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ss.android.download.api.clean.u, com.ss.android.download.api.clean.h
    public String mb() {
        return "clean_app_cache";
    }

    @Override // com.ss.android.download.api.clean.ox, com.ss.android.download.api.clean.u, com.ss.android.download.api.clean.h, com.ss.android.download.api.clean.b, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.h);
    }
}
