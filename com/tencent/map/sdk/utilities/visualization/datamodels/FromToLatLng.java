package com.tencent.map.sdk.utilities.visualization.datamodels;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/datamodels/FromToLatLng.class */
public class FromToLatLng implements Parcelable {
    public static final Parcelable.Creator<FromToLatLng> CREATOR = new a();
    private static final double DEFAULT_ARC = 45.0d;
    private double mArc;
    private LatLng mEndPoint;
    private LatLng mStartPoint;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/datamodels/FromToLatLng$a.class */
    public static final class a implements Parcelable.Creator<FromToLatLng> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FromToLatLng createFromParcel(Parcel parcel) {
            return new FromToLatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FromToLatLng[] newArray(int i) {
            return new FromToLatLng[i];
        }
    }

    public FromToLatLng(Parcel parcel) {
        this.mStartPoint = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.mEndPoint = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.mArc = parcel.readDouble();
    }

    public FromToLatLng(LatLng latLng, LatLng latLng2) {
        this(latLng, latLng2, DEFAULT_ARC);
    }

    private FromToLatLng(LatLng latLng, LatLng latLng2, double d) {
        setPoint(latLng, latLng2);
        setArc(d);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof FromToLatLng) {
            if (obj == this) {
                return true;
            }
            LatLng latLng = this.mStartPoint;
            if (latLng == null || this.mEndPoint == null) {
                FromToLatLng fromToLatLng = (FromToLatLng) obj;
                if (fromToLatLng.mStartPoint != null) {
                    return false;
                }
                if (this.mArc == fromToLatLng.mArc) {
                    z = true;
                }
                return z;
            }
            FromToLatLng fromToLatLng2 = (FromToLatLng) obj;
            boolean z2 = false;
            if (latLng.equals(fromToLatLng2.mStartPoint)) {
                z2 = false;
                if (this.mEndPoint.equals(fromToLatLng2.mEndPoint)) {
                    z2 = false;
                    if (this.mArc == fromToLatLng2.mArc) {
                        z2 = true;
                    }
                }
            }
            return z2;
        }
        return false;
    }

    public double getArc() {
        return this.mArc;
    }

    public LatLng getEndPoint() {
        return this.mEndPoint;
    }

    public LatLng getStartPoint() {
        return this.mStartPoint;
    }

    public int hashCode() {
        LatLng latLng = this.mStartPoint;
        return (latLng == null || this.mEndPoint == null) ? (int) (this.mArc * 1000000.0d) : latLng.hashCode() + this.mEndPoint.hashCode() + ((int) (this.mArc * 1000000.0d));
    }

    public void setArc(double d) {
        if (d <= 0.0d || d > 90.0d) {
            this.mArc = DEFAULT_ARC;
        } else {
            this.mArc = d;
        }
    }

    public void setPoint(LatLng latLng, LatLng latLng2) {
        this.mStartPoint = latLng;
        this.mEndPoint = latLng2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mStartPoint, i);
        parcel.writeParcelable(this.mEndPoint, i);
        parcel.writeDouble(this.mArc);
    }
}
