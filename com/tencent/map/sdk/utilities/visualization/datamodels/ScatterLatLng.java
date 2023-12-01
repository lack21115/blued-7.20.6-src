package com.tencent.map.sdk.utilities.visualization.datamodels;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/datamodels/ScatterLatLng.class */
public class ScatterLatLng implements Parcelable {
    public static final Parcelable.Creator<ScatterLatLng> CREATOR = new a();
    private static final double DEFAULT_INTENSITY = 1.0d;
    private static final int DEFAULT_TYPE = 0;
    private double mIntensity;
    private LatLng mPoint;
    private int mType;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/datamodels/ScatterLatLng$a.class */
    public static final class a implements Parcelable.Creator<ScatterLatLng> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ScatterLatLng createFromParcel(Parcel parcel) {
            return new ScatterLatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ScatterLatLng[] newArray(int i) {
            return new ScatterLatLng[i];
        }
    }

    public ScatterLatLng(Parcel parcel) {
        this.mPoint = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.mType = parcel.readInt();
        this.mIntensity = parcel.readDouble();
    }

    public ScatterLatLng(LatLng latLng) {
        this(latLng, 0, 1.0d);
    }

    public ScatterLatLng(LatLng latLng, double d) {
        setPoint(latLng);
        setType(0);
        setIntensity(d);
    }

    public ScatterLatLng(LatLng latLng, int i) {
        setPoint(latLng);
        setType(i);
        setIntensity(1.0d);
    }

    public ScatterLatLng(LatLng latLng, int i, double d) {
        setPoint(latLng);
        setType(i);
        setIntensity(d);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ScatterLatLng) {
            if (obj == this) {
                return true;
            }
            LatLng latLng = this.mPoint;
            if (latLng != null) {
                ScatterLatLng scatterLatLng = (ScatterLatLng) obj;
                boolean z = false;
                if (latLng.equals(scatterLatLng.mPoint)) {
                    z = false;
                    if (this.mType == scatterLatLng.mType) {
                        z = false;
                        if (this.mIntensity == scatterLatLng.mIntensity) {
                            z = true;
                        }
                    }
                }
                return z;
            }
            ScatterLatLng scatterLatLng2 = (ScatterLatLng) obj;
            if (scatterLatLng2.mPoint != null) {
                return false;
            }
            boolean z2 = false;
            if (this.mType == scatterLatLng2.mType) {
                z2 = false;
                if (this.mIntensity == scatterLatLng2.mIntensity) {
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

    public int getType() {
        return this.mType;
    }

    public int hashCode() {
        int i;
        double d;
        LatLng latLng = this.mPoint;
        if (latLng != null) {
            i = latLng.hashCode() + ((int) (this.mType * 1000000.0d));
            d = this.mIntensity;
        } else {
            i = (int) (this.mType * 1000000.0d);
            d = this.mIntensity;
        }
        return i + ((int) (d * 1000000.0d));
    }

    public void setIntensity(double d) {
        this.mIntensity = d;
    }

    public void setPoint(LatLng latLng) {
        this.mPoint = latLng;
    }

    public void setType(int i) {
        this.mType = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mPoint, i);
        parcel.writeInt(this.mType);
        parcel.writeDouble(this.mIntensity);
    }
}
