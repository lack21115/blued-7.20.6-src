package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/geocoder/StreetNumber.class */
public final class StreetNumber implements Parcelable {
    public static final Parcelable.Creator<StreetNumber> CREATOR = new Parcelable.Creator<StreetNumber>() { // from class: com.amap.api.services.geocoder.StreetNumber.1
        private static StreetNumber a(Parcel parcel) {
            return new StreetNumber(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StreetNumber createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StreetNumber[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5642a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f5643c;
    private String d;
    private float e;

    public StreetNumber() {
    }

    private StreetNumber(Parcel parcel) {
        this.f5642a = parcel.readString();
        this.b = parcel.readString();
        this.f5643c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.d = parcel.readString();
        this.e = parcel.readFloat();
    }

    /* synthetic */ StreetNumber(Parcel parcel, byte b) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getDirection() {
        return this.d;
    }

    public final float getDistance() {
        return this.e;
    }

    public final LatLonPoint getLatLonPoint() {
        return this.f5643c;
    }

    public final String getNumber() {
        return this.b;
    }

    public final String getStreet() {
        return this.f5642a;
    }

    public final void setDirection(String str) {
        this.d = str;
    }

    public final void setDistance(float f) {
        this.e = f;
    }

    public final void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f5643c = latLonPoint;
    }

    public final void setNumber(String str) {
        this.b = str;
    }

    public final void setStreet(String str) {
        this.f5642a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5642a);
        parcel.writeString(this.b);
        parcel.writeValue(this.f5643c);
        parcel.writeString(this.d);
        parcel.writeFloat(this.e);
    }
}
