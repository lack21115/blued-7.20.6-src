package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/DriveRouteResult.class */
public class DriveRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<DriveRouteResult> CREATOR = new Parcelable.Creator<DriveRouteResult>() { // from class: com.amap.api.services.route.DriveRouteResult.1
        private static DriveRouteResult a(Parcel parcel) {
            return new DriveRouteResult(parcel);
        }

        private static DriveRouteResult[] a(int i) {
            return new DriveRouteResult[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResult[] newArray(int i) {
            return a(i);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f5704a;
    private List<DrivePath> b;

    /* renamed from: c  reason: collision with root package name */
    private RouteSearch.DriveRouteQuery f5705c;

    public DriveRouteResult() {
        this.b = new ArrayList();
    }

    public DriveRouteResult(Parcel parcel) {
        super(parcel);
        this.b = new ArrayList();
        this.f5704a = parcel.readFloat();
        this.b = parcel.createTypedArrayList(DrivePath.CREATOR);
        this.f5705c = (RouteSearch.DriveRouteQuery) parcel.readParcelable(RouteSearch.DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearch.DriveRouteQuery getDriveQuery() {
        return this.f5705c;
    }

    public List<DrivePath> getPaths() {
        return this.b;
    }

    public float getTaxiCost() {
        return this.f5704a;
    }

    public void setDriveQuery(RouteSearch.DriveRouteQuery driveRouteQuery) {
        this.f5705c = driveRouteQuery;
    }

    public void setPaths(List<DrivePath> list) {
        this.b = list;
    }

    public void setTaxiCost(float f) {
        this.f5704a = f;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f5704a);
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.f5705c, i);
    }
}
