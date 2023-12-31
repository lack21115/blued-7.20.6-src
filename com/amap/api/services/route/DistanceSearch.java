package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003sl.fe;
import com.amap.api.col.p0003sl.gu;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IDistanceSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/DistanceSearch.class */
public class DistanceSearch {
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";
    public static final int TYPE_DISTANCE = 0;
    public static final int TYPE_DRIVING_DISTANCE = 1;
    public static final int TYPE_WALK_DISTANCE = 3;
    private IDistanceSearch a;

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/DistanceSearch$DistanceQuery.class */
    public static class DistanceQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DistanceQuery> CREATOR = new Parcelable.Creator<DistanceQuery>() { // from class: com.amap.api.services.route.DistanceSearch.DistanceQuery.1
            private static DistanceQuery a(Parcel parcel) {
                return new DistanceQuery(parcel);
            }

            private static DistanceQuery[] a(int i) {
                return new DistanceQuery[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistanceQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistanceQuery[] newArray(int i) {
                return a(i);
            }
        };
        private int a;
        private List<LatLonPoint> b;
        private LatLonPoint c;
        private String d;
        private int e;

        public DistanceQuery() {
            this.a = 1;
            this.b = new ArrayList();
            this.d = "base";
            this.e = 4;
        }

        protected DistanceQuery(Parcel parcel) {
            this.a = 1;
            this.b = new ArrayList();
            this.d = "base";
            this.e = 4;
            this.a = parcel.readInt();
            this.b = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            this.c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.d = parcel.readString();
            this.e = parcel.readInt();
        }

        public void addOrigins(LatLonPoint... latLonPointArr) {
            int length = latLonPointArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                LatLonPoint latLonPoint = latLonPointArr[i2];
                if (latLonPoint != null) {
                    this.b.add(latLonPoint);
                }
                i = i2 + 1;
            }
        }

        /* renamed from: clone */
        public DistanceQuery m8922clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                fe.a(e, "DistanceSearch", "DistanceQueryclone");
            }
            DistanceQuery distanceQuery = new DistanceQuery();
            distanceQuery.setType(this.a);
            distanceQuery.setOrigins(this.b);
            distanceQuery.setDestination(this.c);
            distanceQuery.setExtensions(this.d);
            distanceQuery.setMode(this.e);
            return distanceQuery;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public LatLonPoint getDestination() {
            return this.c;
        }

        public String getExtensions() {
            return this.d;
        }

        public int getMode() {
            return this.e;
        }

        public List<LatLonPoint> getOrigins() {
            return this.b;
        }

        public int getType() {
            return this.a;
        }

        public void setDestination(LatLonPoint latLonPoint) {
            this.c = latLonPoint;
        }

        public void setExtensions(String str) {
            this.d = str;
        }

        public void setMode(int i) {
            this.e = i;
        }

        public void setOrigins(List<LatLonPoint> list) {
            if (list != null) {
                this.b = list;
            }
        }

        public void setType(int i) {
            this.a = i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeTypedList(this.b);
            parcel.writeParcelable(this.c, i);
            parcel.writeString(this.d);
            parcel.writeInt(this.e);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/DistanceSearch$OnDistanceSearchListener.class */
    public interface OnDistanceSearchListener {
        void onDistanceSearched(DistanceResult distanceResult, int i);
    }

    public DistanceSearch(Context context) throws AMapException {
        if (this.a == null) {
            try {
                this.a = new gu(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    public DistanceResult calculateRouteDistance(DistanceQuery distanceQuery) throws AMapException {
        IDistanceSearch iDistanceSearch = this.a;
        if (iDistanceSearch != null) {
            return iDistanceSearch.calculateRouteDistance(distanceQuery);
        }
        return null;
    }

    public void calculateRouteDistanceAsyn(DistanceQuery distanceQuery) {
        IDistanceSearch iDistanceSearch = this.a;
        if (iDistanceSearch != null) {
            iDistanceSearch.calculateRouteDistanceAsyn(distanceQuery);
        }
    }

    public void setDistanceSearchListener(OnDistanceSearchListener onDistanceSearchListener) {
        IDistanceSearch iDistanceSearch = this.a;
        if (iDistanceSearch != null) {
            iDistanceSearch.setDistanceSearchListener(onDistanceSearchListener);
        }
    }
}
