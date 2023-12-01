package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/offlinemap/Province.class */
public class Province implements Parcelable {
    public static final Parcelable.Creator<Province> CREATOR = new Parcelable.Creator<Province>() { // from class: com.amap.api.maps.offlinemap.Province.1
        private static Province a(Parcel parcel) {
            return new Province(parcel);
        }

        private static Province[] a(int i) {
            return new Province[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Province createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Province[] newArray(int i) {
            return a(i);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5568a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f5569c;
    private String d;

    public Province() {
        this.f5568a = "";
        this.d = "";
    }

    public Province(Parcel parcel) {
        this.f5568a = "";
        this.d = "";
        this.f5568a = parcel.readString();
        this.b = parcel.readString();
        this.f5569c = parcel.readString();
        this.d = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getJianpin() {
        return this.b;
    }

    public String getPinyin() {
        return this.f5569c;
    }

    public String getProvinceCode() {
        return this.d;
    }

    public String getProvinceName() {
        return this.f5568a;
    }

    public void setJianpin(String str) {
        this.b = str;
    }

    public void setPinyin(String str) {
        this.f5569c = str;
    }

    public void setProvinceCode(String str) {
        this.d = str;
    }

    public void setProvinceName(String str) {
        this.f5568a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5568a);
        parcel.writeString(this.b);
        parcel.writeString(this.f5569c);
        parcel.writeString(this.d);
    }
}
