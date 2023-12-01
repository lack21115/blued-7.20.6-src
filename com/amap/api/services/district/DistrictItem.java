package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/district/DistrictItem.class */
public final class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new Parcelable.Creator<DistrictItem>() { // from class: com.amap.api.services.district.DistrictItem.1
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
    private String a;
    private String b;
    private String c;
    private LatLonPoint d;
    private String e;
    private List<DistrictItem> f;
    private String[] g;

    public DistrictItem() {
        this.f = new ArrayList();
        this.g = new String[0];
    }

    public DistrictItem(Parcel parcel) {
        this.f = new ArrayList();
        this.g = new String[0];
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.e = parcel.readString();
        this.f = parcel.createTypedArrayList(CREATOR);
        String[] strArr = new String[parcel.readInt()];
        this.g = strArr;
        parcel.readStringArray(strArr);
    }

    public DistrictItem(String str, String str2, String str3, LatLonPoint latLonPoint, String str4) {
        this.f = new ArrayList();
        this.g = new String[0];
        this.c = str;
        this.a = str2;
        this.b = str3;
        this.d = latLonPoint;
        this.e = str4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String[] districtBoundary() {
        return this.g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DistrictItem districtItem = (DistrictItem) obj;
            String str = this.b;
            if (str == null) {
                if (districtItem.b != null) {
                    return false;
                }
            } else if (!str.equals(districtItem.b)) {
                return false;
            }
            LatLonPoint latLonPoint = this.d;
            if (latLonPoint == null) {
                if (districtItem.d != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(districtItem.d)) {
                return false;
            }
            String str2 = this.a;
            if (str2 == null) {
                if (districtItem.a != null) {
                    return false;
                }
            } else if (!str2.equals(districtItem.a)) {
                return false;
            }
            if (Arrays.equals(this.g, districtItem.g)) {
                List<DistrictItem> list = this.f;
                if (list == null) {
                    if (districtItem.f != null) {
                        return false;
                    }
                } else if (!list.equals(districtItem.f)) {
                    return false;
                }
                String str3 = this.e;
                if (str3 == null) {
                    if (districtItem.e != null) {
                        return false;
                    }
                } else if (!str3.equals(districtItem.e)) {
                    return false;
                }
                String str4 = this.c;
                return str4 == null ? districtItem.c == null : str4.equals(districtItem.c);
            }
            return false;
        }
        return false;
    }

    public final String getAdcode() {
        return this.b;
    }

    public final LatLonPoint getCenter() {
        return this.d;
    }

    public final String getCitycode() {
        return this.a;
    }

    public final String getLevel() {
        return this.e;
    }

    public final String getName() {
        return this.c;
    }

    public final List<DistrictItem> getSubDistrict() {
        return this.f;
    }

    public final int hashCode() {
        String str = this.b;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        LatLonPoint latLonPoint = this.d;
        int hashCode2 = latLonPoint == null ? 0 : latLonPoint.hashCode();
        String str2 = this.a;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        int hashCode4 = Arrays.hashCode(this.g);
        List<DistrictItem> list = this.f;
        int hashCode5 = list == null ? 0 : list.hashCode();
        String str3 = this.e;
        int hashCode6 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.c;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return ((((((((((((hashCode + 31) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + i;
    }

    public final void setAdcode(String str) {
        this.b = str;
    }

    public final void setCenter(LatLonPoint latLonPoint) {
        this.d = latLonPoint;
    }

    public final void setCitycode(String str) {
        this.a = str;
    }

    public final void setDistrictBoundary(String[] strArr) {
        this.g = strArr;
    }

    public final void setLevel(String str) {
        this.e = str;
    }

    public final void setName(String str) {
        this.c = str;
    }

    public final void setSubDistrict(ArrayList<DistrictItem> arrayList) {
        this.f = arrayList;
    }

    public final String toString() {
        return "DistrictItem [mCitycode=" + this.a + ", mAdcode=" + this.b + ", mName=" + this.c + ", mCenter=" + this.d + ", mLevel=" + this.e + ", mDistricts=" + this.f + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeString(this.e);
        parcel.writeTypedList(this.f);
        parcel.writeInt(this.g.length);
        parcel.writeStringArray(this.g);
    }
}
