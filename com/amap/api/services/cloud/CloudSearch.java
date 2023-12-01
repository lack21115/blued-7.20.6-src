package com.amap.api.services.cloud;

import android.content.Context;
import com.amap.api.col.p0003sl.fe;
import com.amap.api.col.p0003sl.fw;
import com.amap.api.col.p0003sl.gt;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/cloud/CloudSearch.class */
public class CloudSearch {
    private ICloudSearch a;

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/cloud/CloudSearch$OnCloudSearchListener.class */
    public interface OnCloudSearchListener {
        void onCloudItemDetailSearched(CloudItemDetail cloudItemDetail, int i);

        void onCloudSearched(CloudResult cloudResult, int i);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/cloud/CloudSearch$Query.class */
    public static class Query implements Cloneable {
        private String a;
        private String d;
        private SearchBound e;
        private Sortingrules f;
        private int b = 1;
        private int c = 20;
        private ArrayList<fw> g = new ArrayList<>();
        private List<String> h = new ArrayList();

        private Query() {
        }

        public Query(String str, String str2, SearchBound searchBound) throws AMapException {
            if (fe.a(str) || searchBound == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            this.d = str;
            this.a = str2;
            this.e = searchBound;
        }

        private ArrayList<fw> a() {
            if (this.g == null) {
                return null;
            }
            ArrayList<fw> arrayList = new ArrayList<>();
            arrayList.addAll(this.g);
            return arrayList;
        }

        private static boolean a(SearchBound searchBound, SearchBound searchBound2) {
            if (searchBound == null && searchBound2 == null) {
                return true;
            }
            if (searchBound == null || searchBound2 == null) {
                return false;
            }
            return searchBound.equals(searchBound2);
        }

        private static boolean a(Sortingrules sortingrules, Sortingrules sortingrules2) {
            if (sortingrules == null && sortingrules2 == null) {
                return true;
            }
            if (sortingrules == null || sortingrules2 == null) {
                return false;
            }
            return sortingrules.equals(sortingrules2);
        }

        private ArrayList<String> b() {
            if (this.h == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(this.h);
            return arrayList;
        }

        public void addFilterNum(String str, String str2, String str3) {
            this.g.add(new fw(str, str2, str3));
        }

        public void addFilterString(String str, String str2) {
            if (str == null || str2 == null) {
                return;
            }
            List<String> list = this.h;
            list.add(str + str2);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
        /* renamed from: clone */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.amap.api.services.cloud.CloudSearch.Query m8891clone() {
            /*
                r6 = this;
                r0 = r6
                java.lang.Object r0 = super.clone()     // Catch: java.lang.CloneNotSupportedException -> L8
                goto Ld
            L8:
                r7 = move-exception
                r0 = r7
                r0.printStackTrace()
            Ld:
                com.amap.api.services.cloud.CloudSearch$Query r0 = new com.amap.api.services.cloud.CloudSearch$Query     // Catch: com.amap.api.services.core.AMapException -> L50
                r1 = r0
                r2 = r6
                java.lang.String r2 = r2.d     // Catch: com.amap.api.services.core.AMapException -> L50
                r3 = r6
                java.lang.String r3 = r3.a     // Catch: com.amap.api.services.core.AMapException -> L50
                r4 = r6
                com.amap.api.services.cloud.CloudSearch$SearchBound r4 = r4.e     // Catch: com.amap.api.services.core.AMapException -> L50
                r1.<init>(r2, r3, r4)     // Catch: com.amap.api.services.core.AMapException -> L50
                r7 = r0
                r0 = r7
                r1 = r6
                int r1 = r1.b     // Catch: com.amap.api.services.core.AMapException -> L4c
                r0.setPageNum(r1)     // Catch: com.amap.api.services.core.AMapException -> L4c
                r0 = r7
                r1 = r6
                int r1 = r1.c     // Catch: com.amap.api.services.core.AMapException -> L4c
                r0.setPageSize(r1)     // Catch: com.amap.api.services.core.AMapException -> L4c
                r0 = r7
                r1 = r6
                com.amap.api.services.cloud.CloudSearch$Sortingrules r1 = r1.getSortingrules()     // Catch: com.amap.api.services.core.AMapException -> L4c
                r0.setSortingrules(r1)     // Catch: com.amap.api.services.core.AMapException -> L4c
                r0 = r7
                r1 = r6
                java.util.ArrayList r1 = r1.a()     // Catch: com.amap.api.services.core.AMapException -> L4c
                r0.g = r1     // Catch: com.amap.api.services.core.AMapException -> L4c
                r0 = r7
                r1 = r6
                java.util.ArrayList r1 = r1.b()     // Catch: com.amap.api.services.core.AMapException -> L4c
                r0.h = r1     // Catch: com.amap.api.services.core.AMapException -> L4c
                goto L57
            L4c:
                r8 = move-exception
                goto L53
            L50:
                r8 = move-exception
                r0 = 0
                r7 = r0
            L53:
                r0 = r8
                r0.printStackTrace()
            L57:
                r0 = r7
                if (r0 != 0) goto L63
                com.amap.api.services.cloud.CloudSearch$Query r0 = new com.amap.api.services.cloud.CloudSearch$Query
                r1 = r0
                r1.<init>()
                return r0
            L63:
                r0 = r7
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.cloud.CloudSearch.Query.m8891clone():com.amap.api.services.cloud.CloudSearch$Query");
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Query)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            Query query = (Query) obj;
            return queryEquals(query) && query.b == this.b;
        }

        public SearchBound getBound() {
            return this.e;
        }

        public String getFilterNumString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                int size = this.g.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    fw fwVar = this.g.get(i2);
                    stringBuffer.append(fwVar.a());
                    stringBuffer.append(">=");
                    stringBuffer.append(fwVar.b());
                    stringBuffer.append("&&");
                    stringBuffer.append(fwVar.a());
                    stringBuffer.append("<=");
                    stringBuffer.append(fwVar.c());
                    if (i2 != size - 1) {
                        stringBuffer.append("&&");
                    }
                    i = i2 + 1;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public String getFilterString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                int size = this.h.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    stringBuffer.append(this.h.get(i2));
                    if (i2 != size - 1) {
                        stringBuffer.append("&&");
                    }
                    i = i2 + 1;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public int getPageNum() {
            return this.b;
        }

        public int getPageSize() {
            return this.c;
        }

        public String getQueryString() {
            return this.a;
        }

        public Sortingrules getSortingrules() {
            return this.f;
        }

        public String getTableID() {
            return this.d;
        }

        public int hashCode() {
            ArrayList<fw> arrayList = this.g;
            int i = 0;
            int hashCode = arrayList == null ? 0 : arrayList.hashCode();
            List<String> list = this.h;
            int hashCode2 = list == null ? 0 : list.hashCode();
            SearchBound searchBound = this.e;
            int hashCode3 = searchBound == null ? 0 : searchBound.hashCode();
            int i2 = this.b;
            int i3 = this.c;
            String str = this.a;
            int hashCode4 = str == null ? 0 : str.hashCode();
            Sortingrules sortingrules = this.f;
            int hashCode5 = sortingrules == null ? 0 : sortingrules.hashCode();
            String str2 = this.d;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return ((((((((((((((hashCode + 31) * 31) + hashCode2) * 31) + hashCode3) * 31) + i2) * 31) + i3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return CloudSearch.b(query.a, this.a) && CloudSearch.b(query.getTableID(), getTableID()) && CloudSearch.b(query.getFilterString(), getFilterString()) && CloudSearch.b(query.getFilterNumString(), getFilterNumString()) && query.c == this.c && a(query.getBound(), getBound()) && a(query.getSortingrules(), getSortingrules());
        }

        public void setBound(SearchBound searchBound) {
            this.e = searchBound;
        }

        public void setPageNum(int i) {
            this.b = i;
        }

        public void setPageSize(int i) {
            if (i <= 0) {
                this.c = 20;
            } else if (i > 100) {
                this.c = 100;
            } else {
                this.c = i;
            }
        }

        public void setSortingrules(Sortingrules sortingrules) {
            this.f = sortingrules;
        }

        public void setTableID(String str) {
            this.d = str;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/cloud/CloudSearch$SearchBound.class */
    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String LOCAL_SHAPE = "Local";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";
        private LatLonPoint a;
        private LatLonPoint b;
        private int c;
        private LatLonPoint d;
        private String e;
        private List<LatLonPoint> f;
        private String g;

        public SearchBound(LatLonPoint latLonPoint, int i) {
            this.e = "Bound";
            this.c = i;
            this.d = latLonPoint;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.e = "Rectangle";
            if (a(latLonPoint, latLonPoint2)) {
                return;
            }
            new IllegalArgumentException("invalid rect ").printStackTrace();
        }

        public SearchBound(String str) {
            this.e = LOCAL_SHAPE;
            this.g = str;
        }

        public SearchBound(List<LatLonPoint> list) {
            this.e = "Polygon";
            this.f = list;
        }

        private List<LatLonPoint> a() {
            if (this.f == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (LatLonPoint latLonPoint : this.f) {
                arrayList.add(new LatLonPoint(latLonPoint.getLatitude(), latLonPoint.getLongitude()));
            }
            return arrayList;
        }

        private boolean a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.a = latLonPoint;
            this.b = latLonPoint2;
            return latLonPoint != null && latLonPoint2 != null && latLonPoint.getLatitude() < this.b.getLatitude() && this.a.getLongitude() < this.b.getLongitude();
        }

        private static boolean a(List<LatLonPoint> list, List<LatLonPoint> list2) {
            if (list == null && list2 == null) {
                return true;
            }
            if (list == null || list2 == null || list.size() != list2.size()) {
                return false;
            }
            int size = list.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return true;
                }
                if (!list.get(i2).equals(list2.get(i2))) {
                    return false;
                }
                i = i2 + 1;
            }
        }

        /* renamed from: clone */
        public SearchBound m8892clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return getShape().equals("Bound") ? new SearchBound(this.d, this.c) : getShape().equals("Polygon") ? new SearchBound(a()) : getShape().equals(LOCAL_SHAPE) ? new SearchBound(this.g) : new SearchBound(this.a, this.b);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof SearchBound)) {
                return false;
            }
            SearchBound searchBound = (SearchBound) obj;
            if (getShape().equalsIgnoreCase(searchBound.getShape())) {
                return getShape().equals("Bound") ? searchBound.d.equals(this.d) && searchBound.c == this.c : getShape().equals("Polygon") ? a(searchBound.f, this.f) : getShape().equals(LOCAL_SHAPE) ? searchBound.g.equals(this.g) : searchBound.a.equals(this.a) && searchBound.b.equals(this.b);
            }
            return false;
        }

