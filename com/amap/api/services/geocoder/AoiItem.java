package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/geocoder/AoiItem.class */
public class AoiItem implements Parcelable {
    public static final Parcelable.Creator<AoiItem> CREATOR = new Parcelable.Creator<AoiItem>() { // from class: com.amap.api.services.geocoder.AoiItem.1
        private static AoiItem a(Parcel parcel) {
            return new AoiItem(parcel);
        }

        private static AoiItem[] a(int i) {
            return new AoiItem[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AoiItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AoiItem[] newArray(int i) {
            return a(i);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5626a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f5627c;
    private LatLonPoint d;
    private Float e;

    public AoiItem() {
    }

    public AoiItem(Parcel parcel) {
        this.f5626a = parcel.readString();
        this.b = parcel.readString();
        this.f5627c = parcel.readString();
        this.d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.e = Float.valueOf(parcel.readFloat());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f5627c;
    }

    public Float getAoiArea() {
        return this.e;
    }

    public LatLonPoint getAoiCenterPoint() {
        return this.d;
    }

    public String getAoiId() {
        return this.f5626a;
    }

    public String getAoiName() {
        return this.b;
    }

    public void setAdcode(String str) {
        this.f5627c = str;
    }

    public void setArea(Float f) {
        this.e = f;
    }

    public void setId(String str) {
        this.f5626a = str;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.d = latLonPoint;
    }

    public void setName(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5626a);
        parcel.writeString(this.b);
        parcel.writeString(this.f5627c);
        parcel.writeParcelable(this.d, i);
        parcel.writeFloat(this.e.floatValue());
    }
}
