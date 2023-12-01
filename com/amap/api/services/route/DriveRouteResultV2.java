package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/DriveRouteResultV2.class */
public class DriveRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<DriveRouteResultV2> CREATOR = new Parcelable.Creator<DriveRouteResultV2>() { // from class: com.amap.api.services.route.DriveRouteResultV2.1
        private static DriveRouteResultV2 a(Parcel parcel) {
            return new DriveRouteResultV2(parcel);
        }

        private static DriveRouteResultV2[] a(int i) {
            return new DriveRouteResultV2[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResultV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResultV2[] newArray(int i) {
            return a(i);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f5706a;
    private List<DrivePathV2> b;

    /* renamed from: c  reason: collision with root package name */
    private RouteSearchV2.DriveRouteQuery f5707c;

    public DriveRouteResultV2() {
        this.b = new ArrayList();
    }

    public DriveRouteResultV2(Parcel parcel) {
        super(parcel);
        this.b = new ArrayList();
        this.f5706a = parcel.readFloat();
        this.b = parcel.createTypedArrayList(DrivePathV2.CREATOR);
        this.f5707c = (RouteSearchV2.DriveRouteQuery) parcel.readParcelable(RouteSearchV2.DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearchV2.DriveRouteQuery getDriveQuery() {
        return this.f5707c;
    }

    public List<DrivePathV2> getPaths() {
        return this.b;
    }

    public float getTaxiCost() {
        return this.f5706a;
    }

    public void setDriveQuery(RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        this.f5707c = driveRouteQuery;
    }

    public void setPaths(List<DrivePathV2> list) {
        this.b = list;
    }

    public void setTaxiCost(float f) {
        this.f5706a = f;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f5706a);
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.f5707c, i);
    }
}
