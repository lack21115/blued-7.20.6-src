package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/location/DPoint.class */
public class DPoint implements Parcelable {
    public static final Parcelable.Creator<DPoint> CREATOR = new Parcelable.Creator<DPoint>() { // from class: com.amap.api.location.DPoint.1
        private static DPoint a(Parcel parcel) {
            return new DPoint(parcel);
        }

        private static DPoint[] a(int i) {
            return new DPoint[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DPoint createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DPoint[] newArray(int i) {
            return a(i);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private double f5490a;
    private double b;

    public DPoint() {
        this.f5490a = 0.0d;
        this.b = 0.0d;
    }

    public DPoint(double d, double d2) {
        this.f5490a = 0.0d;
        this.b = 0.0d;
        double d3 = d2 > 180.0d ? 180.0d : d2;
        double d4 = d3 < -180.0d ? -180.0d : d3;
        double d5 = d > 90.0d ? 90.0d : d;
        double d6 = d5 < -90.0d ? -90.0d : d5;
        this.f5490a = d4;
        this.b = d6;
    }

    protected DPoint(Parcel parcel) {
        this.f5490a = 0.0d;
        this.b = 0.0d;
        this.f5490a = parcel.readDouble();
        this.b = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DPoint) {
            DPoint dPoint = (DPoint) obj;
            return this.b == dPoint.b && this.f5490a == dPoint.f5490a;
        }
        return false;
    }

    public double getLatitude() {
        return this.b;
    }

    public double getLongitude() {
        return this.f5490a;
    }

    public int hashCode() {
        return Double.valueOf((this.b + this.f5490a) * 1000000.0d).intValue();
    }

    public void setLatitude(double d) {
        double d2 = d;
        if (d > 90.0d) {
            d2 = 90.0d;
        }
        double d3 = d2;
        if (d2 < -90.0d) {
            d3 = -90.0d;
        }
        this.b = d3;
    }

    public void setLongitude(double d) {
        double d2 = d;
        if (d > 180.0d) {
            d2 = 180.0d;
        }
        double d3 = d2;
        if (d2 < -180.0d) {
            d3 = -180.0d;
        }
        this.f5490a = d3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f5490a);
        parcel.writeDouble(this.b);
    }
}
