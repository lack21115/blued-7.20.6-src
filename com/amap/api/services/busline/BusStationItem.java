package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/busline/BusStationItem.class */
public class BusStationItem implements Parcelable {
    public static final Parcelable.Creator<BusStationItem> CREATOR = new Parcelable.Creator<BusStationItem>() { // from class: com.amap.api.services.busline.BusStationItem.1
        private static BusStationItem a(Parcel parcel) {
            return new BusStationItem(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusStationItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusStationItem[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5588a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f5589c;
    private String d;
    private String e;
    private List<BusLineItem> f;

    public BusStationItem() {
        this.f = new ArrayList();
    }

    private BusStationItem(Parcel parcel) {
        this.f = new ArrayList();
        this.b = parcel.readString();
        this.f5588a = parcel.readString();
        this.f5589c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readArrayList(BusLineItem.class.getClassLoader());
    }

    /* synthetic */ BusStationItem(Parcel parcel, byte b) {
        this(parcel);
    }

    private static String a(List<BusLineItem> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                stringBuffer.append(list.get(i2).getBusLineName());
                if (i2 < list.size() - 1) {
                    stringBuffer.append("|");
                }
                i = i2 + 1;
            }
        }
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BusStationItem busStationItem = (BusStationItem) obj;
            String str = this.f5588a;
            return str == null ? busStationItem.f5588a == null : str.equals(busStationItem.f5588a);
        }
        return false;
    }

    public String getAdCode() {
        return this.e;
    }

    public List<BusLineItem> getBusLineItems() {
        return this.f;
    }

    public String getBusStationId() {
        return this.f5588a;
    }

    public String getBusStationName() {
        return this.b;
    }

    public String getCityCode() {
        return this.d;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f5589c;
    }

    public int hashCode() {
        String str = this.f5588a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setAdCode(String str) {
        this.e = str;
    }

    public void setBusLineItems(List<BusLineItem> list) {
        this.f = list;
    }

    public void setBusStationId(String str) {
        this.f5588a = str;
    }

    public void setBusStationName(String str) {
        this.b = str;
    }

    public void setCityCode(String str) {
        this.d = str;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f5589c = latLonPoint;
    }

    public String toString() {
        return "BusStationName: " + this.b + " LatLonPoint: " + this.f5589c.toString() + " BusLines: " + a(this.f) + " CityCode: " + this.d + " AdCode: " + this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.f5588a);
        parcel.writeValue(this.f5589c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeList(this.f);
    }
}
