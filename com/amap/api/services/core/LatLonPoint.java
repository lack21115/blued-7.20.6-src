package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/core/LatLonPoint.class */
public class LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonPoint> CREATOR = new Parcelable.Creator<LatLonPoint>() { // from class: com.amap.api.services.core.LatLonPoint.1
        private static LatLonPoint a(Parcel parcel) {
            return new LatLonPoint(parcel);
        }

        private static LatLonPoint[] a(int i) {
            return new LatLonPoint[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonPoint createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonPoint[] newArray(int i) {
            return a(i);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private double f5610a;
    private double b;

    public LatLonPoint(double d, double d2) {
        this.f5610a = d;
        this.b = d2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LatLonPoint(Parcel parcel) {
        this.f5610a = parcel.readDouble();
        this.b = parcel.readDouble();
    }

    public LatLonPoint copy() {
        return new LatLonPoint(this.f5610a, this.b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            LatLonPoint latLonPoint = (LatLonPoint) obj;
            return Double.doubleToLongBits(this.f5610a) == Double.doubleToLongBits(latLonPoint.f5610a) && Double.doubleToLongBits(this.b) == Double.doubleToLongBits(latLonPoint.b);
        }
        return false;
    }

    public double getLatitude() {
        return this.f5610a;
    }

    public double getLongitude() {
        return this.b;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f5610a);
        int i = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        long doubleToLongBits2 = Double.doubleToLongBits(this.b);
        return ((i + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public void setLatitude(double d) {
        this.f5610a = d;
    }

    public void setLongitude(double d) {
        this.b = d;
    }

    public String toString() {
        return this.f5610a + "," + this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f5610a);
        parcel.writeDouble(this.b);
    }
}