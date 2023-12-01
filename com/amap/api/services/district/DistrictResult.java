package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import java.util.ArrayList;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/district/DistrictResult.class */
public final class DistrictResult implements Parcelable {
    public Parcelable.Creator<DistrictResult> CREATOR;

    /* renamed from: a  reason: collision with root package name */
    private DistrictSearchQuery f5620a;
    private ArrayList<DistrictItem> b;

    /* renamed from: c  reason: collision with root package name */
    private int f5621c;
    private AMapException d;

    public DistrictResult() {
        this.b = new ArrayList<>();
        this.CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.amap.api.services.district.DistrictResult.1
            private static DistrictResult a(Parcel parcel) {
                return new DistrictResult(parcel);
            }

            private static DistrictResult[] a(int i) {
                return new DistrictResult[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult[] newArray(int i) {
                return a(i);
            }
        };
    }

    protected DistrictResult(Parcel parcel) {
        this.b = new ArrayList<>();
        this.CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.amap.api.services.district.DistrictResult.1
            private static DistrictResult a(Parcel parcel2) {
                return new DistrictResult(parcel2);
            }

            private static DistrictResult[] a(int i) {
                return new DistrictResult[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel2) {
                return a(parcel2);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult[] newArray(int i) {
                return a(i);
            }
        };
        this.f5620a = (DistrictSearchQuery) parcel.readParcelable(DistrictSearchQuery.class.getClassLoader());
        this.b = parcel.createTypedArrayList(DistrictItem.CREATOR);
    }

    public DistrictResult(DistrictSearchQuery districtSearchQuery, ArrayList<DistrictItem> arrayList) {
        this.b = new ArrayList<>();
        this.CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.amap.api.services.district.DistrictResult.1
            private static DistrictResult a(Parcel parcel2) {
                return new DistrictResult(parcel2);
            }

            private static DistrictResult[] a(int i) {
                return new DistrictResult[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel2) {
                return a(parcel2);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult[] newArray(int i) {
                return a(i);
            }
        };
        this.f5620a = districtSearchQuery;
        this.b = arrayList;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DistrictResult districtResult = (DistrictResult) obj;
            DistrictSearchQuery districtSearchQuery = this.f5620a;
            if (districtSearchQuery == null) {
                if (districtResult.f5620a != null) {
                    return false;
                }
            } else if (!districtSearchQuery.equals(districtResult.f5620a)) {
                return false;
            }
            ArrayList<DistrictItem> arrayList = this.b;
            return arrayList == null ? districtResult.b == null : arrayList.equals(districtResult.b);
        }
        return false;
    }

    public final AMapException getAMapException() {
        return this.d;
    }

    public final ArrayList<DistrictItem> getDistrict() {
        return this.b;
    }

    public final int getPageCount() {
        return this.f5621c;
    }

    public final DistrictSearchQuery getQuery() {
        return this.f5620a;
    }

    public final int hashCode() {
        DistrictSearchQuery districtSearchQuery = this.f5620a;
        int i = 0;
        int hashCode = districtSearchQuery == null ? 0 : districtSearchQuery.hashCode();
        ArrayList<DistrictItem> arrayList = this.b;
        if (arrayList != null) {
            i = arrayList.hashCode();
        }
        return ((hashCode + 31) * 31) + i;
    }

    public final void setAMapException(AMapException aMapException) {
        this.d = aMapException;
    }

    public final void setDistrict(ArrayList<DistrictItem> arrayList) {
        this.b = arrayList;
    }

    public final void setPageCount(int i) {
        this.f5621c = i;
    }

    public final void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f5620a = districtSearchQuery;
    }

    public final String toString() {
        return "DistrictResult [mDisQuery=" + this.f5620a + ", mDistricts=" + this.b + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f5620a, i);
        parcel.writeTypedList(this.b);
    }
}
