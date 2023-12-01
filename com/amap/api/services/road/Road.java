package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/road/Road.class */
public class Road implements Parcelable {
    public static final Parcelable.Creator<Road> CREATOR = new Parcelable.Creator<Road>() { // from class: com.amap.api.services.road.Road.1
        private static Road a(Parcel parcel) {
            return new Road(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Road createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Road[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5674a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f5675c;
    private float d;
    private String e;
    private LatLonPoint f;

    public Road() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Road(Parcel parcel) {
        this.f5674a = parcel.readString();
        this.b = parcel.readString();
        this.f5675c = parcel.readString();
        this.d = parcel.readFloat();
        this.e = parcel.readString();
        this.f = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }

    public Road(String str, String str2) {
        this.f5674a = str;
        this.b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getCenterPoint() {
        return this.f;
    }

    public String getCityCode() {
        return this.f5675c;
    }

    public String getId() {
        return this.f5674a;
    }

    public String getName() {
        return this.b;
    }

    public float getRoadWidth() {
        return this.d;
    }

    public String getType() {
        return this.e;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f = latLonPoint;
    }

    public void setCityCode(String str) {
        this.f5675c = str;
    }

    public void setId(String str) {
        this.f5674a = str;
    }

    public void setName(String str) {
        this.b = str;
    }

    public void setRoadWidth(float f) {
        this.d = f;
    }

    public void setType(String str) {
        this.e = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5674a);
        parcel.writeString(this.b);
        parcel.writeString(this.f5675c);
        parcel.writeFloat(this.d);
        parcel.writeString(this.e);
        parcel.writeValue(this.f);
    }
}
