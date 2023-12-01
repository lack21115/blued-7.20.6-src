package com.tencent.map.sdk.utilities.visualization.datamodels;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/datamodels/WeightedLatLng.class */
public class WeightedLatLng implements Parcelable {
    public static final Parcelable.Creator<WeightedLatLng> CREATOR = new a();
    private static final double DEFAULT_INTENSITY = 1.0d;
    private double mIntensity;
    private LatLng mPoint;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/datamodels/WeightedLatLng$a.class */
    public static final class a implements Parcelable.Creator<WeightedLatLng> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WeightedLatLng createFromParcel(Parcel parcel) {
            return new WeightedLatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WeightedLatLng[] newArray(int i) {
            return new WeightedLatLng[i];
        }
    }

    public WeightedLatLng(Parcel parcel) {
        this.mPoint = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.mIntensity = parcel.readDouble();
    }

    public WeightedLatLng(LatLng latLng) {
        this(latLng, 1.0d);
    }

    public WeightedLatLng(LatLng latLng, double d) {
        setPoint(latLng);
        setIntensity(d);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof WeightedLatLng) {
            if (obj == this) {
                return true;
            }
            LatLng latLng = this.mPoint;
            if (latLng == null) {
                WeightedLatLng weightedLatLng = (WeightedLatLng) obj;
                if (weightedLatLng.mPoint != null) {
                    return false;
                }
                if (this.mIntensity == weightedLatLng.mIntensity) {
                    z = true;
                }
                return z;
            }
            WeightedLatLng weightedLatLng2 = (WeightedLatLng) obj;
            boolean z2 = false;
            if (latLng.equals(weightedLatLng2.mPoint)) {
                z2 = false;
                if (this.mIntensity == weightedLatLng2.mIntensity) {
                    z2 = true;
                }
            }
            return z2;
        }
        return false;
    }

    public double getIntensity() {
        return this.mIntensity;
    }

    public LatLng getPoint() {
        return this.mPoint;
    }

    public int hashCode() {
        LatLng latLng = this.mPoint;
        return latLng != null ? latLng.hashCode() + ((int) (this.mIntensity * 1000000.0d)) : (int) (this.mIntensity * 1000000.0d);
    }

    public void setIntensity(double d) {
        if (d >= 0.0d) {
            this.mIntensity = d;
        } else {
            this.mIntensity = 1.0d;
        }
    }

    public void setPoint(LatLng latLng) {
        this.mPoint = latLng;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mPoint, i);
        parcel.writeDouble(this.mIntensity);
    }
}
