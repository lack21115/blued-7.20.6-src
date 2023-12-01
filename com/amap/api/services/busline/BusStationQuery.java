package com.amap.api.services.busline;

import com.amap.api.col.p0003sl.fe;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/busline/BusStationQuery.class */
public class BusStationQuery implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private String f5590a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f5591c = 20;
    private int d = 1;

    public BusStationQuery(String str, String str2) {
        this.f5590a = str;
        this.b = str2;
        if (a()) {
            return;
        }
        new IllegalArgumentException("Empty query").printStackTrace();
    }

    private boolean a() {
        return !fe.a(this.f5590a);
    }

    /* renamed from: clone */
    public BusStationQuery m2444clone() {
        BusStationQuery busStationQuery = new BusStationQuery(this.f5590a, this.b);
        busStationQuery.setPageNumber(this.d);
        busStationQuery.setPageSize(this.f5591c);
        return busStationQuery;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BusStationQuery busStationQuery = (BusStationQuery) obj;
            String str = this.b;
            if (str == null) {
                if (busStationQuery.b != null) {
                    return false;
                }
            } else if (!str.equals(busStationQuery.b)) {
                return false;
            }
            if (this.d == busStationQuery.d && this.f5591c == busStationQuery.f5591c) {
                String str2 = this.f5590a;
                return str2 == null ? busStationQuery.f5590a == null : str2.equals(busStationQuery.f5590a);
            }
            return false;
        }
        return false;
    }

    public String getCity() {
        return this.b;
    }

    public int getPageNumber() {
        return this.d;
    }

    public int getPageSize() {
        return this.f5591c;
    }

    public String getQueryString() {
        return this.f5590a;
    }

    public int hashCode() {
        String str = this.b;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        int i2 = this.d;
        int i3 = this.f5591c;
        String str2 = this.f5590a;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((((hashCode + 31) * 31) + i2) * 31) + i3) * 31) + i;
    }

    public void setCity(String str) {
        this.b = str;
    }

    public void setPageNumber(int i) {
        int i2 = i;
        if (i <= 0) {
            i2 = 1;
        }
        this.d = i2;
    }

    public void setPageSize(int i) {
        this.f5591c = i;
    }

    public void setQueryString(String str) {
        this.f5590a = str;
    }

    public boolean weakEquals(BusStationQuery busStationQuery) {
        if (this == busStationQuery) {
            return true;
        }
        if (busStationQuery == null) {
            return false;
        }
        String str = this.b;
        if (str == null) {
            if (busStationQuery.b != null) {
                return false;
            }
        } else if (!str.equals(busStationQuery.b)) {
            return false;
        }
        if (this.f5591c != busStationQuery.f5591c) {
            return false;
        }
        String str2 = this.f5590a;
        return str2 == null ? busStationQuery.f5590a == null : str2.equals(busStationQuery.f5590a);
    }
}
