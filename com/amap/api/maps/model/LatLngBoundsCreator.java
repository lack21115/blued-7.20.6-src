package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/LatLngBoundsCreator.class */
public class LatLngBoundsCreator implements Parcelable.Creator<LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        parcel.writeInt(latLngBounds.a());
        parcel.writeParcelable(latLngBounds.southwest, i);
        parcel.writeParcelable(latLngBounds.northeast, i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        LatLng latLng3;
        int readInt = parcel.readInt();
        try {
            latLng2 = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
        } catch (BadParcelableException e) {
            e = e;
            latLng = null;
        }
        try {
            latLng3 = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
        } catch (BadParcelableException e2) {
            latLng = latLng2;
            e = e2;
            e.printStackTrace();
            latLng2 = latLng;
            latLng3 = null;
            return new LatLngBounds(readInt, latLng2, latLng3);
        }
        return new LatLngBounds(readInt, latLng2, latLng3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LatLngBounds[] newArray(int i) {
        return new LatLngBounds[i];
    }
}
