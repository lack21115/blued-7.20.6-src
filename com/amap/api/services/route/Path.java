package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/Path.class */
public class Path implements Parcelable {
    public static final Parcelable.Creator<Path> CREATOR = new Parcelable.Creator<Path>() { // from class: com.amap.api.services.route.Path.1
        private static Path a(Parcel parcel) {
            return new Path(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Path createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Path[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f5715a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private List<LatLonPoint> f5716c;

    public Path() {
        this.f5716c = new ArrayList();
    }

    public Path(Parcel parcel) {
        this.f5716c = new ArrayList();
        this.f5715a = parcel.readFloat();
        this.b = parcel.readLong();
        this.f5716c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f5715a;
    }

    public long getDuration() {
        return this.b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f5716c;
    }

    public void setDistance(float f) {
        this.f5715a = f;
    }

    public void setDuration(long j) {
        this.b = j;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f5716c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f5715a);
        parcel.writeLong(this.b);
        parcel.writeTypedList(this.f5716c);
    }
}
