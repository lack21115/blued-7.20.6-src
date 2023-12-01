package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003sl.fe;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/district/DistrictSearchQuery.class */
public class DistrictSearchQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<DistrictSearchQuery> CREATOR = new Parcelable.Creator<DistrictSearchQuery>() { // from class: com.amap.api.services.district.DistrictSearchQuery.1
        private static DistrictSearchQuery a(Parcel parcel) {
            DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
            districtSearchQuery.setKeywords(parcel.readString());
            districtSearchQuery.setKeywordsLevel(parcel.readString());
            districtSearchQuery.setPageNum(parcel.readInt());
            districtSearchQuery.setPageSize(parcel.readInt());
            districtSearchQuery.setShowChild(parcel.readByte() == 1);
            districtSearchQuery.setShowBoundary(parcel.readByte() == 1);
            boolean z = false;
            if (parcel.readByte() == 1) {
                z = true;
            }
            districtSearchQuery.setShowBusinessArea(z);
            districtSearchQuery.setSubDistrict(parcel.readInt());
            return districtSearchQuery;
        }

        private static DistrictSearchQuery[] a(int i) {
            return new DistrictSearchQuery[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictSearchQuery createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictSearchQuery[] newArray(int i) {
            return a(i);
        }
    };
    public static final String KEYWORDS_BUSINESS = "biz_area";
    public static final String KEYWORDS_CITY = "city";
    public static final String KEYWORDS_COUNTRY = "country";
    public static final String KEYWORDS_DISTRICT = "district";
    public static final String KEYWORDS_PROVINCE = "province";

    /* renamed from: a  reason: collision with root package name */
    private int f5624a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private String f5625c;
    private String d;
    private boolean e;
    private boolean f;
    private boolean g;
    private int h;

    public DistrictSearchQuery() {
        this.f5624a = 1;
        this.b = 20;
        this.e = true;
        this.f = false;
        this.g = false;
        this.h = 1;
    }

    public DistrictSearchQuery(String str, String str2, int i) {
        this.f5624a = 1;
        this.b = 20;
        this.e = true;
        this.f = false;
        this.g = false;
        this.h = 1;
        this.f5625c = str;
        this.d = str2;
        this.f5624a = i;
    }

    public DistrictSearchQuery(String str, String str2, int i, boolean z, int i2) {
        this(str, str2, i);
        this.e = z;
        this.b = i2;
    }

    public boolean checkKeyWords() {
        String str = this.f5625c;
        return (str == null || str.trim().equalsIgnoreCase("")) ? false : true;
    }

    public boolean checkLevels() {
        String str = this.d;
        if (str == null) {
            return false;
        }
        return str.trim().equals("country") || this.d.trim().equals(KEYWORDS_PROVINCE) || this.d.trim().equals(KEYWORDS_CITY) || this.d.trim().equals(KEYWORDS_DISTRICT) || this.d.trim().equals(KEYWORDS_BUSINESS);
    }

    /* renamed from: clone */
    public DistrictSearchQuery m2455clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            fe.a(e, "DistrictSearchQuery", "clone");
        }
        DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
        districtSearchQuery.setKeywords(this.f5625c);
        districtSearchQuery.setKeywordsLevel(this.d);
        districtSearchQuery.setPageNum(this.f5624a);
        districtSearchQuery.setPageSize(this.b);
        districtSearchQuery.setShowChild(this.e);
        districtSearchQuery.setSubDistrict(this.h);
        districtSearchQuery.setShowBoundary(this.g);
        districtSearchQuery.setShowBusinessArea(this.f);
        return districtSearchQuery;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DistrictSearchQuery districtSearchQuery = (DistrictSearchQuery) obj;
            if (this.g != districtSearchQuery.g) {
                return false;
            }
            String str = this.f5625c;
            if (str == null) {
                if (districtSearchQuery.f5625c != null) {
                    return false;
                }
            } else if (!str.equals(districtSearchQuery.f5625c)) {
                return false;
            }
            return this.f5624a == districtSearchQuery.f5624a && this.b == districtSearchQuery.b && this.e == districtSearchQuery.e && this.h == districtSearchQuery.h;
        }
        return false;
    }

    public String getKeywords() {
        return this.f5625c;
    }

    public String getKeywordsLevel() {
        return this.d;
    }

    public int getPageNum() {
        int i = this.f5624a;
        int i2 = i;
        if (i <= 0) {
            i2 = 1;
        }
        return i2;
    }

    public int getPageSize() {
        return this.b;
    }

    public int getSubDistrict() {
        return this.h;
    }

    public int hashCode() {
        int i = 1231;
        int i2 = this.g ? 1231 : 1237;
        String str = this.f5625c;
        int i3 = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.d;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        int i4 = this.f5624a;
        int i5 = this.b;
        if (!this.e) {
            i = 1237;
        }
        return ((((((((((((i2 + 31) * 31) + hashCode) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i) * 31) + this.h;
    }

    public boolean isShowBoundary() {
        return this.g;
    }

    public boolean isShowBusinessArea() {
        return this.f;
    }

    public boolean isShowChild() {
        return this.e;
    }

    public void setKeywords(String str) {
        this.f5625c = str;
    }

    public void setKeywordsLevel(String str) {
        this.d = str;
    }

    public void setPageNum(int i) {
        this.f5624a = i;
    }

    public void setPageSize(int i) {
        this.b = i;
    }

    public void setShowBoundary(boolean z) {
        this.g = z;
    }

    public void setShowBusinessArea(boolean z) {
        this.f = z;
    }

    public void setShowChild(boolean z) {
        this.e = z;
    }

    public void setSubDistrict(int i) {
        this.h = i;
    }

    public boolean weakEquals(DistrictSearchQuery districtSearchQuery) {
        if (this == districtSearchQuery) {
            return true;
        }
        if (districtSearchQuery == null) {
            return false;
        }
        String str = this.f5625c;
        if (str == null) {
            if (districtSearchQuery.f5625c != null) {
                return false;
            }
        } else if (!str.equals(districtSearchQuery.f5625c)) {
            return false;
        }
        return this.b == districtSearchQuery.b && this.e == districtSearchQuery.e && this.g == districtSearchQuery.g && this.h == districtSearchQuery.h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5625c);
        parcel.writeString(this.d);
        parcel.writeInt(this.f5624a);
        parcel.writeInt(this.b);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.h);
    }
}
