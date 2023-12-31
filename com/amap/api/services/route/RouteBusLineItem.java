package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/RouteBusLineItem.class */
public class RouteBusLineItem extends BusLineItem implements Parcelable {
    public static final Parcelable.Creator<RouteBusLineItem> CREATOR = new Parcelable.Creator<RouteBusLineItem>() { // from class: com.amap.api.services.route.RouteBusLineItem.1
        private static RouteBusLineItem a(Parcel parcel) {
            return new RouteBusLineItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteBusLineItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RouteBusLineItem[] newArray(int i) {
            return null;
        }
    };
    private BusStationItem a;
    private BusStationItem b;
    private List<LatLonPoint> c;
    private int d;
    private List<BusStationItem> e;
    private float f;

    public RouteBusLineItem() {
        this.c = new ArrayList();
        this.e = new ArrayList();
    }

    public RouteBusLineItem(Parcel parcel) {
        super(parcel);
        this.c = new ArrayList();
        this.e = new ArrayList();
        this.a = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.b = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.d = parcel.readInt();
        this.e = parcel.createTypedArrayList(BusStationItem.CREATOR);
        this.f = parcel.readFloat();
    }

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj) && getClass() == obj.getClass()) {
            RouteBusLineItem routeBusLineItem = (RouteBusLineItem) obj;
            BusStationItem busStationItem = this.b;
            if (busStationItem == null) {
                if (routeBusLineItem.b != null) {
                    return false;
                }
            } else if (!busStationItem.equals(routeBusLineItem.b)) {
                return false;
            }
            BusStationItem busStationItem2 = this.a;
            return busStationItem2 == null ? routeBusLineItem.a == null : busStationItem2.equals(routeBusLineItem.a);
        }
        return false;
    }

    public BusStationItem getArrivalBusStation() {
        return this.b;
    }

    public BusStationItem getDepartureBusStation() {
        return this.a;
    }

    public float getDuration() {
        return this.f;
    }

    public int getPassStationNum() {
        return this.d;
    }

    public List<BusStationItem> getPassStations() {
        return this.e;
    }

    public List<LatLonPoint> getPolyline() {
        return this.c;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public int hashCode() {
        int hashCode = super.hashCode();
        BusStationItem busStationItem = this.b;
        int i = 0;
        int hashCode2 = busStationItem == null ? 0 : busStationItem.hashCode();
        BusStationItem busStationItem2 = this.a;
        if (busStationItem2 != null) {
            i = busStationItem2.hashCode();
        }
        return (((hashCode * 31) + hashCode2) * 31) + i;
    }

    public void setArrivalBusStation(BusStationItem busStationItem) {
        this.b = busStationItem;
    }

    public void setDepartureBusStation(BusStationItem busStationItem) {
        this.a = busStationItem;
    }

    public void setDuration(float f) {
        this.f = f;
    }

    public void setPassStationNum(int i) {
        this.d = i;
    }

    public void setPassStations(List<BusStationItem> list) {
        this.e = list;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.c = list;
    }

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeTypedList(this.c);
        parcel.writeInt(this.d);
        parcel.writeTypedList(this.e);
        parcel.writeFloat(this.f);
    }
}
