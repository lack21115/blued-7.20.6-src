package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.col.p0003sl.fe;
import com.amap.api.col.p0003sl.gz;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/poisearch/PoiSearch.class */
public class PoiSearch {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";
    private IPoiSearch a;

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/poisearch/PoiSearch$OnPoiSearchListener.class */
    public interface OnPoiSearchListener {
        void onPoiItemSearched(PoiItem poiItem, int i);

        void onPoiSearched(PoiResult poiResult, int i);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/poisearch/PoiSearch$Query.class */
    public static class Query implements Cloneable {
        private String a;
        private String b;
        private String c;
        private int d;
        private int e;
        private String f;
        private boolean g;
        private boolean h;
        private String i;
        private boolean j;
        private LatLonPoint k;
        private boolean l;
        private String m;

        public Query(String str, String str2) {
            this(str, str2, null);
        }

        public Query(String str, String str2, String str3) {
            this.d = 1;
            this.e = 20;
            this.f = "zh-CN";
            this.g = false;
            this.h = false;
            this.j = true;
            this.l = true;
            this.m = "base";
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        private static String a() {
            return "";
        }

        /* renamed from: clone */
        public Query m8911clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                fe.a(e, "PoiSearch", "queryclone");
            }
            Query query = new Query(this.a, this.b, this.c);
            query.setPageNum(this.d);
            query.setPageSize(this.e);
            query.setQueryLanguage(this.f);
            query.setCityLimit(this.g);
            query.requireSubPois(this.h);
            query.setBuilding(this.i);
            query.setLocation(this.k);
            query.setDistanceSort(this.j);
            query.setSpecial(this.l);
            query.setExtensions(this.m);
            return query;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Query query = (Query) obj;
                String str = this.b;
                if (str == null) {
                    if (query.b != null) {
                        return false;
                    }
                } else if (!str.equals(query.b)) {
                    return false;
                }
                String str2 = this.c;
                if (str2 == null) {
                    if (query.c != null) {
                        return false;
                    }
                } else if (!str2.equals(query.c)) {
                    return false;
                }
                String str3 = this.f;
                if (str3 == null) {
                    if (query.f != null) {
                        return false;
                    }
                } else if (!str3.equals(query.f)) {
                    return false;
                }
                if (this.d == query.d && this.e == query.e) {
                    String str4 = this.a;
                    if (str4 == null) {
                        if (query.a != null) {
                            return false;
                        }
                    } else if (!str4.equals(query.a)) {
                        return false;
                    }
                    String str5 = this.i;
                    if (str5 == null) {
                        if (query.i != null) {
                            return false;
                        }
                    } else if (!str5.equals(query.i)) {
                        return false;
                    }
                    if (this.g == query.g && this.h == query.h && this.l == query.l) {
                        String str6 = this.m;
                        return str6 == null ? query.m == null : str6.equals(query.m);
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public String getBuilding() {
            return this.i;
        }

        public String getCategory() {
            String str = this.b;
            return (str == null || str.equals("00") || this.b.equals("00|")) ? a() : this.b;
        }

        public String getCity() {
            return this.c;
        }

        public boolean getCityLimit() {
            return this.g;
        }

        public String getExtensions() {
            return this.m;
        }

        public LatLonPoint getLocation() {
            return this.k;
        }

        public int getPageNum() {
            return this.d;
        }

        public int getPageSize() {
            return this.e;
        }

        protected String getQueryLanguage() {
            return this.f;
        }

        public String getQueryString() {
            return this.a;
        }

        public int hashCode() {
            String str = this.b;
            int i = 0;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.c;
            int hashCode2 = str2 == null ? 0 : str2.hashCode();
            int i2 = 1231;
            int i3 = this.g ? 1231 : 1237;
            if (!this.h) {
                i2 = 1237;
            }
            String str3 = this.f;
            int hashCode3 = str3 == null ? 0 : str3.hashCode();
            int i4 = this.d;
            int i5 = this.e;
            String str4 = this.a;
            int hashCode4 = str4 == null ? 0 : str4.hashCode();
            String str5 = this.i;
            if (str5 != null) {
                i = str5.hashCode();
            }
            return ((((((((((((((((hashCode + 31) * 31) + hashCode2) * 31) + i3) * 31) + i2) * 31) + hashCode3) * 31) + i4) * 31) + i5) * 31) + hashCode4) * 31) + i;
        }

        public boolean isDistanceSort() {
            return this.j;
        }

        public boolean isRequireSubPois() {
            return this.h;
        }

        public boolean isSpecial() {
            return this.l;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return PoiSearch.b(query.a, this.a) && PoiSearch.b(query.b, this.b) && PoiSearch.b(query.f, this.f) && PoiSearch.b(query.c, this.c) && PoiSearch.b(query.m, this.m) && PoiSearch.b(query.i, this.i) && query.g == this.g && query.e == this.e && query.j == this.j && query.l == this.l;
        }

        public void requireSubPois(boolean z) {
            this.h = z;
        }

        public void setBuilding(String str) {
            this.i = str;
        }

        public void setCityLimit(boolean z) {
            this.g = z;
        }

        public void setDistanceSort(boolean z) {
            this.j = z;
        }

        public void setExtensions(String str) {
            this.m = str;
        }

        public void setLocation(LatLonPoint latLonPoint) {
            this.k = latLonPoint;
        }

        public void setPageNum(int i) {
            int i2 = i;
            if (i <= 0) {
                i2 = 1;
            }
            this.d = i2;
        }

        public void setPageSize(int i) {
            if (i <= 0) {
                this.e = 20;
            } else if (i > 30) {
                this.e = 30;
            } else {
                this.e = i;
            }
        }

        public void setQueryLanguage(String str) {
            if ("en".equals(str)) {
                this.f = "en";
            } else {
                this.f = "zh-CN";
            }
        }

        public void setSpecial(boolean z) {
            this.l = z;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/poisearch/PoiSearch$SearchBound.class */
    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String ELLIPSE_SHAPE = "Ellipse";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";
        private LatLonPoint a;
        private LatLonPoint b;
        private int c;
        private LatLonPoint d;
        private String e;
        private boolean f;
        private List<LatLonPoint> g;

        public SearchBound(LatLonPoint latLonPoint, int i) {
            this.c = 1500;
            this.f = true;
            this.e = "Bound";
            this.c = i;
            this.d = latLonPoint;
        }

        public SearchBound(LatLonPoint latLonPoint, int i, boolean z) {
            this.c = 1500;
            this.f = true;
            this.e = "Bound";
            this.c = i;
            this.d = latLonPoint;
            this.f = z;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.c = 1500;
            this.f = true;
            this.e = "Rectangle";
            a(latLonPoint, latLonPoint2);
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z) {
            this.c = 1500;
            this.f = true;
            this.a = latLonPoint;
            this.b = latLonPoint2;
            this.c = i;
            this.d = latLonPoint3;
            this.e = str;
            this.g = list;
            this.f = z;
        }

        public SearchBound(List<LatLonPoint> list) {
            this.c = 1500;
            this.f = true;
            this.e = "Polygon";
            this.g = list;
        }

        private void a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.a = latLonPoint;
            this.b = latLonPoint2;
            if (latLonPoint.getLatitude() >= this.b.getLatitude() || this.a.getLongitude() >= this.b.getLongitude()) {
                new IllegalArgumentException("invalid rect ").printStackTrace();
            }
            this.d = new LatLonPoint((this.a.getLatitude() + this.b.getLatitude()) / 2.0d, (this.a.getLongitude() + this.b.getLongitude()) / 2.0d);
        }

        /* renamed from: clone */
        public SearchBound m8912clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                fe.a(e, "PoiSearch", "SearchBoundClone");
            }
            return new SearchBound(this.a, this.b, this.c, this.d, this.e, this.g, this.f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                SearchBound searchBound = (SearchBound) obj;
                LatLonPoint latLonPoint = this.d;
                if (latLonPoint == null) {
                    if (searchBound.d != null) {
                        return false;
                    }
                } else if (!latLonPoint.equals(searchBound.d)) {
                    return false;
                }
                if (this.f != searchBound.f) {
                    return false;
                }
                LatLonPoint latLonPoint2 = this.a;
                if (latLonPoint2 == null) {
                    if (searchBound.a != null) {
                        return false;
                    }
                } else if (!latLonPoint2.equals(searchBound.a)) {
                    return false;
                }
                LatLonPoint latLonPoint3 = this.b;
                if (latLonPoint3 == null) {
                    if (searchBound.b != null) {
                        return false;
                    }
                } else if (!latLonPoint3.equals(searchBound.b)) {
                    return false;
                }
                List<LatLonPoint> list = this.g;
                if (list == null) {
                    if (searchBound.g != null) {
                        return false;
                    }
                } else if (!list.equals(searchBound.g)) {
                    return false;
                }
                if (this.c != searchBound.c) {
                    return false;
                }
                String str = this.e;
                return str == null ? searchBound.e == null : str.equals(searchBound.e);
            }
            return false;
        }

