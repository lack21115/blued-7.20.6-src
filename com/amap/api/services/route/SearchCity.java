package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/SearchCity.class */
public class SearchCity implements Parcelable {
    public static final Parcelable.Creator<SearchCity> CREATOR = new Parcelable.Creator<SearchCity>() { // from class: com.amap.api.services.route.SearchCity.1
        private static SearchCity a(Parcel parcel) {
            return new SearchCity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SearchCity createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SearchCity[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5764a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f5765c;

    public SearchCity() {
    }

    public SearchCity(Parcel parcel) {
        this.f5764a = parcel.readString();
        this.b = parcel.readString();
        this.f5765c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSearchCityAdCode() {
        return this.f5765c;
    }

    public String getSearchCityName() {
        return this.f5764a;
    }

    public String getSearchCitycode() {
        return this.b;
    }

    public void setSearchCityName(String str) {
        this.f5764a = str;
    }

    public void setSearchCitycode(String str) {
        this.b = str;
    }

    public void setSearchCityhAdCode(String str) {
        this.f5765c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5764a);
        parcel.writeString(this.b);
        parcel.writeString(this.f5765c);
    }
}
