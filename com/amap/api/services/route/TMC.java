package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/TMC.class */
public class TMC implements Parcelable {
    public static final Parcelable.Creator<TMC> CREATOR = new Parcelable.Creator<TMC>() { // from class: com.amap.api.services.route.TMC.1
        private static TMC a(Parcel parcel) {
            return new TMC(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TMC createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TMC[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f5766a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private List<LatLonPoint> f5767c;

    public TMC() {
        this.f5767c = new ArrayList();
    }

    public TMC(Parcel parcel) {
        this.f5767c = new ArrayList();
        this.f5766a = parcel.readInt();
        this.b = parcel.readString();
        this.f5767c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f5766a;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f5767c;
    }

    public String getStatus() {
        return this.b;
    }

    public void setDistance(int i) {
        this.f5766a = i;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f5767c = list;
    }

    public void setStatus(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5766a);
        parcel.writeString(this.b);
        parcel.writeTypedList(this.f5767c);
    }
}
