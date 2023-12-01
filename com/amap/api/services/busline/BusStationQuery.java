package com.amap.api.services.busline;

import com.amap.api.col.p0003sl.fe;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/busline/BusStationQuery.class */
public class BusStationQuery implements Cloneable {
    private String a;
    private String b;
    private int c = 20;
    private int d = 1;

    public BusStationQuery(String str, String str2) {
        this.a = str;
        this.b = str2;
        if (a()) {
            return;
        }
        new IllegalArgumentException("Empty query").printStackTrace();
    }

    private boolean a() {
        return !fe.a(this.a);
    }

    /* renamed from: clone */
    public BusStationQuery m8887clone() {
        BusStationQuery busStationQuery = new BusStationQuery(this.a, this.b);
        busStationQuery.setPageNumber(this.d);
        busStationQuery.setPageSize(this.c);
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
            if (this.d == busStationQuery.d && this.c == busStationQuery.c) {
                String str2 = this.a;
                return str2 == null ? busStationQuery.a == null : str2.equals(busStationQuery.a);
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
        return this.c;
    }

    public String getQueryString() {
        return this.a;
    }

    public int hashCode() {
        String str = this.b;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        int i2 = this.d;
        int i3 = this.c;
        String str2 = this.a;
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
        this.c = i;
    }

    public void setQueryString(String str) {
        this.a = str;
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
        if (this.c != busStationQuery.c) {
            return false;
        }
        String str2 = this.a;
        return str2 == null ? busStationQuery.a == null : str2.equals(busStationQuery.a);
    }
}
