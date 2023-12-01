package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/BusRouteResult.class */
public class BusRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<BusRouteResult> CREATOR = new Parcelable.Creator<BusRouteResult>() { // from class: com.amap.api.services.route.BusRouteResult.1
        private static BusRouteResult a(Parcel parcel) {
            return new BusRouteResult(parcel);
        }

        private static BusRouteResult[] a(int i) {
            return new BusRouteResult[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResult[] newArray(int i) {
            return a(i);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f5678a;
    private List<BusPath> b;

    /* renamed from: c  reason: collision with root package name */
    private RouteSearch.BusRouteQuery f5679c;

    public BusRouteResult() {
        this.b = new ArrayList();
    }

    public BusRouteResult(Parcel parcel) {
        super(parcel);
        this.b = new ArrayList();
        this.f5678a = parcel.readFloat();
        this.b = parcel.createTypedArrayList(BusPath.CREATOR);
        this.f5679c = (RouteSearch.BusRouteQuery) parcel.readParcelable(RouteSearch.BusRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearch.BusRouteQuery getBusQuery() {
        return this.f5679c;
    }

    public List<BusPath> getPaths() {
        return this.b;
    }

    public float getTaxiCost() {
        return this.f5678a;
    }

    public void setBusQuery(RouteSearch.BusRouteQuery busRouteQuery) {
        this.f5679c = busRouteQuery;
    }

    public void setPaths(List<BusPath> list) {
        this.b = list;
    }

    public void setTaxiCost(float f) {
        this.f5678a = f;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f5678a);
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.f5679c, i);
    }
}