        public LatLonPoint getCenter() {
            return this.d;
        }

        public LatLonPoint getLowerLeft() {
            return this.a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.g;
        }

        public int getRange() {
            return this.c;
        }

        public String getShape() {
            return this.e;
        }

        public LatLonPoint getUpperRight() {
            return this.b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.d;
            int i = 0;
            int hashCode = latLonPoint == null ? 0 : latLonPoint.hashCode();
            int i2 = this.f ? 1231 : 1237;
            LatLonPoint latLonPoint2 = this.a;
            int hashCode2 = latLonPoint2 == null ? 0 : latLonPoint2.hashCode();
            LatLonPoint latLonPoint3 = this.b;
            int hashCode3 = latLonPoint3 == null ? 0 : latLonPoint3.hashCode();
            List<LatLonPoint> list = this.g;
            int hashCode4 = list == null ? 0 : list.hashCode();
            int i3 = this.c;
            String str = this.e;
            if (str != null) {
                i = str.hashCode();
            }
            return ((((((((((((hashCode + 31) * 31) + i2) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i3) * 31) + i;
        }

        public boolean isDistanceSort() {
            return this.f;
        }
    }

    public PoiSearch(Context context, Query query) throws AMapException {
        this.a = null;
        if (0 == 0) {
            try {
                this.a = new gz(context, query);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public SearchBound getBound() {
        IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            return iPoiSearch.getBound();
        }
        return null;
    }

    public String getLanguage() {
        IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            return iPoiSearch.getLanguage();
        }
        return null;
    }

    public Query getQuery() {
        IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            return iPoiSearch.getQuery();
        }
        return null;
    }

    public PoiResult searchPOI() throws AMapException {
        IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            return iPoiSearch.searchPOI();
        }
        return null;
    }

    public void searchPOIAsyn() {
        IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            iPoiSearch.searchPOIAsyn();
        }
    }

    public PoiItem searchPOIId(String str) throws AMapException {
        IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            return iPoiSearch.searchPOIId(str);
        }
        return null;
    }

    public void searchPOIIdAsyn(String str) {
        IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            iPoiSearch.searchPOIIdAsyn(str);
        }
    }

    public void setBound(SearchBound searchBound) {
        IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            iPoiSearch.setBound(searchBound);
        }
    }

    public void setLanguage(String str) {
        IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            iPoiSearch.setLanguage(str);
        }
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            iPoiSearch.setOnPoiSearchListener(onPoiSearchListener);
        }
    }

    public void setQuery(Query query) {
        IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            iPoiSearch.setQuery(query);
        }
    }
}
