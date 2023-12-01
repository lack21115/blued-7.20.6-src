package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/District.class */
public class District implements Parcelable {
    public static final Parcelable.Creator<District> CREATOR = new Parcelable.Creator<District>() { // from class: com.amap.api.services.route.District.1
        private static District a(Parcel parcel) {
            return new District(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ District createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ District[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5692a;
    private String b;

    public District() {
    }

    public District(Parcel parcel) {
        this.f5692a = parcel.readString();
        this.b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDistrictAdcode() {
        return this.b;
    }

    public String getDistrictName() {
        return this.f5692a;
    }

    public void setDistrictAdcode(String str) {
        this.b = str;
    }

    public void setDistrictName(String str) {
        this.f5692a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5692a);
        parcel.writeString(this.b);
    }
}
