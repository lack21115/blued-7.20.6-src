package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/VisibleRegionCreator.class */
public class VisibleRegionCreator implements Parcelable.Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        parcel.writeInt(visibleRegion.a());
        parcel.writeParcelable(visibleRegion.nearLeft, i);
        parcel.writeParcelable(visibleRegion.nearRight, i);
        parcel.writeParcelable(visibleRegion.farLeft, i);
        parcel.writeParcelable(visibleRegion.farRight, i);
        parcel.writeParcelable(visibleRegion.latLngBounds, i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        LatLng latLng3;
        LatLng latLng4;
        LatLng latLng5;
        LatLng latLng6;
        LatLngBounds latLngBounds;
        LatLng latLng7;
        int readInt = parcel.readInt();
        try {
            latLng6 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            try {
                latLng2 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            } catch (BadParcelableException e) {
                e = e;
                latLng = latLng6;
                latLng2 = null;
                latLng3 = null;
                latLng4 = latLng3;
                latLng5 = latLng3;
                latLng6 = latLng;
                e.printStackTrace();
                latLngBounds = null;
                latLng7 = latLng4;
                return new VisibleRegion(readInt, latLng6, latLng2, latLng5, latLng7, latLngBounds);
            }
            try {
                latLng5 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                try {
                    latLng7 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                    try {
                        latLngBounds = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
                    } catch (BadParcelableException e2) {
                        e = e2;
                        latLng4 = latLng7;
                        e.printStackTrace();
                        latLngBounds = null;
                        latLng7 = latLng4;
                        return new VisibleRegion(readInt, latLng6, latLng2, latLng5, latLng7, latLngBounds);
                    }
                } catch (BadParcelableException e3) {
                    e = e3;
                    latLng4 = null;
                }
            } catch (BadParcelableException e4) {
                e = e4;
                latLng = latLng6;
                latLng3 = null;
                latLng4 = latLng3;
                latLng5 = latLng3;
                latLng6 = latLng;
                e.printStackTrace();
                latLngBounds = null;
                latLng7 = latLng4;
                return new VisibleRegion(readInt, latLng6, latLng2, latLng5, latLng7, latLngBounds);
            }
        } catch (BadParcelableException e5) {
            e = e5;
            latLng = null;
        }
        return new VisibleRegion(readInt, latLng6, latLng2, latLng5, latLng7, latLngBounds);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public VisibleRegion[] newArray(int i) {
        return new VisibleRegion[i];
    }
}
