package com.amap.api.col.p0003sl;

import android.content.Context;
import com.alipay.sdk.util.i;
import com.amap.api.col.p0003sl.ga;
import com.amap.api.col.p0003sl.gc;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import com.android.internal.util.cm.SpamFilter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.fv  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fv.class */
public final class fv extends ft<fy, PoiResult> {
    private int k;
    private boolean l;
    private List<String> m;
    private List<SuggestionCity> n;

    public fv(Context context, fy fyVar) {
        super(context, fyVar);
        this.k = 0;
        this.l = false;
        this.m = new ArrayList();
        this.n = new ArrayList();
    }

    private String a(boolean z) {
        List<LatLonPoint> polyGonList;
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        if (((fy) this.b).b != null) {
            if (((fy) this.b).b.getShape().equals("Bound")) {
                if (z) {
                    double a = fe.a(((fy) this.b).b.getCenter().getLongitude());
                    double a2 = fe.a(((fy) this.b).b.getCenter().getLatitude());
                    sb.append("&location=");
                    sb.append(a + "," + a2);
                }
                sb.append("&radius=");
                sb.append(((fy) this.b).b.getRange());
                sb.append("&sortrule=");
                sb.append(b(((fy) this.b).b.isDistanceSort()));
            } else if (((fy) this.b).b.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((fy) this.b).b.getLowerLeft();
                LatLonPoint upperRight = ((fy) this.b).b.getUpperRight();
                double a3 = fe.a(lowerLeft.getLatitude());
                double a4 = fe.a(lowerLeft.getLongitude());
                double a5 = fe.a(upperRight.getLatitude());
                double a6 = fe.a(upperRight.getLongitude());
                sb.append("&polygon=" + a4 + "," + a3 + i.b + a6 + "," + a5);
            } else if (((fy) this.b).b.getShape().equals("Polygon") && (polyGonList = ((fy) this.b).b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb.append("&polygon=" + fe.a(polyGonList));
            }
        }
        String city = ((fy) this.b).a.getCity();
        if (!c(city)) {
            String b = b(city);
            sb.append("&city=");
            sb.append(b);
        }
        String b2 = b(((fy) this.b).a.getQueryString());
        if (!c(b2)) {
            sb.append("&keywords=");
            sb.append(b2);
        }
        sb.append("&offset=");
        sb.append(((fy) this.b).a.getPageSize());
        sb.append("&page=");
        sb.append(((fy) this.b).a.getPageNum());
        String building = ((fy) this.b).a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb.append("&building=");
            sb.append(((fy) this.b).a.getBuilding());
        }
        String b3 = b(((fy) this.b).a.getCategory());
        if (!c(b3)) {
            sb.append("&types=");
            sb.append(b3);
        }
        if (c(((fy) this.b).a.getExtensions())) {
            sb.append("&extensions=base");
        } else {
            sb.append("&extensions=");
            sb.append(((fy) this.b).a.getExtensions());
        }
        sb.append("&key=");
        sb.append(ho.f(this.i));
        if (((fy) this.b).a.getCityLimit()) {
            sb.append("&citylimit=true");
        } else {
            sb.append("&citylimit=false");
        }
        if (((fy) this.b).a.isRequireSubPois()) {
            sb.append("&children=1");
        } else {
            sb.append("&children=0");
        }
        if (this.l) {
            if (((fy) this.b).a.isSpecial()) {
                sb.append("&special=1");
            } else {
                sb.append("&special=0");
            }
        }
        if (((fy) this.b).b == null && ((fy) this.b).a.getLocation() != null) {
            sb.append("&sortrule=");
            sb.append(b(((fy) this.b).a.isDistanceSort()));
            double a7 = fe.a(((fy) this.b).a.getLocation().getLongitude());
            double a8 = fe.a(((fy) this.b).a.getLocation().getLatitude());
            sb.append("&location=");
            sb.append(a7 + "," + a8);
        }
        return sb.toString();
    }

