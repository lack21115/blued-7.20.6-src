package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/data/ActivatingData.class */
public class ActivatingData extends a implements Parcelable {
    public static final Parcelable.Creator<ActivatingData> CREATOR = new Parcelable.Creator<ActivatingData>() { // from class: com.opos.mobad.model.data.ActivatingData.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ActivatingData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                return new ActivatingData(parcel.readString(), parcel.readString(), parcel.readArrayList(ApkSignerData.class.getClassLoader()), parcel.readInt());
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ActivatingData[] newArray(int i) {
            return new ActivatingData[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f26456a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final List<ApkSignerData> f26457c;
    public final int d;

    public ActivatingData(String str, String str2, List<ApkSignerData> list, int i) {
        this.f26456a = str;
        this.b = str2;
        this.f26457c = list;
        this.d = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivatingData{pkgName=" + this.f26456a + ", target='" + this.b + "', apkSignerDataList=" + this.f26457c + ", minVerCode=" + this.d + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f26456a);
        parcel.writeString(this.b);
        parcel.writeList(this.f26457c);
        parcel.writeInt(this.d);
    }
}
