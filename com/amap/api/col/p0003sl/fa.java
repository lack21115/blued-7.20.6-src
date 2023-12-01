package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.fa  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fa.class */
public abstract class fa<T, V> extends ex<T, V> {
    public fa(Context context, T t) {
        super(context, t);
        this.f4949a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static JSONArray a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            return optJSONObject.optJSONArray("list");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(CloudItem cloudItem, JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        HashMap<String, String> hashMap = new HashMap<>();
        if (keys == null) {
            return;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            if (next != null) {
                hashMap.put(next.toString(), jSONObject.optString(next.toString()));
            }
        }
        cloudItem.setCustomfield(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("info")) == null) {
            return 0;
        }
        return optJSONObject.optInt("count");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static CloudItemDetail c(JSONObject jSONObject) throws JSONException {
        CloudItemDetail cloudItemDetail = new CloudItemDetail(fm.a(jSONObject, "id"), new LatLonPoint(jSONObject.optDouble("point_y"), jSONObject.optDouble("point_x")), fm.a(jSONObject, "title"), fm.a(jSONObject, "address"));
        cloudItemDetail.setCreatetime(fm.a(jSONObject, "gmt_create"));
        cloudItemDetail.setUpdatetime(fm.a(jSONObject, "gmt_modified"));
        if (jSONObject.has("_distance")) {
            String optString = jSONObject.optString("_distance");
            if (!c(optString)) {
                cloudItemDetail.setDistance(Integer.parseInt(optString));
            }
        }
        return cloudItemDetail;
    }

    private static boolean c(String str) {
        return str == null || str.equals("") || str.equals("[]");
    }

    @Override // com.amap.api.col.p0003sl.ew
    protected final V a(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            fe.a(e, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        fe.c(str);
        return a(str);
    }

    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.kb
    public byte[] getEntityBytes() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew, com.amap.api.col.p0003sl.kb
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 9.3.1");
        hashMap.put("X-INFO", hr.b(this.i));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "9.3.1", "cloud"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }
}
