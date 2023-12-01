package com.amap.api.services.routepoisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/routepoisearch/RoutePOIItem.class */
public class RoutePOIItem implements Parcelable {
    public static final Parcelable.Creator<RoutePOIItem> CREATOR = new Parcelable.Creator<RoutePOIItem>() { // from class: com.amap.api.services.routepoisearch.RoutePOIItem.1
        private static RoutePOIItem a(Parcel parcel) {
            return new RoutePOIItem(parcel);
        }

        private static RoutePOIItem[] a(int i) {
            return new RoutePOIItem[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePOIItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePOIItem[] newArray(int i) {
            return a(i);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5783a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f5784c;
    private float d;
    private float e;

    public RoutePOIItem() {
    }

    protected RoutePOIItem(Parcel parcel) {
        this.f5783a = parcel.readString();
        this.b = parcel.readString();
        this.f5784c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.d = parcel.readFloat();
        this.e = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.d;
    }

    public float getDuration() {
        return this.e;
    }

    public String getID() {
        return this.f5783a;
    }

    public LatLonPoint getPoint() {
        return this.f5784c;
    }

    public String getTitle() {
        return this.b;
    }

    public void setDistance(float f) {
        this.d = f;
    }

    public void setDuration(float f) {
        this.e = f;
    }

    public void setID(String str) {
        this.f5783a = str;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f5784c = latLonPoint;
    }

    public void setTitle(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5783a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.f5784c, i);
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.e);
    }
}
