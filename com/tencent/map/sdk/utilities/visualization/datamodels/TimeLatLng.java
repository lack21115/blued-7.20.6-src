package com.tencent.map.sdk.utilities.visualization.datamodels;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/datamodels/TimeLatLng.class */
public class TimeLatLng implements Parcelable {
    public static final Parcelable.Creator<TimeLatLng> CREATOR = new a();
    private static final int DEFAULT_TIME = 0;
    private LatLng mPoint;
    private int mTime;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/datamodels/TimeLatLng$a.class */
    public static final class a implements Parcelable.Creator<TimeLatLng> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TimeLatLng createFromParcel(Parcel parcel) {
            return new TimeLatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TimeLatLng[] newArray(int i) {
            return new TimeLatLng[i];
        }
    }

    public TimeLatLng(Parcel parcel) {
        this.mPoint = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.mTime = parcel.readInt();
    }

    public TimeLatLng(LatLng latLng) {
        this(latLng, 0);
    }

    public TimeLatLng(LatLng latLng, int i) {
        setPoint(latLng);
        setTime(i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof TimeLatLng) {
            if (obj == this) {
                return true;
            }
            LatLng latLng = this.mPoint;
            if (latLng == null) {
                TimeLatLng timeLatLng = (TimeLatLng) obj;
                if (timeLatLng.mPoint != null) {
                    return false;
                }
                if (this.mTime == timeLatLng.mTime) {
                    z = true;
                }
                return z;
            }
            TimeLatLng timeLatLng2 = (TimeLatLng) obj;
            boolean z2 = false;
            if (latLng.equals(timeLatLng2.mPoint)) {
                z2 = false;
                if (this.mTime == timeLatLng2.mTime) {
                    z2 = true;
                }
            }
            return z2;
        }
        return false;
    }

    public LatLng getPoint() {
        return this.mPoint;
    }

    public int getTime() {
        return this.mTime;
    }

    public int hashCode() {
        LatLng latLng = this.mPoint;
        return latLng != null ? latLng.hashCode() + ((int) (this.mTime * 1000000.0d)) : (int) (this.mTime * 1000000.0d);
    }

    public void setPoint(LatLng latLng) {
        this.mPoint = latLng;
    }

    public void setTime(int i) {
        if (i >= 0) {
            this.mTime = i;
        } else {
            this.mTime = 0;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mPoint, i);
        parcel.writeInt(this.mTime);
    }
}
