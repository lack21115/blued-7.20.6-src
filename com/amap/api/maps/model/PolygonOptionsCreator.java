package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.AMapPara;
import java.util.ArrayList;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/PolygonOptionsCreator.class */
public class PolygonOptionsCreator implements Parcelable.Creator<PolygonOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public PolygonOptions createFromParcel(Parcel parcel) {
        PolygonOptions polygonOptions = new PolygonOptions();
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, LatLng.CREATOR);
        float readFloat = parcel.readFloat();
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        float readFloat2 = parcel.readFloat();
        boolean z = parcel.readByte() == 1;
        LatLng[] latLngArr = new LatLng[arrayList.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                break;
            }
            latLngArr[i2] = (LatLng) arrayList.get(i2);
            i = i2 + 1;
        }
        polygonOptions.add(latLngArr);
        polygonOptions.strokeWidth(readFloat);
        polygonOptions.strokeColor(readInt);
        polygonOptions.fillColor(readInt2);
        polygonOptions.zIndex(readFloat2);
        polygonOptions.visible(z);
        polygonOptions.a = parcel.readString();
        ArrayList arrayList2 = new ArrayList();
        parcel.readList(arrayList2, BaseHoleOptions.class.getClassLoader());
        polygonOptions.addHoles(arrayList2);
        polygonOptions.lineJoinType(AMapPara.LineJoinType.valueOf(parcel.readInt()));
        boolean z2 = false;
        if (parcel.readByte() == 1) {
            z2 = true;
        }
        polygonOptions.usePolylineStroke(z2);
        return polygonOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public PolygonOptions[] newArray(int i) {
        return new PolygonOptions[i];
    }
}