        public LatLonPoint getCenter() {
            return this.d;
        }

        public String getCity() {
            return this.g;
        }

        public LatLonPoint getLowerLeft() {
            return this.a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f;
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
            LatLonPoint latLonPoint2 = this.a;
            int hashCode2 = latLonPoint2 == null ? 0 : latLonPoint2.hashCode();
            LatLonPoint latLonPoint3 = this.b;
            int hashCode3 = latLonPoint3 == null ? 0 : latLonPoint3.hashCode();
            List<LatLonPoint> list = this.f;
            int hashCode4 = list == null ? 0 : list.hashCode();
            int i2 = this.c;
            String str = this.e;
            int hashCode5 = str == null ? 0 : str.hashCode();
            String str2 = this.g;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return ((((((((((((hashCode + 31) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i2) * 31) + hashCode5) * 31) + i;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/cloud/CloudSearch$Sortingrules.class */
    public static class Sortingrules {
        public static final int DISTANCE = 1;
        public static final int WEIGHT = 0;
        private int a;
        private String b;
        private boolean c;

        public Sortingrules(int i) {
            this.a = 0;
            this.c = true;
            this.a = i;
        }

        public Sortingrules(String str, boolean z) {
            this.a = 0;
            this.c = true;
            this.b = str;
            this.c = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Sortingrules sortingrules = (Sortingrules) obj;
                if (this.c != sortingrules.c) {
                    return false;
                }
                String str = this.b;
                if (str == null) {
                    if (sortingrules.b != null) {
                        return false;
                    }
                } else if (!str.equals(sortingrules.b)) {
                    return false;
                }
                return this.a == sortingrules.a;
            }
            return false;
        }

        public int hashCode() {
            int i = this.c ? 1231 : 1237;
            String str = this.b;
            return ((((i + 31) * 31) + (str == null ? 0 : str.hashCode())) * 31) + this.a;
        }

        public String toString() {
            if (fe.a(this.b)) {
                int i = this.a;
                return i == 0 ? "_weight:desc" : i == 1 ? "_distance:asc" : "";
            } else if (this.c) {
                return this.b + ":asc";
            } else {
                return this.b + ":desc";
            }
        }
    }

    public CloudSearch(Context context) throws AMapException {
        if (this.a == null) {
            try {
                this.a = new gt(context);
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

    public void searchCloudAsyn(Query query) {
        ICloudSearch iCloudSearch = this.a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudAsyn(query);
        }
    }

    public void searchCloudDetailAsyn(String str, String str2) {
        ICloudSearch iCloudSearch = this.a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudDetailAsyn(str, str2);
        }
    }

    public void setOnCloudSearchListener(OnCloudSearchListener onCloudSearchListener) {
        ICloudSearch iCloudSearch = this.a;
        if (iCloudSearch != null) {
            iCloudSearch.setOnCloudSearchListener(onCloudSearchListener);
        }
    }
}
