package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/core/LatLonSharePoint.class */
public class LatLonSharePoint extends LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonSharePoint> CREATOR = new Parcelable.Creator<LatLonSharePoint>() { // from class: com.amap.api.services.core.LatLonSharePoint.1
        private static LatLonSharePoint a(Parcel parcel) {
            return new LatLonSharePoint(parcel);
        }

        private static LatLonSharePoint[] a(int i) {
            return new LatLonSharePoint[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonSharePoint createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonSharePoint[] newArray(int i) {
            return a(i);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5611a;

    public LatLonSharePoint(double d, double d2, String str) {
        super(d, d2);
        this.f5611a = str;
    }

    protected LatLonSharePoint(Parcel parcel) {
        super(parcel);
        this.f5611a = parcel.readString();
    }

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj) && getClass() == obj.getClass()) {
            LatLonSharePoint latLonSharePoint = (LatLonSharePoint) obj;
            String str = this.f5611a;
            return str == null ? latLonSharePoint.f5611a == null : str.equals(latLonSharePoint.f5611a);
        }
        return false;
    }

    public String getSharePointName() {
        return this.f5611a;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public int hashCode() {
        int hashCode = super.hashCode();
        String str = this.f5611a;
        return (hashCode * 31) + (str == null ? 0 : str.hashCode());
    }

    public void setSharePointName(String str) {
        this.f5611a = str;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public String toString() {
        return super.toString() + "," + this.f5611a;
    }

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f5611a);
    }
}
