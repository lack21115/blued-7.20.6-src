package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/data/MaterialFileData.class */
public class MaterialFileData extends a implements Parcelable {
    public static final Parcelable.Creator<MaterialFileData> CREATOR = new Parcelable.Creator<MaterialFileData>() { // from class: com.opos.mobad.model.data.MaterialFileData.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MaterialFileData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                MaterialFileData materialFileData = new MaterialFileData();
                materialFileData.a(parcel.readString());
                materialFileData.b(parcel.readString());
                return materialFileData;
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MaterialFileData[] newArray(int i) {
            return new MaterialFileData[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f12790a;
    private String b;

    public String a() {
        return this.f12790a;
    }

    public void a(String str) {
        this.f12790a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MaterialFileData{filePath='" + this.f12790a + "', md5='" + this.b + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12790a);
        parcel.writeString(this.b);
    }
}
