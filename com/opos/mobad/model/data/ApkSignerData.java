package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/data/ApkSignerData.class */
public class ApkSignerData extends a implements Parcelable {
    public static final Parcelable.Creator<ApkSignerData> CREATOR = new Parcelable.Creator<ApkSignerData>() { // from class: com.opos.mobad.model.data.ApkSignerData.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ApkSignerData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            return new ApkSignerData(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ApkSignerData[] newArray(int i) {
            return new ApkSignerData[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f12776a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f12777c;

    public ApkSignerData(String str, String str2, String str3) {
        this.f12776a = str;
        this.b = str2;
        this.f12777c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ApkSignerData{md5=" + this.f12776a + ", sha1='" + this.b + "', sha256=" + this.f12777c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12776a);
        parcel.writeString(this.b);
        parcel.writeString(this.f12777c);
    }
}