    private static String b(boolean z) {
        return z ? "distance" : "weight";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    /* renamed from: d */
    public PoiResult a(String str) throws AMapException {
        ArrayList<PoiItem> arrayList;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        ArrayList<PoiItem> arrayList2 = new ArrayList<>();
        if (str == null) {
            return PoiResult.createPagedResult(((fy) this.b).a, ((fy) this.b).b, this.m, this.n, ((fy) this.b).a.getPageSize(), this.k, arrayList2);
        }
        try {
            jSONObject = new JSONObject(str);
            this.k = jSONObject.optInt(SpamFilter.SpamContract.NotificationTable.COUNT);
            arrayList = fm.c(jSONObject);
        } catch (JSONException e) {
            fe.a(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
            arrayList = arrayList2;
        } catch (Exception e2) {
            fe.a(e2, "PoiSearchKeywordHandler", "paseJSONException");
            arrayList = arrayList2;
        }
        if (jSONObject.has("suggestion") && (optJSONObject = jSONObject.optJSONObject("suggestion")) != null) {
            this.n = fm.a(optJSONObject);
            this.m = fm.b(optJSONObject);
            return PoiResult.createPagedResult(((fy) this.b).a, ((fy) this.b).b, this.m, this.n, ((fy) this.b).a.getPageSize(), this.k, arrayList);
        }
        return PoiResult.createPagedResult(((fy) this.b).a, ((fy) this.b).b, this.m, this.n, ((fy) this.b).a.getPageSize(), this.k, arrayList);
    }

    private static gc f() {
        gb a = ga.a().a("regeo");
        if (a == null) {
            return null;
        }
        return (gc) a;
    }

    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    protected final String c() {
        return a(true);
    }

    @Override // com.amap.api.col.p0003sl.ew
    protected final ga.b e() {
        ga.b bVar = new ga.b();
        if (this.l) {
            gc f = f();
            double d = 0.0d;
            if (f != null) {
                d = f.a();
            }
            bVar.a = getURL() + a(false) + "language=" + ServiceSettings.getInstance().getLanguage();
            if (((fy) this.b).b.getShape().equals("Bound")) {
                bVar.b = new gc.a(fe.a(((fy) this.b).b.getCenter().getLatitude()), fe.a(((fy) this.b).b.getCenter().getLongitude()), d);
                return bVar;
            }
        } else {
            bVar.a = getURL() + c() + "language=" + ServiceSettings.getInstance().getLanguage();
        }
        return bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00a5, code lost:
        if (((com.amap.api.col.p0003sl.fy) r3.b).b.getShape().equals("Polygon") != false) goto L16;
     */
    @Override // com.amap.api.col.p0003sl.kb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getURL() {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r4
            java.lang.String r1 = com.amap.api.col.p0003sl.fd.a()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r1 = "/place"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r0 = r0.toString()
            r5 = r0
            r0 = r3
            T r0 = r0.b
            com.amap.api.col.3sl.fy r0 = (com.amap.api.col.p0003sl.fy) r0
            com.amap.api.services.poisearch.PoiSearch$SearchBound r0 = r0.b
            if (r0 != 0) goto L45
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r4
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r1 = "/text?"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r0 = r0.toString()
            return r0
        L45:
            r0 = r3
            T r0 = r0.b
            com.amap.api.col.3sl.fy r0 = (com.amap.api.col.p0003sl.fy) r0
            com.amap.api.services.poisearch.PoiSearch$SearchBound r0 = r0.b
            java.lang.String r0 = r0.getShape()
            java.lang.String r1 = "Bound"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r4
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r1 = "/around?"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r0 = r0.toString()
            r4 = r0
            r0 = r3
            r1 = 1
            r0.l = r1
            r0 = r4
            return r0
        L7c:
            r0 = r3
            T r0 = r0.b
            com.amap.api.col.3sl.fy r0 = (com.amap.api.col.p0003sl.fy) r0
            com.amap.api.services.poisearch.PoiSearch$SearchBound r0 = r0.b
            java.lang.String r0 = r0.getShape()
            java.lang.String r1 = "Rectangle"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto La8
            r0 = r5
            r4 = r0
            r0 = r3
            T r0 = r0.b
            com.amap.api.col.3sl.fy r0 = (com.amap.api.col.p0003sl.fy) r0
            com.amap.api.services.poisearch.PoiSearch$SearchBound r0 = r0.b
            java.lang.String r0 = r0.getShape()
            java.lang.String r1 = "Polygon"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lc3
        La8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r4
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r1 = "/polygon?"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r0 = r0.toString()
            r4 = r0
        Lc3:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.fv.getURL():java.lang.String");
    }
}
