package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/offlinemap/City.class */
public class City implements Parcelable {
    public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() { // from class: com.amap.api.maps.offlinemap.City.1
        private static City a(Parcel parcel) {
            return new City(parcel);
        }

        private static City[] a(int i) {
            return new City[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ City createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ City[] newArray(int i) {
            return a(i);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5549a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f5550c;
    private String d;
    private String e;

    public City() {
        this.f5549a = "";
        this.b = "";
        this.e = "";
    }

    public City(Parcel parcel) {
        this.f5549a = "";
        this.b = "";
        this.e = "";
        this.f5549a = parcel.readString();
        this.b = parcel.readString();
        this.f5550c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.e;
    }

    public String getCity() {
        return this.f5549a;
    }

    public String getCode() {
        return this.b;
    }

    public String getJianpin() {
        return this.f5550c;
    }

    public String getPinyin() {
        return this.d;
    }

    public void setAdcode(String str) {
        this.e = str;
    }

    public void setCity(String str) {
        this.f5549a = str;
    }

    public void setCode(String str) {
        if (str == null || "[]".equals(str)) {
            return;
        }
        this.b = str;
    }

    public void setJianpin(String str) {
        this.f5550c = str;
    }

    public void setPinyin(String str) {
        this.d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5549a);
        parcel.writeString(this.b);
        parcel.writeString(this.f5550c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }
}
