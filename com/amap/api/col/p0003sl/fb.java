package com.amap.api.col.p0003sl;

import android.content.Context;
import android.provider.MediaStore;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.fb  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fb.class */
public final class fb extends fa<fx, CloudItemDetail> {
    public fb(Context context, fx fxVar) {
        super(context, fxVar);
    }

    private static CloudItemDetail c(String str) throws AMapException {
        if (str == null || str.equals("")) {
            return null;
        }
        try {
            return d(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static CloudItemDetail d(JSONObject jSONObject) throws JSONException {
        JSONArray a2 = a(jSONObject);
        if (a2 == null || a2.length() <= 0) {
            return null;
        }
        JSONObject jSONObject2 = a2.getJSONObject(0);
        CloudItemDetail c2 = c(jSONObject2);
        a(c2, jSONObject2);
        return c2;
    }

    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    protected final String c() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew, com.amap.api.col.p0003sl.kb
    public final Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", ho.f(this.i));
        hashtable.put("layerId", ((fx) this.b).f4975a);
        hashtable.put(MediaStore.EXTRA_OUTPUT, "json");
        hashtable.put("id", ((fx) this.b).b);
        String a2 = hr.a();
        String a3 = hr.a(this.i, a2, ib.b(hashtable));
        hashtable.put("ts", a2);
        hashtable.put("scode", a3);
        return hashtable;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        return fd.e() + "/datasearch/id";
    }
}
