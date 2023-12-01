package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.location.DPoint;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/fence/DistrictItem.class */
public class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new Parcelable.Creator<DistrictItem>() { // from class: com.amap.api.fence.DistrictItem.1
        private static DistrictItem a(Parcel parcel) {
            return new DistrictItem(parcel);
        }

        private static DistrictItem[] a(int i) {
            return new DistrictItem[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem[] newArray(int i) {
            return a(i);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5464a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f5465c;
    private List<DPoint> d;

    public DistrictItem() {
        this.f5464a = "";
        this.b = null;
        this.f5465c = null;
        this.d = null;
    }

    protected DistrictItem(Parcel parcel) {
        this.f5464a = "";
        this.b = null;
        this.f5465c = null;
        this.d = null;
        this.f5464a = parcel.readString();
        this.b = parcel.readString();
        this.f5465c = parcel.readString();
        this.d = parcel.createTypedArrayList(DPoint.CREATOR);
    }

    public static Parcelable.Creator<DistrictItem> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f5465c;
    }

    public String getCitycode() {
        return this.b;
    }

    public String getDistrictName() {
        return this.f5464a;
    }

    public List<DPoint> getPolyline() {
        return this.d;
    }

    public void setAdcode(String str) {
        this.f5465c = str;
    }

    public void setCitycode(String str) {
        this.b = str;
    }

    public void setDistrictName(String str) {
        this.f5464a = str;
    }

    public void setPolyline(List<DPoint> list) {
        this.d = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5464a);
        parcel.writeString(this.b);
        parcel.writeString(this.f5465c);
        parcel.writeTypedList(this.d);
    }
}
