package com.amap.api.col.p0003sl;

import android.content.Context;
import android.provider.MediaStore;
import android.provider.SearchIndexablesContract;
import android.text.TextUtils;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.fc  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fc.class */
public final class fc extends fa<CloudSearch.Query, CloudResult> {
    private int k;

    public fc(Context context, CloudSearch.Query query) {
        super(context, query);
        this.k = 0;
    }

    private static String a(Map<String, String> map) {
        return f(b(map));
    }

    private static String b(Map<String, String> map) {
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
            }
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    /* renamed from: c */
    public CloudResult a(String str) throws AMapException {
        ArrayList<CloudItem> arrayList;
        if (str == null || str.equals("")) {
            return CloudResult.createPagedResult((CloudSearch.Query) this.b, this.k, ((CloudSearch.Query) this.b).getBound(), ((CloudSearch.Query) this.b).getPageSize(), null);
        }
        try {
            arrayList = d(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            arrayList = null;
        } catch (Exception e2) {
            e2.printStackTrace();
            arrayList = null;
        }
        return CloudResult.createPagedResult((CloudSearch.Query) this.b, this.k, ((CloudSearch.Query) this.b).getBound(), ((CloudSearch.Query) this.b).getPageSize(), arrayList);
    }

    private static String d(String str) {
        String str2 = str;
        if (str != null) {
            str2 = str.replace("&&", "%26%26");
        }
        return str2;
    }

    private ArrayList<CloudItem> d(JSONObject jSONObject) throws JSONException {
        ArrayList<CloudItem> arrayList = new ArrayList<>();
        JSONArray a2 = a(jSONObject);
        if (a2 == null) {
            return arrayList;
        }
        this.k = b(jSONObject);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2.length()) {
                return arrayList;
            }
            JSONObject optJSONObject = a2.optJSONObject(i2);
            CloudItemDetail c2 = c(optJSONObject);
            a(c2, optJSONObject);
            arrayList.add(c2);
            i = i2 + 1;
        }
    }

    private static String e(String str) {
        String str2 = str;
        if (str != null) {
            str2 = str.replace("%26%26", "&&");
        }
        return str2;
    }

    private String f() {
        return ((CloudSearch.Query) this.b).getSortingrules() != null ? ((CloudSearch.Query) this.b).getSortingrules().toString() : "";
    }

    private static String f(String str) {
        String str2;
        String str3 = str;
        try {
        } catch (Throwable th) {
            it.a(th, "ut", "sPa");
            str2 = str3;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String d = d(str);
        String[] split = d.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            stringBuffer.append(split[i2]);
            stringBuffer.append("&");
            i = i2 + 1;
        }
        String e = e(stringBuffer.toString());
        str2 = d;
        if (e.length() > 1) {
            str3 = d;
            return (String) e.subSequence(0, e.length() - 1);
        }
        return str2;
    }

    private String g() {
        StringBuffer stringBuffer = new StringBuffer();
        String filterString = ((CloudSearch.Query) this.b).getFilterString();
        String filterNumString = ((CloudSearch.Query) this.b).getFilterNumString();
        stringBuffer.append(filterString);
        if (!fe.a(filterString) && !fe.a(filterNumString)) {
            stringBuffer.append("&&");
        }
        stringBuffer.append(filterNumString);
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    protected final String c() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew, com.amap.api.col.p0003sl.kb
    public final Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", ho.f(this.i));
        hashtable.put(MediaStore.EXTRA_OUTPUT, "json");
        if (((CloudSearch.Query) this.b).getBound() != null) {
            if (((CloudSearch.Query) this.b).getBound().getShape().equals("Bound")) {
                double a2 = fe.a(((CloudSearch.Query) this.b).getBound().getCenter().getLongitude());
                double a3 = fe.a(((CloudSearch.Query) this.b).getBound().getCenter().getLatitude());
                hashtable.put("center", a2 + "," + a3);
                StringBuilder sb = new StringBuilder();
                sb.append(((CloudSearch.Query) this.b).getBound().getRange());
                hashtable.put("radius", sb.toString());
            } else if (((CloudSearch.Query) this.b).getBound().getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((CloudSearch.Query) this.b).getBound().getLowerLeft();
                LatLonPoint upperRight = ((CloudSearch.Query) this.b).getBound().getUpperRight();
                double a4 = fe.a(lowerLeft.getLatitude());
                double a5 = fe.a(lowerLeft.getLongitude());
                double a6 = fe.a(upperRight.getLatitude());
                double a7 = fe.a(upperRight.getLongitude());
                hashtable.put("polygon", a5 + "," + a4 + ";" + a7 + "," + a6);
            } else if (((CloudSearch.Query) this.b).getBound().getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = ((CloudSearch.Query) this.b).getBound().getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    hashtable.put("polygon", fe.a(polyGonList, ";"));
                }
            } else if (((CloudSearch.Query) this.b).getBound().getShape().equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
                hashtable.put(DistrictSearchQuery.KEYWORDS_CITY, ((CloudSearch.Query) this.b).getBound().getCity());
            }
        }
        hashtable.put("layerId", ((CloudSearch.Query) this.b).getTableID());
        if (!fe.a(f())) {
            hashtable.put("sortrule", f());
        }
        String g = g();
        if (!fe.a(g)) {
            hashtable.put("filter", g);
        }
        String queryString = ((CloudSearch.Query) this.b).getQueryString();
        if (queryString == null || "".equals(queryString)) {
            hashtable.put(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, "");
        } else {
            hashtable.put(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, queryString);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((CloudSearch.Query) this.b).getPageSize());
        hashtable.put("pageSize", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(((CloudSearch.Query) this.b).getPageNum());
        hashtable.put("pageNum", sb3.toString());
        String a8 = hr.a();
        String a9 = hr.a(this.i, a8, a(hashtable));
        hashtable.put("ts", a8);
        hashtable.put("scode", a9);
        return hashtable;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        String str;
        String str2 = fd.e() + "/datasearch";
        String shape = ((CloudSearch.Query) this.b).getBound().getShape();
        if (shape.equals("Bound")) {
            return str2 + "/around";
        }
        if (shape.equals("Polygon") || shape.equals("Rectangle")) {
            str = str2 + "/polygon";
        } else {
            str = str2;
            if (shape.equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
                return str2 + "/local";
            }
        }
        return str;
    }
}
