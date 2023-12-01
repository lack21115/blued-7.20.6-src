package com.amap.api.services.busline;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/busline/BusLineQuery.class */
public class BusLineQuery implements Cloneable {
    private String a;
    private String b;
    private SearchType e;
    private int c = 20;
    private int d = 1;
    private String f = "base";

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/busline/BusLineQuery$SearchType.class */
    public enum SearchType {
        BY_LINE_ID,
        BY_LINE_NAME
    }

    public BusLineQuery(String str, SearchType searchType, String str2) {
        this.a = str;
        this.e = searchType;
        this.b = str2;
    }

    /* renamed from: clone */
    public BusLineQuery m8884clone() {
        BusLineQuery busLineQuery = new BusLineQuery(this.a, this.e, this.b);
        busLineQuery.setPageNumber(this.d);
        busLineQuery.setPageSize(this.c);
        busLineQuery.setExtensions(this.f);
        return busLineQuery;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BusLineQuery busLineQuery = (BusLineQuery) obj;
            if (this.e != busLineQuery.e) {
                return false;
            }
            String str = this.b;
            if (str == null) {
                if (busLineQuery.b != null) {
                    return false;
                }
            } else if (!str.equals(busLineQuery.b)) {
                return false;
            }
            if (this.d == busLineQuery.d && this.c == busLineQuery.c) {
                String str2 = this.a;
                if (str2 == null) {
                    if (busLineQuery.a != null) {
                        return false;
                    }
                } else if (!str2.equals(busLineQuery.a)) {
                    return false;
                }
                String str3 = this.f;
                return str3 == null ? busLineQuery.f == null : str3.equals(busLineQuery.f);
            }
            return false;
        }
        return false;
    }

    public SearchType getCategory() {
        return this.e;
    }

    public String getCity() {
        return this.b;
    }

    public String getExtensions() {
        return this.f;
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
        SearchType searchType = this.e;
        int i = 0;
        int hashCode = searchType == null ? 0 : searchType.hashCode();
        String str = this.b;
        int hashCode2 = str == null ? 0 : str.hashCode();
        int i2 = this.d;
        int i3 = this.c;
        String str2 = this.a;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.f;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((((((((((hashCode + 31) * 31) + hashCode2) * 31) + i2) * 31) + i3) * 31) + hashCode3) * 31) + i;
    }

    public void setCategory(SearchType searchType) {
        this.e = searchType;
    }

    public void setCity(String str) {
        this.b = str;
    }

    public void setExtensions(String str) {
        this.f = str;
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

    public boolean weakEquals(BusLineQuery busLineQuery) {
        if (this == busLineQuery) {
            return true;
        }
        if (busLineQuery == null) {
            return false;
        }
        if (this.a == null) {
            if (busLineQuery.getQueryString() != null) {
                return false;
            }
        } else if (!busLineQuery.getQueryString().equals(this.a)) {
            return false;
        }
        if (this.b == null) {
            if (busLineQuery.getCity() != null) {
                return false;
            }
        } else if (!busLineQuery.getCity().equals(this.b)) {
            return false;
        }
        return this.c == busLineQuery.getPageSize() && busLineQuery.getCategory().compareTo(this.e) == 0;
    }
}
