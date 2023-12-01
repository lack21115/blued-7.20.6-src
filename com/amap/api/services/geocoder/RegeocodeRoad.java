package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/geocoder/RegeocodeRoad.class */
public final class RegeocodeRoad implements Parcelable {
    public static final Parcelable.Creator<RegeocodeRoad> CREATOR = new Parcelable.Creator<RegeocodeRoad>() { // from class: com.amap.api.services.geocoder.RegeocodeRoad.1
        private static RegeocodeRoad a(Parcel parcel) {
            return new RegeocodeRoad(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RegeocodeRoad createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RegeocodeRoad[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5640a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private float f5641c;
    private String d;
    private LatLonPoint e;

    public RegeocodeRoad() {
    }

    private RegeocodeRoad(Parcel parcel) {
        this.f5640a = parcel.readString();
        this.b = parcel.readString();
        this.f5641c = parcel.readFloat();
        this.d = parcel.readString();
        this.e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }

    /* synthetic */ RegeocodeRoad(Parcel parcel, byte b) {
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
        return this.f5641c;
    }

    public final String getId() {
        return this.f5640a;
    }

    public final LatLonPoint getLatLngPoint() {
        return this.e;
    }

    public final String getName() {
        return this.b;
    }

    public final void setDirection(String str) {
        this.d = str;
    }

    public final void setDistance(float f) {
        this.f5641c = f;
    }

    public final void setId(String str) {
        this.f5640a = str;
    }

    public final void setLatLngPoint(LatLonPoint latLonPoint) {
        this.e = latLonPoint;
    }

    public final void setName(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5640a);
        parcel.writeString(this.b);
        parcel.writeFloat(this.f5641c);
        parcel.writeString(this.d);
        parcel.writeValue(this.e);
    }
}
