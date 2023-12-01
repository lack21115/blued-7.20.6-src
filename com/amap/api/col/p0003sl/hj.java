package com.amap.api.col.p0003sl;

import android.app.backup.FullBackup;
import android.content.Context;
import android.os.Handler;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.hj  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hj.class */
public final class hj extends hh<List<TraceLocation>, List<LatLng>> implements Runnable {
    private List<TraceLocation> j;
    private Handler k;
    private int l;
    private int m;
    private String n;

    public hj(Context context, Handler handler, List<TraceLocation> list, String str, int i, int i2) {
        super(context, list);
        this.k = null;
        this.l = 0;
        this.m = 0;
        this.j = list;
        this.k = handler;
        this.m = i;
        this.l = i2;
        this.n = str;
    }

    private static List<LatLng> a(String str) throws hf {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
            return arrayList;
        }
        if (jSONObject.has("data") && (optJSONArray = jSONObject.optJSONObject("data").optJSONArray("points")) != null && optJSONArray.length() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                arrayList.add(new LatLng(Double.parseDouble(optJSONObject.optString("y")), Double.parseDouble(optJSONObject.optString("x"))));
                i = i2 + 1;
            }
            return arrayList;
        }
        return arrayList;
    }

    @Override // com.amap.api.col.p0003sl.hh, com.amap.api.col.p0003sl.hg
    protected final String c() {
        long j;
        JSONArray jSONArray = new JSONArray();
        long j2 = 0;
        int i = 0;
        while (i < this.j.size()) {
            TraceLocation traceLocation = this.j.get(i);
            JSONObject jSONObject = new JSONObject();
            long j3 = j2;
            try {
                jSONObject.put("x", traceLocation.getLongitude());
                long j4 = j2;
                jSONObject.put("y", traceLocation.getLatitude());
                long j5 = j2;
                jSONObject.put("ag", (int) traceLocation.getBearing());
                long j6 = j2;
                long time = traceLocation.getTime();
                if (i == 0) {
                    long j7 = time;
                    if (time == 0) {
                        j7 = (System.currentTimeMillis() - 10000) / 1000;
                    }
                    long j8 = j2;
                    jSONObject.put("tm", j7 / 1000);
                    j = j7;
                } else {
                    if (time != 0) {
                        long j9 = time - j2;
                        if (j9 >= 1000) {
                            jSONObject.put("tm", j9 / 1000);
                            j = time;
                        }
                    }
                    jSONObject.put("tm", 1);
                    j = time;
                }
                jSONObject.put(FullBackup.SHAREDPREFS_TREE_TOKEN, (int) traceLocation.getSpeed());
                j3 = j;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
            i++;
            j2 = j3;
        }
        this.h = getURL() + "&" + jSONArray.toString();
        return jSONArray.toString();
    }

    @Override // com.amap.api.col.p0003sl.hh, com.amap.api.col.p0003sl.hg
    protected final /* synthetic */ Object d(String str) throws hf {
        return a(str);
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getIPV6URL() {
        return dw.a(getURL());
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        String str = "key=" + ho.f(this.g);
        String a2 = hr.a();
        return "http://restsdk.amap.com/v4/grasproad/driving?" + str + "&ts=".concat(String.valueOf(a2)) + "&scode=".concat(String.valueOf(hr.a(this.g, a2, str)));
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final boolean isSupportIPV6() {
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        new ArrayList();
        try {
            try {
                List<LatLng> d = d();
                hl.a().a(this.n, this.l, d);
                hl.a().a(this.n).a(this.k);
            } catch (hf e) {
                hl.a();
                hl.a(this.k, this.m, e.a());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
