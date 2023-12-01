package com.tencent.map.sdk.utilities.heatmap;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/heatmap/WeightedLatLng.class */
public class WeightedLatLng extends com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng {
    public static final Parcelable.Creator<WeightedLatLng> CREATOR = new a();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/heatmap/WeightedLatLng$a.class */
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
        super(parcel);
    }

    public WeightedLatLng(LatLng latLng) {
        super(latLng);
    }

    public WeightedLatLng(LatLng latLng, double d) {
        super(latLng, d);
    }

    @Override // com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof WeightedLatLng) {
            if (obj == this) {
                return true;
            }
            LatLng point = getPoint();
            double intensity = getIntensity();
            if (point == null) {
                WeightedLatLng weightedLatLng = (WeightedLatLng) obj;
                if (weightedLatLng.getPoint() != null) {
                    return false;
                }
                if (intensity == weightedLatLng.getIntensity()) {
                    z = true;
                }
                return z;
            }
            WeightedLatLng weightedLatLng2 = (WeightedLatLng) obj;
            boolean z2 = false;
            if (point.equals(weightedLatLng2.getPoint())) {
                z2 = false;
                if (intensity == weightedLatLng2.getIntensity()) {
                    z2 = true;
                }
            }
            return z2;
        }
        return false;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
